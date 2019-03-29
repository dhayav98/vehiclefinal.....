<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="loginstyle.css">

<script type="text/javascript" src="ValidateRegistration.js"></script> 

<title>Admin Registration</title>

</head>

<body class="bodystyle">

<div class="form-group required">

<h1 style="text-align:center;">  ADMIN REGISTRATION</h1>

<form name="Registration" id="loginform"  action="Registration" onsubmit="return validate(this)"  method="post">

<label class='control-label'>Employee ID</label><input type="text" maxlength="6" class="input" placeholder="Employee ID" name="empid" id="employeeid"  /><br>

<label class='control-label'>First Name</label><input type="text" maxlength="50" class="input" placeholder="First Name" name="fname" id="firstname"/><br>

<label class='control-label'>Last Name</label><input type="text" maxlength="50" class="input" placeholder="Last Name" name="lname" id="lastname"/><br>

<label class='control-label' > Age</label><input type="number" maxlength="2" SIZE="2"class="input" placeholder="Age" name="age" id="empage"/><br>

<label class='control-label'>Gender</label><select class="input dropdown1" name="gender">

                                    <option value="Male">Male</option>

                                    <option value="Female">Female</option>

                                    </select><br>

<label class='control-label'>Contact Number</label><input type="text" maxlength="10" class="input" placeholder="Contact Number" name="contact" id="empcontact"/><br>

<label class='control-label'>Email ID</label><input type="text" maxlength="50" class="input" placeholder="Email ID" name="email" id="empemail"/><br>

<label class='control-label'>Password</label><input type="password" maxlength="15" class="input" placeholder="Password" name="password" id="emppassword"/><br>

<label class='control-label'>Branch</label><input type="text" maxlength="5" class="input" placeholder="Branch" name="branch" id="empbranch"/><br>

<input type="submit" class="loginbutton"  value="SIGN UP"  /><br>

</form>

 
</div>
</body>

</html>