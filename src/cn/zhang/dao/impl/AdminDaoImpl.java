package cn.zhang.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zhang.dao.AdminDao;

@Service
@Transactional
public class AdminDaoImpl implements AdminDao {
    
    @Resource SessionFactory factory;

    /**
     * 登录校验
     * @param loginName
     * @param password
     * @return
     */
    public boolean checkLogin(String loginName,String password) {
        String sql="select count(*) from Admin as a where a.loginName=:loginName and a.password=:password";//使用命名参数，推荐使用，易读。
        Query query=factory.getCurrentSession().createSQLQuery(sql);
        query.setString("loginName", loginName);
        query.setString("password", password);
        
        int count=((Number)query.uniqueResult()).intValue();//获取记录数，兼容不同版本Hibernate写法
        return count>0;
    }
}
