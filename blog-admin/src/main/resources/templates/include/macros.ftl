<#-- 公共顶部 -->
<#macro header title="MG BLOG" keywords="" description="" canonical="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>${title}</title>
        <meta name="keywords" content="${keywords}">
        <meta name="description" content="${description}">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="robots" content="all,follow">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-table@1.11.1/dist/bootstrap-table.min.css">
        <link rel="stylesheet" href="/vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/vendor/bootstrap/css/bootstrap-treetable.css"></link>
        <link rel="stylesheet" href="/vendor/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="/css/font.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Muli:300,400,700">
        <link rel="stylesheet" href="/css/style.blue.css" id="theme-stylesheet">
        <link rel="stylesheet" href="/css/custom.css">
        <#-- <link rel="shortcut icon" href="img/favicon.ico">-->

        <!-- Tweaks for older IEs-->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
</#macro>

<#-- 公共底部 -->
<#macro footer>
    <!-- JavaScript files-->
    <script src="/vendor/jquery/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap-table@1.11.1/dist/bootstrap-table.min.js"></script>
    <script src="/vendor/popper.js/umd/popper.min.js"></script>
    <script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="/vendor/bootstrap/js/bootstrap-treetable.js"></script>
    <script src="/vendor/jquery.cookie/jquery.cookie.js"></script>
    <script src="/vendor/chart.js/Chart.min.js"></script>
    <script src="/vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="/js/front.js"></script>
    <script src="/js/table.js"></script>
</#macro>

<#-- 内部公共顶部 -->
<#macro indexHeader>
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid d-flex align-items-center justify-content-between">
            <div class="navbar-header">
                <!-- Navbar Header-->
                <a href="/index" class="navbar-brand">
                    <div class="brand-text brand-big visible text-uppercase"><strong
                                class="text-primary">MG BLOG &nbsp;</strong><strong>Admin</strong></div>
                    <div class="brand-text brand-sm"><strong class="text-primary">M</strong><strong>G</strong></div>
                </a>
                <!-- Sidebar Toggle Btn-->
                <button class="sidebar-toggle"><i class="fa fa-long-arrow-left"></i></button>
            </div>
            <div class="right-menu list-inline no-margin-bottom">
                <!-- Log out               -->
                <div class="list-inline-item logout">
                    <a id="logout" href="/logout" class="nav-link">
                        <span class="d-none d-sm-inline">退出登录</span>
                        <i class="icon-logout"></i>
                    </a>
                </div>
            </div>
        </div>
    </nav>
</#macro>

<#macro indexFooter>
    <footer class="footer">
        <div class="footer__block block no-margin-bottom">
            <div class="container-fluid text-center">
                <p class="no-margin-bottom">Copyright &copy; 2019.Personal minggui All rights reserved.More
                    Templates</p>
            </div>
        </div>
    </footer>
</#macro>

<#macro indexSiderBar>
    <!-- Sidebar Navigation-->
    <nav id="sidebar">
        <!-- Sidebar Header-->
        <div class="sidebar-header d-flex align-items-center">
            <div class="avatar"><img src="/img/avatar-6.jpg" alt="..." class="img-fluid rounded-circle"></div>
            <div class="title">
                <h1 class="h5">Li MingGui</h1>
                <p>JAVA开发者</p>
            </div>
        </div>
        <span class="heading">主要功能</span>
        <ul class="list-unstyled">
            <li class="active"><a href="/index"> <i class="icon-home"></i>概览</a></li>
            <li><a href="/articles"> <i class="icon-grid"></i>文章管理</a></li>
            <li><a href="/charts"> <i class="fa fa-bar-chart"></i>统计 </a></li>
            <li><a href="/monitor/druid"> <i class="icon-writing-whiteboard"></i>数据库监控</a></li>
            <li><a href="/forms"> <i class="icon-padnote"></i>Forms </a></li>
        </ul>
    </nav>
    <!-- Sidebar Navigation end-->
</#macro>