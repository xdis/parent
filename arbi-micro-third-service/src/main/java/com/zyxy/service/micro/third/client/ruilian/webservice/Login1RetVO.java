/**
 * Login1RetVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class Login1RetVO  implements java.io.Serializable {
    private java.lang.String randomNum;

    private java.lang.String reason;

    private java.lang.String returnCode;

    private java.lang.String serverEcptCert;

    private java.lang.String serverSignCert;

    private java.lang.String signature;

    public Login1RetVO() {
    }

    public Login1RetVO(
           java.lang.String randomNum,
           java.lang.String reason,
           java.lang.String returnCode,
           java.lang.String serverEcptCert,
           java.lang.String serverSignCert,
           java.lang.String signature) {
           this.randomNum = randomNum;
           this.reason = reason;
           this.returnCode = returnCode;
           this.serverEcptCert = serverEcptCert;
           this.serverSignCert = serverSignCert;
           this.signature = signature;
    }


    /**
     * Gets the randomNum value for this Login1RetVO.
     * 
     * @return randomNum
     */
    public java.lang.String getRandomNum() {
        return randomNum;
    }


    /**
     * Sets the randomNum value for this Login1RetVO.
     * 
     * @param randomNum
     */
    public void setRandomNum(java.lang.String randomNum) {
        this.randomNum = randomNum;
    }


    /**
     * Gets the reason value for this Login1RetVO.
     * 
     * @return reason
     */
    public java.lang.String getReason() {
        return reason;
    }


    /**
     * Sets the reason value for this Login1RetVO.
     * 
     * @param reason
     */
    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }


    /**
     * Gets the returnCode value for this Login1RetVO.
     * 
     * @return returnCode
     */
    public java.lang.String getReturnCode() {
        return returnCode;
    }


    /**
     * Sets the returnCode value for this Login1RetVO.
     * 
     * @param returnCode
     */
    public void setReturnCode(java.lang.String returnCode) {
        this.returnCode = returnCode;
    }


    /**
     * Gets the serverEcptCert value for this Login1RetVO.
     * 
     * @return serverEcptCert
     */
    public java.lang.String getServerEcptCert() {
        return serverEcptCert;
    }


    /**
     * Sets the serverEcptCert value for this Login1RetVO.
     * 
     * @param serverEcptCert
     */
    public void setServerEcptCert(java.lang.String serverEcptCert) {
        this.serverEcptCert = serverEcptCert;
    }


    /**
     * Gets the serverSignCert value for this Login1RetVO.
     * 
     * @return serverSignCert
     */
    public java.lang.String getServerSignCert() {
        return serverSignCert;
    }


    /**
     * Sets the serverSignCert value for this Login1RetVO.
     * 
     * @param serverSignCert
     */
    public void setServerSignCert(java.lang.String serverSignCert) {
        this.serverSignCert = serverSignCert;
    }


    /**
     * Gets the signature value for this Login1RetVO.
     * 
     * @return signature
     */
    public java.lang.String getSignature() {
        return signature;
    }


    /**
     * Sets the signature value for this Login1RetVO.
     * 
     * @param signature
     */
    public void setSignature(java.lang.String signature) {
        this.signature = signature;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Login1RetVO)) return false;
        Login1RetVO other = (Login1RetVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.randomNum==null && other.getRandomNum()==null) || 
             (this.randomNum!=null &&
              this.randomNum.equals(other.getRandomNum()))) &&
            ((this.reason==null && other.getReason()==null) || 
             (this.reason!=null &&
              this.reason.equals(other.getReason()))) &&
            ((this.returnCode==null && other.getReturnCode()==null) || 
             (this.returnCode!=null &&
              this.returnCode.equals(other.getReturnCode()))) &&
            ((this.serverEcptCert==null && other.getServerEcptCert()==null) || 
             (this.serverEcptCert!=null &&
              this.serverEcptCert.equals(other.getServerEcptCert()))) &&
            ((this.serverSignCert==null && other.getServerSignCert()==null) || 
             (this.serverSignCert!=null &&
              this.serverSignCert.equals(other.getServerSignCert()))) &&
            ((this.signature==null && other.getSignature()==null) || 
             (this.signature!=null &&
              this.signature.equals(other.getSignature())));
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
        if (getRandomNum() != null) {
            _hashCode += getRandomNum().hashCode();
        }
        if (getReason() != null) {
            _hashCode += getReason().hashCode();
        }
        if (getReturnCode() != null) {
            _hashCode += getReturnCode().hashCode();
        }
        if (getServerEcptCert() != null) {
            _hashCode += getServerEcptCert().hashCode();
        }
        if (getServerSignCert() != null) {
            _hashCode += getServerSignCert().hashCode();
        }
        if (getSignature() != null) {
            _hashCode += getSignature().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Login1RetVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "Login1RetVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("randomNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "randomNum"));
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
        elemField.setFieldName("returnCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "returnCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serverEcptCert");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serverEcptCert"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serverSignCert");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serverSignCert"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signature");
        elemField.setXmlName(new javax.xml.namespace.QName("", "signature"));
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
