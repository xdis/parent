$('#icon-left').on('click',function () {
    $('#scroll-nav').animate({left:0})
})
$('#icon-right').on('click',function () {
    $('#scroll-nav').animate({left:-236})
})

function removeApproveClass(){
    $("#caseApproveInfo").find("span").removeClass("bg475");
}

function removeCaseInfoClass(){
    $("#scroll-nav").find("p").removeClass("bg475");
}

//案件审批
function approve(isMyOperation,approveType,caseId,event){
    removeApproveClass();
    removeCaseInfoClass();
    var _this = $(event);
    _this.addClass("bg475");
     if(isMyOperation==1){
        return;
     }

    switch (approveType){
        //变更仲裁请求审批
        case "ALTERATION_ARBITRATION_REQUEST":
            Request.loadMain({url:"case/changeRecord",max:true,container:".case-main",params:'caseId='+caseId+'&counterclaimFlag=0&approveType=ALTERATION_ARBITRATION_REQUEST'});
            break;
        //反请求审批
        case "COUNTERCLAIM_APPROVAL":
            Request.loadMain({url:"case/processing/"+caseId+"/antiRequestAudit",max:true,container:".case-main"});
            break;
        //变更反请求审批
        case "ALTERATION_COUNTERCLAIM_APPROVAL":
            Request.loadMain({url:"case/processing/"+caseId+"/changeCounterclaim",max:true,container:".case-main"});
            break;
        //管辖权异议审批
        case "JURISDICTION_OBJECTION_APPROVAL":
            Request.loadMain({url:"case/jurisdis",max:true,container:".case-main",params:'caseId='+caseId+'&counterclaimFlag=0&approveType=JURISDICTION_OBJECTION_APPROVAL&docType=17'});
            break;
        //反请求管辖权异议审批
        case "COUNTERCLAIM_JURISDICTION_APPROVAL":
            Request.loadMain({url:"case/jurisdis",max:true,container:".case-main",params:'caseId='+caseId+'&counterclaimFlag=1&approveType=COUNTERCLAIM_JURISDICTION_APPROVAL&docType=18'});
            break;
        //秘书申请回避审批
        case "APPLY_SIDESTEP_APPROVAL":
            Request.loadMain({url:"avoid/audit/"+caseId+"/secretaries",max:true,container:".case-main"});
            break;
        //裁决书审批
        case "ARBITRAL_AWARD_APPROVAL":
            Request.loadMain({url:"ruling/audit/"+caseId+"/rulingBookAudit",max:true,container:".case-main"});
            break;
        //调解书审批
        case "CONCILIATION_BOOK_APPROVAL":
            Request.loadMain({url:"case/conciliation",max:true,container:".case-main",params:'caseId='+caseId+'&approveType=CONCILIATION_BOOK_APPROVAL&approveStatus=18'});
            break;
        //调解申请审批
        case "CONCILIATION_APPLY_APPROVAL":
            Request.loadMain({url:"compromise/apply/"+caseId,max:true,container:".case-main"});
            break;
        //补正书审批
        case "CORRECTION_BOOK_APPROVAL":
            Request.loadMain({url:"case/"+caseId+"/adjudicationAmendmentDoc",max:true,container:".case-main"});
            break;
        //仲裁员回避审批
        case "ARBITRATOR_AVOID_EXAMINE":
            Request.loadMain({url:"avoid/audit/"+caseId+"/arbitrator",max:true,container:".case-main"});
            break;
        //本请求撤案审批
        case "THIS_REQUEST_WITHDRAW_CASE_APPROVE":
            Request.loadMain({url:"case/withdrawArbitration/"+caseId,max:true,container:".case-main",params:'requestFlag=0'});
            break;
        //反请求撤案审批
        case "COUNTER_CLAIM_CASE_APPROVE":
            Request.loadMain({url:"case/withdrawArbitration/"+caseId,max:true,container:".case-main",params:'requestFlag=1'});
            break;

    }
}

//和解
function compromiseApply(caseId,event){
    removeApproveClass();
    removeCaseInfoClass();
    var _this = $(event);
    _this.addClass("bg475");
    Request.loadMain({url:"compromise/apply/"+caseId,max:true,container:".case-main"});
}
