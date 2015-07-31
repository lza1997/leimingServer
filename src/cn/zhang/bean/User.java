package cn.zhang.bean;

/**
 * ÓÃ»§±í
 * */
public class User {

	private String username;
	private String userpass;
	
	public User(){}
	public User(String username, String userpass) {
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
}
