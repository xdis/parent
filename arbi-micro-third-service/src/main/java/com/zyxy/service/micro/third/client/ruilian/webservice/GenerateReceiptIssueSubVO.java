/**
 * GenerateReceiptIssueSubVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class GenerateReceiptIssueSubVO  extends com.zyxy.service.micro.third.client.ruilian.webservice.GenericVO  implements java.io.Serializable {
    private int allPieces;

    private double amountCost;

    private java.lang.String desUnitid;

    private double disAmountCost;

    private double discount;

    private java.lang.String endNo;

    private int needConfirm;

    private int packs;

    private java.lang.String procTM;

    private double realPrice;

    private java.lang.String receiver;

    private int rshid;

    private java.lang.String rtId;

    private java.lang.String startNo;

    public GenerateReceiptIssueSubVO() {
    }

    public GenerateReceiptIssueSubVO(
           java.lang.String loginKey,
           int allPieces,
           double amountCost,
           java.lang.String desUnitid,
           double disAmountCost,
           double discount,
           java.lang.String endNo,
           int needConfirm,
           int packs,
           java.lang.String procTM,
           double realPrice,
           java.lang.String receiver,
           int rshid,
           java.lang.String rtId,
           java.lang.String startNo) {
        super(
            loginKey);
        this.allPieces = allPieces;
        this.amountCost = amountCost;
        this.desUnitid = desUnitid;
        this.disAmountCost = disAmountCost;
        this.discount = discount;
        this.endNo = endNo;
        this.needConfirm = needConfirm;
        this.packs = packs;
        this.procTM = procTM;
        this.realPrice = realPrice;
        this.receiver = receiver;
        this.rshid = rshid;
        this.rtId = rtId;
        this.startNo = startNo;
    }


    /**
     * Gets the allPieces value for this GenerateReceiptIssueSubVO.
     * 
     * @return allPieces
     */
    public int getAllPieces() {
        return allPieces;
    }


    /**
     * Sets the allPieces value for this GenerateReceiptIssueSubVO.
     * 
     * @param allPieces
     */
    public void setAllPieces(int allPieces) {
        this.allPieces = allPieces;
    }


    /**
     * Gets the amountCost value for this GenerateReceiptIssueSubVO.
     * 
     * @return amountCost
     */
    public double getAmountCost() {
        return amountCost;
    }


    /**
     * Sets the amountCost value for this GenerateReceiptIssueSubVO.
     * 
     * @param amountCost
     */
    public void setAmountCost(double amountCost) {
        this.amountCost = amountCost;
    }


    /**
     * Gets the desUnitid value for this GenerateReceiptIssueSubVO.
     * 
     * @return desUnitid
     */
    public java.lang.String getDesUnitid() {
        return desUnitid;
    }


    /**
     * Sets the desUnitid value for this GenerateReceiptIssueSubVO.
     * 
     * @param desUnitid
     */
    public void setDesUnitid(java.lang.String desUnitid) {
        this.desUnitid = desUnitid;
    }


    /**
     * Gets the disAmountCost value for this GenerateReceiptIssueSubVO.
     * 
     * @return disAmountCost
     */
    public double getDisAmountCost() {
        return disAmountCost;
    }


    /**
     * Sets the disAmountCost value for this GenerateReceiptIssueSubVO.
     * 
     * @param disAmountCost
     */
    public void setDisAmountCost(double disAmountCost) {
        this.disAmountCost = disAmountCost;
    }


    /**
     * Gets the discount value for this GenerateReceiptIssueSubVO.
     * 
     * @return discount
     */
    public double getDiscount() {
        return discount;
    }


    /**
     * Sets the discount value for this GenerateReceiptIssueSubVO.
     * 
     * @param discount
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }


    /**
     * Gets the endNo value for this GenerateReceiptIssueSubVO.
     * 
     * @return endNo
     */
    public java.lang.String getEndNo() {
        return endNo;
    }


    /**
     * Sets the endNo value for this GenerateReceiptIssueSubVO.
     * 
     * @param endNo
     */
    public void setEndNo(java.lang.String endNo) {
        this.endNo = endNo;
    }


    /**
     * Gets the needConfirm value for this GenerateReceiptIssueSubVO.
     * 
     * @return needConfirm
     */
    public int getNeedConfirm() {
        return needConfirm;
    }


    /**
     * Sets the needConfirm value for this GenerateReceiptIssueSubVO.
     * 
     * @param needConfirm
     */
    public void setNeedConfirm(int needConfirm) {
        this.needConfirm = needConfirm;
    }


    /**
     * Gets the packs value for this GenerateReceiptIssueSubVO.
     * 
     * @return packs
     */
    public int getPacks() {
        return packs;
    }


    /**
     * Sets the packs value for this GenerateReceiptIssueSubVO.
     * 
     * @param packs
     */
    public void setPacks(int packs) {
        this.packs = packs;
    }


    /**
     * Gets the procTM value for this GenerateReceiptIssueSubVO.
     * 
     * @return procTM
     */
    public java.lang.String getProcTM() {
        return procTM;
    }


    /**
     * Sets the procTM value for this GenerateReceiptIssueSubVO.
     * 
     * @param procTM
     */
    public void setProcTM(java.lang.String procTM) {
        this.procTM = procTM;
    }


    /**
     * Gets the realPrice value for this GenerateReceiptIssueSubVO.
     * 
     * @return realPrice
     */
    public double getRealPrice() {
        return realPrice;
    }


    /**
     * Sets the realPrice value for this GenerateReceiptIssueSubVO.
     * 
     * @param realPrice
     */
    public void setRealPrice(double realPrice) {
        this.realPrice = realPrice;
    }


    /**
     * Gets the receiver value for this GenerateReceiptIssueSubVO.
     * 
     * @return receiver
     */
    public java.lang.String getReceiver() {
        return receiver;
    }


    /**
     * Sets the receiver value for this GenerateReceiptIssueSubVO.
     * 
     * @param receiver
     */
    public void setReceiver(java.lang.String receiver) {
        this.receiver = receiver;
    }


    /**
     * Gets the rshid value for this GenerateReceiptIssueSubVO.
     * 
     * @return rshid
     */
    public int getRshid() {
        return rshid;
    }


    /**
     * Sets the rshid value for this GenerateReceiptIssueSubVO.
     * 
     * @param rshid
     */
    public void setRshid(int rshid) {
        this.rshid = rshid;
    }


    /**
     * Gets the rtId value for this GenerateReceiptIssueSubVO.
     * 
     * @return rtId
     */
    public java.lang.String getRtId() {
        return rtId;
    }


    /**
     * Sets the rtId value for this GenerateReceiptIssueSubVO.
     * 
     * @param rtId
     */
    public void setRtId(java.lang.String rtId) {
        this.rtId = rtId;
    }


    /**
     * Gets the startNo value for this GenerateReceiptIssueSubVO.
     * 
     * @return startNo
     */
    public java.lang.String getStartNo() {
        return startNo;
    }


    /**
     * Sets the startNo value for this GenerateReceiptIssueSubVO.
     * 
     * @param startNo
     */
    public void setStartNo(java.lang.String startNo) {
        this.startNo = startNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GenerateReceiptIssueSubVO)) return false;
        GenerateReceiptIssueSubVO other = (GenerateReceiptIssueSubVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.allPieces == other.getAllPieces() &&
            this.amountCost == other.getAmountCost() &&
            ((this.desUnitid==null && other.getDesUnitid()==null) || 
             (this.desUnitid!=null &&
              this.desUnitid.equals(other.getDesUnitid()))) &&
            this.disAmountCost == other.getDisAmountCost() &&
            this.discount == other.getDiscount() &&
            ((this.endNo==null && other.getEndNo()==null) || 
             (this.endNo!=null &&
              this.endNo.equals(other.getEndNo()))) &&
            this.needConfirm == other.getNeedConfirm() &&
            this.packs == other.getPacks() &&
            ((this.procTM==null && other.getProcTM()==null) || 
             (this.procTM!=null &&
              this.procTM.equals(other.getProcTM()))) &&
            this.realPrice == other.getRealPrice() &&
            ((this.receiver==null && other.getReceiver()==null) || 
             (this.receiver!=null &&
              this.receiver.equals(other.getReceiver()))) &&
            this.rshid == other.getRshid() &&
            ((this.rtId==null && other.getRtId()==null) || 
             (this.rtId!=null &&
              this.rtId.equals(other.getRtId()))) &&
            ((this.startNo==null && other.getStartNo()==null) || 
             (this.startNo!=null &&
              this.startNo.equals(other.getStartNo())));
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
        _hashCode += getAllPieces();
        _hashCode += new Double(getAmountCost()).hashCode();
        if (getDesUnitid() != null) {
            _hashCode += getDesUnitid().hashCode();
        }
        _hashCode += new Double(getDisAmountCost()).hashCode();
        _hashCode += new Double(getDiscount()).hashCode();
        if (getEndNo() != null) {
            _hashCode += getEndNo().hashCode();
        }
        _hashCode += getNeedConfirm();
        _hashCode += getPacks();
        if (getProcTM() != null) {
            _hashCode += getProcTM().hashCode();
        }
        _hashCode += new Double(getRealPrice()).hashCode();
        if (getReceiver() != null) {
            _hashCode += getReceiver().hashCode();
        }
        _hashCode += getRshid();
        if (getRtId() != null) {
            _hashCode += getRtId().hashCode();
        }
        if (getStartNo() != null) {
            _hashCode += getStartNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GenerateReceiptIssueSubVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GenerateReceiptIssueSubVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allPieces");
        elemField.setXmlName(new javax.xml.namespace.QName("", "allPieces"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amountCost");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amountCost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("desUnitid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "desUnitid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("disAmountCost");
        elemField.setXmlName(new javax.xml.namespace.QName("", "disAmountCost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("discount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "discount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("needConfirm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "needConfirm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "packs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("procTM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "procTM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("realPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "realPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiver");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiver"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rshid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rshid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rtId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rtId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startNo"));
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
