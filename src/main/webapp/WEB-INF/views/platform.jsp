<%@ page language="java" pageEncoding="utf-8"%>
<!-- BEGIN PAGE HEADER-->
<div class="row">
    <div class="col-md-12">
        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
        <h3 class="page-title" id="index-page-title">项目平台</h3>
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
                    项目平台
                </a>
            </li>
        </ul>
        <!-- END PAGE TITLE & BREADCRUMB-->
    </div>
</div>
<!-- END PAGE HEADER-->

<div class="form-group">
    <button  type="button" class="btn btn-primary" id="addPlatform" href="#modal-add" data-toggle="modal"><i class="fa fa-plus-square"></i>  添加项目平台</button>
</div>

<div id = "box">
    <table id="example" class="table table-hover table-bordered dataTable dataTable-nosort" cellspacing="0">
        <thead>
        <tr>
            <th width="7%">公司名称</th>
            <th width="7%">平台名称</th>
            <th width="7%">创建时间</th>
            <th>设置</th>
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
                    <h3>添加项目平台</h3>
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                </div>
                <!-- 中间结构 -->
                <div class="modal-body">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>公司名称：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="companyName">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>平台名称：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="platformName">
                            </div>
                        </div>
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <a href="javascript:void(0)" type="button" class="btn btn-primary" onclick="addPlatform()">添加</a>
                    <button type="button" class="btn btn-custom4" data-dismiss="modal">取消</button>
                </div>
            </div><!-- .modal-content end-->
        </div><!-- .modal-dialog end-->
    </form>
</section>

<!--模态框-查看模块-->
<section class="modal" id="modal-look" tabindex="-1" role="dialog">
    <form method="get" action="#" id="mainForm">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- 标题 -->
                <div class="modal-header">
                    <h3>查看模块</h3>
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                </div>
                <!-- 中间结构 -->
                <div class="modal-body" style="max-height: 300px; overflow-y: auto;">
                    <div class="modularBox">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">模块名称</label>
                            <div class="col-sm-8">
                                <p></p>
                            </div>
                            <div class="col-sm-1">
                                <a class="" href="javascript:void(0)" onclick="delModule(this)">x</a>
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="float:right">
                        <button type="button" class="btn btn-primary" id="addVar">添加模块</button>
                    </div>
                    <div id="platformId" style="display:none"></div>
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
                url: MyDoc.ip+"rest/platform/queryPlatform",
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
                    returnData.recordsTotal = result.data.platformDocs.total;// 返回数据全部记录 这里先定死 result.data.total
                    returnData.recordsFiltered = result.data.platformDocs.total;//查询返回数据全部记录，记录分页数  同上
                    returnData.data = result.data.platformDocs.list;
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
            {"data": "companyName"},
            {"data": "platformName"},
            {"data": "platformCreateTime"},
            {
                "data": "platformDocId",
                "orderable": false, // 禁用排序
                "defaultContent": "",
                "width": "10%",
                "render": function (data, type, row, meta) {
                    return data = '<button data-id="'+data+'" class="btn btn-default btn-sm view" data-id=' + data + ' ><i class="fa fa-search"></i> 查看模块</button>&nbsp;';

                }
            }
        ]
    });

    //追加表单
    $(function () {
        var varCount = 1;
        //新增按钮点击
        $('#addVar').on('click', function(){
            varCount++;
            $node ='<div class="form-group "> <label class="col-sm-3 control-label ">模块名称</label> <div class="col-sm-7">'+
                '<input type="text" name="moduleName" class="form-control" placeholder="模块名称" required data-bv-notempty-message="模块名称不能为空">'+
                '</div><div class="col-sm-1"><a class="addVar" href="javascript:void(0)" onclick="addModule(this)">+</a></div>'+
                '<div class="col-sm-1"><a class="removeVar" href="javascript:void(0)">x</a></div></div> ';
            //新表单项添加到“新增”按钮前面
            $(this).parent().before($node);
        });
        //删除按钮点击
        $('#mainForm').on('click', '.removeVar', function(){
            $(this).parents('.form-group').remove();
            varCount--;
        });
    });

    //曾看模块
    $("#example").on("click", "button.view", function(){
        var platformId = $(this).data("id");
        $("#modal-look").find('#platformId').html(platformId);
        $("#modal-look").modal();
        queryModuleClassifyByPlatformId();
    })

    function queryModuleClassifyByPlatformId(){
        var html =""
        var platformId = $("#modal-look").find('#platformId').html();
        var param = {map:{}};
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
                console.log(data);
                var list = data.data.platformDocModuleClassifies;
                // console.log(list);
                for(var a=0;a<list.length;a++){
                    var _this = list[a];
                    html += '<div class="form-group"><label for="rank" class="col-sm-3">模块名称：</label>'+
                        '<div class="col-sm-8"> <p>'+_this.moduleName+'</p> </div>'+
                        '<div class="col-sm-1"> <a class="" href="javascript:void(0)"  onclick="delModule(this)" data-moduleId ="'+_this.platformDocModuleClassifyId+'">x</a> </div> </div> ';
                }
                $("#modal-look").find('.modularBox').html(html);
            }
        });
    }

    //添加项目平台
    function  addPlatform() {
        var companyName =$('#modal-add').find('input[name=companyName]').val();
        var platformName =$('#modal-add').find('input[name=platformName]').val();

        var param = {map:{}};
        param.map.companyName = companyName;
        param.map.platformName = platformName;
        console.log(JSON.stringify(param));
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/platform/addPlatform",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                $('#modal-add').modal('hide');
                table._fnReDraw();
            }
        });
    };

    //添加模块
    function addModule(obj){
        var moduleName = $(obj).parent().siblings().find('input[name=moduleName]').val();
        var platformId = $("#modal-look").find('#platformId').html();
        var param = {map:{}};
        param.map.moduleName = moduleName;
        param.map.platformId = platformId;
        console.log(JSON.stringify(param));
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/platform/addModule",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                console.log(data);
                queryModuleClassifyByPlatformId();
                $(obj).parents('.form-group').remove();
            }
        });
    };

    //删除模块
    function delModule(obj){
        var res=confirm("如果删除模块后，模块内的接口将删除，请谨慎操作!");
        if (res == true) {
            var moduleId =  $(obj).data('moduleid');
            var param = {map:{}};
            param.map.moduleId = moduleId;
            $.ajax({
                type : "post",
                url : MyDoc.ip+"rest/platform/delModule",
                data : JSON.stringify(param),
                contentType: 'application/json;charset=UTF-8',
                dataType: "json",
                type: "post",
                async: false,
                success : function(data) {
                    console.log(data);
                    queryModuleClassifyByPlatformId();
                    $(obj).parents('.form-group').remove();
                }
            });
        }
    };

    //查看模块
</script>