package com.teamproj.Model;

public class User {
private int userid;
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getUtype() {
	return utype;
}
public void setUtype(String utype) {
	this.utype = utype;
}
public String getSec() {
	return sec;
}
public void setSec(String sec) {
	this.sec = sec;
}
public String getAns() {
	return ans;
}
public void setAns(String ans) {
	this.ans = ans;
}
public User() {
	super();
}
public User(int userid, String name, String password, String email, String phone, String utype, String sec, String ans) {
	super();
	this.userid = userid;
	this.name = name;
	this.password = password;
	this.email = email;
	this.phone = phone;
	this.utype = utype;
	this.sec = sec;
	this.ans = ans;
}
private String name;
private String password;
private String email;
private String phone;
private String utype;
private String sec;
private String ans;


}
