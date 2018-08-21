/**
 * EnterStockVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class EnterStockVO  extends com.zyxy.service.micro.third.client.ruilian.webservice.GenericVO  implements java.io.Serializable {
    private java.lang.String endNO;

    private int pieceCount;

    private java.lang.String procTM;

    private double receiptCost;

    private java.lang.String rtNO;

    private java.lang.String startNO;

    private java.lang.String stockHouseName;

    private java.lang.String unitNO;

    public EnterStockVO() {
    }

    public EnterStockVO(
           java.lang.String loginKey,
           java.lang.String endNO,
           int pieceCount,
           java.lang.String procTM,
           double receiptCost,
           java.lang.String rtNO,
           java.lang.String startNO,
           java.lang.String stockHouseName,
           java.lang.String unitNO) {
        super(
            loginKey);
        this.endNO = endNO;
        this.pieceCount = pieceCount;
        this.procTM = procTM;
        this.receiptCost = receiptCost;
        this.rtNO = rtNO;
        this.startNO = startNO;
        this.stockHouseName = stockHouseName;
        this.unitNO = unitNO;
    }


    /**
     * Gets the endNO value for this EnterStockVO.
     * 
     * @return endNO
     */
    public java.lang.String getEndNO() {
        return endNO;
    }


    /**
     * Sets the endNO value for this EnterStockVO.
     * 
     * @param endNO
     */
    public void setEndNO(java.lang.String endNO) {
        this.endNO = endNO;
    }


    /**
     * Gets the pieceCount value for this EnterStockVO.
     * 
     * @return pieceCount
     */
    public int getPieceCount() {
        return pieceCount;
    }


    /**
     * Sets the pieceCount value for this EnterStockVO.
     * 
     * @param pieceCount
     */
    public void setPieceCount(int pieceCount) {
        this.pieceCount = pieceCount;
    }


    /**
     * Gets the procTM value for this EnterStockVO.
     * 
     * @return procTM
     */
    public java.lang.String getProcTM() {
        return procTM;
    }


    /**
     * Sets the procTM value for this EnterStockVO.
     * 
     * @param procTM
     */
    public void setProcTM(java.lang.String procTM) {
        this.procTM = procTM;
    }


    /**
     * Gets the receiptCost value for this EnterStockVO.
     * 
     * @return receiptCost
     */
    public double getReceiptCost() {
        return receiptCost;
    }


    /**
     * Sets the receiptCost value for this EnterStockVO.
     * 
     * @param receiptCost
     */
    public void setReceiptCost(double receiptCost) {
        this.receiptCost = receiptCost;
    }


    /**
     * Gets the rtNO value for this EnterStockVO.
     * 
     * @return rtNO
     */
    public java.lang.String getRtNO() {
        return rtNO;
    }


    /**
     * Sets the rtNO value for this EnterStockVO.
     * 
     * @param rtNO
     */
    public void setRtNO(java.lang.String rtNO) {
        this.rtNO = rtNO;
    }


    /**
     * Gets the startNO value for this EnterStockVO.
     * 
     * @return startNO
     */
    public java.lang.String getStartNO() {
        return startNO;
    }


    /**
     * Sets the startNO value for this EnterStockVO.
     * 
     * @param startNO
     */
    public void setStartNO(java.lang.String startNO) {
        this.startNO = startNO;
    }


    /**
     * Gets the stockHouseName value for this EnterStockVO.
     * 
     * @return stockHouseName
     */
    public java.lang.String getStockHouseName() {
        return stockHouseName;
    }


    /**
     * Sets the stockHouseName value for this EnterStockVO.
     * 
     * @param stockHouseName
     */
    public void setStockHouseName(java.lang.String stockHouseName) {
        this.stockHouseName = stockHouseName;
    }


    /**
     * Gets the unitNO value for this EnterStockVO.
     * 
     * @return unitNO
     */
    public java.lang.String getUnitNO() {
        return unitNO;
    }


    /**
     * Sets the unitNO value for this EnterStockVO.
     * 
     * @param unitNO
     */
    public void setUnitNO(java.lang.String unitNO) {
        this.unitNO = unitNO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EnterStockVO)) return false;
        EnterStockVO other = (EnterStockVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.endNO==null && other.getEndNO()==null) || 
             (this.endNO!=null &&
              this.endNO.equals(other.getEndNO()))) &&
            this.pieceCount == other.getPieceCount() &&
            ((this.procTM==null && other.getProcTM()==null) || 
             (this.procTM!=null &&
              this.procTM.equals(other.getProcTM()))) &&
            this.receiptCost == other.getReceiptCost() &&
            ((this.rtNO==null && other.getRtNO()==null) || 
             (this.rtNO!=null &&
              this.rtNO.equals(other.getRtNO()))) &&
            ((this.startNO==null && other.getStartNO()==null) || 
             (this.startNO!=null &&
              this.startNO.equals(other.getStartNO()))) &&
            ((this.stockHouseName==null && other.getStockHouseName()==null) || 
             (this.stockHouseName!=null &&
              this.stockHouseName.equals(other.getStockHouseName()))) &&
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
        int _hashCode = super.hashCode();
        if (getEndNO() != null) {
            _hashCode += getEndNO().hashCode();
        }
        _hashCode += getPieceCount();
        if (getProcTM() != null) {
            _hashCode += getProcTM().hashCode();
        }
        _hashCode += new Double(getReceiptCost()).hashCode();
        if (getRtNO() != null) {
            _hashCode += getRtNO().hashCode();
        }
        if (getStartNO() != null) {
            _hashCode += getStartNO().hashCode();
        }
        if (getStockHouseName() != null) {
            _hashCode += getStockHouseName().hashCode();
        }
        if (getUnitNO() != null) {
            _hashCode += getUnitNO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EnterStockVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "EnterStockVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pieceCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pieceCount"));
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
        elemField.setFieldName("receiptCost");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiptCost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
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
        elemField.setFieldName("stockHouseName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stockHouseName"));
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
