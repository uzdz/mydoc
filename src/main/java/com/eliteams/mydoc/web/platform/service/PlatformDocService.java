package com.eliteams.mydoc.web.platform.service;

import com.eliteams.mydoc.common.entity.Pagination;
import com.eliteams.mydoc.common.generic.GenericService;
import com.eliteams.mydoc.web.platform.model.PlatformDoc;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
public interface PlatformDocService extends GenericService<PlatformDoc, Long> {
    /**
     * 添加文档平台
     * @return
     */
    boolean addPlatformDoc(PlatformDoc platformDoc);

    /**
     * 查询文档平台
     * @return
     */
    Pagination<PlatformDoc> queryPlatformDoc(int pageSize, int pageNo);

    /**
     * 根据id查询文档平台
     * @return
     */
    PlatformDoc queryPlatformDocById(long platformDocId);
}
