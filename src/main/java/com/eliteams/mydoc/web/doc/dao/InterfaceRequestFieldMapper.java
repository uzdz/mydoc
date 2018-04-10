package com.eliteams.mydoc.web.doc.dao;

import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.web.doc.model.InterfaceRequestField;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
@Repository
public interface InterfaceRequestFieldMapper extends GenericDao<InterfaceRequestField, Long> {
    /**
     * 添加请求参数
     * @param interfaceRequestField
     * @return
     */
    int addInterfaceRequestField(InterfaceRequestField interfaceRequestField);

    /**
     * 根据接口信息表删除请求参数数据
     * @param interfaceInfoId
     * @return
     */
    int delInterfaceRequestField(long interfaceInfoId);

    /**
     * 删除请求字段
     * @param interfaceRequestFieldId
     * @return
     */
    int delRequestField(long interfaceRequestFieldId);

    /**
     * 更新请求字段
     * @param interfaceRequestField
     * @return
     */
    int updateRequestField(InterfaceRequestField interfaceRequestField);

    /**
     * 根据接口id查询请求字段
     * @param interfaceId
     * @return
     */
    List<InterfaceRequestField> queryRequestByInterfaceId(long interfaceId);
}
