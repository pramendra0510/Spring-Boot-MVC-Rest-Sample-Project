package my.spring.dao;

import org.springframework.data.repository.CrudRepository;

import my.spring.model.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Integer>{

}
