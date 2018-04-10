package com.eliteams.mydoc.web.user.Enum;

import com.eliteams.mydoc.web.doc.Enum.InterfaceStatusEnum;

public enum UserStatusEnum {
    NORMAL(1, "正常"), ABNORMAL(2, "异常");
    int status;
    String statusMsg;

    UserStatusEnum(int status, String statusMsg) {
        this.status = status;
        this.statusMsg = statusMsg;
    }

    public static UserStatusEnum get(int v) {
        for (UserStatusEnum u : UserStatusEnum.values()) {
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
