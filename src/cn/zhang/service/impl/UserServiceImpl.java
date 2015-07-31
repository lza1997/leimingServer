package cn.zhang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zhang.bean.User;
import cn.zhang.service.UserService;

/**
 * EmployeeService接口的实现类，这里面具体实现相应的操作
 * 同时由于使用的是扫描加注解的方式进行将bean交给spring管理，
 * 所以这里要进行配置注解
 * */
//只要加上注解那么spring在扫描到这里的时候，就会将这个类交给spring管理了，和在spring中配置
//是一样的，默认的bean的名称就是该类的简写：也就是类的名称EmployeeServiceImpl
@Service
//声明这里的方法是要进行事务管理的,加上下面的这个注解就行了
@Transactional
public class UserServiceImpl implements UserService {

	/*
	 * 如果要进行对数据库的操作，这里就要获取sqlsession对象，而获取sqlsession对象呢
	 * 又要获取sqlsessionFactor有对象，那么我们就要注入sqlsession对象了
	 * */
	//这里使用注解的方式来将sessionFactory进行注入进来
	@Resource SessionFactory factory;
	public void save(User employee) {
		/*factory.openSession();
		这里会又开启一个新的session，但是由于spring中配置的aop事务管理呢
		自己是会自己创建一个session的，如果这里又新建一个的话，那么原来spring的事务管理
		所建立的session就不管用了
		那么我们如何得到spring开启事务时创立的session呢*/
		
		/*
		 * 下面这个语句就是获取spring开启事务时创建的session对象
			确保方法实在spring的事务管理的session下进行的
		*/
		//持久化操作
		factory.getCurrentSession().persist(employee);//内部其实还是调用的save方法
	}

	public void update(User employee) {
		factory.getCurrentSession().merge(employee);//他对应的是saveOrupdate()方法
	}
	//如果某一个方法呢不需要使用事务进行管理，那么进行设置该
	//方法的传播属性如下面就行了
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public User find(String username) {
		return (User) factory.getCurrentSession().get(User.class, username);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<User> list() {
		//创建一个查询对象
		//这里注意是调用的createQuery方法，还有一个是createSQLQuery这个是无法自动转换为实体类型Employee的
		//所以这里最好是用createQuery方法能够直接转化为实体类型
		return factory.getCurrentSession().createQuery("from Employee").list();
	}

	public void delete(String... usernames) {
			for(String username:usernames){
				factory.getCurrentSession().delete(factory.getCurrentSession().load(User.class, username));
			}
	}
}
