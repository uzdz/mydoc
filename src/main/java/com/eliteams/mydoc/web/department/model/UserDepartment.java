package com.eliteams.mydoc.web.department.model;

/**
 * @author [董振]
 * @version [2017/10/25]
 * @since [v1.0]
 */
public class UserDepartment {
    // 主键
    private long id;
    // 用户id
    private long userId;
    // 部门主键
    private long departmentId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }
}
