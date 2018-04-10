package com.eliteams.mydoc.web.doc.service.impl;

import com.eliteams.mydoc.common.entity.Pagination;
import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.common.generic.GenericServiceImpl;
import com.eliteams.mydoc.web.department.dao.DepartmentMapper;
import com.eliteams.mydoc.web.doc.dao.InterfaceInfoMapper;
import com.eliteams.mydoc.web.doc.model.DataType;
import com.eliteams.mydoc.web.doc.model.InterfaceInfo;
import com.eliteams.mydoc.web.doc.service.InterfaceInfoService;
import com.eliteams.mydoc.web.doc.vo.InterfaceViewVO;
import com.eliteams.mydoc.web.user.dao.UserMapper;
import com.eliteams.mydoc.web.user.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
@Service
public class InterfaceInfoServiceImpl extends GenericServiceImpl<InterfaceInfo, Long> implements InterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public GenericDao<InterfaceInfo, Long> getDao() {
        return interfaceInfoMapper;
    }

    @Override
    public boolean addInterfaceInfo(InterfaceInfo interfaceInfo) {
        User user = userMapper.selectByPrimaryKey(interfaceInfo.getInterfaceCreateUserId());
        interfaceInfo.setInterfaceCreateTime(new Date());
        interfaceInfo.setInterfaceCreateUserName(user.getUsername());
        int bool = interfaceInfoMapper.addInterfaceInfo(interfaceInfo);
        if (bool == 1) {
            return true;
        }
        return false;
    }

    @Override
    public int countInterface(long departmentId) {
        return interfaceInfoMapper.countInterface(departmentId);
    }

    @Override
    public int countInterfaceJava() {
        return interfaceInfoMapper.countInterfaceJava();
    }

    @Override
    public Pagination<InterfaceViewVO> queryInterfaceByDepartmentId(InterfaceInfo interfaceInfo, int pageSize, int pageNo) {
        PageHelper.startPage(pageNo, pageSize);
        List<InterfaceViewVO> interfaceEditVOS = interfaceInfoMapper.queryInterfaceByDepartmentId(interfaceInfo);
        PageInfo<InterfaceViewVO> pageInfo = new PageInfo<InterfaceViewVO>(interfaceEditVOS);
        return new Pagination<InterfaceViewVO>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public Pagination<InterfaceViewVO> queryInterfaceByManager(InterfaceInfo interfaceInfo, int pageSize, int pageNo) {
        PageHelper.startPage(pageNo, pageSize);
        List<InterfaceViewVO> interfaceEditVOS = interfaceInfoMapper.queryInterfaceByManager(interfaceInfo);
        PageInfo<InterfaceViewVO> pageInfo = new PageInfo<InterfaceViewVO>(interfaceEditVOS);
        return new Pagination<InterfaceViewVO>(pageInfo.getTotal(), pageInfo.getList());
    }


    @Override
    public InterfaceInfo queryInterfaceInfoById(long interfaceInfoId) {
        return interfaceInfoMapper.queryInterfaceInfoById(interfaceInfoId);
    }

    @Override
    public boolean delInterfaceInfoById(long interfaceInfoId) {
        int i = interfaceInfoMapper.delInterfaceInfoById(interfaceInfoId);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public int countPlatformInterface(long platformDocId, long department) {
        return interfaceInfoMapper.countPlatformInterface(platformDocId, department);
    }

    @Override
    public List<DataType> selectDateType() {
        return interfaceInfoMapper.selectDateType();
    }
}
