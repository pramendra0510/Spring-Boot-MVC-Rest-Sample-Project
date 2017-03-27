package my.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import my.spring.dao.IEmployeeRepository;
import my.spring.model.Employee;

@Service
@Transactional
public class EmployeeService {
	private final IEmployeeRepository eRepository;

	public EmployeeService(IEmployeeRepository eRepository) {
		this.eRepository = eRepository;
	}
	
	public List<Employee> getAll() {
		List<Employee> ls = new ArrayList<Employee>();
		for(Employee e : eRepository.findAll())
			ls.add(e);
		return ls;
	}

	public Employee getEmployee(int id) {
		return eRepository.findOne(id);
	}

	public void saveEmployee(Employee emp) {
		eRepository.save(emp);
	}
	
	public void deleteEmployee(int emp_id) {
		eRepository.delete(emp_id);
	}
	
}
