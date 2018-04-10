package com.eliteams.mydoc.web.doc.service;

import com.eliteams.mydoc.common.generic.GenericService;
import com.eliteams.mydoc.web.doc.model.InterfaceResponseField;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
public interface InterfaceResponseFieldService extends GenericService<InterfaceResponseField, Long>{
    /**
     * 添加响应参数
     * @param interfaceResponseFields
     * @return
     */
    boolean addInterfaceResponseField(List<InterfaceResponseField> interfaceResponseFields);

    /**
     * 根据信息表id删除响应数据
     * @param interfaceInfoId
     * @return
     */
    boolean delInterfaceResponseField(long interfaceInfoId);

    /**
     * 删除响应字段
     * @param interfaceResponseFieldId
     * @return
     */
    boolean delResponseField(long interfaceResponseFieldId);

    /**
     * 添加响应字段
     * @param interfaceInfoId
     * @return
     */
    boolean addResponseField(long interfaceInfoId, List<InterfaceResponseField> interfaceResponseFields);

    /**
     * 更新响应字段
     * @param interfaceResponseField
     * @return
     */
    boolean updateResponseField(InterfaceResponseField interfaceResponseField);

    /**
     * 根据接口id查询响应参数
     * @param interfaceId
     * @return
     */
    List<InterfaceResponseField> queryResponseByInterfaceId(long interfaceId);
}
