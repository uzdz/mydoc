package com.eliteams.mydoc.web.platform.service.impl;

import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.common.generic.GenericServiceImpl;
import com.eliteams.mydoc.web.platform.dao.PlatformDocModuleClassifyMapper;
import com.eliteams.mydoc.web.platform.model.PlatformDocModuleClassify;
import com.eliteams.mydoc.web.platform.service.PlatformDocModuleClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
@Service
public class PlatformDocModuleClassifyServiceImpl extends GenericServiceImpl<PlatformDocModuleClassify, Long> implements PlatformDocModuleClassifyService {

    @Resource
    private PlatformDocModuleClassifyMapper platformDocModuleClassifyMapper;

    @Override
    public GenericDao<PlatformDocModuleClassify, Long> getDao() {
        return platformDocModuleClassifyMapper;
    }

    @Override
    public List<PlatformDocModuleClassify> queryModuleClassify(long platformId) {
        return platformDocModuleClassifyMapper.queryModuleClassify(platformId);
    }

    @Override
    public boolean addModule(long platformId, String moduleName) {
        int i = platformDocModuleClassifyMapper.addModule(platformId, moduleName);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delModule(long moduleId) {
        int i = platformDocModuleClassifyMapper.delModule(moduleId);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public PlatformDocModuleClassify queryModule(long moduleId) {
        return platformDocModuleClassifyMapper.queryModule(moduleId);
    }
}
