package cn.zhang.service;

import cn.zhang.bean.User;

/**
 * µÇÂ¼´¦ÀíµÄservice
 * */
public interface LoginService {

	public User login(String username,String userMac,String proofRule);
	
}
