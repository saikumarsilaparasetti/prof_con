package com.mindtree.professionalconsultancyservice.service;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.professionalconsultancyservice.entity.Employee;
import com.mindtree.professionalconsultancyservice.entity.User;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
