/**
 * GeneratePayNoteVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class GeneratePayNoteVO  extends com.zyxy.service.micro.third.client.ruilian.webservice.GenericVO  implements java.io.Serializable {
    private int chargeItemCount;

    private java.lang.String chargeItemNO1;

    private java.lang.String chargeItemNO2;

    private java.lang.String chargeItemNO3;

    private java.lang.String checkDigitAll;

    private java.lang.String checkDigitNO;

    private java.lang.String createTM;

    private java.lang.String overdueAmt1;

    private java.lang.String overdueAmt2;

    private java.lang.String overdueAmt3;

    private java.lang.String overdueDT;

    private java.lang.String payerName;

    private java.lang.String pnNO;

    private java.lang.String price1;

    private java.lang.String price2;

    private java.lang.String price3;

    private java.lang.String quantity1;

    private java.lang.String quantity2;

    private java.lang.String quantity3;

    private java.lang.String receivableAmt;

    private java.lang.String relateUserName;

    private java.lang.String remark;

    private java.lang.String unitNO;

    public GeneratePayNoteVO() {
    }

    public GeneratePayNoteVO(
           java.lang.String loginKey,
           int chargeItemCount,
           java.lang.String chargeItemNO1,
           java.lang.String chargeItemNO2,
           java.lang.String chargeItemNO3,
           java.lang.String checkDigitAll,
           java.lang.String checkDigitNO,
           java.lang.String createTM,
           java.lang.String overdueAmt1,
           java.lang.String overdueAmt2,
           java.lang.String overdueAmt3,
           java.lang.String overdueDT,
           java.lang.String payerName,
           java.lang.String pnNO,
           java.lang.String price1,
           java.lang.String price2,
           java.lang.String price3,
           java.lang.String quantity1,
           java.lang.String quantity2,
           java.lang.String quantity3,
           java.lang.String receivableAmt,
           java.lang.String relateUserName,
           java.lang.String remark,
           java.lang.String unitNO) {
        super(
            loginKey);
        this.chargeItemCount = chargeItemCount;
        this.chargeItemNO1 = chargeItemNO1;
        this.chargeItemNO2 = chargeItemNO2;
        this.chargeItemNO3 = chargeItemNO3;
        this.checkDigitAll = checkDigitAll;
        this.checkDigitNO = checkDigitNO;
        this.createTM = createTM;
        this.overdueAmt1 = overdueAmt1;
        this.overdueAmt2 = overdueAmt2;
        this.overdueAmt3 = overdueAmt3;
        this.overdueDT = overdueDT;
        this.payerName = payerName;
        this.pnNO = pnNO;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
        this.quantity1 = quantity1;
        this.quantity2 = quantity2;
        this.quantity3 = quantity3;
        this.receivableAmt = receivableAmt;
        this.relateUserName = relateUserName;
        this.remark = remark;
        this.unitNO = unitNO;
    }


    /**
     * Gets the chargeItemCount value for this GeneratePayNoteVO.
     * 
     * @return chargeItemCount
     */
    public int getChargeItemCount() {
        return chargeItemCount;
    }


    /**
     * Sets the chargeItemCount value for this GeneratePayNoteVO.
     * 
     * @param chargeItemCount
     */
    public void setChargeItemCount(int chargeItemCount) {
        this.chargeItemCount = chargeItemCount;
    }


    /**
     * Gets the chargeItemNO1 value for this GeneratePayNoteVO.
     * 
     * @return chargeItemNO1
     */
    public java.lang.String getChargeItemNO1() {
        return chargeItemNO1;
    }


    /**
     * Sets the chargeItemNO1 value for this GeneratePayNoteVO.
     * 
     * @param chargeItemNO1
     */
    public void setChargeItemNO1(java.lang.String chargeItemNO1) {
        this.chargeItemNO1 = chargeItemNO1;
    }


    /**
     * Gets the chargeItemNO2 value for this GeneratePayNoteVO.
     * 
     * @return chargeItemNO2
     */
    public java.lang.String getChargeItemNO2() {
        return chargeItemNO2;
    }


    /**
     * Sets the chargeItemNO2 value for this GeneratePayNoteVO.
     * 
     * @param chargeItemNO2
     */
    public void setChargeItemNO2(java.lang.String chargeItemNO2) {
        this.chargeItemNO2 = chargeItemNO2;
    }


    /**
     * Gets the chargeItemNO3 value for this GeneratePayNoteVO.
     * 
     * @return chargeItemNO3
     */
    public java.lang.String getChargeItemNO3() {
        return chargeItemNO3;
    }


    /**
     * Sets the chargeItemNO3 value for this GeneratePayNoteVO.
     * 
     * @param chargeItemNO3
     */
    public void setChargeItemNO3(java.lang.String chargeItemNO3) {
        this.chargeItemNO3 = chargeItemNO3;
    }


    /**
     * Gets the checkDigitAll value for this GeneratePayNoteVO.
     * 
     * @return checkDigitAll
     */
    public java.lang.String getCheckDigitAll() {
        return checkDigitAll;
    }


    /**
     * Sets the checkDigitAll value for this GeneratePayNoteVO.
     * 
     * @param checkDigitAll
     */
    public void setCheckDigitAll(java.lang.String checkDigitAll) {
        this.checkDigitAll = checkDigitAll;
    }


    /**
     * Gets the checkDigitNO value for this GeneratePayNoteVO.
     * 
     * @return checkDigitNO
     */
    public java.lang.String getCheckDigitNO() {
        return checkDigitNO;
    }


    /**
     * Sets the checkDigitNO value for this GeneratePayNoteVO.
     * 
     * @param checkDigitNO
     */
    public void setCheckDigitNO(java.lang.String checkDigitNO) {
        this.checkDigitNO = checkDigitNO;
    }


    /**
     * Gets the createTM value for this GeneratePayNoteVO.
     * 
     * @return createTM
     */
    public java.lang.String getCreateTM() {
        return createTM;
    }


    /**
     * Sets the createTM value for this GeneratePayNoteVO.
     * 
     * @param createTM
     */
    public void setCreateTM(java.lang.String createTM) {
        this.createTM = createTM;
    }


    /**
     * Gets the overdueAmt1 value for this GeneratePayNoteVO.
     * 
     * @return overdueAmt1
     */
    public java.lang.String getOverdueAmt1() {
        return overdueAmt1;
    }


    /**
     * Sets the overdueAmt1 value for this GeneratePayNoteVO.
     * 
     * @param overdueAmt1
     */
    public void setOverdueAmt1(java.lang.String overdueAmt1) {
        this.overdueAmt1 = overdueAmt1;
    }


    /**
     * Gets the overdueAmt2 value for this GeneratePayNoteVO.
     * 
     * @return overdueAmt2
     */
    public java.lang.String getOverdueAmt2() {
        return overdueAmt2;
    }


    /**
     * Sets the overdueAmt2 value for this GeneratePayNoteVO.
     * 
     * @param overdueAmt2
     */
    public void setOverdueAmt2(java.lang.String overdueAmt2) {
        this.overdueAmt2 = overdueAmt2;
    }


    /**
     * Gets the overdueAmt3 value for this GeneratePayNoteVO.
     * 
     * @return overdueAmt3
     */
    public java.lang.String getOverdueAmt3() {
        return overdueAmt3;
    }


    /**
     * Sets the overdueAmt3 value for this GeneratePayNoteVO.
     * 
     * @param overdueAmt3
     */
    public void setOverdueAmt3(java.lang.String overdueAmt3) {
        this.overdueAmt3 = overdueAmt3;
    }


    /**
     * Gets the overdueDT value for this GeneratePayNoteVO.
     * 
     * @return overdueDT
     */
    public java.lang.String getOverdueDT() {
        return overdueDT;
    }


    /**
     * Sets the overdueDT value for this GeneratePayNoteVO.
     * 
     * @param overdueDT
     */
    public void setOverdueDT(java.lang.String overdueDT) {
        this.overdueDT = overdueDT;
    }


    /**
     * Gets the payerName value for this GeneratePayNoteVO.
     * 
     * @return payerName
     */
    public java.lang.String getPayerName() {
        return payerName;
    }


    /**
     * Sets the payerName value for this GeneratePayNoteVO.
     * 
     * @param payerName
     */
    public void setPayerName(java.lang.String payerName) {
        this.payerName = payerName;
    }


    /**
     * Gets the pnNO value for this GeneratePayNoteVO.
     * 
     * @return pnNO
     */
    public java.lang.String getPnNO() {
        return pnNO;
    }


    /**
     * Sets the pnNO value for this GeneratePayNoteVO.
     * 
     * @param pnNO
     */
    public void setPnNO(java.lang.String pnNO) {
        this.pnNO = pnNO;
    }


    /**
     * Gets the price1 value for this GeneratePayNoteVO.
     * 
     * @return price1
     */
    public java.lang.String getPrice1() {
        return price1;
    }


    /**
     * Sets the price1 value for this GeneratePayNoteVO.
     * 
     * @param price1
     */
    public void setPrice1(java.lang.String price1) {
        this.price1 = price1;
    }


    /**
     * Gets the price2 value for this GeneratePayNoteVO.
     * 
     * @return price2
     */
    public java.lang.String getPrice2() {
        return price2;
    }


    /**
     * Sets the price2 value for this GeneratePayNoteVO.
     * 
     * @param price2
     */
    public void setPrice2(java.lang.String price2) {
        this.price2 = price2;
    }


    /**
     * Gets the price3 value for this GeneratePayNoteVO.
     * 
     * @return price3
     */
    public java.lang.String getPrice3() {
        return price3;
    }


    /**
     * Sets the price3 value for this GeneratePayNoteVO.
     * 
     * @param price3
     */
    public void setPrice3(java.lang.String price3) {
        this.price3 = price3;
    }


    /**
     * Gets the quantity1 value for this GeneratePayNoteVO.
     * 
     * @return quantity1
     */
    public java.lang.String getQuantity1() {
        return quantity1;
    }


    /**
     * Sets the quantity1 value for this GeneratePayNoteVO.
     * 
     * @param quantity1
     */
    public void setQuantity1(java.lang.String quantity1) {
        this.quantity1 = quantity1;
    }


    /**
     * Gets the quantity2 value for this GeneratePayNoteVO.
     * 
     * @return quantity2
     */
    public java.lang.String getQuantity2() {
        return quantity2;
    }


    /**
     * Sets the quantity2 value for this GeneratePayNoteVO.
     * 
     * @param quantity2
     */
    public void setQuantity2(java.lang.String quantity2) {
        this.quantity2 = quantity2;
    }


    /**
     * Gets the quantity3 value for this GeneratePayNoteVO.
     * 
     * @return quantity3
     */
    public java.lang.String getQuantity3() {
        return quantity3;
    }


    /**
     * Sets the quantity3 value for this GeneratePayNoteVO.
     * 
     * @param quantity3
     */
    public void setQuantity3(java.lang.String quantity3) {
        this.quantity3 = quantity3;
    }


    /**
     * Gets the receivableAmt value for this GeneratePayNoteVO.
     * 
     * @return receivableAmt
     */
    public java.lang.String getReceivableAmt() {
        return receivableAmt;
    }


    /**
     * Sets the receivableAmt value for this GeneratePayNoteVO.
     * 
     * @param receivableAmt
     */
    public void setReceivableAmt(java.lang.String receivableAmt) {
        this.receivableAmt = receivableAmt;
    }


    /**
     * Gets the relateUserName value for this GeneratePayNoteVO.
     * 
     * @return relateUserName
     */
    public java.lang.String getRelateUserName() {
        return relateUserName;
    }


    /**
     * Sets the relateUserName value for this GeneratePayNoteVO.
     * 
     * @param relateUserName
     */
    public void setRelateUserName(java.lang.String relateUserName) {
        this.relateUserName = relateUserName;
    }


    /**
     * Gets the remark value for this GeneratePayNoteVO.
     * 
     * @return remark
     */
    public java.lang.String getRemark() {
        return remark;
    }


    /**
     * Sets the remark value for this GeneratePayNoteVO.
     * 
     * @param remark
     */
    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }


    /**
     * Gets the unitNO value for this GeneratePayNoteVO.
     * 
     * @return unitNO
     */
    public java.lang.String getUnitNO() {
        return unitNO;
    }


    /**
     * Sets the unitNO value for this GeneratePayNoteVO.
     * 
     * @param unitNO
     */
    public void setUnitNO(java.lang.String unitNO) {
        this.unitNO = unitNO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GeneratePayNoteVO)) return false;
        GeneratePayNoteVO other = (GeneratePayNoteVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.chargeItemCount == other.getChargeItemCount() &&
            ((this.chargeItemNO1==null && other.getChargeItemNO1()==null) || 
             (this.chargeItemNO1!=null &&
              this.chargeItemNO1.equals(other.getChargeItemNO1()))) &&
            ((this.chargeItemNO2==null && other.getChargeItemNO2()==null) || 
             (this.chargeItemNO2!=null &&
              this.chargeItemNO2.equals(other.getChargeItemNO2()))) &&
            ((this.chargeItemNO3==null && other.getChargeItemNO3()==null) || 
             (this.chargeItemNO3!=null &&
              this.chargeItemNO3.equals(other.getChargeItemNO3()))) &&
            ((this.checkDigitAll==null && other.getCheckDigitAll()==null) || 
             (this.checkDigitAll!=null &&
              this.checkDigitAll.equals(other.getCheckDigitAll()))) &&
            ((this.checkDigitNO==null && other.getCheckDigitNO()==null) || 
             (this.checkDigitNO!=null &&
              this.checkDigitNO.equals(other.getCheckDigitNO()))) &&
            ((this.createTM==null && other.getCreateTM()==null) || 
             (this.createTM!=null &&
              this.createTM.equals(other.getCreateTM()))) &&
            ((this.overdueAmt1==null && other.getOverdueAmt1()==null) || 
             (this.overdueAmt1!=null &&
              this.overdueAmt1.equals(other.getOverdueAmt1()))) &&
            ((this.overdueAmt2==null && other.getOverdueAmt2()==null) || 
             (this.overdueAmt2!=null &&
              this.overdueAmt2.equals(other.getOverdueAmt2()))) &&
            ((this.overdueAmt3==null && other.getOverdueAmt3()==null) || 
             (this.overdueAmt3!=null &&
              this.overdueAmt3.equals(other.getOverdueAmt3()))) &&
            ((this.overdueDT==null && other.getOverdueDT()==null) || 
             (this.overdueDT!=null &&
              this.overdueDT.equals(other.getOverdueDT()))) &&
            ((this.payerName==null && other.getPayerName()==null) || 
             (this.payerName!=null &&
              this.payerName.equals(other.getPayerName()))) &&
            ((this.pnNO==null && other.getPnNO()==null) || 
             (this.pnNO!=null &&
              this.pnNO.equals(other.getPnNO()))) &&
            ((this.price1==null && other.getPrice1()==null) || 
             (this.price1!=null &&
              this.price1.equals(other.getPrice1()))) &&
            ((this.price2==null && other.getPrice2()==null) || 
             (this.price2!=null &&
              this.price2.equals(other.getPrice2()))) &&
            ((this.price3==null && other.getPrice3()==null) || 
             (this.price3!=null &&
              this.price3.equals(other.getPrice3()))) &&
            ((this.quantity1==null && other.getQuantity1()==null) || 
             (this.quantity1!=null &&
              this.quantity1.equals(other.getQuantity1()))) &&
            ((this.quantity2==null && other.getQuantity2()==null) || 
             (this.quantity2!=null &&
              this.quantity2.equals(other.getQuantity2()))) &&
            ((this.quantity3==null && other.getQuantity3()==null) || 
             (this.quantity3!=null &&
              this.quantity3.equals(other.getQuantity3()))) &&
            ((this.receivableAmt==null && other.getReceivableAmt()==null) || 
             (this.receivableAmt!=null &&
              this.receivableAmt.equals(other.getReceivableAmt()))) &&
            ((this.relateUserName==null && other.getRelateUserName()==null) || 
             (this.relateUserName!=null &&
              this.relateUserName.equals(other.getRelateUserName()))) &&
            ((this.remark==null && other.getRemark()==null) || 
             (this.remark!=null &&
              this.remark.equals(other.getRemark()))) &&
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
        _hashCode += getChargeItemCount();
        if (getChargeItemNO1() != null) {
            _hashCode += getChargeItemNO1().hashCode();
        }
        if (getChargeItemNO2() != null) {
            _hashCode += getChargeItemNO2().hashCode();
        }
        if (getChargeItemNO3() != null) {
            _hashCode += getChargeItemNO3().hashCode();
        }
        if (getCheckDigitAll() != null) {
            _hashCode += getCheckDigitAll().hashCode();
        }
        if (getCheckDigitNO() != null) {
            _hashCode += getCheckDigitNO().hashCode();
        }
        if (getCreateTM() != null) {
            _hashCode += getCreateTM().hashCode();
        }
        if (getOverdueAmt1() != null) {
            _hashCode += getOverdueAmt1().hashCode();
        }
        if (getOverdueAmt2() != null) {
            _hashCode += getOverdueAmt2().hashCode();
        }
        if (getOverdueAmt3() != null) {
            _hashCode += getOverdueAmt3().hashCode();
        }
        if (getOverdueDT() != null) {
            _hashCode += getOverdueDT().hashCode();
        }
        if (getPayerName() != null) {
            _hashCode += getPayerName().hashCode();
        }
        if (getPnNO() != null) {
            _hashCode += getPnNO().hashCode();
        }
        if (getPrice1() != null) {
            _hashCode += getPrice1().hashCode();
        }
        if (getPrice2() != null) {
            _hashCode += getPrice2().hashCode();
        }
        if (getPrice3() != null) {
            _hashCode += getPrice3().hashCode();
        }
        if (getQuantity1() != null) {
            _hashCode += getQuantity1().hashCode();
        }
        if (getQuantity2() != null) {
            _hashCode += getQuantity2().hashCode();
        }
        if (getQuantity3() != null) {
            _hashCode += getQuantity3().hashCode();
        }
        if (getReceivableAmt() != null) {
            _hashCode += getReceivableAmt().hashCode();
        }
        if (getRelateUserName() != null) {
            _hashCode += getRelateUserName().hashCode();
        }
        if (getRemark() != null) {
            _hashCode += getRemark().hashCode();
        }
        if (getUnitNO() != null) {
            _hashCode += getUnitNO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GeneratePayNoteVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "GeneratePayNoteVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chargeItemCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chargeItemCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chargeItemNO1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chargeItemNO1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chargeItemNO2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chargeItemNO2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chargeItemNO3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chargeItemNO3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkDigitAll");
        elemField.setXmlName(new javax.xml.namespace.QName("", "checkDigitAll"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkDigitNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "checkDigitNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createTM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "createTM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overdueAmt1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "overdueAmt1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overdueAmt2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "overdueAmt2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overdueAmt3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "overdueAmt3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overdueDT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "overdueDT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payerName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payerName"));
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
        elemField.setFieldName("price1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "price1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "price2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "price3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantity1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantity1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantity2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantity2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantity3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantity3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receivableAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receivableAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relateUserName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relateUserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remark");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remark"));
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
