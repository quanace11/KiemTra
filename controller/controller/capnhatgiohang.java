package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.GioHangBo;

/**
 * Servlet implementation class capnhatgiohang
 */
@WebServlet("/capnhatgiohang")
public class capnhatgiohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public capnhatgiohang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String macay = request.getParameter("macay");
			String delete= request.getParameter("delete");
			String update=request.getParameter("update");
			HttpSession session = request.getSession();
			GioHangBo gioHangbo=(GioHangBo)session.getAttribute("giohangbo");
			long soluong = Long.parseLong(request.getParameter("soluong"));
			if(update!=null) {
				gioHangbo.update(macay, soluong);
				session.setAttribute("giohangbo", gioHangbo);
//				RequestDispatcher rd =request.getRequestDispatcher("giohangController");
//				rd.forward(request, response);
				response.sendRedirect("giohangController");
			}
			else if(delete!=null && macay!= null){
				gioHangbo.xoa(macay);
				session.setAttribute("giohangbo", gioHangbo);
//				RequestDispatcher rDispatcher =request.getRequestDispatcher("giohangController");
//				rDispatcher.forward(request, response);
				response.sendRedirect("giohangController");
			}
		
		}catch(Exception e) {
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
