<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.teamproj.Controller.LoginController"%>
    <%
    if(session.getAttribute("name")==null) {
	    	request.setAttribute("msg", "Please login to perform this action!");
			RequestDispatcher rd1=request.getRequestDispatcher("login.jsp"); 
	 	    rd1.forward(request, response);
    }
    %>
<!DOCTYPE html>
<html>
<title>Homepage</title>
<head>
    <style>
@import url(https://fonts.googleapis.com/css?family=Roboto:300,400,600);
body {
    background-color: #212121;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-flow: wrap;
    margin: 0;
    height: 100%;
}
.snip1336 {
  font-family: 'Roboto', Arial, sans-serif;
  position: relative;
  overflow: hidden;
  margin: 10px;
  min-width: 230px;
  max-width: 315px;
  width: 100%;
  color: #ffffff;
  text-align: left;
  line-height: 1.4em;
  background-color: #141414;
}
.snip1336 * {
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all 0.25s ease;
  transition: all 0.25s ease;
}
.snip1336 img {
  max-width: 100%;
  vertical-align: top;
  opacity: 0.85;
}
.snip1336 figcaption {
  width: 100%;
  background-color: #141414;
  padding: 25px;
  position: relative;
}
.snip1336 figcaption:before {
  position: absolute;
  content: '';
  bottom: 100%;
  left: 0;
  width: 0;
  height: 0;
  border-style: solid;
  border-width: 55px 0 0 400px;
  border-color: transparent transparent transparent #141414;
}
.snip1336 figcaption a {
  padding: 5px;
  border: 1px solid #ffffff;
  color: #ffffff;
  font-size: 0.7em;
  text-transform: uppercase;
  margin: 10px 0;
  display: inline-block;
  opacity: 0.65;
  width: 47%;
  text-align: center;
  text-decoration: none;
  font-weight: 600;
  letter-spacing: 1px;
}
.snip1336 figcaption a:hover {
  opacity: 1;
}
.snip1336 .profile {
  border-radius: 50%;
  position: absolute;
  bottom: 100%;
  left: 25px;
  z-index: 1;
  max-width: 90px;
  opacity: 1;
  box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
}
.snip1336 .follow {
  margin-right: 4%;
  border-color: #2980b9;
  color: #2980b9;
}
.snip1336 h2 {
  margin: 0 0 5px;
  font-weight: 300;
}
.snip1336 h2 span {
  display: block;
  font-size: 0.5em;
  color: #2980b9;
}
.snip1336 p {
  margin: 0 0 10px;
  font-size: 0.8em;
  letter-spacing: 1px;
  opacity: 0.8;
}

    </style>
<script>
/* Demo purposes only */
$(".hover").mouseleave(
  function () {
    $(this).removeClass("hover");
  }
);

</script>
</head>
<body>



<figure class="snip1336 hover"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/331810/sample74.jpg" alt="sample74" />
  <figcaption>
    <img src="https://cdn-icons-png.flaticon.com/512/21/21104.png" alt="profile-sample2" class="profile" />
    <h2><%= session.getAttribute("name") %><span><%= session.getAttribute("userid") %></span></h2>
    <p><%= session.getAttribute("email") %></p>
        <p><%= session.getAttribute("utype") %></p>
        <% 
        if(session.getAttribute("utype").equals("ADMIN"))
            out.println("<a href=\"UserList?pgno=1\" class=\"follow\">USERS</a>");
        %>
       
        
    <a href="editprofile.jsp" class="follow">Edit</a>
    <a href="Logout" class="info">Logout</a>
  </figcaption>
</figure>



</body>
</html>