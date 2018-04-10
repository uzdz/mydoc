package com.eliteams.mydoc.web.doc.dao;

import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.web.doc.model.GlobalVariableField;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
@Repository
public interface GlobalVariableFieldMapper extends GenericDao<GlobalVariableField, Long> {
    /**
     * 添加全局变量
     * @param globalVariableField
     * @return
     */
    int addGlobalVariableField(GlobalVariableField globalVariableField);

    /**
     * 根据全局集合id查询全局变量
     * @param globalClassifyId
     * @return
     */
    List<GlobalVariableField> queryGlobalField(@Param("globalClassifyId") long globalClassifyId, @Param("type") int type);

    /**
     * 删除全局变量
     * @param globalVariableFieldId
     * @return
     */
    int delGlobalField(@Param("globalVariableFieldId") long globalVariableFieldId);
}
