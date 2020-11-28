<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>查看详情</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="/assets/plugins/layui/css/layui.css" rel="stylesheet" type="text/css">
</head>
<body>
<form class="layui-form" method="post" style="margin-top: 20px;">
    <div class="layui-form-item">
        <label class="layui-form-label">角色名称 *</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="title" autocomplete="off" placeholder="请输入角色名称"
                   class="layui-input" style="width: 95%;" value="${data.name}" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">角色描述 *</label>
        <div class="layui-input-block">
            <input type="text" name="description" lay-verify="title" autocomplete="off" placeholder="请输入角色描述"
                   class="layui-input" style="width: 95%;" value="${data.description}" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">是否可用 *</label>
        <div class="layui-input-block">
            <select name="available" lay-verify="required" style="width: 95%;" disabled>
                <option value="">请选择</option>
                <#if data.available>
                    <option value="0" selected>不可用</option>
                    <option value="1">可用</option>
                <#else>
                    <option value="0">不可用</option>
                    <option value="1" selected>可用</option>
                </#if>
            </select>
        </div>
    </div>
</form>
<script src="/assets/plugins/layui/layui.js"></script>
<script>
    layui.use(['form'], function () {
    });
</script>
</body>
</html>
