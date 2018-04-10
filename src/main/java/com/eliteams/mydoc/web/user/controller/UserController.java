package com.eliteams.mydoc.web.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.eliteams.mydoc.common.entity.RequestParams;
import com.eliteams.mydoc.common.entity.Result;
import com.eliteams.mydoc.common.entity.ResultCodeMessage;
import com.eliteams.mydoc.web.department.model.Department;
import com.eliteams.mydoc.web.department.model.UserDepartment;
import com.eliteams.mydoc.web.department.service.DepartmentService;
import com.eliteams.mydoc.web.department.service.UserDepartmentService;
import com.eliteams.mydoc.web.user.Enum.UserStatusEnum;
import com.eliteams.mydoc.web.user.model.User;
import com.eliteams.mydoc.web.user.security.PermissionSign;
import com.eliteams.mydoc.web.user.security.RoleSign;
import com.eliteams.mydoc.web.user.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.eliteams.mydoc.web.user.service.UserService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 用户控制器
 * 
 * @author uzdz
 * @since 2014年5月28日 下午3:54:00
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private UserDepartmentService userDepartmentService;

    /**
     * 用户登录
     * 
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid User user, BindingResult result, Model model, HttpServletRequest request) {
        try {
            Subject subject = SecurityUtils.getSubject();
            // 已登陆则 跳到首页
            if (subject.isAuthenticated()) {
                return "redirect:/";
            }
            if (result.hasErrors()) {
                model.addAttribute("error", "参数错误！");
                return "login";
            }
            // 身份验证
            subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
            // 验证成功在Session中保存用户信息
            final User authUserInfo = userService.selectByUsername(user.getUsername());
            request.getSession().setAttribute("userInfo", authUserInfo);
        } catch (AuthenticationException e) {
            // 身份验证失败
            model.addAttribute("error", "用户名或密码错误 ！");
            return "login";
        }
        return "redirect:/";
    }

    /**
     * 用户注册
     *
     * @param username
     * @param departmentId
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(String username, long departmentId, String rpassword, String r2password, HttpServletRequest request) {
        if (StringUtils.isBlank(rpassword) || StringUtils.isBlank(r2password)) {
            request.setAttribute("error", "密码不能为空");
            return "login";
        }
        if (!rpassword.equals(r2password)) {
            request.setAttribute("error", "二次密码不一致");
            return "login";
        }
        if (StringUtils.isBlank(username)) {
            request.setAttribute("error", "用户名不能为空");
            return "login";
        }
        User checkUser = userService.selectByUsername(username);
        if (checkUser != null) {
            request.setAttribute("error", "用户名已经注册");
            return "login";
        }
        Department department = departmentService.queryDepartmentById(departmentId);
        if (department == null) {
            request.setAttribute("error", "部门选择异常");
            return "login";
        }
        User user = new User(username, rpassword, UserStatusEnum.NORMAL.getStatus(), new Date());
        boolean bool = userService.register(user, departmentId);
        if (bool == true) {
            // 验证成功在Session中保存用户信息
            final User authUserInfo = userService.selectByUsername(user.getUsername());
            request.getSession().setAttribute("userInfo", authUserInfo);
            return "redirect:/";
        }
        return "login";
    }

    /**
     * 用户修改密码
     *
     * @param requestParams
     * @return
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public Result updatePassword(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("userName")) || Objects.isNull(map.get("newPassword"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        String userName = map.get("userName").toString();
        String newPassword = map.get("newPassword").toString();
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(newPassword)) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        boolean bool = userService.updatePassword(userName, newPassword);
        if (bool == true) {
            result.executeSuccess(ResultCodeMessage.UPDATED_SUCCESS_MESSAGE);
        } else {
            result.executeSuccess(ResultCodeMessage.EXECUTE_FAIL_MESSAGE);
        }
        return result;

    }

    /**
     * 个人信息
     *
     * @return
     */
    @RequestMapping(value = "/personalInformation", method = RequestMethod.POST)
    @ResponseBody
    public Result personalInformation(@RequestBody(required = false) RequestParams requestParams) {
        // 获取当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Result result = new Result(method);
        Map<String, Object> map = requestParams.getMap();
        if (Objects.isNull(map.get("userName"))) {
            result.paramsError(ResultCodeMessage.PARAMS_FAIL_MESSAGE);
            return result;
        }
        String userName = map.get("userName").toString();
        User user = userService.personalInformation(userName);
        if (user == null) {
            result.paramsError(ResultCodeMessage.USER_NO_EXIST_MESSAGE);
            return result;
        }
        Map<String, Object> paramsList = new HashMap<>();
        UserVO userVO = new UserVO(user);
        UserDepartment userDepartment = userDepartmentService.selectUserDepartment(user.getUserId());
        Department department = departmentService.queryDepartmentById(userDepartment.getDepartmentId());
        userVO.setDepartmentName(department.getDepartmentName());
        userVO.setState(UserStatusEnum.get(user.getStatus()).getStatusMsg());
        paramsList.put("user", userVO);
        result.setData(paramsList);
        result.executeSuccess(ResultCodeMessage.SUB_SUCCESS_MESSAGE);
        return result;
    }


    /**
     * 用户登出
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("userInfo");
        // 登出操作
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    /**
     * 基于角色 标识的权限控制案例
     */
    @RequestMapping(value = "/admin")
    @ResponseBody
    @RequiresRoles(value = RoleSign.ADMIN)
    public String admin() {
        return "拥有admin角色,能访问";
    }

    /**
     * 基于权限标识的权限控制案例
     */
    @RequestMapping(value = "/create")
    @ResponseBody
    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    public String create() {
        return "拥有user:create权限,能访问";
    }
}
