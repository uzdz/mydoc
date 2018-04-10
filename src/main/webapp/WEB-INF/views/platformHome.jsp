<%@ page language="java" pageEncoding="utf-8"%>

<!-- BEGIN PAGE HEADER-->
<div class="row">
    <div class="col-md-12">
        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
        <h3 class="page-title" id="index-page-title">平台项目</h3>
        <ul class="page-breadcrumb breadcrumb">
            <li>
                <i class="fa fa-home"></i>
                <a onclick="main()" href="javascript:;">
                    平台项目
                </a>
                <i class="fa fa-angle-right"></i>
            </li>
        </ul>
        <!-- END PAGE TITLE & BREADCRUMB-->
    </div>
</div>
<!-- END PAGE HEADER-->

<div class="row" id="platform">

</div>
<script>
    var userId = ${userInfo.userId};
    var param = {map:{}};
    param.map.userId = userId;
    $.ajax({
        type : "post",
        url :   MyDoc.ip+"rest/doc/queryPlatform",
        data : JSON.stringify(param),
        contentType: 'application/json;charset=UTF-8',
        dataType: "json",
        type: "post",
        async: false,
        success : function(data) {
            console.log(data)
            var html = "";
            for (var i = 0; i<data.data.platform.length; i++) {
                html += '<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">' +
                    '        <div class="dashboard-stat blue">' +
                    '            <div class="visual">' +
                    '                  <i class="fa fa-folder-open"></i>' +
                    '            </div>' +
                    '            <div class="details">' +
                    '                <div class="number" id="1">'+data.data.platform[i].count+'</div>' +
                    '                <div class="txt">'+data.data.platform[i].platformName+'</div>' +
                    '            </div>' +
                    '            <a class="more" onclick="platformSkip('+data.data.platform[i].platformDocId+')"> 点击查看更多 <i class="m-icon-swapright m-icon-white"></i>' +
                    '            </a>' +
                    '        </div>' +
                    '    </div>'
            }
            $("#platform").html(html);
        }
    });
</script>