package com.eliteams.mydoc.web.doc.service.impl;

import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.common.generic.GenericServiceImpl;
import com.eliteams.mydoc.web.doc.dao.InterfaceRequestFieldMapper;
import com.eliteams.mydoc.web.doc.model.InterfaceRequestField;
import com.eliteams.mydoc.web.doc.service.InterfaceRequestFieldService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
@Service
public class InterfaceRequestFieldServiceImpl extends GenericServiceImpl<InterfaceRequestField, Long> implements InterfaceRequestFieldService{

    @Resource
    private InterfaceRequestFieldMapper interfaceRequestFieldMapper;

    @Override
    public GenericDao<InterfaceRequestField, Long> getDao() {
        return interfaceRequestFieldMapper;
    }

    @Override
    public boolean addInterfaceRequestField(List<InterfaceRequestField> interfaceRequestFields) {
        boolean bool = false;
        for (InterfaceRequestField i:interfaceRequestFields) {
            int b = interfaceRequestFieldMapper.addInterfaceRequestField(i);
            if (b == 1) {
                bool = true;
            }
        }
        return bool;
    }

    @Override
    public boolean delInterfaceRequestField(long interfaceInfoId) {
        int i = interfaceRequestFieldMapper.delInterfaceRequestField(interfaceInfoId);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addRequestField(long interfaceInfoId, List<InterfaceRequestField> interfaceRequestFields) {
        for (InterfaceRequestField interfaceRequestField:interfaceRequestFields) {
            interfaceRequestField.setInterfaceInfoId(interfaceInfoId);
            int count = interfaceRequestFieldMapper.addInterfaceRequestField(interfaceRequestField);
            if (count != 1) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean delRequestField(long interfaceRequestFieldId) {
        int i = interfaceRequestFieldMapper.delRequestField(interfaceRequestFieldId);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRequestField(InterfaceRequestField interfaceRequestField) {
        int b = interfaceRequestFieldMapper.updateRequestField(interfaceRequestField);
        if (b == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<InterfaceRequestField> queryRequestByInterfaceId(long interfaceId) {
        return interfaceRequestFieldMapper.queryRequestByInterfaceId(interfaceId);
    }
}
