<%@ page import="com.tan.voting_system.pojo.VotingOptions" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: TS
  Date: 2022/12/30
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看投票结果</title>
  <base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/ "/>
  <link rel="stylesheet" href="layui-v2.6.8/layui/css/layui.css">
</head>
<body>
<div class="layui-layout layui-layout-admin" style="width:70%;margin:80px 0 0 auto">
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

    <div class="layui-bg-gray" >
        <!-- 内容主体区域 -->
            <h1>${votingThemes.theme}</h1>
            <%
                List<VotingOptions> options = (List<VotingOptions>) request.getAttribute("options");
                int num = (int) request.getAttribute("num");
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                for (VotingOptions option : options) {%>
            <div class="layui-row layui-form-item">
                <label><%=option.getVote_number()%>票</label>
                <div class="layui-col-md6">
                    <div class="layui-progress layui-progress-big" lay-showpercent="true">
                        <div class="layui-progress-bar layui-bg-black"
                             lay-percent="<%=decimalFormat.format((((double )option.getVote_number()/(double ) num)*100))%>%"></div>
                    </div>
                </div>
                <div class="layui-col-md6">
                    <p style="color: black"><%=option.getOption_name()%></p>
                </div>
            </div>
            <%}%>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
    </div>
</div>
<script src="layui-v2.6.8/layui/layui.js"></script>
</body>
</html>
