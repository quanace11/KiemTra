<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<title>Trang Chủ</title>
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

	
    <table width="85%" align="center" border = "1">
   <tr>
   		<td valign="top" width="300" style="text-align">
			<table class="table table-hover" >
                 <c:forEach items="${dsLoai}" var ="loai">
                 	<tr>
                 		<td style="padding: 22px 20px;">
                 			<a href="trangchu?ml=${loai.getMaLoai()}">
                           		${loai.getTenLoai()}
                    		</a>
                  		</td>
                  	</tr>
                  </c:forEach>
  			 </table>
   		</td>
   		<td>
   			<table class="table table-hover" style = "padding : 10px" border = "1">
   				<c:forEach items= "${cBean}" var = "c">
   					<tr>
   						<td>
   							<div class="product-ad" style="display: flex;border: 2px solid green;border-radius: 12px;">
   									<div class="img-adm" style="flex-shrink: 0;">
		   							 <img src="${c.getAnh()}" style="width: 257px;height: 300px;border-radius: 30px;"/>
		   							</div>
		   							<div style="flex:1;margin-top: 8%;margin-left: 48px;font-size: 21px;">
		   								<c:out value= "Ma cay    : ${c.getMacay()}"></c:out> <br>
		   								<c:out value= "Ten cay   :${c.getTencay()}"></c:out> <br>
		   								<c:out value= "So luong  : ${c.getSoluong()}"></c:out> <br>
		   								<c:out value= "${c.getNgayNhap()}"></c:out> <br>
		   								<c:out value= "Gia       :${c.getGia()}"></c:out> <br>
		   							</div>
		   							
		   							<a style="border-radius: 9px;font-size: 14px;" class= "btn btn-danger btn-sm" href = "delete?ms=${c.getMacay()}">Delete</a> 
   							</div>  		
   						</td>
  					</tr>
   				</c:forEach>
   					
   			</table>
   		</td>
   		<td valign="top" width="150">
   			<div style="    padding: 0 10px;">
	       		<form action="trangchu" method="post">
	       			<input type= "text" name = "txtname" style= "margin-top: 20px"><br>
	       				
	       			<input type= "submit" value = "Tìm Kiếm"  style= "margin-top: 10px;" >
	       		</form>
       		</div>
       	</td>
   				
   		
   </tr>
    </table>
 
</body>
</html>