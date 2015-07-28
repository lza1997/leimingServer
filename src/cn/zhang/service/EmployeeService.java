package cn.zhang.service;

import java.util.List;

import cn.zhang.bean.Employee;

/**
 * 提供对Employee的service的接口功能
 * */
public interface EmployeeService {

		public void save(Employee employee);
		public void update(Employee employee);
		public Employee find(String username);
		//使用动态变量
		public void delete(String ...usernames);
		public List<Employee> list(); 
}
