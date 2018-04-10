package com.eliteams.mydoc.web.doc.service;

import com.eliteams.mydoc.common.generic.GenericService;
import com.eliteams.mydoc.web.doc.model.InterfaceRequestField;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
public interface InterfaceRequestFieldService extends GenericService<InterfaceRequestField, Long>{
    /**
     * 添加请求参数
     * @param interfaceRequestFields
     * @return
     */
    boolean addInterfaceRequestField(List<InterfaceRequestField> interfaceRequestFields);

    /**
     * 根据接口信息表删除请求参数数据
     * @param interfaceInfoId
     * @return
     */
    boolean delInterfaceRequestField(long interfaceInfoId);

    /**
     * 添加请求字段
     * @param interfaceInfoId
     * @return
     */
    boolean addRequestField(long interfaceInfoId, List<InterfaceRequestField> interfaceRequestFields);

    /**
     * 删除请求字段
     * @param interfaceRequestFieldId
     * @return
     */
    boolean delRequestField(long interfaceRequestFieldId);

    /**
     * 更新请求字段
     * @param interfaceRequestField
     * @return
     */
    boolean updateRequestField(InterfaceRequestField interfaceRequestField);

    /**
     * 根据接口id查询请求字段
     * @param interfaceId
     * @return
     */
    List<InterfaceRequestField> queryRequestByInterfaceId(long interfaceId);
}
