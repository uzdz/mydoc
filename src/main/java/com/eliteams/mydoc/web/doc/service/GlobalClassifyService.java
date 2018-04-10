package com.eliteams.mydoc.web.doc.service;

import com.eliteams.mydoc.common.entity.Pagination;
import com.eliteams.mydoc.common.generic.GenericService;
import com.eliteams.mydoc.web.doc.model.GlobalClassify;

/**
 * @author [董振]
 * @version [2017/10/27]
 * @since [v1.0]
 */
public interface GlobalClassifyService extends GenericService<GlobalClassify, Long> {
    /**
     * 添加全局名称
     * @param globalClassify
     * @return
     */
    boolean addGlobalClassify(GlobalClassify globalClassify);

    /**
     * 查询全部的全局变量集合
     * @return
     */
    Pagination<GlobalClassify> queryGlobalClassify(int pageSize, int pageNo);

    /**
     * 查询全局变量集合
     * @return
     */
    GlobalClassify queryGlobalClassifyById(long globalClassifyId);
}
