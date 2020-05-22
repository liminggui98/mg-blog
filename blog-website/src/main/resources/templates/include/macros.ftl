<#-- 公共顶部 -->
<#macro header title="MG BLOG" keywords="" description="" canonical="" hasEditor=false>
    <#include "/common/annotation.ftl">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">

        <title>${title}</title>
        <meta name="keywords" content="${keywords}">
        <meta name="description" content="${description}">

        <link href="/css/base.css" rel="stylesheet" type="text/css">

        <script src="/js/jquery-1.8.3.min.js" type="text/javascript"></script>
        <script src="/js/jquery.slides.min.js" type="text/javascript"></script>
        <script src="/js/base.js" type="text/javascript"></script>
    </head>
</#macro>

<#-- 公共底部 -->
<#macro footer>
    <div class="footer_box">
        <div class="footer clearfix">
            <div class="footer_img">
                <ul>
                    <li>
                        <img src="img/self_qq_bottom_erweima.png">
                        <span>我的qq</span>
                    </li>
                    <li>
                        <img src="img/self_weixin_bottom_erweima.jpg">
                        <span>我的微信</span>
                    </li>
                </ul>
            </div>
            <div class="footer_text">
                <p><i>站点声明：</i></p>
                <p>1、本站创建的目的以学习交流为基础，记录日常生活中遇到的事物。</p>
                <p>2、本站中所有分享的模板只供个人学习研究使用，未经允许不得用于任何商业目的。</p>
                <p>3、本站所有文章均可转载，请注明出处，欢迎大家看到喜欢的文章帮忙转发点赞。举报意见邮箱：446157433@qq.com</p>
                <p>Copyright © 2014-2019 大青牛爱穿山甲 保留所有版权</p>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        function search_btn_click() {
            $("#search_form").attr("action","/search");
            $("#search_form").submit();
        }
    </script>
</#macro>

<#-- 分页组件 -->
<#macro pageBar>
    <#if page?? && (page.pages > 1)>
        <nav class="pagination"
             data-url="${config.siteUrl}/${url!}"
             data-search="${(model.keywords == null || model.keywords == '')?string('false', 'true')}"
             data-total-page="${page.pages?c}"
             data-current-page="${page.pageNum?c}"
             data-pre="${page.prePage}"
             data-next="${page.nextPage}"></nav>
    </#if>
</#macro>

<#-- blog-header -->
<#macro blogHeader title="Header" weiboName="@我的微博">
    <div class="col-sm-12 blog-main">
        <div class="blog-header">
            <h4>${title}</h4>
            <p class="blog-description" id="hitokoto"></p>
            <div>
                <a href="javascript:void(0);" target="_blank" title="点击QQ联系我"
                   onclick="window.open('tencent://message/?uin=${config.qq}&amp;Site=www.${config.domain}&amp;Menu=yes')"
                   rel="external nofollow"><i class="fa fa fa-qq fa-fw"></i>QQ联系</a>
                |
                <a href="mailto:${config.authorEmail}" target="_blank" title="点击给我发邮件" rel="external nofollow"><i
                            class="fa fa fa-envelope fa-fw"></i>邮箱联系</a>
                |
                <a href="${config.weibo}" target="_blank" title="点击查看我的微博" rel="external nofollow"><i
                            class="fa fa fa-weibo fa-fw"></i>${weiboName}</a>
            </div>
        </div>
    </div>
</#macro>

<#-- 页面顶部、菜单下方提示栏 -->
<#macro prompt>
    <div class="head_box">
        <div class="header">
            <div class="header_logo">
                <a href="/index"><h2>MG BLOG</h4></a>
            </div>
            <div class="header_nav">
                <ul class="clearfix">
                    <li><a href="#">后端技术</a></li>
                    <li class="have_second"><a href="#">前端技术</a>
                        <ul class="nav_second">
                            <i></i>
                            <li><a href="#">模板分享</a></li>
                            <li><a href="#">模板分享</a></li>
                            <li><a href="#">模板分享</a></li>
                        </ul>
                    </li>
                    <li class="have_second">
                        <a href="#">面试总结</a>
                        <ul class="nav_second">
                            <i></i>
                            <li><a href="#">CSS笔记</a></li>
                            <li><a href="#">JS笔记</a></li>
                            <li><a href="#">Jquery笔记</a></li>
                        </ul>
                    </li>
                    <li><a href="#">我的博文</a></li>
                    <li><a href="/about">关于我</a></li>
                </ul>
            </div>
            <div class="header_search">
                <a href="#" class="header_search_btn">
                    <i></i>
                </a>
            </div>
            <div class="header_nav_small_btn">
                <span class="small_btn"></span>
            </div>
        </div>
    </div>
    <div class="search_box">
        <div class="search">
            <form name="search_form" class="search_form" id="search_form" method="post" target="_self">
                <input type="text" class="search_text" name="keyBoard" placeholder="输入关键字点击搜索">
                <input type="hidden" name="tb_name" value="news">
                <input type="hidden" name="show" value="title">
                <input type="hidden" name="temp_id" value="1">
                <input type="javascript:void(0);" class="search_btn" onclick="search_btn_click()" value="搜索一下">
            </form>
        </div>
    </div>
</#macro>

<#-- 赞赏 -->
<#macro praise>
    <#if config.wxPraiseCode! || config.zfbPraiseCode!>
        <h5 class="custom-title"><i class="fa fa-dollar fa-fw"></i><strong>鼓励一下</strong><small></small></h5>
        <div class="col-sm-12 col-md-12" style="float: initial;">
            <#if config.zfbPraiseCode!>
                <a href="${config.zfbPraiseCode}" class="showImage" title="支付宝收钱码" rel="external nofollow">
                    <img src="${config.zfbPraiseCode}" alt="支付宝收钱码" class="img-rounded"
                         style="width: 250px;height: auto;">
                </a>
            </#if>
            <#if config.wxPraiseCode!>
                <a href="${config.wxPraiseCode}" class="showImage" title="微信收钱码" rel="external nofollow">
                    <img src="${config.wxPraiseCode}" alt="微信收钱码" class="img-rounded"
                         style="width: 250px;height: auto;">
                </a>
            </#if>
        </div>
    </#if>
</#macro>

<#macro right>
    <div class="right">
        <!--个人介绍部分-->
        <div class="self_info right_box">
            <img src="/img/self.jpg">
            <div class="self_info_text">
                <h3>大青牛和穿山甲</h3>
                <div>
                    <p>以彼之长，增长自身</p>
                    <p>有匪君子，如切如磋，如琢如磨。</p>
                    <p>天将降大任于斯人也，必先苦其心志、磨其胫骨、饿其体肤</p>
                </div>
                <a href="#">Read More</a>
            </div>
        </div>
        <!--微信二维码部分-->
        <div class="self_erweima right_box">
            <h3>微信二维码</h3>
            <div>
                <img src="/img/self_weixin_erweima.png">
            </div>
        </div>
        <!--qq二维码部分-->
        <div class="self_erweima right_box">
            <h3>QQ二维码</h3>
            <div>
                <img src="/img/self_qq_erweima.png">
            </div>
        </div>
        <!--友情链接-->
        <div class="right_box youlian_list">
            <h3>友情链接</h3>
            <div>
                <ul>
                    <li><a href="#">最新模板-律所类模板</a></li>
                </ul>
            </div>
        </div>
    </div>
</#macro>