package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.KhachHangBean;
import bo.KhachHangBo;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String un=request.getParameter("txtun");
			String pass=request.getParameter("txtpass");
			HttpSession session =request.getSession();
		
			if(request.getParameter("but1")!=null) 
			{
				KhachHangBo khbo=new KhachHangBo();
				if(un==null&&pass==null)
				{
					request.setAttribute("kt", (long)2);
				}
				else
				{
					KhachHangBean kh = khbo.checkDn(un, pass); 
					if(kh!= null) 
					{
						session.setAttribute("khachhang", kh);
					}
					else
					{
						request.setAttribute("kt",(long)1);
					}
				}		
				RequestDispatcher rd=request.getRequestDispatcher("HtcayController");
				rd.forward(request, response);
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
