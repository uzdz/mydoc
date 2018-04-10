package com.eliteams.mydoc.web.department.service.impl;

import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.common.generic.GenericServiceImpl;
import com.eliteams.mydoc.web.department.dao.UserDepartmentMapper;
import com.eliteams.mydoc.web.department.model.UserDepartment;
import com.eliteams.mydoc.web.department.service.UserDepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/25]
 * @since [v1.0]
 */
@Service
public class UserDepartmentServiceImpl  extends GenericServiceImpl<UserDepartment, Long> implements UserDepartmentService {

    @Resource
    private UserDepartmentMapper userDepartmentMapper;

    @Override
    public GenericDao<UserDepartment, Long> getDao() {
        return userDepartmentMapper;
    }

    @Override
    public boolean addUserDepartment(long userId, long departmentId) {
        int i = userDepartmentMapper.addUserDepartment(userId, departmentId);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserDepartment(long userId, long newDepartmentId) {
        int i = userDepartmentMapper.updateUserDepartment(userId, newDepartmentId);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public UserDepartment selectUserDepartment(long userId) {
        return userDepartmentMapper.selectUserDepartment(userId);
    }

    @Override
    public List<UserDepartment> selectDepartmentUser(long departmentId) {
        return userDepartmentMapper.selectDepartmentUser(departmentId);
    }
}
