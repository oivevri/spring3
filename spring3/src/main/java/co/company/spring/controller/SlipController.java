package co.company.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SlipController {
	@RequestMapping("/slip3")
	public void slip3() {
		
		// RestTemplate : 스프링에서 지원해줌
		
		
		// Jackson : 자바객체를 json 구조의 스트링으로 변환 
		
	}

	@RequestMapping("/slip2")
	public ResponseEntity slip(@RequestBody List<SlipVO> list) {

		if (list.size() < 1) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("process", true); // 처리결과
			map.put("tcount", list.size()); // 전체 건수
			map.put("pcount", list.size()); // 전체 건수
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}
	}

	@RequestMapping("/slip1")
	@ResponseBody
	public Map<String, Object> slip(@RequestBody List<SlipVO> list, HttpServletResponse response) {
		System.out.println(">>>> slip : " + list);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("process", true); // 처리결과
		map.put("tcount", list.size()); // 전체 건수
		map.put("pcount", list.size()); // 전체 건수
		return map;
	}
}
