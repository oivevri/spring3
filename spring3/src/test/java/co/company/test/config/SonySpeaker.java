package co.company.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component//빈등록
public class SonySpeaker implements Speaker {

	@Override
	public void volumeup() {
		System.out.println("쏘오닝스삐꽁 볼륨을 높여ㄹ ㅑ");
	}

}
