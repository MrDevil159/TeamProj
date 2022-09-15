<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.tramproj.DAO.*"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

    <%@page import="java.sql.PreparedStatement"%>
        <%@page import="java.sql.ResultSet"%>
                <%@page import="java.sql.DriverManager"%>
                                <%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users List</title>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
PreparedStatement count = con.prepareStatement("SELECT COUNT(*) FROM USERSDATA");
ResultSet cou=count.executeQuery();
cou.next();
double max=cou.getDouble(1);
max=max/5;
max=Math.ceil(max);
int top=(int)max;
%>
<style>
table {
  border: 1px solid #ccc;
  border-collapse: collapse;
  margin: 0;
  padding: 0;
  width: 100%;
  table-layout: fixed;
}

table caption {
  font-size: 1.5em;
  margin: .5em 0 .75em;
}

table tr {
  background-color: #f8f8f8;
  border: 1px solid #ddd;
  padding: .35em;
}

table th,
table td {
  padding: .625em;
  text-align: center;
}

table th {
  font-size: .85em;
  letter-spacing: .1em;
  text-transform: uppercase;
}

@media screen and (max-width: 600px) {
  table {
    border: 0;
  }

  table caption {
    font-size: 1.3em;
  }
  
  table thead {
    border: none;
    clip: rect(0 0 0 0);
    height: 1px;
    margin: -1px;
    overflow: hidden;
    padding: 0;
    position: absolute;
    width: 1px;
  }
  
  table tr {
    border-bottom: 3px solid #ddd;
    display: block;
    margin-bottom: .625em;
  }
  
  table td {
    border-bottom: 1px solid #ddd;
    display: block;
    font-size: .8em;
    text-align: right;
  }
  
  table td::before {
    /*
    * aria-label has no advantage, it won't be read inside a table
    content: attr(aria-label);
    */
    content: attr(data-label);
    float: left;
    font-weight: bold;
    text-transform: uppercase;
  }
  
  table td:last-child {
    border-bottom: 0;
  }
}














/* general styling */
body {
  font-family: "Open Sans", sans-serif;
  line-height: 1.25;
}
</style>
</head>
<body>
        <% 
        if(request.getAttribute("msg") != null) {
    		out.println("<div style=\"background: #ddd; padding: 10px;\"><p style=\"color: red\">"+request.getAttribute("msg")+"</p></div>");
        	}

    %>
<table>
  <caption>User List</caption>
				<thead>
					<tr>
						<th scope="col">USERID</th>
						<th scope="col">NAME</th>
						<th scope="col">PASSWORD</th>
						<th scope="col">EMAIL</th>
						<th scope="col">PHONE</th>
						<th scope="col">UTYPE</th>
						<th scope="col">SEC</th>
						<th scope="col">ANS</th>
						<th scope="col">ACTION</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="users" items="${users}">

						<tr>
							<td><c:out value="${users.userid}" /></td>
							<td><c:out value="${users.name}" /></td>
							<td><c:out value="${users.password}" /></td>
							<td><c:out value="${users.email}" /></td>
							<td><c:out value="${users.phone}" /></td>
							<td><c:out value="${users.utype}" /></td>
							<td><c:out value="${users.sec}" /></td>
							<td><c:out value="${users.ans}" /></td>
					
							<td><a href="Edit?userid=<c:out value='${users.userid}' />">Edit</a>
								</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
<center>
			<% 
			int i=1;
			while(i<=top) {
				out.print("|<a href=\"UserList?pgno="+i+"\"> PG"+i+" </a>|");
				i=i+1;
			}
			
			%>
			</center>
</body>
</html>