package hanh.codelean.ex4.service;

import java.util.List;

import hanh.codelean.ex4.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}
