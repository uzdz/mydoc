package com.eliteams.mydoc.web.doc.vo;

import com.eliteams.mydoc.web.doc.model.InterfaceRequestField;
import com.eliteams.mydoc.web.doc.model.InterfaceResponseField;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/11/14]
 * @since [v1.0]
 */
public class LookVO {
    private InterfaceLookVO interfaceLookVO;
    private List<InterfaceRequestField> interfaceRequestFields;
    private List<InterfaceResponseField> interfaceResponseFields;

    public InterfaceLookVO getInterfaceLookVO() {
        return interfaceLookVO;
    }

    public void setInterfaceLookVO(InterfaceLookVO interfaceLookVO) {
        this.interfaceLookVO = interfaceLookVO;
    }

    public List<InterfaceRequestField> getInterfaceRequestFields() {
        return interfaceRequestFields;
    }

    public void setInterfaceRequestFields(List<InterfaceRequestField> interfaceRequestFields) {
        this.interfaceRequestFields = interfaceRequestFields;
    }

    public List<InterfaceResponseField> getInterfaceResponseFields() {
        return interfaceResponseFields;
    }

    public void setInterfaceResponseFields(List<InterfaceResponseField> interfaceResponseFields) {
        this.interfaceResponseFields = interfaceResponseFields;
    }
}
