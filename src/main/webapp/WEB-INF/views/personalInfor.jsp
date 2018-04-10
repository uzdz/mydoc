<%@ page language="java" pageEncoding="utf-8"%>
<!-- BEGIN PAGE HEADER-->
<div class="row">
    <div class="col-md-12">
        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
        <h3 class="page-title" id="index-page-title">个人信息</h3>
        <ul class="page-breadcrumb breadcrumb">
            <li>
                <i class="fa fa-home"></i>
                <a onclick="main()" href="javascript:;">
                    首页
                </a>
                <i class="fa fa-angle-right"></i>
            </li>
            <li>
                <a href="javascript:;">
                    个人信息
                </a>
            </li>
        </ul>
        <!-- END PAGE TITLE & BREADCRUMB-->
    </div>
</div>

<div class="form-horizontal" style="margin-top: 10px">
    <div class="form-group">
        <label class="col-sm-1 control-label">用户昵称：</label>
        <div class="col-sm-3">
            <p class="form-control-static" id="username" style="border-bottom: 1px solid #ccc; padding: 7px;">${userInfo.username}</p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-1 control-label">部门名称：</label>
        <div class="col-sm-3">
            <p class="form-control-static" id="department" style="border-bottom: 1px solid #ccc; padding: 7px;">${userInfo.username}</p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-1 control-label">创建时间：</label>
        <div class="col-sm-3">
            <p class="form-control-static" id="createtime" style="border-bottom: 1px solid #ccc; padding: 7px;">${userInfo.password}</p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-1 control-label">用户状态：</label>
        <div class="col-sm-3">
            <p class="form-control-static form-control-line" id="status">${userInfo.username}</p>
        </div>
    </div>
</div>
<!-- END PAGE HEADER-->

<script>
    var param = {map:{}};
    param.map.userName = '${userInfo.username}'
    $.ajax({
        type : "post",
        url : MyDoc.ip+"rest/user/personalInformation",
        data : JSON.stringify(param),
        contentType: 'application/json;charset=UTF-8',
        dataType: "json",
        type: "post",
        async: false,
        success : function(data) {
            $("#username").html(data.data.user.username);
            $("#department").html(data.data.user.departmentName);
            $("#createtime").html(data.data.user.createTime);
            $("#status").html(data.data.user.state);
        }
    });
</script>