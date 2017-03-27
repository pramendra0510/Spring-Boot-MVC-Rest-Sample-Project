package my.spring.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.spring.model.Employee;
import my.spring.service.EmployeeService;

@Controller
public class MVCController {

	@Autowired
	private EmployeeService eService;

	@GetMapping("/home")
	public String home(HttpServletRequest Request) {
		Request.setAttribute("mode", "MODE_HOME");
		return "index";
	}

	@GetMapping("/new-emp")
	public String newEmployee(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@GetMapping("/all-emps")
	public String allEmployees(HttpServletRequest Request) {
		Request.setAttribute("emps", eService.getAll());
		Request.setAttribute("mode", "MODE_EMPs");
		return "index";
	}
	
	@GetMapping("/update-emp")
	public String updateEmployees(@RequestParam int id, HttpServletRequest Request) {
		Request.setAttribute("emp", eService.getEmployee(id)); 
		Request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@PostMapping("/save-emp")
	public String saveEmployee(@ModelAttribute Employee emp, BindingResult bindingResult, HttpServletRequest Request){
		emp.setDate(new Date());
		eService.saveEmployee(emp);
		Request.setAttribute("emps", eService.getAll());
		Request.setAttribute("mode", "MODE_EMPs");
		return "index";
	}
	
	@GetMapping("/delete-emp")
	public String deleteEmployees(@RequestParam int id, HttpServletRequest Request) {
		eService.deleteEmployee(id);
		Request.setAttribute("emps", eService.getAll()); 
		Request.setAttribute("mode", "MODE_EMPs");
		return "index";
	}
}
