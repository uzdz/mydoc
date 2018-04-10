<%@ page language="java" pageEncoding="utf-8"%>
<style>
    .modal table{
        margin-bottom:0;
    }
    .modal table input {
        margin: 5px;
        width: 85%;
    }
    .modal table td{
        padding: 8px;
        border: 1px solid #dddddd;
        word-break: break-all;
    }
</style>
<!-- BEGIN PAGE HEADER-->
<div class="row">
    <div class="col-md-12">
        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
        <h3 class="page-title" id="index-page-title">全局参数</h3>
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
                    全局参数
                </a>
            </li>
        </ul>
        <!-- END PAGE TITLE & BREADCRUMB-->
    </div>
</div>
<!-- END PAGE HEADER-->

<div class="form-group">
    <button  type="button" class="btn btn-primary" id="addPlatform" href="#modal-add" data-toggle="modal"><i class="fa fa-plus-square"></i>  添加全局参数</button>
</div>

<div id = "box">
    <table id="example" class="table table-hover table-bordered dataTable dataTable-nosort" cellspacing="0">
        <thead>
        <tr>
            <th width="7%">全局名称</th>
            <th width="7%">启用状态</th>
            <th width="7%">创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
    </table>
</div>

<!--模态框-添加项目平台-->
<section class="modal" id="modal-add" tabindex="-1" role="dialog">
    <form method="get" action="#">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- 标题 -->
                <div class="modal-header">
                    <h3>添加全局参数</h3>
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                </div>
                <!-- 中间结构 -->
                <div class="modal-body">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>全局名称：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="globalClassifyName">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>启用状态：</label>
                            <div class="col-sm-8">
                                <label class="radio-inline">
                                    <input type="radio" name="globalClassifyStatus" value="1" checked > 是
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="globalClassifyStatus" value="0"> 否
                                </label>
                            </div>
                        </div>
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <a href="javascript:void(0)" type="button" class="btn btn-primary" onclick="addGlobalFieldShell()">添加</a>
                    <button type="button" class="btn btn-custom4" data-dismiss="modal">取消</button>
                </div>
            </div><!-- .modal-content end-->
        </div><!-- .modal-dialog end-->
    </form>
</section>

<!--模态框-请求参数-->
<section class="modal" id="modal-look" tabindex="-1" role="dialog">
    <form method="get" action="#" id="mainForm">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <!-- 标题 -->
                <div class="modal-header">
                    <h3>请求参数</h3>
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                </div>

                <!-- 中间结构 -->
                <div class="modal-body" style="max-height: 300px; overflow-y: auto;">
                    <div style="float:right"><button type="button" class="btn btn-primary" id="addVar" data-id ="">添加</button></div>
                    <div class="modularBox">
                        <table class="table table-hover table-bordered">
                            <thead>
                                <th width="20%">字段名称</th>
                                <th width="20%">类型</th>
                                <th width="15%">是否必须</th>
                                <th width="20%">备注</th>
                                <th width="25%">操作</th>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                    <div id="platformId" style="display:none"></div>
                    <div id="platformId2" style="display:none"></div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-custom4" data-dismiss="modal">取消</button>
                </div>

            </div><!-- .modal-content end-->
        </div><!-- .modal-dialog end-->
    </form>
</section>

<script>
    var table = $("#example").dataTable({
        destroy: true,
        "sDom": 'rt<"bottom"ilp<"clear">>',
        language: datatables_lang,  //提示信息
        processing: true,//是否显示加载中提示
        autoWidth: false,//是否自动计算表格各列宽度
        info: true,//是否显示页数信息
        pagingType:"full_numbers",//分页样式的类型
        pageLength :10,//默认每页显示多少条记录
        searching: false,//是否显示搜索框
        ordering:false,//是否允许排序
        serverSide: true,//是否从服务器获取数据
        stateSave: true,//页面重载后保持当前页
        lengthChange: true,//是否显示每页大小的下拉框
        lengthMenu: [ 10, 15,25, 50, 75, 100 ],//长度菜单
        responsive: true,
        scrollX: true,//横向滑动
        ajax: function (data, callback, settings){
            var param = {map:{}};
            //封装请求参数
            //注释动态的数据总数
            param.map.pageSize = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
            param.map.pageNo = (data.start / data.length)+1;//当前页码
            //ajax请求数据
            $.ajax({
                url: MyDoc.ip+"rest/doc/queryGlobalFieldGroup",
                data: JSON.stringify(param),
                contentType: 'application/json;charset=UTF-8',
                dataType: "json",
                type: "post",
                async: false,
                success: function (result) {
                    console.log(result)
                    //封装返回数据
                    var returnData = {};
                    returnData.draw = result.draw;//这里直接自行返回了draw计数器,应该由后台返回
                    returnData.recordsTotal = result.data.globalClassifies.total;// 返回数据全部记录 这里先定死 result.data.total
                    returnData.recordsFiltered = result.data.globalClassifies.total;//查询返回数据全部记录，记录分页数  同上
                    returnData.data = result.data.globalClassifies.list;
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
            {"data": "globalClassifyName"},
            {"data": "globalClassifyStatus",
                render: function (data, type, row) {
                    if(data == 0){
                        return "否"
                    }else{
                        return "是"
                    }
                }
            },
            {"data": "globalClassifyCreateTime"},
            {
                "data": "globalClassifyId",
                "orderable": false, // 禁用排序
                "defaultContent": "",
                "width": "10%",
                "render": function (data, type, row, meta) {
                    return data = '<button data-id="'+data+'" class="btn btn-default btn-sm request" data-id=' + data + ' ><i class="fa fa-search"></i> 请求参数</button>&nbsp;'+
                                  '<button data-id="'+data+'" class="btn btn-default btn-sm response" data-id=' + data + ' ><i class="fa fa-search"></i> 响应参数</button>&nbsp;';
                }
            }
        ]
    });
    
    //添加项目平台
    function  addGlobalFieldShell() {
        var globalClassifyName =$('#modal-add').find('input[name=globalClassifyName]').val();
        var globalClassifyStatus =$('#modal-add').find('input[name=globalClassifyStatus]:checked').val();
        var param = {map:{}};
        param.map.globalClassifyName = globalClassifyName;
        param.map.globalClassifyStatus = globalClassifyStatus;
        console.log(JSON.stringify(param));
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/doc/addGlobalFieldShell",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                console.log(data);
                table._fnReDraw();
                $('#modal-add').modal('hide');

            }
        });
    };

    //追加表单
    $(function () {
        var varCount = 1;
        //新增按钮点击
        $('#addVar').on('click', function(){
            varCount++;
            $node ='<tr>'+
                 '<td><input type="text" name="globalFieldName" class="form-control" placeholder="字段名称" required data-bv-notempty-message="项目名称不能为空"></td>'+
                 '<td><select class="form-control" name="globalFieldType"><option value="String">String</option>' + '<option value="int">int</option>' + '<option value="long">long</option>' + '<option value="boolean">boolean</option>' + '<option value="map">map</option>' + '<option value="json">json</option>'+'<option value="list">list</option></select></td>'+
                 '<td><select class="form-control" name="globalFieldMust"><option value="1">是</option><option value="0">否</option></select></td>'+
                 '<td><input type="text" name="globalFieldRemark" class="form-control" placeholder="备注" required data-bv-notempty-message="备注不能为空"></td>'+
                 '<td><button class="btn btn-primary addVar" href="javascript:void(0)" onclick="addGlobalField(this)">保存</button>&nbsp;<button class="btn btn-danger removeVar" href="javascript:void(0)" >删除</button></td> </tr>'
            
            //新表单项添加到“新增”按钮前面
            $('#modal-look .modularBox table tbody').after($node);
        });
        //删除按钮点击
        $('#mainForm').on('click', '.removeVar', function(){
            $(this).parents('tr').remove();
            varCount--;
        });
    });

    //请求参数 / 响应
    $("#example").on("click", "button.request", function(){
        var platformId = $(this).data("id");
        $("#modal-look").find('#platformId').html(platformId);
        $("#modal-look").find('h3').html('请求参数'); 
        $("#modal-look").modal();
        queryGlobalFieldRequest();
    }).on("click", "button.response", function () {
        var platformId = $(this).data("id");
        $("#modal-look").find('#platformId').html(platformId);
        $("#modal-look").find('h3').html('响应参数');
        $("#modal-look").modal();
        queryGlobalFieldResult();
    })

    //请求参数-列表
    function queryGlobalFieldRequest(){
        $("#modal-look").find('#platformId2').html("1");
        var html =""
        var platformId = $("#modal-look").find('#platformId').html();
        var param = {map:{}};
        param.map.globalClassifyId = platformId;
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/doc/queryGlobalFieldRequest",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                console.log(data);
                var list = data.data.globalVariableFields;
                // console.log(list);
                for(var a=0;a<list.length;a++){
                    var _this = list[a];
                    if(_this.globalFieldMust == 0){
                        var globalFieldMust = "否"
                    }else{
                        var globalFieldMust = "是"
                    }
                    html+= '<tr>' +
                        '<td>'+_this.globalFieldName+'</td>' +
                        '<td>'+_this.globalFieldType+'</td>' +
                        '<td>'+globalFieldMust+'</td>' +
                        '<td>'+_this.globalFieldRemark+'</td>' +
                        '<td><button class="btn btn-danger" href="javascript:void(0)" onclick="delGlobalField(this)" data-globalVariableFieldId ="'+_this.globalVariableFieldId+'">删除</button></td>' +
                        '</tr>';
                }
                $("#modal-look tbody").html(html);
            }
        });
    }

    //响应参数-列表
    function queryGlobalFieldResult(){
        $("#modal-look").find('#platformId2').html("2");
        var html =""
        var platformId = $("#modal-look").find('#platformId').html();
        var param = {map:{}};
        param.map.globalClassifyId = platformId;
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/doc/queryGlobalFieldResult",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                console.log(data);
                var list = data.data.globalVariableFields;
                // console.log(list);
                for(var a=0;a<list.length;a++){
                    var _this = list[a];
                    if(_this.globalFieldMust == 0){
                        var globalFieldMust = "否"
                    }else{
                        var globalFieldMust = "是"
                    }
                    html+= '<tr>' +
                        '<td>'+_this.globalFieldName+'</td>' +
                        '<td>'+_this.globalFieldType+'</td>' +
                        '<td>'+globalFieldMust+'</td>' +
                        '<td>'+_this.globalFieldRemark+'</td>' +
                        '<td><button class="btn btn-danger" href="javascript:void(0)" onclick="delGlobalField(this)" data-globalVariableFieldId ="'+_this.globalVariableFieldId+'">删除</button></td>' +
                        '</tr>';
                }
                $("#modal-look tbody").html(html);
            }
        });
    }

    
    //添加模块
    function addGlobalField(obj){
        var globalRequestResultType = $("#modal-look").find('#platformId2').html();
        var globalClassifyId = $("#modal-look").find('#platformId').html();
        var globalFieldName = $(obj).parent().siblings().find('input[name=globalFieldName]').val();
        var globalFieldRemark = $(obj).parent().siblings().find('input[name=globalFieldRemark]').val();
        var globalFieldType = $(obj).parent().siblings().find('select[name=globalFieldType]').val();
        var globalFieldMust = $(obj).parent().siblings().find('select[name=globalFieldMust]').val();
        var param = {map:{globalVariableField:{}}};
        param.map.globalVariableField.globalClassifyId = globalClassifyId;
        param.map.globalVariableField.globalFieldName = globalFieldName;
        param.map.globalVariableField.globalFieldRemark = globalFieldRemark;
        param.map.globalVariableField.globalFieldType = globalFieldType;
        param.map.globalVariableField.globalFieldMust = globalFieldMust;
        param.map.globalVariableField.globalRequestResultType = globalRequestResultType;

        console.log(JSON.stringify(param));
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/doc/addGlobalField",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                console.log(data);
               if(globalRequestResultType==1){
                   queryGlobalFieldRequest();
               }else{
                   queryGlobalFieldResult();
               }
                $(obj).parents('tr').remove();
            }
        });
    };

    //删除模块
    function delGlobalField(obj){
        var globalRequestResultType = $("#modal-look").find('#platformId2').html();
        var globalVariableFieldId =  $(obj).data('globalvariablefieldid');
        var param = {map:{}};
        param.map.globalVariableFieldId = globalVariableFieldId;
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/doc/delGlobalField",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                console.log(data);
                if(globalRequestResultType==1){
                    queryGlobalFieldRequest();
                }else{
                    queryGlobalFieldResult();
                }
                $(obj).parents('tr').remove();
            }
        });
    };

</script>