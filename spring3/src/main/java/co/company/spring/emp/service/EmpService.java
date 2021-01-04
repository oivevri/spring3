package co.company.spring.emp.service;

import java.util.List;
import java.util.Map;

import co.company.spring.dao.Departments;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpSearch;
import co.company.spring.dao.Jobs;

public interface EmpService {
	
	//public List<Emp> getEmpList(Emp emp);
		//단건조회면 List빼고 emp만 사용하면됨
		
		//Emp.java
		public List<Emp> getEmpList(Emp emp);
		
		
		//-------------------------------------
		//EmpSearch.java 검색용 vo만들고 난 후
		public List<Emp> getEmpList(EmpSearch emp);
		
		//전체 데이터 카운트
		public int getCount2(EmpSearch emp);
		
		// 항상 전체조회하고 카운트하고 두개는 묶어 쓰기
		//-------------------------------------
		
		
		
		
		//update
		public int updateEmp(Emp emp);
		
		//단건 등록
		public int insertEmp(Emp emp);
		
		//단건조회
		public Emp getEmp(Emp emp);
		
		//단건 삭제
		public int deleteEmp(Emp emp);
		
		//선택 다건 삭제
		public int deleteMultiEmp(EmpSearch emp);
		
		//프로시저 사원 등록
		public void insertEmpProc(Emp emp);
		
		//전체 레코드 건수 조회
		public int getCount1();
		
		//테이블 join 조회 (key값은 보통String, 값은 object)
		public List<Map<String,Object>> getStateDept();
		
		//joblist option 지정
	    public List<Jobs> jobSelect();
	    
	  //joblist option 지정
	    public List<Departments> departSelect();
	    
}
