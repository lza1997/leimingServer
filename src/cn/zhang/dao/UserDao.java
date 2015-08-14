package cn.zhang.dao;

import cn.zhang.bean.User;
import cn.zhang.bean.UserControl;

/**
 * 用户信息操作类
 * */
public interface UserDao {
	
	public void save(User user);
	public void update(User user);
	public void delete(String... id);
	public User find(String username,String userMac,String proofRule);
	public User find(String username);
	public UserControl find_usercontrol(String username);

}
