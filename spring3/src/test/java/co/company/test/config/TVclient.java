package co.company.test.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { IOCConfiguration.class })
public class TVclient {
	@Autowired TV tv1;
	@Autowired TV tv2;

	@Test
	public void tvtest() {
		//System.out.println(tv);
		System.out.println(tv1 == tv2);
		tv1.volumeup();
	}
}
