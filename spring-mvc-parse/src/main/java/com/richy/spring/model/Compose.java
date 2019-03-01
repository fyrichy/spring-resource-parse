package com.richy.spring.model;

public class Compose {

	private User user;
	private Teacher teacher;
	
	
	public Compose(User user, Teacher teacher) {
		super();
		this.user = user;
		this.teacher = teacher;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Compose [user=" + user + ", teacher=" + teacher + "]";
	}
	
	
}
