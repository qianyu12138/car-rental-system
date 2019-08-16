<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>选车列表</title>
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap-theme.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/jquery.raty.css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/common.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/carList.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=HHNwksT3c9XuGE9iwPrL0LLgSF0KzQsg"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery.raty.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/carList.js"></script>
</head>
<body>
<div class="header-box"></div>
<script>
    $(".header-box").load("${pageContext.request.contextPath}/jsp/common/public-header.jsp");
</script>
<form id="form" action="<c:url value='${pageContext.request.contextPath}/'/>" method="post" ></form>
<div class="address-date-choice">
    <div class="public-container clearfloat">
        <div class="choice-address left-float">
            <div class="choice-address-block">
                <span class="address-text get-address-text">取车</span><!--
                --><input value="${deliveryAddress}" form="form" class="address-choice" placeholder="请输入送车上门地址">
                <p class="switch-text get-car-text">送车上门</p><!--
                    --><a href="javascript:void(0)" onclick="switchChange(this);"><img src="${pageContext.request.contextPath}/images/switch-on.png" alt="switch-on"></a>
            </div>
            <div class="choice-address-block">
                <span class="address-text return-address-text">还车</span><!--
                --><input value="${pickUpAddress}" form="form" class="address-choice" placeholder="请输入上门取车地址">
                <p class="switch-text return-car-text">上门取车</p><!--
                    --><a href="javascript:void(0)" onclick="switchChange(this);"><img class="switch-img" src="${pageContext.request.contextPath}/images/switch-on.png" alt="switch-on"></a>
            </div>
        </div>
        <img class="left-float car-to-img" src="${pageContext.request.contextPath}/images/car-to.jpg">
        <div class="choice-date left-float">
            <div class="choice-date-block"><span class="date-text">取车时间</span><!--
                --><input readonly value="${startTime}" form="form" placeholder="请选择开始日期" class="date-choice" type="text"></div>
            <div class="choice-date-block"><span class="date-text">还车时间</span><!--
                --><input readonly value="${endTime}" form="form" placeholder="请选择结束日期" class="date-choice" type="text"></div>
        </div>
        <img class="date-to-img left-float" src="${pageContext.request.contextPath}/images/dateToV.png" alt="至">
        <div class="choice-submit clearfloat">
            <p class="rent-time">租期：<span class="red-text">2天</span>，不限里程</p>
            <input type="submit" form="form" class="choice-btn" value="立即选车">
        </div>
    </div>
</div>

<!--中间的选车部分-->
<div class="car-select">
    <div class="public-container clearfloat">
        <div class="car-filter left-float">
            <div class="car-price">
                <p class="price-title">价格<span class="grey-text size14">(元)</span></p>
                <div class="price-line">
                    <a href="javascript:void(0)" onclick="selectPrice(this, '.price-no-filter', '');"><div class="price-line-common price-line-1"></div></a><!--
                        --><a href="javascript:void(0)" onclick="selectPrice(this, '.price-0', '.price-150');"><div class="price-line-common price-line-2"></div></a><!--
                        --><a href="javascript:void(0)" onclick="selectPrice(this, '.price-150', '.price-300');"><div class="price-line-common price-line-3"></div></a><!--
                        --><a href="javascript:void(0)" onclick="selectPrice(this, '.price-350', '.price-500');"><div class="price-line-common price-line-4"></div></a><!--
                        --><a href="javascript:void(0)" onclick="selectPrice(this, '.price-500-plus', '');"><div class="price-line-common price-line-5"></div></a><!--
                        -->
                </div>
                <p class="price-text"><span class="orange-text price-no-filter size14">不限</span>&nbsp;<!--
                    --><span class="price-0">0</span>&nbsp;&nbsp;<!--
                        --><span class="price-150">150</span>&nbsp;&nbsp;<!--
                        --><span class="price-300">300</span>&nbsp;&nbsp;<!--
                        --><span class="price-500">500</span>&nbsp;&nbsp;<!--x
                        --><span class="price-500-plus">500+</span><!--
                        --></p>
            </div>
            <div class="car-brand">
                <p class="brand-title">品牌</p>
                <div class="brand-content">
                    <a href="javascript:void(0)" onclick="selectBrand(this);"><p class="brand-name-common brand-name-specify">不限</p></a><!--
                        --><a href="javascript:void(0)" onclick="selectBrand(this);"><p class="brand-name-common">大众</p></a><!--
                        --><a href="javascript:void(0)" onclick="selectBrand(this);"><p class="brand-name-common">比亚迪</p></a><!--
                        --><a href="javascript:void(0)" onclick="selectBrand(this);"><p class="brand-name-common">丰田</p></a><!--
                        --><a href="javascript:void(0)" onclick="selectBrand(this);"><p class="brand-name-common">马自达</p></a><!--
                        --><a href="javascript:void(0)" onclick="selectBrand(this);"><p class="brand-name-common">斯巴鲁</p></a><!--
                        --><a href="javascript:void(0)" onclick="selectBrand(this);"><p class="brand-name-common">长安</p></a><!--
                        --><a href="javascript:void(0)" onclick="selectBrand(this);"><p class="brand-name-common">本田</p></a><!--
                        --><a href="javascript:void(0)" onclick="selectBrand(this);"><p class="brand-name-common">日产</p></a><!--
                        --><a href="javascript:void(0)" onclick="selectBrand(this);"><p class="brand-name-common">保时捷</p></a><!--
                        --><a href="javascript:void(0)" onclick="selectBrand(this);"><p class="brand-name-common">大众</p></a><!--
                        -->
                </div>
            </div>
            <div class="car-store">
                <p class="store-name">武汉天河机场店</p>
                <div id="store-map" class="store-map"></div>
                <div class="store-desc">
                    <dl>
                        <dt class="store-title">门店地址：</dt>
                        <dd class="store-content">T3航站楼国内到达二楼7号出口左面柜台</dd>
                        <dt class="store-title">营业时间：</dt>
                        <dd class="store-content">09:00-21:00</dd>
                        <dt class="store-title">门店电话：</dt>
                        <dd class="store-content">13432825705</dd>
                        <dt class="store-title">客户评价：</dt>
                        <dd class="store-content clearfloat"><div class="comment-star left-float"></div>&nbsp;<span class="orange-text">3.0</span><a href="#" class="total-comment right-float">3000000条评论&gt;</a></dd>
                    </dl>
                </div>
            </div>
        </div>

        <div class="car-content left-float">
            <div class="single-car clearfloat">
                <img class="car-img left-float" src="${pageContext.request.contextPath}/images/car-1.jpg">
                <dl class="car-desc-box left-float">
                    <dt class="car-name">别克英朗</dt>
                    <dd class="car-desc">三厢|1.5自动|5人</dd>
                    <dd class="car-gear-auto">自动挡</dd>
                    <dd class="car-gear">手动挡</dd>
                </dl>
                <div class="car-price-box left-float">
                    <span class="car-price-text">&yen;83</span><span class="day-avg">/日均</span>
                </div>
                <div class="choice-btn-box left-float">
                    <button class="choice-btn">租&nbsp;车</button>
                </div>
            </div>
            <div class="single-car clearfloat">
                <img class="car-img left-float" src="${pageContext.request.contextPath}/images/car-1.jpg">
                <dl class="car-desc-box left-float">
                    <dt class="car-name">别克英朗</dt>
                    <dd class="car-desc">三厢|1.5自动|5人</dd>
                    <dd class="car-gear-auto">自动挡</dd>
                    <dd class="car-gear">手动挡</dd>
                </dl>
                <div class="car-price-box left-float">
                    <span class="car-price-text">&yen;83</span><span class="day-avg">/日均</span>
                </div>
                <div class="choice-btn-box left-float">
                    <button class="choice-btn">租&nbsp;车</button>
                </div>
            </div>
            <div class="single-car clearfloat">
                <img class="car-img left-float" src="${pageContext.request.contextPath}/images/car-1.jpg">
                <dl class="car-desc-box left-float">
                    <dt class="car-name">别克英朗</dt>
                    <dd class="car-desc">三厢|1.5自动|5人</dd>
                    <dd class="car-gear-auto">自动挡</dd>
                    <dd class="car-gear">手动挡</dd>
                </dl>
                <div class="car-price-box left-float">
                    <span class="car-price-text">&yen;83</span><span class="day-avg">/日均</span>
                </div>
                <div class="choice-btn-box left-float">
                    <button class="choice-btn">租&nbsp;车</button>
                </div>
            </div>
            <div class="single-car clearfloat">
                <img class="car-img left-float" src="${pageContext.request.contextPath}/images/car-1.jpg">
                <dl class="car-desc-box left-float">
                    <dt class="car-name">别克英朗</dt>
                    <dd class="car-desc">三厢|1.5自动|5人</dd>
                    <dd class="car-gear-auto">自动挡</dd>
                    <dd class="car-gear">手动挡</dd>
                </dl>
                <div class="car-price-box left-float">
                    <span class="car-price-text">&yen;83</span><span class="day-avg">/日均</span>
                </div>
                <div class="choice-btn-box left-float">
                    <button class="choice-btn">租&nbsp;车</button>
                </div>
            </div>
            <div class="single-car clearfloat">
                <img class="car-img left-float" src="${pageContext.request.contextPath}/images/car-1.jpg">
                <dl class="car-desc-box left-float">
                    <dt class="car-name">别克英朗</dt>
                    <dd class="car-desc">三厢|1.5自动|5人</dd>
                    <dd class="car-gear-auto">自动挡</dd>
                    <dd class="car-gear">手动挡</dd>
                </dl>
                <div class="car-price-box left-float">
                    <span class="car-price-text">&yen;83</span><span class="day-avg">/日均</span>
                </div>
                <div class="choice-btn-box left-float">
                    <button class="choice-btn">租&nbsp;车</button>
                </div>
            </div>
            <div class="single-car clearfloat">
                <img class="car-img left-float" src="${pageContext.request.contextPath}/images/car-1.jpg">
                <dl class="car-desc-box left-float">
                    <dt class="car-name">别克英朗</dt>
                    <dd class="car-desc">三厢|1.5自动|5人</dd>
                    <dd class="car-gear-auto">自动挡</dd>
                    <dd class="car-gear">手动挡</dd>
                </dl>
                <div class="car-price-box left-float">
                    <span class="car-price-text">&yen;83</span><span class="day-avg">/日均</span>
                </div>
                <div class="choice-btn-box left-float">
                    <button class="choice-btn">租&nbsp;车</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="footer-box"></div>
<script>
    $(".footer-box").load("${pageContext.request.contextPath}/jsp/common/public-footer.html");
</script>

<script>
    $(function() {
        $('.date-choice').datetimepicker({
            autoclose: true,
            startDate: new Date()
        });

        // 星星
        $('.comment-star').raty({
            starOn:'${pageContext.request.contextPath}/images/star-on.png',
            starOff:'${pageContext.request.contextPath}/images/star-off.png',
            halfShow: false,
            score:3,
            readOnly: false,
        });


        var map = new BMap.Map("store-map");
        var point = new BMap.Point(116.404, 39.915);  // 根据经纬度设置中心点:天安门
        map.centerAndZoom(point,12);  // 设置中心点和缩放级别，数字越大，显示的范围越小
        map.enableScrollWheelZoom();  // 支持滚轮缩放
        // map.addControl(new BMap.NavigationControl());  // 左上角添加平移缩放控件
        // map.addControl(new BMap.ScaleControl());  // 左下方显示比例
        // 根据地址在地图上显示
        var myGeo = new BMap.Geocoder();
        myGeo.getPoint("武汉天河机场", function(point) {
            if (point) {
                map.centerAndZoom(point, 17);
                map.addOverlay(new BMap.Marker(point));    // 标注
            }
        });
    });

</script>
</body>
</html>