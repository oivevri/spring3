package co.company.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // bean 등록
public class EmpDAO {
	@Autowired
	DataSource ds;// db커넥션을 가져옴

	Connection conn;
	PreparedStatement pstmt;
	final String SELECT = "SELECT * FROM EMPLOYEES";
	final String INSERT = "INSERT INTO FROM EMPLOYEES" 
			+ "(EMPLOYEE_ID,FIRST_NAME,EMAIL,HIRE_DATE,JOB_ID)"
			+ " VALUES(?,?,?,SYSDATE,'IT_PROG')";

	public void insert(Emp emp) {
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getLastName());
			pstmt.setString(3, emp.getEmail());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Emp> getList() {
		ArrayList<Emp> list = new ArrayList<Emp>();
		try {
			// spring은datasource로 부터 가져옴
			conn = ds.getConnection(); // 이부분만 바뀜
			pstmt = conn.prepareStatement(SELECT);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setFirstName(rs.getNString("first_name"));
				emp.setLastName(rs.getNString("last_name"));
				emp.setEmployeeId(rs.getNString("employee_id"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

}
