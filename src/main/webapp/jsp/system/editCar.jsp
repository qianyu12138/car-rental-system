<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>车辆信息修改</title>
<style type="text/css">
body{
	font-size:12px;
}
table{
	width:80%;
	text-align:center;
	margin:auto;
}
table,td{
	border:1px solid #09F;
	border-collapse:collapse;
	padding:10px;
}
table#tab1{
	text-align:left;
	margin-bottom:10px;
}
</style>
</head>
<body>
<script type="text/javascript">
	function html5Reader(file,imgid) {

		var file = file.files[0];
		var imgid=imgid;
		var reader = new FileReader();
		reader.readAsDataURL(file);
		reader.onload = function(e){
			var pic = document.getElementById(imgid);
			pic.src=this.result;
			$("#"+imgid).show();
		}
	}


</script>
	<table id="tab1">
	<form action="<c:url value='editCar'/>?car_cid=${car.cid }" method="post" enctype="multipart/form-data">
		<input type="hidden" name="cid" value="${car.cid }" />
	   	<tr>
	   		<td>车辆名称：</td>
	       	<td><input type="text" name="cname" value="${car.cname }" /></td>
	    </tr>
		<tr>
			<td>车辆图片：</td>
			<td>
				<img    class=" " name="carimg1" src="${carimg1}" width="130px" height="80px" >
				<img   class="  " name="carimg2"src="${carimg2}" width="130px" height="80px" >
				<img  class="" name="carimg3" src="${carimg3}" width="130px" height="80px" >
				<br />
				点击修改第一张<input type="file"  name="carimg1" onchange="html5Reader(this,'carimg1')"   >
				<img  hidden  class=" col-lg-offset-2 " id="carimg1" src="" width="130px" height="80px" >
				点击修改第二张<input type="file"  name="carimg2" onchange="html5Reader(this,'carimg2')"  >
				<img  hidden  class=" col-lg-offset-2 " id="carimg2" src="" width="130px" height="80px" >
				<br/>
				点击修改第三张<input type="file"  name="carimg3" onchange="html5Reader(this,'carimg3')"  >
				<img  hidden  class=" col-lg-offset-2 " id="carimg3" src="" width="130px" height="80px" >
			</td>
		</tr>
	    <tr>
	   		<td>车型</td>
	       	<td><input type="text" name="cdesc" value="${car.cdesc }" /></td>
	    </tr>
		<tr>
			<td>每日单价</td>
			<td><input type="text" name="price" value="${car.price }" /></td>
		</tr>
		<tr>
			<td>车牌号</td>
			<td><input type="text" name="licensenumber" value="${car.licensenumber }" /></td>
		</tr>
		<tr>
			<td>座位数</td>
			<td><input type="text" name="sitnumber" value="${car.sitnumber}" /></td>
		</tr>
		<tr>
			<td>排量</td>
			<td><input type="text" name="displacement" value="${car.displacement }" /></td>
		</tr>
		<tr>
			<td>是否有导航仪</td>
			<td><c:if test="${car.navigator==1}"><input type="radio" name="navigator"value="1" checked=true  />是<input type="radio"value="0" name="navigator"  />否</c:if>
				<c:if test="${car.navigator==0}"><input type="radio" name="navigator" value="1" />是<input type="radio" name="navigator" value="0" checked=true />否</c:if></td>

		<tr>
			<td>油箱</td>
			<td><input type="text" name="tankcapacity" value="${car.tankcapacity }" /></td>
		</tr>
		<tr>
			<td>是否自动挡</td>
			<td><c:if test="${car.automatic==1}"><input type="radio" name="automatic" value="1" checked=true  />是<input type="radio" name="automatic"value="0" />否</c:if>
			<c:if test="${car.automatic==0}"><input type="radio" name="automatic" value="1 " />是<input type="radio" name="automatic"value="0" checked=true  />否</c:if></td>
		</tr>
		<tr>
			<td>是否有天窗</td>
			<td><c:if test="${car.skylight==1}"><input type="radio" name="skylight" checked=true value="1"  />是<input type="radio" name="skylight" value="0" />否</c:if>
			<c:if test="${car.skylight==0}"><input type="radio" name="skylight" value="1"  />是<input type="radio" name="skylight" value="0" checked=true />否</c:if></td>
		</tr>
		<tr>
			<td>押金</td>
			<td><input type="text" name="deposit" value="${car.deposit }" /></td>
		</tr>
	    <tr>  		
	       	<td colspan="2">
	       		<input type="reset" name="reset" value="重置" />
	       		<input type="submit" name="submit" value="更新"  />
	       	</td>
	    </tr>
	</form>
   	</table>
</body>
</html>
