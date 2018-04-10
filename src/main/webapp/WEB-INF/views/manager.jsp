<%@ page language="java" pageEncoding="utf-8"%>
<!-- BEGIN PAGE HEADER-->
<div class="row">
    <div class="col-md-12">
        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
        <h3 class="page-title" id="index-page-title">接口管理</h3>
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
                    接口管理
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
                    <input type="text" class="form-control" id="interfaceName"/>
                </div>
                <div class="form-group">
                    <label class=" control-label">方法名称：</label>
                    <input type="text" class="form-control" id="methodName"/>
                </div>
                <div class="form-group">
                    <label class=" control-label">项目名称：</label>
                    <select class="form-control" id="platformId">
                        <option value="0">请选择...</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class=" control-label">模块名称：</label>
                    <select class="form-control" id="moduleId">
                        <option value="0">请选择...</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="control-label">接口状态：</label>
                    <select class="form-control" id="status">
                        <option value="0">请选择...</option>
                        <option value="1">未启用</option>
                        <option value="2">已启用</option>
                        <option value="3">维护中</option>
                    </select>
                </div>
                <div class="form-group">
                    <button  type="button" class="btn btn-success search" id="search"><i class="fa fa-search"></i> 查询</button>
                </div>
                <div class="form-group" style="float:right">
                    <button  type="button" class="btn btn-primary search" id="add" href="#modal-add" data-toggle="modal"><i class="fa fa-plus-square"></i> 添加接口</button>
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

<!--模态框-添加接口-->
<section class="modal port-add" id="modal-add" tabindex="-1" role="dialog">
    <form method="get" action="#">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <!-- 标题 -->
                <div class="modal-header">
                    <h3>添加接口</h3>
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                </div>
                <!-- 中间结构 -->
                <div class="modal-body">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>用户名ID</label>
                            <div class="col-sm-8">
                                <p id="interfaceCreateUserIdAdd" style="border-bottom: 1px solid #ccc; padding: 7px; color: red;">${userInfo.userId}</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>用户名</label>
                            <div class="col-sm-8">
                                <p id="interfaceCreateUserNameAdd" style="border-bottom: 1px solid #ccc; padding: 7px; color: red;">${userInfo.username}</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>接口名称</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="interfaceNameAdd">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>方法名称</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="interfaceMethodNameAdd">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>方法用途</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="methodPurposeAdd">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>方法请求路径</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="methodRouteAdd">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>接口请求方式</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="interfaceRequestModeAdd">
                                    <option value="0">请选择...</option>
                                    <option value="post">post</option>
                                    <option value="get">get</option>
                                </select>
                            </div>

                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>接口响应方式</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="interfaceResponseModeAdd">
                                    <option value="0">请选择...</option>
                                    <option value="json">json</option>
                                    <option value="text">text</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>项目名称：</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="platformIdAdd">
                                    <option value="0">请选择...</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>模块名称：</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="moduleIdAdd">
                                    <option value="0">请选择...</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>接口状态：</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="interfaceStatusAdd">
                                    <option value="0">请选择...</option>
                                    <option value="1">未启用</option>
                                    <option value="2">已启用</option>
                                    <option value="3">维护中</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>部门</label>
                            <div class="col-sm-8">
                                <select name="departmentId" id="departmentIdAdd" class="select2 form-control">
                                    <option value="0">全部</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>全局集合</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="globalClassifyIdAdd">
                                    <option value="0">请选择...</option>
                                </select>
                            </div>

                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>方法请求演示</label>
                            <div class="col-sm-8">
                                <textarea class="form-control" id="methodRequestDemoAdd" cols="30" rows="10"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>方法结果演示</label>
                            <div class="col-sm-8">
                                <textarea class="form-control" id="methodResultDemoAdd" cols="30" rows="10"></textarea>
                            </div>
                        </div>
                        <div class="modal-header" style="border-top:1px solid #333333;">
                            <h3>请求参数</h3>
                            <button type="button" class="btn btn-primary" id="requestAddVarAdd" data-id style="float: right;">添加</button>
                        </div>
                        <div class="modal-body">
                            <div class="requestBoxAdd">
                                <table class="table table-hover table-bordered" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>名称</th>
                                        <th>类型</th>
                                        <th>必须</th>
                                        <th>备注</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody></tbody>
                                </table>
                            </div>
                        </div>
                        <div class="modal-header" style="border-top:1px solid #333333;">
                            <h3>响应参数</h3>
                            <button type="button" class="btn btn-primary" id="responseAddVarAdd" data-id style="float: right;">添加</button>
                        </div>
                        <div class="modal-body">
                            <div class="responseBoxAdd">
                                <table class="table table-hover table-bordered" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>名称</th>
                                        <th>类型</th>
                                        <th>必须</th>
                                        <th>备注</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody></tbody>
                                </table>
                            </div>
                        </div>
                    </fieldset>
                </div>

                <div class="modal-footer">
                    <a href="javascript:void(0)" type="button" class="btn btn-primary" onclick="add()">保存</a>
                    <button type="button" class="btn btn-custom4" data-dismiss="modal">取消</button>
                </div>

            </div><!-- .modal-content end-->
        </div><!-- .modal-dialog end-->
    </form>
</section>

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
                            <div class="requestBoxLook">
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
                            <div class="responseBoxLook">
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


<!--模态框-编辑接口-->
<section class="modal port-edit" id="modal-edit" tabindex="-1" role="dialog">
    <form method="get" action="#">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <!-- 标题 -->
                <div class="modal-header">
                    <h3>编辑接口</h3>
                    <span id="interfaceId" style="display: none"></span>
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                </div>
                <!-- 中间结构 -->
                <div class="modal-body">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>用户名ID</label>
                            <div class="col-sm-8">
                                <p id="interfaceCreateUserIdEdit" style="border-bottom: 1px solid #ccc; padding: 7px; color: red;">${userInfo.userId}</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>用户名</label>
                            <div class="col-sm-8">
                                <p id="interfaceCreateUserNameEdit" style="border-bottom: 1px solid #ccc; padding: 7px; color: red;">${userInfo.username}</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>接口名称</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="interfaceNameEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>方法名称</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="methodNameEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>方法用途</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="methodPurposeEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>方法请求路径</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="methodRouteEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>接口请求方式</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="interfaceRequestModeEdit">
                                    <option value="0">请选择...</option>
                                    <option value="post">post</option>
                                    <option value="get">get</option>
                                    <option value="put">put</option>
                                    <option value="delete">delete</option>
                                </select>
                            </div>

                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>接口响应方式</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="interfaceResponseModeEdit">
                                    <option value="0">请选择...</option>
                                    <option value="json">json</option>
                                    <option value="text">text</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>项目名称：</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="platformIdEdit">
                                    <option value="0">请选择...</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>模块名称：</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="moduleIdEdit">
                                    <option value="0">请选择...</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>接口状态：</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="interfaceStatusEdit">
                                    <option value="0">请选择...</option>
                                    <option value="1">未启用</option>
                                    <option value="2">已启用</option>
                                    <option value="3">维护中</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>部门</label>
                            <div class="col-sm-8">
                                <select id="departmentIdEdit" class="select2 form-control">
                                    <option value="0">全部</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>全局集合</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="globalClassifyIdEdit">
                                    <option value="0">请选择...</option>
                                </select>
                            </div>

                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>方法请求演示</label>
                            <div class="col-sm-8">
                                <textarea class="form-control" id="methodRequestDemoEdit" cols="30" rows="10"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label"><sup>*</sup>方法结果演示</label>
                            <div class="col-sm-8">
                                <textarea class="form-control" id="methodResultDemoEdit" cols="30" rows="10"></textarea>
                            </div>
                        </div>
                        <div class="modal-header" style="border-top:1px solid #333333;">
                            <h3>请求参数</h3>
                            <button type="button" class="btn btn-primary" id="requestAddVarEdit" data-id style="float: right;">添加</button>
                        </div>
                        <div class="modal-body">
                            <div class="requestBoxEdit">
                                <table class="table table-hover table-bordered" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>名称</th>
                                        <th>类型</th>
                                        <th>必须</th>
                                        <th>备注</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody></tbody>
                                </table>
                            </div>
                        </div>
                        <div class="modal-header" style="border-top:1px solid #333333;">
                            <h3>响应参数</h3>
                            <button type="button" class="btn btn-primary" id="responseAddVarEdit" data-id style="float: right;">添加</button>
                        </div>
                        <div class="modal-body">
                            <div class="responseBoxEdit">
                                <table class="table table-hover table-bordered" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>名称</th>
                                        <th>类型</th>
                                        <th>必须</th>
                                        <th>备注</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody></tbody>
                                </table>
                            </div>
                        </div>
                    </fieldset>
                </div>

                <div class="modal-footer">
                    <a href="javascript:void(0)" type="button" class="btn btn-primary" onclick="edit()">保存</a>
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
                    确定要删除该接口吗
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
                    $("#platformIdAdd").append("<option value='"+data.data.platformDocs.list[i].platformDocId+"'>"+data.data.platformDocs.list[i].platformName+"</option>");
                    $("#platformIdEdit").append("<option value='"+data.data.platformDocs.list[i].platformDocId+"'>"+data.data.platformDocs.list[i].platformName+"</option>");
                }
            }
        });
    })

    //追加表单 添加 请求
    $(function () {
        var varCount = 1;
        //新增按钮点击
        $('#requestAddVarAdd').on('click', function(){
            varCount++;
            $node ='<tr class="requestAdd">'+
                '<td><input type="text" name="fieldNameRequestAdd" class="form-control"></td>'+
                '<td></td>'+
                '<td><select class="form-control" name="fieldMustRequestAdd"><option value="1">是</option><option value="0">否</option></select></td>'+
                '<td><input type="text" name="fieldRemarkRequestAdd" class="form-control" placeholder="备注" required data-bv-notempty-message="备注不能为空"></td>'+
                '<td><button class="btn btn-danger removeVarAdd" href="javascript:void(0)" >删除</button></td></tr>'

            var param = {map:{}};
            $.ajax({
                type : "post",
                url :   MyDoc.ip+"rest/doc/queryDataType",
                data : JSON.stringify(param),
                contentType: 'application/json;charset=UTF-8',
                dataType: "json",
                type: "post",
                async: false,
                success : function(data) {
                    console.log(data)
                    $node ='<tr class="requestEdit">'+
                        '<td><input type="text" name="fieldNameRequestAdd" class="form-control"></td>'+
                        '<td><select class="form-control" name="fieldTypeRequestAdd">';

                    for (var i = 0; i< data.data.dataType.length; i++) {
                        var dataTypeElement = data.data.dataType[i];
                        $node += '<option value='+dataTypeElement+'>'+dataTypeElement+'</option>';
                    }
                    $node +='</select></td>'+
                        '<td><select class="form-control" name="fieldMustRequestAdd"><option value="1">是</option><option value="0">否</option></select></td>'+
                        '<td><input type="text" name="fieldRemarkRequestAdd" class="form-control" placeholder="备注" required data-bv-notempty-message="备注不能为空"></td>'+
                        '<td><button class="btn btn-danger removeVarAdd" href="javascript:void(0)" >删除</button></td></tr>';
                }
            });

            //新表单项添加到“新增”按钮前面
            $('.requestBoxAdd table tbody').append($node);
        });
        //删除按钮点击
        $('.requestBoxAdd').on('click', '.removeVarAdd', function(){
            $(this).parents('tr').remove();
            varCount--;
        });
    });


    // 追加表单 添加 响应
    $(function () {
        var varCount = 1;
        // 新增按钮点击
        $('#responseAddVarAdd').on('click', function(){
            varCount++;
            $node ='<tr class="responseAdd">'+
                '<td><input type="text" name="fieldNameResponseAdd" class="form-control"></td>'+
                '<td></td>'+
                '<td><select class="form-control" name="fieldMustResponseAdd"><option value="1">是</option><option value="0">否</option></select></td>'+
                '<td><input type="text" name="fieldRemarkResponseAdd" class="form-control" placeholder="备注" required data-bv-notempty-message="备注不能为空"></td>'+
                '<td><button class="btn btn-danger removeVarAdd" href="javascript:void(0)" >删除</button></td></tr>'

            var param = {map:{}};
            $.ajax({
                type : "post",
                url :   MyDoc.ip+"rest/doc/queryDataType",
                data : JSON.stringify(param),
                contentType: 'application/json;charset=UTF-8',
                dataType: "json",
                type: "post",
                async: false,
                success : function(data) {
                    console.log(data)
                    $node ='<tr class="responseEdit">'+
                        '<td><input type="text" name="fieldNameResponseAdd" class="form-control"></td>'+
                        '<td><select class="form-control" name="fieldTypeResponseAdd">';

                    for (var i = 0; i< data.data.dataType.length; i++) {
                        var dataTypeElement = data.data.dataType[i];
                        $node += '<option value='+dataTypeElement+'>'+dataTypeElement+'</option>';
                    }
                    $node +='</select></td>'+
                        '<td><select class="form-control" name="fieldMustResponseAdd"><option value="1">是</option><option value="0">否</option></select></td>'+
                        '<td><input type="text" name="fieldRemarkResponseAdd" class="form-control" placeholder="备注" required data-bv-notempty-message="备注不能为空"></td>'+
                        '<td><button class="btn btn-danger removeVarAdd" href="javascript:void(0)" >删除</button></td></tr>';
                }
            });

            //新表单项添加到“新增”按钮前面
            $('.responseBoxAdd table tbody').append($node);
        });

        //删除按钮点击
        $('.responseBoxAdd').on('click', '.removeVarAdd', function(){
            $(this).parents('tr').remove();
            varCount--;
        });
    });

    //追加表单 编辑 请求
    $(function () {
        var varCount = 1;
        //新增按钮点击
        $('#requestAddVarEdit').on('click', function(){
            varCount++;
            $node ='<tr class="requestEdit">'+
                '<td><input type="text" name="fieldNameRequestEdit" class="form-control"></td>'+
                '<td></td>'+
                '<td><select class="form-control" name="fieldMustRequestEdit"><option value="1">是</option><option value="0">否</option></select></td>'+
                '<td><input type="text" name="fieldRemarkRequestEdit" class="form-control" placeholder="备注" required data-bv-notempty-message="备注不能为空"></td>'+
                '<td><button class="btn btn-danger removeVarEdit" href="javascript:void(0)" >删除</button></td></tr>'

            var param = {map:{}};
            $.ajax({
                type : "post",
                url :   MyDoc.ip+"rest/doc/queryDataType",
                data : JSON.stringify(param),
                contentType: 'application/json;charset=UTF-8',
                dataType: "json",
                type: "post",
                async: false,
                success : function(data) {
                    console.log(data)
                    $node ='<tr class="requestEdit">'+
                            '<td><input type="text" name="fieldNameRequestEdit" class="form-control"></td>'+
                            '<td><select class="form-control" name="fieldTypeRequestEdit">';

                    for (var i = 0; i< data.data.dataType.length; i++) {
                        var dataTypeElement = data.data.dataType[i];
                        $node += '<option value='+dataTypeElement+'>'+dataTypeElement+'</option>';
                    }
                    $node +='</select></td>'+
                        '<td><select class="form-control" name="fieldMustRequestEdit"><option value="1">是</option><option value="0">否</option></select></td>'+
                        '<td><input type="text" name="fieldRemarkRequestEdit" class="form-control" placeholder="备注" required data-bv-notempty-message="备注不能为空"></td>'+
                        '<td><button class="btn btn-danger removeVarEdit" href="javascript:void(0)" >删除</button></td></tr>';
                }
            });

            //新表单项添加到“新增”按钮前面
            $('.requestBoxEdit table tbody').append($node);
        });
        //删除按钮点击
        $('.requestBoxEdit').on('click', '.removeVarEdit', function(){
            $(this).parents('tr').remove();
            varCount--;
        });
    });


    // 追加表单 编辑 响应
    $(function () {
        var varCount = 1;
        // 新增按钮点击
        $('#responseAddVarEdit').on('click', function(){


            varCount++;
            $node ='<tr class="responseEdit">'+
                '<td><input type="text" name="fieldNameResponseEdit" class="form-control"></td>'+
                '<td></td>'+
                '<td><select class="form-control" name="fieldMustResponseEdit"><option value="1">是</option><option value="0">否</option></select></td>'+
                '<td><input type="text" name="fieldRemarkResponseEdit" class="form-control" placeholder="备注" required data-bv-notempty-message="备注不能为空"></td>'+
                '<td><button class="btn btn-danger removeVarEdit" href="javascript:void(0)" >删除</button></td></tr>'

            var param = {map:{}};
            $.ajax({
                type : "post",
                url :   MyDoc.ip+"rest/doc/queryDataType",
                data : JSON.stringify(param),
                contentType: 'application/json;charset=UTF-8',
                dataType: "json",
                type: "post",
                async: false,
                success : function(data) {
                    console.log(data)
                    $node ='<tr class="responseEdit">'+
                        '<td><input type="text" name="fieldNameResponseEdit" class="form-control"></td>'+
                        '<td><select class="form-control" name="fieldTypeResponseEdit">';

                    for (var i = 0; i< data.data.dataType.length; i++) {
                        var dataTypeElement = data.data.dataType[i];
                        $node += '<option value='+dataTypeElement+'>'+dataTypeElement+'</option>';
                    }
                    $node +='</select></td>'+
                        '<td><select class="form-control" name="fieldMustResponseEdit"><option value="1">是</option><option value="0">否</option></select></td>'+
                        '<td><input type="text" name="fieldRemarkResponseEdit" class="form-control" placeholder="备注" required data-bv-notempty-message="备注不能为空"></td>'+
                        '<td><button class="btn btn-danger removeVarEdit" href="javascript:void(0)" >删除</button></td></tr>';
                }
            });

            //新表单项添加到“新增”按钮前面
            $('.responseBoxEdit table tbody').append($node);
        });

        //删除按钮点击
        $('.responseBoxEdit').on('click', '.removeVarEdit', function(){
            $(this).parents('tr').remove();
            varCount--;
        });
    });


    // 请求全局字段集合
    $(function() {
        var param = {map:{}};
        $.ajax({
            type : "post",
            url :   MyDoc.ip+"rest/department/selectDepartment",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                var obj1=document.getElementById('departmentIdAdd');
                var obj2=document.getElementById('departmentIdEdit');
                for (var i = 0; i < data.data.departments.length; i++) {
                    obj1.options.add(new Option(data.data.departments[i].departmentName,data.data.departments[i].departmentId)); //这个兼容IE与firefox
                    obj2.options.add(new Option(data.data.departments[i].departmentName,data.data.departments[i].departmentId)); //这个兼容IE与firefox
                }
            }
        });
    })

    // 请求部门集合
    $(function() {
        param.map.pageSize = 9999;//页面显示记录条数，在页面显示每页显示多少项的时候
        param.map.pageNo = 1;//当前页码
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/doc/queryGlobalFieldGroup",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                for (var i = 0;i < data.data.globalClassifies.list.length; i++) {
                    $("#globalClassifyId").append("<option value='"+data.data.globalClassifies.list[i].globalClassifyId+"'>"+data.data.globalClassifies.list[i].globalClassifyName+"</option>");
                    $("#globalClassifyIdAdd").append("<option value='"+data.data.globalClassifies.list[i].globalClassifyId+"'>"+data.data.globalClassifies.list[i].globalClassifyName+"</option>");
                    $("#globalClassifyIdEdit").append("<option value='"+data.data.globalClassifies.list[i].globalClassifyId+"'>"+data.data.globalClassifies.list[i].globalClassifyName+"</option>");
                }
            }
        });
    })

    // 点击搜索平台 填充模块
    $("select#platformId").change(function(){
        var param = {map:{}};
        var platformId = $('#platformId').val();
        var obj=document.getElementById('moduleId');
        obj.options.length=1;
        if (platformId != 0) {
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
    });

    // 添加接口 搜索平添 填充模块
    $("select#platformIdAdd").change(function(){
        var param = {map:{}};
        var platformId = $('#platformIdAdd').val();
        var obj=document.getElementById('moduleIdAdd');
        obj.options.length=1;
        if (platformId != 0) {
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
                        $("#moduleIdAdd").append("<option value='"+data.data.platformDocModuleClassifies[i].platformDocModuleClassifyId+"'>"+data.data.platformDocModuleClassifies[i].moduleName+"</option>");
                    }
                }
            });
        }
    });

    // 编辑接口 搜索平添 填充模块
    $("select#platformIdEdit").change(function(){
        var param = {map:{}};
        var platformId = $('#platformIdEdit').val();
        var obj=document.getElementById('moduleIdEdit');
        obj.options.length=1;
        if (platformId != 0) {
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
                        $("#moduleIdEdit").append("<option value='"+data.data.platformDocModuleClassifies[i].platformDocModuleClassifyId+"'>"+data.data.platformDocModuleClassifies[i].moduleName+"</option>");
                    }
                }
            });
        }
    });

    // 添加接口
    function add() {
        var param = {map:{
            userId:${userInfo.userId},
            interfaceInfo:{},
            interfaceRequestFields:{},
            interfaceResponseFields:{}
        }};
        var request = new Array()
        var result = new Array()

        var requestObj = {}
        var resultObj = {}
        var interfaceObj = {}

        var interfaceName = $("#interfaceNameAdd").val();
        var methodName = $("#interfaceMethodNameAdd").val();
        var methodPurpose = $("#methodPurposeAdd").val();
        var methodRoute = $("#methodRouteAdd").val();
        var methodRequestDemo = $("#methodRequestDemoAdd").val();
        var methodResultDemo = $("#methodResultDemoAdd").val();
        var interfaceRequestMode = $("#interfaceRequestModeAdd").val();
        var interfaceResponseMode = $("#interfaceResponseModeAdd").val();
        var platformDocId = $("#platformIdAdd").val();
        var platformDocModuleClassifyId = $("#moduleIdAdd").val();
        var interfaceStatus = $("#interfaceStatusAdd").val();
        var departmentId = $("#departmentIdAdd").val();
        var globalClassifyId = $("#globalClassifyIdAdd").val();
        interfaceObj.interfaceCreateUserId = $("#interfaceCreateUserIdAdd").html();
        interfaceObj.interfaceCreateUserName = $("#interfaceCreateUserNameAdd").html();
        interfaceObj.interfaceName = interfaceName;
        interfaceObj.methodName = methodName;
        interfaceObj.methodPurpose = methodPurpose;
        interfaceObj.methodRoute = methodRoute;
        interfaceObj.methodRequestDemo = methodRequestDemo;
        interfaceObj.methodResultDemo = methodResultDemo;
        interfaceObj.interfaceRequestMode = interfaceRequestMode;
        interfaceObj.interfaceResponseMode = interfaceResponseMode;
        interfaceObj.platformDocId = platformDocId;
        interfaceObj.platformDocModuleClassifyId = platformDocModuleClassifyId;
        interfaceObj.departmentId = departmentId;
        interfaceObj.globalClassifyId = globalClassifyId;
        interfaceObj.interfaceStatus = interfaceStatus;
        param.map.interfaceInfo = interfaceObj;
        $(".requestAdd").each(function(){
            $(this).each(function(){
                var requestObj = {}
                requestObj.fieldName =  $(this).find("input[name=fieldNameRequestAdd]").val();
                requestObj.fieldType =  $(this).find("select[name=fieldTypeRequestAdd]").val();
                requestObj.fieldMust =  $(this).find("select[name=fieldMustRequestAdd]").val();
                requestObj.fieldRemark =  $(this).find("input[name=fieldRemarkRequestAdd]").val();
                request.push(requestObj);
            });
        });
        param.map.interfaceRequestFields = request;
        console.log(param)
        $(".responseAdd").each(function(){
            $(this).each(function(){
                var resultObj = {}
                resultObj.fieldName =  $(this).find("input[name=fieldNameResponseAdd]").val();
                resultObj.fieldType =  $(this).find("select[name=fieldTypeResponseAdd]").val();
                resultObj.fieldMust =  $(this).find("select[name=fieldMustResponseAdd]").val();
                resultObj.fieldRemark =  $(this).find("input[name=fieldRemarkResponseAdd]").val();
                result.push(resultObj);
            });
        });
        param.map.interfaceResponseFields = result;
        console.log(param)
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/doc/addDoc",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                console.log(data)
                Messenger.options = {
                    extraClasses: 'messenger-fixed messenger-on-top',
                    theme: 'block'
                }
                Messenger().post({
                    message: data.subMessage,
                    type: 'info',
                    showCloseButton: true
                });
                $("#modal-add").modal("hide");
                $('#example').dataTable().fnDraw(false);
            }
        });
    }

    // 编辑
    function edit() {
        var param = {map:{
            userId:${userInfo.userId},
            interfaceInfo:{},
            interfaceRequestFields:{},
            interfaceResponseFields:{}
        }};
        var request = new Array()
        var result = new Array()

        var requestObj = {}
        var resultObj = {}
        var interfaceObj = {}
        var interfaceInfoId = $("#interfaceId").html();
        var interfaceName = $("#interfaceNameEdit").val();
        var methodName = $("#methodNameEdit").val();
        var methodPurpose = $("#methodPurposeEdit").val();
        var methodRoute = $("#methodRouteEdit").val();
        var methodRequestDemo = $("#methodRequestDemoEdit").val();
        var methodResultDemo = $("#methodResultDemoEdit").val();
        var interfaceRequestMode = $("#interfaceRequestModeEdit").val();
        var interfaceResponseMode = $("#interfaceResponseModeEdit").val();
        var platformDocId = $("#platformIdEdit").val();
        var platformDocModuleClassifyId = $("#moduleIdEdit").val();
        var interfaceStatus = $("#interfaceStatusEdit").val();
        var departmentId = $("#departmentIdEdit").val();
        var globalClassifyId = $("#globalClassifyIdEdit").val();
        interfaceObj.interfaceCreateUserId = $("#interfaceCreateUserIdEdit").html();
        interfaceObj.interfaceCreateUserName = $("#interfaceCreateUserNameEdit").html();
        interfaceObj.interfaceInfoId = interfaceInfoId;
        interfaceObj.interfaceName = interfaceName;
        interfaceObj.methodName = methodName;
        interfaceObj.methodPurpose = methodPurpose;
        interfaceObj.methodRoute = methodRoute;
        interfaceObj.methodRequestDemo = methodRequestDemo;
        interfaceObj.methodResultDemo = methodResultDemo;
        interfaceObj.interfaceRequestMode = interfaceRequestMode;
        interfaceObj.interfaceResponseMode = interfaceResponseMode;
        interfaceObj.platformDocId = platformDocId;
        interfaceObj.platformDocModuleClassifyId = platformDocModuleClassifyId;
        interfaceObj.departmentId = departmentId;
        interfaceObj.globalClassifyId = globalClassifyId;
        interfaceObj.interfaceStatus = interfaceStatus;
        param.map.interfaceInfo = interfaceObj;
        $(".requestEdit").each(function(){
            $(this).each(function(){
                var requestObj = {}
                requestObj.fieldName =  $(this).find("input[name=fieldNameRequestEdit]").val();
                requestObj.fieldType =  $(this).find("select[name=fieldTypeRequestEdit]").val();
                requestObj.fieldMust =  $(this).find("select[name=fieldMustRequestEdit]").val();
                requestObj.fieldRemark =  $(this).find("input[name=fieldRemarkRequestEdit]").val();
                request.push(requestObj);
            });
        });
        param.map.interfaceRequestFields = request;
        $(".responseEdit").each(function(){
            $(this).each(function(){
                var resultObj = {}
                resultObj.fieldName =  $(this).find("input[name=fieldNameResponseEdit]").val();
                resultObj.fieldType =  $(this).find("select[name=fieldTypeResponseEdit]").val();
                resultObj.fieldMust =  $(this).find("select[name=fieldMustResponseEdit]").val();
                resultObj.fieldRemark =  $(this).find("input[name=fieldRemarkResponseEdit]").val();
                result.push(resultObj);
            });
        });
        param.map.interfaceResponseFields = result;
        console.log(param)
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/doc/updateDoc",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                console.log(data)
                Messenger.options = {
                    extraClasses: 'messenger-fixed messenger-on-top',
                    theme: 'block'
                }
                Messenger().post({
                    message: data.subMessage,
                    type: 'info',
                    showCloseButton: true
                });
                $("#modal-edit").modal("hide");
                $('#example').dataTable().fnDraw(false);
            }
        });
    }

    // 搜索 模块判断
    $("#moduleId").click(function () {
        var platformId = $('#platformId').val();
        if (platformId == 0) {
            $("#modal-prompting").modal();
        }
    })

    // 添加 模块判断
    $("#moduleIdAdd").click(function () {
        var platformId = $('#platformIdAdd').val();
        if (platformId == 0) {
            $("#modal-prompting").modal();
        }
    })

    // 编辑 模块判断
    $("#moduleIdEdit").click(function () {
        var platformId = $('#platformIdEdit').val();
        if (platformId == 0) {
            $("#modal-prompting").modal();
        }
    })

    // table填充
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
            param.map.pageSize = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
            param.map.pageNo = (data.start / data.length)+1;//当前页码
            //ajax请求数据
            $.ajax({
                url: MyDoc.ip+"rest/doc/manager",
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
                    return data ='<button data-id="'+data+'" class="btn btn-info btn-sm edit" data-id=' + data + ' href="#modal-edit" data-toggle="modal"><i class="fa fa-pencil"></i> 编辑</button>&nbsp;'
                        + '<button data-id="'+data+'" class="btn btn-primary btn-sm look" data-id=' + data + ' href="#modal-look" data-toggle="modal"><i class="fa fa-search"></i> 查看</button>&nbsp;'
                        + '<button data-id="'+data+'" class="btn btn-danger btn-sm delete" data-id=' + data + ' href="#modal-del" data-toggle="modal"><i class="fa fa-trash-o"></i> 删除</button>&nbsp;';

                }
            }
        ]
    });

    $("#example").on("click", "button.delete", function() {
        var del = $(this).data("id");
        $("#del").html(del);
    })

    $("#example").on("click", "button.edit", function() {
        var dataType;
        var param = {map:{}};
        $.ajax({
            type : "post",
            url :   MyDoc.ip+"rest/doc/queryDataType",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                dataType = data;
            }
        });

        var id = $(this).data("id");
        var param = {map:{}};
        param.map.interfaceInfoId = id;
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/doc/editInterfaceById",
            data : JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            dataType: "json",
            type: "post",
            async: false,
            success : function(data) {
                console.log(data);
                $("#interfaceId").html(data.data.interface.interfaceEditVO.interfaceInfoId) ;
                $("#interfaceNameEdit").val(data.data.interface.interfaceEditVO.interfaceName) ;
                $("#methodNameEdit").val(data.data.interface.interfaceEditVO.methodName);
                $("#methodPurposeEdit").val(data.data.interface.interfaceEditVO.methodPurpose);
                $("#methodRouteEdit").val(data.data.interface.interfaceEditVO.methodRoute);
                $("#methodRequestDemoEdit").val(data.data.interface.interfaceEditVO.methodRequestDemo);
                $("#methodResultDemoEdit").val(data.data.interface.interfaceEditVO.methodResultDemo);
                $("#interfaceRequestModeEdit").val(data.data.interface.interfaceEditVO.interfaceRequestMode);
                $("#interfaceResponseModeEdit").val(data.data.interface.interfaceEditVO.interfaceResponseMode);
                $("#interfaceCreateUserIdEdit").val(data.data.interface.interfaceEditVO.interfaceCreateUserId);
                $("#interfaceCreateUserNameEdit").val(data.data.interface.interfaceEditVO.interfaceCreateUserName);
                $("#interfaceStatusEdit").val(data.data.interface.interfaceEditVO.interfaceStatus);
                $("#departmentIdEdit").val(data.data.interface.interfaceEditVO.departmentId);
                $("#globalClassifyIdEdit").val(data.data.interface.interfaceEditVO.globalClassifyId);
                $("#platformIdEdit").val(data.data.interface.interfaceEditVO.platformDocId);
                var param = {map:{}};
                if (platformId != 0) {
                    param.map.platformId = data.data.interface.interfaceEditVO.platformDocId;
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
                                $("#moduleIdEdit").append("<option value='"+data.data.platformDocModuleClassifies[i].platformDocModuleClassifyId+"'>"+data.data.platformDocModuleClassifies[i].moduleName+"</option>");
                            }
                        }
                    });
                }
                $("#moduleIdEdit").val(data.data.interface.interfaceEditVO.platformDocModuleClassifyId);
                var htmlRequest =" ";
                for (var i = 0; i<data.data.interface.interfaceRequestFields.length; i++) {
                    var statusName = "";
                    if (data.data.interface.interfaceRequestFields[i].fieldMust == 0) {
                        statusName = "是"
                    } else {
                        statusName = "否"
                    }
                    var op = "";
                    for (var a = 0; a< dataType.data.dataType.length; a++) {
                        if (data.data.interface.interfaceRequestFields[i].fieldType == dataType.data.dataType[a]) {
                            op += "<option value="+dataType.data.dataType[a]+" selected='selected'>"+dataType.data.dataType[a]+"</option>"
                        } else {
                            op += "<option value="+dataType.data.dataType[a]+">"+dataType.data.dataType[a]+"</option>"
                        }
                    }

                    var must = "";
                    if (data.data.interface.interfaceRequestFields[i].fieldMust == "0") {
                        must += "<option value='0' selected='selected'>否</option>"
                    } else {
                        must += "<option value='0'>否</option>"
                    }
                    if (data.data.interface.interfaceRequestFields[i].fieldMust == "1") {
                        must += "<option value='1' selected='selected'>是</option>"
                    } else {
                        must += "<option value='1'>是</option>"
                    }
                    htmlRequest +='<tr class="requestEdit">'+
                        '<td><input type="text" name="fieldNameRequestEdit" class="form-control" placeholder="字段名称" value="'+data.data.interface.interfaceRequestFields[i].fieldName+'"></td>'+
                        '<td><select class="form-control" name="fieldTypeRequestEdit">'+op+'</select></td>'+
                        '<td><select class="form-control" name="fieldMustRequestEdit">'+must+'</select></td>'+
                        '<td><input type="text" name="fieldRemarkRequestEdit" class="form-control" value="'+data.data.interface.interfaceRequestFields[i].fieldRemark+'"></td>'+
                        '<td><button class="btn btn-danger removeVarEdit" href="javascript:void(0)" >删除</button></td></tr>'
                }

                $('.requestBoxEdit table tbody').html(htmlRequest);
                var htmlResult = "";
                for (var i = 0; i<data.data.interface.interfaceResponseFields.length; i++) {
                    var statusName = "";
                    if (data.data.interface.interfaceResponseFields[i].fieldMust == 0) {
                        statusName = "是"
                    } else {
                        statusName = "否"
                    }

                    var op = "";
                    for (var a = 0; a < dataType.data.dataType.length; a++) {
                        if (data.data.interface.interfaceResponseFields[i].fieldType == dataType.data.dataType[a]) {
                            op += "<option value="+dataType.data.dataType[a]+" selected='selected'>"+dataType.data.dataType[a]+"</option>"
                        } else {
                            op += "<option value="+dataType.data.dataType[a]+">"+dataType.data.dataType[a]+"</option>"
                        }
                    }

                    var must = "";
                    if (data.data.interface.interfaceResponseFields[i].fieldMust == "0") {
                        must += "<option value='0' selected='selected'>否</option>"
                    } else {
                        must += "<option value='0'>否</option>"
                    }
                    if (data.data.interface.interfaceResponseFields[i].fieldMust == "1") {
                        must += "<option value='1' selected='selected'>是</option>"
                    } else {
                        must += "<option value='1'>是</option>"
                    }
                    htmlResult +='<tr class="responseEdit">'+
                        '<td><input type="text" name="fieldNameResponseEdit" class="form-control" placeholder="字段名称" value="'+data.data.interface.interfaceResponseFields[i].fieldName+'"></td>'+
                        '<td><select class="form-control" name="fieldTypeResponseEdit">'+op+'</select></td>'+
                        '<td><select class="form-control" name="fieldMustResponseEdit">'+must+'</select></td>'+
                        '<td><input type="text" name="fieldRemarkResponseEdit" class="form-control" value="'+data.data.interface.interfaceResponseFields[i].fieldRemark+'"></td>'+
                        '<td><button class="btn btn-danger removeVarEdit" href="javascript:void(0)" >删除</button></td></tr>'
                    //新表单项添加到“新增”按钮前面
                }
                $('.responseBoxEdit table tbody').html(htmlResult);

            }
        });
    })

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
                        '<td><p class="form-control-static" name="fieldNameRequestLook">'+data.data.interface.interfaceRequestFields[i].fieldName+'</p></td>'+
                        '<td><p class="form-control-static" name="fieldTypeRequestLook">'+data.data.interface.interfaceRequestFields[i].fieldType+'</p></td>'+
                        '<td><p class="form-control-static" name="fieldMustRequestLook">'+statusName+'</p></td>'+
                        '<td><p class="form-control-static" name="fieldRemarkRequestLook">'+data.data.interface.interfaceRequestFields[i].fieldRemark+'</p></tr>'
                    //新表单项添加到“新增”按钮前面

                }
                $('.requestBoxLook table tbody').html(htmlRequest);
                var htmlResult = "";
                for (var i = 0; i<data.data.interface.interfaceResponseFields.length; i++) {
                    var statusName = "";
                    if (data.data.interface.interfaceResponseFields[i].fieldMust == 0) {
                        statusName = "否"
                    } else {
                        statusName = "是"
                    }
                    htmlResult +='<tr>'+
                        '<td><p class="form-control-static" id="fieldNameResponseLook">'+data.data.interface.interfaceResponseFields[i].fieldName+'</p></td>'+
                        '<td><p class="form-control-static" id="fieldTypeResponseLook">'+data.data.interface.interfaceResponseFields[i].fieldType+'</p></td>'+
                        '<td><p class="form-control-static" id="fieldMustResponseLook">'+statusName+'</p></td>'+
                        '<td><p class="form-control-static" id="fieldRemarkResponseLook">'+data.data.interface.interfaceResponseFields[i].fieldRemark+'</p></tr>'
                    //新表单项添加到“新增”按钮前面
                }
                $('.responseBoxLook table tbody').html(htmlResult);
            }
        });
    })

    $("#modal-del").on("click", "button.yesDel", function() {
        var del = $("#del").html();
        var param = {map:{}};
        param.map.interfaceInfoId = del;
        $.ajax({
            type : "post",
            url : MyDoc.ip+"rest/doc/deleteDoc",
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
        var interfaceName = $("#interfaceName").val();
        var methodName = $("#methodName").val();
        var moduleId = $("#moduleId").val();
        var platformId = $("#platformId").val();
        var status = $("#status").val();
        param.map.interfaceName = interfaceName;
        param.map.methodName = methodName;
        param.map.moduleId = moduleId;
        param.map.platformId = platformId;
        param.map.status = status;
        table._fnReDraw();
    })

</script>