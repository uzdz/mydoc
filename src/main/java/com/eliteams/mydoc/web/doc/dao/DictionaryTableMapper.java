package com.eliteams.mydoc.web.doc.dao;

import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.web.doc.model.DictionaryTable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/11/14]
 * @since [v1.0]
 */
@Repository
public interface DictionaryTableMapper extends GenericDao<DictionaryTable, Long> {
    /**
     * 添加字典表字段
     * @param dictionaryTable
     * @return
     */
    int addDictionaryTable(@Param("dictionaryTable") DictionaryTable dictionaryTable);

    /**
     * 删除字典表字段
     * @param dictionaryTableId
     * @return
     */
    int delDictionaryTable(long dictionaryTableId);

    /**
     * 搜索字典表
     * @param dictionaryTable
     * @return
     */
    List<DictionaryTable> queryDictionaryTable(@Param("dictionaryTable") DictionaryTable dictionaryTable);

    /**
     * 更新字典表
     * @param dictionaryTable
     * @return
     */
    int updateDictionaryTable(@Param("dictionaryTable") DictionaryTable dictionaryTable);

    /**
     * 根据id查询字典表
     * @param dictionaryTableId
     * @return
     */
    DictionaryTable queryDictionaryTableId(@Param("dictionaryTableId") long dictionaryTableId);
}
