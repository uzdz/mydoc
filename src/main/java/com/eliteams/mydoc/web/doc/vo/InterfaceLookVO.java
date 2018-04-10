package com.eliteams.mydoc.web.doc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author [董振]
 * @version [2017/10/27]
 * @since [v1.0]
 */
public class InterfaceLookVO {
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
    private String platformDocName;
    // 平台文档模块分类Id
    private String platformDocModuleClassifyName;
    // 接口状态
    private String interfaceStatusName;
    // 创建时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date interfaceCreateTime;
    // 接口所属部门
    private String departmentName;
    // 全局集合标识
    private String globalClassifyName;

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

    public String getPlatformDocName() {
        return platformDocName;
    }

    public void setPlatformDocName(String platformDocName) {
        this.platformDocName = platformDocName;
    }

    public String getPlatformDocModuleClassifyName() {
        return platformDocModuleClassifyName;
    }

    public void setPlatformDocModuleClassifyName(String platformDocModuleClassifyName) {
        this.platformDocModuleClassifyName = platformDocModuleClassifyName;
    }

    public String getInterfaceStatusName() {
        return interfaceStatusName;
    }

    public void setInterfaceStatusName(String interfaceStatusName) {
        this.interfaceStatusName = interfaceStatusName;
    }

    public Date getInterfaceCreateTime() {
        return interfaceCreateTime;
    }

    public void setInterfaceCreateTime(Date interfaceCreateTime) {
        this.interfaceCreateTime = interfaceCreateTime;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getGlobalClassifyName() {
        return globalClassifyName;
    }

    public void setGlobalClassifyName(String globalClassifyName) {
        this.globalClassifyName = globalClassifyName;
    }
}
