package com.zyxy.service.micro.core.service.impl;


import com.zyxy.common.domain.*;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.MenuVO;
import com.zyxy.service.micro.core.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private CaseInfoMapper caseInfoMapper;
    @Autowired
    private CaseRequestInfoMapper caseRequestInfoMapper;
    @Autowired
    private CaseApproveMapper caseApproveMapper;
    @Autowired
    private CaseReplyTimeRecordMapper caseReplyTimeRecordMapper;
    @Autowired
    private CompromiseApplyMapper compromiseApplyMapper;
    @Autowired
    private CaseProposerMapper caseProposerMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private CaseDefendantMapper caseDefendantMapper;
    @Autowired
    private CaseAgentMapper caseAgentMapper;
    @Autowired
    private AgentAuthorityRefMapper agentAuthorityRefMapper;



    @Override
    public BusiExecuteResult<List<MenuVO>> queryMenu(String caseId, String userId) {


        //根据useId查询在此案件的角色
        LitigantTypeEnum litigantTypeEnum=queryCaseRoleByUserId(caseId,userId);
        if(litigantTypeEnum==null){

            return null;
        }



        List<MenuVO> menuVOS=new ArrayList<MenuVO>();

        //查询案件基本信息

        CaseInfo caseInfo=new CaseInfo();
        caseInfo.setId(caseId);
        caseInfo=caseInfoMapper.selectCaseInfoByCaseId(caseInfo);

        //查询反请求信息
        CaseRequestInfo caseRequestInfo=new CaseRequestInfo();
        caseRequestInfo.setCaseId(caseId);
        caseRequestInfo.setRequestType(RequestTypeEnum.BACK_REQUEST.getValue());
        caseRequestInfo=caseRequestInfoMapper.selectRequestByParam(caseRequestInfo);


        //查询本请求信息
        CaseRequestInfo requestInfo=new CaseRequestInfo();
        requestInfo.setCaseId(caseId);
        requestInfo.setRequestType(RequestTypeEnum.REQUEST.getValue());
        requestInfo=caseRequestInfoMapper.selectRequestByParam(requestInfo);

        //查询案件待审批信息
        CaseApprove caseApproveParams=new CaseApprove();
        caseApproveParams.setCaseId(caseId);
        caseApproveParams.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
        List<CaseApprove> caseApproves=caseApproveMapper.selectApproveInfoByCaseId(caseApproveParams);

        //判断案件是否在和解期 和解期只能有申请撤案操作
        CompromiseApply compromiseApply=new CompromiseApply();
        compromiseApply.setCaseId(caseId);
        compromiseApply=compromiseApplyMapper.selectCompromiseByCaseId(compromiseApply);






        //ps:管辖权异议只能申请一次，如未通过 则不可再次申请
        //延期答辩可申请一次，自动延长答辩时间
        //回避申请截止日期审限期到期前3日
        switch (litigantTypeEnum){




            //申请人
            case PROPESER:


                //和解期
                if(compromiseApply!=null&&compromiseApply.getStatus()!=null&&ComproiseApplyStatusEnum.DOING.getValue().equals(compromiseApply.getStatus())){

                        MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                        menuVOS.add(menuVO3);

                        for (CaseApprove caseApprove:caseApproves){
                            String approveType=caseApprove.getApproveType();

                            if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                menuVOS.remove(menuVO3);
                            }

                        }




                }

                else{

                    CaseAgent caseAgent=new CaseAgent();
                    caseAgent.setCaseId(caseId);
                    caseAgent.setLitigantType(LitigantTypeEnum.PROPESER.getValue());
                    caseAgent=caseAgentMapper.selectAgentByCaseId(caseAgent);



                        //判断是否在答辩期
                        if(caseInfo.getCurrentMainNode().equals(CaseMainNodeEnum.CASE_REPLY.getCode())){

                            //
                            //无反请求
                            if(caseRequestInfo==null||caseRequestInfo.getId()==null){

                                //本请求无撤案
                                if("0".equals(requestInfo.getStatus())){
                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    MenuVO menuVO2=new MenuVO(MenuEnum.CHANGE_OF_ARBITRATION_REQUEST.getCode(),MenuEnum.CHANGE_OF_ARBITRATION_REQUEST.getRemark());
                                    menuVOS.add(menuVO2);
                                    MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                    menuVOS.add(menuVO3);

                                    if(caseApproves!=null){


                                        for (CaseApprove caseApprove:caseApproves){
                                            String approveType=caseApprove.getApproveType();

                                            //无代理人 无反请求 未撤案 本请求答辩期未过期 申请人可操作的有：申请撤案、申请秘书回避、变更仲裁请求
                                            if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                                //申请秘书回避
                                                menuVOS.remove(menuVO1);
                                            }
                                            if(approveType.equals(ApproveTypeEnum.ALTERATION_ARBITRATION_REQUEST.getTypeName())){

                                                menuVOS.remove(menuVO2);

                                            }
                                            if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                                menuVOS.remove(menuVO3);
                                            }



                                        }

                                    }





                                }
                                //本请求已撤案
                           /*     else{

                            }*/

                                //有反请求
                            }else{


                                //有反请求 本请求、反请求都无撤案 无代理人： 申请秘书回避 申请撤案 变更仲裁请求 反请求管辖权异议 申请延期举证
                                if("0".equals(requestInfo.getStatus())&&"0".equals(caseRequestInfo.getStatus())){

                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    MenuVO menuVO2=new MenuVO(MenuEnum.CHANGE_OF_ARBITRATION_REQUEST.getCode(),MenuEnum.CHANGE_OF_ARBITRATION_REQUEST.getRemark());
                                    menuVOS.add(menuVO2);
                                    MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                    menuVOS.add(menuVO3);
                                    MenuVO menuVO4=new MenuVO(MenuEnum.OBJECTION_JURISDICTION_THE_COUNTERCLAIM.getCode(),MenuEnum.OBJECTION_JURISDICTION_THE_COUNTERCLAIM.getRemark());
                                    menuVOS.add(menuVO4);

                                    //判断是否延期申请过
                                    CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
                                    caseReplyTimeRecord.setBusiId(caseRequestInfo.getId());

                                    caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);

                                    //没有延期
                                    if(caseReplyTimeRecord!=null&&caseReplyTimeRecord.getDelayFlag().equals("1")){
                                        MenuVO menuVO=new MenuVO(MenuEnum.APPLY_FOR_EXTENSION_PROOF.getCode(),MenuEnum.APPLY_FOR_EXTENSION_PROOF.getRemark());
                                        menuVOS.add(menuVO);

                                    }

                                    for (CaseApprove caseApprove:caseApproves){
                                        String approveType=caseApprove.getApproveType();

                                        //申请秘书回避
                                        if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                            menuVOS.remove(menuVO1);
                                        }
                                        //变更仲裁请求
                                        if(approveType.equals(ApproveTypeEnum.ALTERATION_ARBITRATION_REQUEST.getTypeName())){

                                            menuVOS.remove(menuVO2);

                                        }
                                        //申请撤案
                                        if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                            menuVOS.remove(menuVO3);
                                        }

                                        //反请求管辖权异议
                                        if(approveType.equals(ApproveTypeEnum.COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName())){
                                            menuVOS.remove(menuVO4);
                                        }



                                    }


                                }

                                //有反请求 本请求已撤案 反请求存在 无代理：申请秘书回避  反请求管辖权异议 申请延期举证
                                if("1".equals(requestInfo.getStatus())&&"0".equals(caseRequestInfo.getStatus())){

                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    MenuVO menuVO2=new MenuVO(MenuEnum.OBJECTION_JURISDICTION_THE_COUNTERCLAIM.getCode(),MenuEnum.OBJECTION_JURISDICTION_THE_COUNTERCLAIM.getRemark());
                                    menuVOS.add(menuVO2);

                                    //判断是否延期申请过
                                    CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
                                    caseReplyTimeRecord.setBusiId(caseRequestInfo.getId());

                                    caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);

                                    //没有延期
                                    if(caseReplyTimeRecord.getDelayFlag().equals("1")){
                                        MenuVO menuVO=new MenuVO(MenuEnum.APPLY_FOR_EXTENSION_PROOF.getCode(),MenuEnum.APPLY_FOR_EXTENSION_PROOF.getRemark());
                                        menuVOS.add(menuVO);

                                    }



                                    for (CaseApprove caseApprove:caseApproves){
                                        String approveType=caseApprove.getApproveType();

                                        //申请秘书回避
                                        if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                            menuVOS.remove(menuVO1);
                                        }


                                        //反请求管辖权异议
                                        if(approveType.equals(ApproveTypeEnum.COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName())){
                                            menuVOS.remove(menuVO2);
                                        }





                                    }





                                }


                                //有反请求 本请求未撤案 反请求已撤案 无代理：申请秘书回避  申请撤案 变更仲裁请求

                                if(requestInfo.getStatus().equals("0")&&caseRequestInfo.getStatus().equals("1")){

                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    MenuVO menuVO2=new MenuVO(MenuEnum.CHANGE_OF_ARBITRATION_REQUEST.getCode(),MenuEnum.CHANGE_OF_ARBITRATION_REQUEST.getRemark());
                                    menuVOS.add(menuVO2);
                                    MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                    menuVOS.add(menuVO3);

                                    for (CaseApprove caseApprove:caseApproves){
                                        String approveType=caseApprove.getApproveType();

                                        //申请秘书回避
                                        if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                            menuVOS.remove(menuVO1);
                                        }
                                        //变更仲裁请求
                                        if(approveType.equals(ApproveTypeEnum.ALTERATION_ARBITRATION_REQUEST.getTypeName())){

                                            menuVOS.remove(menuVO2);

                                        }
                                        //申请撤案
                                        if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                            menuVOS.remove(menuVO3);
                                        }


                                    }

                                }



                            }



                        }
                        //在审理期
                        else if(caseInfo.getCurrentMainNode().equals(CaseMainNodeEnum.CASE_PROCESSING.getCode())){

                            //反请求答辩记录
                            CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
                            caseReplyTimeRecord.setBusiId(caseRequestInfo.getId());
                            caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);

                            //无反请求
                            if(caseRequestInfo==null||caseRequestInfo.getId()==null){

                                //本请求无撤案
                                if(requestInfo.getStatus().equals("0")){
                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO2);
                                    MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                    menuVOS.add(menuVO3);

                                    for (CaseApprove caseApprove:caseApproves){
                                        String approveType=caseApprove.getApproveType();

                                        //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                        if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                            //申请秘书回避
                                            menuVOS.remove(menuVO1);
                                        }
                                        if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                            menuVOS.remove(menuVO2);

                                        }
                                        if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                            menuVOS.remove(menuVO3);
                                        }



                                    }






                                }

                            }
                            //有反请求
                            else{

                                //本请求无撤案
                                if(requestInfo.getStatus().equals("0")){
                                    //反请求已撤案
                                    if(caseRequestInfo.getStatus().equals("1")){
                                        MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                        menuVOS.add(menuVO1);
                                        MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                        menuVOS.add(menuVO2);
                                        MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                        menuVOS.add(menuVO3);

                                        for (CaseApprove caseApprove:caseApproves){
                                            String approveType=caseApprove.getApproveType();

                                            //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                            if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                                //申请秘书回避
                                                menuVOS.remove(menuVO1);
                                            }
                                            if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                                menuVOS.remove(menuVO2);

                                            }
                                            if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                                menuVOS.remove(menuVO3);
                                            }



                                        }

                                    }

                                    //反请求未撤案
                                    else{

                                        //反请求答辩未到期
                                        if(new Date().compareTo(caseReplyTimeRecord.getEndTime())>0){
                                            MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                            menuVOS.add(menuVO1);
                                            MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                            menuVOS.add(menuVO2);
                                            MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                            menuVOS.add(menuVO3);


                                            //没有延期
                                            if(caseReplyTimeRecord.getDelayFlag().equals("1")){
                                                MenuVO menuVO=new MenuVO(MenuEnum.APPLY_FOR_EXTENSION_PROOF.getCode(),MenuEnum.APPLY_FOR_EXTENSION_PROOF.getRemark());
                                                menuVOS.add(menuVO);

                                            }
                                            MenuVO menuVO5=new MenuVO(MenuEnum.OBJECTION_JURISDICTION_THE_COUNTERCLAIM.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                            menuVOS.add(menuVO5);

                                            for (CaseApprove caseApprove:caseApproves){
                                                String approveType=caseApprove.getApproveType();

                                                //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                                if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                                    //申请秘书回避
                                                    menuVOS.remove(menuVO1);
                                                }
                                                if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                                    menuVOS.remove(menuVO2);

                                                }
                                                if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                                    menuVOS.remove(menuVO3);
                                                }

                                                //反请求管辖权异议
                                                if(approveType.equals(ApproveTypeEnum.COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName())){
                                                    menuVOS.remove(menuVO5);
                                                }



                                            }


                                        }
                                        //反请求答辩已过期
                                        else{

                                            MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                            menuVOS.add(menuVO1);
                                            MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                            menuVOS.add(menuVO2);
                                            MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                            menuVOS.add(menuVO3);

                                            for (CaseApprove caseApprove:caseApproves){
                                                String approveType=caseApprove.getApproveType();

                                                //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                                if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                                    //申请秘书回避
                                                    menuVOS.remove(menuVO1);
                                                }
                                                if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                                    menuVOS.remove(menuVO2);

                                                }
                                                if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                                    menuVOS.remove(menuVO3);
                                                }



                                            }

                                        }

                                    }

                                }
                                //本请求已撤案
                                else{

                                    //反请求未撤案
                                    if(caseRequestInfo.getStatus().equals("0")){
                                        //反请求答辩未到期
                                        if(new Date().compareTo(caseReplyTimeRecord.getEndTime())>0){
                                            MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                            menuVOS.add(menuVO1);
                                            MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                            menuVOS.add(menuVO2);

                                            MenuVO menuVO3=new MenuVO(MenuEnum.OBJECTION_JURISDICTION_THE_COUNTERCLAIM.getCode(),MenuEnum.OBJECTION_JURISDICTION_THE_COUNTERCLAIM.getRemark());
                                            menuVOS.add(menuVO3);


                                            //没有延期
                                            if(caseReplyTimeRecord.getDelayFlag().equals("1")){
                                                MenuVO menuVO=new MenuVO(MenuEnum.APPLY_FOR_EXTENSION_PROOF.getCode(),MenuEnum.APPLY_FOR_EXTENSION_PROOF.getRemark());
                                                menuVOS.add(menuVO);

                                            }

                                            for (CaseApprove caseApprove:caseApproves){
                                                String approveType=caseApprove.getApproveType();

                                                //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                                if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                                    //申请秘书回避
                                                    menuVOS.remove(menuVO1);
                                                }
                                                if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                                    menuVOS.remove(menuVO2);

                                                }
                                                if(approveType.equals(ApproveTypeEnum.COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName())){
                                                    menuVOS.remove(menuVO3);
                                                }



                                            }




                                        }
                                        else{
                                            MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                            menuVOS.add(menuVO1);
                                            MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                            menuVOS.add(menuVO2);

                                            for (CaseApprove caseApprove:caseApproves){
                                                String approveType=caseApprove.getApproveType();

                                                //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                                if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                                    //申请秘书回避
                                                    menuVOS.remove(menuVO1);
                                                }
                                                if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                                    menuVOS.remove(menuVO2);

                                                }




                                            }

                                        }
                                    }






                                }

                            }


                        }
                        //结案
                        else if(caseInfo.getCurrentMainNode().equals(CaseMainNodeEnum.CASE_OVER.getCode())){

                        }

                }

                break;

            case DEFENDANT:


                //和解期
                if(compromiseApply!=null&&compromiseApply.getStatus()!=null&&ComproiseApplyStatusEnum.DOING.getValue().equals(compromiseApply.getStatus())){

                    //有反请求并且有未撤案

                    if(caseRequestInfo!=null&&caseRequestInfo.getStatus().equals("0")){

                        MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                        menuVOS.add(menuVO3);

                        for (CaseApprove caseApprove:caseApproves){
                            String approveType=caseApprove.getApproveType();

                            if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                menuVOS.remove(menuVO3);
                            }

                        }

                    }



                }
                else{
                    CaseAgent decaseAgent=new CaseAgent();
                    decaseAgent.setCaseId(caseId);
                    decaseAgent.setLitigantType(LitigantTypeEnum.DEFENDANT.getValue());
                    decaseAgent=caseAgentMapper.selectAgentByCaseId(decaseAgent);



                        //判断是否在答辩期
                        if(caseInfo.getCurrentMainNode().equals(CaseMainNodeEnum.CASE_REPLY.getCode())){

                            //
                            //无反请求
                            if(caseRequestInfo==null||caseRequestInfo.getId()==null){

                                //本请求无撤案
                                if(requestInfo.getStatus().equals("0")){
                                    //申请秘书回避
                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    //反请求
                                    MenuVO menuVO2=new MenuVO(MenuEnum.COUNTER_REQUEST.getCode(),MenuEnum.COUNTER_REQUEST.getRemark());
                                    menuVOS.add(menuVO2);

                                    //判断是否延期申请过
                                    CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
                                    caseReplyTimeRecord.setBusiId(requestInfo.getId());

                                    caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);

                                    //没有延期
                                    if(caseReplyTimeRecord.getDelayFlag().equals("1")){
                                        MenuVO menuVO=new MenuVO(MenuEnum.APPLY_FOR_EXTENSION_PROOF.getCode(),MenuEnum.APPLY_FOR_EXTENSION_PROOF.getRemark());
                                        menuVOS.add(menuVO);

                                    }

                                    //管辖权异议
                                    MenuVO menuVO4=new MenuVO(MenuEnum.JURISDICTION_OBJECTION.getCode(),MenuEnum.JURISDICTION_OBJECTION.getRemark());
                                    menuVOS.add(menuVO4);

                                    if(caseApproves!=null){


                                        for (CaseApprove caseApprove:caseApproves){
                                            String approveType=caseApprove.getApproveType();

                                            //无代理人 无反请求 未撤案 本请求答辩期未过期 被申请人可操作的有：申请秘书回避、反请求、延期答辩、管辖权异议
                                            if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                                //申请秘书回避
                                                menuVOS.remove(menuVO1);
                                            }
                                            if(approveType.equals(ApproveTypeEnum.COUNTERCLAIM_APPROVAL.getTypeName())){

                                                menuVOS.remove(menuVO2);

                                            }
                                            //只能申请一次
                                            if(approveType.equals(ApproveTypeEnum.JURISDICTION_OBJECTION_APPROVAL.getTypeName())){
                                                menuVOS.remove(menuVO4);
                                            }



                                        }

                                    }





                                }
                                //本请求已撤案
                           /*     else{

                            }*/

                                //有反请求
                            }else{


                                //有反请求 本请求、反请求都无撤案 无代理人： 申请秘书回避 申请撤案 反请求变更 本请求管辖权异议 申请延期举证
                                if(requestInfo.getStatus().equals("0")&&caseRequestInfo.getStatus().equals("0")){


                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);


                                    MenuVO menuVO2=new MenuVO(MenuEnum.REVERSE_REQUEST_CHANGE.getCode(),MenuEnum.REVERSE_REQUEST_CHANGE.getRemark());
                                    menuVOS.add(menuVO2);
                                    MenuVO menuVO3=new MenuVO(MenuEnum.REVERSE_WITHDRAW_CASE.getCode(),MenuEnum.REVERSE_WITHDRAW_CASE.getRemark());
                                    menuVOS.add(menuVO3);
                                    MenuVO menuVO4=new MenuVO(MenuEnum.JURISDICTION_OBJECTION.getCode(),MenuEnum.JURISDICTION_OBJECTION.getRemark());
                                    menuVOS.add(menuVO4);

                                    //判断是否延期申请过
                                    CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
                                    caseReplyTimeRecord.setBusiId(requestInfo.getId());

                                    caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);

                                    //没有延期
                                    if(caseReplyTimeRecord.getDelayFlag().equals("1")){
                                        MenuVO menuVO=new MenuVO(MenuEnum.APPLY_FOR_EXTENSION_PROOF.getCode(),MenuEnum.APPLY_FOR_EXTENSION_PROOF.getRemark());
                                        menuVOS.add(menuVO);

                                    }

                                    for (CaseApprove caseApprove:caseApproves){
                                        String approveType=caseApprove.getApproveType();

                                        //申请秘书回避
                                        if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                            menuVOS.remove(menuVO1);
                                        }
                                        //变更仲裁请求
                                        if(approveType.equals(ApproveTypeEnum.ALTERATION_COUNTERCLAIM_APPROVAL.getTypeName())){

                                            menuVOS.remove(menuVO2);

                                        }
                                        //申请撤案
                                        if(approveType.equals(ApproveTypeEnum.COUNTER_CLAIM_CASE_APPROVE.getTypeName())){
                                            menuVOS.remove(menuVO3);
                                        }

                                        //本请求管辖权异议 只能申请一次
                                        if(approveType.equals(ApproveTypeEnum.JURISDICTION_OBJECTION_APPROVAL.getTypeName())){
                                            menuVOS.remove(menuVO4);
                                        }



                                    }


                                }

                                //有反请求 本请求已撤案 反请求存在 无代理：申请秘书回避  撤回反请求 变更反请求
                                if(requestInfo.getStatus().equals("1")&&caseRequestInfo.getStatus().equals("0")){

                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    MenuVO menuVO2=new MenuVO(MenuEnum.REVERSE_WITHDRAW_CASE.getCode(),MenuEnum.REVERSE_WITHDRAW_CASE.getRemark());
                                    menuVOS.add(menuVO2);

                                    MenuVO menuVO3=new MenuVO(MenuEnum.REVERSE_REQUEST_CHANGE.getCode(),MenuEnum.REVERSE_REQUEST_CHANGE.getRemark());
                                    menuVOS.add(menuVO3);





                                    for (CaseApprove caseApprove:caseApproves){
                                        String approveType=caseApprove.getApproveType();

                                        //申请秘书回避
                                        if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                            menuVOS.remove(menuVO1);
                                        }
                                        //反请求管辖权异议
                                        if(approveType.equals(ApproveTypeEnum.COUNTER_CLAIM_CASE_APPROVE.getTypeName())){
                                            menuVOS.remove(menuVO2);
                                        }

                                        //变更反请求
                                        if(approveType.equals(ApproveTypeEnum.ALTERATION_COUNTERCLAIM_APPROVAL.getTypeName())){
                                            menuVOS.remove(menuVO3);
                                        }

                                    }

                                }


                                //有反请求 本请求未撤案 反请求已撤案 无代理：申请秘书回避  延期答辩 管辖权异议

                                if(requestInfo.getStatus().equals("0")&&caseRequestInfo.getStatus().equals("1")){

                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    MenuVO menuVO2=new MenuVO(MenuEnum.JURISDICTION_OBJECTION.getCode(),MenuEnum.JURISDICTION_OBJECTION.getRemark());
                                    menuVOS.add(menuVO2);

                                    //判断是否延期申请过
                                    CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
                                    caseReplyTimeRecord.setBusiId(requestInfo.getId());

                                    caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);

                                    //没有延期
                                    if(caseReplyTimeRecord.getDelayFlag().equals("1")){
                                        MenuVO menuVO=new MenuVO(MenuEnum.APPLY_FOR_EXTENSION_PROOF.getCode(),MenuEnum.APPLY_FOR_EXTENSION_PROOF.getRemark());
                                        menuVOS.add(menuVO);

                                    }


                                    for (CaseApprove caseApprove:caseApproves){
                                        String approveType=caseApprove.getApproveType();

                                        //申请秘书回避
                                        if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                            menuVOS.remove(menuVO1);
                                        }
                                        //管辖权异议 只能申请一次
                                        if(approveType.equals(ApproveTypeEnum.JURISDICTION_OBJECTION_APPROVAL.getTypeName())){

                                            menuVOS.remove(menuVO2);

                                        }

                                    }

                                }

                            }

                        }
                        //在审理期
                        else if(caseInfo.getCurrentMainNode().equals(CaseMainNodeEnum.CASE_PROCESSING.getCode())){

                            //反请求答辩记录
                            CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
                            caseReplyTimeRecord.setBusiId(caseRequestInfo.getId());
                            caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);

                            //无反请求
                            if(caseRequestInfo==null||caseRequestInfo.getId()==null){

                                //本请求无撤案
                                if(requestInfo.getStatus().equals("0")){
                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO2);


                                    for (CaseApprove caseApprove:caseApproves){
                                        String approveType=caseApprove.getApproveType();

                                        //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                        if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                            //申请秘书回避
                                            menuVOS.remove(menuVO1);
                                        }
                                        if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                            menuVOS.remove(menuVO2);

                                        }

                                    }
                                }
                            }
                            //有反请求
                            else{

                                //本请求无撤案
                                if(requestInfo.getStatus().equals("0")){

                                    //反请求未撤案
                                    if(caseRequestInfo.getStatus().equals("0")){

                                        MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                        menuVOS.add(menuVO1);
                                        MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                        menuVOS.add(menuVO2);
                                        MenuVO menuVO3=new MenuVO(MenuEnum.REVERSE_WITHDRAW_CASE.getCode(),MenuEnum.REVERSE_WITHDRAW_CASE.getRemark());
                                        menuVOS.add(menuVO3);


                                        for (CaseApprove caseApprove:caseApproves){
                                            String approveType=caseApprove.getApproveType();

                                            //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                            if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                                //申请秘书回避
                                                menuVOS.remove(menuVO1);
                                            }
                                            if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                                menuVOS.remove(menuVO2);

                                            }

                                            if(approveType.equals(ApproveTypeEnum.COUNTER_CLAIM_CASE_APPROVE.getTypeName())){

                                                menuVOS.remove(menuVO3);

                                            }

                                        }

                                    }
                                    //反请求已撤案
                                    else{

                                        MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                        menuVOS.add(menuVO1);
                                        MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                        menuVOS.add(menuVO2);



                                        for (CaseApprove caseApprove:caseApproves){
                                            String approveType=caseApprove.getApproveType();

                                            //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                            if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                                //申请秘书回避
                                                menuVOS.remove(menuVO1);
                                            }
                                            if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                                menuVOS.remove(menuVO2);

                                            }






                                        }

                                    }

                                }
                                //本请求已撤案
                                else{

                                    //反请求未撤案
                                    if(caseRequestInfo.getStatus().equals("0")){
                                        MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                        menuVOS.add(menuVO1);
                                        MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                        menuVOS.add(menuVO2);
                                        MenuVO menuVO3=new MenuVO(MenuEnum.REVERSE_WITHDRAW_CASE.getCode(),MenuEnum.REVERSE_WITHDRAW_CASE.getRemark());
                                        menuVOS.add(menuVO3);


                                        for (CaseApprove caseApprove:caseApproves){
                                            String approveType=caseApprove.getApproveType();

                                            //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                            if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                                //申请秘书回避
                                                menuVOS.remove(menuVO1);
                                            }
                                            if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                                menuVOS.remove(menuVO2);

                                            }

                                            if(approveType.equals(ApproveTypeEnum.COUNTER_CLAIM_CASE_APPROVE.getTypeName())){

                                                menuVOS.remove(menuVO3);

                                            }




                                        }
                                    }

                                }



                            }



                        }







                }

                break;

            //申请人代理
            case PROPESER_AGENT:

                //读取案件代理人权限
                CaseAgent caseAgent=new CaseAgent();
                caseAgent.setCaseId(caseId);
                caseAgent.setLitigantType(LitigantTypeEnum.PROPESER.getValue());
                caseAgent=caseAgentMapper.selectAgentByCaseId(caseAgent);
                List<MenuVO> authorityMenuList=new ArrayList<MenuVO>();

                if(caseAgent.getAgentType()!=null){

                    //根据权限类型对应的按钮权限按钮集合
                    AgentAuthorityRef agentAuthorityRef=new AgentAuthorityRef();
                    agentAuthorityRef.setAgentAuthorityId(caseAgent.getAgentType());
                    authorityMenuList= agentAuthorityRefMapper.selectAuthoByAgent(agentAuthorityRef);


                }




                //得到集合的交集


                //和解期
                if(compromiseApply!=null&&compromiseApply.getStatus()!=null&&ComproiseApplyStatusEnum.DOING.getValue().equals(compromiseApply.getStatus())){
                    MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                    menuVOS.add(menuVO3);

                    for (CaseApprove caseApprove:caseApproves){
                        String approveType=caseApprove.getApproveType();

                        if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                            menuVOS.remove(menuVO3);
                        }

                    }

                }

                else{





                        //判断是否在答辩期
                        if(caseInfo.getCurrentMainNode().equals(CaseMainNodeEnum.CASE_REPLY.getCode())){

                            //
                            //无反请求
                            if(caseRequestInfo==null||caseRequestInfo.getId()==null){

                                //本请求无撤案
                                if(requestInfo.getStatus().equals("0")){
                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    MenuVO menuVO2=new MenuVO(MenuEnum.CHANGE_OF_ARBITRATION_REQUEST.getCode(),MenuEnum.CHANGE_OF_ARBITRATION_REQUEST.getRemark());
                                    menuVOS.add(menuVO2);
                                    MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                    menuVOS.add(menuVO3);

                                    if(caseApproves!=null){


                                        for (CaseApprove caseApprove:caseApproves){
                                            String approveType=caseApprove.getApproveType();

                                            //无代理人 无反请求 未撤案 本请求答辩期未过期 申请人可操作的有：申请撤案、申请秘书回避、变更仲裁请求
                                            if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                                //申请秘书回避
                                                menuVOS.remove(menuVO1);
                                            }
                                            if(approveType.equals(ApproveTypeEnum.ALTERATION_ARBITRATION_REQUEST.getTypeName())){

                                                menuVOS.remove(menuVO2);

                                            }
                                            if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                                menuVOS.remove(menuVO3);
                                            }



                                        }

                                    }





                                }
                                //本请求已撤案
                           /*     else{

                            }*/

                                //有反请求
                            }else{


                                //有反请求 本请求、反请求都无撤案 无代理人： 申请秘书回避 申请撤案 变更仲裁请求 反请求管辖权异议 申请延期举证
                                if(requestInfo.getStatus().equals("0")&&caseRequestInfo.getStatus().equals("0")){

                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    MenuVO menuVO2=new MenuVO(MenuEnum.CHANGE_OF_ARBITRATION_REQUEST.getCode(),MenuEnum.CHANGE_OF_ARBITRATION_REQUEST.getRemark());
                                    menuVOS.add(menuVO2);
                                    MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                    menuVOS.add(menuVO3);
                                    MenuVO menuVO4=new MenuVO(MenuEnum.OBJECTION_JURISDICTION_THE_COUNTERCLAIM.getCode(),MenuEnum.OBJECTION_JURISDICTION_THE_COUNTERCLAIM.getRemark());
                                    menuVOS.add(menuVO4);

                                    //判断是否延期申请过
                                    CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
                                    caseReplyTimeRecord.setBusiId(caseRequestInfo.getId());

                                    caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);

                                    //没有延期
                                    if(caseReplyTimeRecord.getDelayFlag().equals("1")){
                                        MenuVO menuVO=new MenuVO(MenuEnum.APPLY_FOR_EXTENSION_PROOF.getCode(),MenuEnum.APPLY_FOR_EXTENSION_PROOF.getRemark());
                                        menuVOS.add(menuVO);

                                    }

                                    for (CaseApprove caseApprove:caseApproves){
                                        String approveType=caseApprove.getApproveType();

                                        //申请秘书回避
                                        if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                            menuVOS.remove(menuVO1);
                                        }
                                        //变更仲裁请求
                                        if(approveType.equals(ApproveTypeEnum.ALTERATION_ARBITRATION_REQUEST.getTypeName())){

                                            menuVOS.remove(menuVO2);

                                        }
                                        //申请撤案
                                        if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                            menuVOS.remove(menuVO3);
                                        }

                                        //反请求管辖权异议
                                        if(approveType.equals(ApproveTypeEnum.COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName())){
                                            menuVOS.remove(menuVO4);
                                        }



                                    }


                                }

                                //有反请求 本请求已撤案 反请求存在 无代理：申请秘书回避  反请求管辖权异议 申请延期举证
                                if(requestInfo.getStatus().equals("1")&&caseRequestInfo.getStatus().equals("0")){

                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    MenuVO menuVO2=new MenuVO(MenuEnum.OBJECTION_JURISDICTION_THE_COUNTERCLAIM.getCode(),MenuEnum.OBJECTION_JURISDICTION_THE_COUNTERCLAIM.getRemark());
                                    menuVOS.add(menuVO2);

                                    //判断是否延期申请过
                                    CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
                                    caseReplyTimeRecord.setBusiId(caseRequestInfo.getId());

                                    caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);

                                    //没有延期
                                    if(caseReplyTimeRecord.getDelayFlag().equals("1")){
                                        MenuVO menuVO=new MenuVO(MenuEnum.APPLY_FOR_EXTENSION_PROOF.getCode(),MenuEnum.APPLY_FOR_EXTENSION_PROOF.getRemark());
                                        menuVOS.add(menuVO);

                                    }



                                    for (CaseApprove caseApprove:caseApproves){
                                        String approveType=caseApprove.getApproveType();

                                        //申请秘书回避
                                        if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                            menuVOS.remove(menuVO1);
                                        }


                                        //反请求管辖权异议
                                        if(approveType.equals(ApproveTypeEnum.COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName())){
                                            menuVOS.remove(menuVO2);
                                        }





                                    }





                                }


                                //有反请求 本请求未撤案 反请求已撤案 无代理：申请秘书回避  申请撤案 变更仲裁请求

                                if(requestInfo.getStatus().equals("0")&&caseRequestInfo.getStatus().equals("1")){

                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    MenuVO menuVO2=new MenuVO(MenuEnum.CHANGE_OF_ARBITRATION_REQUEST.getCode(),MenuEnum.CHANGE_OF_ARBITRATION_REQUEST.getRemark());
                                    menuVOS.add(menuVO2);
                                    MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                    menuVOS.add(menuVO3);

                                    for (CaseApprove caseApprove:caseApproves){
                                        String approveType=caseApprove.getApproveType();

                                        //申请秘书回避
                                        if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                            menuVOS.remove(menuVO1);
                                        }
                                        //变更仲裁请求
                                        if(approveType.equals(ApproveTypeEnum.ALTERATION_ARBITRATION_REQUEST.getTypeName())){

                                            menuVOS.remove(menuVO2);

                                        }
                                        //申请撤案
                                        if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                            menuVOS.remove(menuVO3);
                                        }


                                    }

                                }



                            }



                        }
                        //在审理期
                        else if(caseInfo.getCurrentMainNode().equals(CaseMainNodeEnum.CASE_PROCESSING.getCode())){

                            //反请求答辩记录
                            CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
                            caseReplyTimeRecord.setBusiId(caseRequestInfo.getId());
                            caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);

                            //无反请求
                            if(caseRequestInfo==null||caseRequestInfo.getId()==null){

                                //本请求无撤案
                                if(requestInfo.getStatus().equals("0")){
                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO2);
                                    MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                    menuVOS.add(menuVO3);

                                    for (CaseApprove caseApprove:caseApproves){
                                        String approveType=caseApprove.getApproveType();

                                        //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                        if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                            //申请秘书回避
                                            menuVOS.remove(menuVO1);
                                        }
                                        if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                            menuVOS.remove(menuVO2);

                                        }
                                        if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                            menuVOS.remove(menuVO3);
                                        }



                                    }






                                }

                            }
                            //有反请求
                            else{

                                //本请求无撤案
                                if(requestInfo.getStatus().equals("0")){
                                    //反请求已撤案
                                    if(caseRequestInfo.getStatus().equals("1")){
                                        MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                        menuVOS.add(menuVO1);
                                        MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                        menuVOS.add(menuVO2);
                                        MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                        menuVOS.add(menuVO3);

                                        for (CaseApprove caseApprove:caseApproves){
                                            String approveType=caseApprove.getApproveType();

                                            //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                            if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                                //申请秘书回避
                                                menuVOS.remove(menuVO1);
                                            }
                                            if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                                menuVOS.remove(menuVO2);

                                            }
                                            if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                                menuVOS.remove(menuVO3);
                                            }



                                        }

                                    }

                                    //反请求未撤案
                                    else{

                                        //反请求答辩未到期
                                        if(new Date().compareTo(caseReplyTimeRecord.getEndTime())>0){
                                            MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                            menuVOS.add(menuVO1);
                                            MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                            menuVOS.add(menuVO2);
                                            MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                            menuVOS.add(menuVO3);


                                            //没有延期
                                            if(caseReplyTimeRecord.getDelayFlag().equals("1")){
                                                MenuVO menuVO=new MenuVO(MenuEnum.APPLY_FOR_EXTENSION_PROOF.getCode(),MenuEnum.APPLY_FOR_EXTENSION_PROOF.getRemark());
                                                menuVOS.add(menuVO);

                                            }
                                            MenuVO menuVO5=new MenuVO(MenuEnum.OBJECTION_JURISDICTION_THE_COUNTERCLAIM.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                            menuVOS.add(menuVO5);

                                            for (CaseApprove caseApprove:caseApproves){
                                                String approveType=caseApprove.getApproveType();

                                                //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                                if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                                    //申请秘书回避
                                                    menuVOS.remove(menuVO1);
                                                }
                                                if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                                    menuVOS.remove(menuVO2);

                                                }
                                                if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                                    menuVOS.remove(menuVO3);
                                                }

                                                //反请求管辖权异议
                                                if(approveType.equals(ApproveTypeEnum.COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName())){
                                                    menuVOS.remove(menuVO5);
                                                }



                                            }


                                        }
                                        //反请求答辩已过期
                                        else{

                                            MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                            menuVOS.add(menuVO1);
                                            MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                            menuVOS.add(menuVO2);
                                            MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                            menuVOS.add(menuVO3);

                                            for (CaseApprove caseApprove:caseApproves){
                                                String approveType=caseApprove.getApproveType();

                                                //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                                if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                                    //申请秘书回避
                                                    menuVOS.remove(menuVO1);
                                                }
                                                if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                                    menuVOS.remove(menuVO2);

                                                }
                                                if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                                    menuVOS.remove(menuVO3);
                                                }



                                            }

                                        }

                                    }

                                }
                                //本请求已撤案
                                else{

                                    //反请求未撤案
                                    if(caseRequestInfo.getStatus().equals("0")){
                                        //反请求答辩未到期
                                        if(new Date().compareTo(caseReplyTimeRecord.getEndTime())>0){
                                            MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                            menuVOS.add(menuVO1);
                                            MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                            menuVOS.add(menuVO2);

                                            MenuVO menuVO3=new MenuVO(MenuEnum.OBJECTION_JURISDICTION_THE_COUNTERCLAIM.getCode(),MenuEnum.OBJECTION_JURISDICTION_THE_COUNTERCLAIM.getRemark());
                                            menuVOS.add(menuVO3);


                                            //没有延期
                                            if(caseReplyTimeRecord.getDelayFlag().equals("1")){
                                                MenuVO menuVO=new MenuVO(MenuEnum.APPLY_FOR_EXTENSION_PROOF.getCode(),MenuEnum.APPLY_FOR_EXTENSION_PROOF.getRemark());
                                                menuVOS.add(menuVO);

                                            }

                                            for (CaseApprove caseApprove:caseApproves){
                                                String approveType=caseApprove.getApproveType();

                                                //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                                if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                                    //申请秘书回避
                                                    menuVOS.remove(menuVO1);
                                                }
                                                if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                                    menuVOS.remove(menuVO2);

                                                }
                                                if(approveType.equals(ApproveTypeEnum.COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName())){
                                                    menuVOS.remove(menuVO3);
                                                }



                                            }




                                        }
                                        else{
                                            MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                            menuVOS.add(menuVO1);
                                            MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                            menuVOS.add(menuVO2);

                                            for (CaseApprove caseApprove:caseApproves){
                                                String approveType=caseApprove.getApproveType();

                                                //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                                if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                                    //申请秘书回避
                                                    menuVOS.remove(menuVO1);
                                                }
                                                if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                                    menuVOS.remove(menuVO2);

                                                }




                                            }

                                        }
                                    }






                                }

                            }


                        }
                        //结案
                        else if(caseInfo.getCurrentMainNode().equals(CaseMainNodeEnum.CASE_OVER.getCode())){

                        }









                }


                menuVOS.retainAll(authorityMenuList);


                break;










            //被申请人代理
            case DEFENDANT_AGENT:

                CaseAgent decaseAgent=new CaseAgent();
                decaseAgent.setCaseId(caseId);
                decaseAgent.setLitigantType(LitigantTypeEnum.DEFENDANT.getValue());
                decaseAgent=caseAgentMapper.selectAgentByCaseId(decaseAgent);
                List<MenuVO> deauthorityMenuList=new ArrayList<MenuVO>();

                if(decaseAgent.getAgentType()!=null){

                    //根据权限类型对应的按钮权限按钮集合
                    AgentAuthorityRef agentAuthorityRef=new AgentAuthorityRef();
                    agentAuthorityRef.setAgentAuthorityId(decaseAgent.getAgentType());
                    deauthorityMenuList= agentAuthorityRefMapper.selectAuthoByAgent(agentAuthorityRef);


                }


                //和解期  和解申请表状态为和解中
                if(compromiseApply!=null&&compromiseApply.getStatus()!=null&&ComproiseApplyStatusEnum.DOING.getValue().equals(compromiseApply.getStatus())){

                    //有反请求并且有未撤案

                    if(caseRequestInfo!=null&&"0".equals(caseRequestInfo.getStatus())){

                        MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                        menuVOS.add(menuVO3);

                        for (CaseApprove caseApprove:caseApproves){
                            String approveType=caseApprove.getApproveType();

                            if(approveType.equals(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName())){
                                menuVOS.remove(menuVO3);
                            }

                        }

                    }



                }
                else{




                    //判断是否在答辩期
                    if(caseInfo.getCurrentMainNode().equals(CaseMainNodeEnum.CASE_REPLY.getCode())){

                        //
                        //无反请求
                        if(caseRequestInfo==null||caseRequestInfo.getId()==null){

                            //本请求无撤案
                            if("0".equals(requestInfo.getStatus())){
                                //申请秘书回避
                                MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                menuVOS.add(menuVO1);
                                //反请求
                                MenuVO menuVO2=new MenuVO(MenuEnum.COUNTER_REQUEST.getCode(),MenuEnum.COUNTER_REQUEST.getRemark());
                                menuVOS.add(menuVO2);

                                //判断是否延期申请过
                                CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
                                caseReplyTimeRecord.setBusiId(requestInfo.getId());

                                caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);

                                //没有延期
                                if(caseReplyTimeRecord.getDelayFlag().equals("1")){
                                    MenuVO menuVO=new MenuVO(MenuEnum.APPLY_FOR_EXTENSION_PROOF.getCode(),MenuEnum.APPLY_FOR_EXTENSION_PROOF.getRemark());
                                    menuVOS.add(menuVO);

                                }

                                //管辖权异议
                                MenuVO menuVO4=new MenuVO(MenuEnum.JURISDICTION_OBJECTION.getCode(),MenuEnum.JURISDICTION_OBJECTION.getRemark());
                                menuVOS.add(menuVO4);

                                if(caseApproves!=null){


                                    for (CaseApprove caseApprove:caseApproves){
                                        String approveType=caseApprove.getApproveType();

                                        //无代理人 无反请求 未撤案 本请求答辩期未过期 被申请人可操作的有：申请秘书回避、反请求、延期答辩、管辖权异议
                                        if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                            //申请秘书回避
                                            menuVOS.remove(menuVO1);
                                        }
                                        if(approveType.equals(ApproveTypeEnum.COUNTERCLAIM_APPROVAL.getTypeName())){

                                            menuVOS.remove(menuVO2);

                                        }
                                        //只能申请一次
                                        if(approveType.equals(ApproveTypeEnum.JURISDICTION_OBJECTION_APPROVAL.getTypeName())){
                                            menuVOS.remove(menuVO4);
                                        }



                                    }

                                }





                            }
                            //本请求已撤案
                           /*     else{

                            }*/

                            //有反请求
                        }else{


                            //有反请求 本请求、反请求都无撤案 无代理人： 申请秘书回避 申请撤案 反请求变更 本请求管辖权异议 申请延期举证
                            if(requestInfo.getStatus().equals("0")&&caseRequestInfo.getStatus().equals("0")){


                                MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                menuVOS.add(menuVO1);


                                MenuVO menuVO2=new MenuVO(MenuEnum.REVERSE_REQUEST_CHANGE.getCode(),MenuEnum.REVERSE_REQUEST_CHANGE.getRemark());
                                menuVOS.add(menuVO2);
                                MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                menuVOS.add(menuVO3);
                                MenuVO menuVO4=new MenuVO(MenuEnum.JURISDICTION_OBJECTION.getCode(),MenuEnum.JURISDICTION_OBJECTION.getRemark());
                                menuVOS.add(menuVO4);

                                //判断是否延期申请过
                                CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
                                caseReplyTimeRecord.setBusiId(requestInfo.getId());

                                caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);

                                //没有延期
                                if(caseReplyTimeRecord.getDelayFlag().equals("1")){
                                    MenuVO menuVO=new MenuVO(MenuEnum.APPLY_FOR_EXTENSION_PROOF.getCode(),MenuEnum.APPLY_FOR_EXTENSION_PROOF.getRemark());
                                    menuVOS.add(menuVO);

                                }

                                for (CaseApprove caseApprove:caseApproves){
                                    String approveType=caseApprove.getApproveType();

                                    //申请秘书回避
                                    if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                        menuVOS.remove(menuVO1);
                                    }
                                    //变更仲裁请求
                                    if(approveType.equals(ApproveTypeEnum.ALTERATION_COUNTERCLAIM_APPROVAL.getTypeName())){

                                        menuVOS.remove(menuVO2);

                                    }
                                    //申请撤案
                                    if(approveType.equals(ApproveTypeEnum.COUNTER_CLAIM_CASE_APPROVE.getTypeName())){
                                        menuVOS.remove(menuVO3);
                                    }

                                    //本请求管辖权异议 只能申请一次
                                    if(approveType.equals(ApproveTypeEnum.JURISDICTION_OBJECTION_APPROVAL.getTypeName())){
                                        menuVOS.remove(menuVO4);
                                    }



                                }


                            }

                            //有反请求 本请求已撤案 反请求存在 无代理：申请秘书回避  撤回反请求 变更反请求
                            if(requestInfo.getStatus().equals("1")&&caseRequestInfo.getStatus().equals("0")){

                                MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                menuVOS.add(menuVO1);
                                MenuVO menuVO2=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                menuVOS.add(menuVO2);

                                MenuVO menuVO3=new MenuVO(MenuEnum.REVERSE_REQUEST_CHANGE.getCode(),MenuEnum.REVERSE_REQUEST_CHANGE.getRemark());
                                menuVOS.add(menuVO3);





                                for (CaseApprove caseApprove:caseApproves){
                                    String approveType=caseApprove.getApproveType();

                                    //申请秘书回避
                                    if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                        menuVOS.remove(menuVO1);
                                    }


                                    //反请求管辖权异议
                                    if(approveType.equals(ApproveTypeEnum.COUNTER_CLAIM_CASE_APPROVE.getTypeName())){
                                        menuVOS.remove(menuVO2);
                                    }

                                    //变更反请求
                                    if(approveType.equals(ApproveTypeEnum.ALTERATION_COUNTERCLAIM_APPROVAL.getTypeName())){
                                        menuVOS.remove(menuVO3);
                                    }





                                }





                            }


                            //有反请求 本请求未撤案 反请求已撤案 无代理：申请秘书回避  延期答辩 管辖权异议

                            if("0".equals(requestInfo.getStatus())&&"1".equals(caseRequestInfo.getStatus())){

                                MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                menuVOS.add(menuVO1);
                                MenuVO menuVO2=new MenuVO(MenuEnum.JURISDICTION_OBJECTION.getCode(),MenuEnum.JURISDICTION_OBJECTION.getRemark());
                                menuVOS.add(menuVO2);

                                //判断是否延期申请过
                                CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
                                caseReplyTimeRecord.setBusiId(requestInfo.getId());

                                caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);

                                //没有延期
                                if("1".equals(caseReplyTimeRecord.getDelayFlag())){
                                    MenuVO menuVO=new MenuVO(MenuEnum.APPLY_FOR_EXTENSION_PROOF.getCode(),MenuEnum.APPLY_FOR_EXTENSION_PROOF.getRemark());
                                    menuVOS.add(menuVO);

                                }


                                for (CaseApprove caseApprove:caseApproves){
                                    String approveType=caseApprove.getApproveType();

                                    //申请秘书回避
                                    if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                        menuVOS.remove(menuVO1);
                                    }
                                    //管辖权异议
                                    if(approveType.equals(ApproveTypeEnum.JURISDICTION_OBJECTION_APPROVAL.getTypeName())){

                                        menuVOS.remove(menuVO2);

                                    }



                                }

                            }



                        }



                    }
                    //在审理期
                    else if(caseInfo.getCurrentMainNode().equals(CaseMainNodeEnum.CASE_PROCESSING.getCode())){

                        //反请求答辩记录
                        CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
                        caseReplyTimeRecord.setBusiId(caseRequestInfo.getId());
                        caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);

                        //无反请求
                        if(caseRequestInfo==null||caseRequestInfo.getId()==null){

                            //本请求无撤案
                            if("0".equals(requestInfo.getStatus())){
                                MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                menuVOS.add(menuVO1);
                                MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                menuVOS.add(menuVO2);


                                for (CaseApprove caseApprove:caseApproves){
                                    String approveType=caseApprove.getApproveType();

                                    //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                    if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                        //申请秘书回避
                                        menuVOS.remove(menuVO1);
                                    }
                                    if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                        menuVOS.remove(menuVO2);

                                    }




                                }
                            }
                        }
                        //有反请求
                        else{

                            //本请求无撤案
                            if("0".equals(requestInfo.getStatus())){

                                //反请求未撤案
                                if("0".equals(caseRequestInfo.getStatus())){

                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO2);
                                    MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                    menuVOS.add(menuVO3);


                                    for (CaseApprove caseApprove:caseApproves){
                                        String approveType=caseApprove.getApproveType();

                                        //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                        if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                            //申请秘书回避
                                            menuVOS.remove(menuVO1);
                                        }
                                        if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                            menuVOS.remove(menuVO2);

                                        }

                                        if(approveType.equals(ApproveTypeEnum.COUNTER_CLAIM_CASE_APPROVE.getTypeName())){

                                            menuVOS.remove(menuVO3);

                                        }




                                    }

                                }
                                //反请求已撤案
                                else{

                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO2);



                                    for (CaseApprove caseApprove:caseApproves){
                                        String approveType=caseApprove.getApproveType();

                                        //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                        if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                            //申请秘书回避
                                            menuVOS.remove(menuVO1);
                                        }
                                        if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                            menuVOS.remove(menuVO2);

                                        }


                                    }

                                }

                            }
                            //本请求已撤案
                            else{

                                //反请求未撤案
                                if("0".equals(caseRequestInfo.getStatus())){
                                    MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO1);
                                    MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());
                                    menuVOS.add(menuVO2);
                                    MenuVO menuVO3=new MenuVO(MenuEnum.WITHDRAW_CASE.getCode(),MenuEnum.WITHDRAW_CASE.getRemark());
                                    menuVOS.add(menuVO3);


                                    for (CaseApprove caseApprove:caseApproves){
                                        String approveType=caseApprove.getApproveType();

                                        //申请人可操作的有：申请撤案、申请秘书回避、申请仲裁员回避
                                        if(approveType.equals(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName())){
                                            //申请秘书回避
                                            menuVOS.remove(menuVO1);
                                        }
                                        if(approveType.equals(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName())){

                                            menuVOS.remove(menuVO2);

                                        }

                                        if(approveType.equals(ApproveTypeEnum.COUNTER_CLAIM_CASE_APPROVE.getTypeName())){

                                            menuVOS.remove(menuVO3);

                                        }




                                    }
                                }

                            }



                        }



                    }







                }


                //
                menuVOS.retainAll(deauthorityMenuList);


                break;

            default:

                break;


        }



        return BusiExecuteResult.builderSuccessResult(menuVOS);
    }

    @Override
    public LitigantTypeEnum queryCaseRoleByUserId(String caseId, String userId) {

        //查询对应用户的身份证号
        UserInfo userInfo=userInfoMapper.selectByPrimaryKey(userId);
        String cardId=userInfo.getCardId();

        //判断是否是当事人
        CaseProposer caseProposer=caseProposerMapper.selectCaseProposerByCaseId(caseId);
        if(caseProposer!=null&&caseProposer.getCardId().equals(cardId)){
            return LitigantTypeEnum.PROPESER;
        }
      //判断是否是被申请人
        CaseDefendant caseDefendant=caseDefendantMapper.selectCaseDefendantByCaseId(caseId);
        if(caseDefendant!=null&&caseDefendant.getCardId().equals(cardId)){
            return LitigantTypeEnum.DEFENDANT;
        }

      //判断是否是代理人(两种类型)
        CaseAgent caseagent=new CaseAgent();
        caseagent.setCaseId(caseId);
        caseagent=caseAgentMapper.selectAgentByCaseId(caseagent);
        if(caseagent.getAgentId()!=null && caseagent.getAgentId().equals(userId)){

            if(caseagent.getLitigantType().equals(LitigantTypeEnum.PROPESER.getValue())){
                return LitigantTypeEnum.PROPESER_AGENT;
            }

            if(caseagent.getLitigantType().equals(LitigantTypeEnum.DEFENDANT.getValue())){
                return LitigantTypeEnum.DEFENDANT_AGENT;
            }
        }

        return null;

    }


    public static void main(String[] args) {


        List<MenuVO> menuVOS1=new ArrayList<>();

        MenuVO menuVO1=new MenuVO(MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getCode(),MenuEnum.APPLY_FOR_SECRETARIAL_AVOIDANCE.getRemark());

        MenuVO menuVO2=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());


        menuVOS1.add(menuVO1);
        menuVOS1.add(menuVO2);

        List<MenuVO> menuVOS2=new ArrayList<>();




        MenuVO menuVO3=new MenuVO(MenuEnum.ARBITRATOR_AVOIDANCE.getCode(),MenuEnum.ARBITRATOR_AVOIDANCE.getRemark());

        menuVOS2.add(menuVO3);

        menuVOS2.retainAll(menuVOS1);

//        for (MenuVO menuVO:menuVOS1){
//
//            if(menuVOS2.contains(menuVO)){
//                menuVOSet.add(menuVO);
//            }
//
////            for (MenuVO menuVO4:menuVOS2){
////
////                if(menuVO4.getMenuId().equals(menuVO.getMenuId())){
////                    menuVOSet.add(menuVO);
////                }
////
////            }
//        }

        for (MenuVO menuVO5:menuVOS2){
            System.out.println(menuVO5.getMenuName());
        }
    }





}
