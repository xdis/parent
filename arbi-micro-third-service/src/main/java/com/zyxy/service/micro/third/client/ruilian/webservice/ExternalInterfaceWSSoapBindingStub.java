/**
 * ExternalInterfaceWSSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class ExternalInterfaceWSSoapBindingStub extends org.apache.axis.client.Stub implements com.zyxy.service.micro.third.client.ruilian.webservice.ExternalInterfaceWS_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[52];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
        _initOperationDesc5();
        _initOperationDesc6();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("main");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "args"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "ArrayOf_xsd_string"), java.lang.String[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("logout");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lpvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "LogoutVO"), com.zyxy.service.micro.third.client.ruilian.webservice.LogoutVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "LogoutRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.LogoutRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "logoutReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("receiptTypeToFS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "xml"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "receiptTypeToFSReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("unitReceiptTypeToFS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "xml"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "unitReceiptTypeToFSReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getYdzsReceiptStock");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "yrstVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "YdzsReceiptStockTempVO"), com.zyxy.service.micro.third.client.ruilian.webservice.YdzsReceiptStockTempVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "YdzsReceiptStockTempRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.YdzsReceiptStockTempRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getYdzsReceiptStockReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("unitToFS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "xml"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "unitToFSReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("sysUserToFS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "xml"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "sysUserToFSReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("enterStock");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "stockVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "EnterStockVO"), com.zyxy.service.micro.third.client.ruilian.webservice.EnterStockVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "EnterStockRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.EnterStockRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "enterStockReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("chargeRequest");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "xml"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "chargeRequestReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cancelPayNote");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cpnvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "CancelPayNoteVO"), com.zyxy.service.micro.third.client.ruilian.webservice.CancelPayNoteVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "CancelPayNoteRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.CancelPayNoteRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "cancelPayNoteReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("chargeCancel");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "xml"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "chargeCancelReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("chargeSuccess");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "xml"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "chargeSuccessReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("generateReceiptStock");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "grsvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GenerateReceiptStockVO"), com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptStockVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GenerateReceiptStockRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptStockRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "generateReceiptStockReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("generateReceiptIssue");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "grivo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GenerateReceiptIssueVO"), com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptIssueVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GenerateReceiptIssueRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptIssueRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "generateReceiptIssueReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("batchVoidReceipt");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "xml"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "batchVoidReceiptReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("receiptDisableXml");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "xml"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "receiptDisableXmlReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Login1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "loginonevo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "Login1VO"), com.zyxy.service.micro.third.client.ruilian.webservice.Login1VO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "Login1RetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.Login1RetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "Login1Return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Login");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "loginvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "LoginVO"), com.zyxy.service.micro.third.client.ruilian.webservice.LoginVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "LoginRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.LoginRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "LoginReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Login2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "logintwovo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "Login2VO"), com.zyxy.service.micro.third.client.ruilian.webservice.Login2VO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "Login2RetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.Login2RetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "Login2Return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("generatePayNote");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "gpnvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteVO"), com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "generatePayNoteReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("generatePayNoteZK");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "gpnvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteZKVO"), com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteZKVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteZKRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteZKRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "generatePayNoteZKReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("generatePayNoteCG");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "gpnvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteCGVO"), com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteCGVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "generatePayNoteCGReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("generatePayNoteGt");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "gpngtvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteGTVO"), com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteGTVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "generatePayNoteGtReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchPayNote");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "spnvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SearchPayNoteVO"), com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SearchPayNoteRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "searchPayNoteReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchPnnos");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "spnvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SearchPayNoteVO"), com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SearchPayNoteRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "searchPnnosReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cancelReceiptStock");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "crsvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "CancelReceiptStockVO"), com.zyxy.service.micro.third.client.ruilian.webservice.CancelReceiptStockVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "CancelReceiptStockRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.CancelReceiptStockRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "cancelReceiptStockReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("sendReceiptInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "srivo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SendReceiptInfoVO"), com.zyxy.service.micro.third.client.ruilian.webservice.SendReceiptInfoVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SendReceiptInfoRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.SendReceiptInfoRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "sendReceiptInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("generatePenaltyPN");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "gplnvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePenaltyPNVO"), com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePenaltyPNVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePenaltyPNRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePenaltyPNRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "generatePenaltyPNReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cancelEnterStock");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "stockVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "CancelEnterStockVO"), com.zyxy.service.micro.third.client.ruilian.webservice.CancelEnterStockVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "CancelEnterStockRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.CancelEnterStockRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "cancelEnterStockReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("generatePayNoteMP");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "gpnvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteYDVO"), com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteYDVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteYDRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteYDRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "generatePayNoteMPReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("chargeRequestMP");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "gpnvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ChargeRequestVO"), com.zyxy.service.micro.third.client.ruilian.webservice.ChargeRequestVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ChargeRequestRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.ChargeRequestRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "chargeRequestMPReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("chargeConfirmMP");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "gpnvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ChargeConfirmVO"), com.zyxy.service.micro.third.client.ruilian.webservice.ChargeConfirmVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ChargeConfirmRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.ChargeConfirmRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "chargeConfirmMPReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("receiptPrintMP");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "gpnvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ReceiptPrintVO"), com.zyxy.service.micro.third.client.ruilian.webservice.ReceiptPrintVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ReceiptPrintRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.ReceiptPrintRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "receiptPrintMPReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("switchReceiptMP");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "gpnvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SwitchReceiptVO"), com.zyxy.service.micro.third.client.ruilian.webservice.SwitchReceiptVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SwitchReceiptRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.SwitchReceiptRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "switchReceiptMPReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchPayNoteMP");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "gpnvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SearchPayNoteYDVO"), com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteYDVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SearchPayNoteYDRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteYDRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "searchPayNoteMPReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchReceiptMP");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "gpnvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SearchReceiptYDVO"), com.zyxy.service.micro.third.client.ruilian.webservice.SearchReceiptYDVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SearchReceiptInfoRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.SearchReceiptInfoRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "searchReceiptMPReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("reviseReceiptMP");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "gpnvo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ReviseReceiptVO"), com.zyxy.service.micro.third.client.ruilian.webservice.ReviseReceiptVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ReviseReceiptRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.ReviseReceiptRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "reviseReceiptMPReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("outStorage");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "outStorageVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "OutStorageVO"), com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "OutStorageRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "outStorageReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[37] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("inStorage");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "inStorageVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "InStorageVO"), com.zyxy.service.micro.third.client.ruilian.webservice.InStorageVO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "InStorageRetVO"));
        oper.setReturnClass(com.zyxy.service.micro.third.client.ruilian.webservice.InStorageRetVO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "inStorageReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("receiptStockXml");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "xml"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "receiptStockXmlReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[39] = oper;

    }

    private static void _initOperationDesc5(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("listToString");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "list"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "ArrayOf_xsd_anyType"), java.lang.Object[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "ArrayOf_xsd_string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "listToStringReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[40] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("generateTKSQ");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "xml"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "generateTKSQReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[41] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getParm");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parmmap"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Map"), java.util.HashMap.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dftValue"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        oper.setReturnClass(short.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getParmReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[42] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getParm");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parmmap"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Map"), java.util.HashMap.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dftValue"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        oper.setReturnClass(double.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getParmReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[43] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getParm");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parmmap"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Map"), java.util.HashMap.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dftValue"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getParmReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[44] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getParm");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parmmap"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Map"), java.util.HashMap.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dftValue"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getParmReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[45] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getParm");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parmmap"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Map"), java.util.HashMap.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dftValue"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getParmReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[46] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getParm");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "strKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parmmap"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Map"), java.util.HashMap.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dftValue"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getParmReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[47] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("formatStr");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "str"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "formatStrReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[48] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("toMonthChinese");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "month"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "toMonthChineseReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[49] = oper;

    }

    private static void _initOperationDesc6(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("toChineseYear");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "year"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "toChineseYearReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[50] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("toDayChinese");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "day"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "toDayChineseReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[51] = oper;

    }

    public ExternalInterfaceWSSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ExternalInterfaceWSSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ExternalInterfaceWSSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://common.webservices.gfmis.todaytech.com", "BaseWssVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.BaseWssVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://common.webservices.gfmis.todaytech.com", "GenericRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GenericRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://common.webservices.gfmis.todaytech.com", "GenericVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GenericVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "ArrayOf_tns1_GenerateReceiptIssueSubVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptIssueSubVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GenerateReceiptIssueSubVO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "ArrayOf_tns1_InStorageDetailVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.InStorageDetailVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "InStorageDetailVO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "ArrayOf_tns1_OutStorageDetailVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageDetailVO[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "OutStorageDetailVO");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "ArrayOf_xsd_anyType");
            cachedSerQNames.add(qName);
            cls = java.lang.Object[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "ArrayOf_xsd_string");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "CancelEnterStockRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.CancelEnterStockRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "CancelEnterStockVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.CancelEnterStockVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "CancelPayNoteRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.CancelPayNoteRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "CancelPayNoteVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.CancelPayNoteVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "CancelReceiptStockRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.CancelReceiptStockRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "CancelReceiptStockVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.CancelReceiptStockVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ChargeConfirmRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.ChargeConfirmRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ChargeConfirmVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.ChargeConfirmVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ChargeRequestRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.ChargeRequestRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ChargeRequestVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.ChargeRequestVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "EnterStockRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.EnterStockRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "EnterStockVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.EnterStockVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteCGVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteCGVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteGTVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteGTVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteYDRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteYDRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteYDVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteYDVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteZKRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteZKRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteZKVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteZKVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePenaltyPNRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePenaltyPNRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePenaltyPNVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePenaltyPNVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GenerateReceiptIssueRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptIssueRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GenerateReceiptIssueSubVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptIssueSubVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GenerateReceiptIssueVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptIssueVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GenerateReceiptStockRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptStockRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GenerateReceiptStockVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptStockVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "InStorageDetailVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.InStorageDetailVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "InStorageRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.InStorageRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "InStorageVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.InStorageVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "Login1RetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.Login1RetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "Login1VO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.Login1VO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "Login2RetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.Login2RetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "Login2VO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.Login2VO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "LoginRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.LoginRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "LoginVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.LoginVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "LogoutRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.LogoutRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "LogoutVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.LogoutVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "OutStorageDetailVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageDetailVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "OutStorageRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "OutStorageVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ReceiptPrintRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.ReceiptPrintRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ReceiptPrintVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.ReceiptPrintVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ReviseReceiptRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.ReviseReceiptRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ReviseReceiptVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.ReviseReceiptVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SearchPayNoteRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SearchPayNoteVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SearchPayNoteYDRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteYDRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SearchPayNoteYDVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteYDVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SearchReceiptInfoRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.SearchReceiptInfoRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SearchReceiptYDVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.SearchReceiptYDVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SendReceiptInfoRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.SendReceiptInfoRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SendReceiptInfoVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.SendReceiptInfoVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SwitchReceiptRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.SwitchReceiptRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SwitchReceiptVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.SwitchReceiptVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "YdzsReceiptStockTempRetVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.YdzsReceiptStockTempRetVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "YdzsReceiptStockTempVO");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.YdzsReceiptStockTempVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "mapItem");
            cachedSerQNames.add(qName);
            cls = com.zyxy.service.micro.third.client.ruilian.webservice.MapItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public void main(java.lang.String[] args) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "main"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {args});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.LogoutRetVO logout(com.zyxy.service.micro.third.client.ruilian.webservice.LogoutVO lpvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "logout"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {lpvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.LogoutRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.LogoutRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.LogoutRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String receiptTypeToFS(java.lang.String xml) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "receiptTypeToFS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {xml});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String unitReceiptTypeToFS(java.lang.String xml) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "unitReceiptTypeToFS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {xml});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.YdzsReceiptStockTempRetVO getYdzsReceiptStock(com.zyxy.service.micro.third.client.ruilian.webservice.YdzsReceiptStockTempVO yrstVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "getYdzsReceiptStock"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {yrstVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.YdzsReceiptStockTempRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.YdzsReceiptStockTempRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.YdzsReceiptStockTempRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String unitToFS(java.lang.String xml) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "unitToFS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {xml});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String sysUserToFS(java.lang.String xml) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "sysUserToFS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {xml});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.EnterStockRetVO enterStock(com.zyxy.service.micro.third.client.ruilian.webservice.EnterStockVO stockVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "enterStock"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {stockVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.EnterStockRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.EnterStockRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.EnterStockRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String chargeRequest(java.lang.String xml) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "chargeRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {xml});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.CancelPayNoteRetVO cancelPayNote(com.zyxy.service.micro.third.client.ruilian.webservice.CancelPayNoteVO cpnvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "cancelPayNote"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cpnvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.CancelPayNoteRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.CancelPayNoteRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.CancelPayNoteRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String chargeCancel(java.lang.String xml) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "chargeCancel"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {xml});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String chargeSuccess(java.lang.String xml) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "chargeSuccess"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {xml});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptStockRetVO generateReceiptStock(com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptStockVO grsvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "generateReceiptStock"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {grsvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptStockRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptStockRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptStockRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptIssueRetVO generateReceiptIssue(com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptIssueVO grivo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "generateReceiptIssue"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {grivo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptIssueRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptIssueRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptIssueRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String batchVoidReceipt(java.lang.String xml) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "batchVoidReceipt"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {xml});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String receiptDisableXml(java.lang.String xml) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "receiptDisableXml"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {xml});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.Login1RetVO login1(com.zyxy.service.micro.third.client.ruilian.webservice.Login1VO loginonevo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "Login1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {loginonevo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.Login1RetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.Login1RetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.Login1RetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.LoginRetVO login(com.zyxy.service.micro.third.client.ruilian.webservice.LoginVO loginvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "Login"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {loginvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.LoginRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.LoginRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.LoginRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.Login2RetVO login2(com.zyxy.service.micro.third.client.ruilian.webservice.Login2VO logintwovo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "Login2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {logintwovo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.Login2RetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.Login2RetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.Login2RetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO generatePayNote(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteVO gpnvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "generatePayNote"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {gpnvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteZKRetVO generatePayNoteZK(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteZKVO gpnvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "generatePayNoteZK"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {gpnvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteZKRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteZKRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteZKRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO generatePayNoteCG(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteCGVO gpnvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "generatePayNoteCG"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {gpnvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO generatePayNoteGt(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteGTVO gpngtvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "generatePayNoteGt"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {gpngtvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteRetVO searchPayNote(com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteVO spnvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "searchPayNote"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {spnvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteRetVO searchPnnos(com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteVO spnvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "searchPnnos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {spnvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.CancelReceiptStockRetVO cancelReceiptStock(com.zyxy.service.micro.third.client.ruilian.webservice.CancelReceiptStockVO crsvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "cancelReceiptStock"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {crsvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.CancelReceiptStockRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.CancelReceiptStockRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.CancelReceiptStockRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.SendReceiptInfoRetVO sendReceiptInfo(com.zyxy.service.micro.third.client.ruilian.webservice.SendReceiptInfoVO srivo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "sendReceiptInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {srivo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.SendReceiptInfoRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.SendReceiptInfoRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.SendReceiptInfoRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePenaltyPNRetVO generatePenaltyPN(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePenaltyPNVO gplnvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "generatePenaltyPN"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {gplnvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePenaltyPNRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePenaltyPNRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePenaltyPNRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.CancelEnterStockRetVO cancelEnterStock(com.zyxy.service.micro.third.client.ruilian.webservice.CancelEnterStockVO stockVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "cancelEnterStock"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {stockVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.CancelEnterStockRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.CancelEnterStockRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.CancelEnterStockRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteYDRetVO generatePayNoteMP(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteYDVO gpnvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "generatePayNoteMP"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {gpnvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteYDRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteYDRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteYDRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.ChargeRequestRetVO chargeRequestMP(com.zyxy.service.micro.third.client.ruilian.webservice.ChargeRequestVO gpnvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "chargeRequestMP"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {gpnvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.ChargeRequestRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.ChargeRequestRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.ChargeRequestRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.ChargeConfirmRetVO chargeConfirmMP(com.zyxy.service.micro.third.client.ruilian.webservice.ChargeConfirmVO gpnvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "chargeConfirmMP"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {gpnvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.ChargeConfirmRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.ChargeConfirmRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.ChargeConfirmRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.ReceiptPrintRetVO receiptPrintMP(com.zyxy.service.micro.third.client.ruilian.webservice.ReceiptPrintVO gpnvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "receiptPrintMP"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {gpnvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.ReceiptPrintRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.ReceiptPrintRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.ReceiptPrintRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.SwitchReceiptRetVO switchReceiptMP(com.zyxy.service.micro.third.client.ruilian.webservice.SwitchReceiptVO gpnvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "switchReceiptMP"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {gpnvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.SwitchReceiptRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.SwitchReceiptRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.SwitchReceiptRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteYDRetVO searchPayNoteMP(com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteYDVO gpnvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "searchPayNoteMP"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {gpnvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteYDRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteYDRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteYDRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.SearchReceiptInfoRetVO searchReceiptMP(com.zyxy.service.micro.third.client.ruilian.webservice.SearchReceiptYDVO gpnvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "searchReceiptMP"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {gpnvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.SearchReceiptInfoRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.SearchReceiptInfoRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.SearchReceiptInfoRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.ReviseReceiptRetVO reviseReceiptMP(com.zyxy.service.micro.third.client.ruilian.webservice.ReviseReceiptVO gpnvo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "reviseReceiptMP"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {gpnvo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.ReviseReceiptRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.ReviseReceiptRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.ReviseReceiptRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageRetVO outStorage(com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageVO outStorageVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "outStorage"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {outStorageVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.zyxy.service.micro.third.client.ruilian.webservice.InStorageRetVO inStorage(com.zyxy.service.micro.third.client.ruilian.webservice.InStorageVO inStorageVO) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "inStorage"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inStorageVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.InStorageRetVO) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.zyxy.service.micro.third.client.ruilian.webservice.InStorageRetVO) org.apache.axis.utils.JavaUtils.convert(_resp, com.zyxy.service.micro.third.client.ruilian.webservice.InStorageRetVO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String receiptStockXml(java.lang.String xml) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "receiptStockXml"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {xml});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] listToString(java.lang.Object[] list) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "listToString"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {list});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String generateTKSQ(java.lang.String xml) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[41]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "generateTKSQ"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {xml});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public short getParm(java.lang.String strKey, java.util.HashMap parmmap, short dftValue) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[42]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "getParm"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {strKey, parmmap, new java.lang.Short(dftValue)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Short) _resp).shortValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Short) org.apache.axis.utils.JavaUtils.convert(_resp, short.class)).shortValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public double getParm(java.lang.String strKey, java.util.HashMap parmmap, double dftValue) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[43]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "getParm"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {strKey, parmmap, new java.lang.Double(dftValue)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Double) _resp).doubleValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Double) org.apache.axis.utils.JavaUtils.convert(_resp, double.class)).doubleValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean getParm(java.lang.String strKey, java.util.HashMap parmmap, boolean dftValue) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[44]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "getParm"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {strKey, parmmap, new java.lang.Boolean(dftValue)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String getParm(java.lang.String strKey, java.util.HashMap parmmap, java.lang.String dftValue) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[45]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "getParm"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {strKey, parmmap, dftValue});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public long getParm(java.lang.String strKey, java.util.HashMap parmmap, long dftValue) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[46]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "getParm"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {strKey, parmmap, new java.lang.Long(dftValue)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Long) _resp).longValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, long.class)).longValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int getParm(java.lang.String strKey, java.util.HashMap parmmap, int dftValue) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[47]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "getParm"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {strKey, parmmap, new java.lang.Integer(dftValue)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String formatStr(java.lang.String str) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[48]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "formatStr"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {str});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String toMonthChinese(int month) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[49]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "toMonthChinese"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(month)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String toChineseYear(java.lang.String year) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[50]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "toChineseYear"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {year});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String toDayChinese(int day) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[51]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://face.webservices.gfmis.todaytech.com", "toDayChinese"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(day)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
