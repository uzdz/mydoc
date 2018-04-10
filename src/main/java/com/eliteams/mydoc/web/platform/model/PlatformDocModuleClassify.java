package com.eliteams.mydoc.web.platform.model;

/**
 * @author [董振]
 * @version [2017/10/17]
 * @since [v1.0]
 */
public class PlatformDocModuleClassify {
    // 平台文档模块分类主键
    private long platformDocModuleClassifyId;
    // 模块名称
    private String moduleName;
    // 平台文档表外键
    private long platformDocId;

    @Override
    public String toString() {
        return "PlatformDocModuleClassifyService{" +
                "platformDocModuleClassifyId=" + platformDocModuleClassifyId +
                ", moduleName='" + moduleName + '\'' +
                ", platformDocId=" + platformDocId +
                '}';
    }

    public long getPlatformDocModuleClassifyId() {
        return platformDocModuleClassifyId;
    }

    public void setPlatformDocModuleClassifyId(long platformDocModuleClassifyId) {
        this.platformDocModuleClassifyId = platformDocModuleClassifyId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public long getPlatformDocId() {
        return platformDocId;
    }

    public void setPlatformDocId(long platformDocId) {
        this.platformDocId = platformDocId;
    }
}
