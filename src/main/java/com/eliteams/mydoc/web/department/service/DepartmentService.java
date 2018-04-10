package com.eliteams.mydoc.web.department.service;

import com.eliteams.mydoc.common.generic.GenericService;
import com.eliteams.mydoc.web.department.model.Department;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
public interface DepartmentService extends GenericService<Department, Long> {
    /**
     * 根据部门主键查询部门信息
     * @param departmentId
     * @return
     */
    Department queryDepartmentById(long departmentId);

    /**
     * 查询全部的部门信息
     * @return
     */
    List<Department> selectDepartment();

    /**
     * 添加部门
     * @return
     */
    boolean addDepartment(String departmentName);
}
