/**
 * ReceiptPrintRetVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class ReceiptPrintRetVO  extends com.zyxy.service.micro.third.client.ruilian.webservice.GenericRetVO  implements java.io.Serializable {
    private java.lang.String returnInfo;

    public ReceiptPrintRetVO() {
    }

    public ReceiptPrintRetVO(
           java.lang.String reason,
           java.lang.String returnCode,
           java.lang.String returnInfo) {
        super(
            reason,
            returnCode);
        this.returnInfo = returnInfo;
    }


    /**
     * Gets the returnInfo value for this ReceiptPrintRetVO.
     * 
     * @return returnInfo
     */
    public java.lang.String getReturnInfo() {
        return returnInfo;
    }


    /**
     * Sets the returnInfo value for this ReceiptPrintRetVO.
     * 
     * @param returnInfo
     */
    public void setReturnInfo(java.lang.String returnInfo) {
        this.returnInfo = returnInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReceiptPrintRetVO)) return false;
        ReceiptPrintRetVO other = (ReceiptPrintRetVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.returnInfo==null && other.getReturnInfo()==null) || 
             (this.returnInfo!=null &&
              this.returnInfo.equals(other.getReturnInfo())));
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
        if (getReturnInfo() != null) {
            _hashCode += getReturnInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReceiptPrintRetVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ReceiptPrintRetVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "returnInfo"));
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
