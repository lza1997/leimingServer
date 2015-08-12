package cn.zhang.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zhang.bean.UserControl;
import cn.zhang.dao.UserControlDao;

@Service
@Transactional
public class UserControlDaoImpl implements UserControlDao {

    @Resource SessionFactory factory;
    
    @Override
    public List<UserControl> getList(int start, int number) {
        String hql="from UserControl";
        Query query=factory.getCurrentSession().createQuery(hql);
        query.setFirstResult(start);
        query.setMaxResults(number);
        return query.list();
    }

    @Override
    public int count() {
        String sql="select count(*) from UserControl";
        Query query=factory.getCurrentSession().createQuery(sql);
        return ((Number)query.uniqueResult()).intValue();
    }

    @Override
    public UserControl getOne(String userName) {
        return (UserControl)factory.getCurrentSession().get(UserControl.class, userName);
    }

    @Override
    public void delete(String[] userNames) throws Exception {
        for(String id:userNames){
            factory.getCurrentSession().delete(factory.getCurrentSession().load(UserControl.class, id));
        }
    }

    @Override
    public void update(UserControl userControl) throws Exception {
        factory.getCurrentSession().update(userControl);
    }

    @Override
    public void addOne(UserControl userControl) throws Exception {
        factory.getCurrentSession().save(userControl);
    }

}
