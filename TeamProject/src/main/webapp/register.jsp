<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
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

    select {
        -webkit-appearance: none;
        -moz-appearance: none;
        -ms-appearance: none;
        appearance: none;
        outline: 0;
        background: #f1f1f1;
        background-image: none;
        border: 1px solid black;
        padding: 15px;
    	margin: 5px 0 22px 0;
    	display: inline-block;
    }
     
    .select {
        position: relative;
        display: block;
        width: 20em;
        height: 3em;
        line-height: 3;
        background: #2C3E50;
        overflow: hidden;
        border-radius: .25em;
    }
     
    select {
        width: 100%;
        height: 100%;
        padding: 0 0 0 .5em;
        color: black;
        cursor: pointer;
        padding: 15px;
    	margin: 5px 0 22px 0;
    	display: inline-block;
    }
     
    select::-ms-expand {
        display: none;
        padding: 15px;
    	margin: 5px 0 22px 0;
    	display: inline-block;
    }
     
    .select::after {
        content: '\25BC';
        position: absolute;
        top: 0;
        right: 0;
        bottom: 0;
        padding: 0 1em;
        background: #34495E;
        pointer-events: none;
        padding: 15px;
   		 margin: 5px 0 22px 0;
    	display: inline-block;
    }
     
    .select:hover::after {
        color: #F39C12;
    }
     
    <!-- For different browsers --> .select::after {
        -webkit-transition: .25s all ease;
        -o-transition: .25s all ease;
        transition: .25s all ease;
            padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    }
    
</style>
</head>
<body>
<form style="margin: 0 auto; width: 50%;" method="post" action="RegisterController">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    
    <% if(request.getAttribute("msg") != null) 
    	out.println("<div style=\"background: #ddd; padding: 10px;\"><p style=\"color: red\">"+request.getAttribute("msg")+"</p></div>");
    %>
    
    <hr>
    <label for="name"><b>NAME</b></label>
    <input type="text" placeholder="Enter Name" name="name" id="name" required>

    <label for="pwd"><b>PASSWORD</b></label>
    <input type="password" placeholder="Enter Password" name="pwd" id="pwd" required>

    <label for="email"><b>EMAIL</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" required>
    
    <label for="email"><b>PHONE</b></label>
    <input type="text" placeholder="Enter PHONE No." size=10 name="phone" id="phone" required>

    <label for="sec"><b>SECURITY QUESTION</b></label>
    <select id="sec" name="sec">
    	<option value="WHAT IS YOUR MOTHER NAME">WHAT IS YOUR MOTHER NAME?</option>
    	<option value="WHAT IS YOUR BIRTHPLACE">WHAT IS YOUR BIRTHPLACE?</option>
    	<option value="WHERE IS YOUR HOME LOCATED">WHERE IS YOUR HOME LOCATED?</option>
    </select>
    <br>
    <label for="ans"><b>ANSWER</b></label>
    <input type="text" placeholder="Enter Security Answer" name="ans" id="ans" required>
    <hr>

    <button type="submit" class="registerbtn" name="button" value="register">Register</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="login.jsp">Sign in</a>.</p>
  </div>
</form>
</body>
</html>