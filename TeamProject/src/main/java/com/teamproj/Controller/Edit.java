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

public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
		if(request.getParameter("submit")!=null) {
		System.out.println("Edit Success");	
		String name=request.getParameter("name");
    	String password=request.getParameter("pwd");
    	String email=request.getParameter("email");
    	int userid=Integer.parseInt(request.getParameter("userid"));
    	String phone=request.getParameter("phone");
    	String utype=request.getParameter("utype");
    	String sec=request.getParameter("sec");
    	String ans=request.getParameter("ans");
    	System.out.println("Admin Panel Edited Data LOG: "+name+password+email+userid+phone+sec+ans);
		User user=new User();
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		user.setUtype(utype);
		user.setSec(sec);
		user.setAns(ans);
		user.setUserid(userid);	
		UserDao userdao=new UserDao();
		User status=userdao.EditProfile(user);
			System.out.println("Success Update");
 	    	request.setAttribute("msg", "Successfully Updated Profile Data!");
 			RequestDispatcher rd1=request.getRequestDispatcher("UserList?pgno=1"); 
 	 	    rd1.forward(request, response);
		}	 	
		else if(request.getParameter("submit")==null) {
			int userid=Integer.parseInt(request.getParameter("userid"));
			UserDao userdao=new UserDao();
			User getUser=userdao.getUser(userid);
			request.setAttribute("userid", getUser.getUserid());
			request.setAttribute("name", getUser.getName());
			request.setAttribute("password", getUser.getPassword());
			request.setAttribute("email", getUser.getEmail());
			request.setAttribute("phone", getUser.getPhone());
			request.setAttribute("utype", getUser.getUtype());
			request.setAttribute("sec", getUser.getSec());
			request.setAttribute("ans", getUser.getAns());
 			RequestDispatcher rd1=request.getRequestDispatcher("adminedit.jsp"); 
 	 	    rd1.forward(request, response);
    	}
		else {
			System.out.println("Please Login Admin");
 	    	request.setAttribute("msg", "Session not set, do login!");
 			RequestDispatcher rd1=request.getRequestDispatcher("login.jsp"); 
 	 	    rd1.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
