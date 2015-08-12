package cn.zhang.service;

import cn.zhang.bean.UserControl;
import net.sf.json.JSONObject;


public interface UserControlService {

    /**
     * 获取beanList
     * @param type
     */
    JSONObject getList(int start, int number) throws Exception ;
    
    /**
     * count上个list方法的数量
     * @return
     * @throws Exception
     */
    int countList() throws Exception;
    
    /**
     * 获取一条记录
     * @param id
     * @return
     * @throws Exception
     */
    UserControl getOne (String userName) throws Exception ;
    
    /**
     * 删除多条
     * @param userNames
     * @return
     * @throws Exception
     */
    public JSONObject delete(String[] userNames);
    
    /**
     * 修改一条
     * @param userControl
     * @return
     * @throws Exception
     */
    public JSONObject update(UserControl userControl);
    
    /**
     * 增加一条
     * @param userControl
     * @return
     * @throws Exception
     */
    public JSONObject addOne(UserControl userControl);

}
