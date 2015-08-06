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
 * �û���¼���õ�action
 * */
@Controller
public class LoginAction {
	
	//��EmployeeServiceҵ��bean����ע��
	@Resource
	private LoginService loginService;
	
	public void execute(){
		HttpServletRequest request=ServletActionContext.getRequest();
		//�û��˺�
		String username = new String(request.getParameter("username"));
		//�û������mac��ַ
		String userMac = new String(request.getParameter("user_mac"));
		//��ȡ��
		System.out.println(username+"---"+userMac);
		String returnValue = null;
		//��ѯ�Ƿ��е�ǰ���û�
		StringBuilder proofRule = new StringBuilder(username.substring(0, 5) + userMac.substring(5, 15));
		User user = loginService.login(username, userMac, proofRule.toString()); 
		if( user!=null ){
			returnValue = "1"; //˵�����ڸ��û������سɹ���ʾ1
		}else{ 
			returnValue = "2"; //˵�������ڸ��û�
		}
		//����¼����
		
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html");  
        PrintWriter out;  
        //��ȡ���������
        try {
			out = response.getWriter();
        	JSONObject json=new JSONObject();  
	        json.put("state", returnValue);
	        if(user!=null){
	        	json.put("userPermission", user.getUserPermission() );
	        }else{
	        	json.put("userPermission", "");
	        }
	        
	        //��json��ݷŵ�������з���
	        out.println(json.toString());  
	        out.flush();  
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
