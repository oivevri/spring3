package co.company.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //@Controller, @Repository, @Service
public class TV {
	
	//0
	//@Autowired Speaker speaker; 
	
	//1
	@Autowired 
	@Qualifier("appleSpeaker") Speaker speaker; //의존주입2개되서, 어떤 의존주입 객체 사용할껀지 지정 , 
												//해당클래스의 앞글자만 소문자로 바꿔서 씀
	
	//2
	//@Autowired
	//@Qualifier("apple") Speaker speaker;
	
	//3
	//@Resource(name="apple")Speaker speaker;
	
	public void volumeup() {
		speaker.volumeup();
	}
	
	public TV() {
		System.out.println("TV생성됨");
	}
	
	public void init() {
		System.out.println("init 실행됨");
	}
	

	public void destroy() {
		System.out.println("destroy 실행됨");
	}
	
}
