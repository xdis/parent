/**
 * InStorageDetailVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class InStorageDetailVO  implements java.io.Serializable {
    private int allPieces;

    private double amountCost;

    private double disAmountCost;

    private java.lang.String endNo;

    private int packs;

    private double realPrice;

    private java.lang.String rtNo;

    private java.lang.String startNo;

    public InStorageDetailVO() {
    }

    public InStorageDetailVO(
           int allPieces,
           double amountCost,
           double disAmountCost,
           java.lang.String endNo,
           int packs,
           double realPrice,
           java.lang.String rtNo,
           java.lang.String startNo) {
           this.allPieces = allPieces;
           this.amountCost = amountCost;
           this.disAmountCost = disAmountCost;
           this.endNo = endNo;
           this.packs = packs;
           this.realPrice = realPrice;
           this.rtNo = rtNo;
           this.startNo = startNo;
    }


    /**
     * Gets the allPieces value for this InStorageDetailVO.
     * 
     * @return allPieces
     */
    public int getAllPieces() {
        return allPieces;
    }


    /**
     * Sets the allPieces value for this InStorageDetailVO.
     * 
     * @param allPieces
     */
    public void setAllPieces(int allPieces) {
        this.allPieces = allPieces;
    }


    /**
     * Gets the amountCost value for this InStorageDetailVO.
     * 
     * @return amountCost
     */
    public double getAmountCost() {
        return amountCost;
    }


    /**
     * Sets the amountCost value for this InStorageDetailVO.
     * 
     * @param amountCost
     */
    public void setAmountCost(double amountCost) {
        this.amountCost = amountCost;
    }


    /**
     * Gets the disAmountCost value for this InStorageDetailVO.
     * 
     * @return disAmountCost
     */
    public double getDisAmountCost() {
        return disAmountCost;
    }


    /**
     * Sets the disAmountCost value for this InStorageDetailVO.
     * 
     * @param disAmountCost
     */
    public void setDisAmountCost(double disAmountCost) {
        this.disAmountCost = disAmountCost;
    }


    /**
     * Gets the endNo value for this InStorageDetailVO.
     * 
     * @return endNo
     */
    public java.lang.String getEndNo() {
        return endNo;
    }


    /**
     * Sets the endNo value for this InStorageDetailVO.
     * 
     * @param endNo
     */
    public void setEndNo(java.lang.String endNo) {
        this.endNo = endNo;
    }


    /**
     * Gets the packs value for this InStorageDetailVO.
     * 
     * @return packs
     */
    public int getPacks() {
        return packs;
    }


    /**
     * Sets the packs value for this InStorageDetailVO.
     * 
     * @param packs
     */
    public void setPacks(int packs) {
        this.packs = packs;
    }


    /**
     * Gets the realPrice value for this InStorageDetailVO.
     * 
     * @return realPrice
     */
    public double getRealPrice() {
        return realPrice;
    }


    /**
     * Sets the realPrice value for this InStorageDetailVO.
     * 
     * @param realPrice
     */
    public void setRealPrice(double realPrice) {
        this.realPrice = realPrice;
    }


    /**
     * Gets the rtNo value for this InStorageDetailVO.
     * 
     * @return rtNo
     */
    public java.lang.String getRtNo() {
        return rtNo;
    }


    /**
     * Sets the rtNo value for this InStorageDetailVO.
     * 
     * @param rtNo
     */
    public void setRtNo(java.lang.String rtNo) {
        this.rtNo = rtNo;
    }


    /**
     * Gets the startNo value for this InStorageDetailVO.
     * 
     * @return startNo
     */
    public java.lang.String getStartNo() {
        return startNo;
    }


    /**
     * Sets the startNo value for this InStorageDetailVO.
     * 
     * @param startNo
     */
    public void setStartNo(java.lang.String startNo) {
        this.startNo = startNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InStorageDetailVO)) return false;
        InStorageDetailVO other = (InStorageDetailVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.allPieces == other.getAllPieces() &&
            this.amountCost == other.getAmountCost() &&
            this.disAmountCost == other.getDisAmountCost() &&
            ((this.endNo==null && other.getEndNo()==null) || 
             (this.endNo!=null &&
              this.endNo.equals(other.getEndNo()))) &&
            this.packs == other.getPacks() &&
            this.realPrice == other.getRealPrice() &&
            ((this.rtNo==null && other.getRtNo()==null) || 
             (this.rtNo!=null &&
              this.rtNo.equals(other.getRtNo()))) &&
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
        int _hashCode = 1;
        _hashCode += getAllPieces();
        _hashCode += new Double(getAmountCost()).hashCode();
        _hashCode += new Double(getDisAmountCost()).hashCode();
        if (getEndNo() != null) {
            _hashCode += getEndNo().hashCode();
        }
        _hashCode += getPacks();
        _hashCode += new Double(getRealPrice()).hashCode();
        if (getRtNo() != null) {
            _hashCode += getRtNo().hashCode();
        }
        if (getStartNo() != null) {
            _hashCode += getStartNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InStorageDetailVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "InStorageDetailVO"));
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
        elemField.setFieldName("disAmountCost");
        elemField.setXmlName(new javax.xml.namespace.QName("", "disAmountCost"));
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
        elemField.setFieldName("packs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "packs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("realPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "realPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rtNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rtNo"));
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
