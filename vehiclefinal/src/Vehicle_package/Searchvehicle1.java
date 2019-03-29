package Vehicle_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Searchvehicle
 */
@WebServlet("/Searchvehicle1")
public class Searchvehicle1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searchvehicle1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		int choice1=Integer.parseInt(request.getParameter("choice"));
		System.out.println("choice :"+choice1);
		String data=request.getParameter("data");
		System.out.println("data :"+data);
		Vehicle v=new Vehicle();
		//int choice=Integer.parseInt(choice1);
		ArrayList<Vehicle> searchcriteria=new ArrayList<Vehicle>();
		searchcriteria=VehicleDAO.SearchCriteria(choice1,data);
		if(searchcriteria.isEmpty())
		{
			out.print("<br>");
			out.print("<br>");
			out.print("<h2>Vehicle Details</h2>");
			out.print("<br>");
			out.print("<br>");
			out.print("<b>No such element found</b>");
		}
		else
		{
		out.print("<html>");
		out.print("");
		out.println("<head>");
		out.println("<style>");
		out.println("body{");
		out.println("background-color:#C8C8C8");
		out.println("}");
		out.println("table,td,th{");        
	    out.println("border: 1px solid #f5f5f5;");
	 	 out.println(" padding: 2px;");
		  out.println("}");
		  out.println("table {");
		  out.println("border-spacing: 5px;");
		  out.println("}");
		  out.println("</style>");
		  out.println("</head>");
		  out.println("<body>");
		  out.print("<br>");
		  out.print("<center>");
		  
		  out.print("<h2>Vehicle Details</h2>");
		  
		  out.print("</center>");
		  out.print("<br>");
		out.print("<table width='100%'");
		out.print("<tr><th>Vehicle No</th><th>Branch</th><th>Vehicle Type</th><th>Insurance Expiry Date</th><th>Last Serviced Date</th><th>Service Due Date</th></tr>");
		for(Vehicle vv: searchcriteria)
		{
			String d1=vv.getInsurance_expiry();
			Date d = null;
			try {
				d = df.parse(d1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Date dd=new Date();
			//System.out.println("display details : date2="+dd);
			//System.out.println("difference : "+(dd.getDate()-d.getDate()));
		long duration=d.getTime()-dd.getTime();
		   long datedifference=TimeUnit.MILLISECONDS.toDays(duration);
		   System.out.println("Total number of days : "+datedifference);
			if(datedifference<=15)
			{
				out.print("<tr style='color:red;'><td>"+vv.getVehicleno()+"</td><td>"+vv.getBranch()+"</td><td>"+vv.getVehicletype()+"</td><td>"+vv.getInsurance_expiry()+"</td><td>"+vv.getLast_serviced_date()+"</td><td>"+vv.getService_due_date()+"</td></tr>");
			}
			else
			{
				out.print("<tr><td>"+vv.getVehicleno()+"</td><td>"+vv.getBranch()+"</td><td>"+vv.getVehicletype()+"</td><td>"+vv.getInsurance_expiry()+"</td><td>"+vv.getLast_serviced_date()+"</td><td>"+vv.getService_due_date()+"</td></tr>");
			
			}
			
			}
		out.print("</table>");
		out.print("<br>");
		out.println("</body>");
		out.println("</html>");
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
