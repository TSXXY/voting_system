<%--
  Created by IntelliJ IDEA.
  User: TS
  Date: 2022/12/29
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发起投票</title>
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
                        Cookie[] cookies = request.getCookies();
                        String name = null;
                        for (Cookie cookie : cookies) {
                            if (cookie.getName().equals("name")) name = cookie.getValue();
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
            <form class="layui-form" action="voting?action=createVote" method="post">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">投票标题</label>
                        <div class="layui-input-inline">
                            <input type="tel" name="theme"  autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item yf-input-del layui-form-item">
                    <label class="layui-form-label">投票选项</label>
                    <div class="layui-input-block" id="edu_bg">
                        <div class="layui-input-inline">
                            <input type="text" name="option_name" value="" autocomplete="off" placeholder="请输入" lay-verify="required" class="layui-input">
                            <i class="layui-icon deleteEduBg">&#x1006;</i>
                        </div>
                        <div class="layui-input-inline">
                            <input type="text" name="option_name" value="" autocomplete="off" placeholder="请输入" lay-verify="required" class="layui-input">
                            <i class="layui-icon deleteEduBg">&#x1006;</i>
                        </div>
                        <div class="layui-input-inline">
                            <input type="text" name="option_name" value="" autocomplete="off" placeholder="请输入" lay-verify="required" class="layui-input">
                            <i class="layui-icon deleteEduBg">&#x1006;</i>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item" id="edu_bg_add">
                    <label class="layui-form-label"></label>
                    <div class="layui-input-inline">
                        <a href="javascript:;" class="layui-btn site-demo-active" onclick="insertInput()">
                            <i class="layui-icon">&#xe654;</i> 添加选项
                        </a>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">结束日期</label>
                    <div class="layui-input-inline">
                        <input type="text" name="end_time" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="layui-footer">
        底部固定区域
    </div>
</div>
<script src="layui-v2.6.8/layui/layui.js"></script>
<script>
    //JS
        var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,$ = layui.jquery
            ,laydate = layui.laydate;
        var key1=$("#edu_bg").children(".layui-input-inline").length;
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
        //日期
        laydate.render({
            elem: '#date'
        });
        $("body").on("click",".deleteEduBg", function(e){
            if( key1 > 2 ) {
                $(this).parent('div').remove(); //移除对应的父级div元素
                key1--; //decrement textbox
            }else{
                layer.msg("至少留两个选项")
                return false;
            }
        })
    function insertInput() {
        var div1 = $("<div></div>").addClass("layui-input-inline");
        //console.log(edu_bg[FieldCount1]);
        var input1 = "<input type='text' name='option_name' value='' autocomplete='off' placeholder='请输入' lay-verify='required' class='layui-input'>"
        var icon1 = "<i class='layui-icon deleteEduBg' onclick='deleteElement(this)'>&#x1006;</i>";
        div1.append(input1, icon1);
        $("#edu_bg").append(div1);  // 追加新元素
        key1++;
    }

</script>

</body>
</html>
