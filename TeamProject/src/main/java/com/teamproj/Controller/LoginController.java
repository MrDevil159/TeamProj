package com.teamproj.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.teamproj.Model.User;
import com.tramproj.DAO.UserDao;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("pwd");
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		UserDao userdao=new UserDao();
		User status=userdao.login(user);
 	    if(status!=null) {
 	    	HttpSession session=request.getSession();
 	    	session.setAttribute("email", email);
 	    	session.setAttribute("password", password);
 	    	session.setAttribute("name", status.getName());
 	    	session.setAttribute("userid", status.getUserid());
 	    	session.setAttribute("phone", status.getPhone());
 	    	session.setAttribute("utype", status.getUtype());
 	    	session.setAttribute("sec", status.getSec());
 	    	session.setAttribute("ans", status.getAns());
 	    	
 	    	request.setAttribute("msg", "Successfully Logged In! Welcome");
 			RequestDispatcher rd1=request.getRequestDispatcher("home.jsp"); 
 	 	    rd1.forward(request, response);
 	    } 
 	    else {
 	    	request.setAttribute("msg", "Invalid Password or Email");
 			RequestDispatcher rd1=request.getRequestDispatcher("login.jsp"); 
 	 	    rd1.forward(request, response);
 	    }
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.getWriter().append("What are you doing here? BAD NOTTY");
	}

}
