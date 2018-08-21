package com.zyxy.service.micro.file.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zyxy.common.domain.SysFile;
import com.zyxy.common.enums.SysEnum;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.util.ArrayUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.common.web.util.RequestUtil;
import com.zyxy.service.micro.file.service.SysFileService;

/**
 * 文件服务模块
 *
 * @author tanquan
 */
@Api(description="文件服务模块")
@RequestMapping("/file")
@RestController
public class SysFileController extends BaseController{

	private final static Logger logger = LoggerFactory.getLogger(SysFileController.class);


	@Autowired
	private SequenceService sequenceService;
    
	@Autowired
	private SysFileService sysFileService;
	
	@Value("${system.userFilePath}")
	private String userFileSysPath;
	
	/**
     * 文件上传
     *
     * @param userId
     * @param buzzType
     * @param uploadFile
     * @return
     */
    @ApiOperation(value = "文件上传")
    @RequestMapping(value = "/uploads", method = {RequestMethod.POST, RequestMethod.GET})
    public ApiResultVO<String> uploadFiles(
    		HttpServletRequest request,
            @ApiParam(value = "用户编号(非必填)") @RequestParam(required = false) String userId,
            @ApiParam(value = "业务类型编码 请通过公共接口'/getFileUploadBusiType'获取") @RequestParam(value = "buzzType", required = true) String buzzType,
            @ApiParam(value = "文件") @RequestParam(required = true) MultipartFile uploadFile
    ) {
		// 该日志必不可少
		String busiDesr = "文件上传";
        logger.info("开始业务[{}]-参数:{}", busiDesr, RequestUtil.getParamMap(request));
    	
        if (userId == null) {
            userId = "common";
        }
        logger.info("用户[{}]上传文件：{}", userId, uploadFile.getOriginalFilename());
        SysEnum.FileBuzzType type = SysEnum.FileBuzzType.getTypeByCode(buzzType);
        if (type == null) {
            logger.error("业务代码不存在");
            return super.validError();
        }
        String fileName = uploadFile.getOriginalFilename();
        String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        // 文件格式校验
        if (!ArrayUtil.contains(type.getAllowExts(), fileExt)) {
            logger.warn("{}", "格式非法");
            return super.validError();
        }
        // 文件大小校验
        if (uploadFile.getSize() > type.getAllowSize()) {
            logger.warn("{}", "大小非法");
            return super.validError();
        }
        String fileId = UUID.randomUUID().toString().replace("-", "");
        // 文件保存相对路径->存库
        String relativePathName = userId + File.separator + type.getCode() + File.separator + fileExt + File.separator + fileId + "." + fileExt;
        if (!userFileSysPath.endsWith("/") && !userFileSysPath.endsWith("\\")) {
            userFileSysPath += File.separator;
        }
        // 文件保存绝对路径
        String toSavePathName = userFileSysPath + relativePathName;
        logger.debug("保存绝对路径：{}", toSavePathName);
        File saveFile = new File(toSavePathName);
        if (!saveFile.getParentFile().exists()) {
            saveFile.getParentFile().mkdirs();
        }
        try {
            uploadFile.transferTo(saveFile);
        } catch (IllegalStateException | IOException e) {
        	return super.error(ApiResultVO.Coder.REQ_ERROR.setMessage(e.getMessage()));
        }

        // 文件数据入库
        SysFile dbFile = new SysFile();
        dbFile.setId(fileId); // 文件编号
        dbFile.setFileOrignName(fileName); // 文件名
        dbFile.setFileExt(fileExt); // 文件后缀
        dbFile.setFileSize(uploadFile.getSize()); // 文件大小
        dbFile.setSysPath(relativePathName); // 系统保存路径
        dbFile.setCreateId(userId); // 上传者 // TODO 暂时不验证是否存在
        dbFile.setBuzzType(type.getCode()); // 业务类型
        dbFile.setCreateTime(new Date());
        int it = sysFileService.insertSelective(dbFile);
        if (it != 1) {
            return super.error(ApiResultVO.Coder.DB_INSERT_ERROR);
        }
        ApiResultVO<String> ret = super.ok(fileId);
        return ret;
    }
    
    /**
     * 文件下载
     * 循环输出文件流，防止内存溢出
     * @param id 文件ID
     * @return
     * @throws IOException 
     */
    @ApiOperation(value = "文件下载")
    @RequestMapping(value = "/downloads", method = {RequestMethod.GET})
    public void downloads(
            @ApiParam(value = "文件编号") @RequestParam(required = true) String id,
            HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        SysFile dbFile = sysFileService.selectByPrimaryKey(id);
        response.setCharacterEncoding("utf-8");
        if (dbFile == null) {
            response.setContentType("text/html");
            response.setStatus(HttpStatus.OK.value());
            response.getWriter().print("文件不存在");
            return;
        }
        File file = new File(userFileSysPath + dbFile.getSysPath());
        if (!file.exists()) {
            logger.error("db file not exist - {}", dbFile.getId());
            response.setContentType("text/html");
            response.setStatus(HttpStatus.OK.value());
            response.getWriter().print("文件不存在");
            return;
        }

        // 设置响应头和客户端保存文件名
        String dfileName = "";
        try {
            dfileName = new String(dbFile.getFileOrignName().getBytes("UTF-8"),"iso8859-1");
        } catch (UnsupportedEncodingException e) {
            logger.error("获取文件名失败", e);
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + dfileName);
        try {
            //打开本地文件流
            InputStream inputStream = new FileInputStream(file);
            //激活下载操作
            OutputStream os = response.getOutputStream();

            //循环写入输出流
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }

            // 这里主要关闭。
            os.close();
            inputStream.close();
        } catch (Exception e){
            logger.error("文件下载-读取源文件失败", e);
        }
    }
	
    /**
     * 文件信息查看
     * @param id 文件ID
     * @return
     */
    @ApiOperation(value = "文件-查看摘要信息")
    @RequestMapping(value = "/getFileInfoById", method = {RequestMethod.GET, RequestMethod.POST})
    public ApiResultVO<SysFile> getFileInfoById(
            HttpServletRequest request
            ,@ApiParam(value = "文件编号") @RequestParam(required = true) String id
            ) {
        // 该日志必不可少
        String busiDesr = "当事人-获取案件列表";
        logger.info("开始业务[{}]-参数:{}", busiDesr, RequestUtil.getParamMap(request));

        SysFile dbFile = sysFileService.selectByPrimaryKey(id);
        if (dbFile == null) {
            return error(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
        }
        
        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ok(dbFile);
    }

}
