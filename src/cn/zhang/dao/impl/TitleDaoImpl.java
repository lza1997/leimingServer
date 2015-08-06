package cn.zhang.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import cn.zhang.bean.Title;
import cn.zhang.dao.TitleDao;

@Component
public class TitleDaoImpl implements TitleDao {
    
    @Resource
    private SessionFactory factory;

    @Override
    public List<Title> getList(String type) {
        //String hql="from Title t where t.type=:type";//使用命名参数，推荐使用，易读。
        String hql="from Title t where t.type="+type;//使用命名参数，推荐使用，易读。
        Session session=factory.getCurrentSession();
        Query query=session.createQuery(hql);
        //query.setString("type", type);
        return query.list();
    }

}
