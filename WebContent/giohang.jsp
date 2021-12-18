<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="bean.GioHangBean"%>
<%@page import="bean.KhachHangBean"%>
<%@page import="bo.CayBo"%>
<%@page import="bean.CayBean"%>
<%@page import="java.util.ArrayList"%>
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
<body>
	<%
	    response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("utf-8");
		ArrayList<CayBean> cBean= (ArrayList<CayBean>) request.getAttribute("cBean");
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
                		<a>Giỏ Hàng</a>
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
                        	<li><a href="lichsuController">Lịch sử mua hàng</a></li>
                        	<li><a href="HtcayController?dangxuat=oke"">Đăng xuất</a></li>
                      
                    	</ul>
                    <%} 
                	else {%>
                    </li>
                    <li>
                        <a class="nav-link disabled" href=""
							style="color: white;" data-toggle="modal" data-target="#myModal">
							<i class="fa fa-user-circle" aria-hidden="true"></i> Đăng nhập
						</a>       
                    </li>
                    <li>
                        <a href="#" data-toggle="modal" data-target="#myModalregister"><span class="nav-link disabled"></span>Đăng ký</a>
                    </li>
                    <%
                    	Long ktra=(long)0;
                    	if(request.getAttribute("kt")!=null ){
                    		ktra=(long)request.getAttribute("kt");
                    		if(ktra ==1){%>
                    			<script>
                    				alert("tài khoản hoặc mật khẩu không đúng");
                    			</script>
                    		<%}else if (ktra==2) {%>
                    			<script>
                    				alert("không được để trống");
                    			</script>
                    		<%}
                    		
                    	}
                	}
                    %>
                    
                    
                </ul>

               
            </div>
        </div>
        <!-- Modal -->
		  <div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog modal-sm">
		      <div class="modal-content">
		        <div class="modal-header">
		         <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Đăng nhập hệ thống</h4>
		        </div>
		        <div class="modal-body">
		          <form method="post" action="LoginController">
		             <label> Tên đăng nhập: </label><br>
		              <input name="txtun" type="text" class="form-control"><br>
		             <label> Mật khẩu: </label><br>
		             <input name="txtpass" type="password" class="form-control"><br>
		             <input name="but1" type="submit" value="Đăng nhập" class="btn-primary"><br>
		         </form>
		        </div>
		        </div>
		    </div>
		    
		  </div>
		 
	<div class="modal fade" id="myModalregister" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Đăng Ký</h4>
				</div>
				<div class="modal-body">
					<form method="post" action="RegisterController">
						<tbody>
					<tr style="height: 40px">
						<td>Họ tên khách hàng:</td><br>
						<td><input id="HotenKH" name="txthoten" type="text" value="">

						</td><br>
					</tr>
					<tr style="height: 40px">
						<td>Tên đăng nhập:</td><br>
						<td><input id="TenDN" name="txttendn" type="text" value="">
						</td><br>
					</tr>
					<tr style="height: 40px">
						<td>Mật khẩu:</td><br>
						<td><input id="Matkhau" name="txtpassword" type="password"><br>
						</td>
					</tr>

					<tr style="height: 40px">
						<td>Email:</td><br>
						<td><input id="Email" name="txtemail" type="text" value=""><br>
						</td>
					</tr>
					<tr style="height: 40px">
						<td>Địa chỉ:</td><br>
						<td><input id="Diachi" name="txtdiachi" type="text" value=""><br>
						</td>
					</tr>
					<tr style="height: 40px">
						<td>Điện thoại:</td><br>
						<td><input id="Dienthoai" name="Dienthoai" type="text"
							value=""></td><br>
					</tr>

					<tr style="height: 40px">
						<td></td>
						<td><input name="btnregister" type="Submit" value="Đăng ký">
						</td>
					</tr>

				</tbody>
				</form>
				</div>
			</div>
		</div>
	</div>
	
	<%
		Long ktra = (long)0;
		if(request.getAttribute("ketquadangki") !=null){
			ktra = (long)request.getAttribute("ketquadangki");
			if(ktra == 1){%>
				<script>
					alert('Đăng kí thành công');
				</script>
			<%}else if(ktra == 0) {%>
				<script>
					alert('Đăng kí thất bại');
				</script>
			<%}else if(ktra == 2) {%>
				<script>
					alert('Đăng kí thất bại,tên đăng nhập đã tồn tại');
				</script>
			<%}
		}
	%>
	 
      <% DecimalFormat formatter = new DecimalFormat("###,###,###"); %>
       <% ArrayList<GioHangBean> listgiohang= new ArrayList<>();
        Long tongtien=(long)0;
       if(session.getAttribute("listgh")!=null){
         listgiohang=(ArrayList<GioHangBean>)session.getAttribute("listgh");
         tongtien=(long)session.getAttribute("tongtien");
       }
         if(session.getAttribute("listgh") != null){%>
            <div class="content-cart" style="margin-top: 200px">
            	<div class="content-cart-goods" style="margin:0 20%;">
                    <div class="content-goods">
                            <div class="content-products">
                                <table class="shop_table shop_table_responsive cart woocommerce-cart-form__contents" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th class="product-name" colspan="3">Sản phẩm</th>
                                            <th class="product-price">Giá</th>
                                            <th class="product-quantity">Số lượng</th>
                                            <th class="product-subtotal">Tạm tính</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                    	for(GioHangBean gh: listgiohang) {
                                   		%> 
                                    <tr class="woocommerce-cart-form__cart-item cart_item">
                                    
                                       	<td class="product-remove">
                                       		<a href="deleteController?macay=<%=gh.getMacay()%>&delete=haha">X</a>
                                             
                                        </td>
                                        <td class="product-thumbnail">
                                            <img width="100" height="100" class="cart-image" src="<%=gh.getAnh()%>">						
                                        </td>
                                        <td class="product-name" data-title="Sản phẩm">
                                            <h4><%=gh.getTencay() %></h4>
                                         </td>
                
                                         <td class="product-price" data-title="Giá">
                                            <span class="woocommerce-Price-amount amount"><bdi><%= formatter.format(gh.getGia())%>&nbsp;<span class="woocommerce-Price-currencySymbol">₫</span></bdi></span>						
                                         </td>
                
                                         <td class="product-quantity" data-title="Số lượng">
                                            <div class="quantity buttons_added">
                                       			 <form action="capnhatgiohang?macay=<%=gh.getMacay()%>" method="post">
                                                 	<input type="number"style="width: 50px" name="soluong" value="<%=gh.getSlMua()%>">
                                 					<input class="content-goods-input" type="submit" value="Cập nhật" name="update">	
                                                </form>	
                                            </div>
                                         </td>
                                         <td class="product-subtotal" data-title="Tạm tính">
                                             <span class="woocommerce-Price-amount amount"><bdi><%= formatter.format(gh.getGia() * gh.getSlMua())%>&nbsp;<span class="woocommerce-Price-currencySymbol">₫</span></bdi></span>						
                                         </td>
                                          <%} %>
                                        </tr>
                                        
                                        <tr>
                                            <td colspan="6" class="actions clear">
                        
                                                <div class="continue-shopping pull-left text-left">
                                                    <a class="button-continue-shopping button primary is-outline" href="HtcayController">
                                                    ←&nbsp;Tiếp tục xem sản phẩm	</a>
                                                </div>
                                               
                                                	
                                            </td>
                                        </tr>
                
                                    </tbody>
                                </table>
                            </div>
                    </div>
                    <div class="content-payment">
                        <div class="cart-sidebar col-inner ">
                            <div class="cart_totals ">
                                <table cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th class="product-name" colspan="2" style="border-width:3px;">Cộng giỏ hàng</th>
                                        </tr>
                                    </thead>
                                </table>
                                <table cellspacing="0" class="table-payments">
                    
                                    <tbody>
                                        <tr class="cart-subtotal">
                                            <th>Tạm tính</th>
                                            <td data-title="Tạm tính"><span class="woocommerce-Price-amount amount"><bdi> <%=formatter.format(tongtien)%>&nbsp;<span class="woocommerce-Price-currencySymbol">₫</span></bdi></span></td>
                                        </tr>
                                        <tr class="order-total">
                                            <th>Tổng</th>
                                            <td data-title="Tổng"><strong><span class="woocommerce-Price-amount amount"><bdi> <%=formatter.format(tongtien)%>&nbsp;<span class="woocommerce-Price-currencySymbol">₫</span></bdi></span></strong> </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="content-payment-button">   
                                    <a class="btn btn-primary" href="thanhtoanController" role="button">Xác nhận đặt mua</a>
                                </div>
                            </div>
                            <form class="checkout_coupon mb-0" method="post">
                                <div class="coupon">
                                    <h3 class="widget-title"><i class="icon-tag"></i> Phiếu ưu đãi</h3><input type="text" name="coupon_code" class="input-text" id="coupon_code" value="" placeholder="Mã ưu đãi"> <input type="submit" class="is-form expand" name="apply_coupon" value="Áp dụng">
                                </div>
                            </form>
                        </div>
                    
                    </div>
                    <%} else {%>
						<div style="text-align: center; margin-bottom: 130px; margin-top: 130px">
							<span style="margin-top: 180px; font-weight: 900; font-size: 25px; color: #d7d7c1">GIỎ
							HÀNG TRỐNG</span>
							</div>
					<% }%>
            </div>   
        </div>    
	</div>
</body>
</html>