package com.rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rest.Exception.Mensaje;
import com.rest.Model.Employee;
import com.rest.Service.IEmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
		RestTemplate restTemplate = new RestTemplate();

		@Autowired
		private	IEmployeeService employeeservice;

		@GetMapping("/FindAll")
		public ResponseEntity<?> getAll() {
			List<Employee> lista = employeeservice.getAll();
			if(lista.isEmpty()){
				return new ResponseEntity<>(new Mensaje("Sin resgistros en la Base de Datos"), HttpStatus.BAD_REQUEST);
			}
			return ResponseEntity.ok().body(employeeservice.getAll());
		}

		@GetMapping("/FindById/{id}")
		public ResponseEntity<Employee> getbyId(@PathVariable long id) {
			return ResponseEntity.ok().body(employeeservice.getById(id));
		
		}
		
		@PostMapping("/New")
		public ResponseEntity<Employee>neww(@RequestBody Employee employee) {
			return ResponseEntity.ok().body(this.employeeservice.neww(employee));
		}
		
		@PutMapping("/Update/{id}")
		public ResponseEntity<Employee> update(@PathVariable long id, @RequestBody Employee employee) {
			employee.setId(id);
			return ResponseEntity.ok().body(this.employeeservice.update(employee));
		}
		
		@DeleteMapping("/Delete/{id}")
		public HttpStatus delete(@PathVariable long id) {
			this.employeeservice.deleteEmployee(id);
			return HttpStatus.OK;
		}
		
		
		
	}


