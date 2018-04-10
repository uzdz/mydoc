package com.eliteams.mydoc.web.doc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author [董振]
 * @version [2017/10/17]
 * @since [v1.0]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InterfaceRequestField {
    // 接口请求字段表主键
    private long interfaceRequestFieldId;
    // 字段名称
    private String fieldName;
    // 字段类型
    private String fieldType;
    // 字段备注
    private String fieldRemark;
    // 接口表外键
    private long interfaceInfoId;
    // 字段是否必须
    private int fieldMust;

    @Override
    public String toString() {
        return "InterfaceRequestField{" +
                "interfaceRequestFieldId=" + interfaceRequestFieldId +
                ", fieldName='" + fieldName + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", fieldRemark='" + fieldRemark + '\'' +
                ", interfaceInfoId=" + interfaceInfoId +
                ", fieldMust=" + fieldMust +
                '}';
    }

    public long getInterfaceRequestFieldId() {
        return interfaceRequestFieldId;
    }

    public void setInterfaceRequestFieldId(long interfaceRequestFieldId) {
        this.interfaceRequestFieldId = interfaceRequestFieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldRemark() {
        return fieldRemark;
    }

    public void setFieldRemark(String fieldRemark) {
        this.fieldRemark = fieldRemark;
    }

    public long getInterfaceInfoId() {
        return interfaceInfoId;
    }

    public void setInterfaceInfoId(long interfaceInfoId) {
        this.interfaceInfoId = interfaceInfoId;
    }

    public int getFieldMust() {
        return fieldMust;
    }

    public void setFieldMust(int fieldMust) {
        this.fieldMust = fieldMust;
    }
}
