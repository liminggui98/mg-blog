<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加角色</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="/assets/plugins/layui/css/layui.css" rel="stylesheet" type="text/css">
</head>
<body>
<form class="layui-form" action="" method="post">
    <div class="layui-form-item" style="width: 95%;">
        <label class="layui-form-label">角色名称 *</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="title" autocomplete="off" placeholder="请输入角色名称"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="width: 95%;">
        <label class="layui-form-label">角色描述 *</label>
        <div class="layui-input-block">
            <input type="text" name="description" lay-verify="title" autocomplete="off" placeholder="请输入角色描述"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="width: 95%;">
        <label class="layui-form-label">是否可用 *</label>
        <div class="layui-input-block">
            <select name="available" lay-verify="required">
                <option value="">请选择</option>
                <option value="0">不可用</option>
                <option value="1">可用</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item" style="width: 95%;display: none">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="add" id="LAY-add-submit">立即提交</button>
        </div>
    </div>
</form>
<script src="/assets/plugins/layui/layui.js"></script>
<script>
    layui.use(['form'], function () {
        let form = layui.form
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '至少得5个字符啊';
                }
            },
            pass: [
                /^[\S]{6,12}$/,
                '密码必须6到12位，且不能出现空格'
            ],
            content: function (value) {
            }
        });

        //监听提交
        form.on('submit(add)', function(data){
            tableIns.reload(option);
        });
    });
</script>
</body>
</html>
