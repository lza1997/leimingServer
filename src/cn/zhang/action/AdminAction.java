package cn.zhang.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import cn.zhang.bean.Admin;
import cn.zhang.dao.AdminDao;

import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台管理员
 * 
 * @author ZhangYaxu
 * @date 2015年8月6日
 */
@Controller
public class AdminAction implements ModelDriven<Admin>{
    private Admin admin=new Admin();
    @Override
    public Admin getModel() {
        return admin;
    }
    
    @Resource
    private AdminDao adminDao;
    
    /**
     * 到登陆页面
     * @return
     * @throws Exception
     */
    public String login()throws Exception{
        return "login";
    }
    
    /**
     * 注销
     * @return
     * @throws Exception
     */
    public String logout()throws Exception{
        HttpSession session=ServletActionContext.getRequest().getSession();
        if (null!=session.getAttribute("admin")) {
            session.removeAttribute("admin");
        }
        return "login";
    }
    
    /**
     * 登陆
     * @throws Exception
     */
    public void loginSubmit()throws Exception{
        boolean canLogin=adminDao.checkLogin(admin.getLoginName(), admin.getPassword());
        if(canLogin){
            PrintWriter writer=ServletActionContext.getResponse().getWriter();
            HttpServletRequest request=ServletActionContext.getRequest();
            request.getSession().setAttribute("admin", admin);
            writer.write(request.getContextPath()+"/admin_framehome");
            writer.flush();
            writer.close();
        }
    }
    
    public String framehome() throws Exception{
        Admin sessionAdmin=(Admin)ServletActionContext.getRequest().getSession().getAttribute("admin");
        if(null==sessionAdmin){
            return "login";
        }
        return "framehome";
    }

}
