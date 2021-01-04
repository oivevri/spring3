package co.company.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.company.spring.config.DBConfiguration;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpDAOJdbcTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfiguration.class)
public class EmpDaoJdbcTemplateClient {
	
	@Autowired EmpDAOJdbcTemplate empDao; //autowired - bean을 가져옴
	@Test
	public void empdaotest() {
		//spring에서는 객체생성할때 new쓰지말고,
		//컨테이너에서 관련하도록 @bean달아주기 (우리는component씀)
		System.out.println(empDao.getListMap());
	}
	
	@Test
	public void insert() {
		Emp emp = new Emp();
		emp.setEmployeeId("10120");
		emp.setFirstName("집가자");
		emp.setEmail("1000번의 이메일");
		empDao.insert(emp);
	}
}
