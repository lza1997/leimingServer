package cn.zhang.dao;

import java.util.List;

import cn.zhang.bean.Title;

public interface TitleDao {
    
    public List<Title> getList(String type);
    public List<Title> getList(String type, int start, int number);
    public int count(String type);

    public Title getOne(Integer id);
    
    public void delete(String[] ids) throws Exception;
    
    public void update(Title title) throws Exception;
    
    
}
