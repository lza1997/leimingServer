package cn.zhang.dao;

import java.util.List;

import cn.zhang.bean.Title;

public interface TitleDao {
    
    List<Title> getList(String type);
    
}
