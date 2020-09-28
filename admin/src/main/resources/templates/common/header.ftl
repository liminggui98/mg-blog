<header>
    <div class="layui-header">
        <div class="layui-logo">
            <a class="logo" href="/">
                <img width="82" height="31" src="/assets/images/logo.png" alt="${config.siteName}"
                     title="${config.siteName}">
            </a>
        </div>
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    访问前台
                </a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;" class="layui-icon layui-icon-email"></a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    minggui
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                    <dd><a href="">退出系统</a></dd>
                </dl>
            </li>
        </ul>
    </div>
    <script src="/assets/plugins/layui/layui.js"></script>
    <script src="/assets/plugins/jquery/jquery.min.js"></script>
    <script>
        layui.use(['element'], function () {
            let element = layui.element;
        });
    </script>
</header>
