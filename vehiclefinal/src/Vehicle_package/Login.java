package Vehicle_package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		HttpSession s=request.getSession(true);
		ServletContext sc=request.getServletContext();
		String empid=request.getParameter("empid");
		String password=request.getParameter("password");
		User v=new User();
		v.setEmployeeid(empid);
		v.setPassword(password);
		int status=VehicleDAO.logincheck(v);
		if(status>0)
		{
			//sc.setAttribute("empid",empid);
			out.println("<script>alert('Success')</script>");
			request.getRequestDispatcher("Servletmail").include(request,response);
			request.getRequestDispatcher("Home.jsp").forward(request,response);
		}
		else
		{
			out.println("<script>alert('Invalid UserName or Password')</script>");
			//request.getRequestDispatcher("Login.jsp").include(request,response);
			request.getRequestDispatcher("login.jsp").include(request,response);
		}
	}

}
