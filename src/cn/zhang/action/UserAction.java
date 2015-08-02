package cn.zhang.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import cn.zhang.bean.User;
import cn.zhang.service.LoginService;
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
		System.out.println(username+"---"+userMac);
		String returnValue = null;
		//查询是否有当前的用户
		StringBuilder proofRule = new StringBuilder(username.substring(0, 5) + userMac.substring(5, 15));
		String state = userService.register(username, userMac, proofRule.toString()); 
		if( state.equals("1") ){
			returnValue = "1"; //说明注册成功
		}else{ 
			returnValue = "2"; //注册失败
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
	        //将json数据放到输出流中返回
	        out.println(json.toString());  
	        out.flush();  
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
