package co.company.spring;

import co.company.spring.controller.MemberVO;

public class LombokTest {
	public static void main(String[] args) {
		MemberVO member = MemberVO.builder().id("seonae").name("뭉또냉이").build(); // 생성자를 통한 필드 초기화
		System.out.println(member.getId());
		System.out.println(member.getName());
	}
}
