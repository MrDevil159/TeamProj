package com.teamproj.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.teamproj.Model.User;
import com.tramproj.DAO.UserDao;

public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String sec=request.getParameter("sec");
		String ans=request.getParameter("ans");
		User user=new User();
		user.setEmail(email);
		user.setSec(sec);
		user.setAns(ans);
		UserDao userdao=new UserDao();
 	    String status=userdao.forgetPass(user);
 	    if(status!=null) {
 	    		request.setAttribute("msg", "Your Password is");
 	    		request.setAttribute("password", status);
	    		request.setAttribute("taketologin", "Take me to login page!");
 	    		RequestDispatcher rd=request.getRequestDispatcher("forgetpassword.jsp");
 	    		rd.forward(request, response);
 	    } else {
	    		request.setAttribute("msg", "Error, Combination doesn't exist!");
	    		RequestDispatcher rd=request.getRequestDispatcher("forgetpassword.jsp");
	    		rd.forward(request, response);
 	    }

	}
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("What are you doing here? BAD NOTTY");
	}

}
