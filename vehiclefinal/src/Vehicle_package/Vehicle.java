package Vehicle_package;
import java.sql.Date;

public class Vehicle 
{
	private String vehicleno;
	private String branch;
	private String vehicletype;
	public String insurance_expiry;
	public String service_due_date;
	public String last_serviced_date;
	public String getVehicleno() 
	{
		return vehicleno;
	}
	public void setVehicleno(String vehicleno) 
	{
		this.vehicleno = vehicleno;
	}
	public String getBranch() 
	{
		return branch;
	}
	public void setBranch(String branch) 
	{
		this.branch = branch;
	}
	public String getVehicletype() 
	{
		return vehicletype;
	}
	public void setVehicletype(String vehicletype)
	{
		this.vehicletype = vehicletype;
	}
	public String getInsurance_expiry()
	{
		return insurance_expiry;
	}
	public void setInsurance_expiry(String insurance_expiry) 
	{
		this.insurance_expiry = insurance_expiry;
	}
	public String getService_due_date() 
	{
		return service_due_date;
	}
	public void setService_due_date(String service_due_date) 
	{
		this.service_due_date = service_due_date;
	}
	public String getLast_serviced_date()
	{
		return last_serviced_date;
	}
	public void setLast_serviced_date(String last_serviced_date)
	{
		this.last_serviced_date = last_serviced_date;
	}
	
	
}
