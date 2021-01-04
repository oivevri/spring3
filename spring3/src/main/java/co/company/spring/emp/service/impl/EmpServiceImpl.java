package co.company.spring.emp.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.company.spring.dao.Departments;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpMapper;
import co.company.spring.dao.EmpSearch;
import co.company.spring.dao.Jobs;
import co.company.spring.emp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired EmpMapper dao;
	
	@Override
	public List<Map<String, Object>> getStateDept() {
		return dao.getStateDept();
	}
	
	@Override
	public List<Emp> getEmpList(Emp emp) {
		return  dao.getEmpList(emp);
	}

	@Override
	public List<Emp> getEmpList(EmpSearch emp) {
		return dao.getEmpList(emp);
	}

	@Override
	public int getCount2(EmpSearch emp) {
		return dao.getCount2(emp);
	}

	@Override
	public int updateEmp(Emp emp) {
		return dao.updateEmp(emp);
	}

	@Override
	public int insertEmp(Emp emp) {
		return dao.insertEmp(emp);
	}

	@Override
	public Emp getEmp(Emp emp) {
		return dao.getEmp(emp);
	}

	@Override
	public int deleteEmp(Emp emp) {
		return dao.deleteEmp(emp);
	}

	@Override
	public int deleteMultiEmp(EmpSearch emp) {
		return dao.deleteMultiEmp(emp);
	}

	@Override
	public void insertEmpProc(Emp emp) {
		
	}

	@Override
	public int getCount1() {
		return dao.getCount1();
	}


	@Override
	public List<Jobs> jobSelect() {
		return dao.jobSelect();
	}

	@Override
	public List<Departments> departSelect() {
		return dao.departSelect();
	}
	
	
}
