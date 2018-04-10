package com.eliteams.mydoc.web.doc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author [董振]
 * @version [2017/10/17]
 * @since [v1.0]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InterfaceResponseField {
    // 接口响应表主键
    private long interfaceResponseFieldId;
    // 字段名称
    private String fieldName;
    // 字段类型
    private String fieldType;
    // 接口信息表外键
    private long interfaceInfoId;
    // 字段是否必须
    private int fieldMust;
    // 字段备注
    private String fieldRemark;

    @Override
    public String toString() {
        return "InterfaceResponseField{" +
                "interfaceResponseFieldId=" + interfaceResponseFieldId +
                ", fieldName='" + fieldName + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", interfaceInfoId=" + interfaceInfoId +
                ", fieldMust=" + fieldMust +
                ", fieldRemark='" + fieldRemark + '\'' +
                '}';
    }

    public String getFieldRemark() {
        return fieldRemark;
    }

    public void setFieldRemark(String fieldRemark) {
        this.fieldRemark = fieldRemark;
    }

    public long getInterfaceResponseFieldId() {
        return interfaceResponseFieldId;
    }

    public void setInterfaceResponseFieldId(long interfaceResponseFieldId) {
        this.interfaceResponseFieldId = interfaceResponseFieldId;
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
