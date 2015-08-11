package cn.zhang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import cn.zhang.bean.UserControl;
import cn.zhang.dao.UserControlDao;
import cn.zhang.service.UserControlService;

@Service
public class UserControlServiceImpl implements UserControlService {
    
    @Resource
    private UserControlDao userControlDao;

    
    @Override
    public JSONObject getList(int start, int number)
            throws Exception {
      //DAO操作
        List<UserControl> list=userControlDao.getList(start, number);
        int total=userControlDao.count();
        JSONObject json=new JSONObject();
        if (list.size()<=0) {
            json.put("state", 3); //3代表没有对应类型的数据
            return json;
        }
        json.put("rows", list);
        json.put("total", total);
        json.put("state", 1); //1代表返回数据成功
        return json;
    }
    
    @Override
    public int countList() throws Exception {
        return userControlDao.count();
    }

    @Override
    public UserControl getOne(String userName) throws Exception {
        return userControlDao.getOne(userName);
    }

    @Override
    public JSONObject delete(String[] userNames){
        JSONObject json=new JSONObject();
        try {
            userControlDao.delete(userNames);
            json.put("state", 1); //1代表返回数据成功
        } catch (Exception e) {
            e.printStackTrace();
            json.put("state", 0); //0失败
            return json;
        }
        return json;
    }

    @Override
    public JSONObject update(UserControl userControl){
        JSONObject json=new JSONObject();
        try {
            userControlDao.update(userControl);
            json.put("state", 1); //1代表返回数据成功
        } catch (Exception e) {
            e.printStackTrace();
            json.put("state", 0); //0失败
            return json;
        }
        return json;
    }

    @Override
    public JSONObject addOne(UserControl userControl) {
        JSONObject json=new JSONObject();
        try {
            userControlDao.addOne(userControl);
            json.put("state", 1); //1代表返回数据成功
        } catch (Exception e) {
            e.printStackTrace();
            json.put("state", 0); //0失败
            return json;
        }
        return json;
    }

}
