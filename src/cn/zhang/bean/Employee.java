package cn.zhang.bean;

public class Employee {

	private String username;
	private String userpass;
	private Gender gender=Gender.MAN;
	
	public Employee(){}
	public Employee(String username, String userpass) {
		super();
		this.username = username;
		this.userpass = userpass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
