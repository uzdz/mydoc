package com.eliteams.mydoc.web.doc.vo;

/**
 * @author [董振]
 * @version [2017/11/23]
 * @since [v1.0]
 */
public class PlatformHomeVO {
    // 平台名称
    private String platformName;
    // 该用户所属部门平台接口个数
    private int count;
    // 项目Id
    private long platformDocId;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
