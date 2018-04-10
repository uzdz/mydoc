package com.eliteams.mydoc.web.doc.vo;

import com.eliteams.mydoc.web.doc.model.InterfaceRequestField;
import com.eliteams.mydoc.web.doc.model.InterfaceResponseField;

import java.util.List;

/**
 * @author [董振]
 * @version [2017/11/14]
 * @since [v1.0]
 */
public class EditVO {
    private InterfaceEditVO interfaceEditVO;
    private List<InterfaceRequestField> interfaceRequestFields;
    private List<InterfaceResponseField> interfaceResponseFields;

    public InterfaceEditVO getInterfaceEditVO() {
        return interfaceEditVO;
    }

    public void setInterfaceEditVO(InterfaceEditVO interfaceEditVO) {
        this.interfaceEditVO = interfaceEditVO;
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
