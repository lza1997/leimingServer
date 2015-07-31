package cn.zhang.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zhang.bean.User;
import cn.zhang.service.UserService;

/**
 * 该测试类用于进行测试spring和hibernate的结合是否成功
 * 测试标准：是能够根据Employee的hbm.xml文件生产相应的表
 * 
 * 需要实例化spring容器就行了
 * */
public class EmployeeTest {

	private static UserService employeeService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//由于该方法实在所有的操作执行前进行的操作，所以我们在这里将这些操作
		//移到这里这样下面的test方法就可以直接用了
		try {
			ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
			employeeService=(UserService) act.getBean("employeeServiceImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		//下面的类是使用类路径下的xml文件进行实例化
		//这样就能实例化spring容器了，当spring容器创建后sessionFactory自然就会被创建
		//然后根据我们在beans中sessionFactory的配置hibernate.hbm2ddl.auto=update
		//会自动的进行创建相应的表
		new ClassPathXmlApplicationContext("beans.xml");
	}
	@Test 
	public void save(){
		employeeService.save(new User("chun","123"));
	}
	@Test 
	public void update(){
		User eml=employeeService.find("zhang");
		eml.setUserpass("1111");
		employeeService.update(eml);
	}
	@Test 
	public void find(){
		User el=employeeService.find("zhang");
		System.out.println(el.getUserpass());
	}
	@Test 
	public void delete(){
		employeeService.delete("zhang");
	}
	@Test 
	public void list(){
		List<User> elList=employeeService.list();
		System.out.println(elList.size());
		for(User em:elList){
			System.out.println(em.getUserpass());
			System.out.println("--");
		}
	}
}
