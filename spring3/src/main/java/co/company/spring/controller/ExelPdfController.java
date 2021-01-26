package co.company.spring.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.company.spring.dao.EmpMapper;

@Controller
public class ExelPdfController {
	@Autowired EmpMapper dao;
	
	// pdf 출력
	@RequestMapping("/pdf/emp")
	public String pdf1(Model model) {
		model.addAttribute("filename", "/report/Emp.jasper");
		return "pdfView";
	}
	
	// pdf 출력2. 파라미터 값 받는 경우에? param 으로 넘겨줘야함
	@RequestMapping("/pdf/emp2")
	public String pdf2(Model model, @RequestParam(required = false, defaultValue = "10") String dept) {
		// 필수요소는 X고, 파라미터 안넘기면 디폴트로 10 주겠다.
		
		// 맵 만들기
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("P_DEPARTMENT_ID", dept);	// Emp2에서 파라미터를 P_DEPARTMENT_ID로 줬었는거
		model.addAttribute("filename", "/report/Emp2.jasper"); // filename 지정
		model.addAttribute("param", map); // param 은 map의 값으로 하겠다고 지정
		return "pdfView";
	}
	
	// 엑셀출력
	@RequestMapping("/deptExcelView.do")
	public ModelAndView excelView(HttpServletResponse response) throws IOException {
		List<Map<String, Object>> list = dao.getStateDept();
		HashMap<String, Object> map = new HashMap<String, Object>();
		String[] header = { "deptId", "deptName", "cnt" };
		map.put("headers", header);
		map.put("filename", "excel_dept");
		map.put("datas", list);
		return new ModelAndView("commonExcelView", map);
	}
}
