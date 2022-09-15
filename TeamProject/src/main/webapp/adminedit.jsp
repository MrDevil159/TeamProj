<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    if(session.getAttribute("utype").equals("ADMIN")==false) {
	    	request.setAttribute("msg", "Please login to perform this action!");
			RequestDispatcher rd1=request.getRequestDispatcher("login.jsp"); 
	 	    rd1.forward(request, response);
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
<style>
@import url(https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800);
@import url(https://fonts.googleapis.com/css?family=Droid+Sans:400,700);
@import "//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css";
*, *:before, *:after {
  box-sizing: border-box;
}

body {
  font-size: 100%;
  font-family: 'Open Sans', sans-serif;
  background-color: #212121;
}

.wrapper {
  max-width: 500px;
  margin: 3rem auto;
  background: #eceff1;
  padding: 0 0 1rem;
  position: relative;
}

.form-header {
  background: #fff;
  text-align: center;
  font-size: 1.25rem;
  font-weight: 600;
  color: #212121;
  padding: 1rem;
  margin: 0 0 1rem;
  position: relative;
}
.form-header .close {
  position: absolute;
  right: 1rem;
  top: 1.25rem;
  color: #cfd6db;
  cursor: pointer;
  transition: color .2s ease;
}
.form-header .close:hover {
  color: #212121;
}

.form-grp {
  margin: 0 2rem 1rem;
}
.form-grp label {
  display: block;
  margin: 0 0 .5rem;
  font-weight: 700;
  letter-spacing: .2px;
  font-size: .875rem;
  color: #212121;
}
.form-grp label.inline {
  display: inline-block;
  width: 100px;
}
.form-grp label.inline.right {
  text-align: right;
  padding-right: .5rem;
}

input[type="text"],
input[type="email"],
input[type="password"] {
  padding: 0.75rem 0.875rem;
  border-radius: 4px;
  outline: 0;
  color: #212121;
  font-size: .875rem;
  width: 100%;
  border: 0.063rem solid #b0bec5;
}

input[type="submit"] {
  padding: 0.75rem 1.5rem;
  margin: .5rem 0 0;
  outline: 0;
  border: 0;
  background: #2196f3;
  border-radius: 4px;
  color: #FFF;
  font-weight: 700;
  font-size: .875rem;
  letter-spacing: .25px;
  transition: background .3s ease;
}
input[type="submit"]:hover {
  background: #39a1f4;
}


    select {
        -webkit-appearance: none;
        -moz-appearance: none;
        -ms-appearance: none;
        appearance: none;
        outline: 0;
        background: #f1f1f1;
        background-image: none;
        border: 0.063rem solid #b0bec5;;
        padding: 15px;
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
        color: #212121;
        cursor: pointer;
        padding: 15px;
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

<form class="wrapper" method="post" action="Edit">

  <div class="form-header">Edit Profile</div>
  
         <% if(request.getAttribute("msg") != null) {
    		out.println("<label><div style=\"background: #ddd; padding: 10px;\"><p style=\"color: red\">"+request.getAttribute("msg")+"</p></div></label>");
        	}
        %> 


    <input type="hidden" name="userid" value="<%= request.getAttribute("userid") %>" placeholder="Enter UserID" />

  <div class="form-grp">
    <label>Full name</label>
    <input type="text" name="name" value="<%= request.getAttribute("name") %>" placeholder="Enter Full name"/>
  </div>
  
  
  <div class="form-grp">
    <label>Email</label>
    <input type="text" name="email" value="<%= request.getAttribute("email") %>" placeholder="Enter Email"/>
  </div>
  
    <div class="form-grp">
    <label>Password</label>
    <input type="password" name="pwd" value="<%= request.getAttribute("password") %>" placeholder="Enter Password"/>
  </div>
  
  <div class="form-grp">
    <label>Phone</label>
    <input type="text" name="phone" value="<%= request.getAttribute("phone") %>" placeholder="Phone No."/>
  </div>
  <div class="form-grp">
    <label>User Type</label>
        <select id="utype" name="utype">
<% if (request.getAttribute("utype").equals("AUTHOR")) {
		out.println("<option value=\"AUTHOR\" selected>AUTHOR</option>");
	}
	else if(request.getAttribute("utype").equals("USER")) {
		out.println("<option value=\"USER\" selected>USER</option>");
	}
	else {
		out.println("<option value=\"ADMIN\" selected>ADMIN</option>");
	}
%>

    	<option value="USER">USER</option>
    	<option value="AUTHOR">AUTHOR</option>
    	<option value="ADMIN">ADMIN</option>
    </select>
  </div>
    <div class="form-grp">
    <label>Security Question</label>
    <select id="sec" name="sec">
    	<option value="WHAT IS YOUR MOTHER NAME">WHAT IS YOUR MOTHER NAME?</option>
    	<option value="WHAT IS YOUR BIRTHPLACE">WHAT IS YOUR BIRTHPLACE?</option>
    	<option value="WHERE IS YOUR HOME LOCATED">WHERE IS YOUR HOME LOCATED?</option>
    </select>
  </div>

  <div class="form-grp">
    <label>Answer</label>
    <input type="text" name="ans" value="<%= request.getAttribute("ans") %>" placeholder="Answer"/>
  </div>
  
  
  <div class="form-grp">
    <input type="submit" name="submit" value="Update"/>
    <a href="home.jsp" style="padding: 0.75rem 1.5rem;margin: 0.5rem 0 0;outline: 0;border: 0;background: #2196f3;border-radius: 4px;color: #FFF;
    font-weight: 700;font-size: .875rem;float: right;letter-spacing: .25px;transition: background .3s ease;">Go Back</a>
    
  </div>
</form>
</body>
</html>