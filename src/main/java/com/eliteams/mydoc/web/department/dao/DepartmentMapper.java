package com.eliteams.mydoc.web.department.dao;

import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.web.department.model.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
@Repository
public interface DepartmentMapper extends GenericDao<Department, Long> {
    /**
     * 根据部门主键查询部门信息
     * @param departmentId
     * @return
     */
    Department queryDepartmentById(@Param("departmentId") long departmentId);

    /**
     * 查询全部的部门信息
     * @return
     */
    List<Department> selectDepartment();

    /**
     * 添加部门
     * @return
     */
    int addDepartment(String departmentName);
}
