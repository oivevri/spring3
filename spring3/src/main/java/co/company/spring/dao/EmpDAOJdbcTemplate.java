package co.company.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component //test에서 사용하려고 여기도 달아줌
public class EmpDAOJdbcTemplate {
	final String SELECT = "SELECT * FROM EMPLOYEES";
	final String INSERT = "INSERT INTO EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,EMAIL,HIRE_DATE,JOB_ID) VALUES (?,?,?,SYSDATE,'IT_PROG')";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<Map<String,Object>> getListMap() {
		return jdbcTemplate.queryForList(SELECT);
		//조회할때는 query사용
	}
	
	public void insert(Emp emp) {
		Object[] param = new Object[] {
				emp.getEmployeeId(),
				emp.getFirstName(),
				emp.getEmail()
		};
		jdbcTemplate.update(INSERT,param);
	}
	
	public List<Emp> getList() {
		return jdbcTemplate.query(SELECT, new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp emp = new Emp();
				emp.setFirstName(rs.getNString("first_name"));
				emp.setLastName(rs.getNString("last_name"));
				emp.setEmployeeId(rs.getNString("employee_id"));
				return emp;
			}});
	}
}
