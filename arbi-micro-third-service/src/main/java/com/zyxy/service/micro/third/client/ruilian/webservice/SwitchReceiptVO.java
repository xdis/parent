/**
 * SwitchReceiptVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class SwitchReceiptVO  implements java.io.Serializable {
    private java.lang.String bankNO;

    private java.lang.String loginKey;

    private java.lang.String newRTNO;

    private java.lang.String newRcptNO;

    private java.lang.String pnNO;

    private java.lang.String rcptNO;

    private java.lang.String reason;

    private java.lang.String rtNO;

    private java.lang.String unitNO;

    public SwitchReceiptVO() {
    }

    public SwitchReceiptVO(
           java.lang.String bankNO,
           java.lang.String loginKey,
           java.lang.String newRTNO,
           java.lang.String newRcptNO,
           java.lang.String pnNO,
           java.lang.String rcptNO,
           java.lang.String reason,
           java.lang.String rtNO,
           java.lang.String unitNO) {
           this.bankNO = bankNO;
           this.loginKey = loginKey;
           this.newRTNO = newRTNO;
           this.newRcptNO = newRcptNO;
           this.pnNO = pnNO;
           this.rcptNO = rcptNO;
           this.reason = reason;
           this.rtNO = rtNO;
           this.unitNO = unitNO;
    }


    /**
     * Gets the bankNO value for this SwitchReceiptVO.
     * 
     * @return bankNO
     */
    public java.lang.String getBankNO() {
        return bankNO;
    }


    /**
     * Sets the bankNO value for this SwitchReceiptVO.
     * 
     * @param bankNO
     */
    public void setBankNO(java.lang.String bankNO) {
        this.bankNO = bankNO;
    }


    /**
     * Gets the loginKey value for this SwitchReceiptVO.
     * 
     * @return loginKey
     */
    public java.lang.String getLoginKey() {
        return loginKey;
    }


    /**
     * Sets the loginKey value for this SwitchReceiptVO.
     * 
     * @param loginKey
     */
    public void setLoginKey(java.lang.String loginKey) {
        this.loginKey = loginKey;
    }


    /**
     * Gets the newRTNO value for this SwitchReceiptVO.
     * 
     * @return newRTNO
     */
    public java.lang.String getNewRTNO() {
        return newRTNO;
    }


    /**
     * Sets the newRTNO value for this SwitchReceiptVO.
     * 
     * @param newRTNO
     */
    public void setNewRTNO(java.lang.String newRTNO) {
        this.newRTNO = newRTNO;
    }


    /**
     * Gets the newRcptNO value for this SwitchReceiptVO.
     * 
     * @return newRcptNO
     */
    public java.lang.String getNewRcptNO() {
        return newRcptNO;
    }


    /**
     * Sets the newRcptNO value for this SwitchReceiptVO.
     * 
     * @param newRcptNO
     */
    public void setNewRcptNO(java.lang.String newRcptNO) {
        this.newRcptNO = newRcptNO;
    }


    /**
     * Gets the pnNO value for this SwitchReceiptVO.
     * 
     * @return pnNO
     */
    public java.lang.String getPnNO() {
        return pnNO;
    }


    /**
     * Sets the pnNO value for this SwitchReceiptVO.
     * 
     * @param pnNO
     */
    public void setPnNO(java.lang.String pnNO) {
        this.pnNO = pnNO;
    }


    /**
     * Gets the rcptNO value for this SwitchReceiptVO.
     * 
     * @return rcptNO
     */
    public java.lang.String getRcptNO() {
        return rcptNO;
    }


    /**
     * Sets the rcptNO value for this SwitchReceiptVO.
     * 
     * @param rcptNO
     */
    public void setRcptNO(java.lang.String rcptNO) {
        this.rcptNO = rcptNO;
    }


    /**
     * Gets the reason value for this SwitchReceiptVO.
     * 
     * @return reason
     */
    public java.lang.String getReason() {
        return reason;
    }


    /**
     * Sets the reason value for this SwitchReceiptVO.
     * 
     * @param reason
     */
    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }


    /**
     * Gets the rtNO value for this SwitchReceiptVO.
     * 
     * @return rtNO
     */
    public java.lang.String getRtNO() {
        return rtNO;
    }


    /**
     * Sets the rtNO value for this SwitchReceiptVO.
     * 
     * @param rtNO
     */
    public void setRtNO(java.lang.String rtNO) {
        this.rtNO = rtNO;
    }


    /**
     * Gets the unitNO value for this SwitchReceiptVO.
     * 
     * @return unitNO
     */
    public java.lang.String getUnitNO() {
        return unitNO;
    }


    /**
     * Sets the unitNO value for this SwitchReceiptVO.
     * 
     * @param unitNO
     */
    public void setUnitNO(java.lang.String unitNO) {
        this.unitNO = unitNO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SwitchReceiptVO)) return false;
        SwitchReceiptVO other = (SwitchReceiptVO) obj;
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
            ((this.newRTNO==null && other.getNewRTNO()==null) || 
             (this.newRTNO!=null &&
              this.newRTNO.equals(other.getNewRTNO()))) &&
            ((this.newRcptNO==null && other.getNewRcptNO()==null) || 
             (this.newRcptNO!=null &&
              this.newRcptNO.equals(other.getNewRcptNO()))) &&
            ((this.pnNO==null && other.getPnNO()==null) || 
             (this.pnNO!=null &&
              this.pnNO.equals(other.getPnNO()))) &&
            ((this.rcptNO==null && other.getRcptNO()==null) || 
             (this.rcptNO!=null &&
              this.rcptNO.equals(other.getRcptNO()))) &&
            ((this.reason==null && other.getReason()==null) || 
             (this.reason!=null &&
              this.reason.equals(other.getReason()))) &&
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
        if (getNewRTNO() != null) {
            _hashCode += getNewRTNO().hashCode();
        }
        if (getNewRcptNO() != null) {
            _hashCode += getNewRcptNO().hashCode();
        }
        if (getPnNO() != null) {
            _hashCode += getPnNO().hashCode();
        }
        if (getRcptNO() != null) {
            _hashCode += getRcptNO().hashCode();
        }
        if (getReason() != null) {
            _hashCode += getReason().hashCode();
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
        new org.apache.axis.description.TypeDesc(SwitchReceiptVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SwitchReceiptVO"));
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
        elemField.setFieldName("newRTNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "newRTNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newRcptNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "newRcptNO"));
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
        elemField.setFieldName("rcptNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rcptNO"));
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
