package com.eliteams.mydoc.web.platform.controller;

import com.eliteams.mydoc.common.entity.Pagination;
import com.eliteams.mydoc.common.entity.RequestParams;
import com.eliteams.mydoc.common.entity.Result;
import com.eliteams.mydoc.common.entity.ResultCodeMessage;
import com.eliteams.mydoc.web.platform.model.PlatformDoc;
import com.eliteams.mydoc.web.platform.model.PlatformDocModuleClassify;
import com.eliteams.mydoc.web.platform.service.PlatformDocModuleClassifyService;
import com.eliteams.mydoc.web.platform.service.PlatformDocService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author [董振]
 * @version [2017/10/18]
 * @since [v1.0]
 */
@RestController
@RequestMapping("/platform")
public class PlatformController {

    @Resource
    private PlatformDocService platformDocService;

    @Resource
    private PlatformDocModuleClassifyService platformDocModuleClassifyService;

    /**
     * 添加项目平台
     *
     * @return
     */
    @RequestMapping(value = "/addPlatform", method = RequestMethod.POST)
    public Result addPlatform(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("companyName")) || Objects.isNull(map.get("platformName"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        String companyName = map.get("companyName").toString();
        String platformName = map.get("platformName").toString();
        PlatformDoc platformDoc = new PlatformDoc(companyName, platformName, new Date());
        boolean add = platformDocService.addPlatformDoc(platformDoc);
        if (add == true) {
            result.executeSuccess(ResultCodeMessage.ADD_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }

    /**
     * 查询所有的平台
     *
     * @return
     */
    @RequestMapping(value = "/queryPlatform", method = RequestMethod.POST)
    public Result queryPlatform(@RequestBody(required = false) RequestParams requestParams) {
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
        Pagination<PlatformDoc> platformDocs = platformDocService.queryPlatformDoc(pageSize, pageNo);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("platformDocs", platformDocs);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 根据平台id查询旗下的模块
     *
     * @return
     */
    @RequestMapping(value = "/queryModuleClassifyByPlatformId", method = RequestMethod.POST)
    public Result queryModuleClassifyByPlatformId(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("platformId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        Long platformId = Long.parseLong(map.get("platformId").toString());
        List<PlatformDocModuleClassify> platformDocModuleClassifies = platformDocModuleClassifyService.queryModuleClassify(platformId);
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("platformDocModuleClassifies", platformDocModuleClassifies);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 添加平台下的模块
     *
     * @return
     */
    @RequestMapping(value = "/addModule", method = RequestMethod.POST)
    public Result addModule(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("platformId")) || Objects.isNull(map.get("moduleName"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        Long platformId = Long.parseLong(map.get("platformId").toString());
        String moduleName = map.get("moduleName").toString();
        boolean bool = platformDocModuleClassifyService.addModule(platformId, moduleName);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.ADD_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }

    /**
     * 删除平台下的模块
     *
     * @return
     */
    @RequestMapping(value = "/delModule", method = RequestMethod.POST)
    public Result delModule(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("moduleId"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        Long moduleId = Long.parseLong(map.get("moduleId").toString());
        boolean bool = platformDocModuleClassifyService.delModule(moduleId);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.DELETE_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }
}
