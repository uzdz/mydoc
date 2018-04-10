package com.eliteams.mydoc.web.doc.dao;

import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.web.doc.model.GlobalClassify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/27]
 * @since [v1.0]
 */
@Repository
public interface GlobalClassifyMapper extends GenericDao<GlobalClassify, Long> {
    /**
     * 添加全局名称
     * @param globalClassify
     * @return
     */
    int addGlobalClassify(@Param("globalClassify") GlobalClassify globalClassify);

    /**
     * 查询全局变量集合
     * @return
     */
    List<GlobalClassify> queryGlobalClassify();

    /**
     * 根据Id查询全局变量集合
     * @return
     */
    GlobalClassify queryGlobalClassifyById(long globalClassifyId);
}
