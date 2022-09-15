package com.teamproj.Model;

public class Course {
	private int courseid;
	private String title;
	private String detail;
	private int sessions;
	private int intake;
	private int registered;
	private int author;
	private String status;
	public Course() {
		super();
	}
	public Course(int courseid, String title, String detail, int sessions, int intake, int registered, int author,
			String status) {
		super();
		this.courseid = courseid;
		this.title = title;
		this.detail = detail;
		this.sessions = sessions;
		this.intake = intake;
		this.registered = registered;
		this.author = author;
		this.status = status;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getSessions() {
		return sessions;
	}
	public void setSessions(int sessions) {
		this.sessions = sessions;
	}
	public int getIntake() {
		return intake;
	}
	public void setIntake(int intake) {
		this.intake = intake;
	}
	public int getRegistered() {
		return registered;
	}
	public void setRegistered(int registered) {
		this.registered = registered;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
