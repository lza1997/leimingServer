package cn.zhang.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import cn.zhang.bean.UserControl;
import cn.zhang.service.UserControlService;

import com.opensymphony.xwork2.ModelDriven;

@Controller
public class UserControlAction extends BaseAction implements ModelDriven<UserControl>{
    
    private UserControl userControl=new UserControl();
    @Override
    public UserControl getModel() {
        return userControl;
    }
    
    @Resource
    private UserControlService userControlService;
    
    //后台用的：获得UserControllist
    public void getListJson() throws Exception{
        //1 设置分页参数
        //当前页           
        int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);            
        //每页显示条数            
        int number = Integer.parseInt((rows == null || rows == "0") ? "10":rows); 
        //每页的开始记录  第一页为1  第二页为number +1
        int start = (intPage-1)*number;
        
        JSONObject json = userControlService.getList(start, number);//构造结果
        //返回结果
        HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("application/json;charset=UTF-8");
        response.setContentType("");
        PrintWriter out=null;  
        try {
            out = response.getWriter();
            out.write(json.toString());
            out.flush();  
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.close();
        }  
    }   
    
    /**
     * 获得One
     * @throws Exception
     */
    public void getOne() throws Exception{
        JSONObject json=JSONObject.fromObject(userControlService.getOne(userControl.getUserName()));
        //返回结果
        HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("application/json");
        PrintWriter out=null;  
        try {
            out = response.getWriter();
            out.write(json.toString());
            out.flush();  
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.close();
        }  
    }
    
    /**
     * 删除
     */
    public void delete(){
        PrintWriter out=null;  
        try {
            String userNames = ServletActionContext.getRequest().getParameter("userNames");
            //返回结果
            HttpServletResponse response=ServletActionContext.getResponse();  
            response.setContentType("application/json");
            out = response.getWriter();
            out.write(userControlService.delete(userNames.split(",")).toString());
            out.flush();  
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.close();
        }  
    }
    
    /**
     * udpateOne
     * @throws Exception
     */
    public void udpateOne() throws Exception{
        PrintWriter out=null;  
        try {
            HttpServletResponse response=ServletActionContext.getResponse();  
            response.setContentType("application/json");
            out = response.getWriter();
            JSONObject json=null;
            if (StringUtils.isBlank(userControl.getUserName())||StringUtils.isBlank(userControl.getUserPermission())) {
                json=new JSONObject();
                json.put("state", 0); //0失败
            }else{
                json=userControlService.update(userControl);
            }
            out.write(json.toString());
            out.flush();  
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.close();
        }  
    }
    
    /**
     * 增加
     */
    public void addOne(){
        PrintWriter out=null;  
        try {
            HttpServletResponse response=ServletActionContext.getResponse();  
            response.setContentType("application/json");
            out = response.getWriter();
            JSONObject json=null;
            if (StringUtils.isBlank(userControl.getUserName())||StringUtils.isBlank(userControl.getUserPermission())) {
                json=new JSONObject();
                json.put("state", 0); //0失败
            }else if(null!=userControlService.getOne(userControl.getUserName())){
                json=new JSONObject();
                json.put("state", 3); //3重复
            }else{
                json=userControlService.addOne(userControl);
            }
            out.write(json.toString());
            out.flush();  
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.close();
        }
    }

}
