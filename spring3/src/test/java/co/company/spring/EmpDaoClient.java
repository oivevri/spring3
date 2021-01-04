package co.company.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import co.company.spring.config.DBConfiguration;
import co.company.spring.dao.EmpDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfiguration.class)
public class EmpDaoClient {
	@Autowired EmpDAO empDao;
	@Test
	public void empdaotest() {
		//spring에서는 객체생성할때 new쓰지말고,
		//컨테이너에서 관련하도록 @bean달아주기 (우리는component씀)
		System.out.println(empDao.getList());
	}
}
