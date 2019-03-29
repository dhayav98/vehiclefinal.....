package Vehicle_package;
import java.util.*;
import java.text.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Createvehicle
 */
@WebServlet("/Createvehicle")
public class Createvehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Createvehicle() {
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
		try
		{
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		String vehicleno=request.getParameter("vno");
		String branch=request.getParameter("branch");
		String vehicletype=request.getParameter("vtype");
		String insurance_expiry=request.getParameter("insurance");
		String last_serviced_date=request.getParameter("lastserviceddate");
		String service_due_date=request.getParameter("serviceduedate");
		Vehicle v=new Vehicle();
		v.setVehicleno(vehicleno);
		v.setVehicletype(vehicletype);
		v.setBranch(branch);
		v.setInsurance_expiry(insurance_expiry);
		v.setLast_serviced_date(last_serviced_date);
		v.setService_due_date(service_due_date);
		
		int status=VehicleDAO.SaveVehicleDetails(v);
		if(status>0)
		{
			out.println("<script>alert('Saved Successfully')</script>");
			request.getRequestDispatcher("Home.jsp").include(request,response);
		}
		else
		{
			out.println("<script>alert('ErroR')</script>");
			request.getRequestDispatcher("Createvehicle.jsp").forward(request,response);
		}
		
		}
		catch(Exception e)
		{
			System.out.print("create vehicle.java "+e);
		}
	}


}
