package my.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.spring.model.Employee;
import my.spring.service.EmployeeService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	private EmployeeService eService;

	@Autowired
	public void seteService(EmployeeService eService) {
		this.eService = eService;
	}

	@RequestMapping("/")
	public String get(){
		return "I'm Up!!!";
	}
	
	@GetMapping("/r_get-all-emp")
	public String getAllEmployee() {
		return eService.getAll().toString();
	}
	
	@GetMapping("/r_save-emp")
	public String saveEmployee(@RequestParam String Fname, @RequestParam String Mname, @RequestParam String Lname) {
		Employee emp = new Employee(Fname, Mname, Lname, new Date(), true);
		eService.saveEmployee(emp);
		return "Employee data saved!";
	}
	
	@GetMapping("/r_delete-emp")
	public String deleteEmployee(@RequestParam int id) {
		eService.deleteEmployee(id);
		return "Employee data deleted!";
	}
}
