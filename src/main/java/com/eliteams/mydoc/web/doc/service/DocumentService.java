package com.eliteams.mydoc.web.doc.service;

import com.eliteams.mydoc.web.doc.model.*;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/11/8]
 * @since [v1.0]
 */
public interface DocumentService {
    /**
     * 添加接口
     * @param interfaceInfo
     * @param interfaceRequestFields
     * @param interfaceResponseFields
     * @return
     */
    boolean addDocument(InterfaceInfo interfaceInfo, List<InterfaceRequestField> interfaceRequestFields, List<InterfaceResponseField> interfaceResponseFields);

    /**
     * 更新接口
     * @param interfaceInfo
     * @param interfaceRequestFields
     * @param interfaceResponseFields
     * @return
     */
    boolean updateDocument(InterfaceInfo interfaceInfo, List<InterfaceRequestField> interfaceRequestFields, List<InterfaceResponseField> interfaceResponseFields);

    /**
     * 删除接口
     * @param interfaceInfoId
     * @return
     */
    boolean delDocument(long interfaceInfoId);

    /**
     * 添加全局参数
     * @param globalVariableField
     * @return
     */
    boolean addGlobalField(GlobalVariableField globalVariableField);

    /**
     * 添加全局参数 -- 壳子
     * @param globalClassify
     * @return
     */
    boolean addGlobalFieldShell(GlobalClassify globalClassify);
}
