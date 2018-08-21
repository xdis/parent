/**
 * Login1VO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class Login1VO  implements java.io.Serializable {
    private java.lang.String clientSignCert;

    private java.lang.String disaID;

    public Login1VO() {
    }

    public Login1VO(
           java.lang.String clientSignCert,
           java.lang.String disaID) {
           this.clientSignCert = clientSignCert;
           this.disaID = disaID;
    }


    /**
     * Gets the clientSignCert value for this Login1VO.
     * 
     * @return clientSignCert
     */
    public java.lang.String getClientSignCert() {
        return clientSignCert;
    }


    /**
     * Sets the clientSignCert value for this Login1VO.
     * 
     * @param clientSignCert
     */
    public void setClientSignCert(java.lang.String clientSignCert) {
        this.clientSignCert = clientSignCert;
    }


    /**
     * Gets the disaID value for this Login1VO.
     * 
     * @return disaID
     */
    public java.lang.String getDisaID() {
        return disaID;
    }


    /**
     * Sets the disaID value for this Login1VO.
     * 
     * @param disaID
     */
    public void setDisaID(java.lang.String disaID) {
        this.disaID = disaID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Login1VO)) return false;
        Login1VO other = (Login1VO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.clientSignCert==null && other.getClientSignCert()==null) || 
             (this.clientSignCert!=null &&
              this.clientSignCert.equals(other.getClientSignCert()))) &&
            ((this.disaID==null && other.getDisaID()==null) || 
             (this.disaID!=null &&
              this.disaID.equals(other.getDisaID())));
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
        if (getClientSignCert() != null) {
            _hashCode += getClientSignCert().hashCode();
        }
        if (getDisaID() != null) {
            _hashCode += getDisaID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Login1VO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "Login1VO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientSignCert");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientSignCert"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("disaID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "disaID"));
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
