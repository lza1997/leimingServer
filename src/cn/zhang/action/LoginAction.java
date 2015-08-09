package cn.zhang.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import cn.zhang.bean.User;
import cn.zhang.service.LoginService;

/**
 * 锟矫伙拷锟斤拷录锟斤拷锟矫碉拷action
 * */
@Controller
public class LoginAction {
	
	//锟斤拷EmployeeService业锟斤拷bean锟斤拷锟斤拷注锟斤拷
	@Resource
	private LoginService loginService;
	
	public void execute(){
		HttpServletRequest request=ServletActionContext.getRequest();
		//锟矫伙拷锟剿猴拷
		String username = new String(request.getParameter("username"));
		//锟矫伙拷锟斤拷锟斤拷锟絤ac锟斤拷址
		String userMac = new String(request.getParameter("user_mac"));
		//锟斤拷取锟斤拷
		System.out.println(username+"---"+userMac);
		String returnValue = null;
		//锟斤拷询锟角凤拷锟叫碉拷前锟斤拷锟矫伙拷
		StringBuilder proofRule = new StringBuilder(username.substring(0, 5) + userMac.substring(5, 15));
		User user = loginService.login(username, userMac, proofRule.toString()); 
		if( user!=null ){
			returnValue = "1"; //说锟斤拷锟斤拷锟节革拷锟矫伙拷锟斤拷锟斤拷锟截成癸拷锟斤拷示1
		}else{ 
			returnValue = "2"; //说锟斤拷锟斤拷锟斤拷锟节革拷锟矫伙拷
		}
		//锟斤拷锟斤拷录锟斤拷锟斤拷
		
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html");  
        PrintWriter out;  
        //锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷锟�
        try {
			out = response.getWriter();
        	JSONObject json=new JSONObject();  
	        json.put("state", returnValue);
	        if(user!=null){
	        	json.put("userPermission", user.getUserPermission() );
	        }else{
	        	json.put("userPermission", "");
	        }
	        
	        //锟斤拷json锟斤拷莘诺锟斤拷锟斤拷锟斤拷锟叫凤拷锟斤拷
	        out.println(json.toString());  
	        out.flush();  
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
