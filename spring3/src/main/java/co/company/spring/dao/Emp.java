package co.company.spring.dao;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Emp {//	<setting name="mapUnderscoreToCamelCase" value="true" />
	@JsonProperty(value="empId")
    String employeeId;   
	String firstName;
	String lastName;
	String email;
	//@JsonFormat(pattern="yyyy/MM/dd/HH:mm:ss")
	@DateTimeFormat(pattern="YYYY-MM-DD")
	@JsonFormat(shape =Shape.STRING)
	Date hireDate;	
	String jobId;	
	String departmentId;
	@JsonIgnore Integer salary;
	@JsonIgnore String msg;
}
