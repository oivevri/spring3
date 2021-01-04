package co.company.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import co.company.spring.config.MvcConfiguration;
import co.company.spring.controller.Greeter;

public class Main {
	public static void main(String[] args) {
		//Greeter g = new Greeter();
		//g.setFormat("%s, 안녕하세요");
		
		//책 46p
		//1.컨테이너 생성 
		AnnotationConfigApplicationContext ctx = 
		new AnnotationConfigApplicationContext(MvcConfiguration.class);
		Greeter g = ctx.getBean(Greeter.class);
		String msg = g.greet("스프링");
		System.out.println(msg);
	}
}
