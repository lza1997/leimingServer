package cn.zhang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import cn.zhang.bean.Title;
import cn.zhang.dao.TitleDao;
import cn.zhang.service.TitleService;

@Service
public class TitleServiceImpl implements TitleService {
    
    @Resource
    private TitleDao titleDao;

    @Override
    public JSONObject getList(String type) throws Exception {
        //DAO操作
        List<Title> list=titleDao.getList(type);
        JSONObject json=new JSONObject();
        if (list.size()<=0) {
            return json.put("state", 3); //3代表没有对应类型的数据
        }
        json.put("titles", titleDao.getList(type));
        return json.put("state", 1); //1代表返回数据成功
    }

}
