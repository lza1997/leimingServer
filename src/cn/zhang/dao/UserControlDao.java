package cn.zhang.dao;

import java.util.List;

import cn.zhang.bean.UserControl;

/**
 * 用户控制表Dao
 * 
 * @author ZhangYaxu
 * @date 2015年8月11日
 */
public interface UserControlDao {
    public List<UserControl> getList(int start, int number);
    public int count();

    public UserControl getOne(String userName);
    
    public void delete(String[] userNames) throws Exception;
    
    public void update(UserControl userControl) throws Exception;
    
    public void addOne(UserControl userControl) throws Exception;
}
