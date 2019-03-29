<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Vehicle</title>
<link rel="stylesheet" href="loginstyle.css">
<link rel="stylesheet" href="menubar.css">
<script>
var req;
function search()
{
	
	var vchoice=document.form1.choice.value;
	var vsearch=document.form1.data.value;

	var url="Searchvehicle1?choice="+vchoice+"&data="+vsearch;
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
		req.onreadystatechange=function()
		{
			if(req.readyState==4)
		{
			var val=req.responseText;
			document.getElementById("id3").innerHTML=val;
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
<br>
<ul>
  <li ><a class="active" href="login.jsp">logout</a></li>
  <li ><a class="active" href="Dispupdate">Update</a></li>
  <li ><a class="active" href="Home.jsp">Home</a></li>
</ul>
<div class="form-group required">
<form name="form1" >
<br><h2>Select the field to be searched </h2>
<group class="inline-radio">
<br><input type="radio"  name="choice" value="1"  id="choice1"> <label >Branch</label>
<br><input type="radio"  name="choice" value="2"  id="choice2"> <label >Vehicle type</label>
<br><input type="radio"  name="choice" value="3"  id="choice3"> <label >Insurance Expiry Date</label>
<br><input type="radio"  name="choice" value="4"  id="choice4"> <label >Service Due Date</label>
</group>
<br><h2>Enter the vehicle detail to be searched </h2>

<input type="text" class="inputmanipulate" name="data" >
<br>
<input type="button" class="updatebutton" onclick="search()" placeholder="search"  value="search">
</form>
<span id="id3"></span>
</div>

</body>
</html>