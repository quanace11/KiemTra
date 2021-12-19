package controllerAdmin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdminBean;
import bo.AdminBo;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String user= request.getParameter("txtUser");
			String pass=request.getParameter("txtPass");
			HttpSession session = request.getSession();
			if(request.getParameter("but1")!=null) {
				AdminBo dnBo = new AdminBo();
			 	AdminBean login = dnBo.getAdmin(user, pass);
			 	if(login != null){
					session.setAttribute("admin", login);
					request.setAttribute("kt", (long)1);
					session.setAttribute("tenadmin", login.getTenDn());
				}
				else{
					request.setAttribute("kt", (long)0);
					RequestDispatcher rDispatcher =request.getRequestDispatcher("Login.jsp");
					rDispatcher.forward(request, response);
				}
			 	response.sendRedirect("trangchu");
			}
			else {
				RequestDispatcher rDispatcher =request.getRequestDispatcher("Login.jsp");
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
