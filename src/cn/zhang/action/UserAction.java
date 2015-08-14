package cn.zhang.action;

import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import cn.zhang.service.UserService;

/**
 * 关于用户处理的action
 * 添加删除用户等
 * */
@Controller //
public class UserAction{
	
	@Resource
	private UserService userService;
	//用户注册
	public void register(){
		HttpServletRequest request=ServletActionContext.getRequest();
		//用户账号
		String username = new String(request.getParameter("username"));
		//用户本机的mac地址
		String userMac = new String(request.getParameter("user_mac"));
		//获取该
		//System.out.println(username+"---"+userMac);
		//查询是否有当前的用户
		StringBuilder proofRule = new StringBuilder(username.substring(0, 5) + userMac.substring(5, 15));
		//返回的状态码
		String state = userService.register(username.trim(), userMac.trim(), proofRule.toString().trim()); 
		
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html");  
        PrintWriter out;  
        //获取输出流对象
        try {
			out = response.getWriter();
        	JSONObject json=new JSONObject();  
	        json.put("state", state);
	        //将json数据放到输出流中返回
	        out.println(json.toString());  
	        out.flush();  
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
