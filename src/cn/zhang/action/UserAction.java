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
import cn.zhang.service.UserService;

/**
 * 关于用户处理的action
 * 添加删除用户等
 * */
@Controller //employeeAddAtion
public class UserAction{
	
	//上传用户头像
	public void uphead(){
		HttpServletRequest request=ServletActionContext.getRequest();
		//获取系统的跟路径
		String savePath = ServletActionContext.getRequest().getRealPath("/");
		String user_head = new String(request.getParameter("user_head"));
		String returnValue = null;
		
		byte [] user_headByte = Base64.decode(user_head);
		//创建保存用户头像的file
		File file = new File(savePath+"images/user/user_head.jpg");
		try {
			if(file.exists()){
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(user_headByte);
			fos.flush();
			fos.close();
			returnValue = "1";
		} catch (IOException e) {
			e.printStackTrace();
			returnValue = "2";
		}
		
		//将登录结果返回
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html");  
        PrintWriter out;  
        //获取输出流对象
        try {
			out = response.getWriter();
        	JSONObject json=new JSONObject();  
	        json.put("State", returnValue);
	        //将json数据放到输出流中返回
	        out.println(json.toString());  
	        out.flush();  
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
