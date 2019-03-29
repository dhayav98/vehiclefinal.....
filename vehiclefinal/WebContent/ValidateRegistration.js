function validate()                                    
{ 

	var empid=document.getElementById('employeeid').value;
	 var fn=document.getElementById('firstname').value;
	 var lname=document.getElementById('lastname').value;
	 var age=document.getElementById('empage').value;
	 var phone=document.getElementById('empcontact').value;
	var email=document.getElementById('empemail').value;
	var password=document.getElementById('emppassword').value;
	var branch=document.getElementById('empbranch').value;
	 if(empid=="")
	    {
	    	alert('Please Enter Employee id');
	        document.getElementById('employeeid').style.borderColor = "red";
	        
	        return false;
	    }
	  
	    if(fn == ""){
	        alert('Please Enter First Name');
	        document.getElementById('firstname').style.borderColor = "red";
	        return false;
	    }
	    if (lname== "")                                  
	    { 
	        window.alert("Please enter your last name."); 
	        document.getElementById('lastname').style.borderColor = "red";
	     
	        return false; 
	    } 
	    if (age== "")                           
	    { 
	        window.alert("Please enter your age."); 
	        document.getElementById('empage').style.borderColor = "red";
	        
	        return false; 
	    } 
	   if (phone== "")                           
	    { 
	        window.alert("Please enter your telephone number."); 
	        document.getElementById('empcontact').style.borderColor = "red";
	        
	        return false; 
	    } 
	   if (email== "")                                   
	    { 
	        window.alert("Please enter a valid e-mail address."); 
	        document.getElementById('empemail').style.borderColor = "red";
	        email.focus(); 
	        return false; 
	    } 
	   if (email.indexOf("@", 0) < 0)                 
	    { 
	        window.alert("Please enter a valid e-mail address."); 
	        document.getElementById('empemail').style.borderColor = "red";
	        return false; 
	    } 
	   if (password == "")                        
	    { 
	        window.alert("Please enter your password"); 
	        document.getElementById('emppassword').style.borderColor = "red";
	        return flase; 
	    } 
	   if (branch == "")                        
	    { 
	        window.alert("Please enter your branch"); 
	        document.getElementById('empbranch').style.borderColor = "red";
	        return flase; 
	    } 
	    return true;
}