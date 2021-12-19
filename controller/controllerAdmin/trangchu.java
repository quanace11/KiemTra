package controllerAdmin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CayAdminBean;
import bo.CayAdminBo;
import bo.LoaiBoAdmin;

/**
 * Servlet implementation class trangchu
 */
@WebServlet("/trangchu")
public class trangchu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public trangchu() {
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
			CayAdminBo cabo =new CayAdminBo();
			LoaiBoAdmin lbAd=new LoaiBoAdmin();
			request.setAttribute("dsLoai", lbAd.getLoaiSach());
			ArrayList<CayAdminBean> cBean=cabo.getCay();
			String ml =request.getParameter("ml");
			String timcay = request.getParameter("txtname");
			if(ml == null && timcay == null) {
				request.setAttribute("cBean", cBean);
				RequestDispatcher rDispatcher =request.getRequestDispatcher("trangchu.jsp");
				rDispatcher.forward(request, response);
			}else if(ml!=null){
				request.setAttribute("cBean",cabo.timLoaiCay(ml));
				RequestDispatcher rDispatcher =request.getRequestDispatcher("trangchu.jsp");
				rDispatcher.forward(request, response);
			}else if(timcay!=null) {
				request.setAttribute("cBean",cabo.timCay(timcay));
				RequestDispatcher rDispatcher =request.getRequestDispatcher("trangchu.jsp");
				rDispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
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
