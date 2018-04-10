<%@ page language="java" pageEncoding="utf-8"%>
<div class="page-sidebar navbar-collapse collapse">
    <!-- BEGIN SIDEBAR MENU -->
    <ul class="page-sidebar-menu" id="page-sidebar-menu">
        <li class="sidebar-toggler-wrapper">
            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
            <div class="sidebar-toggler hidden-phone"></div>
            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
        </li>

        <li class="start active">
            <a href="rest/page/home" id="btn-dashboard">
                <i class="fa fa-home"></i><span class="title"> 首页 </span><span
                    class="selected"> </span>
            </a>
        </li>

        <li class="start active">
            <a href="rest/page/platformHome" id="btn-platform">
                <i class="fa fa-cloud"></i><span class="title"> 平台项目 </span><span
                    class="selected"> </span>
            </a>
        </li>

        <li class="">
            <a href="javascript:;">
                <i class="fa fa-gears"></i><span class="title"> 接口管理 </span><span
                    class="arrow "> </span>
            </a>
            <ul class="sub-menu">
                <li>
                    <a href="rest/page/platform">
                        项目平台
                    </a>
                </li>
                <li>
                    <a href="rest/page/global">
                        全局参数
                    </a>
                </li>
                <li>
                    <a href="rest/page/dictionary">
                        字典表
                    </a>
                </li>
                <li>
                    <a href="rest/page/manager">
                        接口管理
                    </a>
                </li>
                <li>
                    <a href="rest/page/doc">
                        我的接口
                    </a>
                </li>
            </ul>
        </li>

        <li class="">
            <a href="javascript:;">
                <i class="fa fa-user"></i><span class="title"> 个人中心 </span><span
                    class="arrow "> </span>
            </a>
            <ul class="sub-menu">
                <li>
                    <a href="rest/page/personalInfor">
                        个人信息
                    </a>
                </li>
                <li>
                    <a href="rest/page/modifyPassword">
                        密码修改
                    </a>
                </li>

                <!-- 测试权限控制 -->
                <shiro:hasAnyRoles name="super_admin">
                    <li>
                        <a href="javascript:;">super_admin 拥有此角色</a>
                    </li>
                </shiro:hasAnyRoles>

                <shiro:hasPermission name="user:create">
                    <li>
                        <a href="javascript:;">user:create 拥有此权限</a>
                    </li>
                </shiro:hasPermission>

                <shiro:hasPermission name="user:update">
                    <li>
                        <a href="javascript:;">user:update 拥有此权限</a>
                    </li>
                </shiro:hasPermission>

            </ul>
        </li>

    </ul>
    <!-- END SIDEBAR MENU -->
</div>