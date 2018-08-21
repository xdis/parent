package com.zyxy.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.ArbitratorAdministerService;
import com.zyxy.common.dto.ArbitratorEnquiriesDTO;
import com.zyxy.common.dto.ArbitratorInfoUpdateDTO;
import com.zyxy.common.enums.ArbitratorApplyInfoUpdateEnum;
import com.zyxy.common.enums.OpinionStateEnum;
import com.zyxy.common.mapper.ArbitratorChangeProfileRecordMapper;
import com.zyxy.common.mapper.ArbitratorInfoMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitratorInfoAduitVO;
import com.zyxy.common.vo.ArbitratorInformationVO;
/**
 * 仲裁员列表ServiceImpl
 *
 */
@Service
public class ArbitratorAdministerServiceImpl implements ArbitratorAdministerService{
	
	@Autowired
	private ArbitratorInfoMapper arbitratorInfoMapper;
	
	@Autowired
	private MicroFileService microFileService;
	
	@Autowired
	private ArbitratorChangeProfileRecordMapper arbitratorChangeProfileRecordMapper;
	
	/**
	 * 获取仲裁员列表
	 * @param formData 仲裁员信息DTO
	 * @return
	 */
	@Override
	public BusiExecuteResult<PageInfo<ArbitratorInformationVO>> arbitratorTableBusiExecute(
			ArbitratorEnquiriesDTO formData) {
		
		PageInfo<ArbitratorInformationVO> caseListVOPageInfo = this.queryArbiCaseList(formData);
		
		return BusiExecuteResult.builderSuccessResult(caseListVOPageInfo);
		
	}
	
	/**
	 * 获取仲裁员基本信息
	 * @param id 仲裁员Id
	 * @return
	 */
	@Override
	public ArbitratorInformationVO arbitratorInfoBusiExecute(String id) {
		ArbitratorEnquiriesDTO formData = new ArbitratorEnquiriesDTO();
		formData.setId(id);
		List<ArbitratorInformationVO> arbitratorInfo = arbitratorInfoMapper.queryArbitratorInLists(formData);
		if(arbitratorInfo==null){
			return null;
		}
		//获取图片地址添加到对象中
		if(arbitratorInfo.get(0).getHeadPhoto()!=null){
			arbitratorInfo.get(0).setHeadPhoto(microFileService.getFileInfoById(arbitratorInfo.get(0).getHeadPhoto()).getBody().getSysPath());
		}

		return arbitratorInfo.get(0);

	}
	
	/**
	  * 禁用仲裁员
	 * @param id 仲裁员Id
	 * @return 成功失败
	 */
	@Override
	public BusiExecuteResult arbitratorDisableBusiExecute(String id) {
		int update = arbitratorInfoMapper.updateArbitratorDisable(id);
		
		if (update <= 0) {
			return BusiExecuteResult
					.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
		}

		return BusiExecuteResult.builderSuccessResult();
	}
	
	/**
	  * 信息审核对象
	 * @param id 仲裁员Id
	 * @return 
	 */
	@Override
	public ArbitratorInfoAduitVO arbitratorInfoAduitBusiExecute(String id) {
		ArbitratorInfoAduitVO ArbitratorAudit = arbitratorInfoMapper.queryArbitratorAudit(id);
		return ArbitratorAudit;
	}
	
	/**
	 *仲裁员信息更新或驳回
	 */
	@Override
	public BusiExecuteResult updateArbitratorInfoBusiExecute(
			ArbitratorInfoUpdateDTO formData) {
		boolean updateArbitratorInfo = this.updateArbitratorInfo(formData);
		if(!updateArbitratorInfo){
			return BusiExecuteResult
					.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
		}
		return BusiExecuteResult.builderSuccessResult();
	}
	
	/**
	 *将仲裁员删除或移出黑名单
	 */
	@Override
	public BusiExecuteResult deleteOrReinstateNormalBusiExecute(
			ArbitratorInfoUpdateDTO formData) {
		int updateStatus = arbitratorInfoMapper.updateStatus(formData);
		
		if(updateStatus<=0){
			return BusiExecuteResult
					.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
		}
		return BusiExecuteResult.builderSuccessResult();
	}
	
	
	
	//#####################私有方法###############################
	
	/**
	 * 查询仲裁员列表
	 * 
	 * @param formData 仲裁员信息DTO
	 * @return
	 */
	private PageInfo<ArbitratorInformationVO> queryArbiCaseList(ArbitratorEnquiriesDTO formData) {
		
		if (formData.getPageNum() == null || formData.getPageNum() < 1) {
			formData.setPageNum(1);
		}
		if (formData.getPageSize() == null || formData.getPageSize() < 1
				|| formData.getPageSize() > 1000) {
			formData.setPageSize(10);
		}
		PageHelper.startPage(formData.getPageNum(), formData.getPageSize());
		// 查询出仲裁员列表
		List<ArbitratorInformationVO> arbitratorInforList = arbitratorInfoMapper
				.queryArbitratorInLists(formData);

		return new PageInfo<ArbitratorInformationVO>(arbitratorInforList);

	}
	
	
	private boolean updateArbitratorInfo(ArbitratorInfoUpdateDTO formData){
		if(OpinionStateEnum.GET_THROUGH.getValue().equals(formData.getStatus())){//通过 
			//添加修改时间
			Date date=new Date();  
			SimpleDateFormat updateDate=new SimpleDateFormat("yyyyHHdd");
		    SimpleDateFormat updateTime=new SimpleDateFormat("HHmmss");  
		    formData.setUpdateDate(updateDate.format(date));
		    formData.setUpdateTime(updateTime.format(date));
			//将信息更新到仲裁员表
			int updateArbitratorInfo = arbitratorInfoMapper.updateArbitratorInfo(formData);
			
			//仲裁员修改信息表修改为通过
			int updateStatus = arbitratorChangeProfileRecordMapper.updateStatus( ArbitratorApplyInfoUpdateEnum.AUDIT_APPROVAL.getCode() , formData.getNewId());
			
			if(updateArbitratorInfo<=0||updateStatus<=0){
				return false;
			}
			
		}else if(OpinionStateEnum.REJECTED.getValue().equals(formData.getStatus())){//驳回 
			//仲裁员修改信息表修改为未通过
			int updateStatus = arbitratorChangeProfileRecordMapper.updateStatus( ArbitratorApplyInfoUpdateEnum.NOT_ACCEPT.getCode() , formData.getNewId());
			
			if(updateStatus<=0){
				return false;
			}
		}
		
		return true;
	}



	
	
}
