<%@ page language="java" pageEncoding="utf-8"%>
<!-- BEGIN PAGE HEADER-->
<div class="row">
    <div class="col-md-12">
        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
        <h3 class="page-title" id="index-page-title">平台接口</h3>
        <ul class="page-breadcrumb breadcrumb">
            <li>
                <i class="fa fa-home"></i>
                <a onclick="platformHome()" href="javascript:;">
                    平台
                </a>
                <i class="fa fa-angle-right"></i>
            </li>
            <li>
                <a href="javascript:;">
                    平台接口
                </a>
            </li>
        </ul>
        <!-- END PAGE TITLE & BREADCRUMB-->
    </div>
</div>
<!-- END PAGE HEADER-->
<div class="panel panel-default">
    <div class="panel-body">
        <div class="form-inline">
            <div class="form-group">
                <label class=" control-label">接口名称：</label>
                <input type="text" class="form-control" id="interfaceName" name="interfaceName"/>
            </div>
            <div class="form-group">
                <label class=" control-label">方法名称：</label>
                <input type="text" class="form-control" id="methodName" name="methodName"/>
            </div>
            <div class="form-group">
                <label class=" control-label">模块名称：</label>
                <select class="form-control" id="moduleId" name="moduleId">
                    <option value="0">请选择...</option>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label">接口状态：</label>
                <select class="form-control" id="status" name="status">
                    <option value="0">请选择...</option>
                    <option value="1">未启用</option>
                    <option value="2">已启用</option>
                    <option value="3">维护中</option>
                </select>
            </div>
            <div class="form-group">
                <button  type="button" class="btn btn-success search" id="search"><i class="fa fa-search"></i> 查询</button>
            </div>
        </div>
    </div>
</div>

<div id = "box">
    <table id="example" class="table table-hover table-bordered dataTable dataTable-nosort" cellspacing="0">
        <thead>
        <tr>
            <th width="7%">名称</th>
            <th width="7%">方法名</th>
            <th width="7%">平台</th>
            <th width="5%">创建者</th>
            <th width="5%">接口状态</th>
            <th width="7%">创建时间</th>
            <th>设置</th>
        </tr>
        </thead>
    </table>
</div>

<!--模态框-查看接口-->
<section class="modal port-look" id="modal-look" tabindex="-1" role="dialog">
    <form method="get" action="#">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <!-- 标题 -->
                <div class="modal-header">
                    <h3>编辑接口</h3>
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                </div>
                <!-- 中间结构 -->
                <div class="modal-body">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>用户名ID</label>
                            <div class="col-sm-8">
                                <p id="interfaceCreateUserIdLook" style="border-bottom: 1px solid #ccc; padding: 7px; color: red;"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>用户名</label>
                            <div class="col-sm-8">
                                <p id="interfaceCreateUserNameLook" style="border-bottom: 1px solid #ccc; padding: 7px; color: red;"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>接口名称</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="interfaceNameLook" style="border-bottom: 1px solid #ccc; padding: 7px;"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>方法名称</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="methodNameLook" style="border-bottom: 1px solid #ccc; padding: 7px;"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>方法用途</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="methodPurposeLook" style="border-bottom: 1px solid #ccc; padding: 7px;"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>方法请求路径</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="methodRouteLook" style="border-bottom: 1px solid #ccc; padding: 7px;"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>接口请求方式</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="interfaceRequestModeLook" style="border-bottom: 1px solid #ccc; padding: 7px;"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>接口响应方式</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="interfaceResponseModeLook" style="border-bottom: 1px solid #ccc; padding: 7px;"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>项目名称：</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="platformDocIdLook" style="border-bottom: 1px solid #ccc; padding: 7px;"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>模块名称：</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="platformDocModuleClassifyIdLook" style="border-bottom: 1px solid #ccc; padding: 7px;"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>接口状态：</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="interfaceStatusLook" style="border-bottom: 1px solid #ccc; padding: 7px;"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>部门</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="departmentIdLook" style="border-bottom: 1px solid #ccc; padding: 7px;"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>全局集合</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="globalClassifyIdLook" style="border-bottom: 1px solid #ccc; padding: 7px;"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>方法请求演示</label>
                            <div class="col-sm-8">
                                <textarea class="form-control" readonly="readonly"  id="methodRequestDemoLook" name="methodRequestDemoLook" cols="30" rows="10"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>方法结果演示</label>
                            <div class="col-sm-8">
                                <textarea class="form-control" readonly="readonly" id="methodResultDemoLook" name="methodResultDemoLook" cols="30" rows="10"></textarea>
                            </div>
                        </div>
                        <div class="modal-header" style="border-top:1px solid #333333;">
                            <h3>请求参数</h3>
                        </div>
                        <div class="modal-body">
                            <div class="requiredBoxLook">
                                <table class="table table-hover table-bordered" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th width="25%">名称</th>
                                        <th width="25%">类型</th>
                                        <th width="25%">必须</th>
                                        <th width="25%">备注</th>
                                    </tr>
                                    </thead>
                                    <tbody></tbody>
                                </table>
                            </div>
                        </div>
                        <div class="modal-header" style="border-top:1px solid #333333;">
                            <h3>响应参数</h3>
                        </div>
                        <div class="modal-body">
                            <div class="responseBoxLook" id ="resultBox">
                                <table class="table table-hover table-bordered" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th width="25%">名称</th>
                                        <th width="25%">类型</th>
                                        <th width="25%">必须</th>
                                        <th width="25%">备注</th>
                                    </tr>
                                    </thead>
                                    <tbody></tbody>
                                </table>
                            </div>
                        </div>
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-custom4" data-dismiss="modal">取消</button>
                </div>
            </div><!-- .modal-content end-->
        </div><!-- .modal-dialog end-->
    </form>
</section>

<!--模态框-提示-->
<section class="modal" id="modal-prompting" tabindex="-1" role="dialog">
    <form method="get" action="#">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <!-- 标题 -->
                <div class="modal-header">
                    <h3>提示</h3>
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                </div>
                <!-- 中间结构 -->
                <div class="modal-body">
                    请选择项目
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-custom4" data-dismiss="modal">Cancel</button>
                </div>
            </div><!-- .modal-content end-->
        </div><!-- .modal-dialog end-->
    </form>
</section>



<script>
    var param = {map:{}};

    $(function () {
        var param = {map:{}};
        var platformId = ${platformId};
        var obj=document.getElementById('moduleId');
        obj.options.length=1;
        if (platformId != 9999) {
            param.map.platformId = platformId;
            $.ajax({
                type : "post",
                url : MyDoc.ip+"rest/platform/queryModuleClassifyByPlatformId",
                data : JSON.stringify(param),
                contentType: 'application/json;charset=UTF-8',
                dataType: "json",
                type: "post",
                async: false,
                success : function(data) {
                    for (var i = 0;i < data.data.platformDocModuleClassifies.length; i++) {
                        $("#moduleId").append("<option value='"+data.data.platformDocModuleClassifies[i].platformDocModuleClassifyId+"'>"+data.data.platformDocModuleClassifies[i].moduleName+"</option>");
                    }
                }
            });
        }
    })

    var table = $("#example").dataTable({
        "sDom": 'rt<"bottom"ilp<"clear">>',
        language: datatables_lang,  //提示信息
        processing: true,//是否显示加载中提示
        autoWidth: false,//是否自动计算表格各列宽度
        info: true,//是否显示页数信息
        pagingType:"full_numbers",//分页样式的类型
        pageLength :10,//默认每页显示多少条记录
        searching: false,//是否显示搜索框
        bStateSave: true,// 不刷新当前页码
        ordering:false,//是否允许排序
        serverSide: true,//是否从服务器获取数据
        stateSave: true,//页面重载后保持当前页
        lengthChange: true,//是否显示每页大小的下拉框
        lengthMenu: [ 10, 15,25, 50, 75, 100 ],//长度菜单
        responsive: true,
        scrollX: true,//横向滑动
        ajax: function (data, callback, settings){
            //封装请求参数
            //注释动态的数据总数
            param.map.userId = ${userInfo.userId};
            param.map.platformId = ${platformId}
            param.map.pageSize = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
            param.map.pageNo = (data.start / data.length)+1;//当前页码
            console.log(param)
            //ajax请求数据
            $.ajax({
                url: MyDoc.ip+"rest/doc/platformDoc",
                data: JSON.stringify(param),
                contentType: 'application/json;charset=UTF-8',
                dataType: "json",
                type: "post",
                async: false,
                success: function (result) {
                    console.log(result);

                    //封装返回数据
                    var returnData = {};
                    returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                    returnData.recordsTotal = 0;//返回数据全部记录
                    returnData.recordsFiltered = 0;//后台不实现过滤功能，每次查询均视作全部结果
                    returnData.data = [];//返回的数据列表
                    listdata = returnData.data;

                    // 不存在数据或者异常
                    if (result.subCode != 10002) {
                        callback(returnData);
                        return false;
                    }

                    //封装返回数据
                    var returnData = {};
                    returnData.draw = result.draw;//这里直接自行返回了draw计数器,应该由后台返回
                    returnData.recordsTotal = result.data.interfaceInfoVO.total;// 返回数据全部记录 这里先定死 result.data.total
                    returnData.recordsFiltered = result.data.interfaceInfoVO.total;//查询返回数据全部记录，记录分页数  同上
                    returnData.data = result.data.interfaceInfoVO.list;
                    //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                    //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                    callback(returnData);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("查询失败");
                }
            });
        },
        //列表表头字段
        columns: [
            {"data": "interfaceName"},
            {"data": "methodName"},
            {"data": "platformDocName"},
            {"data": "interfaceCreateUserName"},
            {"data": "interfaceStatus",sortable: false, render: function (status) {
                var statusCN = "";
                if (status == 1) {
                    statusCN = "未启用";
                } else if (status == 2) {
                    statusCN = "已启用";
                } else if (status == 3) {
                    statusCN = "维护中";
                }
                return '<div>'+statusCN+'</div>';
            }},
            {"data": "interfaceCreateTime"},
            {
                "data": "interfaceInfoId",
                "orderable": false, // 禁用排序
                "defaultContent": "",
                "width": "10%",
                "render": function (data, type, row, meta) {
                    return data ='<button data-id="'+data+'" class="btn btn-primary btn-sm look" data-id=' + data + ' href="#modal-look" data-toggle="modal"><i class="fa fa-folder-open"></i> 查看</button>&nbsp;';

                }
            }
        ]
    });

    $("#example").on("click", "button.look", function() {
        var id = $(this).data("id");
        var param = {map:{}};
        param.map.interfaceInfoId = id;
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/doc/queryInterfaceById",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                console.log(data)
                $("#interfaceNameLook").html(data.data.interface.interfaceLookVO.interfaceName) ;
                $("#methodNameLook").html(data.data.interface.interfaceLookVO.methodName);
                $("#methodPurposeLook").html(data.data.interface.interfaceLookVO.methodPurpose);
                $("#methodRouteLook").html(data.data.interface.interfaceLookVO.methodRoute);
                $("#methodRequestDemoLook").val(data.data.interface.interfaceLookVO.methodRequestDemo);
                $("#methodResultDemoLook").val(data.data.interface.interfaceLookVO.methodResultDemo);
                $("#interfaceRequestModeLook").html(data.data.interface.interfaceLookVO.interfaceRequestMode);
                $("#interfaceResponseModeLook").html(data.data.interface.interfaceLookVO.interfaceResponseMode);
                $("#interfaceCreateUserIdLook").html(data.data.interface.interfaceLookVO.interfaceCreateUserId);
                $("#interfaceCreateUserNameLook").html(data.data.interface.interfaceLookVO.interfaceCreateUserName);
                $("#platformDocIdLook").html(data.data.interface.interfaceLookVO.platformDocName);
                $("#platformDocModuleClassifyIdLook").html(data.data.interface.interfaceLookVO.platformDocModuleClassifyName);
                $("#interfaceStatusLook").html(data.data.interface.interfaceLookVO.interfaceStatusName);
                $("#departmentIdLook").html(data.data.interface.interfaceLookVO.departmentName);
                $("#globalClassifyIdLook").html(data.data.interface.interfaceLookVO.globalClassifyName);
                var htmlRequest =" ";
                for (var i = 0; i<data.data.interface.interfaceRequestFields.length; i++) {
                    var statusName = "";
                    if (data.data.interface.interfaceRequestFields[i].fieldMust == 0) {
                        statusName = "否"
                    } else {
                        statusName = "是"
                    }
                    htmlRequest +='<tr>'+
                        '<td><p class="form-control-static" id="department">'+data.data.interface.interfaceRequestFields[i].fieldName+'</p></td>'+
                        '<td><p class="form-control-static" id="department">'+data.data.interface.interfaceRequestFields[i].fieldType+'</p></td>'+
                        '<td><p class="form-control-static" id="department">'+statusName+'</p></td>'+
                        '<td><p class="form-control-static" id="department">'+data.data.interface.interfaceRequestFields[i].fieldRemark+'</p></tr>'
                    //新表单项添加到“新增”按钮前面

                }
                $('.requiredBoxLook table tbody').html(htmlRequest);
                var htmlResult = "";
                for (var i = 0; i<data.data.interface.interfaceResponseFields.length; i++) {
                    var statusName = "";
                    if (data.data.interface.interfaceResponseFields[i].fieldMust == 0) {
                        statusName = "否"
                    } else {
                        statusName = "是"
                    }
                    htmlResult +='<tr>'+
                        '<td><p class="form-control-static" id="department">'+data.data.interface.interfaceResponseFields[i].fieldName+'</p></td>'+
                        '<td><p class="form-control-static" id="department">'+data.data.interface.interfaceResponseFields[i].fieldType+'</p></td>'+
                        '<td><p class="form-control-static" id="department">'+statusName+'</p></td>'+
                        '<td><p class="form-control-static" id="department">'+data.data.interface.interfaceResponseFields[i].fieldRemark+'</p></tr>'
                    //新表单项添加到“新增”按钮前面
                }
                $('.responseBoxLook table tbody').html(htmlResult);
            }
        });
    })

    $("#search").click(function() {
        var interfaceName = $("#interfaceName").val();
        var methodName = $("#methodName").val();
        var moduleId = $("#moduleId").val();
        var platformId = ${platformId};
        var status = $("#status").val();
        param.map.interfaceName = interfaceName;
        param.map.methodName = methodName;
        param.map.moduleId = moduleId;
        param.map.platformId = platformId;
        param.map.status = status;
        table._fnReDraw();
    })

</script>