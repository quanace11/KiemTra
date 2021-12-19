package controllerAdmin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LichSuAdminBean;
import bo.LichSuAdminBo;

/**
 * Servlet implementation class damuaAdmin
 */
@WebServlet("/damuaAdmin")
public class damuaAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public damuaAdmin() {
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
			LichSuAdminBo lsadBo=new LichSuAdminBo();
			ArrayList<LichSuAdminBean> lsmhdm=lsadBo.getLichSuDaMua();
			request.setAttribute("lsmhdm", lsmhdm);
			RequestDispatcher rd =request.getRequestDispatcher("dammuaadmin.jsp");
			rd.forward(request, response);
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
