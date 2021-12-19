<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đơn hàng đã bán</title>
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
		<h1>LỊCH SỬ BÁN</h1>
	</div>
	<c:choose>
		<c:when test="${lsmhdm.size() >0 }">
				<div style="margin: 30px 200px;">
				<c:forEach items = "${lsmhdm}" var = "lsmh">
				<div class="list-historys" style="display: flex;flex-direction: row;align-items: center;border:2px solid green;margin-bottom:30px;}">
					<div class="list-image" style="flex-shrink:0">
						<img src="${lsmh.getAnh()}" style="width: 274px;boder-radius:5px; height: 300px;"> <br>
					</div>
					<div class="list-info-confirm" style="flex:1;display:flex">
						<div class="lsit-info" style="flex-shrink:0;font-size:25px;margin-left:6%;width: 30%;">
							Tên sách: ${lsmh.getTencay() } <br>				
							Giá: ${lsmh.getGia() } <br>
							Số lượng : ${lsmh.getSoluongMua()} <br>
							<br>
						</div>
						
					</div >	
				</div>
				</c:forEach>
				</div>
		</c:when>

	</c:choose>
	

</body>
</html> 