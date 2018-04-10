package com.eliteams.mydoc.web.department.model;

/**
 * @author [董振]
 * @version [2017/10/17]
 * @since [v1.0]
 */
public class Department {
    // 部门身份主键
    private long departmentId;
    // 部门名称
    private String departmentName;

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
