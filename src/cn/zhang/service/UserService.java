package cn.zhang.service;

import java.util.List;

import cn.zhang.bean.User;

/**
 * 提供对Employee的service的接口功能
 * */
public interface UserService {

		public void save(User employee);
		public void update(User employee);
		public User find(String username);
		//使用动态变量
		public void delete(String ...usernames);
		public List<User> list(); 
}
