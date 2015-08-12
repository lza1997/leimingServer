package cn.zhang.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zhang.bean.Title;
import cn.zhang.dao.TitleDao;

@Service
@Transactional
public class TitleDaoImpl implements TitleDao {
    
    @Resource SessionFactory factory;

    @Override
    public List<Title> getList(String type) {
        String hql="from Title";//使用命名参数，推荐使用，易读。
        if( type!=null && !"".equals(type)){
            hql="from Title as t where t.type=:type";
        }
 	    Query query=factory.getCurrentSession().createQuery(hql);
 	    if( type!=null && !"".equals(type)){
 	       query.setString("type", type);
 	    }
        return query.list();
    }
    
    @Override
    public List<Title> getList(String type, int start, int number) {
        String hql="from Title";//使用命名参数，推荐使用，易读。
        if( type!=null && !"".equals(type)){
            hql="from Title as t where t.type=:type";
        }
        Query query=factory.getCurrentSession().createQuery(hql);
        if( type!=null && !"".equals(type)){
            query.setString("type", type);
        }
        query.setFirstResult(start);
        query.setMaxResults(number);
        return query.list();
    }
    
    @Override
    public int count(String type) {
        String sql="select count(*) from Title";//使用命名参数，推荐使用，易读。
        if( type!=null && !"".equals(type)){
            sql="select count(*) from Title as a where a.type=:type";//使用命名参数，推荐使用，易读。
        }
        Query query=factory.getCurrentSession().createQuery(sql);
        if( type!=null && !"".equals(type)){
           query.setString("type", type);
        }
        return ((Number)query.uniqueResult()).intValue();
    }

    @Override
    public Title getOne(Integer id) {
        return (Title)factory.getCurrentSession().get(Title.class, id);
    }
    
    @Override
    public void delete(String[] ids) throws Exception{
        for(String id:ids){
            factory.getCurrentSession().delete(factory.getCurrentSession().load(Title.class, Integer.valueOf(id)));
        }
    }
    
    @Override
    public void update(Title title) throws Exception{
        factory.getCurrentSession().update(title);
    }

    @Override
    public void addOne(Title title) throws Exception {
        factory.getCurrentSession().save(title);
    }

}
