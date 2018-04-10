package com.eliteams.mydoc.web.doc.service;

import com.eliteams.mydoc.common.entity.Pagination;
import com.eliteams.mydoc.common.generic.GenericService;
import com.eliteams.mydoc.web.doc.model.DataType;
import com.eliteams.mydoc.web.doc.model.InterfaceInfo;
import com.eliteams.mydoc.web.doc.vo.InterfaceViewVO;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
public interface InterfaceInfoService extends GenericService<InterfaceInfo, Long> {
    /**
     * 添加相关接口
     * @param interfaceInfo
     * @return
     */
    boolean addInterfaceInfo(InterfaceInfo interfaceInfo);

    /**
     * 根据部门查询旗下的接口数量
     * @param departmentId
     * @return
     */
    int countInterface(long departmentId);

    /**
     * 根据部门查询旗下的接口数量 java
     * @return
     */
    int countInterfaceJava();

    /**
     * 各部门查询旗下的接口
     * @param interfaceInfo
     * @return
     */
    Pagination<InterfaceViewVO> queryInterfaceByDepartmentId(InterfaceInfo interfaceInfo, int pageSize, int pageNo);

    /**
     * 各部门查询旗下的接口
     * @param interfaceInfo
     * @return
     */
    Pagination<InterfaceViewVO> queryInterfaceByManager(InterfaceInfo interfaceInfo, int pageSize, int pageNo);

    /**
     * 根据接口id查询接口
     * @param interfaceInfoId
     * @return
     */
    InterfaceInfo queryInterfaceInfoById(long interfaceInfoId);

    /**
     * 根据接口id删除接口
     * @param interfaceInfoId
     * @return
     */
    boolean delInterfaceInfoById(long interfaceInfoId);

    /**
     * 根据用户部门分类项目平台
     * @param platformDocId
     * @return
     */
    int countPlatformInterface(long platformDocId, long department);

    /**
     * 查询所有数据类型
     * @return
     */
    List<DataType> selectDateType();
}
