/**
 * YdzsReceiptStockTempVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class YdzsReceiptStockTempVO  implements java.io.Serializable {
    private java.lang.String rtid;

    private java.lang.String unitid;

    public YdzsReceiptStockTempVO() {
    }

    public YdzsReceiptStockTempVO(
           java.lang.String rtid,
           java.lang.String unitid) {
           this.rtid = rtid;
           this.unitid = unitid;
    }


    /**
     * Gets the rtid value for this YdzsReceiptStockTempVO.
     * 
     * @return rtid
     */
    public java.lang.String getRtid() {
        return rtid;
    }


    /**
     * Sets the rtid value for this YdzsReceiptStockTempVO.
     * 
     * @param rtid
     */
    public void setRtid(java.lang.String rtid) {
        this.rtid = rtid;
    }


    /**
     * Gets the unitid value for this YdzsReceiptStockTempVO.
     * 
     * @return unitid
     */
    public java.lang.String getUnitid() {
        return unitid;
    }


    /**
     * Sets the unitid value for this YdzsReceiptStockTempVO.
     * 
     * @param unitid
     */
    public void setUnitid(java.lang.String unitid) {
        this.unitid = unitid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof YdzsReceiptStockTempVO)) return false;
        YdzsReceiptStockTempVO other = (YdzsReceiptStockTempVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.rtid==null && other.getRtid()==null) || 
             (this.rtid!=null &&
              this.rtid.equals(other.getRtid()))) &&
            ((this.unitid==null && other.getUnitid()==null) || 
             (this.unitid!=null &&
              this.unitid.equals(other.getUnitid())));
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
        if (getRtid() != null) {
            _hashCode += getRtid().hashCode();
        }
        if (getUnitid() != null) {
            _hashCode += getUnitid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(YdzsReceiptStockTempVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "YdzsReceiptStockTempVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rtid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rtid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unitid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unitid"));
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
