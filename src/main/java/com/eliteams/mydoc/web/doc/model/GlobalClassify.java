package com.eliteams.mydoc.web.doc.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author [董振]
 * @version [2017/10/27]
 * @since [v1.0]
 */
public class GlobalClassify {
    // 主键
    private long globalClassifyId;
    // 全局变量集合名称
    private String globalClassifyName;
    // 全局变量集合启用状态
    private int globalClassifyStatus;
    // 创建时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date globalClassifyCreateTime;

    @Override
    public String toString() {
        return "GlobalClassify{" +
                "globalClassifyId=" + globalClassifyId +
                ", globalClassifyName='" + globalClassifyName + '\'' +
                ", globalClassifyStatus=" + globalClassifyStatus +
                ", globalClassifyCreateTime=" + globalClassifyCreateTime +
                '}';
    }

    public long getGlobalClassifyId() {
        return globalClassifyId;
    }

    public void setGlobalClassifyId(long globalClassifyId) {
        this.globalClassifyId = globalClassifyId;
    }

    public String getGlobalClassifyName() {
        return globalClassifyName;
    }

    public void setGlobalClassifyName(String globalClassifyName) {
        this.globalClassifyName = globalClassifyName;
    }

    public int getGlobalClassifyStatus() {
        return globalClassifyStatus;
    }

    public void setGlobalClassifyStatus(int globalClassifyStatus) {
        this.globalClassifyStatus = globalClassifyStatus;
    }

    public Date getGlobalClassifyCreateTime() {
        return globalClassifyCreateTime;
    }

    public void setGlobalClassifyCreateTime(Date globalClassifyCreateTime) {
        this.globalClassifyCreateTime = globalClassifyCreateTime;
    }
}
