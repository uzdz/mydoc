package com.eliteams.mydoc.web.doc.service.impl;

import com.eliteams.mydoc.common.entity.Pagination;
import com.eliteams.mydoc.web.doc.dao.DictionaryTableMapper;
import com.eliteams.mydoc.web.doc.model.DictionaryTable;
import com.eliteams.mydoc.web.doc.service.DictionaryTableService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author [董振]
 * @version [2017/11/14]
 * @since [v1.0]
 */
@Service
public class DictionaryTableServiceImpl implements DictionaryTableService {

    @Resource
    private DictionaryTableMapper dictionaryTableMapper;

    @Override
    public boolean addDictionaryTable(DictionaryTable dictionaryTable) {
        int i = dictionaryTableMapper.addDictionaryTable(dictionaryTable);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delDictionaryTable(long dictionaryTableId) {
        int i = dictionaryTableMapper.delDictionaryTable(dictionaryTableId);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public DictionaryTable queryDictionaryTableId(long dictionaryTableId) {
        return dictionaryTableMapper.queryDictionaryTableId(dictionaryTableId);
    }

    @Override
    public boolean updateDictionaryTable(DictionaryTable dictionaryTable) {
        int i = dictionaryTableMapper.updateDictionaryTable(dictionaryTable);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Pagination<DictionaryTable> queryDictionaryTable(int pageSize, int pageNo, DictionaryTable dictionaryTable) {
        PageHelper.startPage(pageNo, pageSize);
        List<DictionaryTable> dictionaryTables = dictionaryTableMapper.queryDictionaryTable(dictionaryTable);
        PageInfo<DictionaryTable> pageInfo = new PageInfo<DictionaryTable>(dictionaryTables);
        return new Pagination<DictionaryTable>(pageInfo.getTotal(), pageInfo.getList());
    }
}
