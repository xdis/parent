package com.zyxy.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.admin.service.DataStatisticsService;
import com.zyxy.common.domain.DataStatistics;
import com.zyxy.common.domain.ManagerInfo;
import com.zyxy.common.dto.DataStatisticsDTO;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.enums.ManagerInfoStatusEnum;
import com.zyxy.common.mapper.ManagerInfoMapper;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.DataStatisticsVO;

/**
 * 数据统计serviceImpl
 */
@Service
public class DataStatisticsServiceImpl implements DataStatisticsService {

    @Autowired
    ManagerInfoMapper managerInfoMapper;
    /**
     * 业务验证
     * @param userId
     * @return
     */
    @Override
    public BusiValidResult queryDataStatisticsBusiValid(String userId) {
        //根据user_info表中的数据查询出仲裁委的信息
        ManagerInfo managerInfo = managerInfoMapper.queryDutiesAndStatusByPrimaryKey(userId);
        
        if(managerInfo!=null){
            if(ManagerInfoStatusEnum.NORMAL.getCode().equals(managerInfo.getStatus())){
                return BusiValidResult.builderSuccessResult();
            }else {
            	return BusiValidResult.builderErrorResult(ApiResultVO.Coder.ACCOUNT_ERROR);
			}
        }
        
        return BusiValidResult.builderSuccessResult();
		
    }

    /**
     * 业务处理
     * @param formData
     * @return
     */
    @Override
    public DataStatisticsVO queryDataStatisticsBusiBusiExecute(DataStatisticsDTO formData) {
        //根据user_info表中的数据查询出仲裁委的信息
        ManagerInfo managerInfo = managerInfoMapper.queryDutiesAndStatusByPrimaryKey(formData.getUserId());

        //创建返回对象
        DataStatisticsVO dataStatisticsVO=new DataStatisticsVO();
        
        Date date = new Date();
        
        //当月所有
        if(formData.getSameMonth() == null){
            SimpleDateFormat monthSdf=new SimpleDateFormat("yyyy-MM");
            formData.setSameMonth(monthSdf.format(date));
        }
        dataStatisticsVO.setSameMonth(formData.getSameMonth());
        DataStatistics monthDataStatistics = this.queryDataStatistics(formData);
        
        //查询当月立案
        formData.setRegistered(ApproveTypeEnum.INITIATE_APPROVAL.getTypeName());
        DataStatistics monthRegistered = this.queryDataStatistics(formData);
        
        //查询当月裁决
        formData.setRegistered(null);
        formData.setNumber(ApproveTypeEnum.ARBITRAL_AWARD_APPROVAL.getTypeName());
        DataStatistics monthNumber = this.queryDataStatistics(formData);
        
        //查询当月反请求审批
        formData.setNumber(null);
        formData.setCounterclaim(ApproveTypeEnum.COUNTERCLAIM_APPROVAL.getTypeName());
        DataStatistics monthCounterclaim = this.queryDataStatistics(formData);
        
        //查询当月仲裁请求变更
        formData.setCounterclaim(null);
        formData.setChange(ApproveTypeEnum.ALTERATION_ARBITRATION_REQUEST.getTypeName());
        DataStatistics monthChange = this.queryDataStatistics(formData);
        
        //查询当月秘书回避请求
        formData.setChange(null);
        formData.setAvoid(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName());
        DataStatistics monthAvoid = this.queryDataStatistics(formData);
        
        //查询当天所有
        formData.setSameMonth(null);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        formData.setToDay(sdf.format(date));
        DataStatistics todayDataStatistics = this.queryDataStatistics(formData);
        
        //查询当天所有已撤案
        formData.setIsCancel(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName());
        formData.setAntiCancel(ApproveTypeEnum.COUNTER_CLAIM_CASE_APPROVE.getTypeName());
        DataStatistics todayCancel = this.queryDataStatistics(formData);
        
        //查询当天所有已调解
        formData.setIsCancel(null);
        formData.setAntiCancel(null);
        formData.setConciliation(ApproveTypeEnum.CONCILIATION_APPLY_APPROVAL.getTypeName());
        DataStatistics todayConciliation = this.queryDataStatistics(formData);
        
        //总统计
        formData.setToDay(null);
        DataStatistics totalDataStatistics = this.queryDataStatistics(formData);
        
        //查询已立案的总统计
        formData.setRegistered(ApproveTypeEnum.INITIATE_APPROVAL.getTypeName());
        DataStatistics totalRegistered = this.queryDataStatistics(formData);
        
        //查询已裁决的总统计
        formData.setRegistered(null);
        formData.setNumber(ApproveTypeEnum.ARBITRAL_AWARD_APPROVAL.getTypeName());
        DataStatistics totalNumber = this.queryDataStatistics(formData);

        //将当天数据和月份数据设置进去
        dataStatisticsVO.setTotalDataStatistics(totalDataStatistics);
        dataStatisticsVO.setTotalRegistered(totalRegistered);
        dataStatisticsVO.setTotalNumber(totalNumber);;
        dataStatisticsVO.setTodayDataStatistics(todayDataStatistics);
        dataStatisticsVO.setTodayCancel(todayCancel);
        dataStatisticsVO.setTodayConciliation(todayConciliation);
        dataStatisticsVO.setMonthDataStatistics(monthDataStatistics);
        dataStatisticsVO.setMonthRegistered(monthRegistered);
        dataStatisticsVO.setMonthNumber(monthNumber);
        dataStatisticsVO.setMonthCounterclaim(monthCounterclaim);
        dataStatisticsVO.setMonthChange(monthChange);
        dataStatisticsVO.setMonthAvoid(monthAvoid);
        dataStatisticsVO.setDuties(managerInfo.getDuties());
        return dataStatisticsVO;
    }


    /*******私有service******/
    /**
     * 数据统计
     * @param formData
     * @return
     */
    @Override
    public DataStatistics queryDataStatistics(DataStatisticsDTO formData) {
        return managerInfoMapper.queryDataStatistics(formData);
    }
    
}
