<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>公共头部</title>

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/common.css">
</head>
<body>
<div class="public-header">
    <div class="public-container clearfloat">
        <div class="header-logo left-float"><a href="#"><img src="${pageContext.request.contextPath}/images/logo.png"></a></div>

        <ul class="header-nav clearfloat">
            <li class="item left-float"><a class="nav-link first-link" href="#">首页</a></li>
            <li class="item left-float"><a class="nav-link" href="#">租车</a></li>
            <li class="item left-float"><a class="nav-link" href="#">租私家车</a></li>
            <li class="item left-float"><a class="nav-link" href="#">我有车辆</a></li>
            <li class="item left-float"><a class="nav-link" href="#">以租代购</a></li>
            <li class="item left-float"><a class="nav-link" href="#">门店</a></li>

            <!--未登录-->
            <c:if test="${user==null}">
            <li class="item right-float">
                <a class="nav-link regist-link" href="${pageContext.request.contextPath }/toRegist">注册</a><span class="slash-text">/</span><a class="nav-link login-link" href="${pageContext.request.contextPath }/user/toLogin">登录</a>
            </li>
            </c:if>
            <!--已登录-->
            <c:if test="${user!=null}">
            <li class="item right-float"><a class="nav-link mycargo-link" href="${pageContext.request.contextPath }/usr/toPcenter">我的Cargo</a></li>
            <li class="item right-float"><span class="hello-text">欢迎您，${user.name}</span></li>
            </c:if>
            <!--已登录-->

        </ul>
    </div>
</div>
</body>
</html>