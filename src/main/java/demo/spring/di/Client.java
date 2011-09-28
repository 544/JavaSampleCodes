package demo.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Client {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"diContext.xml");

		DemoService b = ctx.getBean(DemoService.class);

		// AutoWiredでInjectionされたbeanが取得できてる。
		System.out.println(b.toString());
		System.out.println(b.comp.toString());

	}

}
