package cn.zhang.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zhang.bean.Title;
import cn.zhang.bean.User;
import cn.zhang.dao.TitleDao;

@Service
@Transactional
public class TitleDaoImpl implements TitleDao {
    
    @Resource SessionFactory factory;

    public List<Title> getList(String type) {
        String hql="from Title as t where t.type=:type";//使用命名参数，推荐使用，易读。
 	    Query query=factory.getCurrentSession().createQuery(hql);
 	    query.setString("type", type);
        return query.list();
    }

}
