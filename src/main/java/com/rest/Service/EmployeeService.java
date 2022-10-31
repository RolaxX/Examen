package com.rest.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rest.Exception.ResourceNotFoundException;
import com.rest.Model.Employee;
import com.rest.Repository.IEmployeeRepository;

@Service 
@Transactional 
public class EmployeeService implements IEmployeeService{
	
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAll() {
		return this.employeeRepository.findAll();
	}
	@Override
	public Employee neww(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	
	@Override
	public Employee update(Employee employee) {
		Optional<Employee> employeedb = this.employeeRepository.findById(employee.getId());
        
		if (employeedb.isPresent()) {
			Employee employeeUpdate = employeedb.get();
			employeeUpdate.setId(employee.getId());
			employeeRepository.save(employeeUpdate);
			return employeeUpdate;
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + employee.getId());
		}
	}

	@Override
	public Employee getById(long employeeId) {

		Optional<Employee> employeedb = this.employeeRepository.findById(employeeId);

		if (employeedb.isPresent()) {
			return employeedb.get();
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + employeeId);
		}
	}

	@Override
	public void deleteEmployee(long employeeId) {
		Optional<Employee> employeedb = this.employeeRepository.findById(employeeId);

		if (employeedb.isPresent()) {
			this.employeeRepository.delete(employeedb.get());
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + employeeId);
		}

	}


}