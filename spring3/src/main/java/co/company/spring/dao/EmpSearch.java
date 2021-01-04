package co.company.spring.dao;

import lombok.Data;

@Data
public class EmpSearch extends Emp {
	//int 보다는 Integer가 null체크하기 더 편함
	Integer	minSalary;
	Integer	maxSalary;
	Integer first;
	Integer last;
	String[] list;
}
