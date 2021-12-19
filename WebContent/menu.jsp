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
	<%int count = 0;
	if(session.getAttribute("soluongsp")!=null){
		count = (int)session.getAttribute("soluongsp");
	}
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
                		<a href="giohang.jsp">Giỏ Hàng(<%=count %>)</a>
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
	
        <div id="slider">
            <div class="col-md-9" >
                <div class="row carousel-holder">
                    <div class="col-md-12" style="left: 17%;margin-top: 46px;">
                        <div id="carousel-example-generic" class="carousel slide"
                            data-ride="carousel" >
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0"
                                    class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="slide/slide1.jpg" alt="">
        
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="slide/slide2.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="slide/slide3.jpg" alt="">
                                </div>
        
        
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic"
                                data-slide="prev"> <span
                                class="glyphicon glyphicon-chevron-left"></span>
                            </a> <a class="right carousel-control" href="#carousel-example-generic"
                                data-slide="next"> <span
                                class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                            <div style=" float: right;">
                               
                            </div>
                        </div>
                    </div>
                       
                </div>
            </div>
           
        </div>
        <div id="contents" >
             <h1 class="section-title"><b></b></h1> 
             <h1 style="text-align: center;color: rgb(38, 197, 51);text-transform: uppercase;" >Các sản phẩm có sẵn</h1>  
             <div class="trees">
             	<%if(cBean!=null) {
             		for(CayBean cay: cBean){ %>
             			<div class="tree">
             				<img class="tree-image" src=<%=cay.getAnh() %>>
             				<div class="tree-content">
             					<div class="tree-top">
             						<h3 class="tree-title"><%=cay.getTencay() %></h3>
             						<div class="tree-info">
             							<a href="giohangController?tc=<%=cay.getTencay() %>&gia=<%=cay.getGia() %>&mcay=<%=cay.getMacay() %>&anh=<%=cay.getAnh() %>"><input type="submit" value="Thêm vào giỏ hàng" style="width:150px;color:#fff;height:40px;background-color: #d26e4b;" ></a>
             						</div>
             					</div>
             					<div class="tree-bottom">
             						<div class="tree-bottom-price">
										<h4 class="tree-price">Giá : <%=cay.getGia() %></h4>             							
             						</div>
             					</div>
             				</div>   
             			</div>
             			<% } %>
             		<% } %>
          
             </div>
            
        </div>
    </div>
</body>
</html>
