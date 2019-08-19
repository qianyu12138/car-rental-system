<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>完善账户</title>
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap-theme.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/jquery.raty.css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/common.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/carList.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/improveAccount.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/order.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/user/improveAccount.js"></script>
</head>
<body>
<!--头部-->
<div class="header-box"></div>
<script>
    $(".header-box").load("${pageContext.request.contextPath}/jsp/common/public-header.jsp");
</script>

<!-- 用户中心头部 -->
<div class="top-box"></div>
<script>
    $(".top-box").load("${pageContext.request.contextPath}/jsp/common/userTopNav.jsp");
</script>


<div class="main-content">
    <div class="public-container clearfloat">
        <!-- 左边导航 -->
        <div class="left-box"></div>
        <script>
            $(".left-box").load("${pageContext.request.contextPath}/jsp/common/userLeftNav.jsp");
        </script>

        <!-- 右边内容 -->
        <div class="right-content left-float">
            <dl>
                <table>

                    <dt class="content-title "><a class="btn-info btn-lg  " href="${pageContext.request.contextPath}/user/findOrderList/">全部</a>
                        <a class="btn-info btn-lg  " href="${pageContext.request.contextPath}/user/findOrderList/"/>租赁中</a>
                        <a class="btn-info  btn-lg " href="${pageContext.request.contextPath}/user/findOrderList/">已完成</a>
                        <a class="btn-info  btn-lg  " href="${pageContext.request.contextPath}/user/findOrderList/">等待付款</a></dt>
                    <tr class="tableth">

                        <th class="col-lg-6">订单信息</th>
                        <th class="col-lg-3">取还信息</th>
                        <th class="col-lg-2">总计</th>
                        <th class="col-lg-2">状态</th>

                    </tr>
                    <c:forEach items="leases" var="lease">
                    <tr class="tabletr">
                        <td>
                            <img class="img left-float" src="${pageContext.request.contextPath}/images/car-1.jpg"><br>
                            <span> <strong></strong></span>
                            <br><span class="decs">三厢/1.5自动 | 乘坐5人</span>
                            <br><span class="decs">订单号：15661147068763</span></br>
                        </td>
                        <td>
                            <br><br>
                            <span>天津 - 滨海机场店</span><br>
                            <span class="decs">2019-08-19 10:00</span><br>
                            <span>天津 - 滨海机场店</span><br>
                            <span class="decs">2019-08-21 10:00</span><br>
                            <br>
                            <br>
                        </td>
                        <td>
                            <span class="price">318元</span>
                        </td>
                        <td>
                            <span class="decs status">已完成</span><br>
                            <a href="#" class="btn-md btn-link">查看详情</a>
                        </td>
                    </tr>
                    </c:forEach>

                </table>
            </dl>


        </div>
    </div>
</div>

<!--尾部-->
<div class="footer-box"></div>
<script>
    $(".footer-box").load("${pageContext.request.contextPath}/jsp/common/public-footer.jsp");
</script>
</body>
</html>