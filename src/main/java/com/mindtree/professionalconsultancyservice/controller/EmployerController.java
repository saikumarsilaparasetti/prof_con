package com.mindtree.professionalconsultancyservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.professionalconsultancyservice.entity.Employer;
import com.mindtree.professionalconsultancyservice.service.EmployerRepository;

@RestController
public class EmployerController {

	@Autowired
	EmployerRepository repo;
	private static final Logger log = LoggerFactory.getLogger(EmployerController.class);
	@PostMapping("/employer/add/{name}/{email}/{password}/{skills}")
	void addEmployer(@PathVariable String name, @PathVariable String email, @PathVariable String password, @PathVariable String skills) {
		Employer e = new Employer(name, email, password, skills);
		repo.save(e);
		log.info("New employer added"+e);
	}
}
