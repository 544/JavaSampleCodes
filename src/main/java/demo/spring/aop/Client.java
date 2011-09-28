package demo.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Client {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"aopContext.xml");
		
		Service1 service = ctx.getBean(Service1.class);
		service.doIt("hoge");
		

	}

}
