package com.eliteams.mydoc.web.department.service;

import com.eliteams.mydoc.common.generic.GenericService;
import com.eliteams.mydoc.web.department.model.UserDepartment;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/25]
 * @since [v1.0]
 */
public interface UserDepartmentService extends GenericService<UserDepartment, Long> {
    /**
     * 添加用户与部门的关系
     * @param userId
     * @param departmentId
     * @return
     */
    boolean addUserDepartment(long userId, long departmentId);

    /**
     * 更新用户与部门的关系
     * @param userId
     * @param newDepartmentId
     * @return
     */
    boolean updateUserDepartment(long userId, long newDepartmentId);

    /**
     * 查询用户绑定的部门
     * @param userId
     * @return
     */
    UserDepartment selectUserDepartment(long userId);

    /**
     * 查询部门下的用户
     * @param departmentId
     * @return
     */
    List<UserDepartment> selectDepartmentUser(long departmentId);
}
