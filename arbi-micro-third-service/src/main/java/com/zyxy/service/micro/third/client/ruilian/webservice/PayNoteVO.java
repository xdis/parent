/**
 * PayNoteVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class PayNoteVO  implements java.io.Serializable {
    private java.lang.String loginKey;

    private java.lang.String pnNO;

    private java.lang.String unitNO;

    public PayNoteVO() {
    }

    public PayNoteVO(
           java.lang.String loginKey,
           java.lang.String pnNO,
           java.lang.String unitNO) {
           this.loginKey = loginKey;
           this.pnNO = pnNO;
           this.unitNO = unitNO;
    }


    /**
     * Gets the loginKey value for this PayNoteVO.
     * 
     * @return loginKey
     */
    public java.lang.String getLoginKey() {
        return loginKey;
    }


    /**
     * Sets the loginKey value for this PayNoteVO.
     * 
     * @param loginKey
     */
    public void setLoginKey(java.lang.String loginKey) {
        this.loginKey = loginKey;
    }


    /**
     * Gets the pnNO value for this PayNoteVO.
     * 
     * @return pnNO
     */
    public java.lang.String getPnNO() {
        return pnNO;
    }


    /**
     * Sets the pnNO value for this PayNoteVO.
     * 
     * @param pnNO
     */
    public void setPnNO(java.lang.String pnNO) {
        this.pnNO = pnNO;
    }


    /**
     * Gets the unitNO value for this PayNoteVO.
     * 
     * @return unitNO
     */
    public java.lang.String getUnitNO() {
        return unitNO;
    }


    /**
     * Sets the unitNO value for this PayNoteVO.
     * 
     * @param unitNO
     */
    public void setUnitNO(java.lang.String unitNO) {
        this.unitNO = unitNO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PayNoteVO)) return false;
        PayNoteVO other = (PayNoteVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.loginKey==null && other.getLoginKey()==null) || 
             (this.loginKey!=null &&
              this.loginKey.equals(other.getLoginKey()))) &&
            ((this.pnNO==null && other.getPnNO()==null) || 
             (this.pnNO!=null &&
              this.pnNO.equals(other.getPnNO()))) &&
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
        int _hashCode = 1;
        if (getLoginKey() != null) {
            _hashCode += getLoginKey().hashCode();
        }
        if (getPnNO() != null) {
            _hashCode += getPnNO().hashCode();
        }
        if (getUnitNO() != null) {
            _hashCode += getUnitNO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PayNoteVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "PayNoteVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "loginKey"));
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
