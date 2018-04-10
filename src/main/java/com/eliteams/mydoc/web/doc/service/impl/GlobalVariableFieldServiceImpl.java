package com.eliteams.mydoc.web.doc.service.impl;

import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.common.generic.GenericServiceImpl;
import com.eliteams.mydoc.web.doc.dao.GlobalVariableFieldMapper;
import com.eliteams.mydoc.web.doc.model.GlobalVariableField;
import com.eliteams.mydoc.web.doc.service.GlobalVariableFieldService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
@Service
public class GlobalVariableFieldServiceImpl extends GenericServiceImpl<GlobalVariableField, Long> implements GlobalVariableFieldService {

    @Resource
    private GlobalVariableFieldMapper globalVariableFieldMapper;

    @Override
    public GenericDao<GlobalVariableField, Long> getDao() {
        return null;
    }

    @Override
    public boolean addGlobalVariableField(GlobalVariableField globalVariableField) {
        int i = globalVariableFieldMapper.addGlobalVariableField(globalVariableField);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<GlobalVariableField> queryGlobalField(long globalClassifyId, int type) {
        return globalVariableFieldMapper.queryGlobalField(globalClassifyId, type);
    }

    @Override
    public boolean delGlobalField(long globalVariableFieldId) {
        int i = globalVariableFieldMapper.delGlobalField(globalVariableFieldId);
        if (i == 1) {
            return true;
        }
        return false;
    }
}
