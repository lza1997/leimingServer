package cn.zhang.service;

import cn.zhang.bean.Title;
import net.sf.json.JSONObject;


public interface TitleService {

    /**
     * 获取beanList
     * @param type
     */
    JSONObject getList(String type) throws Exception ;
    /**
     * 获取beanList
     * @param type
     */
    JSONObject getList(String type, int start, int number) throws Exception ;
    
    /**
     * count上个list方法的数量
     * @param type
     * @return
     * @throws Exception
     */
    int countList(String type) throws Exception;
    
    /**
     * 获取一条记录
     * @param id
     * @return
     * @throws Exception
     */
    Title getOne (Integer id) throws Exception ;
    
    /**
     * 删除多条
     * @param ids
     * @return
     * @throws Exception
     */
    public JSONObject delete(String[] ids);
    
    /**
     * 修改一条
     * @param title
     * @return
     * @throws Exception
     */
    public JSONObject update(Title title);
    
    /**
     * 增加一条
     * @param title
     * @return
     * @throws Exception
     */
    public JSONObject addOne(Title title);

}
