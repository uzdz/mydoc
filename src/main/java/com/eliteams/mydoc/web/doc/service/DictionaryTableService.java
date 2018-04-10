package com.eliteams.mydoc.web.doc.service;

import com.eliteams.mydoc.common.entity.Pagination;
import com.eliteams.mydoc.web.doc.model.DictionaryTable;

/**
 * @author [董振]
 * @version [2017/11/14]
 * @since [v1.0]
 */
public interface DictionaryTableService {
    /**
     * 添加字典表字段
     * @param dictionaryTable
     * @return
     */
    boolean addDictionaryTable(DictionaryTable dictionaryTable);

    /**
     * 删除字典表字段
     * @param dictionaryTableId
     * @return
     */
    boolean delDictionaryTable(long dictionaryTableId);

    /**
     * 根据id查询字典表
     * @param dictionaryTableId
     * @return
     */
    DictionaryTable queryDictionaryTableId(long dictionaryTableId);

    /**
     * 更新字典表
     * @param dictionaryTable
     * @return
     */
    boolean updateDictionaryTable(DictionaryTable dictionaryTable);


    /**
     * 搜索字典表
     * @param dictionaryTable
     * @return
     */
    Pagination<DictionaryTable> queryDictionaryTable(int pageSize, int pageNo, DictionaryTable dictionaryTable);
}
