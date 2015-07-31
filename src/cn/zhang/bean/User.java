package cn.zhang.bean;

/**
 * 用户表
 * */
public class User {

	private String userName; //用户名
	private String userMac; //用户手机的mac地址
	/*
	 * 用户的权限，控制能够使用那些功能
	 * 服务器返回的格式：{permission:"权限1，权限2";}
	 * */
	private String userPermission;
	/*
	 * 验证规则，因为用户名和mac地址都有可能被伪造，所以我这里
	 * 在注册的时候就会进行根据用户名和mac地址生成一个有规则的string
	 * 然后在登录的按同样的规则根据传递过来的用户名和mac进行生成string然后
	 * 和数据库中的比对，已达到验证的目的
	 * */
	private String proofRule; 
	
	public User(){}
	public User(String userName, String userMac,String userPermission,String proofRule) {
		super();
		this.userName = userName;
		this.userMac = userMac;
		this.userPermission = userPermission;
		this.proofRule = proofRule;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMac() {
		return userMac;
	}
	public void setUserMac(String userMac) {
		this.userMac = userMac;
	}
	public String getUserPermission() {
		return userPermission;
	}
	public void setUserPermission(String userPermission) {
		this.userPermission = userPermission;
	}
	public String getProofRule() {
		return proofRule;
	}
	public void setProofRule(String proofRule) {
		this.proofRule = proofRule;
	}
	
	
	
}
