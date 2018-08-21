/**
 * ExternalInterfaceWS_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public interface ExternalInterfaceWS_PortType extends java.rmi.Remote {
    public void main(java.lang.String[] args) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.LogoutRetVO logout(com.zyxy.service.micro.third.client.ruilian.webservice.LogoutVO lpvo) throws java.rmi.RemoteException;
    public java.lang.String receiptTypeToFS(java.lang.String xml) throws java.rmi.RemoteException;
    public java.lang.String unitReceiptTypeToFS(java.lang.String xml) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.YdzsReceiptStockTempRetVO getYdzsReceiptStock(com.zyxy.service.micro.third.client.ruilian.webservice.YdzsReceiptStockTempVO yrstVO) throws java.rmi.RemoteException;
    public java.lang.String unitToFS(java.lang.String xml) throws java.rmi.RemoteException;
    public java.lang.String sysUserToFS(java.lang.String xml) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.EnterStockRetVO enterStock(com.zyxy.service.micro.third.client.ruilian.webservice.EnterStockVO stockVO) throws java.rmi.RemoteException;
    public java.lang.String chargeRequest(java.lang.String xml) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.CancelPayNoteRetVO cancelPayNote(com.zyxy.service.micro.third.client.ruilian.webservice.CancelPayNoteVO cpnvo) throws java.rmi.RemoteException;
    public java.lang.String chargeCancel(java.lang.String xml) throws java.rmi.RemoteException;
    public java.lang.String chargeSuccess(java.lang.String xml) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptStockRetVO generateReceiptStock(com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptStockVO grsvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptIssueRetVO generateReceiptIssue(com.zyxy.service.micro.third.client.ruilian.webservice.GenerateReceiptIssueVO grivo) throws java.rmi.RemoteException;
    public java.lang.String batchVoidReceipt(java.lang.String xml) throws java.rmi.RemoteException;
    public java.lang.String receiptDisableXml(java.lang.String xml) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.Login1RetVO login1(com.zyxy.service.micro.third.client.ruilian.webservice.Login1VO loginonevo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.LoginRetVO login(com.zyxy.service.micro.third.client.ruilian.webservice.LoginVO loginvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.Login2RetVO login2(com.zyxy.service.micro.third.client.ruilian.webservice.Login2VO logintwovo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO generatePayNote(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteVO gpnvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteZKRetVO generatePayNoteZK(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteZKVO gpnvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO generatePayNoteCG(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteCGVO gpnvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO generatePayNoteGt(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteGTVO gpngtvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteRetVO searchPayNote(com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteVO spnvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteRetVO searchPnnos(com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteVO spnvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.CancelReceiptStockRetVO cancelReceiptStock(com.zyxy.service.micro.third.client.ruilian.webservice.CancelReceiptStockVO crsvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.SendReceiptInfoRetVO sendReceiptInfo(com.zyxy.service.micro.third.client.ruilian.webservice.SendReceiptInfoVO srivo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePenaltyPNRetVO generatePenaltyPN(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePenaltyPNVO gplnvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.CancelEnterStockRetVO cancelEnterStock(com.zyxy.service.micro.third.client.ruilian.webservice.CancelEnterStockVO stockVO) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteYDRetVO generatePayNoteMP(com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteYDVO gpnvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.ChargeRequestRetVO chargeRequestMP(com.zyxy.service.micro.third.client.ruilian.webservice.ChargeRequestVO gpnvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.ChargeConfirmRetVO chargeConfirmMP(com.zyxy.service.micro.third.client.ruilian.webservice.ChargeConfirmVO gpnvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.ReceiptPrintRetVO receiptPrintMP(com.zyxy.service.micro.third.client.ruilian.webservice.ReceiptPrintVO gpnvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.SwitchReceiptRetVO switchReceiptMP(com.zyxy.service.micro.third.client.ruilian.webservice.SwitchReceiptVO gpnvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteYDRetVO searchPayNoteMP(com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteYDVO gpnvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.SearchReceiptInfoRetVO searchReceiptMP(com.zyxy.service.micro.third.client.ruilian.webservice.SearchReceiptYDVO gpnvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.ReviseReceiptRetVO reviseReceiptMP(com.zyxy.service.micro.third.client.ruilian.webservice.ReviseReceiptVO gpnvo) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageRetVO outStorage(com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageVO outStorageVO) throws java.rmi.RemoteException;
    public com.zyxy.service.micro.third.client.ruilian.webservice.InStorageRetVO inStorage(com.zyxy.service.micro.third.client.ruilian.webservice.InStorageVO inStorageVO) throws java.rmi.RemoteException;
    public java.lang.String receiptStockXml(java.lang.String xml) throws java.rmi.RemoteException;
    public java.lang.String[] listToString(java.lang.Object[] list) throws java.rmi.RemoteException;
    public java.lang.String generateTKSQ(java.lang.String xml) throws java.rmi.RemoteException;
    public short getParm(java.lang.String strKey, java.util.HashMap parmmap, short dftValue) throws java.rmi.RemoteException;
    public double getParm(java.lang.String strKey, java.util.HashMap parmmap, double dftValue) throws java.rmi.RemoteException;
    public boolean getParm(java.lang.String strKey, java.util.HashMap parmmap, boolean dftValue) throws java.rmi.RemoteException;
    public java.lang.String getParm(java.lang.String strKey, java.util.HashMap parmmap, java.lang.String dftValue) throws java.rmi.RemoteException;
    public long getParm(java.lang.String strKey, java.util.HashMap parmmap, long dftValue) throws java.rmi.RemoteException;
    public int getParm(java.lang.String strKey, java.util.HashMap parmmap, int dftValue) throws java.rmi.RemoteException;
    public java.lang.String formatStr(java.lang.String str) throws java.rmi.RemoteException;
    public java.lang.String toMonthChinese(int month) throws java.rmi.RemoteException;
    public java.lang.String toChineseYear(java.lang.String year) throws java.rmi.RemoteException;
    public java.lang.String toDayChinese(int day) throws java.rmi.RemoteException;
}
