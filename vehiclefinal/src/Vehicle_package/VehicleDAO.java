package Vehicle_package;

import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.text.*;
import java.util.*;

public class VehicleDAO
{
	public static Connection GetConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cogdb","root","root");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}

	public static int SaveDetails(User v)
	{
	   int savedstatus=0;
	   try
	   {
		Connection con=VehicleDAO.GetConnection();
		PreparedStatement ps=con.prepareStatement("insert into userdetails values(?,?,?,?,?,?,?,?,?)");
		ps.setString(1,v.getEmployeeid());
		ps.setString(2,v.getFirstname());
		ps.setString(3,v.getLastname());
		ps.setInt(4,v.getAge());
		ps.setString(5,v.getGender());
		ps.setLong(6,v.getPhone());
		ps.setString(7,v.getEmailid());
		ps.setString(8,v.getPassword());
		ps.setString(9,v.getBranch() );
		savedstatus=ps.executeUpdate();
	   }
	   catch(Exception e)
	   {
		System.out.println(e);
	   }
	   return savedstatus;
   }
	
	public static int logincheck(User v)
	{
		int loginstatus=0;
		try
		{
			String empid=v.getEmployeeid();
			String password=v.getPassword();
			Connection con=VehicleDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("select employeeid,password from userdetails");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				if((empid.equalsIgnoreCase(rs.getString(1)))&& (password.equalsIgnoreCase(rs.getString(2))))
				{
					loginstatus=1;
					break;
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return loginstatus;
	}
	
	public static int SaveVehicleDetails(Vehicle v)
	{
		int status=0;
		try
		{		
			Connection con=VehicleDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("insert into vehicledetails values(?,?,?,?,?,?)");
			ps.setString(1,v.getVehicleno());
			ps.setString(2,v.getBranch());
			ps.setString(3,v.getVehicletype());
			ps.setString(4,v.getInsurance_expiry());
			ps.setString(5,v.getService_due_date());
			ps.setString(6,v.getService_due_date());
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("vechileDAO vehicledeatails :"+e);
		}
		
		return status;
	}
	 
	public static ArrayList SearchVehicleDetails()
	{
		ArrayList<Vehicle> list=new ArrayList<Vehicle>();
		try
		{
			Connection con=VehicleDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("select * from vehicledetails");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Vehicle v= new Vehicle();
				v.setVehicleno(rs.getString("vehicleno"));
				v.setBranch(rs.getString("branch"));
				v.setVehicletype(rs.getString("vehicletype"));
				v.setInsurance_expiry(rs.getString("insurance_expiry"));
				v.setService_due_date(rs.getString("service_due_date"));
				v.setLast_serviced_date(rs.getString("last_serviced_date"));
				list.add(v);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	public static ArrayList SearchCriteria(int choice,String data)
	{
		ArrayList<Vehicle> list1=new ArrayList<Vehicle>();
		try
		{
			//Connection con=VehicleDAO.GetConnection();
			Connection con=null;
			PreparedStatement ps;
			int status;
			ResultSet rs=null;
			switch(choice)
			{
				case 1:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("select * from vehicledetails where branch=?");
					ps.setString(1,data);
					rs=ps.executeQuery();
					break;
				case 2:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("select * from vehicledetails where vehicletype=?");
					ps.setString(1,data);
					rs=ps.executeQuery();
					break;
				case 3:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("select * from vehicledetails where insurance_expiry=?");
					ps.setString(1,data);
					rs=ps.executeQuery();
					break;
				case 4:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("select * from vehicledetails where service_due_date=?");
					ps.setString(1,data);
					rs=ps.executeQuery();
					break;
					
			}
			while(rs.next())
			{
				Vehicle v= new Vehicle();
				v.setVehicleno(rs.getString("vehicleno"));
				v.setBranch(rs.getString("branch"));
				v.setVehicletype(rs.getString("vehicletype"));
				v.setInsurance_expiry(rs.getString("insurance_expiry"));
				v.setService_due_date(rs.getString("service_due_date"));
				v.setLast_serviced_date(rs.getString("last_serviced_date"));
				list1.add(v);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
		return list1;
	}
	
	public static int UpdateVehicleDetails(int choice, String s, String vehicleno) throws Exception
	{
		int status=0;
		try
		{
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date d1=null;
			Connection con=null;
			PreparedStatement ps;
			switch(choice)
			{
				
				case 1:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("update vehicledetails set branch=? where vehicleno=?");
					ps.setString(1,s);
					ps.setString(2,vehicleno);
					status=ps.executeUpdate();
					break;

				case 2:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("update vehicledetails set vehicletype=? where vehicleno=?");
					ps.setString(1,s);
					ps.setString(2,vehicleno);
					status=ps.executeUpdate();
					break;

				case 3:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("update vehicledetails set insurance_expiry=? where vehicleno=?");
					ps.setString(1,s);
					ps.setString(2,vehicleno);
					status=ps.executeUpdate();
					break;
				case 4:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("update vehicledetails set last_serviced_date=? where vehicleno=?");
					ps.setString(1,s);
					ps.setString(2,vehicleno);
					status=ps.executeUpdate();
					break;
				case 5:
					con=VehicleDAO.GetConnection();
					ps=con.prepareStatement("update vehicledetails set service_due_date=? where vehicleno=?");
					ps.setString(1,s);
					ps.setString(2,vehicleno);
					status=ps.executeUpdate();
					break;			
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	
	public static ArrayList GetUserDetails()
	{
		ArrayList<User> userlist=new ArrayList<User>();
		
		try
		{
			Connection con=VehicleDAO.GetConnection();
			PreparedStatement ps=con.prepareStatement("select * from userdetails");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				User u=new User();
				u.setEmployeeid(rs.getString(1));
				u.setFirstname(rs.getString(2));
				u.setLastname(rs.getString(3));
				u.setAge(rs.getInt(4));
				u.setGender(rs.getString(5));
				u.setPhone(Long.parseLong(rs.getString(6)));
				u.setEmailid(rs.getString(7));
				u.setBranch(rs.getString(9));
				userlist.add(u);
			}
		}
		catch(Exception e)
		{
			System.out.println("Errorr in getting userdetails "+e);
		}
		return userlist;
	}

}
