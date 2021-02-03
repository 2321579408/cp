package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lanou.service.AdminService;
import com.lanou.service.AdminServiceImpl;

import cao.lanou.bean.Admin;

public class SpringTest {
	
	@Test
	public void test() {
		
		Admin admin=new Admin();
		admin.setName("mx");
		System.out.println(admin.getName());
	}
	@Test
	public void test2() {
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		Admin admin = (Admin) ac.getBean("adm");
		admin.setName("mx");
		System.out.println(admin.getName());
		
		System.out.println(admin.getPwd());
		System.out.println(admin.getHobbys().size());
		System.out.println(admin.getMaps());
		
	}
	
	@Test
	public void test3() {  
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminServiceImpl adminServiceImpl=(AdminServiceImpl) ac.getBean("adminService");
		adminServiceImpl.ss();
	}

}
