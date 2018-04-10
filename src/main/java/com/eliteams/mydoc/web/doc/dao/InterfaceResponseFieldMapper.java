package com.eliteams.mydoc.web.doc.dao;

import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.web.doc.model.InterfaceResponseField;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
@Repository
public interface InterfaceResponseFieldMapper extends GenericDao<InterfaceResponseField, Long> {
    /**
     * 添加响应参数
     * @param interfaceResponseField
     * @return
     */
    int addInterfaceResponseField(InterfaceResponseField interfaceResponseField);

    /**
     * 根据信息表id删除响应数据
     * @param interfaceInfoId
     * @return
     */
    int delInterfaceResponseField(long interfaceInfoId);

    /**
     * 删除响应字段
     * @param interfaceResponseFieldId
     * @return
     */
    int delResponseField(long interfaceResponseFieldId);

    /**
     * 更新响应字段
     * @param interfaceResponseField
     * @return
     */
    int updateResponseField(InterfaceResponseField interfaceResponseField);

    /**
     * 根据接口id查询响应参数
     * @param interfaceId
     * @return
     */
    List<InterfaceResponseField> queryResponseByInterfaceId(long interfaceId);
}
