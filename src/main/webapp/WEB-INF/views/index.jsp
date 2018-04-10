<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->
    <head>
        <base href="<%=basePath%>">
        <meta charset="utf-8" />
        <title>MyDoc</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
        <meta content="" name="description" />
        <meta content="" name="author" />
        <meta name="MobileOptimized" content="320">

        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->

        <!-- BEGIN THEME STYLES -->
        <link href="assets/css/style-metronic.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/style.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/style-responsive.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/plugins.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/pages/tasks.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="assets/css/custom.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="assets/plugins/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/messenger.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/messenger-theme-future.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/messenger-theme-air.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/messenger-theme-block.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/messenger-theme-flat.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/messenger-theme-ice.css" rel="stylesheet" type="text/css"/>
        <!-- END THEME STYLES -->

        <link rel="shortcut icon" href="app/img/favicon.ico" />
    </head>
    <!-- END HEAD -->

    <!-- BEGIN BODY -->
    <body class="page-header-fixed">
        <!-- BEGIN HEADER -->

        <%@include file="com/head.jsp" %>
        <!-- END HEADER -->
        <div class="clearfix"></div>
        <!-- BEGIN CONTAINER -->
        <div class="page-container">
            <!-- BEGIN SIDEBAR -->
            <div class="page-sidebar-wrapper">
                <%@include file="com/left-nav.jsp" %>
            </div>
            <!-- END SIDEBAR -->
            <!-- BEGIN CONTENT -->
            <div class="page-content-wrapper">
                <div class="page-content">
                    <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
                    <div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                                    <h4 class="modal-title">Modal title</h4>
                                </div>
                                <div class="modal-body">
                                    Widget settings form goes here
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn blue">
                                        Save changes
                                    </button>
                                    <button type="button" class="btn default" data-dismiss="modal">
                                        Close
                                    </button>
                                </div>
                            </div>
                            <!-- /.modal-content -->
                        </div>
                        <!-- /.modal-dialog -->
                    </div>
                    <!-- /.modal -->
                    <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
                    <!-- BEGIN STYLE CUSTOMIZER -->
                    <div class="theme-panel hidden-xs hidden-sm">
                        <div class="toggler"></div>
                        <div class="toggler-close"></div>
                        <div class="theme-options">
                            <div class="theme-option theme-colors clearfix">
                                <span> 主题颜色 </span>
                                <ul>
                                    <li class="color-black current color-default" data-style="default"></li>
                                    <li class="color-blue" data-style="blue"></li>
                                    <li class="color-brown" data-style="brown"></li>
                                    <li class="color-purple" data-style="purple"></li>
                                    <li class="color-grey" data-style="grey"></li>
                                    <li class="color-white color-light" data-style="light"></li>
                                </ul>
                            </div>
                            <div class="theme-option">
                                <span> 布局 </span>
                                <select class="layout-option form-control input-small">
                                    <option value="fluid">顺序</option>
                                    <option value="boxed">盒状</option>
                                </select>
                            </div>
                            <div class="theme-option">
                                <span> 标题 </span>
                                <select class="header-option form-control input-small">
                                    <option value="fixed">固定</option>
                                    <option value="default">默认</option>
                                </select>
                            </div>
                            <div class="theme-option">
                                <span> 工具栏 </span>
                                <select class="sidebar-option form-control input-small">
                                    <option value="fixed">固定</option>
                                    <option value="default">默认</option>
                                </select>
                            </div>
                            <div class="theme-option">
                                <span> 工具栏位置 </span>
                                <select class="sidebar-pos-option form-control input-small">
                                    <option value="left">左边</option>
                                    <option value="right">右边</option>
                                </select>
                            </div>
                            <div class="theme-option">
                                <span> 页脚 </span>
                                <select class="footer-option form-control input-small">
                                    <option value="fixed">固定</option>
                                    <option value="default">默认</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <!-- END STYLE CUSTOMIZER -->

                    <!-- BEGIN DASHBOARD STATS -->
                    <div id="main-content"></div>

                    <!-- END PORTLET-->
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END CONTAINER -->
        <!-- BEGIN FOOTER -->
        <%@include file="com/footer.jsp" %>
        <!--[if lt IE 9]>
        <script src="assets/plugins/respond.min.js"></script>
        <script src="assets/plugins/excanvas.min.js"></script>
        <![endif]-->
        <script src="assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
        <script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
        <script src="assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>

        <%--<script src="assets/plugins/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>--%>
        <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
        <script src="assets/plugins/datatable/jquery.dataTables.min.js" type="text/javascript"></script><!--datatable-->
        <script src="assets/plugins/datatable/dataTables.bootstrap.min.js" type="text/javascript"></script><!--datatable-->
        <script type="text/javascript" src="assets/plugins/select2/select2.min.js"></script>
        <script src="assets/scripts/messenger.js" type="text/javascript"></script>
        <script src="assets/scripts/base.js" type="text/javascript"></script>
        <script src="assets/scripts/messenger-theme-future.js" type="text/javascript"></script>
        <script src="assets/scripts/messenger-theme-flat.js" type="text/javascript"></script>
        <script src="assets/scripts/app.js" type="text/javascript"></script>
        <script type="text/javascript" src="app/js/index.js"></script>


        <!-- <script data-main="app/js/main" src="app/lib/requirejs/require.js"></script> -->
    <script>
        function  manager() {
            var url = "rest/page/manager";
            if (url != null && url != 'javascript:;') {
                $.get(url, function(data) {
                    $('#main-content').html(data);
                });
            }
        }
        function  doc() {
            var url = "rest/page/doc";
            if (url != null && url != 'javascript:;') {
                $.get(url, function(data) {
                    $('#main-content').html(data);
                });
            }
        }

        function  platform() {
            var url = "rest/page/platform";
            if (url != null && url != 'javascript:;') {
                $.get(url, function(data) {
                    $('#main-content').html(data);
                });
            }
        }

        function  platformSkip(platformDocId) {
            var url = "rest/page/platformInterface";
            if (url != null && url != 'javascript:;') {
                $.get(url, {platformId : platformDocId}, function(data) {
                    $('#main-content').html(data);
                });
            }
        }

        function  global() {
            var url = "rest/page/global";
            if (url != null && url != 'javascript:;') {
                $.get(url, function(data) {
                    $('#main-content').html(data);
                });
            }
        }
        function  dictionary() {
            var url = "rest/page/dictionary";
            if (url != null && url != 'javascript:;') {
                $.get(url, function(data) {
                    $('#main-content').html(data);
                });
            }
        }

        function  main() {
            var url = "rest/page/home";
            if (url != null && url != 'javascript:;') {
                $.get(url, function(data) {
                    $('#main-content').html(data);
                });
            }
        }

        function  platformHome() {
            var url = "rest/page/platformHome";
            if (url != null && url != 'javascript:;') {
                $.get(url, function(data) {
                    $('#main-content').html(data);
                });
            }
        }
    </script>
    </body>
</html>