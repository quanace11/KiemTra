<%@page import="bean.LichSuBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="bean.KhachHangBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>The Caxavina</title>
   
    <link rel="stylesheet" href="stle.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

      
<style>
    
    
</style>
<body>
	<%
	    response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("utf-8");
	%>
    <div id="main">
        <div id="header">
            <a style="display: inline-block;position: absolute;" href=""><img style="height: 66px;display: block;" src="assets/logo-caxavina-01.jpg" alt=""></a>
            <ul style="margin-left: 66px;" id="nav">
                <li><a href="HtcayController">TRANG CHỦ</a></li>
                <li><a href="">SẢN PHẨM</a>
                    <ul class="subnav">
                        <li><a href="HtcayController?ml=deban">Cây để bàn</a></li>
                        <li><a href="HtcayController?ml=phongthuy">Cây phong thủy</a></li>
                        <li><a href="HtcayController?ml=treocua">Cây treo cửa</a></li>
                        <li><a href="HtcayController?ml=vanphonglon">Cây văn phòng lớn</a></li>
                    </ul>
                </li>
                <li><a href="">LIÊN HỆ</a></li>
                <li><a style="" href="">BLOG</a></li>
                
                
            </ul>
            
            <div class="search-btn" >
                <ul >
                	<li> 
                    	<form  action="HtcayController" method="post">
                       	 	<input type="text" name="txtfind" style="width: 150px;">
                        	<input class="find" type="submit" value="Tìm kiếm">
                    	</form> 
               		</li>
                	<li>
                		<a href="giohang.jsp">Giỏ Hàng</a>
                	</li>
                	<%if(request.getParameter("dangxuat")!= null)
                	{
                		session.setAttribute("khachhang",null);
                	}
                	KhachHangBean khachhang=(KhachHangBean)session.getAttribute("khachhang");
                	if(khachhang != null)
                	{%>
                	
                    <li>
                    	<a><i>Xin chào: <%=khachhang.getHoten()%></i></a>
                    	
                    	<ul class="subnav-1" >
                        	<li><a href="">Lịch sử mua hàng</a></li>
                        	<li><a href="HtcayController?dangxuat=oke"">Đăng xuất</a></li>
                      
                    	</ul>
                    <%} %>
                	
                </ul>

               
            </div>
        </div>

	<%	DecimalFormat formatter = new DecimalFormat("###,###,###");
		ArrayList<LichSuBean> list = null;
		if(request.getAttribute("lichsumua")!=null){
			list =(ArrayList<LichSuBean>) request.getAttribute("lichsumua");
		}
	%>
	<div id="main-historys" style="margin-top: 8%; margin-left: 90px;margin-right:90px;overflow:hidden">
              	  <div class="content-history">
                      <h2 style="color: black;text-align: center; margin-bottom: 100px;">Lịch sử mua hàng</h2>
                  </div>
                  
                   <%if(list != null) { %>
                   <%for(LichSuBean h : list) {%>
                   <% Long idhoadon = h.getMaHD(); %><div class="product-list" style="border-top: 2px solid blue;">
                   <h4 style="margin-left:47%; font-weight: bold">Date: <%=h.getNgaymua() %></h4>
                      <div class="product-item" style="display: flex;padding-top: 15px;">
                          <div class="product-item__img" style="padding-right: 8%;  flex-shrink: 0;">
                              <img style="width: 100%;height: 300px;;border-radius: 30px;" title="Ảnh" src="<%=h.getAnh()%>">
                          </div>
                          <div class="product-item__info" style="flex: 1;">
                              <div class="invoice-code" style="margin-left: 70%;">
                                   <%if(h.getDamua() == 1) {%>
                                        <div style = "font-weight: bold; color: green; font-size: 20px"> Đã mua</div>
                                   <%}else { %>
                                        <div style = "font-weight: bold; color: red; font-size: 20px">Chưa duyệt</div>
                                        	<%} %>
                               </div>
                               <div style="margin-top: 14%;">
                                   <div class="product-item__name" style = "font-size: 30px; font-weight: bold ">
                                        <span><%=h.getTencay() %></span>
                                   </div>
                                   <div class="product-item__price"style = "font-size: 18px" >
                                       <div>Price: <%=formatter.format(h.getGia()) + "$" %></div>
                                       <div style="font-size: 20px; font-weight: bold; color: #669bbc;margin-left: 93%;margin-top:5px;"><%=(h.getSoluongMua()) %></div>
                                   </div>
                              </div>
                          </div>
                      </div>
                      <div style="border-bottom: 2px solid blue; display: flex; justify-content: space-between; padding-bottom: 8px;margin-bottom: 48px;margin-top: 16px;">
                      	  <div style="font-weight: bold; font-size:18px" >Total price:
                              <span style="color: #780000; font-weight: bold;"><%=formatter.format((h.getGia()* h.getSoluongMua())) + "Vnd" %></span>
                      		</div>
                   	  </div>
                  </div>
                  
                        <%} %>
                         <%} %>

     </div>
</body>
</html>