<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>租户列表</title>

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
    <table class="easyui-datagrid dg" width="100%" height="100%"
           toolbar=".toolbar" rownumbers="true" fitColumns="false" singleSelect="true">
        <thead>
        <tr>
            <th field="id" width="100">用户编号</th>
            <th field="photo" width="70">用户头像</th>
            <th field="phone" width="150">联系电话</th>
            <th field="username" width="150">用户名</th>
            <th field="email" width="150">邮箱</th>
            <th field="status" width="150">账户状态</th>
            <th field="operate" width="300">操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td><a href="../../images/choice-1.png" target="_blank"><img src="../../images/choice-1.png" style="width: 30px; height: 30px;"></a></td>
            <td>13432825705</td>
            <td>cblstc</td>
            <td>13432825705@163.com</td>
            <td>已启用</td>
            <td>
                <a href="javascript:void(0)" onclick="showInfo();" class="easyui-linkbutton" iconCls="icon-search" plain="true">认证信息</a>
                <a href="javascript:void(0)" onclick="showCar();" class="easyui-linkbutton" iconCls="icon-tip" plain="true">车辆信息</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true">通过</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-no" plain="true">退审</a>
            </td>
        </tr>
        </tbody>
    </table>
    <div class="toolbar" style="padding: 20px; position: relative;">
        <img src="../../images/system/username.png"> <input class="username" placeholder="用户名查询">&nbsp;&nbsp;
        <img src="../../images/system/phone.png"> <input class="username" placeholder="联系电话查询">&nbsp;&nbsp;
        <img src="../../images/system/email.png"> <input class="username" placeholder="邮箱查询">&nbsp;&nbsp;
        <input type="submit" value="查询" style="background:#0089dc; color: #fff; border: 0; border-radius: 3%;">
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
                    '<div class="content-text"><em>姓名：</em>陈龙</div>' +
                    '<div class="content-text"><em>性别：</em>男</div>' +
                    '<div class="content-text"><em>身份证正面：</em></div>' +
                    '<a href="../../images/system/idcard_sample.jpg" target="_blank"><img class="content-img" src="../../images/system/idcard_sample.jpg"></a>' +
                    '<div class="content-text"><em>驾驶证正面：</em></div>' +
                    '<a href="../../images/system/driver-sample.png" target="_blank"><img class="content-img" src="../../images/system/driver-sample.png"></a>' +
                    '<div class="content-text"><em>驾驶证副页：</em></div>' +
                    '<a href="../../images/system/vice-sample.png" target="_blank"><img class="content-img" src="../../images/system/vice-sample.png"></a>' +
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
                    '<div class="content-text"><em>品牌：</em>法拉利</div>' +
                    '<div class="content-text"><em>型号：</em>488</div>' +
                    '<div class="content-text"><em>配置：</em>顶配版</div>' +
                    '<div class="content-text"><em>车牌号：</em>京A00000</div>' +
                    '<div class="content-text"><em>年代：</em>2015款</div>' +
                    '<div class="content-text"><em>图片：</em></div>' +
                    '<a href="../../images/system/488-1.jpg" class="img-big-link" target="_blank"><img class="content-img img-big" src="../../images/system/488-1.jpg"></a>' +
                    '<div class="clearfloat">' +
                        '<a href="javascript:void(0)" onclick="changeImg(this);" class="content-img-small-link left-float"><img class="content-img-small" src="../../images/system/488-1.jpg"></a>' +
                        '<a href="javascript:void(0)" onclick="changeImg(this);" class="content-img-small-link left-float"><img class="content-img-small" src="../../images/system/488-2.jpg"></a>' +
                        '<a href="javascript:void(0)" onclick="changeImg(this);" class="content-img-small-link left-float"><img class="content-img-small" src="../../images/system/488-3.jpg"></a>' +
                        '<a href="javascript:void(0)" onclick="changeImg(this);" class="content-img-small-link left-float"><img class="content-img-small" src="../../images/system/488-4.jpg"></a>' +
                    '</div>' +
                    '<div class="content-text"><em>变速箱：</em>自动挡</div>' +
                    '<div class="content-text"><em>排量：</em>10L</div>' +
                    '<div class="content-text"><em>导航仪：</em>有</div>' +
                    '<div class="content-text"><em>倒车雷达：</em>有</div>' +
                    '<div class="content-text"><em>驱动模式：</em>四驱</div>' +
                    '<div class="content-text"><em>里程：</em>4000km</div>' +
                    '<div class="content-text"><em>载客量：</em>4人</div>' +
                    '<div class="content-text"><em>油箱：</em>40</div>' +
                    '<div class="content-text"><em>详情：</em>法拉利是一款好车，不懂车的勿扰法拉利是一款好车，不懂车的勿扰法拉利是一款好车，不懂车的勿扰法拉利是一款好车，不懂车的勿扰法拉利是一款好车，不懂车的勿扰法拉利是一款好车，不懂车的勿扰</div>' +
                    '<div class="content-text"><em>价格：</em>10000/天</div>' +
                    '<div class="content-text"><em>押金：</em>1000</div>' +
                    '</div>'
                });
            }
        }

        /**
         * 轮播改变图片
         * @param link 图片链接
         */
        function changeImg(link) {
            var img = $(link).find("img").get(0);
            $(".content-img-small").css("border", "0");
            $(img).css("border", "1px solid #c0c0c0");

            $(".img-big").attr("src", $(img).attr("src"));
            $(".img-big-link").attr("href", $(img).attr("src"));
        }
    </script>
</body>
</html>