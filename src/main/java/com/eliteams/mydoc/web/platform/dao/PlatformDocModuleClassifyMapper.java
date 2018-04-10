package com.eliteams.mydoc.web.platform.dao;

import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.web.platform.model.PlatformDocModuleClassify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
@Repository
public interface PlatformDocModuleClassifyMapper extends GenericDao<PlatformDocModuleClassify, Long> {
    /**
     * 根据平台Id查询模块分类
     * @param platformId
     * @return
     */
    List<PlatformDocModuleClassify> queryModuleClassify(long platformId);

    /**
     * 添加平台文档下的模块
     * @param platformId
     * @param moduleName
     * @return
     */
    int addModule(@Param("platformId") long platformId, @Param("moduleName") String moduleName);

    /**
     * 添加平台文档下的模块
     * @param moduleId
     * @return
     */
    int delModule(long moduleId);

    /**
     * 根据模块Id查询模块信息
     * @param moduleId
     * @return
     */
    PlatformDocModuleClassify queryModule(long moduleId);
}
