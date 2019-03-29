package Vehicle_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updatevehicle
 */
@WebServlet("/Updatevehicle")
public class Updatevehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatevehicle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try
		{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ServletContext sc=request.getServletContext();
		String vehicleno=sc.getAttribute("vno").toString();
		int choice=Integer.parseInt(request.getParameter("choice"));
		//System.out.println(choice);
		String data=request.getParameter("date");
		//DateFormat df=new SimpleDateFormat("yyyy-mm-dd");
		//Date d=(Date) df.parse(date);
		//System.out.println(d);
		int status= VehicleDAO.UpdateVehicleDetails(choice,data,vehicleno);
		if(status>0)
		{
			out.println("<script>alert('Updated Successfully')</script>");
			request.getRequestDispatcher("Updatevehicle.jsp").include(request,response);
		}
		else
		{
			out.println("<script>alert('Error')</script>");
			request.getRequestDispatcher("Updatevehicle.jsp").include(request,response);
		}
		
		}
		catch(Exception e)
		{
			System.out.println("update vehicle.java "+e);
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
