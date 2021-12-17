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
 * Servlet implementation class giohangController
 */
@WebServlet("/giohangController")
public class giohangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohangController() {
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
		try 
		{	
			String anh=request.getParameter("anh");
			String tc=request.getParameter("tc");
			String gia=request.getParameter("gia");
			String macay=request.getParameter("mcay");
			System.out.println("macay="+macay);
			HttpSession session = request.getSession();
			GioHangBo gioHangbo=(GioHangBo)session.getAttribute("giohangbo");
		
			if(gioHangbo==null){
		    	gioHangbo = new GioHangBo();
		    }
			if(macay!= null) 
			{
				gioHangbo.themCay(macay,anh, tc,Long.parseLong(gia),(long)1);
				session.setAttribute("giohangbo",gioHangbo);
				
				System.out.println("gio hang bo = " + gioHangbo);
				session.setAttribute("listgh", gioHangbo.ds);
				session.setAttribute("soluongsp", gioHangbo.getSize());
				session.setAttribute("tongtien", gioHangbo.tongTien());
				System.out.println("size"+gioHangbo.ds.size());
				RequestDispatcher rd =request.getRequestDispatcher("HtcayController");
				rd.forward(request, response);
				
			}
			else {
				session.setAttribute("giohangbo",gioHangbo);
				session.setAttribute("listgh", gioHangbo.ds);
				session.setAttribute("tongtien", gioHangbo.tongTien());
				session.setAttribute("soluongsp", gioHangbo.ds.size());
				RequestDispatcher rd=request.getRequestDispatcher("giohang.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception e) 
		{
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
