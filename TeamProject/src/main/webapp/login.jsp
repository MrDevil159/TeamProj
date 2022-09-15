<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
    if(session.getAttribute("name")!=null) {
			RequestDispatcher rd1=request.getRequestDispatcher("home.jsp"); 
	 	    rd1.forward(request, response);
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}

    
</style>

</head>
<body>
<!--in form if necessary onsubmit="return validate()"-->
<form style="margin: 0 auto; width: 50%;" method="post" action="LoginController" >
  <div class="container">
    <h1>Sign In</h1>
    <p>Please fill in this form to sign in to your account.</p>
    
        <% 
        String name="";
        if(request.getAttribute("username")!=null) {
        	name=", "+request.getAttribute("username");
        }
        if(request.getAttribute("msg") != null) {
    		out.println("<div style=\"background: #ddd; padding: 10px;\"><p style=\"color: red\">"+request.getAttribute("msg")+name+"</p></div>");
        	}

    %>
    
    <hr>
    <label for="email"><b>EMAIL</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" required>

    <label for="pwd"><b>PASSWORD</b></label>
    <input type="password" placeholder="Enter Password" name="pwd" id="pwd" required>

    <hr>

    <button type="submit" class="registerbtn" name="button" value="login">Login</button>
  </div>
  
  <div class="container signin">
    <p>Dont have an account? <a href="register.jsp">Sign Up</a>.</p>
        <p>Forgot your password? <a href="forgetpassword.jsp">Click Here</a>.</p>
    
  </div>
</form>
</body>
</html>