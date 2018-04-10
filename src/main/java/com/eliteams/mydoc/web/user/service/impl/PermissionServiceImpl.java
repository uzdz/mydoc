package com.eliteams.mydoc.web.user.service.impl;

import java.util.List;
import javax.annotation.Resource;

import com.eliteams.mydoc.web.user.dao.PermissionMapper;
import com.eliteams.mydoc.web.user.model.Permission;
import com.eliteams.mydoc.web.user.service.PermissionService;
import org.springframework.stereotype.Service;
import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.common.generic.GenericServiceImpl;

/**
 * 权限Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午12:05:03
 */
@Service
public class PermissionServiceImpl extends GenericServiceImpl<Permission, Long> implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;


    @Override
    public GenericDao<Permission, Long> getDao() {
        return permissionMapper;
    }

    @Override
    public List<Permission> selectPermissionsByRoleId(Long roleId) {
        return permissionMapper.selectPermissionsByRoleId(roleId);
    }
}
