/**
 * GeneratePenaltyPNVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class GeneratePenaltyPNVO  extends com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteVO  implements java.io.Serializable {
    private java.lang.String additionalAmount;

    private java.lang.String additionalReason;

    private java.lang.String penaltyBookNo;

    private java.lang.String penaltyReason;

    public GeneratePenaltyPNVO() {
    }

    public GeneratePenaltyPNVO(
           java.lang.String loginKey,
           int chargeItemCount,
           java.lang.String chargeItemNO1,
           java.lang.String chargeItemNO2,
           java.lang.String chargeItemNO3,
           java.lang.String checkDigitAll,
           java.lang.String checkDigitNO,
           java.lang.String createTM,
           java.lang.String overdueAmt1,
           java.lang.String overdueAmt2,
           java.lang.String overdueAmt3,
           java.lang.String overdueDT,
           java.lang.String payerName,
           java.lang.String pnNO,
           java.lang.String price1,
           java.lang.String price2,
           java.lang.String price3,
           java.lang.String quantity1,
           java.lang.String quantity2,
           java.lang.String quantity3,
           java.lang.String receivableAmt,
           java.lang.String relateUserName,
           java.lang.String remark,
           java.lang.String unitNO,
           java.lang.String additionalAmount,
           java.lang.String additionalReason,
           java.lang.String penaltyBookNo,
           java.lang.String penaltyReason) {
        super(
            loginKey,
            chargeItemCount,
            chargeItemNO1,
            chargeItemNO2,
            chargeItemNO3,
            checkDigitAll,
            checkDigitNO,
            createTM,
            overdueAmt1,
            overdueAmt2,
            overdueAmt3,
            overdueDT,
            payerName,
            pnNO,
            price1,
            price2,
            price3,
            quantity1,
            quantity2,
            quantity3,
            receivableAmt,
            relateUserName,
            remark,
            unitNO);
        this.additionalAmount = additionalAmount;
        this.additionalReason = additionalReason;
        this.penaltyBookNo = penaltyBookNo;
        this.penaltyReason = penaltyReason;
    }


    /**
     * Gets the additionalAmount value for this GeneratePenaltyPNVO.
     * 
     * @return additionalAmount
     */
    public java.lang.String getAdditionalAmount() {
        return additionalAmount;
    }


    /**
     * Sets the additionalAmount value for this GeneratePenaltyPNVO.
     * 
     * @param additionalAmount
     */
    public void setAdditionalAmount(java.lang.String additionalAmount) {
        this.additionalAmount = additionalAmount;
    }


    /**
     * Gets the additionalReason value for this GeneratePenaltyPNVO.
     * 
     * @return additionalReason
     */
    public java.lang.String getAdditionalReason() {
        return additionalReason;
    }


    /**
     * Sets the additionalReason value for this GeneratePenaltyPNVO.
     * 
     * @param additionalReason
     */
    public void setAdditionalReason(java.lang.String additionalReason) {
        this.additionalReason = additionalReason;
    }


    /**
     * Gets the penaltyBookNo value for this GeneratePenaltyPNVO.
     * 
     * @return penaltyBookNo
     */
    public java.lang.String getPenaltyBookNo() {
        return penaltyBookNo;
    }


    /**
     * Sets the penaltyBookNo value for this GeneratePenaltyPNVO.
     * 
     * @param penaltyBookNo
     */
    public void setPenaltyBookNo(java.lang.String penaltyBookNo) {
        this.penaltyBookNo = penaltyBookNo;
    }


    /**
     * Gets the penaltyReason value for this GeneratePenaltyPNVO.
     * 
     * @return penaltyReason
     */
    public java.lang.String getPenaltyReason() {
        return penaltyReason;
    }


    /**
     * Sets the penaltyReason value for this GeneratePenaltyPNVO.
     * 
     * @param penaltyReason
     */
    public void setPenaltyReason(java.lang.String penaltyReason) {
        this.penaltyReason = penaltyReason;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GeneratePenaltyPNVO)) return false;
        GeneratePenaltyPNVO other = (GeneratePenaltyPNVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.additionalAmount==null && other.getAdditionalAmount()==null) || 
             (this.additionalAmount!=null &&
              this.additionalAmount.equals(other.getAdditionalAmount()))) &&
            ((this.additionalReason==null && other.getAdditionalReason()==null) || 
             (this.additionalReason!=null &&
              this.additionalReason.equals(other.getAdditionalReason()))) &&
            ((this.penaltyBookNo==null && other.getPenaltyBookNo()==null) || 
             (this.penaltyBookNo!=null &&
              this.penaltyBookNo.equals(other.getPenaltyBookNo()))) &&
            ((this.penaltyReason==null && other.getPenaltyReason()==null) || 
             (this.penaltyReason!=null &&
              this.penaltyReason.equals(other.getPenaltyReason())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getAdditionalAmount() != null) {
            _hashCode += getAdditionalAmount().hashCode();
        }
        if (getAdditionalReason() != null) {
            _hashCode += getAdditionalReason().hashCode();
        }
        if (getPenaltyBookNo() != null) {
            _hashCode += getPenaltyBookNo().hashCode();
        }
        if (getPenaltyReason() != null) {
            _hashCode += getPenaltyReason().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GeneratePenaltyPNVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePenaltyPNVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("additionalAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "additionalAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("additionalReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "additionalReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("penaltyBookNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "penaltyBookNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("penaltyReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "penaltyReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
