package com.teamproj.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.teamproj.Model.User;
import com.tramproj.DAO.UserDao;

public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("pwd");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String sec=request.getParameter("sec");
		String ans=request.getParameter("ans");

		User user=new User();
		user.setUserid(0);
		user.setName(name);
		user.setEmail(email);
		user.setUtype("USER");
		user.setPassword(password);
		user.setPhone(phone);
		user.setSec(sec);
		user.setAns(ans);
	    PrintWriter out=response.getWriter();
		String act=request.getParameter("button");
		request.setAttribute("act", act);
		request.setAttribute("user", user);
		RequestDispatcher rd=request.getRequestDispatcher("UserDao"); 
 	    rd.include(request, response);
		
 	    UserDao userdao=new UserDao();
 	    int status=userdao.register(user);
 	    if(status==1) {
 	    	request.setAttribute("username", name);
 	    	request.setAttribute("msg", "Successfully Registered! Welcome");
 			RequestDispatcher rd1=request.getRequestDispatcher("login.jsp"); 
 	 	    rd1.forward(request, response);
 	    } 
 	    else if(status==2) {
 	    	request.setAttribute("msg", "Email already Exists");
 			RequestDispatcher rd1=request.getRequestDispatcher("register.jsp"); 
 	 	    rd1.forward(request, response);
 	    }
 	    else {
 	    	request.setAttribute("msg", "Invalid Password or Email");
 			RequestDispatcher rd1=request.getRequestDispatcher("register.jsp"); 
 	 	    rd1.forward(request, response);
 	    }
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.getWriter().append("What are you doing here? BAD NOTTY");
	}

}
