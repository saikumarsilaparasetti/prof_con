package com.mindtree.professionalconsultancyservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mindtree.professionalconsultancyservice.entity.Employer;
import com.mindtree.professionalconsultancyservice.service.EmployerRepository;

@Component
public class EmployerCommandLineRunner implements CommandLineRunner{

	@Autowired
	EmployerRepository repo;
	private static final Logger log = LoggerFactory.getLogger(EmployerCommandLineRunner.class);
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employer e1= new Employer("Jhon","Jhon@gmail.com", "1234", "Java");
		Employer e2= new Employer("Keven","keven@gmail.com", "12sa34", "Python");
		repo.save(e1);
		repo.save(e2);
		log.info("Employers added to db");
		
	}

}
