	package co.company.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.company.spring.dao.Departments;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpMapper;
import co.company.spring.dao.EmpSearch;
import co.company.spring.dao.Jobs;
import co.company.spring.emp.service.EmpService;

@Controller
public class EmpController {
	@Autowired EmpService service;//serviceImpl 클래스를 받아옴
	
	@RequestMapping("/ajax/jobSelect")
	@ResponseBody // json구조로 변환시켜 달라는 어노테이션
	public List<Jobs> jobSelect() {
		return service.jobSelect(); 
	}
	
	@ModelAttribute("jobs")
	public List<Jobs> jobs() {
		return service.jobSelect();
	}
	
	@ModelAttribute("departments")
	public List<Departments> depts() {
		return service.departSelect();
	}
	
	@RequestMapping(value = "/empSelect",method = RequestMethod.GET)//단순조회
	public ModelAndView select(EmpSearch emp) {
		ModelAndView mav = new ModelAndView();
		
		//전체 사원정보 조회해서 보냄
		mav.addObject("list", service.getEmpList(emp));
		mav.setViewName("emp/select");
		return mav; //return할때 아무것도 없으면 default - forword임
	}
	
	@GetMapping("/empInsertForm") //등록페이지로 가기
	public String insertForm(Model model, Emp emp) {
//		model.addAttribute("jobs",service.jobSelect());
//		model.addAttribute("departments",service.departSelect());
		return "emp/insert";
	}
	
	//--업데이트--
	@GetMapping("/empUpdateForm") //등록페이지로 가기
	public String updateForm(Model model, Emp emp) {
		model.addAttribute("emp",service.getEmp(emp));
//		model.addAttribute("jobs",dao.jobSelect());
//		model.addAttribute("departments",dao.departSelect());
		return "emp/insert";
	}
	
	
	//사원등록
	@PostMapping("/empInsert")
	public String insert(Model model, Emp emp,Errors errors) {
		new EmpValidator().validate(emp,errors);
		if(errors.hasErrors()) {
			return "emp/insert";
		}
		if(emp.getEmployeeId() == null) {
			service.insertEmp(emp);
		} else {
			service.updateEmp(emp);		
		}
	
		System.out.println(emp);
		//return  "redirect:empSelect";
		//request.setAttrabute("emp",emp);
		return  "emp/insertOutput";
		
		
	}
	
//	@PostMapping("/empInsert") //등록처리
//	//public String insert(HttpServletRequest request,@RequestParam String lastName) {
//	public String insert(HttpServletRequest request,@RequestParam (value="lastName", 
//																	required = false,
//																	defaultValue = "noname") 
//																	String lName,
//													 @RequestParam (value="salary", 
//																	required = false) 
//																	int salary,
//																	Emp emp) {
//		//파라미터 
//		String fName = request.getParameter("firstName");
//		System.out.println(lName + ":" + fName+":" + salary);
//		System.out.println("emp\n" + emp);
//		String firstName = request.getParameter("firstName");
//		System.out.println(lastName + ":" + firstName);
//		//(등록처리 (처리하고 나서는 다시 조회 페이지로 보낼예정)
//		//redirect
//		return "redirect:empSelect";
//		}
//	
//	
//
	//원래 사용방법
//	@PostMapping("/empInsert") //등록처리
//	public String insert(HttpServletRequest request) {
//		//등록처리 (처리하고 나서는 다시 조회 페이지로 보낼예정)
//		String firstName = request.getParameter("firstName");
//		//redirect
//		return "redirect:empSelect";
//		}
//	
	
	
}
