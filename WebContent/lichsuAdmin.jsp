<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đơn hàng</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/thuviencss.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav ">
				<li><a href="trangchu">Trang chủ</a></li>
				<li><a href="lichsuadmin">Lịch sử khách hàng đặt mua</a></li>
				<li><a href="damuaAdmin" >Lịch sử khách hàng đã bán</a></li>
				<li><a href="add" >Add</a></li>
			</ul>
		</div>
	</nav>
	<div
		style="cursor: pointer; width: auto; border-bottom: #d6d6d6 1px dotted;margin-left: 200px;color: green;">
		<h1>LỊCH SỬ KHÁCH MUA</h1>
	</div>
	<c:choose>
		<c:when test="${lsmh.size() >0 }">
				<div class="main-history" style="margin: 30px 200px;">
				<c:forEach items = "${lsmh}" var = "lsmh">
				<div class="list-historys" style="display: flex;flex-direction: row;align-items: center;border:2px solid green;margin-bottom:30px;}">
					<div class="list-image" style="flex-shrink:0">
						<img src="${lsmh.getAnh()}" style="width: 274px; height: 300px;margin-bottom: -4px;"> <br>
					</div>
					<div class="list-info-confirm" style="flex:1;display:flex">
						<div class="lsit-info" style="flex-shrink:0;font-size:25px;margin-left:6%;width: 30%;">
							Tên sách: ${lsmh.getTencay() } <br>				
							Giá: ${lsmh.getGia() } <br>
							Số lượng : ${lsmh.getSoluongMua()} <br>
							<br>
						</div>
						<div class="confirm" style="flex:1">
							<a class = "btn btn-danger btn-sm"  name = "xacnhan" href = "xacnhanAdmin?mct=${lsmh.getMaCTHD()}" style = " margin-left : 67%;color: #fff;background-color: #d9534f;padding: 5px 10px;border-color: #d43f3a;font-size: 18px;line-height: 1.5;border-radius: 3px;text-decoration: none;"> Xác nhận</a>
						</div>
					</div >	
				</div>
				
				</c:forEach>
				<a class = "btn btn-danger btn-sm"  name = "xacnhanall" href = "xacnhanAdmin?xacnhanall=hehe" style = " margin-left : 82%;color: #fff;background-color: #d9534f;padding: 5px 10px;border-color: #d43f3a;font-size: 18px;line-height: 1.5;border-radius: 3px;text-decoration: none;"> Xác nhận tất cả</a>
				</div>
		</c:when>
		<c:otherwise>
			<div style= "margin-top: 200px; margin-left: 200px">
			
				<h1 style= "margin-left:400px;"> Không có khách hàng nào đặt mua</h1>
			</div>
		</c:otherwise>
	</c:choose>
	

</body>
</html> 