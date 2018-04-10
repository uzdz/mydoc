package com.eliteams.mydoc.web.department.dao;

import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.web.department.model.UserDepartment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/25]
 * @since [v1.0]
 */
@Repository
public interface UserDepartmentMapper extends GenericDao<UserDepartment, Long> {
    /**
     * 添加用户与部门的关系
     * @param userId
     * @param departmentId
     * @return
     */
    int addUserDepartment(@Param("userId") long userId, @Param("departmentId") long departmentId);

    /**
     * 更新用户与部门的关系
     * @param userId
     * @param newDepartmentId
     * @return
     */
    int updateUserDepartment(long userId, long newDepartmentId);

    /**
     * 查询用户与部门的关系
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
