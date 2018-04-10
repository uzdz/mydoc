package com.eliteams.mydoc.web.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 视图控制器,返回jsp视图给前端
 * 
 * @author StarZou
 * @since 2014年5月28日 下午4:00:49
 **/
@Controller
@RequestMapping("/page")
public class PageController {

    /**
     * 登录页
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * home页
     */
    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    /**
     * platformHome
     */
    @RequestMapping("/platformHome")
    public String platformHome() {
        return "platformHome";
    }

    /**
     * platform
     */
    @RequestMapping("/platform")
    public String platform() {
        return "platform";
    }

    /**
     * manager java
     */
    @RequestMapping("/manager")
    public String manager() {
        return "manager";
    }

    /**
     * platformInterface
     */
    @RequestMapping("/platformInterface")
    public String platformInterface(HttpServletRequest httpServletRequest) {
        String platformId = httpServletRequest.getParameter("platformId");
        httpServletRequest.getSession().setAttribute("platformId", platformId);
        return "platformInterface";
    }

    /**
     * doc
     */
    @RequestMapping("/doc")
    public String doc() {
        return "doc";
    }

    /**
     * global
     */
    @RequestMapping("/global")
    public String global() {
        return "global";
    }

    /**
     * dictionary
     */
    @RequestMapping("/dictionary")
    public String dictionary() {
        return "dictionary";
    }

    /**
     * personalInfor
     */
    @RequestMapping("/personalInfor")
    public String personalInfor() {
        return "personalInfor";
    }

    /**
     * modifyPassword
     */
    @RequestMapping("/modifyPassword")
    public String modifyPassword() {
        return "modifyPassword";
    }

    /**
     * 404页
     */
    @RequestMapping("/404")
    public String error404() {
        return "404";
    }

    /**
     * 401页
     */
    @RequestMapping("/401")
    public String error401() {
        return "401";
    }

    /**
     * 500页
     */
    @RequestMapping("/500")
    public String error500() {
        return "500";
    }

}