package com.eliteams.mydoc.web.department.service.impl;

import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.common.generic.GenericServiceImpl;
import com.eliteams.mydoc.web.department.dao.DepartmentMapper;
import com.eliteams.mydoc.web.department.model.Department;
import com.eliteams.mydoc.web.department.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
@Service
public class DepartmentServiceImpl extends GenericServiceImpl<Department, Long> implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public GenericDao<Department, Long> getDao() {
        return departmentMapper;
    }

    @Override
    public Department queryDepartmentById(long departmentId) {
        return departmentMapper.queryDepartmentById(departmentId);
    }

    @Override
    public List<Department> selectDepartment() {
        return departmentMapper.selectDepartment();
    }

    @Override
    public boolean addDepartment(String departmentName) {
        int i = departmentMapper.addDepartment(departmentName);
        if (i == 1) {
            return true;
        }
        return false;
    }
}
