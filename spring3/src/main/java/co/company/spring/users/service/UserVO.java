package co.company.spring.users.service;

import lombok.Data;

@Data
public class UserVO {
	
	private String id;
	private String password;
	private String name;
	private String role;
	private String profile;
	

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name
				+ ", role=" + role + "]";
	}
	
}
