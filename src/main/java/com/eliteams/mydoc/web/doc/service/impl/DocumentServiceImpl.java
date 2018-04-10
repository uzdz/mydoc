package com.eliteams.mydoc.web.doc.service.impl;

import com.eliteams.mydoc.web.doc.dao.*;
import com.eliteams.mydoc.web.doc.model.*;
import com.eliteams.mydoc.web.doc.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author [董振]
 * @version [2017/11/8]
 * @since [v1.0]
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    private static Logger logger = LoggerFactory
            .getLogger(DocumentServiceImpl.class);

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Resource
    private InterfaceRequestFieldMapper interfaceRequestFieldMapper;

    @Resource
    private InterfaceResponseFieldMapper interfaceResponseFieldMapper;

    @Resource
    private GlobalClassifyMapper globalClassifyMapper;

    @Resource
    private GlobalVariableFieldMapper globalVariableFieldMapper;

    @Override
    public boolean addDocument(InterfaceInfo interfaceInfo, List<InterfaceRequestField> interfaceRequestFields, List<InterfaceResponseField> interfaceResponseFields) {
        logger.info("接口添加成功");
        int i = interfaceInfoMapper.addInterfaceInfo(interfaceInfo);
        if (i == 1) {
            logger.info("接口请求参数添加成功");
            for (InterfaceRequestField interfaceRequestField : interfaceRequestFields) {
                interfaceRequestField.setInterfaceInfoId(interfaceInfo.getInterfaceInfoId());
                int count = interfaceRequestFieldMapper.addInterfaceRequestField(interfaceRequestField);
                if (count != 1) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return false;
                }
            }
            logger.info("接口响应参数添加成功");
            for (InterfaceResponseField interfaceResponseField : interfaceResponseFields) {
                interfaceResponseField.setInterfaceInfoId(interfaceInfo.getInterfaceInfoId());
                int count = interfaceResponseFieldMapper.addInterfaceResponseField(interfaceResponseField);
                if (count != 1) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean updateDocument(InterfaceInfo interfaceInfo, List<InterfaceRequestField> interfaceRequestFields, List<InterfaceResponseField> interfaceResponseFields) {
        logger.info("接口更新成功");
        int i = interfaceInfoMapper.updateInterfaceInfo(interfaceInfo);
        if (i == 1) {
            logger.info("原接口请求参数删除成功");
            interfaceRequestFieldMapper.delInterfaceRequestField(interfaceInfo.getInterfaceInfoId());
            logger.info("接口请求参数添加成功");
            for (InterfaceRequestField interfaceRequestField : interfaceRequestFields) {
                interfaceRequestField.setInterfaceInfoId(interfaceInfo.getInterfaceInfoId());
                int count = interfaceRequestFieldMapper.addInterfaceRequestField(interfaceRequestField);
                if (count != 1) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return false;
                }
            }
            logger.info("原接口响应参数删除成功");
            int delResponse = interfaceResponseFieldMapper.delInterfaceResponseField(interfaceInfo.getInterfaceInfoId());
            logger.info("接口响应参数添加成功");
            for (InterfaceResponseField interfaceResponseField : interfaceResponseFields) {
                interfaceResponseField.setInterfaceInfoId(interfaceInfo.getInterfaceInfoId());
                int count = interfaceResponseFieldMapper.addInterfaceResponseField(interfaceResponseField);
                if (count != 1) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean delDocument(long interfaceInfoId) {
        int interfaceCount = interfaceInfoMapper.delInterfaceInfoById(interfaceInfoId);
        if (interfaceCount == 0) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        interfaceRequestFieldMapper.delInterfaceRequestField(interfaceInfoId);
        interfaceResponseFieldMapper.delInterfaceResponseField(interfaceInfoId);
        return true;
    }

    @Override
    public boolean addGlobalField(GlobalVariableField globalVariableField) {
        int addGlobalVariableField = globalVariableFieldMapper.addGlobalVariableField(globalVariableField);
        if (addGlobalVariableField == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addGlobalFieldShell(GlobalClassify globalClassify) {
        int addGlobalClassifyCount = globalClassifyMapper.addGlobalClassify(globalClassify);
        if (addGlobalClassifyCount == 1) {
            return true;
        }
        return false;
    }
}
