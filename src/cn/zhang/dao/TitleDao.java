package cn.zhang.dao;

import java.util.List;

import cn.zhang.bean.Title;

public interface TitleDao {
    
    public List<Title> getList(String type);
    
}
