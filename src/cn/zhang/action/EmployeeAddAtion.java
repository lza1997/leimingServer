package cn.zhang.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.zhang.bean.Employee;
import cn.zhang.service.EmployeeService;

//交给spring进行管理
/*
 * 注意：！！！当我们将action交给spring进行管理的时候，spring会
 * 使用单例的模式进行建立action的实例对象，但是呢struts2呢是为每一次的请求都会创建一个
 * action的，那么这时如果我们想要和struts2的设置并合，那么进行如下设置：
 * 将作用域定义为原型：@Scope("prototype")转为原型模式,这样就能确保和struts2的并合
 * 
 * 如果是单例模式那么这个action就是不安全的，因为数据有可能会被修改
 * 
 * ！！！！！！！！！！！！如果涉及到保存数据的action一定要设置为原型模式
 * */
@Controller //employeeAddAtion
@Scope("prototype")
public class EmployeeAddAtion {
	
		//将EmployeeService业务bean进行注入
		@Resource
		private EmployeeService employeeService;
		//设置用于获得页面参数的
		private Employee employee;
		
		public Employee getEmployee() {
			return employee;
		}
		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
		//定义一个显示条件界面的方法
		public String addUI(){
			return "addUI";
		}
		//定义处理添加功能更的方法
		public String add(){
			
			try {
				employeeService.save(employee);
				
				List<Employee> emList=employeeService.list();
				ActionContext.getContext().put("employees", emList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "message";
		}
}
