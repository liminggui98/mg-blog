<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

    <title>${config.siteName}</title>
    <link href="/assets/images/favicon.ico" rel="icon">
    <link href="/assets/css/common/common.css" rel="stylesheet" type="text/css"/>
    <link href="/assets/plugins/layui/css/layui.css" rel="stylesheet" type="text/css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <#include "/common/header.ftl"/>

    <#include "/common/left-menu.ftl"/>

    <div class="layui-body" style="padding: 20px; background-color: #F2F2F2;">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <table class="layui-hide" id="table" lay-filter="data"></table>

                        <script type="text/html" id="toolbar">
                            <div class="layui-table-tool-temp">
                                <div class="layui-inline" lay-event="add">
                                    <i class="layui-icon layui-icon-add-1"></i>
                                </div>
                                <div class="layui-inline" lay-event="update">
                                    <i class="layui-icon layui-icon-edit"></i>
                                </div>
                                <div class="layui-inline" lay-event="delete">
                                    <i class="layui-icon layui-icon-delete"></i>
                                </div>
                                <div class="layui-inline">
                                    <input class="layui-input" placeholder="搜索" style="height: 26px;font-size: 20px;"
                                           name="id" id="demoReload" autocomplete="off">
                                </div>
                            </div>
                        </script>

                        <script type="text/html" id="bar">
                            <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <#include "/common/footer.ftl"/>
</div>
<script src="/assets/js/common/table.js"></script>
<script>
    let dataOption = ${tableOption};
    blogTable.init(dataOption);
</script>
</body>
</html>
