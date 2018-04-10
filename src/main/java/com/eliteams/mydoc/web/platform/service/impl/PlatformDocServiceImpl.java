package com.eliteams.mydoc.web.platform.service.impl;

import com.eliteams.mydoc.common.entity.Pagination;
import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.common.generic.GenericServiceImpl;
import com.eliteams.mydoc.web.platform.dao.PlatformDocMapper;
import com.eliteams.mydoc.web.platform.model.PlatformDoc;
import com.eliteams.mydoc.web.platform.service.PlatformDocService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
@Service
public class PlatformDocServiceImpl extends GenericServiceImpl<PlatformDoc, Long> implements PlatformDocService {

    @Resource
    private PlatformDocMapper platformDocMapper;

    @Override
    public GenericDao<PlatformDoc, Long> getDao() {
        return platformDocMapper;
    }

    @Override
    public boolean addPlatformDoc(PlatformDoc platformDoc) {
        int i = platformDocMapper.addPlatformDoc(platformDoc);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Pagination<PlatformDoc> queryPlatformDoc(int pageSize, int pageNo) {
        PageHelper.startPage(pageNo, pageSize);
        List<PlatformDoc> platformDocs = platformDocMapper.queryPlatformDoc();
        PageInfo<PlatformDoc> pageInfo = new PageInfo<PlatformDoc>(platformDocs);
        return new Pagination<PlatformDoc>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public PlatformDoc queryPlatformDocById(long platformDocId) {
        return platformDocMapper.queryPlatformDocById(platformDocId);
    }
}
