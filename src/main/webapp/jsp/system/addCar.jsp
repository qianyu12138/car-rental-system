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
	<title>增加车辆</title>
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
	<form action="<c:url value='addCar'/>" method="post" enctype="multipart/form-data">
		<tr>
			<td>车辆名称：</td>
			<td><input type="text" name="cname"  /></td>
		</tr>
		<tr>
			<td>车辆图片：</td>
			<td>
				<input type="file"  name="carimg1" onchange="html5Reader(this,'carimg1')" class="content-file col-lg-3"  placeholder="未完待续">
				<img  hidden  class=" col-lg-offset-2 " id="carimg1" src="" width="130px" height="80px" >
				<input type="file"  name="carimg2" onchange="html5Reader(this,'carimg2')" class="content-file col-lg-3"  placeholder="未完待续">
				<img  hidden  class=" col-lg-offset-2 " id="carimg2" src="" width="130px" height="80px" >
				<input type="file"  name="carimg3" onchange="html5Reader(this,'carimg3')" class="content-file col-lg-3"  placeholder="未完待续">
				<img  hidden  class=" col-lg-offset-2 " id="carimg3" src="" width="130px" height="80px" >
			</td>
		</tr>
		<tr>
			<td>品牌：</td>
			<td><select name="kid">
                <option value="">--请选择--</option>
				<c:forEach items="${kinds }" var="k">
					<option   value="${k.kid}">
							${k.kname }
					</option>
				</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td>车型</td>
			<td><input type="text" name="cdesc"  /></td>
		</tr>
		<tr>
			<td>每日单价</td>
			<td><input type="text" name="price" /></td>
		</tr>
		<tr>
			<td>车牌号</td>
			<td><input type="text" name="licensenumber" /></td>
		</tr>
		<tr>
			<td>座位数</td>
			<td><input type="text" name="sitnumber"  /></td>
		</tr>
		<tr>
			<td>排量</td>
			<td><input type="text" name="displacement"  /></td>
		</tr>
		<tr>
			<td>是否有导航仪</td>
			<td><input type="radio" name="navigator"value="1" checked=true  />是<input type="radio"value="0" name="navigator"  />否</td>

		<tr>
			<td>油箱</td>
			<td><input type="text" name="tankcapacity"  /></td>
		</tr>
		<tr>
			<td>是否自动挡</td>
			<td><input type="radio" name="automatic" value="1" checked=true  />是<input type="radio" name="automatic"value="0" />否</td>
		</tr>
		<tr>
			<td>是否有天窗</td>
			<td><input type="radio" name="skylight" checked=true value="1"  />是<input type="radio" name="skylight" value="0" />否</td>
		</tr>
		<tr>
			<td>押金</td>
			<td><input type="text" name="deposit"  /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="reset" name="reset" value="重置" />
				<input type="submit" name="submit" value="保存"  />
			</td>
		</tr>
	</form>
</table>
</body>
</html>