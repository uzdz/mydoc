package com.eliteams.mydoc.web.platform.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author [董振]
 * @version [2017/10/17]
 * @since [v1.0]
 */
public class PlatformDoc {
    // 平台文档Id
    private long platformDocId;
    // 公司名称
    private String companyName;
    // 平台名称
    private String platformName;
    // 平台创建时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date platformCreateTime;

    public PlatformDoc() {
    }

    public PlatformDoc(String companyName, String platformName, Date platformCreateTime) {
        this.companyName = companyName;
        this.platformName = platformName;
        this.platformCreateTime = platformCreateTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getPlatformDocId() {
        return platformDocId;
    }

    public void setPlatformDocId(long platformDocId) {
        this.platformDocId = platformDocId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public Date getPlatformCreateTime() {
        return platformCreateTime;
    }

    public void setPlatformCreateTime(Date platformCreateTime) {
        this.platformCreateTime = platformCreateTime;
    }
}
