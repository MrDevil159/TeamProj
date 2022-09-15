package com.tramproj.DAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teamproj.Model.User;

public class UserDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("What are you doing here? BAD NOTTY");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	static Connection con;
	static PreparedStatement stmt;
	static ResultSet rs;
		
	public static void connection() throws Exception, SQLException, ServletException 
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		
	}


	public int register(User user) {
		try {
			connection();
			PreparedStatement fetchlastid=con.prepareStatement("SELECT MAX(USERID) FROM USERSDATA");
			ResultSet oldid=fetchlastid.executeQuery();
			
			oldid.next();
			int oldfetchedid=oldid.getInt(1);
			int id;
			if(oldfetchedid==0) {
				id=1000;
			} else {
				id=oldfetchedid+1;
			}
			int userid=id;
			String name=user.getName();
			String password=user.getPassword();
			String email=user.getEmail();
			String phone=user.getPhone();
			String sec=user.getSec();
			String ans=user.getAns();
			String utype=user.getUtype();
			System.out.println("LOG"+name+" "+password+" "+email+" "+phone+" "+sec+" "+ans+" "+utype+" "+userid);
			PreparedStatement register=con.prepareStatement("Insert into USERSDATA (USERID,NAME,PASSWORD,EMAIL,PHONE,UTYPE,SEC,ANS) values (?,?,?,?,?,?,?,?)");
			register.setInt(1, userid);
			register.setString(2, name);
			register.setString(3, password);
			register.setString(4, email);
			register.setString(5, phone);
			register.setString(6, utype);
			register.setString(7, sec);
			register.setString(8, ans);
			int result = register.executeUpdate();
			System.out.println("RegisterController Result Value="+result);
			if(result>0) {
				return 1;
			}
			else {	
				return 0;
			}
		} 
		catch(SQLException e) { 
			if(e.getErrorCode()==00001) {
				return 2;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public User login(User user) {
		try {
			connection();
			String email=user.getEmail();
			String password=user.getPassword();
			PreparedStatement exist=con.prepareStatement("select COUNT(*) from USERSDATA WHERE EMAIL=? AND PASSWORD=?");
			exist.setString(2, password);
			exist.setString(1,email);
			ResultSet existvalue=exist.executeQuery();
			existvalue.next();
			int exists=existvalue.getInt(1);
			
			if(exists==1) {
				PreparedStatement logindetails=con.prepareStatement("select USERID ,NAME, PHONE,UTYPE, SEC, ANS from USERSDATA WHERE EMAIL=? AND PASSWORD=?");
				logindetails.setString(2, password);
				logindetails.setString(1,email);
				ResultSet details=logindetails.executeQuery();
				if(details.next()){
		 	    	user.setUserid(details.getInt(1));
		 	    	user.setName(details.getString(2));
		 	    	user.setPhone(details.getString(3));
		 	    	user.setUtype(details.getString(4));
		 	    	user.setSec(details.getString(5));
		 	    	user.setAns(details.getString(6));
		 	    	System.out.println("LOGIN DETAILS: "+email+password+details.getInt(1)+details.getString(2)+details.getString(3)+details.getString(4)+details.getString(5)+details.getString(6));
		 	    	return user;
	            }				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	
	public User EditProfile(User user) {
		try {
			connection();
			PreparedStatement update=null;
			String name=user.getName();
			String password=user.getPassword();
			String email=user.getEmail();
			String phone=user.getPhone();
			String sec=user.getSec();
			String ans=user.getAns();
			String utype=user.getUtype();
			int userid=user.getUserid();
			System.out.println(utype);
			if(utype!=null) {
				update=con.prepareStatement("UPDATE USERSDATA SET NAME=?, PASSWORD=?, EMAIL=?, PHONE=?, SEC=?, ANS=?, UTYPE=? WHERE USERID=?");
				update.setString(7, utype);
				update.setInt(8, userid);
			}
			else {
				update=con.prepareStatement("UPDATE USERSDATA SET NAME=?, PASSWORD=?, EMAIL=?, PHONE=?, SEC=?, ANS=? WHERE USERID=?");
				update.setInt(7, userid);
			}
			update.setString(1, name);
			update.setString(2, password);
			update.setString(3, email);
			update.setString(4, phone);
			update.setString(5, sec);
			update.setString(6, ans);

			int done=update.executeUpdate();
			System.out.println("Doneval"+done);
			if(done==1) {
				user.setAns(ans);
				user.setEmail(email);
				user.setName(name);
				user.setPassword(password);
				user.setPhone(phone);
				user.setSec(sec);
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String forgetPass(User user) {
		try {
			connection();
			String email=user.getEmail();
			String sec=user.getSec();
			String ans=user.getAns();
			PreparedStatement exists=con.prepareStatement("SELECT COUNT(*) FROM USERSDATA WHERE (EMAIL=? AND SEC=? AND ANS=?)");
			exists.setString(1, email);
			exists.setString(2, sec);
			exists.setString(3, ans);
			ResultSet exist=exists.executeQuery();
			exist.next();
			int existval=exist.getInt(1);
			if(existval==1) {
				PreparedStatement password=con.prepareStatement("SELECT PASSWORD FROM USERSDATA WHERE (EMAIL=? AND SEC=? AND ANS=?)");
				password.setString(1, email);
				password.setString(2, sec);
				password.setString(3, ans);
				ResultSet pass=password.executeQuery();
				pass.next();
				String getpass=pass.getString(1);
				return getpass;
			}
			else {
				return null;
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	public List<User> selectAllUsers(int pgno)  {
	
		List<User> allusers = new ArrayList<>();
		try {
			connection();
			PreparedStatement count = con.prepareStatement("SELECT COUNT(*) FROM USERSDATA");
			ResultSet cou=count.executeQuery();
			cou.next();
			double max=cou.getDouble(1);
			max=max/5;
	        max=Math.ceil(max);
	        int top=(int)max;
	        System.out.println(top);
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM USERSDATA where USERID between ? and ? order by USERID asc");
			int first=1000+(pgno-1)*5;
			int limit=1000+(pgno)*5;
			System.out.println("SELECT * FROM USERSDATA where rownum between "+first+" and "+limit+" order by USERID asc");

			preparedStatement.setInt(1, first);
			preparedStatement.setInt(2, limit);;
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name=rs.getString("name");
				String password=rs.getString("password");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				String sec=rs.getString("sec");
				String ans=rs.getString("ans");
				String utype=rs.getString("utype");
				int userid=rs.getInt("userid");
				
				allusers.add(new User(userid, name, password, email, phone, utype, sec, ans));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allusers;
	}
	public User getUser(int userid) {
		try {
			connection();
			PreparedStatement get = con.prepareStatement("SELECT * FROM USERSDATA WHERE userid=?");
			get.setInt(1, userid);
			ResultSet uservals=get.executeQuery();
			uservals.next();
			User user=new User();
	 	    	user.setUserid(uservals.getInt(1));
	 	    	user.setName(uservals.getString(2));
	 	    	user.setPassword(uservals.getString(3));
	 	    	user.setEmail(uservals.getString(4));
	 	    	user.setPhone(uservals.getString(5));
	 	    	user.setUtype(uservals.getString(6));
	 	    	user.setSec(uservals.getString(7));
	 	    	user.setAns(uservals.getString(8));
			return user;
			
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ServletException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
		return null;
	}
}