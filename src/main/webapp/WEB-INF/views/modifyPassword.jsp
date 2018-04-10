<%@ page language="java" pageEncoding="utf-8"%>
<!-- BEGIN PAGE HEADER-->
<div class="row">
    <div class="col-md-12">
        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
        <h3 class="page-title" id="index-page-title">修改密码</h3>
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
                    修改密码
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
            <input type="text" class="form-control" readonly="true" value="${userInfo.username}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword" class="col-sm-1 control-label">新的密码：</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="inputPassword" placeholder="请输入新密码">
        </div>
    </div>
    <div class="col-sm-1 col-sm-offset-1" style="padding-left: 5px" >
    <button type="button" class="btn btn-primary" id="button">Submit</button>
    </div>
</div>
<!-- END PAGE HEADER-->

<script>
    Messenger.options = {
        extraClasses: 'messenger-fixed messenger-on-top',
        theme: 'block'
    }
    $("#button").click(function(){
        var param = {map:{}};
        param.map.userName = '${userInfo.username}'
        param.map.newPassword = $("#inputPassword").val();
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/user/updatePassword",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                if (data.subCode == 10002) {
                    Messenger().post({
                        message: "密码更新成功！",
                        type: 'info',
                        showCloseButton: true
                    });
                } else if (data.subCode == 10009) {
                    Messenger().post({
                        message: "密码处理失败！",
                        type: 'error',
                        showCloseButton: true
                    });
                } else if (data.subCode == 10001) {
                    Messenger().post({
                        message: "密码不能为空！",
                        type: 'error',
                        showCloseButton: true
                    });
                }
            }
        });
    })
</script>