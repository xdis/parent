package com.zyxy.service.micro.core.controller;

import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.service.micro.MicroThirdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.rtf.style.RtfFont;
import com.zyxy.common.domain.CaseDoc;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CaseDocVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.CaseDocService;

/**
 * 案件文书控制层
 */
@Api(description="案件文书模块")
@RestController
@RequestMapping("/arbitrator/case")
public class CaseDocController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(CaseDocController.class);
    @Autowired
    private CaseDocService caseDocService;





    @ApiOperation(value="预览裁决书")
    @RequestMapping(value="/{caseId}/previewArbitramentDoc")
    public ApiResultVO<CaseDocVO> get(@PathVariable String caseId, String userId){

        /*
         * 参数验证
         */
        if (StringUtils.isBlank(caseId)) {
            return super.validError();
        }

        /*
         *   业务处理
         */
        BusiExecuteResult<CaseDocVO> busiExecuteResult = caseDocService.queryCaseDocBusiExecute(caseId, userId);

        return super.busiExecuteSuccess(busiExecuteResult.getBody());

    }


    /**
     * 生成裁决书
     * @param caseId
     * @param docType
     * @param request
     * @return
     */
    @ApiOperation(value="生成裁决书")
    @GetMapping(value="/{caseId}/{docType}/generationRulingDoc")
    public ApiResultVO<CaseDoc> generationRulingDoc(@PathVariable String caseId, String userId){

        // 该日志必不可少
        String busiDesr = "仲裁员-生成裁决书";
        logger.info("用户[{}]开始业务[{}]-参数:{}", "~public", busiDesr, caseId+","+userId);

        /* 
         * 参数验证
         */
        if (StringUtils.isBlank(caseId)) {
            return super.validError();
        }

        /*
         *   业务处理
         */
        //查询文书信息
        BusiExecuteResult<String> busiExecuteResult = caseDocService.generationapplicationArbitrationDoc(caseId, userId);

//        generateDoc();
        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);

//        return super.busiExecuteSuccess(busiExecuteResult.getBody());
        return null;
    }

    @Autowired
    MicroThirdService microThirdService;

    @GetMapping(value = "/{caseId}/fileLink")
    public ApiResultVO<String> fileLink(@PathVariable String caseId) {
        return microThirdService.fileLink(caseId);
    }


	private void generateDoc() {
		try {
			OutputStream out = new FileOutputStream("e:/temp.pdf");
			// 创建word文档,并设置纸张的大小 边距
			Document document = new Document(PageSize.A4,72,72,80,70);
			PdfWriter.getInstance(document, out);
			document.open();
			//公共资源 字体 
//			BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED); 
			BaseFont bfSt = BaseFont.createFont(getChineseFont("simsun.ttc")+",1",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);  
			BaseFont bfFs = BaseFont.createFont(getChineseFont("simfang.ttf"),BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			Font fsFont = new Font(bfFs, 16, Font.NORMAL);	//正文字体
			Chunk br = new Chunk("\n");	//换行
			//中文日期
			
			//标题
			Font titleFont = new Font(bfSt, 22, Font.BOLD);
	        Paragraph titlePh = new Paragraph("珠 海 仲 裁 委 员 会",titleFont);    
	        titlePh.setAlignment(1);   
	        document.add(titlePh);
	        
	        //副标题
	        Font viceTitleFont = new Font(bfSt,26, Font.BOLD);    
	        Paragraph viceTitlePh = new Paragraph("裁 决 书",viceTitleFont);    
	        viceTitlePh.setAlignment(1);   
	        document.add(viceTitlePh);
	        
			//文书编号
	        Paragraph docNumPh = new Paragraph("珠仲裁字（xxx）第xxx号",fsFont);    
	        docNumPh.setAlignment(Element.ALIGN_RIGHT);   
	        document.add(docNumPh);
	        
	        //申请人
	        Paragraph proposerPh = new Paragraph("申请人（反请求被申请人）：姓名，性别，民族，xx年xx月xx日出生，身份证号码：xxx（如是单位则写明单位名称）",fsFont);    
	        proposerPh.setFirstLineIndent(32);
	        proposerPh.setAlignment(Element.ALIGN_LEFT);   
	        document.add(proposerPh);
	        //申请人（反请求被申请人）：姓名，性别，民族，xx年xx月xx日出生，身份证号码：xxx（如是单位则写明单位名称）
			
	        //申请人是个人
	        //住所
	        /*Paragraph propAddPh = new Paragraph("住所：xxx",fsFont);
	        propAddPh.setFirstLineIndent(32);
	        propAddPh.setAlignment(Element.ALIGN_LEFT);   
	        document.add(propAddPh);
	        
	        //法定代表人
	        Paragraph propAddPh = new Paragraph("住所：xxx",fsFont);
	        propAddPh.setFirstLineIndent(32);
	        propAddPh.setAlignment(Element.ALIGN_LEFT);   
	        document.add(propAddPh);*/
	        
	        //被申请人
	        Paragraph depePh = new Paragraph("被申请人（反请求申请人）：姓名，性别，民族，xx年xx月xx日出生，身份证号码：xxx（如是单位则写明单位名称）",fsFont);    
	        depePh.setFirstLineIndent(32);
	        depePh.setAlignment(Element.ALIGN_LEFT);   
	        document.add(depePh);
	        
	        //代理人propAgentName
	        Paragraph propAgentPh = new Paragraph("委托代理人：姓名，性别，民族，xx年xx月xx日出生，身份证号码：xxx（如是律师代理，应写明：姓名，XX律师事务所律师；如是公民代理，应写明代理人身份信息）",fsFont);    
	        propAgentPh.setFirstLineIndent(32);
	        propAgentPh.setAlignment(Element.ALIGN_LEFT);   
	        document.add(propAgentPh);
	        
	        //正文处理
	        
	        document.add(br);
	        document.add(br);
	        document.add(br);
	        //仲裁员
	        Paragraph arbiPh = new Paragraph("仲  裁  员：xxx",fsFont);    
	        arbiPh.setFirstLineIndent(256);
	        arbiPh.setAlignment(Element.ALIGN_LEFT);   
	        document.add(arbiPh);
	        
	        //日期
	        document.add(br);
	        Paragraph upperDatePh = new Paragraph(getUpperDate("2017-11-01"),fsFont);    
	        upperDatePh.setFirstLineIndent(256);
	        upperDatePh.setAlignment(Element.ALIGN_LEFT);   
	        document.add(upperDatePh);
	        
	        document.close();
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		new CaseDocController().generateDoc();
//	}

    /**
	 * 查找系统字体
	 * @param font
	 * @return
	 */
	private String getChineseFont(String font){  
		  
		  
        //宋体（对应css中的 属性 font-family: SimSun; /*宋体*/）  
        String font1 ="C:/Windows/Fonts/"+font;  
  
  
        //判断系统类型，加载字体文件  
        java.util.Properties prop = System.getProperties();  
        String osName = prop.getProperty("os.name").toLowerCase();  
        if (osName.indexOf("linux")>-1) {  
            font1="/usr/share/fonts/"+font;  
        }  
        if(!new File(font1).exists()){  
            throw new RuntimeException("字体文件不存在,影响导出pdf中文显示！"+font1);  
        }  
        return font1;  
    }
	/**
     * 根据小写数字格式的日期转换成大写格式的日期
     * @param date
     * @return
     */
    private static String getUpperDate(String date) {
    	char[] upper = "〇一二三四五六七八九十".toCharArray();
        if(date == null) return null;
        //非数字的都去掉
        date = date.replaceAll("\\D", "");
        if(date.length() != 8) return null;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<4;i++) {//年
            sb.append(upper[Integer.parseInt(date.substring(i, i+1))]);
        }
        sb.append("年");//拼接年
        int month = Integer.parseInt(date.substring(4, 6));
        if(month <= 10) {
            sb.append(upper[month]);
        } else {
            sb.append("十").append(upper[month%10]);
        }
        sb.append("月");//拼接月

        int day = Integer.parseInt(date.substring(6));
        if (day <= 10) {
            sb.append(upper[day]);
        } else if(day < 20) {
            sb.append("十").append(upper[day % 10]);
        } else {
            sb.append(upper[day / 10]).append("十");
            int tmp = day % 10;
            if (tmp != 0) sb.append(upper[tmp]);
        }
        sb.append("日");//拼接日
        return sb.toString();
    }
}
