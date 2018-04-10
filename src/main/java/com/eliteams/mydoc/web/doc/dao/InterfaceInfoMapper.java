package com.eliteams.mydoc.web.doc.dao;

import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.web.doc.model.DataType;
import com.eliteams.mydoc.web.doc.model.InterfaceInfo;
import com.eliteams.mydoc.web.doc.vo.InterfaceViewVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
@Repository
public interface InterfaceInfoMapper  extends GenericDao<InterfaceInfo, Long> {
    /**
     * 添加接口
     * @param interfaceInfo
     * @return
     */
    int addInterfaceInfo(InterfaceInfo interfaceInfo);

    /**
     * 更新接口
     * @param interfaceInfo
     * @return
     */
    int updateInterfaceInfo(@Param("interfaceInfo") InterfaceInfo interfaceInfo);

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
    List<InterfaceViewVO> queryInterfaceByDepartmentId(@Param("interfaceInfo") InterfaceInfo interfaceInfo);

    /**
     * 各部门查询旗下的接口
     * @param interfaceInfo
     * @return
     */
    List<InterfaceViewVO> queryInterfaceByManager(@Param("interfaceInfo") InterfaceInfo interfaceInfo);

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
    int delInterfaceInfoById(long interfaceInfoId);

    /**
     * 根据用户部门分类项目平台
     * @param platformDocId
     * @return
     */
    int countPlatformInterface(@Param("platformDocId") long platformDocId, @Param("department") long department);

    /**
     * 查询所有数据类型
     * @return
     */
    List<DataType> selectDateType();
}
