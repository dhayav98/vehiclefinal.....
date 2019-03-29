package Vehicle_package;
import java.io.IOException;
import java.text.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.*;
/**
 * Servlet implementation class Servletmail
 */
@WebServlet("/Servletmail")
public class Servletmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try{
			ServletContext sc=request.getServletContext();
			//System.out.println(sc.getAttribute("empid").toString());
			ArrayList<User> userlist=new ArrayList<User>();
			userlist=VehicleDAO.GetUserDetails();
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			ArrayList<String> emaillist=new ArrayList<String>();
			for(User u: userlist)
			{
				emaillist.add(u.getEmailid());
			}
			ArrayList<Vehicle> list=VehicleDAO.SearchVehicleDetails();
			for(Vehicle v:list)
			{
				String d1=v.getInsurance_expiry();
				Date d=df.parse(d1);
				//Calendar c=Calendar.getInstance();
				//c.add(Calendar.DATE,0);
				//Date dd=c.getTime();
			    Date dd=new Date();
				//System.out.println("display details : date2="+dd);
				//System.out.println("difference : "+(dd.getDate()-d.getDate()));
			   long duration=d.getTime()-dd.getTime();
			   long nod=TimeUnit.MILLISECONDS.toDays(duration);
			   System.out.println("Total number of days : "+nod);
			   if((nod==15) || (nod==10) || (nod==5))
				{
					String host ="smtp.gmail.com" ;
		            String user = "vrsystem2019@gmail.com";
		            String pass = "vehicle2019";
		            //String to = u.getEmailid();
		            String from = "vrsystem2019@gmail.com";
		            String subject = "Vehicle Insurance Remainder";
		            String messageText = "Vehicle details: \nVehicle Number: "+v.getVehicleno()+" \nVehicle Type: "+v.getVehicletype()+"\nVehicle Branch: "+v.getBranch()+"\nVehicle Last serviced Date: "+v.getLast_serviced_date()+"\nVehicle Service Due Date: "+v.getService_due_date()+"\nThis vehicle's Insurance will expire within 15days!!!!";
		            boolean sessionDebug = false;
		            
		            Properties props = System.getProperties();

		            props.put("mail.smtp.starttls.enable", "true");
		            props.put("mail.smtp.host", host);
		            props.put("mail.smtp.port", "587");
		            props.put("mail.smtp.auth", "true");
		            props.put("mail.smtp.starttls.required", "true");

		            //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		            Session mailSession = Session.getDefaultInstance(props, null);
		            mailSession.setDebug(sessionDebug);
		            Message msg = new MimeMessage(mailSession);
		            msg.setFrom(new InternetAddress(from));
		            InternetAddress[] address = new InternetAddress[emaillist.size()];
		            for(int i=0;i<emaillist.size();i++)
		            {
		            	address[i]=new InternetAddress(emaillist.get(i));
		            }
		            msg.setRecipients(Message.RecipientType.TO, address);
		            msg.setSubject(subject); msg.setSentDate(new Date());
		            msg.setText(messageText);

		           Transport transport=mailSession.getTransport("smtp");
		           transport.connect(host, user, pass);
		           transport.sendMessage(msg, msg.getAllRecipients());
		           transport.close();
		           System.out.println("message send successfully");
				}
				else
				{
					System.out.println(" Insurance : message not send");
				}
			   
			    String d2=v.getService_due_date();
			    Date date2=df.parse(d2);
			    
			    LocalDate servicedueday = LocalDate.of(date2.getYear()+1900,date2.getMonth()+1,date2.getDate()); 
				LocalDate today = LocalDate.now(); 
				Period age = Period.between(today,servicedueday); 
				int years = age.getYears(); 
				int month = age.getMonths(); 
				int months=years*12+month;
				System.out.println("Total number of months : "+months);
				if(months==15)
				{
					String host ="smtp.gmail.com" ;
		            String user = "vrsystem2019@gmail.com";
		            String pass = "vehicle2019";
		            //String to = u.getEmailid();
		            String from = "vrsystem2019@gmail.com";
		            String subject = "Vehicle Service Remainder";
		            String messageText = "Vehicle details: \nVehicle Number: "+v.getVehicleno()+" \nVehicle Type: "+v.getVehicletype()+"\nVehicle Branch: "+v.getBranch()+"\nVehicle Last serviced Date: "+v.getLast_serviced_date()+"\nVehicle Service Due Date: "+v.getService_due_date()+"\nService due in next 15 months!!!!";
		            boolean sessionDebug = false;
		            
		            Properties props = System.getProperties();

		            props.put("mail.smtp.starttls.enable", "true");
		            props.put("mail.smtp.host", host);
		            props.put("mail.smtp.port", "587");
		            props.put("mail.smtp.auth", "true");
		            props.put("mail.smtp.starttls.required", "true");

		            //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		            Session mailSession = Session.getDefaultInstance(props, null);
		            mailSession.setDebug(sessionDebug);
		            Message msg = new MimeMessage(mailSession);
		            msg.setFrom(new InternetAddress(from));
		            InternetAddress[] address = new InternetAddress[emaillist.size()];
		            for(int i=0;i<emaillist.size();i++)
		            {
		            	address[i]=new InternetAddress(emaillist.get(i));
		            }
		            msg.setRecipients(Message.RecipientType.TO, address);
		            msg.setSubject(subject); msg.setSentDate(new Date());
		            msg.setText(messageText);

		           Transport transport=mailSession.getTransport("smtp");
		           transport.connect(host, user, pass);
		           transport.sendMessage(msg, msg.getAllRecipients());
		           transport.close();
		           System.out.println("message send successfully");
					
				}
				else
				{
					System.out.println(" Service Due Date : message not send");
				}
			    
			   	 
			
			}
			
			
			

        }
		catch(Exception ex)
        {
            System.out.println(ex);
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
