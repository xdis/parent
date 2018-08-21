/**
 * OutStorageVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zyxy.service.micro.third.client.ruilian.webservice;

public class OutStorageVO  extends com.zyxy.service.micro.third.client.ruilian.webservice.GenericVO  implements java.io.Serializable {
    private com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageDetailVO[] details;

    private java.lang.String inUnitCode;

    private java.lang.String outUnitCode;

    private java.lang.String payNoteNo;

    private java.lang.String receiver;

    private java.lang.Double sumCost;

    private java.lang.Integer type;

    public OutStorageVO() {
    }

    public OutStorageVO(
           java.lang.String loginKey,
           com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageDetailVO[] details,
           java.lang.String inUnitCode,
           java.lang.String outUnitCode,
           java.lang.String payNoteNo,
           java.lang.String receiver,
           java.lang.Double sumCost,
           java.lang.Integer type) {
        super(
            loginKey);
        this.details = details;
        this.inUnitCode = inUnitCode;
        this.outUnitCode = outUnitCode;
        this.payNoteNo = payNoteNo;
        this.receiver = receiver;
        this.sumCost = sumCost;
        this.type = type;
    }


    /**
     * Gets the details value for this OutStorageVO.
     * 
     * @return details
     */
    public com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageDetailVO[] getDetails() {
        return details;
    }


    /**
     * Sets the details value for this OutStorageVO.
     * 
     * @param details
     */
    public void setDetails(com.zyxy.service.micro.third.client.ruilian.webservice.OutStorageDetailVO[] details) {
        this.details = details;
    }


    /**
     * Gets the inUnitCode value for this OutStorageVO.
     * 
     * @return inUnitCode
     */
    public java.lang.String getInUnitCode() {
        return inUnitCode;
    }


    /**
     * Sets the inUnitCode value for this OutStorageVO.
     * 
     * @param inUnitCode
     */
    public void setInUnitCode(java.lang.String inUnitCode) {
        this.inUnitCode = inUnitCode;
    }


    /**
     * Gets the outUnitCode value for this OutStorageVO.
     * 
     * @return outUnitCode
     */
    public java.lang.String getOutUnitCode() {
        return outUnitCode;
    }


    /**
     * Sets the outUnitCode value for this OutStorageVO.
     * 
     * @param outUnitCode
     */
    public void setOutUnitCode(java.lang.String outUnitCode) {
        this.outUnitCode = outUnitCode;
    }


    /**
     * Gets the payNoteNo value for this OutStorageVO.
     * 
     * @return payNoteNo
     */
    public java.lang.String getPayNoteNo() {
        return payNoteNo;
    }


    /**
     * Sets the payNoteNo value for this OutStorageVO.
     * 
     * @param payNoteNo
     */
    public void setPayNoteNo(java.lang.String payNoteNo) {
        this.payNoteNo = payNoteNo;
    }


    /**
     * Gets the receiver value for this OutStorageVO.
     * 
     * @return receiver
     */
    public java.lang.String getReceiver() {
        return receiver;
    }


    /**
     * Sets the receiver value for this OutStorageVO.
     * 
     * @param receiver
     */
    public void setReceiver(java.lang.String receiver) {
        this.receiver = receiver;
    }


    /**
     * Gets the sumCost value for this OutStorageVO.
     * 
     * @return sumCost
     */
    public java.lang.Double getSumCost() {
        return sumCost;
    }


    /**
     * Sets the sumCost value for this OutStorageVO.
     * 
     * @param sumCost
     */
    public void setSumCost(java.lang.Double sumCost) {
        this.sumCost = sumCost;
    }


    /**
     * Gets the type value for this OutStorageVO.
     * 
     * @return type
     */
    public java.lang.Integer getType() {
        return type;
    }


    /**
     * Sets the type value for this OutStorageVO.
     * 
     * @param type
     */
    public void setType(java.lang.Integer type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OutStorageVO)) return false;
        OutStorageVO other = (OutStorageVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.details==null && other.getDetails()==null) || 
             (this.details!=null &&
              java.util.Arrays.equals(this.details, other.getDetails()))) &&
            ((this.inUnitCode==null && other.getInUnitCode()==null) || 
             (this.inUnitCode!=null &&
              this.inUnitCode.equals(other.getInUnitCode()))) &&
            ((this.outUnitCode==null && other.getOutUnitCode()==null) || 
             (this.outUnitCode!=null &&
              this.outUnitCode.equals(other.getOutUnitCode()))) &&
            ((this.payNoteNo==null && other.getPayNoteNo()==null) || 
             (this.payNoteNo!=null &&
              this.payNoteNo.equals(other.getPayNoteNo()))) &&
            ((this.receiver==null && other.getReceiver()==null) || 
             (this.receiver!=null &&
              this.receiver.equals(other.getReceiver()))) &&
            ((this.sumCost==null && other.getSumCost()==null) || 
             (this.sumCost!=null &&
              this.sumCost.equals(other.getSumCost()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType())));
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
        if (getDetails() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDetails());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDetails(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInUnitCode() != null) {
            _hashCode += getInUnitCode().hashCode();
        }
        if (getOutUnitCode() != null) {
            _hashCode += getOutUnitCode().hashCode();
        }
        if (getPayNoteNo() != null) {
            _hashCode += getPayNoteNo().hashCode();
        }
        if (getReceiver() != null) {
            _hashCode += getReceiver().hashCode();
        }
        if (getSumCost() != null) {
            _hashCode += getSumCost().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OutStorageVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "OutStorageVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("details");
        elemField.setXmlName(new javax.xml.namespace.QName("", "details"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://vo.webservices.gfmis.todaytech.com", "OutStorageDetailVO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inUnitCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inUnitCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outUnitCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "outUnitCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payNoteNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payNoteNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiver");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiver"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sumCost");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sumCost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
