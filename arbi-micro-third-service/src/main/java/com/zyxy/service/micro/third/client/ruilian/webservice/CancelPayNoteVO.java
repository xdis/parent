/**
 * CancelPayNoteVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class CancelPayNoteVO  extends com.zyxy.service.micro.third.client.ruilian.webservice.GenericVO  implements java.io.Serializable {
    private java.lang.String checkDigitNO;

    private java.lang.String pnNO;

    private java.lang.String reason;

    private java.lang.String unitNO;

    public CancelPayNoteVO() {
    }

    public CancelPayNoteVO(
           java.lang.String loginKey,
           java.lang.String checkDigitNO,
           java.lang.String pnNO,
           java.lang.String reason,
           java.lang.String unitNO) {
        super(
            loginKey);
        this.checkDigitNO = checkDigitNO;
        this.pnNO = pnNO;
        this.reason = reason;
        this.unitNO = unitNO;
    }


    /**
     * Gets the checkDigitNO value for this CancelPayNoteVO.
     * 
     * @return checkDigitNO
     */
    public java.lang.String getCheckDigitNO() {
        return checkDigitNO;
    }


    /**
     * Sets the checkDigitNO value for this CancelPayNoteVO.
     * 
     * @param checkDigitNO
     */
    public void setCheckDigitNO(java.lang.String checkDigitNO) {
        this.checkDigitNO = checkDigitNO;
    }


    /**
     * Gets the pnNO value for this CancelPayNoteVO.
     * 
     * @return pnNO
     */
    public java.lang.String getPnNO() {
        return pnNO;
    }


    /**
     * Sets the pnNO value for this CancelPayNoteVO.
     * 
     * @param pnNO
     */
    public void setPnNO(java.lang.String pnNO) {
        this.pnNO = pnNO;
    }


    /**
     * Gets the reason value for this CancelPayNoteVO.
     * 
     * @return reason
     */
    public java.lang.String getReason() {
        return reason;
    }


    /**
     * Sets the reason value for this CancelPayNoteVO.
     * 
     * @param reason
     */
    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }


    /**
     * Gets the unitNO value for this CancelPayNoteVO.
     * 
     * @return unitNO
     */
    public java.lang.String getUnitNO() {
        return unitNO;
    }


    /**
     * Sets the unitNO value for this CancelPayNoteVO.
     * 
     * @param unitNO
     */
    public void setUnitNO(java.lang.String unitNO) {
        this.unitNO = unitNO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CancelPayNoteVO)) return false;
        CancelPayNoteVO other = (CancelPayNoteVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.checkDigitNO==null && other.getCheckDigitNO()==null) || 
             (this.checkDigitNO!=null &&
              this.checkDigitNO.equals(other.getCheckDigitNO()))) &&
            ((this.pnNO==null && other.getPnNO()==null) || 
             (this.pnNO!=null &&
              this.pnNO.equals(other.getPnNO()))) &&
            ((this.reason==null && other.getReason()==null) || 
             (this.reason!=null &&
              this.reason.equals(other.getReason()))) &&
            ((this.unitNO==null && other.getUnitNO()==null) || 
             (this.unitNO!=null &&
              this.unitNO.equals(other.getUnitNO())));
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
        if (getCheckDigitNO() != null) {
            _hashCode += getCheckDigitNO().hashCode();
        }
        if (getPnNO() != null) {
            _hashCode += getPnNO().hashCode();
        }
        if (getReason() != null) {
            _hashCode += getReason().hashCode();
        }
        if (getUnitNO() != null) {
            _hashCode += getUnitNO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CancelPayNoteVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "CancelPayNoteVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkDigitNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "checkDigitNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pnNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pnNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unitNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unitNO"));
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
