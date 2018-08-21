/**
 * Login2VO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class Login2VO  implements java.io.Serializable {
    private java.lang.String disaID;

    private java.lang.String randomNum;

    private java.lang.String signature;

    public Login2VO() {
    }

    public Login2VO(
           java.lang.String disaID,
           java.lang.String randomNum,
           java.lang.String signature) {
           this.disaID = disaID;
           this.randomNum = randomNum;
           this.signature = signature;
    }


    /**
     * Gets the disaID value for this Login2VO.
     * 
     * @return disaID
     */
    public java.lang.String getDisaID() {
        return disaID;
    }


    /**
     * Sets the disaID value for this Login2VO.
     * 
     * @param disaID
     */
    public void setDisaID(java.lang.String disaID) {
        this.disaID = disaID;
    }


    /**
     * Gets the randomNum value for this Login2VO.
     * 
     * @return randomNum
     */
    public java.lang.String getRandomNum() {
        return randomNum;
    }


    /**
     * Sets the randomNum value for this Login2VO.
     * 
     * @param randomNum
     */
    public void setRandomNum(java.lang.String randomNum) {
        this.randomNum = randomNum;
    }


    /**
     * Gets the signature value for this Login2VO.
     * 
     * @return signature
     */
    public java.lang.String getSignature() {
        return signature;
    }


    /**
     * Sets the signature value for this Login2VO.
     * 
     * @param signature
     */
    public void setSignature(java.lang.String signature) {
        this.signature = signature;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Login2VO)) return false;
        Login2VO other = (Login2VO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.disaID==null && other.getDisaID()==null) || 
             (this.disaID!=null &&
              this.disaID.equals(other.getDisaID()))) &&
            ((this.randomNum==null && other.getRandomNum()==null) || 
             (this.randomNum!=null &&
              this.randomNum.equals(other.getRandomNum()))) &&
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
        if (getDisaID() != null) {
            _hashCode += getDisaID().hashCode();
        }
        if (getRandomNum() != null) {
            _hashCode += getRandomNum().hashCode();
        }
        if (getSignature() != null) {
            _hashCode += getSignature().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Login2VO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "Login2VO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("disaID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "disaID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("randomNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "randomNum"));
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
