<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update vehicle</title>
<link rel="stylesheet" href="loginstyle.css">
<link rel="stylesheet" href="menubar.css">
<script type="text/javascript">
function update1()
{
	var url="Branch.jsp";
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
		req.onreadystatechange=function()
		{
			if(req.readyState==4)
		{
			var val=req.responseText;
			document.getElementById("updateajax").innerHTML=val;
		}
	}
	req.open("GET",url,true);
	req.send();
	}
	catch(e)
	{	
		alert("Unable to connect Server");
	}
}
function update2()
{
	
	var url="Vehicletype.jsp";
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
		req.onreadystatechange=function()
		{
			if(req.readyState==4)
		{
			var val=req.responseText;
			document.getElementById("updateajax").innerHTML=val;
		}
	}
	req.open("GET",url,true);
	req.send();
	}
	catch(e)
	{	
		alert("Unable to connect Server");
	}
}
function update3()
{
	var url="Insuranceupdate.jsp";
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
		req.onreadystatechange=function()
		{
			if(req.readyState==4)
		{
			var val=req.responseText;
			document.getElementById("updateajax").innerHTML=val;
		}
	}
	req.open("GET",url,true);
	req.send();
	}
	catch(e)
	{	
		alert("Unable to connect Server");
	}
}
function update4()
{
	
	var url="Serviceupdate.jsp";
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
		req.onreadystatechange=function()
		{
			if(req.readyState==4)
		{
			var val=req.responseText;
			document.getElementById("updateajax").innerHTML=val;
		}
	}
	req.open("GET",url,true);
	req.send();
	}
	catch(e)
	{	
		alert("Unable to connect Server");
	}
}
function update5()
{
	var c1=document.getElementById("")
	var url="Servicedueupdate.jsp";
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
		req.onreadystatechange=function()
		{
			if(req.readyState==4)
		{
			var val=req.responseText;
			document.getElementById("updateajax").innerHTML=val;
		}
	}
	req.open("GET",url,true);
	req.send();
	}
	catch(e)
	{	
		alert("Unable to connect Server");
	}
}
function disp()
{
	var url="Displayvehicle";
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
		req.onreadystatechange=function()
		{
			if(req.readyState==4)
		{
			var val=req.responseText;
			document.getElementById("id1").innerHTML=val;
		}
	}
	req.open("GET",url,true);
	req.send();
	}
	catch(e) 
	{	
		alert("Unable to connect Server");
	}
}
</script>
</head>
<body class="bodystyle">
<% 
String vehicleno=request.getParameter("vno");
application.setAttribute("vno",vehicleno);
%>

<br>
<ul>
  <li ><a class="active" href="login.jsp">logout</a></li>
  <li ><a class="active" href="Searchvehicle.jsp">search</a></li>
  <li ><a class="active" href="Dispupdate">Update</a></li>
</ul>
<div class="form-group required">
<form action="Updatevehicle" method="post">
<br><h2>Vehicle Number : <%=vehicleno %></h2>
<br><h2>Select the field to be updated :</h2>
<group class="inline-radio">

<input type="radio"  name="choice" value="1" onClick='update1()' id="choice1"> <label class="updatelabel" for="choice1" >Branch</label>
<input type="radio"  name="choice" value="2" onClick='update2()' id="choice2"> <label  class="updatelabel" for="choice2">Vehicle Type</label>
<input type="radio"  name="choice" value="3" onClick='update3()' id="choice3"> <label class="updatelabel">Insurance Expiry</label>
<input type="radio"  name="choice" value="4" onClick='update4()' id="choice4"> <label class="updatelabel">Last Serviced Date</label>
<input type="radio"  name="choice" value="5" onClick='update5()' id="choice5"> <label  for="5" class="updatelabel" >Service Due Date</label>

</group>
<br>
<h2 id="updateajax"></h2>
<input type="text" class="inputmanipulate"  name="date">
<br><input type="submit" class="updatebutton" value="Submit" >
</form>
<h2>To View Updated details</h2>
<input type="button" class="updatebutton" onclick="disp()" value="Display" >
<span id="id1"></span>
</div>
</body>
</html>