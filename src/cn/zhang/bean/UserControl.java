package cn.zhang.bean;

/**
 * 用户申请控制表，只有在改表中的username才能进行添加到user表中
 * */
public class UserControl {

	private String userName; //用户名
	private String userPermission;
	
	public UserControl(){}
	public UserControl(String userName, String userPermission) {
		super();
		this.userName = userName;
		this.userPermission = userPermission;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPermission() {
		return userPermission;
	}
	public void setUserPermission(String userPermission) {
		this.userPermission = userPermission;
	}
	
	
}
