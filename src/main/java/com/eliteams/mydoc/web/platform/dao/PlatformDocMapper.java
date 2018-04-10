package com.eliteams.mydoc.web.platform.dao;

import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.web.platform.model.PlatformDoc;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
@Repository
public interface PlatformDocMapper extends GenericDao<PlatformDoc, Long> {
    /**
     * 添加文档平台
     * @return
     */
    int addPlatformDoc(PlatformDoc platformDoc);

    /**
     * 查询文档平台
     * @return
     */
    List<PlatformDoc> queryPlatformDoc();

    /**
     * 根据id查询文档平台
     * @return
     */
    PlatformDoc queryPlatformDocById(@Param("platformDocId") long platformDocId);
}
