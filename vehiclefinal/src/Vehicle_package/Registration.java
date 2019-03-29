package Vehicle_package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		User v=new User();
		v.setEmployeeid(request.getParameter("empid"));
		v.setFirstname(request.getParameter("fname"));
		v.setLastname(request.getParameter("lname"));
		v.setAge(Integer.parseInt(request.getParameter("age")));
		v.setGender(request.getParameter("gender"));
		v.setPhone(Long.parseLong(request.getParameter("contact")));
		v.setEmailid(request.getParameter("email"));
		v.setPassword(request.getParameter("password"));
		v.setBranch(request.getParameter("branch"));
		int status=VehicleDAO.SaveDetails(v);
		if(status>0)
		{
			out.println("<script>alert('Saved Successfully')</script>");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		else
		{
			out.println("<script>alert('Error in Saving')</script>");
			request.getRequestDispatcher("Registration.jsp").forward(request,response);
		}
	}

}
