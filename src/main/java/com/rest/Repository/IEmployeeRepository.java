package com.rest.Repository;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.Model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
