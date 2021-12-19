<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<title>Thêm cây</title>
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
	<div class="form-add">
		<form method="post" action="add" enctype= "multipart/form-data" style ="margin-left:50px; margin-top: 50px">
	  	Mã cây : <input type="text" name="txtmasach" value="${sachbeanadmin.maSach}"> <br>
	  Tên cây: <input type="text" name="txttensach" value="${sachbeanadmin.tenSach}"> <br>
	  Giá: <input type="number" name="txtgia" value="${sachbeanadmin.gia}"> <br>
	  Số lượng: <input type="number" name="txtsoluong" value="${sachbeanadmin.soLuong}"> <br>
	  Mã loại: <input type="text" name="txtmaloai" value="${sachbeanadmin.maLoai}"> <br>
	  Ngày nhập:<input type="date" name="txtngay" value=""><br>
	  File ảnh:   	
  		<input type="file" name="txtfile" value = "${sachbeanadmin.anh }"><br>
  		<input type="submit"> 
	  
  </form> 	
	</div>
	
	

</body>
</html>