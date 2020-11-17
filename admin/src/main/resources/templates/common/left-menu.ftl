<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
            <#list menus as menu>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="${menu.url}">${menu.name}</a>
                    <#if menu.nodes?size!=0>
                        <dl class="layui-nav-child">
                            <#list menu.nodes as subMenu>
                                <dd><a href="${subMenu.url}">${subMenu.name}</a></dd>
                            </#list>
                        </dl>
                    </#if>
                </li>
            </#list>
        </ul>
    </div>
</div>
