package com.eliteams.mydoc.web.doc.model;

/**
 * @author [董振]
 * @version [2017/11/14]
 * @since [v1.0]
 */
public class DictionaryTable {
    // 主键
    private long dictionaryTableId;
    // 字典表code
    private long dictionaryTableCode;
    // 字典表message
    private String dictionaryTableMessage;
    // 所属平台
    private long dictionaryTablePlatform;
    // 1系统级主错误编码 2业务级公共错误编码 3业务级错误编码
    private int dictionaryTableRank;

    public long getDictionaryTableId() {
        return dictionaryTableId;
    }

    public void setDictionaryTableId(long dictionaryTableId) {
        this.dictionaryTableId = dictionaryTableId;
    }

    public long getDictionaryTableCode() {
        return dictionaryTableCode;
    }

    public void setDictionaryTableCode(long dictionaryTableCode) {
        this.dictionaryTableCode = dictionaryTableCode;
    }

    public String getDictionaryTableMessage() {
        return dictionaryTableMessage;
    }

    public void setDictionaryTableMessage(String dictionaryTableMessage) {
        this.dictionaryTableMessage = dictionaryTableMessage;
    }

    public long getDictionaryTablePlatform() {
        return dictionaryTablePlatform;
    }

    public void setDictionaryTablePlatform(long dictionaryTablePlatform) {
        this.dictionaryTablePlatform = dictionaryTablePlatform;
    }

    public int getDictionaryTableRank() {
        return dictionaryTableRank;
    }

    public void setDictionaryTableRank(int dictionaryTableRank) {
        this.dictionaryTableRank = dictionaryTableRank;
    }
}
