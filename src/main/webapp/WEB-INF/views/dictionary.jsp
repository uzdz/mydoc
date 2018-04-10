<%@ page language="java" pageEncoding="utf-8"%>
<!-- BEGIN PAGE HEADER-->
<div class="row">
    <div class="col-md-12">
        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
        <h3 class="page-title" id="index-page-title">字典表</h3>
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
                    字典表
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
                    <label class=" control-label">Code：</label>
                    <input type="text" class="form-control" id="code" name="code"/>
                </div>
                <div class="form-group">
                    <label class=" control-label">Message：</label>
                    <input type="text" class="form-control" id="message" name="message"/>
                </div>
                <div class="form-group">
                    <label class=" control-label">项目平台：</label>
                    <select class="form-control" id="platformId" name="platformId">
                        <option value="0">请选择...</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="control-label">字典分类：</label>
                    <select class="form-control" id="rank" name="rank">
                        <option value="0">请选择...</option>
                        <option value="1">系统级主错误编码</option>
                        <option value="2">业务级公共错误编码</option>
                        <option value="3">业务级错误编码</option>
                    </select>
                </div>
                <div class="form-group">
                    <button  type="button" class="btn btn-success search" id="search"><i class="fa fa-search"></i> 查询</button>
                </div>
                <div class="form-group" style="float:right">
                    <button  type="button" href="#modal-add" data-toggle="modal" class="btn btn-primary search" id="add" ><i class="fa fa-plus-square"></i> 添加字典</button>
                </div>
            </div>
    </div>
</div>

<div id = "box">
    <table id="example" class="table table-hover table-bordered dataTable dataTable-nosort" cellspacing="0">
        <thead>
        <tr>
            <th width="7%">Code值</th>
            <th width="7%">Message值</th>
            <th width="7%">字典分类</th>
            <th width="7%">设置</th>
        </tr>
        </thead>
    </table>
</div>

<!--模态框-添加字典表-->
<section class="modal" id="modal-add" tabindex="-1" role="dialog">
    <form method="get" action="#">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- 标题 -->
                <div class="modal-header">
                    <h3>添加字典表</h3>
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                </div>
                <!-- 中间结构 -->
                <div class="modal-body">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>Code：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="codeAdd">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>Message：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="messageAdd">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3  control-label">项目平台：</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="platformAdd">
                                    <option value="0">请选择...</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>字典类别：</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="rankAdd">
                                    <option value="0">请选择...</option>
                                    <option value="1">系统级主错误编码</option>
                                    <option value="2">业务级公共错误编码</option>
                                    <option value="3">业务级错误编码</option>
                                </select>
                            </div>
                        </div>
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <a href="javascript:void(0)" type="button" class="btn btn-primary" onclick="addDictionaryTable()">添加</a>
                    <button type="button" class="btn btn-custom4" data-dismiss="modal">取消</button>
                </div>
            </div><!-- .modal-content end-->
        </div><!-- .modal-dialog end-->
    </form>
</section>

<!--模态框-修改字典表-->
<section class="modal" id="modal-edit" tabindex="-1" role="dialog">
    <form method="get" action="#">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- 标题 -->
                <div class="modal-header">
                    <h3>添加字典表</h3>
                    <span id="update" style="display: none"></span>
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                </div>
                <!-- 中间结构 -->
                <div class="modal-body">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>Code：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="codeEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>Message：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="messageEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3  control-label">项目平台：</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="platformEdit">
                                    <option value="0">请选择...</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>字典类别：</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="rankEdit">
                                    <option value="0">请选择...</option>
                                    <option value="1">系统级主错误编码</option>
                                    <option value="2">业务级公共错误编码</option>
                                    <option value="3">业务级错误编码</option>
                                </select>
                            </div>
                        </div>
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <a href="javascript:void(0)" type="button" class="btn btn-primary" onclick="updateDictionaryTable()">修改</a>
                    <button type="button" class="btn btn-custom4" data-dismiss="modal">取消</button>
                </div>
            </div><!-- .modal-content end-->
        </div><!-- .modal-dialog end-->
    </form>
</section>

<!--模态框-删除-->
<section class="modal" id="modal-del" tabindex="-1" role="dialog">
    <form method="get" action="#">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <!-- 标题 -->
                <div class="modal-header">
                    <h3>删除</h3>
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                </div>
                <!-- 中间结构 -->
                <div class="modal-body">
                    确定要删除该字典吗
                </div>
                <span id="del" style="display: none"></span>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger yesDel">Delete</button>
                    <button type="button" class="btn btn-custom4" data-dismiss="modal">Cancel</button>
                </div>

            </div><!-- .modal-content end-->
        </div><!-- .modal-dialog end-->
    </form>
</section>

<script>
    var param = {map:{}};
    $(function() {
        param.map.pageSize = 9999;//页面显示记录条数，在页面显示每页显示多少项的时候
        param.map.pageNo = 1;//当前页码
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/platform/queryPlatform",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                for (var i = 0;i < data.data.platformDocs.list.length; i++) {
                    $("#platformId").append("<option value='"+data.data.platformDocs.list[i].platformDocId+"'>"+data.data.platformDocs.list[i].platformName+"</option>");
                    $("#platformAdd").append("<option value='"+data.data.platformDocs.list[i].platformDocId+"'>"+data.data.platformDocs.list[i].platformName+"</option>");
                    $("#platformEdit").append("<option value='"+data.data.platformDocs.list[i].platformDocId+"'>"+data.data.platformDocs.list[i].platformName+"</option>");
                }
            }
        });
    })

    //添加字典表
    function  addDictionaryTable() {
        var code =$('#modal-add').find('input[id=codeAdd]').val();
        var message =$('#modal-add').find('input[id=messageAdd]').val();
        var platform =$('#modal-add').find('select[id=platformAdd]').val();
        var rank =$('#modal-add').find('select[id=rankAdd]').val();

        var param = {map:{}};
        param.map.code = code;
        param.map.message = message;
        param.map.platformId = platform;
        param.map.rank = rank;
        console.log(JSON.stringify(param));
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/doc/addDictionaryField",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                Messenger.options = {
                    extraClasses: 'messenger-fixed messenger-on-top',
                    theme: 'block'
                }
                Messenger().post({
                    message: data.subMessage,
                    type: 'info',
                    showCloseButton: true
                });
                console.log(data);
                $('#modal-add').modal('hide');
                table._fnReDraw();
            }
        });
    };

    //修改字典表
    function  updateDictionaryTable() {
        var code =$('#modal-edit').find('input[id=codeEdit]').val();
        var message =$('#modal-edit').find('input[id=messageEdit]').val();
        var platform =$('#modal-edit').find('select[id=platformEdit]').val();
        var rank =$('#modal-edit').find('select[id=rankEdit]').val();
        var dictionaryTableId = $("#update").html();
        var param = {map:{}};
        param.map.dictionaryTableId = dictionaryTableId;
        param.map.code = code;
        param.map.message = message;
        param.map.platformId = platform;
        param.map.rank = rank;
        console.log(JSON.stringify(param));
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/doc/updateDictionaryField",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                Messenger.options = {
                    extraClasses: 'messenger-fixed messenger-on-bottom messenger-on-right',
                    theme: 'flat'
                }
                Messenger().post({
                    message: data.subMessage,
                    type: 'info',
                    showCloseButton: true
                });
                console.log(data);
                $('#modal-edit').modal('hide');
                table._fnReDraw();
            }
        });
    };

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
            param.map.pageSize = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
            param.map.pageNo = (data.start / data.length)+1;//当前页码
            //ajax请求数据
            $.ajax({
                url: MyDoc.ip+"rest/doc/queryDictionaryField",
                data: JSON.stringify(param),
                contentType: 'application/json;charset=UTF-8',
                dataType: "json",
                type: "post",
                async: false,
                success: function (result) {
                    console.log(result);
                    //封装返回数据
                    var returnData = {};
                    returnData.draw = result.draw;//这里直接自行返回了draw计数器,应该由后台返回
                    returnData.recordsTotal = result.data.dictionaryTablePagination.total;// 返回数据全部记录 这里先定死 result.data.total
                    returnData.recordsFiltered = result.data.dictionaryTablePagination.total;//查询返回数据全部记录，记录分页数  同上
                    returnData.data = result.data.dictionaryTablePagination.list;
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
            {"data": "dictionaryTableCode"},
            {"data": "dictionaryTableMessage"},
            {"data": "dictionaryTableRank",sortable: false, render: function (dictionaryTableRank) {
                var dictionaryTableRankCN = "";
                if (dictionaryTableRank == 1) {
                    dictionaryTableRankCN = "系统级主错误编码";
                } else if (dictionaryTableRank == 2) {
                    dictionaryTableRankCN = "业务级公共错误编码";
                } else if (dictionaryTableRank == 3) {
                    dictionaryTableRankCN = "业务级错误编码";
                }
                return '<div>'+dictionaryTableRankCN+'</div>';
            }},
            {
                "data": "dictionaryTableId",
                "orderable": false, // 禁用排序
                "defaultContent": "",
                "width": "10%",
                "render": function (data, type, row, meta) {
                    return data = '<button data-id="'+data+'" class="btn btn-primary btn-sm edit" data-id=' + data + ' href="#modal-edit" data-toggle="modal"><i class="fa fa-pencil"></i> 编辑</button>&nbsp;'
                            + '<button data-id="'+data+'" class="btn btn-danger btn-sm delete" data-id=' + data + ' href="#modal-del" data-toggle="modal"><i class="fa fa-trash-o"></i> 删除</button>&nbsp;';
                }
            }
        ]
    });

    $("#example").on("click", "button.edit", function() {
        var id = $(this).data("id");
        $("#update").html(id);
        var param = {map:{}};
        param.map.dictionaryTableId = id;
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/doc/queryDictionaryFieldById",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                console.log(data)
                $("#codeEdit").val(data.data.dictionaryTable.dictionaryTableCode) ;
                $("#messageEdit").val(data.data.dictionaryTable.dictionaryTableMessage);
                $("#platformEdit").val(data.data.dictionaryTable.dictionaryTablePlatform);
                $("#rankEdit").val(data.data.dictionaryTable.dictionaryTableRank);
            }
        });
    })

    $("#example").on("click", "button.delete", function() {
        var del = $(this).data("id");
        $("#del").html(del);
    })

    $("#modal-del").on("click", "button.yesDel", function() {
        var del = $("#del").html();
        var param = {map:{}};
        param.map.dictionaryTableId = del;
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/doc/delDictionaryField",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                Messenger.options = {
                    extraClasses: 'messenger-fixed messenger-on-top',
                    theme: 'block'
                }
                Messenger().post({
                    message: data.subMessage,
                    type: 'info',
                    showCloseButton: true
                });
                $("#modal-del").modal("hide");
                $('#example').dataTable().fnDraw(false);
            }
        });
    })

    $("#search").click(function() {
        var code = $("#code").val();
        var message = $("#message").val();
        var platformId = $("#platformId").val();
        var rank = $("#rank").val();
        param.map.code = code;
        param.map.message = message;
        param.map.platformId = platformId;
        param.map.rank = rank;
        table._fnReDraw();
    })

</script>