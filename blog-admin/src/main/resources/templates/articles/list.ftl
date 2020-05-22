<!DOCTYPE html>
<html>
<#include "../include/macros.ftl">
<@header>
</@header>
<body>
<@indexHeader></@indexHeader>
<div class="d-flex align-items-stretch">
    <@indexSiderBar></@indexSiderBar>
    <div class="page-content">
        <!-- Page Header-->
        <div class="page-header no-margin-bottom">
            <div class="container-fluid">
                <h2 class="h5 no-margin-bottom">文章列表</h2>
            </div>
        </div>
        <!-- Breadcrumb-->
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li class="breadcrumb-item"><a href="/index">概览</a></li>
                <li class="breadcrumb-item active">文章管理</li>
            </ul>
        </div>
        <section class="no-padding-top">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="btn-group hidden-xs" id="toolbar">
                            <@shiro.hasPermission name="article:publish">
                                <a class="btn btn-success" title="发表文章"
                                   href="${(config.articleEditor! == 'md')?string('/article/publishMd', '/article/publish')}">
                                    <i class="fa fa-pencil fa-fw"></i> </a>
                            </@shiro.hasPermission>
                            <@shiro.hasPermission name="article:batchDelete">
                                <button id="btn_delete_ids" type="button" class="btn btn-danger" title="删除选中">
                                    <i class="fa fa-trash-o fa-fw"></i>
                                </button>
                            </@shiro.hasPermission>
                            <#-- 由草稿状态批量修改为已发布状态 -->
                            <@shiro.hasPermission name="article:publish">
                                <button id="btn_update_status" type="button" class="btn btn-default" title="批量发布">
                                    <i class="fa fa-bullhorn fa-fw"></i>
                                </button>
                            </@shiro.hasPermission>
                            <@shiro.hasPermission name="article:batchPush">
                                <button id="btn_push_ids" type="button" class="btn btn-info" title="批量推送到百度">
                                    <i class="fa fa-send-o fa-fw"></i>
                                </button>
                            </@shiro.hasPermission>
                        </div>
                        <div class="table-responsive">
                            <table id="tablelist"></table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <@indexFooter></@indexFooter>
    </div>
</div>
<@footer></@footer>
<script type="text/javascript">
    function operateFormatter(code, row, index) {
        var trId = row.id;
        var operateBtn = [
            '<@shiro.hasPermission name="article:push"><a class="btn btn-sm btn-info btn-push" title="推送" data-id="' + trId + '"><i class="fa fa-send-o"></i></a></@shiro.hasPermission>',
            '<@shiro.hasPermission name="article:edit"><a class="btn btn-sm btn-success" href="/article/update/' + trId + '"><i class="fa fa-edit fa-fw"></i></a></@shiro.hasPermission>',
            '<@shiro.hasPermission name="article:delete"><a class="btn btn-sm btn-danger btn-remove" data-id="' + trId + '"><i class="fa fa-trash-o fa-fw"></i></a></@shiro.hasPermission>',
            <#--'<@shiro.hasPermission name="article:top"><a class="btn btn-sm btn-success btn-top" data-id="' + trId + '">' + top + '</a></@shiro.hasPermission>',-->
            <#--'<@shiro.hasPermission name="article:recommend"><a class="btn btn-sm btn-success btn-recommend" data-id="' + trId + '">' + recommended + '</a></@shiro.hasPermission>'-->
        ];
        return operateBtn.join('');
    }

    $(function () {
        var options = {
            modalName: "文章",
            url: "/article/list",
            method: 'get',
            getInfoUrl: "/article/get/{id}",
            removeUrl: "/article/remove",
            columns: [
                {
                    checkbox: true
                }, {
                    field: 'title',
                    title: '标题',
                    width: '270px',
                }, {
                    field: 'pointCount',
                    title: '查看次数',
                    width: '50px',
                    align: 'center',
                    editable: false,
                }, {
                    field: 'pointCount',
                    title: '点赞次数',
                    width: '50px',
                    align: 'center',
                    editable: false,
                }, {
                    field: 'operate',
                    title: '操作',
                    align: "center",
                    width: '100px',
                    formatter: operateFormatter //自定义方法，添加操作按钮
                }
            ]
        };
        // 初始化table组件
        var table = new Table(options);
        table.init();
    });
</script>
</body>
</html>