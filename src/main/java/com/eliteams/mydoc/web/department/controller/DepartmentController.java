package com.eliteams.mydoc.web.department.controller;

import com.eliteams.mydoc.common.entity.RequestParams;
import com.eliteams.mydoc.common.entity.Result;
import com.eliteams.mydoc.common.entity.ResultCodeMessage;
import com.eliteams.mydoc.web.department.model.Department;
import com.eliteams.mydoc.web.department.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author [uzdz]
 * @version [2017/10/18]
 * @since [v1.0]
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    /**
     * 查询所有的部门
     * @param requestParams
     * @return
     */
    @RequestMapping(value = "/selectDepartment", method = RequestMethod.POST)
    public Result selectDepartment(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        List<Department> departments = departmentService.selectDepartment();
        Map<String, Object> paramsList = new HashMap<>();
        paramsList.put("departments", departments);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * 添加部门
     * @param requestParams
     * @return
     */
    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    public Result addDepartment(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("departmentName"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        String departmentName = map.get("departmentName").toString();
        boolean bool = departmentService.addDepartment(departmentName);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.ADD_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;
    }
}
