/**
 * ChargeRequestVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class ChargeRequestVO  implements java.io.Serializable {
    private java.lang.String bankNO;

    private java.lang.String loginKey;

    private java.lang.String payDate;

    private java.lang.String pnCheckCode;

    private java.lang.String pnNO;

    private java.lang.String receiptNO;

    private java.lang.String rtNO;

    private java.lang.String unitNO;

    public ChargeRequestVO() {
    }

    public ChargeRequestVO(
           java.lang.String bankNO,
           java.lang.String loginKey,
           java.lang.String payDate,
           java.lang.String pnCheckCode,
           java.lang.String pnNO,
           java.lang.String receiptNO,
           java.lang.String rtNO,
           java.lang.String unitNO) {
           this.bankNO = bankNO;
           this.loginKey = loginKey;
           this.payDate = payDate;
           this.pnCheckCode = pnCheckCode;
           this.pnNO = pnNO;
           this.receiptNO = receiptNO;
           this.rtNO = rtNO;
           this.unitNO = unitNO;
    }


    /**
     * Gets the bankNO value for this ChargeRequestVO.
     * 
     * @return bankNO
     */
    public java.lang.String getBankNO() {
        return bankNO;
    }


    /**
     * Sets the bankNO value for this ChargeRequestVO.
     * 
     * @param bankNO
     */
    public void setBankNO(java.lang.String bankNO) {
        this.bankNO = bankNO;
    }


    /**
     * Gets the loginKey value for this ChargeRequestVO.
     * 
     * @return loginKey
     */
    public java.lang.String getLoginKey() {
        return loginKey;
    }


    /**
     * Sets the loginKey value for this ChargeRequestVO.
     * 
     * @param loginKey
     */
    public void setLoginKey(java.lang.String loginKey) {
        this.loginKey = loginKey;
    }


    /**
     * Gets the payDate value for this ChargeRequestVO.
     * 
     * @return payDate
     */
    public java.lang.String getPayDate() {
        return payDate;
    }


    /**
     * Sets the payDate value for this ChargeRequestVO.
     * 
     * @param payDate
     */
    public void setPayDate(java.lang.String payDate) {
        this.payDate = payDate;
    }


    /**
     * Gets the pnCheckCode value for this ChargeRequestVO.
     * 
     * @return pnCheckCode
     */
    public java.lang.String getPnCheckCode() {
        return pnCheckCode;
    }


    /**
     * Sets the pnCheckCode value for this ChargeRequestVO.
     * 
     * @param pnCheckCode
     */
    public void setPnCheckCode(java.lang.String pnCheckCode) {
        this.pnCheckCode = pnCheckCode;
    }


    /**
     * Gets the pnNO value for this ChargeRequestVO.
     * 
     * @return pnNO
     */
    public java.lang.String getPnNO() {
        return pnNO;
    }


    /**
     * Sets the pnNO value for this ChargeRequestVO.
     * 
     * @param pnNO
     */
    public void setPnNO(java.lang.String pnNO) {
        this.pnNO = pnNO;
    }


    /**
     * Gets the receiptNO value for this ChargeRequestVO.
     * 
     * @return receiptNO
     */
    public java.lang.String getReceiptNO() {
        return receiptNO;
    }


    /**
     * Sets the receiptNO value for this ChargeRequestVO.
     * 
     * @param receiptNO
     */
    public void setReceiptNO(java.lang.String receiptNO) {
        this.receiptNO = receiptNO;
    }


    /**
     * Gets the rtNO value for this ChargeRequestVO.
     * 
     * @return rtNO
     */
    public java.lang.String getRtNO() {
        return rtNO;
    }


    /**
     * Sets the rtNO value for this ChargeRequestVO.
     * 
     * @param rtNO
     */
    public void setRtNO(java.lang.String rtNO) {
        this.rtNO = rtNO;
    }


    /**
     * Gets the unitNO value for this ChargeRequestVO.
     * 
     * @return unitNO
     */
    public java.lang.String getUnitNO() {
        return unitNO;
    }


    /**
     * Sets the unitNO value for this ChargeRequestVO.
     * 
     * @param unitNO
     */
    public void setUnitNO(java.lang.String unitNO) {
        this.unitNO = unitNO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChargeRequestVO)) return false;
        ChargeRequestVO other = (ChargeRequestVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bankNO==null && other.getBankNO()==null) || 
             (this.bankNO!=null &&
              this.bankNO.equals(other.getBankNO()))) &&
            ((this.loginKey==null && other.getLoginKey()==null) || 
             (this.loginKey!=null &&
              this.loginKey.equals(other.getLoginKey()))) &&
            ((this.payDate==null && other.getPayDate()==null) || 
             (this.payDate!=null &&
              this.payDate.equals(other.getPayDate()))) &&
            ((this.pnCheckCode==null && other.getPnCheckCode()==null) || 
             (this.pnCheckCode!=null &&
              this.pnCheckCode.equals(other.getPnCheckCode()))) &&
            ((this.pnNO==null && other.getPnNO()==null) || 
             (this.pnNO!=null &&
              this.pnNO.equals(other.getPnNO()))) &&
            ((this.receiptNO==null && other.getReceiptNO()==null) || 
             (this.receiptNO!=null &&
              this.receiptNO.equals(other.getReceiptNO()))) &&
            ((this.rtNO==null && other.getRtNO()==null) || 
             (this.rtNO!=null &&
              this.rtNO.equals(other.getRtNO()))) &&
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
        if (getBankNO() != null) {
            _hashCode += getBankNO().hashCode();
        }
        if (getLoginKey() != null) {
            _hashCode += getLoginKey().hashCode();
        }
        if (getPayDate() != null) {
            _hashCode += getPayDate().hashCode();
        }
        if (getPnCheckCode() != null) {
            _hashCode += getPnCheckCode().hashCode();
        }
        if (getPnNO() != null) {
            _hashCode += getPnNO().hashCode();
        }
        if (getReceiptNO() != null) {
            _hashCode += getReceiptNO().hashCode();
        }
        if (getRtNO() != null) {
            _hashCode += getRtNO().hashCode();
        }
        if (getUnitNO() != null) {
            _hashCode += getUnitNO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ChargeRequestVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "ChargeRequestVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bankNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "loginKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pnCheckCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pnCheckCode"));
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
        elemField.setFieldName("receiptNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiptNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rtNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rtNO"));
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
