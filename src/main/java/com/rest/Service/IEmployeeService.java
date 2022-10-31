package com.rest.Service;

import java.util.List;

import com.rest.Model.Employee;

public interface IEmployeeService {
	
Employee neww(Employee employee);
	
Employee update(Employee employee);

	List<Employee> getAll();
	Employee getById(long employeeId);
	
	void deleteEmployee(long id);

}
