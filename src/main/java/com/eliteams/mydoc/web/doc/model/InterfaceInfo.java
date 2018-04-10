package com.eliteams.mydoc.web.doc.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * @author [董振]
 * @version [2017/10/17]
 * @since [v1.0]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InterfaceInfo {
    // 文档主键
    private long interfaceInfoId;
    // 接口名称
    private String interfaceName;
    // 方法名称
    private String methodName;
    // 方法用途
    private String methodPurpose;
    // 方法请求路径
    private String methodRoute;
    // 方法请求演示
    private String methodRequestDemo;
    // 方法结果演示
    private String methodResultDemo;
    // 接口请求方式
    private String interfaceRequestMode;
    // 接口响应方式
    private String interfaceResponseMode;
    // 接口创建用户
    private long interfaceCreateUserId;
    // 接口创建用户名称
    private String interfaceCreateUserName;
    // 平台文档Id
    private long platformDocId;
    // 平台文档模块分类Id
    private long platformDocModuleClassifyId;
    // 接口状态
    private int interfaceStatus;
    // 创建时间
    private Date interfaceCreateTime = new Date();
    // 接口所属部门
    private long departmentId;
    // 全局集合标识
    private long globalClassifyId;

    @Override
    public String toString() {
        return "InterfaceInfo{" +
                "interfaceInfoId=" + interfaceInfoId +
                ", interfaceName='" + interfaceName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", methodPurpose='" + methodPurpose + '\'' +
                ", methodRoute='" + methodRoute + '\'' +
                ", methodRequestDemo='" + methodRequestDemo + '\'' +
                ", methodResultDemo='" + methodResultDemo + '\'' +
                ", interfaceRequestMode='" + interfaceRequestMode + '\'' +
                ", interfaceResponseMode='" + interfaceResponseMode + '\'' +
                ", interfaceCreateUserId=" + interfaceCreateUserId +
                ", interfaceCreateUserName='" + interfaceCreateUserName + '\'' +
                ", platformDocId=" + platformDocId +
                ", platformDocModuleClassifyId=" + platformDocModuleClassifyId +
                ", interfaceStatus=" + interfaceStatus +
                ", interfaceCreateTime=" + interfaceCreateTime +
                ", departmentId=" + departmentId +
                ", globalClassifyId=" + globalClassifyId +
                '}';
    }

    public long getGlobalClassifyId() {
        return globalClassifyId;
    }

    public void setGlobalClassifyId(long globalClassifyId) {
        this.globalClassifyId = globalClassifyId;
    }

    public long getInterfaceInfoId() {
        return interfaceInfoId;
    }

    public void setInterfaceInfoId(long interfaceInfoId) {
        this.interfaceInfoId = interfaceInfoId;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodPurpose() {
        return methodPurpose;
    }

    public void setMethodPurpose(String methodPurpose) {
        this.methodPurpose = methodPurpose;
    }

    public String getMethodRoute() {
        return methodRoute;
    }

    public void setMethodRoute(String methodRoute) {
        this.methodRoute = methodRoute;
    }

    public String getMethodRequestDemo() {
        return methodRequestDemo;
    }

    public void setMethodRequestDemo(String methodRequestDemo) {
        this.methodRequestDemo = methodRequestDemo;
    }

    public String getMethodResultDemo() {
        return methodResultDemo;
    }

    public void setMethodResultDemo(String methodResultDemo) {
        this.methodResultDemo = methodResultDemo;
    }

    public String getInterfaceRequestMode() {
        return interfaceRequestMode;
    }

    public void setInterfaceRequestMode(String interfaceRequestMode) {
        this.interfaceRequestMode = interfaceRequestMode;
    }

    public String getInterfaceResponseMode() {
        return interfaceResponseMode;
    }

    public void setInterfaceResponseMode(String interfaceResponseMode) {
        this.interfaceResponseMode = interfaceResponseMode;
    }

    public long getInterfaceCreateUserId() {
        return interfaceCreateUserId;
    }

    public void setInterfaceCreateUserId(long interfaceCreateUserId) {
        this.interfaceCreateUserId = interfaceCreateUserId;
    }

    public String getInterfaceCreateUserName() {
        return interfaceCreateUserName;
    }

    public void setInterfaceCreateUserName(String interfaceCreateUserName) {
        this.interfaceCreateUserName = interfaceCreateUserName;
    }

    public long getPlatformDocId() {
        return platformDocId;
    }

    public void setPlatformDocId(long platformDocId) {
        this.platformDocId = platformDocId;
    }

    public long getPlatformDocModuleClassifyId() {
        return platformDocModuleClassifyId;
    }

    public void setPlatformDocModuleClassifyId(long platformDocModuleClassifyId) {
        this.platformDocModuleClassifyId = platformDocModuleClassifyId;
    }

    public int getInterfaceStatus() {
        return interfaceStatus;
    }

    public void setInterfaceStatus(int interfaceStatus) {
        this.interfaceStatus = interfaceStatus;
    }

    public Date getInterfaceCreateTime() {
        return interfaceCreateTime;
    }

    public void setInterfaceCreateTime(Date interfaceCreateTime) {
        this.interfaceCreateTime = interfaceCreateTime;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }
}
