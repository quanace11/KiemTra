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
import bo.LichSuBo;

/**
 * Servlet implementation class lichsuController
 */
@WebServlet("/lichsuController")
public class lichsuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsuController() {
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
			HttpSession session=request.getSession();
			LichSuBo lsbo=new LichSuBo();
			KhachHangBean KhachHang=(KhachHangBean) session.getAttribute("khachhang");
			request.setAttribute("lichsumua", lsbo.getHistorys(KhachHang.getMakh()));
			RequestDispatcher rd=request.getRequestDispatcher("lichsu.jsp");
			rd.forward(request, response);
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
