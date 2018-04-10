package com.eliteams.mydoc.web.doc.controller;

import com.eliteams.mydoc.common.entity.*;
import com.eliteams.mydoc.web.department.model.Department;
import com.eliteams.mydoc.web.department.model.UserDepartment;
import com.eliteams.mydoc.web.department.service.DepartmentService;
import com.eliteams.mydoc.web.department.service.UserDepartmentService;
import com.eliteams.mydoc.web.doc.Enum.InterfaceStatusEnum;
import com.eliteams.mydoc.web.doc.model.*;
import com.eliteams.mydoc.web.doc.service.*;
import com.eliteams.mydoc.web.doc.vo.*;
import com.eliteams.mydoc.web.platform.model.PlatformDoc;
import com.eliteams.mydoc.web.platform.model.PlatformDocModuleClassify;
import com.eliteams.mydoc.web.platform.service.PlatformDocModuleClassifyService;
import com.eliteams.mydoc.web.platform.service.PlatformDocService;
import com.eliteams.mydoc.web.user.model.User;
import com.eliteams.mydoc.web.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author [董振]
 * @version [2017/10/17]
 * @since [v1.0]
 */
@RestController
@RequestMapping("/doc")
public class DocumentController {
    private static Logger logger = LoggerFactory
            .getLogger(DocumentController.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Resource
    private UserService userService;

    @Resource
    private InterfaceInfoService interfaceInfoService;

    @Resource
    private InterfaceRequestFieldService interfaceRequestFieldService;

    @Resource
    private InterfaceResponseFieldService interfaceResponseFieldService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private GlobalClassifyService globalClassifyService;

    @Resource
    private GlobalVariableFieldService globalVariableFieldService;

    @Resource
    private PlatformDocModuleClassifyService platformDocModuleClassifyService;

    @Resource
    private DocumentService documentService;

    @Resource
    private PlatformDocService platformDocService;

    @Resource
    private DictionaryTableService dictionaryTableService;

    @Resource
    private UserDepartmentService userDepartmentService;

    /**
     * Java开发人员添加接口
     *
     * @return
     */
    @RequestMapping(value = "/addDoc", method = RequestMethod.POST)
    public Result addDoc(@RequestBody(required = false) RequestParams requestParams) throws Exception {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("userId")) || Objects.isNull(map.get("interfaceInfo")) || Objects.isNull(map.get("interfaceRequestFields"))
                || Objects.isNull(map.get("interfaceResponseFields"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        List<InterfaceRequestField> interfaceRequestFields = new ArrayList<>();
        List<InterfaceResponseField> interfaceResponseFields = new ArrayList<>();
        InterfaceInfo interfaceInfo = objectMapper.readValue(objectMapper.writeValueAsString(map.get("interfaceInfo")), InterfaceInfo.class);
        List interfaceRequestFieldsList = objectMapper.readValue(objectMapper.writeValueAsString(map.get("interfaceRequestFields")), List.class);
        for (int i = 0; i < interfaceRequestFieldsList.size(); i++) {
            interfaceRequestFields.add(objectMapper.readValue(objectMapper.writeValueAsString(interfaceRequestFieldsList.get(i)), InterfaceRequestField.class));
        }
        List interfaceResponseFieldsList = objectMapper.readValue(objectMapper.writeValueAsString(map.get("interfaceResponseFields")), List.class);
        for (int i = 0; i < interfaceResponseFieldsList.size(); i++ ){
            interfaceResponseFields.add(objectMapper.readValue(objectMapper.writeValueAsString(interfaceResponseFieldsList.get(i)), InterfaceResponseField.class));
        }
        GlobalClassify globalClassify = globalClassifyService.queryGlobalClassifyById(interfaceInfo.getGlobalClassifyId());
        if (globalClassify == null) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        boolean bool = documentService.addDocument(interfaceInfo, interfaceRequestFields, interfaceResponseFields);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.ADD_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }

    /**
     * Java开发人员更新接口
     *
     * @return
     */
    @RequestMapping(value = "/updateDoc", method = RequestMethod.POST)
    public Result updateDoc(@RequestBody(required = false) RequestParams requestParams) throws Exception {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("interfaceInfo")) || Objects.isNull(map.get("interfaceRequestFields"))
                || Objects.isNull(map.get("interfaceResponseFields"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        List<InterfaceRequestField> interfaceRequestFields = new ArrayList<>();
        List<InterfaceResponseField> interfaceResponseFields = new ArrayList<>();
        InterfaceInfo interfaceInfo = objectMapper.readValue(objectMapper.writeValueAsString(map.get("interfaceInfo")), InterfaceInfo.class);
        List interfaceRequestFieldsList = objectMapper.readValue(objectMapper.writeValueAsString(map.get("interfaceRequestFields")), List.class);
        for (int i = 0; i < interfaceRequestFieldsList.size(); i++) {
            interfaceRequestFields.add(objectMapper.readValue(objectMapper.writeValueAsString(interfaceRequestFieldsList.get(i)), InterfaceRequestField.class));
        }
        List interfaceResponseFieldsList = objectMapper.readValue(objectMapper.writeValueAsString(map.get("interfaceResponseFields")), List.class);
        for (int i = 0; i < interfaceResponseFieldsList.size(); i++ ){
            interfaceResponseFields.add(objectMapper.readValue(objectMapper.writeValueAsString(interfaceResponseFieldsList.get(i)), InterfaceResponseField.class));
        }
        GlobalClassify globalClassify = globalClassifyService.queryGlobalClassifyById(interfaceInfo.getGlobalClassifyId());
        if (globalClassify == null) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        boolean bool = documentService.updateDocument(interfaceInfo, interfaceRequestFields, interfaceResponseFields);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.UPDATED_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }

    /**
     * Java开发人员删除接口
     *
     * @return
     */
    @RequestMapping(value = "/deleteDoc", method = RequestMethod.POST)
    public Result deleteDoc(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("interfaceInfoId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        Long interfaceInfoId = Long.parseLong(map.get("interfaceInfoId").toString());
        InterfaceInfo interfaceInfo = interfaceInfoService.queryInterfaceInfoById(interfaceInfoId);
        if (interfaceInfo == null) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        boolean bool = documentService.delDocument(interfaceInfoId);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.DELETE_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }

    /**
     * 查看接口
     *
     * @return
     */
    @RequestMapping(value = "/queryInterfaceById", method = RequestMethod.POST)
    public Result queryInterfaceById(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("interfaceInfoId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        Long interfaceInfoId = Long.parseLong(map.get("interfaceInfoId").toString());
        InterfaceInfo interfaceInfo = interfaceInfoService.queryInterfaceInfoById(interfaceInfoId);
        if (interfaceInfo == null) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        List<InterfaceRequestField> interfaceRequestFields = interfaceRequestFieldService.queryRequestByInterfaceId(interfaceInfo.getInterfaceInfoId());
        List<InterfaceResponseField> interfaceResponseFields = interfaceResponseFieldService.queryResponseByInterfaceId(interfaceInfo.getInterfaceInfoId());
        GlobalClassify globalClassify = globalClassifyService.queryGlobalClassifyById(interfaceInfo.getGlobalClassifyId());
        PlatformDoc platformDoc = platformDocService.queryPlatformDocById(interfaceInfo.getPlatformDocId());
        PlatformDocModuleClassify platformDocModuleClassify = platformDocModuleClassifyService.queryModule(interfaceInfo.getPlatformDocModuleClassifyId());
        InterfaceLookVO interfaceLookVO = new InterfaceLookVO();
        interfaceLookVO.setInterfaceInfoId(interfaceInfo.getInterfaceInfoId());
        interfaceLookVO.setInterfaceName(interfaceInfo.getInterfaceName());
        interfaceLookVO.setMethodName(interfaceInfo.getMethodName());
        interfaceLookVO.setMethodPurpose(interfaceInfo.getMethodPurpose());
        interfaceLookVO.setMethodRoute(interfaceInfo.getMethodRoute());
        interfaceLookVO.setMethodRequestDemo(interfaceInfo.getMethodRequestDemo());
        interfaceLookVO.setMethodResultDemo(interfaceInfo.getMethodResultDemo());
        interfaceLookVO.setInterfaceRequestMode(interfaceInfo.getInterfaceRequestMode());
        interfaceLookVO.setInterfaceResponseMode(interfaceInfo.getInterfaceResponseMode());
        interfaceLookVO.setInterfaceCreateUserId(interfaceInfo.getInterfaceCreateUserId());
        interfaceLookVO.setInterfaceCreateUserName(interfaceInfo.getInterfaceCreateUserName());
        interfaceLookVO.setPlatformDocName(platformDoc.getPlatformName());
        interfaceLookVO.setPlatformDocModuleClassifyName(platformDocModuleClassify.getModuleName());
        interfaceLookVO.setInterfaceStatusName(InterfaceStatusEnum.get(interfaceInfo.getInterfaceStatus()).getStatusMsg());
        interfaceLookVO.setInterfaceCreateTime(interfaceInfo.getInterfaceCreateTime());
        if (interfaceInfo.getDepartmentId() == 0) {
            interfaceLookVO.setDepartmentName("全部");
        } else {
            Department department = departmentService.queryDepartmentById(interfaceInfo.getDepartmentId());
            interfaceLookVO.setDepartmentName(department.getDepartmentName());
        }
        interfaceLookVO.setGlobalClassifyName(globalClassify.getGlobalClassifyName());
        LookVO lookVO = new LookVO();
        lookVO.setInterfaceLookVO(interfaceLookVO);
        lookVO.setInterfaceResponseFields(interfaceResponseFields);
        lookVO.setInterfaceRequestFields(interfaceRequestFields);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("interface", lookVO);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 编辑查看接口
     *
     * @return
     */
    @RequestMapping(value = "/editInterfaceById", method = RequestMethod.POST)
    public Result editInterfaceById(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("interfaceInfoId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        long interfaceInfoId = Integer.parseInt(map.get("interfaceInfoId").toString());
        InterfaceInfo interfaceInfo = interfaceInfoService.queryInterfaceInfoById(interfaceInfoId);
        if (interfaceInfo == null) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        List<InterfaceRequestField> interfaceRequestFields = interfaceRequestFieldService.queryRequestByInterfaceId(interfaceInfo.getInterfaceInfoId());
        List<InterfaceResponseField> interfaceResponseFields = interfaceResponseFieldService.queryResponseByInterfaceId(interfaceInfo.getInterfaceInfoId());
        GlobalClassify globalClassify = globalClassifyService.queryGlobalClassifyById(interfaceInfo.getGlobalClassifyId());
        PlatformDoc platformDoc = platformDocService.queryPlatformDocById(interfaceInfo.getPlatformDocId());
        PlatformDocModuleClassify platformDocModuleClassify = platformDocModuleClassifyService.queryModule(interfaceInfo.getPlatformDocModuleClassifyId());
        InterfaceEditVO interfaceEditVO = new InterfaceEditVO();
        interfaceEditVO.setInterfaceInfoId(interfaceInfo.getInterfaceInfoId());
        interfaceEditVO.setInterfaceName(interfaceInfo.getInterfaceName());
        interfaceEditVO.setMethodName(interfaceInfo.getMethodName());
        interfaceEditVO.setMethodPurpose(interfaceInfo.getMethodPurpose());
        interfaceEditVO.setMethodRoute(interfaceInfo.getMethodRoute());
        interfaceEditVO.setMethodRequestDemo(interfaceInfo.getMethodRequestDemo());
        interfaceEditVO.setMethodResultDemo(interfaceInfo.getMethodResultDemo());
        interfaceEditVO.setInterfaceRequestMode(interfaceInfo.getInterfaceRequestMode());
        interfaceEditVO.setInterfaceResponseMode(interfaceInfo.getInterfaceResponseMode());
        interfaceEditVO.setInterfaceCreateUserId(interfaceInfo.getInterfaceCreateUserId());
        interfaceEditVO.setInterfaceCreateUserName(interfaceInfo.getInterfaceCreateUserName());
        interfaceEditVO.setPlatformDocId(platformDoc.getPlatformDocId());
        interfaceEditVO.setPlatformDocModuleClassifyId(platformDocModuleClassify.getPlatformDocModuleClassifyId());
        interfaceEditVO.setInterfaceStatus(interfaceInfo.getInterfaceStatus());
        interfaceEditVO.setInterfaceCreateTime(interfaceInfo.getInterfaceCreateTime());
        interfaceEditVO.setDepartmentId(interfaceInfo.getDepartmentId());
        interfaceEditVO.setGlobalClassifyId(globalClassify.getGlobalClassifyId());
        EditVO editVO = new EditVO();
        editVO.setInterfaceEditVO(interfaceEditVO);
        editVO.setInterfaceResponseFields(interfaceResponseFields);
        editVO.setInterfaceRequestFields(interfaceRequestFields);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("interface", editVO);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 管理人员查看接口
     *
     * @return
     */
    @RequestMapping(value = "/manager", method = RequestMethod.POST)
    public Result manager(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("pageNo")) || Objects.isNull(map.get("pageSize")) || Objects.isNull(map.get("userId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        long userId = Integer.parseInt(map.get("userId").toString());
        if (pageNo < 0 || pageSize < 0) {
            result.paramsError("分页参数有误" + ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        User user = userService.selectByUserId(userId);
        if (user == null) {
            result.paramsError(ResultCodeMessage.USER_NO_EXIST_MESSAGE);
            return result;
        }
        UserDepartment userDepartment = userDepartmentService.selectUserDepartment(user.getUserId());
        if (userDepartment.getDepartmentId() != 1) {
            result.paramsError(ResultCodeMessage.PERMISSION_DENIED_MESSAGE);
            return result;
        }
        String methodName = null;
        String interfaceName = null;
        long moduleId = 0;
        long platformId = 0;
        int status = 0;
        if (!Objects.isNull(map.get("interfaceName"))) {
            String interfaceNameVerify = map.get("interfaceName").toString();
            if (StringUtils.isNotBlank(interfaceNameVerify)) {
                interfaceName = interfaceNameVerify;
            }
        }
        if (!Objects.isNull(map.get("methodName"))) {
            String methodNameVerify = map.get("methodName").toString();
            if (StringUtils.isNotBlank(methodNameVerify)) {
                methodName = methodNameVerify;
            }
        }
        if (!Objects.isNull(map.get("moduleId"))) {
            long moduleIdVerify = Integer.parseInt(map.get("moduleId").toString());
            if (moduleIdVerify != 0) {
                PlatformDocModuleClassify platformDocModuleClassify = platformDocModuleClassifyService.queryModule(moduleIdVerify);
                if (platformDocModuleClassify == null) {
                    result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
                    return result;
                }
                moduleId = moduleIdVerify;
            }
        }
        if (!Objects.isNull(map.get("platformId"))) {
            long platformIdVerify = Integer.parseInt(map.get("platformId").toString());
            if (platformIdVerify != 0) {
                PlatformDoc platformDoc = platformDocService.queryPlatformDocById(platformIdVerify);
                if (platformDoc == null) {
                    result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
                    return result;
                }
                platformId = platformIdVerify;
            }
        }
        if (!Objects.isNull(map.get("status"))) {
            int statusVerify = Integer.parseInt(map.get("status").toString());
            if (statusVerify != 0) {
                status = statusVerify;
            }
        }
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setMethodName(methodName);
        interfaceInfo.setPlatformDocModuleClassifyId(moduleId);
        interfaceInfo.setPlatformDocId(platformId);
        interfaceInfo.setInterfaceStatus(status);
        interfaceInfo.setInterfaceName(interfaceName);
        Pagination<InterfaceViewVO> interfaceInfoVOPagination = interfaceInfoService.queryInterfaceByManager(interfaceInfo, pageSize, pageNo);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("interfaceInfoVO", interfaceInfoVOPagination);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 开发人员查看接口
     *
     * @return
     */
    @RequestMapping(value = "/doc", method = RequestMethod.POST)
    public Result doc(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("pageNo")) || Objects.isNull(map.get("pageSize")) || Objects.isNull(map.get("userId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        long userId = Integer.parseInt(map.get("userId").toString());
        if (pageNo < 0 || pageSize < 0) {
            result.paramsError("分页参数有误" + ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        User user = userService.selectByUserId(userId);
        if (user == null) {
            result.paramsError(ResultCodeMessage.USER_NO_EXIST_MESSAGE);
            return result;
        }
        String methodName = null;
        String interfaceName = null;
        long moduleId = 0;
        long platformId = 0;
        int status = 0;
        if (!Objects.isNull(map.get("methodName"))) {
            String methodNameVerify = map.get("methodName").toString();
            if (StringUtils.isNotBlank(methodNameVerify)) {
                methodName = methodNameVerify;
            }
        }
        if (!Objects.isNull(map.get("interfaceName"))) {
            String interfaceNameVerify = map.get("interfaceName").toString();
            if (StringUtils.isNotBlank(interfaceNameVerify)) {
                interfaceName = interfaceNameVerify;
            }
        }
        if (!Objects.isNull(map.get("moduleId"))) {
            long moduleIdVerify = Integer.parseInt(map.get("moduleId").toString());
            if (moduleIdVerify != 0) {
                PlatformDocModuleClassify platformDocModuleClassify = platformDocModuleClassifyService.queryModule(moduleIdVerify);
                if (platformDocModuleClassify == null) {
                    result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
                    return result;
                }
                moduleId = moduleIdVerify;
            }
        }
        if (!Objects.isNull(map.get("platformId"))) {
            long platformIdVerify = Integer.parseInt(map.get("platformId").toString());
            if (platformIdVerify != 0) {
                PlatformDoc platformDoc = platformDocService.queryPlatformDocById(platformIdVerify);
                if (platformDoc == null) {
                    result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
                    return result;
                }
                platformId = platformIdVerify;
            }
        }
        if (!Objects.isNull(map.get("status"))) {
            int statusVerify = Integer.parseInt(map.get("status").toString());
            if (statusVerify != 0) {
                status = statusVerify;
            }
        }
        UserDepartment userDepartment = userDepartmentService.selectUserDepartment(user.getUserId());
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setDepartmentId(userDepartment.getDepartmentId());
        interfaceInfo.setMethodName(methodName);
        interfaceInfo.setPlatformDocModuleClassifyId(moduleId);
        interfaceInfo.setPlatformDocId(platformId);
        interfaceInfo.setInterfaceStatus(status);
        interfaceInfo.setInterfaceName(interfaceName);
        Pagination<InterfaceViewVO> interfaceInfoVOPagination = interfaceInfoService.queryInterfaceByDepartmentId(interfaceInfo, pageSize, pageNo);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("interfaceInfoVO", interfaceInfoVOPagination);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 平台下面的接口 并且根据用户的部门分类
     *
     * @return
     */
    @RequestMapping(value = "/platformDoc", method = RequestMethod.POST)
    public Result platformDoc(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("pageNo")) || Objects.isNull(map.get("pageSize")) || Objects.isNull(map.get("userId"))
                || Objects.isNull(map.get("platformId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        long userId = Integer.parseInt(map.get("userId").toString());
        if (pageNo < 0 || pageSize < 0) {
            result.paramsError("分页参数有误" + ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        User user = userService.selectByUserId(userId);
        if (user == null) {
            result.paramsError(ResultCodeMessage.USER_NO_EXIST_MESSAGE);
            return result;
        }
        String interfaceName = null;
        String methodName = null;
        long moduleId = 0;
        long platformId = 0;
        int status = 0;
        if (!Objects.isNull(map.get("interfaceName"))) {
            String interfaceNameVerify = map.get("interfaceName").toString();
            if (StringUtils.isNotBlank(interfaceNameVerify)) {
                interfaceName = interfaceNameVerify;
            }
        }
        if (!Objects.isNull(map.get("methodName"))) {
            String methodNameVerify = map.get("methodName").toString();
            if (StringUtils.isNotBlank(methodNameVerify)) {
                methodName = methodNameVerify;
            }
        }
        long platformIdVerify = Integer.parseInt(map.get("platformId").toString());
        if (platformIdVerify != 0) {
            PlatformDoc platformDoc = platformDocService.queryPlatformDocById(platformIdVerify);
            if (platformDoc == null) {
                result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
                return result;
            }
            platformId = platformIdVerify;
        }
        if (!Objects.isNull(map.get("moduleId"))) {
            long moduleIdVerify = Integer.parseInt(map.get("moduleId").toString());
            if (moduleIdVerify != 0) {
                PlatformDocModuleClassify platformDocModuleClassify = platformDocModuleClassifyService.queryModule(moduleIdVerify);
                if (platformDocModuleClassify == null) {
                    result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
                    return result;
                }
                moduleId = moduleIdVerify;
            }
        }
        if (!Objects.isNull(map.get("status"))) {
            int statusVerify = Integer.parseInt(map.get("status").toString());
            if (statusVerify != 0) {
                status = statusVerify;
            }
        }
        UserDepartment userDepartment = userDepartmentService.selectUserDepartment(user.getUserId());
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setDepartmentId(userDepartment.getDepartmentId());
        interfaceInfo.setMethodName(methodName);
        interfaceInfo.setPlatformDocModuleClassifyId(moduleId);
        interfaceInfo.setPlatformDocId(platformId);
        interfaceInfo.setInterfaceStatus(status);
        interfaceInfo.setInterfaceName(interfaceName);
        Pagination<InterfaceViewVO> interfaceInfoVOPagination = interfaceInfoService.queryInterfaceByDepartmentId(interfaceInfo, pageSize, pageNo);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("interfaceInfoVO", interfaceInfoVOPagination);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 首页接口
     *
     * @return
     */
    @RequestMapping(value = "/homePage", method = RequestMethod.POST)
    public Result homePage(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("userId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        long userId = Integer.parseInt(map.get("userId").toString());
        int countJava = interfaceInfoService.countInterfaceJava();
        UserDepartment userDepartment = userDepartmentService.selectUserDepartment(userId);
        int count = interfaceInfoService.countInterface(userDepartment.getDepartmentId());
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("1", countJava);
        paramsList.put("2", count);
        Pagination<PlatformDoc> platformDocPagination = platformDocService.queryPlatformDoc(9999, 1);
        paramsList.put("3", platformDocPagination.getTotal());
        Pagination<GlobalClassify> globalClassifyPagination = globalClassifyService.queryGlobalClassify(9999, 1);
        paramsList.put("4", globalClassifyPagination.getTotal());
        Pagination<DictionaryTable> dictionaryTablePagination = dictionaryTableService.queryDictionaryTable(9999, 1, new DictionaryTable());
        paramsList.put("5", dictionaryTablePagination.getTotal());
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 添加全局参数 -- 集合壳子
     *
     * @return
     */
    @RequestMapping(value = "/addGlobalFieldShell", method = RequestMethod.POST)
    public Result addGlobalFieldShell(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("globalClassifyName")) || Objects.isNull(map.get("globalClassifyStatus"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        String globalClassifyName = map.get("globalClassifyName").toString();
        int globalClassifyStatus = Integer.parseInt(map.get("globalClassifyStatus").toString());
        GlobalClassify globalClassify = new GlobalClassify();
        globalClassify.setGlobalClassifyName(globalClassifyName);
        globalClassify.setGlobalClassifyStatus(globalClassifyStatus);
        globalClassify.setGlobalClassifyCreateTime(new Date());
        boolean bool = documentService.addGlobalFieldShell(globalClassify);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.ADD_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }

    /**
     * 添加全局参数 -- 具体参数
     *
     * @return
     */
    @RequestMapping(value = "/addGlobalField", method = RequestMethod.POST)
    public Result addGlobalField(@RequestBody(required = false) RequestParams requestParams) throws Exception {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("globalVariableField"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        GlobalVariableField globalVariableField = objectMapper.readValue(objectMapper.writeValueAsString(map.get("globalVariableField")), GlobalVariableField.class);
        GlobalClassify globalClassify = globalClassifyService.queryGlobalClassifyById(globalVariableField.getGlobalClassifyId());
        if (globalClassify == null) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        boolean bool = documentService.addGlobalField(globalVariableField);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.ADD_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }

    /**
     * 查询全局变量集合
     *
     * @return
     */
    @RequestMapping(value = "/queryGlobalFieldGroup", method = RequestMethod.POST)
    public Result queryGlobalFieldGroup(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("pageNo")) || Objects.isNull(map.get("pageSize"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        if (pageNo < 0 || pageSize < 0) {
            result.paramsError("分页参数有误" + ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        Map<String, Object> paramsList = new HashMap<>();
        Pagination<GlobalClassify> globalClassifies = globalClassifyService.queryGlobalClassify(pageSize, pageNo);
        paramsList.put("globalClassifies", globalClassifies);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 根据全局集合Id查询全局变量 -- 请求
     *
     * @return
     */
    @RequestMapping(value = "/queryGlobalFieldRequest", method = RequestMethod.POST)
    public Result queryGlobalFieldRequest(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("globalClassifyId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        long globalClassifyId = Integer.parseInt(map.get("globalClassifyId").toString());
        GlobalClassify globalClassify = globalClassifyService.queryGlobalClassifyById(globalClassifyId);
        if (globalClassify == null) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        Map<String, Object> paramsList = new HashMap<>();
        List<GlobalVariableField> globalVariableFields = globalVariableFieldService.queryGlobalField(globalClassifyId, 1);
        paramsList.put("globalVariableFields", globalVariableFields);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 根据全局集合Id查询全局变量 -- 响应
     *
     * @return
     */
    @RequestMapping(value = "/queryGlobalFieldResult", method = RequestMethod.POST)
    public Result queryGlobalFieldResult(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("globalClassifyId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        long globalClassifyId = Integer.parseInt(map.get("globalClassifyId").toString());
        GlobalClassify globalClassify = globalClassifyService.queryGlobalClassifyById(globalClassifyId);
        if (globalClassify == null) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        Map<String, Object> paramsList = new HashMap<>();
        List<GlobalVariableField> globalVariableFields = globalVariableFieldService.queryGlobalField(globalClassifyId, 2);
        paramsList.put("globalVariableFields", globalVariableFields);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 删除全局变量字段
     *
     * @return
     */
    @RequestMapping(value = "/delGlobalField", method = RequestMethod.POST)
    public Result delGlobalField(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("globalVariableFieldId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        long globalVariableFieldId = Integer.parseInt(map.get("globalVariableFieldId").toString());
        boolean bool = globalVariableFieldService.delGlobalField(globalVariableFieldId);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.DELETE_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }

    /**
     * 添加请求字段
     *
     * @return
     */
    @RequestMapping(value = "/addRequestField", method = RequestMethod.POST)
    public Result addRequestField(@RequestBody(required = false) RequestParams requestParams) throws Exception {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("interfaceInfoId")) || Objects.isNull(map.get("interfaceRequestFields"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        long interfaceInfoId = Integer.parseInt(map.get("interfaceInfoId").toString());
        List<InterfaceRequestField> interfaceRequestFields = new ArrayList<>();
        List interfaceRequestFieldsList = objectMapper.readValue(objectMapper.writeValueAsString(map.get("interfaceRequestFields")), List.class);
        for (int i = 0; i < interfaceRequestFieldsList.size(); i++) {
            interfaceRequestFields.add(objectMapper.readValue(objectMapper.writeValueAsString(interfaceRequestFieldsList.get(i)), InterfaceRequestField.class));
        }
        InterfaceInfo interfaceInfo = interfaceInfoService.queryInterfaceInfoById(interfaceInfoId);
        if (interfaceInfo == null) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        boolean bool = interfaceRequestFieldService.addRequestField(interfaceInfoId, interfaceRequestFields);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.ADD_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }

    /**
     * 更新请求字段
     *
     * @return
     */
    @RequestMapping(value = "/updateRequestField", method = RequestMethod.POST)
    public Result updateRequestField(@RequestBody(required = false) RequestParams requestParams) throws Exception {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("interfaceRequestField"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        InterfaceRequestField interfaceRequestField  = objectMapper.readValue(objectMapper.writeValueAsString(map.get("InterfaceRequestField")), InterfaceRequestField.class);
        boolean bool = interfaceRequestFieldService.updateRequestField(interfaceRequestField);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.UPDATED_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }

    /**
     * 删除请求字段
     *
     * @return
     */
    @RequestMapping(value = "/delRequestField", method = RequestMethod.POST)
    public Result delRequestField(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("interfaceRequestFieldId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        long interfaceRequestFieldId = Integer.parseInt(map.get("interfaceRequestFieldId").toString());
        boolean bool = interfaceRequestFieldService.delRequestField(interfaceRequestFieldId);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.DELETE_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }

    /**
     * 添加响应字段
     *
     * @return
     */
    @RequestMapping(value = "/addResponseField", method = RequestMethod.POST)
    public Result addResponseField(@RequestBody(required = false) RequestParams requestParams) throws Exception {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("interfaceInfoId")) || Objects.isNull(map.get("interfaceResponseFields"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        long interfaceInfoId = Integer.parseInt(map.get("interfaceInfoId").toString());
        List<InterfaceResponseField> interfaceResponseFields = new ArrayList<>();
        List interfaceResponseFieldsList = objectMapper.readValue(objectMapper.writeValueAsString(map.get("interfaceResponseFields")), List.class);
        for (int i = 0; i < interfaceResponseFieldsList.size(); i++ ){
            interfaceResponseFields.add(objectMapper.readValue(objectMapper.writeValueAsString(interfaceResponseFieldsList.get(i)), InterfaceResponseField.class));
        }
        InterfaceInfo interfaceInfo = interfaceInfoService.queryInterfaceInfoById(interfaceInfoId);
        if (interfaceInfo == null) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
        }
        boolean bool = interfaceResponseFieldService.addResponseField(interfaceInfoId, interfaceResponseFields);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.ADD_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }

    /**
     * 更新响应字段
     *
     * @return
     */
    @RequestMapping(value = "/updateResponseField", method = RequestMethod.POST)
    public Result updateResponseField(@RequestBody(required = false) RequestParams requestParams) throws Exception{
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("interfaceResponseField"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        InterfaceResponseField interfaceResponseField = objectMapper.readValue(objectMapper.writeValueAsString(map.get("interfaceResponseField")), InterfaceResponseField.class);
        boolean bool = interfaceResponseFieldService.updateResponseField(interfaceResponseField);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.UPDATED_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }

    /**
     * 删除响应字段
     *
     * @return
     */
    @RequestMapping(value = "/delResponseField", method = RequestMethod.POST)
    public Result delResponseField(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("interfaceResponseFieldId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        long interfaceResponseFieldId = Integer.parseInt(map.get("interfaceResponseFieldId").toString());
        boolean bool = interfaceResponseFieldService.delResponseField(interfaceResponseFieldId);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.DELETE_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }

    /**
     * 搜索字典表
     *
     * @return
     */
    @RequestMapping(value = "/queryDictionaryField", method = RequestMethod.POST)
    public Result queryDictionaryField(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("pageNo")) || Objects.isNull(map.get("pageSize"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        int pageNo = Integer.parseInt(map.get("pageNo").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        if (pageNo < 0 || pageSize < 0) {
            result.paramsError("分页参数有误" + ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        DictionaryTable dictionaryTable = new DictionaryTable();
        if (!Objects.isNull(map.get("code"))) {
            if (StringUtils.isNotBlank(map.get("code").toString())) {
                dictionaryTable.setDictionaryTableCode(Integer.parseInt(map.get("code").toString()));
            }
        }

        if (!Objects.isNull(map.get("message"))) {
            if (StringUtils.isNotBlank(map.get("message").toString())){
                dictionaryTable.setDictionaryTableMessage(map.get("message").toString());
            }
        }

        if (!Objects.isNull(map.get("rank"))) {
            dictionaryTable.setDictionaryTableRank(Integer.parseInt(map.get("rank").toString()));
        }

        if (!Objects.isNull(map.get("platformId"))) {
            dictionaryTable.setDictionaryTablePlatform(Integer.parseInt(map.get("platformId").toString()));
        }
        Pagination<DictionaryTable> dictionaryTablePagination = dictionaryTableService.queryDictionaryTable(pageSize, pageNo, dictionaryTable);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("dictionaryTablePagination", dictionaryTablePagination);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 添加字典表
     *
     * @return
     */
    @RequestMapping(value = "/addDictionaryField", method = RequestMethod.POST)
    public Result addDictionaryField(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("code")) || Objects.isNull(map.get("message")) || Objects.isNull(map.get("rank"))
                || Objects.isNull(map.get("platformId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        int rank = Integer.parseInt(map.get("rank").toString());
        long platformId = Integer.parseInt(map.get("platformId").toString());
        if (StringUtils.isBlank(map.get("code").toString()) || StringUtils.isBlank(map.get("message").toString()) || rank == 0 || platformId ==0) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        long code = Integer.parseInt(map.get("code").toString());
        String message = map.get("message").toString();
        PlatformDoc platformDoc = platformDocService.queryPlatformDocById(platformId);
        if (platformDoc == null) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        DictionaryTable dictionaryTable = new DictionaryTable();
        dictionaryTable.setDictionaryTableCode(code);
        dictionaryTable.setDictionaryTableMessage(message);
        dictionaryTable.setDictionaryTablePlatform(platformId);
        dictionaryTable.setDictionaryTableRank(rank);
        boolean bool = dictionaryTableService.addDictionaryTable(dictionaryTable);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.ADD_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }

    /**
     * 更新字典表
     *
     * @return
     */
    @RequestMapping(value = "/updateDictionaryField", method = RequestMethod.POST)
    public Result updateDictionaryField(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("dictionaryTableId")) || Objects.isNull(map.get("code")) || Objects.isNull(map.get("message")) || Objects.isNull(map.get("rank"))
                || Objects.isNull(map.get("platformId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        int rank = Integer.parseInt(map.get("rank").toString());
        long platformId = Integer.parseInt(map.get("platformId").toString());
        if (StringUtils.isBlank(map.get("dictionaryTableId").toString()) || StringUtils.isBlank(map.get("code").toString()) || StringUtils.isBlank(map.get("message").toString()) || rank == 0 || platformId ==0) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        long dictionaryTableId = Integer.parseInt(map.get("dictionaryTableId").toString());
        long code = Integer.parseInt(map.get("code").toString());
        String message = map.get("message").toString();
        PlatformDoc platformDoc = platformDocService.queryPlatformDocById(platformId);
        if (platformDoc == null) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        DictionaryTable dictionaryTable = new DictionaryTable();
        dictionaryTable.setDictionaryTableId(dictionaryTableId);
        dictionaryTable.setDictionaryTableCode(code);
        dictionaryTable.setDictionaryTableMessage(message);
        dictionaryTable.setDictionaryTablePlatform(platformId);
        dictionaryTable.setDictionaryTableRank(rank);
        boolean bool = dictionaryTableService.updateDictionaryTable(dictionaryTable);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.UPDATED_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }

    /**
     * 根据id查询字典表
     *
     * @return
     */
    @RequestMapping(value = "/queryDictionaryFieldById", method = RequestMethod.POST)
    public Result queryDictionaryFieldById(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("dictionaryTableId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        long dictionaryTableId = Integer.parseInt(map.get("dictionaryTableId").toString());
        DictionaryTable dictionaryTable = dictionaryTableService.queryDictionaryTableId(dictionaryTableId);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("dictionaryTable", dictionaryTable);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.DELETE_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 删除字典表
     *
     * @return
     */
    @RequestMapping(value = "/delDictionaryField", method = RequestMethod.POST)
    public Result delDictionaryField(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("dictionaryTableId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        long dictionaryTableId = Integer.parseInt(map.get("dictionaryTableId").toString());
        boolean bool = dictionaryTableService.delDictionaryTable(dictionaryTableId);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.DELETE_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }


    /**
     * 项目平台分类
     *
     * @return
     */
    @RequestMapping(value = "/queryPlatform", method = RequestMethod.POST)
    public Result queryPlatform(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("userId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        long userId = Integer.parseInt(map.get("userId").toString());
        User user = userService.selectByUserId(userId);
        if (user == null) {
            result.paramsError(ResultCodeMessage.USER_NO_EXIST_MESSAGE);
            return result;
        }
        UserDepartment userDepartment = userDepartmentService.selectUserDepartment(user.getUserId());
        Pagination<PlatformDoc> platformDocPagination = platformDocService.queryPlatformDoc(9999, 1);
        List<PlatformDoc> list = platformDocPagination.getList();
        List<PlatformHomeVO> platformHomeVOS = new ArrayList<>();
        for (int i = 0; i<list.size(); i++) {
            PlatformHomeVO platformHomeVO = new PlatformHomeVO();
            int count = interfaceInfoService.countPlatformInterface(list.get(i).getPlatformDocId(), userDepartment.getDepartmentId());
            platformHomeVO.setPlatformName(list.get(i).getPlatformName());
            platformHomeVO.setCount(count);
            platformHomeVO.setPlatformDocId(list.get(i).getPlatformDocId());
            platformHomeVOS.add(platformHomeVO);
        }
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("platform", platformHomeVOS);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 查询所有数据类型
     *
     * @return
     */
    @RequestMapping(value = "/queryDataType", method = RequestMethod.POST)
    public Result queryDataType(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        List<DataType> dataTypes = interfaceInfoService.selectDateType();
        List<String> collect = dataTypes.stream().map(DataType::getType).collect(Collectors.toList());
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("dataType", collect);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }
}
