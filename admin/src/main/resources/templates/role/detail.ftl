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
