package com.teamproj.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     HttpSession session = request.getSession();
	     	if(session.getAttribute("name")==null) {
		    	request.setAttribute("msg", "You need to be logged in to perform this action!");
				RequestDispatcher rd1=request.getRequestDispatcher("login.jsp"); 
		 	    rd1.forward(request, response);	
	     	}
	     	else if(session!=null) {
	        	session.invalidate();
		    	request.setAttribute("msg", "Logged Out!");
				RequestDispatcher rd1=request.getRequestDispatcher("login.jsp"); 
		 	    rd1.forward(request, response);
	        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
