<%--
  Created by IntelliJ IDEA.
  User: TS
  Date: 2022/12/28
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>正在投票</title>
    <base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/ "/>
    <link rel="stylesheet" href="layui-v2.6.8/layui/css/layui.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">投票系统</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>

            <li class="layui-nav-item layui-hide-xs"><a href="home.jsp">正在投票</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="votingHistory.jsp">历史投票</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="createVote.jsp">发起投票</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <p href="javascript:;">
                    <%
                        String name = null;
                        String userId = null;
                        if (request.getAttribute("name") == null && request.getAttribute("userid") == null){
                        Cookie[] cookies = request.getCookies();
                        for (Cookie cookie : cookies) {
                            if (cookie.getName().equals("name")) name = cookie.getValue();
                            if (cookie.getName().equals("userid")) userId = cookie.getValue();
                        }
                        }else {
                            name =(String)request.getAttribute("name");
                           userId = request.getAttribute("userid").toString();
                            System.out.println(userId);
                        }
                    %>
                    <%=name%>
                </p>
            </li>
        </ul>
    </div>

    <div>
        <!-- 内容主体区域 -->
        <div style="padding: 15px;margin-top: 60px">
            <table class="layui-hide" id="test" lay-filter="demo"></table>
            <script type="text/html" id="checkboxTpl">
                <button type="button" class="layui-btn layui-btn-normal layui-btn-sm" lay-event="update">进行投票</button>
            </script>
        </div>
    </div>

    <div class="layui-footer">
        底部固定区域
    </div>
</div>
<script src="layui-v2.6.8/layui/layui.js"></script>
<script>
    //JS
    layui.use(['element', 'layer', 'util',"jquery"], function(){
        var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,table = layui.table
            ,$ = layui.jquery;

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function(othis){
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            ,menuRight: function(){
                layer.open({
                    type: 1
                    ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    ,area: ['260px', '100%']
                    ,offset: 'rt' //右上角
                    ,anim: 5
                    ,shadeClose: true
                });
            }
        });

        //---------------
        table.render({
            elem: '#test'
            , url: "voting?action=getConductVoting"
            , cellMinWidth: 80
            , cols: [[
                  {type: 'numbers'}
                , {field: 'id', title: 'ID', unresize: true, hide: true}
                , {field: 'theme', title: '投票主题', templet: '#usernameTpl'}
                , {field: 'start_time', title: '开始时间'}
                , {field: 'end_time', title: '结束时间'}
                , {field: '#', title: '操作', templet: '#checkboxTpl', width: 150}
            ]]
        });
        table.on('tool(demo)', function (obj) {
            let data = obj.data
            if (obj.event === 'update'){
                var a = document.createElement('a');
                a.setAttribute('href', "voting?userid=<%=userId%>"+"&themeid="+data.id+ "&action=goToVote");
                document.body.appendChild(a);
                a.click();
            }
        })
    });
</script>
</body>
</html>
