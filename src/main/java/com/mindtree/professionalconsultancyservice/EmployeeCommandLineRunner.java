package com.mindtree.professionalconsultancyservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mindtree.professionalconsultancyservice.entity.Employee;
import com.mindtree.professionalconsultancyservice.service.EmployeeRepository;

@Component
public class EmployeeCommandLineRunner implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(EmployeeCommandLineRunner.class);
	@Autowired
	private EmployeeRepository repo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employee e1 = new Employee("Sai", "saik@gmail.com", "1234","Java,c++");
		Employee e2 = new Employee("Chandu", "chandu@gmail.com", "12ab", "Java,C++,python");
		repo.save(e1);
		repo.save(e2);
		log.info("Employees added to db");
		
	}

}
