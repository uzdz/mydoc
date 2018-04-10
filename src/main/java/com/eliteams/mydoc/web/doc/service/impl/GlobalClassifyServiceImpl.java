package com.eliteams.mydoc.web.doc.service.impl;

import com.eliteams.mydoc.common.entity.Pagination;
import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.common.generic.GenericServiceImpl;
import com.eliteams.mydoc.web.doc.dao.GlobalClassifyMapper;
import com.eliteams.mydoc.web.doc.model.GlobalClassify;
import com.eliteams.mydoc.web.doc.service.GlobalClassifyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/27]
 * @since [v1.0]
 */
@Service
public class GlobalClassifyServiceImpl extends GenericServiceImpl<GlobalClassify, Long> implements GlobalClassifyService {

    @Resource
    private GlobalClassifyMapper globalClassifyMapper;

    @Override
    public GenericDao<GlobalClassify, Long> getDao() {
        return null;
    }

    @Override
    public boolean addGlobalClassify(GlobalClassify globalClassify) {
        int i = globalClassifyMapper.addGlobalClassify(globalClassify);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Pagination<GlobalClassify> queryGlobalClassify(int pageSize, int pageNo) {
        PageHelper.startPage(pageNo, pageSize);
        List<GlobalClassify> globalClassifies = globalClassifyMapper.queryGlobalClassify();
        PageInfo<GlobalClassify> pageInfo = new PageInfo<GlobalClassify>(globalClassifies);
        return new Pagination<GlobalClassify>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public GlobalClassify queryGlobalClassifyById(long globalClassifyId) {
        return globalClassifyMapper.queryGlobalClassifyById(globalClassifyId);
    }
}
