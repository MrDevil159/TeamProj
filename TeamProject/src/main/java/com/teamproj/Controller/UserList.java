package com.teamproj.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.teamproj.Model.User;
import com.tramproj.DAO.UserDao;

public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pgnp=Integer.parseInt(request.getParameter("pgno"));
		UserDao userdao=new UserDao();
		List<User> users=userdao.selectAllUsers(pgnp);
		request.setAttribute("users", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("users.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
