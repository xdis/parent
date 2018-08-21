/**
 * SendReceiptInfoVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class SendReceiptInfoVO  implements java.io.Serializable {
    private java.lang.String bankNO;

    private java.lang.String cino;

    private java.lang.String endNO;

    private java.lang.String kpunitno;

    private java.lang.String loginKey;

    private java.lang.String payer;

    private java.lang.String proTM;

    private java.lang.String rtNO;

    private java.lang.String startNO;

    private int status;

    private double totalamt;

    private java.lang.String zsunitno;

    public SendReceiptInfoVO() {
    }

    public SendReceiptInfoVO(
           java.lang.String bankNO,
           java.lang.String cino,
           java.lang.String endNO,
           java.lang.String kpunitno,
           java.lang.String loginKey,
           java.lang.String payer,
           java.lang.String proTM,
           java.lang.String rtNO,
           java.lang.String startNO,
           int status,
           double totalamt,
           java.lang.String zsunitno) {
           this.bankNO = bankNO;
           this.cino = cino;
           this.endNO = endNO;
           this.kpunitno = kpunitno;
           this.loginKey = loginKey;
           this.payer = payer;
           this.proTM = proTM;
           this.rtNO = rtNO;
           this.startNO = startNO;
           this.status = status;
           this.totalamt = totalamt;
           this.zsunitno = zsunitno;
    }


    /**
     * Gets the bankNO value for this SendReceiptInfoVO.
     * 
     * @return bankNO
     */
    public java.lang.String getBankNO() {
        return bankNO;
    }


    /**
     * Sets the bankNO value for this SendReceiptInfoVO.
     * 
     * @param bankNO
     */
    public void setBankNO(java.lang.String bankNO) {
        this.bankNO = bankNO;
    }


    /**
     * Gets the cino value for this SendReceiptInfoVO.
     * 
     * @return cino
     */
    public java.lang.String getCino() {
        return cino;
    }


    /**
     * Sets the cino value for this SendReceiptInfoVO.
     * 
     * @param cino
     */
    public void setCino(java.lang.String cino) {
        this.cino = cino;
    }


    /**
     * Gets the endNO value for this SendReceiptInfoVO.
     * 
     * @return endNO
     */
    public java.lang.String getEndNO() {
        return endNO;
    }


    /**
     * Sets the endNO value for this SendReceiptInfoVO.
     * 
     * @param endNO
     */
    public void setEndNO(java.lang.String endNO) {
        this.endNO = endNO;
    }


    /**
     * Gets the kpunitno value for this SendReceiptInfoVO.
     * 
     * @return kpunitno
     */
    public java.lang.String getKpunitno() {
        return kpunitno;
    }


    /**
     * Sets the kpunitno value for this SendReceiptInfoVO.
     * 
     * @param kpunitno
     */
    public void setKpunitno(java.lang.String kpunitno) {
        this.kpunitno = kpunitno;
    }


    /**
     * Gets the loginKey value for this SendReceiptInfoVO.
     * 
     * @return loginKey
     */
    public java.lang.String getLoginKey() {
        return loginKey;
    }


    /**
     * Sets the loginKey value for this SendReceiptInfoVO.
     * 
     * @param loginKey
     */
    public void setLoginKey(java.lang.String loginKey) {
        this.loginKey = loginKey;
    }


    /**
     * Gets the payer value for this SendReceiptInfoVO.
     * 
     * @return payer
     */
    public java.lang.String getPayer() {
        return payer;
    }


    /**
     * Sets the payer value for this SendReceiptInfoVO.
     * 
     * @param payer
     */
    public void setPayer(java.lang.String payer) {
        this.payer = payer;
    }


    /**
     * Gets the proTM value for this SendReceiptInfoVO.
     * 
     * @return proTM
     */
    public java.lang.String getProTM() {
        return proTM;
    }


    /**
     * Sets the proTM value for this SendReceiptInfoVO.
     * 
     * @param proTM
     */
    public void setProTM(java.lang.String proTM) {
        this.proTM = proTM;
    }


    /**
     * Gets the rtNO value for this SendReceiptInfoVO.
     * 
     * @return rtNO
     */
    public java.lang.String getRtNO() {
        return rtNO;
    }


    /**
     * Sets the rtNO value for this SendReceiptInfoVO.
     * 
     * @param rtNO
     */
    public void setRtNO(java.lang.String rtNO) {
        this.rtNO = rtNO;
    }


    /**
     * Gets the startNO value for this SendReceiptInfoVO.
     * 
     * @return startNO
     */
    public java.lang.String getStartNO() {
        return startNO;
    }


    /**
     * Sets the startNO value for this SendReceiptInfoVO.
     * 
     * @param startNO
     */
    public void setStartNO(java.lang.String startNO) {
        this.startNO = startNO;
    }


    /**
     * Gets the status value for this SendReceiptInfoVO.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this SendReceiptInfoVO.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the totalamt value for this SendReceiptInfoVO.
     * 
     * @return totalamt
     */
    public double getTotalamt() {
        return totalamt;
    }


    /**
     * Sets the totalamt value for this SendReceiptInfoVO.
     * 
     * @param totalamt
     */
    public void setTotalamt(double totalamt) {
        this.totalamt = totalamt;
    }


    /**
     * Gets the zsunitno value for this SendReceiptInfoVO.
     * 
     * @return zsunitno
     */
    public java.lang.String getZsunitno() {
        return zsunitno;
    }


    /**
     * Sets the zsunitno value for this SendReceiptInfoVO.
     * 
     * @param zsunitno
     */
    public void setZsunitno(java.lang.String zsunitno) {
        this.zsunitno = zsunitno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendReceiptInfoVO)) return false;
        SendReceiptInfoVO other = (SendReceiptInfoVO) obj;
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
            ((this.cino==null && other.getCino()==null) || 
             (this.cino!=null &&
              this.cino.equals(other.getCino()))) &&
            ((this.endNO==null && other.getEndNO()==null) || 
             (this.endNO!=null &&
              this.endNO.equals(other.getEndNO()))) &&
            ((this.kpunitno==null && other.getKpunitno()==null) || 
             (this.kpunitno!=null &&
              this.kpunitno.equals(other.getKpunitno()))) &&
            ((this.loginKey==null && other.getLoginKey()==null) || 
             (this.loginKey!=null &&
              this.loginKey.equals(other.getLoginKey()))) &&
            ((this.payer==null && other.getPayer()==null) || 
             (this.payer!=null &&
              this.payer.equals(other.getPayer()))) &&
            ((this.proTM==null && other.getProTM()==null) || 
             (this.proTM!=null &&
              this.proTM.equals(other.getProTM()))) &&
            ((this.rtNO==null && other.getRtNO()==null) || 
             (this.rtNO!=null &&
              this.rtNO.equals(other.getRtNO()))) &&
            ((this.startNO==null && other.getStartNO()==null) || 
             (this.startNO!=null &&
              this.startNO.equals(other.getStartNO()))) &&
            this.status == other.getStatus() &&
            this.totalamt == other.getTotalamt() &&
            ((this.zsunitno==null && other.getZsunitno()==null) || 
             (this.zsunitno!=null &&
              this.zsunitno.equals(other.getZsunitno())));
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
        if (getCino() != null) {
            _hashCode += getCino().hashCode();
        }
        if (getEndNO() != null) {
            _hashCode += getEndNO().hashCode();
        }
        if (getKpunitno() != null) {
            _hashCode += getKpunitno().hashCode();
        }
        if (getLoginKey() != null) {
            _hashCode += getLoginKey().hashCode();
        }
        if (getPayer() != null) {
            _hashCode += getPayer().hashCode();
        }
        if (getProTM() != null) {
            _hashCode += getProTM().hashCode();
        }
        if (getRtNO() != null) {
            _hashCode += getRtNO().hashCode();
        }
        if (getStartNO() != null) {
            _hashCode += getStartNO().hashCode();
        }
        _hashCode += getStatus();
        _hashCode += new Double(getTotalamt()).hashCode();
        if (getZsunitno() != null) {
            _hashCode += getZsunitno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendReceiptInfoVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "SendReceiptInfoVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bankNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cino");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kpunitno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "kpunitno"));
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
        elemField.setFieldName("payer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proTM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "proTM"));
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
        elemField.setFieldName("startNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalamt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalamt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zsunitno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "zsunitno"));
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
