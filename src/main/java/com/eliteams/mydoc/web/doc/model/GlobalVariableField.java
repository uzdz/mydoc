package com.eliteams.mydoc.web.doc.model;

/**
 * @author [董振]
 * @version [2017/10/17]
 * @since [v1.0]
 */
public class GlobalVariableField {
    // 全局变量表主键
    private long globalVariableFieldId;
    // 全局字段名称
    private String globalFieldName;
    // 字段类型
    private String globalFieldType;
    // 字段备注
    private String globalFieldRemark;
    // 字段是否必须
    private int globalFieldMust;
    // 集合Id
    private long globalClassifyId;
    // 请求响应类型1请求 2响应
    private int globalRequestResultType;

    public int getGlobalRequestResultType() {
        return globalRequestResultType;
    }

    public void setGlobalRequestResultType(int globalRequestResultType) {
        this.globalRequestResultType = globalRequestResultType;
    }

    public long getGlobalClassifyId() {
        return globalClassifyId;
    }

    public void setGlobalClassifyId(long globalClassifyId) {
        this.globalClassifyId = globalClassifyId;
    }

    public long getGlobalVariableFieldId() {
        return globalVariableFieldId;
    }

    public void setGlobalVariableFieldId(long globalVariableFieldId) {
        this.globalVariableFieldId = globalVariableFieldId;
    }

    public String getGlobalFieldName() {
        return globalFieldName;
    }

    public void setGlobalFieldName(String globalFieldName) {
        this.globalFieldName = globalFieldName;
    }

    public String getGlobalFieldType() {
        return globalFieldType;
    }

    public void setGlobalFieldType(String globalFieldType) {
        this.globalFieldType = globalFieldType;
    }

    public String getGlobalFieldRemark() {
        return globalFieldRemark;
    }

    public void setGlobalFieldRemark(String globalFieldRemark) {
        this.globalFieldRemark = globalFieldRemark;
    }


    public int getGlobalFieldMust() {
        return globalFieldMust;
    }

    public void setGlobalFieldMust(int globalFieldMust) {
        this.globalFieldMust = globalFieldMust;
    }
}
