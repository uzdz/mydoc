package com.eliteams.mydoc.web.platform.service;

import com.eliteams.mydoc.common.generic.GenericService;
import com.eliteams.mydoc.web.platform.model.PlatformDocModuleClassify;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
public interface PlatformDocModuleClassifyService extends GenericService<PlatformDocModuleClassify, Long> {
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
    boolean addModule(long platformId, String moduleName);

    /**
     * 删除平台文档下的模块
     * @param moduleId
     * @return
     */
    boolean delModule(long moduleId);

    /**
     * 根据模块Id查询模块信息
     * @param moduleId
     * @return
     */
    PlatformDocModuleClassify queryModule(long moduleId);
}
