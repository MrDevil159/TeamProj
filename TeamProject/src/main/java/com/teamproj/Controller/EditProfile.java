package com.teamproj.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import com.teamproj.Model.User;
import com.tramproj.DAO.UserDao;


public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("submit"));
		if(request.getParameter("submit")!=null) {
	    	HttpSession session=request.getSession();
			String name=request.getParameter("name");
	    	String password=request.getParameter("pwd");
	    	String email=request.getParameter("email");
	    	int userid=(int) session.getAttribute("userid");
	    	String phone=request.getParameter("phone");
	    	String sec=request.getParameter("sec");
	    	String ans=request.getParameter("ans");
	    	System.out.println("Edited Data LOG: "+name+password+email+userid+phone+sec+ans);
			User user=new User();
			user.setName(name);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhone(phone);
			user.setSec(sec);
			user.setAns(ans);
			user.setUserid(userid);	
			UserDao userdao=new UserDao();
			User status=userdao.EditProfile(user);
	 	    	session.setAttribute("email", status.getEmail());
	 	    	session.setAttribute("password", status.getPassword());
	 	    	session.setAttribute("name", status.getName());
	 	    	session.setAttribute("phone", status.getPhone());
	 	    	session.setAttribute("sec", status.getSec());
	 	    	session.setAttribute("ans", status.getAns());
				System.out.println("Success Update");
	 	    	request.setAttribute("msg", "Successfully Updated Profile Data!");
	 			RequestDispatcher rd1=request.getRequestDispatcher("editprofile.jsp"); 
	 	 	    rd1.forward(request, response);
		}
		else if(request.getParameter("submit")==null) {   
	    	HttpSession session=request.getSession();
			String name=(String)session.getAttribute("name");
	    	String password=(String)session.getAttribute("password");
	    	String email=(String)session.getAttribute("email");
	    	int userid=(int) session.getAttribute("userid");
	    	String phone=(String)session.getAttribute("phone");
	    	String sec=(String)session.getAttribute("sec");
	    	String ans=(String)session.getAttribute("ans");
	    	System.out.println("Edit Page Session LOG: "+name+password+email+userid+phone+sec+ans);
 			RequestDispatcher rd1=request.getRequestDispatcher("editprofile.jsp"); 
 	 	    rd1.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("What are you doing here? BAD NOTTY");
	}

}
