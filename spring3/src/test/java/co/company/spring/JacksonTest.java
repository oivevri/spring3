package co.company.spring;

import java.net.URL;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.company.spring.controller.SlipVO;

public class JacksonTest {

	@Test
	public void test1() {
		ObjectMapper mapper = new ObjectMapper();
		String str = "[{\"slipAmount\":28294,\"salDt\":\"202101\",\"customer\":\"114\",\"bankAcct\":\"2135t\"}]";
		try {
			// 1. readTree에 string
			JsonNode node = mapper.readTree(str);
			System.out.println("1. readTree에 string >> " + node.get(0).path("slipAmount"));
			
			// 2. readValue
			SlipVO[] list = mapper.readValue(str, SlipVO[].class);
			// 배열로 받아와야함.. 그래서 string 배열로...
			System.out.println("2. readValue >> " + list[0].getSlipAmount());
			
			// 3. readTree에 url -> 영화정보 api를 땡겨와보자
			URL url = new URL("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101");
			JsonNode movie = mapper.readTree(url);
			System.out.println("3. readTree에 url >> " + movie);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
