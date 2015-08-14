package cn.zhang.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import cn.zhang.bean.Title;
import cn.zhang.service.TitleService;

import com.opensymphony.xwork2.ModelDriven;

@Controller
public class TitleAction extends BaseAction implements ModelDriven<Title>{
    
    private Title title=new Title();
    @Override
    public Title getModel() {
        return title;
    }
    
    @Resource
    private TitleService titleService;
    
    //前台：获得Titlelist
    public void getList() throws Exception{
        HttpServletRequest request=ServletActionContext.getRequest();
        //类型
        String type = request.getParameter("type");
        //构造结果
        JSONObject json=null;
        if (StringUtils.isBlank(type)) {
            json= new JSONObject();
            json.put("state", 4); //4代表type不能为空
        }else{
            json = titleService.getList(type);
        }
        //防止乱码
        String outMessage = json.toString();
        outMessage=new String(outMessage.getBytes("GB2312"),"ISO-8859-1"); 
        //返回结果
        HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html");
        PrintWriter out=null;  
        try {
            out = response.getWriter();
            out.println(outMessage);  
            out.flush();  
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.close();
        }  
    }
    
    //后台用的：获得Titlelist
    public void getListJson() throws Exception{
        HttpServletRequest request=ServletActionContext.getRequest();
        String type = request.getParameter("type");//类型
        
        //1 设置分页参数
        //当前页           
        int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);            
        //每页显示条数            
        int number = Integer.parseInt((rows == null || rows == "0") ? "10":rows); 
        //每页的开始记录  第一页为1  第二页为number +1
        int start = (intPage-1)*number;
        
        
        JSONObject json = titleService.getList(type, start, number);//构造结果
        //返回结果
        HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("application/json;charset=UTF-8");
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
        JSONObject json=JSONObject.fromObject(titleService.getOne(title.getId()));
        //返回结果
        HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("application/json;");
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
            String ids = ServletActionContext.getRequest().getParameter("ids");
            //返回结果
            HttpServletResponse response=ServletActionContext.getResponse();  
            response.setContentType("application/json;");
            out = response.getWriter();
            out.write(titleService.delete(ids.split(",")).toString());
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
            response.setContentType("application/json;");
            out = response.getWriter();
            JSONObject json=null;
            if (null==title.getId()||StringUtils.isBlank(title.getType())||StringUtils.isBlank(title.getTitle())||StringUtils.isBlank(title.getContent())) {
                json=new JSONObject();
                json.put("state", 0); //0失败
            }else{
                json=titleService.update(title);
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
            if (StringUtils.isBlank(title.getType())||StringUtils.isBlank(title.getTitle())||StringUtils.isBlank(title.getContent())) {
                json=new JSONObject();
                json.put("state", 0); //0失败
            }else{
                json=titleService.addOne(title);
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
