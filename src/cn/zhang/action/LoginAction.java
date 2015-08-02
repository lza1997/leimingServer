package cn.zhang.action;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.zhang.bean.User;
import cn.zhang.service.LoginService;

/**
 * 用户登录调用的action
 * */
@Controller
public class LoginAction {
	
	//将EmployeeService业务bean进行注入
	@Resource
	private LoginService loginService;
	
	public void execute(){
		HttpServletRequest request=ServletActionContext.getRequest();
		//用户账号
		String username = new String(request.getParameter("username"));
		//用户本机的mac地址
		String userMac = new String(request.getParameter("user_mac"));
		//获取该
		System.out.println(username+"---"+userMac);
		String returnValue = null;
		//查询是否有当前的用户
		StringBuilder proofRule = new StringBuilder(username.substring(0, 5) + userMac.substring(5, 15));
		User user = loginService.login(username, userMac, proofRule.toString()); 
		if( user!=null ){
			returnValue = "1"; //说明存在改用户，返回成功标示1
		}else{ 
			returnValue = "2"; //说明不存在改用户
		}
		//将登录结果返回
		
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html");  
        PrintWriter out;  
        //获取输出流对象
        try {
			out = response.getWriter();
        	JSONObject json=new JSONObject();  
	        json.put("state", returnValue);
	        if(user!=null){
	        	json.put("userPermission", user.getUserPermission() );
	        }else{
	        	json.put("userPermission", "");
	        }
	        
	        //将json数据放到输出流中返回
	        out.println(json.toString());  
	        out.flush();  
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
