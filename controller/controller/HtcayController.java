package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CayBean;
import bo.CayBo;

/**
 * Servlet implementation class HtcayController
 */
@WebServlet("/HtcayController")
public class HtcayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HtcayController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			String ml=request.getParameter("ml");
			String timcay=request.getParameter("txtfind");
			CayBo cBo =new CayBo();
			ArrayList<CayBean> cBean=cBo.getCay();
			
			if(ml==null && timcay==null) 
			{
				request.setAttribute("cBean", cBean);
				RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);
			}
			else if(ml!=null) 
			{
				request.setAttribute("cBean", cBo.timLoaiCay(ml));
				RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
				rd.forward(request, response);
			}
			else if(timcay!=null)
			{
				request.setAttribute("cBean", cBo.timCay(timcay));
				RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
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
