package com.eliteams.mydoc.web.doc.Enum;

public enum InterfaceStatusEnum {
    CLOSE(1, "未启用"), OPEN(2, "已启用"), MAINTAIN(3, "维护中");
    int status;
    String statusMsg;

    InterfaceStatusEnum(int status, String statusMsg) {
        this.status = status;
        this.statusMsg = statusMsg;
    }

    public static InterfaceStatusEnum get(int v) {
        for (InterfaceStatusEnum u : InterfaceStatusEnum.values()) {
            if (u.getStatus() == v) {
                return u;
            }
        }
        return null;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
}
