package com.eliteams.mydoc.web.doc.service;

import com.eliteams.mydoc.common.generic.GenericService;
import com.eliteams.mydoc.web.doc.model.GlobalVariableField;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
public interface GlobalVariableFieldService extends GenericService<GlobalVariableField, Long>{
    /**
     * 添加全局变量
     * @param globalVariableField
     * @return
     */
    boolean addGlobalVariableField(GlobalVariableField globalVariableField);

    /**
     * 根据全局集合id查询全局变量
     * @param globalClassifyId
     * @return
     */
    List<GlobalVariableField> queryGlobalField(long globalClassifyId, int type);

    /**
     * 删除全局变量
     * @param globalVariableFieldId
     * @return
     */
    boolean delGlobalField(long globalVariableFieldId);
}
