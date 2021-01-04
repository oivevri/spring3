package co.company.test.config;

import org.springframework.stereotype.Component;

//1
@Component
//2
//@Component("apple")
public class AppleSpeaker implements Speaker{

	@Override
	public void volumeup() {
		System.out.println("앱흘 스피커");
	}
}