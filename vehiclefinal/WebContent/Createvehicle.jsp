<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="loginstyle.css">
<script>
function validate1()                                    
{ 

	var vno=document.getElementById('vno').value;
	 var vtype=document.getElementById('vtype').value;
	 var branch=document.getElementById('branch').value;
	 var insurance=document.getElementById('insurance').value;
	 var lastserviceddate=document.getElementById('lastserviceddate').value;
	var serviceduedate=document.getElementById('serviceduedate').value;
	
	 if(vno=="")
	    {
	    	alert('Please Enter vehicle number');
	        document.getElementById('vno').style.borderColor = "red";
	        
	        return false;
	    }
	  
	    if(vtype == ""){
	        alert('Please Enter vehicle type');
	        document.getElementById('vtype').style.borderColor = "red";
	        return false;
	    }
	    if (branch== "")                                  
	    { 
	        window.alert("Please enter branch."); 
	        document.getElementById('branch').style.borderColor = "red";
	     
	        return false; 
	    } 
	    if((insurance== "") || (!insurance.match("[0-9]{4}[-][0-9]{2}[-][0-9]{2}")))                      
	    { 
	        window.alert("Please enter insturance date."); 
	        document.getElementById('insurance').style.borderColor = "red";
	        return false; 
	    } 
	    if((lastserviceddate== "") || (!lastserviceddate.match("[0-9]{4}[-][0-9]{2}[-][0-9]{2}")))                              
	    { 
	        window.alert("Please enter your last service ddate."); 
	        document.getElementById('lastserviceddate').style.borderColor = "red";
	        
	        return false; 
	    } 
	    if((serviceduedate== "") || (!serviceduedate.match("[0-9]{4}[-][0-9]{2}[-][0-9]{2}")))                                
	    { 
	        window.alert("Please enter the service due date."); 
	        document.getElementById('serviceduedate').style.borderColor = "red";
	        email.focus(); 
	        return false; 
	    } 
	   
	    return true;
}
</script>
</head>
<body class="bodystyle">

<div class="form-group required">
<h1 style="text-align:center;"> VEHICLE REGISTRATION</h1>
<form name="Registration" id="loginform"  action="Createvehicle" onsubmit="return validate1(this)"  method="post">

<label class='control-label'>Vehicle No</label><input type="text" maxlength="10" class="input" placeholder="Vehicle No" name="vno" id="vno"  /><br>

<label class='control-label'>Branch</label><input type="text" maxlength="5" class="input" placeholder="Branch" name="branch" id="branch"/><br>

<label class='control-label'>Vehicle Type</label><input type="text" maxlength="15" class="input" placeholder="Vehicle Type" name="vtype" id="vtype"/><br>

<label class='control-label' >Insurance Expiry date(yyyy-mm-dd)</label><input type="text" maxlength="10" class="input" placeholder="Insurance Expiry date" name="insurance" id="insurance"/><br>

<label class='control-label' >Last Serviced Date(yyyy-mm-dd)</label><input type="text" maxlength="10" class="input" placeholder="Last Serviced Date" name="lastserviceddate" id="lastserviceddate"/><br>

<label class='control-label' >Service Due date(yyyy-mm-dd)</label><input type="text" maxlength="10" class="input" placeholder="Service Due date" name="serviceduedate" id="serviceduedate"/><br>

<input type="submit" class="loginbutton" value="Register" name="register" >
</form>
</div>
</body>
</html>