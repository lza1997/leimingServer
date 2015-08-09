package cn.zhang.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zhang.bean.User;
import cn.zhang.bean.UserControl;
import cn.zhang.dao.UserDao;
import cn.zhang.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource  
	private UserDao userDao;

	//用户注册
	@Override
    public String register(String username, String userMac, String proofRule) {
		//先从userControl表中获取当前username是否具有注册的资格
		UserControl usercontrol = userDao.find_usercontrol(username);
		if( usercontrol!=null ){
			//说明用户控制表中有改用户，可以进行注册
			User user = new User(username,userMac,usercontrol.getUserPermission(),proofRule);
		    userDao.save(user);
		}else{
			return "2"; //表示注册失败，没有资格注册
		}
		return "1"; //表示注册成功
		
	}
	
	
}
