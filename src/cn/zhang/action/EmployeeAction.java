package cn.zhang.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.zhang.service.EmployeeService;

/**
 * 把这个action交给spring进行管理，通过注解的方式
 * 
 * 同时我们这里将action的实例交给了spring，那么这里就可以利用spring的
 * 依赖注入将 业务bean 注入进来
 * */
@Controller //employeeAction(默认的bean的名称)
public class EmployeeAction {

		//利用spring的依赖注入原理将业务bean注入进来
		@Resource
		EmployeeService employeeService;
		//action的默认执行函数
		public String execute(){
			//在将员工信息列表数据，放入request请求范围内
			ActionContext.getContext().put("employees", employeeService.list());
			return "list";
		}
}
