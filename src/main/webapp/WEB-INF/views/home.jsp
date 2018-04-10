<%@ page language="java" pageEncoding="utf-8"%>

<!-- BEGIN PAGE HEADER-->
<div class="row">
    <div class="col-md-12">
        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
        <h3 class="page-title" id="index-page-title">首页</h3>
        <ul class="page-breadcrumb breadcrumb">
            <li>
                <i class="fa fa-home"></i>
                <a href="javascript:;">
                    首页
                </a>
                <i class="fa fa-angle-right"></i>
            </li>
        </ul>
        <!-- END PAGE TITLE & BREADCRUMB-->
    </div>
</div>
<!-- END PAGE HEADER-->

<div class="row">
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat blue">
            <div class="visual">
                <i class="fa fa-code"></i>
            </div>
            <div class="details">
                <div class="number" id="1">0</div>
                <div class="txt">接口管理</div>
            </div>
            <a class="more" onclick="manager()"> 点击查看更多 <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat yellow">
            <div class="visual">
                <i class="fa fa-user"></i>
            </div>
            <div class="details">
                <div class="number" id="2">0</div>
                <div class="txt">我的接口</div>
            </div>
            <a class="more" onclick="doc()"> 点击查看更多 <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat dark">
            <div class="visual">
                <i class="fa fa-globe"></i>
            </div>
            <div class="details">
                <div class="number" id="4">0</div>
                <div class="txt">全局参数</div>
            </div>
            <a class="more" onclick="global()"> 点击查看更多 <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat green">
            <div class="visual">
                <i class="fa fa-book"></i>
            </div>
            <div class="details">
                <div class="number" id="5">0</div>
                <div class="txt">字典表</div>
            </div>
            <a class="more" onclick="dictionary()"> 点击查看更多 <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat red .more">
            <div class="visual">
                <i class="fa fa-folder-open"></i>
            </div>
            <div class="details">
                <div class="number" id="3">0</div>
                <div class="txt">项目平台</div>
            </div>
            <a class="more" onclick="platform()"> 点击查看更多 <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
</div>
<script>
    var param = {map:{}};
    param.map.userId = ${userInfo.userId};
    $.ajax({
        type : "post",
        url :   MyDoc.ip+"rest/doc/homePage",
        data : JSON.stringify(param),
        contentType: 'application/json;charset=UTF-8',
        dataType: "json",
        type: "post",
        async: false,
        success : function(data) {
            console.log(data)
            for(var k in data.data){  //通过定义一个局部变量k遍历获取到了map中所有的key值
                document.getElementById(k).innerHTML = data.data[k]; //获取到了key所对应的value的值！
            }
        }
    });
</script>