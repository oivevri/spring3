package co.company.spring;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.company.spring.config.DBConfiguration;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpMapper;
import co.company.spring.dao.EmpSearch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfiguration.class)
public class EmpDaoMybatisClient {

	@Autowired
	EmpMapper empDAO;

	//@Test
	public void empdaotest() {
		//Emp empvo = new Emp();
		EmpSearch empvo = new EmpSearch();
		empvo.setMinSalary(4000);
		empvo.setMaxSalary(50000);
		//empvo.setSalary(10000);
		//empvo.setFirstName("pat");
		//empvo.setFirstName("ex");
		//empvo.setDepartmentId("20");
		List<Emp> list = empDAO.getEmpList(empvo);
		for (Emp emp : list) {
			System.out.println(emp.getEmployeeId()   + ":" 
							 + emp.getFirstName()    + ":" 
							 + emp.getDepartmentId() + ":"
							 + emp.getJobId()+ ":"
							 + emp.getSalary()
							 );
		}
	}
	
	
	//EMP UPDATE TEST
	//@Test
	public void updateTest() {
		Emp emp = new Emp();
		
		//변경전 단건조회
		emp.setEmployeeId("205");
		System.out.println(empDAO.getEmp(emp));
		System.out.println("-------------------");
		
		//변경후 단건조회
		emp.setLastName("ggggg");
		empDAO.updateEmp(emp);
		System.out.println(empDAO.getEmp(emp));
	}
	
	
	//@Test
	public void deleteTest() {
		Emp emp = new Emp();
		
		//단건삭제
		//emp.setEmployeeId("205");
		System.out.println("-------------------");
		
	}
	
	//전체 레코드 건수 조회
	//@Test
	public void getCount() {
		System.out.println(empDAO.getCount1());
	}
	
	
	//전체 레코드 건수 조회+조건절 추가
		//@Test
		public void getCountTest() {
			EmpSearch empvo = new EmpSearch();
			empvo.setMinSalary(5000);
			empvo.setMaxSalary(5500);
			System.out.println(empDAO.getCount2(empvo));
		}
		
		
	//테이블 JOIN SELECT 하기	
		@Test
		public void getStateDeptTest() {
			List<Map<String,Object>> list = 
					empDAO.getStateDept();
			System.out.println(list.get(0));
			System.out.println(list.get(0).get("deptName"));
			//System.out.println(list.get(0).get(""));
		}	
		
	
	
	//프로시저 사용 insert
	//@Test
	public void insertProcTest() {
		Emp emp = new Emp();
		emp.setFirstName("seonae");
		emp.setEmail("seonae@naver.com");
		emp.setJobId("AC_MGR");
		empDAO.insertEmpProc(emp);
		System.out.println(emp.getEmployeeId()+":"
				+emp.getMsg());
	}
	
	
	//@Test
	public void insertTest() {
		Emp emp = new Emp();
		//emp.setEmployeeId("1005");
		emp.setFirstName("slDDsh");
		emp.setLastName("gg");
		emp.setEmail("gDg@naver.com");
		emp.setHireDate(new Date(System.currentTimeMillis()));
		emp.setJobId("AC_MGR");
		empDAO.insertEmp(emp);
		System.out.println(emp.getEmployeeId());
	}
	
	//@Test
	public void multideleteTest() {
		//선택 다건 삭제
		EmpSearch empM = new EmpSearch();
		empM.setList(new String[] {"1002","1003"});
		empDAO.deleteMultiEmp(empM);
		
	}
}
