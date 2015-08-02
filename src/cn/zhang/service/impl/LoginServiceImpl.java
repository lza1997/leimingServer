package cn.zhang.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zhang.bean.User;
import cn.zhang.dao.UserDao;
import cn.zhang.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Resource  
	private UserDao userDao;

	public User login(String username, String userMac, String proofRule) {
		return userDao.find(username, userMac, proofRule);
	}
	
	
}
