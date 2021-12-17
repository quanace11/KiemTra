package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.KhachHangBo;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
    	request.setCharacterEncoding("utf-8");
    	String hoten=request.getParameter("txthoten");
    	String diachi=request.getParameter("txtdiachi");
    	String sodt=request.getParameter("Dienthoai");
    	String email=request.getParameter("txtemail");
    	String tendangnhap=request.getParameter("txttendn");
    	String password=request.getParameter("txtpassword");
    	try {
    		if(request.getParameter("btnregister")!=null) {
    			KhachHangBo khachHangBo = new KhachHangBo();
    			if(khachHangBo.checkLogin(tendangnhap)) {
    				if(khachHangBo.insertKH(hoten, diachi, sodt, email, tendangnhap, password)) {
    					request.setAttribute("ketquadangki", (long)1);
    				}else {
    					request.setAttribute("ketquadangki", (long)0);
    				}
    			}else {
    				request.setAttribute("ketquadangki", (long)2);
    			}
    			RequestDispatcher rDispatcher =request.getRequestDispatcher("HtcayController");
    			rDispatcher.forward(request, response);
		}
    	} catch (Exception e) {
    		// TODO: handle exception
    		e.printStackTrace();
    	}
	
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
