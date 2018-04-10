package com.eliteams.mydoc.web.doc.service.impl;

import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.common.generic.GenericServiceImpl;
import com.eliteams.mydoc.web.doc.dao.InterfaceResponseFieldMapper;
import com.eliteams.mydoc.web.doc.model.InterfaceResponseField;
import com.eliteams.mydoc.web.doc.service.InterfaceResponseFieldService;
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
public class InterfaceResponseFieldServiceImpl extends GenericServiceImpl<InterfaceResponseField, Long> implements InterfaceResponseFieldService {

    @Resource
    private InterfaceResponseFieldMapper interfaceResponseFieldMapper;

    @Override
    public GenericDao<InterfaceResponseField, Long> getDao() {
        return interfaceResponseFieldMapper;
    }

    @Override
    public boolean addInterfaceResponseField(List<InterfaceResponseField> interfaceResponseFields) {
        boolean bool = false;
        for (InterfaceResponseField i:interfaceResponseFields) {
            int b = interfaceResponseFieldMapper.addInterfaceResponseField(i);
            if (b == 1) {
                bool = true;
            }
        }
        return bool;
    }

    @Override
    public boolean delInterfaceResponseField(long interfaceInfoId) {
        int i = interfaceResponseFieldMapper.delInterfaceResponseField(interfaceInfoId);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delResponseField(long interfaceResponseFieldId) {
        int i = interfaceResponseFieldMapper.delResponseField(interfaceResponseFieldId);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addResponseField(long interfaceInfoId, List<InterfaceResponseField> interfaceResponseFields) {
        for (InterfaceResponseField interfaceResponseField: interfaceResponseFields) {
            interfaceResponseField.setInterfaceInfoId(interfaceInfoId);
            int count = interfaceResponseFieldMapper.addInterfaceResponseField(interfaceResponseField);
            if (count != 1) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateResponseField(InterfaceResponseField interfaceResponseField) {
        interfaceResponseFieldMapper.updateResponseField(interfaceResponseField);
        return true;
    }

    @Override
    public List<InterfaceResponseField> queryResponseByInterfaceId(long interfaceId) {
        return interfaceResponseFieldMapper.queryResponseByInterfaceId(interfaceId);
    }
}
