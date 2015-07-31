package cn.zhang.bean;

/**
 * 用户表
 * */
public class User {

	private String username; //用户名
	private String user_mac; //用户手机的mac地址
	/*
	 * 用户的权限，控制能够使用那些功能
	 * 服务器返回的格式：{permission:"权限1，权限2";}
	 * */
	private String user_permission;
	
	public User(){}
	public User(String username, String user_mac,String user_permission) {
		super();
		this.username = username;
		this.user_mac = user_mac;
		this.user_permission = user_permission;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUser_mac() {
		return user_mac;
	}
	public void setUser_mac(String user_mac) {
		this.user_mac = user_mac;
	}
	public String getUser_permission() {
		return user_permission;
	}
	public void setUser_permission(String user_permission) {
		this.user_permission = user_permission;
	}
	
	
}
