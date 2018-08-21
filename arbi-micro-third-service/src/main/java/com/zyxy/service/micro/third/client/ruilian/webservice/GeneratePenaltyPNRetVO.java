/**
 * GeneratePenaltyPNRetVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class GeneratePenaltyPNRetVO  extends com.zyxy.service.micro.third.client.ruilian.webservice.GenericRetVO  implements java.io.Serializable {
    private java.lang.String paynoteNO;

    public GeneratePenaltyPNRetVO() {
    }

    public GeneratePenaltyPNRetVO(
           java.lang.String reason,
           java.lang.String returnCode,
           java.lang.String paynoteNO) {
        super(
            reason,
            returnCode);
        this.paynoteNO = paynoteNO;
    }


    /**
     * Gets the paynoteNO value for this GeneratePenaltyPNRetVO.
     * 
     * @return paynoteNO
     */
    public java.lang.String getPaynoteNO() {
        return paynoteNO;
    }


    /**
     * Sets the paynoteNO value for this GeneratePenaltyPNRetVO.
     * 
     * @param paynoteNO
     */
    public void setPaynoteNO(java.lang.String paynoteNO) {
        this.paynoteNO = paynoteNO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GeneratePenaltyPNRetVO)) return false;
        GeneratePenaltyPNRetVO other = (GeneratePenaltyPNRetVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.paynoteNO==null && other.getPaynoteNO()==null) || 
             (this.paynoteNO!=null &&
              this.paynoteNO.equals(other.getPaynoteNO())));
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
        if (getPaynoteNO() != null) {
            _hashCode += getPaynoteNO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GeneratePenaltyPNRetVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePenaltyPNRetVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paynoteNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paynoteNO"));
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
