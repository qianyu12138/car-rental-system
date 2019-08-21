<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>租借申请</title>
    <link rel="stylesheet" type="text/css" href="../../css/common/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../css/common/bootstrap-theme.min.css">
    <link rel="stylesheet" href="../../css/themes/default/easyui.css" type="text/css">
    <link rel="stylesheet" href="../../css/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="../../css/system/userList.css" type="text/css">
    <link rel="stylesheet"type="text/css" href="../../css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="../../css/common/common.css">
    <script type="text/javascript" src="../../js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../../js/layer/layer.js"></script>
    <script type="text/javascript" src="../../js/common/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../../js/common/easyui-loading.js"></script>
    <style>
    </style>
</head>
<body>
<table  class="easyui-datagrid dg" width="100%" height="100%"
       toolbar=".toolbar" rownumbers="true" fitColumns="false" singleSelect="true">
    <thead>
    <tr>
        <th field="lid" width="60">订单编号</th>
        <th field="uid" width="60">用户编号</th>
        <th field="username"width="100">用户名</th>
        <th field="createtime" width="80">租借时间</th>
        <th field="returntime" width="80">归还时间</th>
        <th field="phone" width="80">联系电话</th>
        <th field="receiveaddress" width="150">配送地址</th>
        <th field="information" width="80">认证信息</th>
        <th field="carinformation" width="80">车辆信息</th>
        <th field="operate" width="120">操作</th>

    </tr>
    </thead>
    <tbody>
    <tr>


        <c:forEach items="${pageBean.resultList}" var="lease">
            <c:if test="${lease.lease.state==1}">
            <td>${lease.lease.lid}</td>
            <td>${lease.user.uid}</td>
            <td>${lease.user.name}</td>
            <td>${lease.lease.createtime}</td>
            <td>${lease.lease.returntime}</td>
            <td>${lease.lease.contactphone}</td>
            <td>${lease.lease.receiveaddress}</td>
            <td><a href="javascript:void(0)" onclick="showInfo();" class="easyui-linkbutton" iconCls="icon-search" plain="true">认证信息</a></td>
            <td><a href="javascript:void(0)" onclick="showCar();" class="easyui-linkbutton" iconCls="icon-tip" plain="true">车辆信息</a></td>
            <td>
                <a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true"onclick="pass()">通过</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-no" plain="true"onclick="impass()">退审</a>
            </td>
            </c:if>
        </c:forEach>

    </tr>
    </tbody>
</table>
<div class="toolbar" style="padding: 20px; position: relative;">
    <img src="../../images/system/username.png"> <input class="username" placeholder="用户名查询">&nbsp;&nbsp;
    <input type="submit" value="查询" onclick="select1()" style="background:#fff; color:#0089dc; border: 0; border-radius: 10%;font-size: 15px;">
    <img src="../../images/system/phone.png"> <input class="username" placeholder="联系电话查询">&nbsp;&nbsp;
    <input type="submit" value="查询" onclick="select2()" style="background:#fff; color:#0089dc; border: 0; border-radius: 10%;font-size: 15px;">
    <img src="../../images/system/username.png"> <input class="username" placeholder="用户编号查询">&nbsp;&nbsp;
    <input type="submit" value="查询"onclick="select3()" style="background:#fff; color:#0089dc; border: 0; border-radius: 10%;font-size: 15px;">
</div>
<div class="easyui-dialog dlg" style="width:500px;height:260px;padding:10px 20px;"
     closed="true" buttons="#dlg-buttons" pagination="true">
</div>

<script>
    /**
     * 查看认证信息
     */
    function showInfo() {
        var row = $(".dg").datagrid("getSelected");
        if (row) {
            layer.open({
                title: '认证信息',
                type: 1,
                closeBtn: 1,  // 调试用
                area: ['600px', '400px'], //宽高
                content: '<div class="info-content">' +
                    '<div class="content-text"><em>姓名：</em>${lease.user.name}</div>' +
                    '<div class="content-text"><em>身份证：</em></div>' +
                    '<a href="${idCard1}" target="_blank"><img class="content-img"  id="idCard1" src="${idCard1}" "></a>' +
                    '<a href="${idCard12}" target="_blank"><img class="content-img"  id="idCard2" src="${idCard2}" "></a>' +
                    '<div class="content-text"><em>驾驶证：</em></div>' +
                    '<a href="${driverCard1}" target="_blank"><img class="content-img" id="driverCar1" src="${driverCard1}"></a>' +
                    '<a href="${driverCard2}" target="_blank"><img class="content-img" id="driverCar2" src="${driverCard2}"></a>' +
                    '</div>'
            });
        }
    }

    /**
     * 显示车辆信息
     */
    function showCar() {
        var row = $(".dg").datagrid("getSelected");
        if (row) {
            layer.open({
                title: '车辆信息',
                type: 1,
                closeBtn: 1,  // 调试用
                area: ['600px', '400px'], //宽高
                content: '<div class="info-content">' +
                    '<div class="content-text"><em>品牌：</em>${lease.car.name}</div>' +
                    '<div class="content-text"><em>型号：</em>${lease.car.kind}</div>' +
                    '<div class="content-text"><em>车牌号：</em>${lease.car.licenseNumber}</div>'+
                    '<div class="content-text"><em> 座位数：</em>${lease.car.sitnumber}</div>'+
                    '<div class="content-text"><em>排量：</em>${lease.car.displacement}T</div>' +
                    '<div class="content-text"><em>油箱：</em>${lease.car.tankcapacity}</div>' +
                    '<div class="content-text"><em>图片：</em></div>' +
                    '<a href="${pageContext.request.contextPath}/${img}" class="img-big-link" target="_blank"><img class="content-img img-big" src="${pageContext.request.contextPath}/${img}"></a>' +
                    '<div class="clearfloat">' +
                    '<a href="javascript:void(0)" onclick="changeImg(this);" class="content-img-small-link left-float"><img class="content-img-small" src="../../images/car-show-1.jpg"></a>' +
                    '<a href="javascript:void(0)" onclick="changeImg(this);" class="content-img-small-link left-float"><img class="content-img-small" src="../../images/car-show-2.jpg"></a>' +
                    '<a href="javascript:void(0)" onclick="changeImg(this);" class="content-img-small-link left-float"><img class="content-img-small" src="../../images/car-show-3.jpg"></a>' +
                    '<a href="javascript:void(0)" onclick="changeImg(this);" class="content-img-small-link left-float"><img class="content-img-small" src="../../images/car-show-4.jpg"></a>' +
                    '</div>' +
                    '<div class="content-text"><em>油箱：</em>${lease.car.tankcapacity}</div>' +
                    '<div class="content-text"><em>变速箱：</em>${lease.car.automatic==1?'自动':'手动'}</div>' +
                    '<div class="content-text"><em> 天窗：</em>${lease.car.skylight==1?'有':'无'}</div>' +
                    '<div class="content-text"><em> 导航仪：</em>${lease.car.navigator==1?'有':'无'}</div>' +
                    '<div class="content-text"><em>详情：</em>${lease.car.desc}</div>' +
                    '<div class="content-text"><em>价格：</em>${lease.car.price}</div>' +
                    '<div class="content-text"><em>押金：</em>${lease.car.deposit}</div>' +
                    '</div>'
            });
        }
    }

    /**
       */
    function changeImg(link) {
        var img = $(link).find("img").get(0);
        $(".content-img-small").css("border", "0");
        $(img).css("border", "1px solid #c0c0c0");

        $(".img-big").attr("src", $(img).attr("src"));
        $(".img-big-link").attr("href", $(img).attr("src"));
    }
    function pass() {
        //get uid   change state;刷新界面重新读取
        ${lease.lease.state}=3;
    }
    function impass() {
        ${lease.lease.state}=5;
        //get uid    change state;刷新界面重新读取
    }
    function select1() {

    }
    function select2() {

    }
    function select3() {

    }
</script>
</body>
</html>