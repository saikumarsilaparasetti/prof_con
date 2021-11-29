package com.mindtree.professionalconsultancyservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.professionalconsultancyservice.entity.Employee;
import com.mindtree.professionalconsultancyservice.entity.User;
import com.mindtree.professionalconsultancyservice.service.EmployeeRepository;
import com.mindtree.professionalconsultancyservice.service.UserRepository;


@RestController
public class EmployeeController {
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository repo;
	@Autowired
	private UserRepository userRepo;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employees")
	List<Employee> getEmployees(){
		return repo.findAll();
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/employees/add/{name}/{email}/{password}/{skills}")
	void addEmployee(@PathVariable String name, @PathVariable String email, @PathVariable String password, @PathVariable String skills) {
		String temSkill = "";
		for(int i=0;i<skills.length();i++)
			if(skills.charAt(i)!=' ')
				temSkill+=skills.charAt(i);
		
		Employee e = new Employee(name, email, password, temSkill);
		repo.save(e);
		log.info("New employee added "+e);
	}
	
	boolean isValid(String s1, String s2) {
		String[] sk1 = s1.split(",");
		String[] sk2 = s2.split(",");
		Arrays.sort(sk1);
		Arrays.sort(sk2);
		for(String s:sk1)
			for(String ss:sk2)
				if(s.equalsIgnoreCase(ss))
					return true;
		return false;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employees/{skills}")
	List<User> getEmpWithSkills(@PathVariable String skills){
		List<User> list = new ArrayList<>();
		List<Employee> temp = repo.findAll();
		for(User e:temp) {
			if(isValid(e.getSkills(),skills))
				list.add(e);
		}
		return list;
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/user/validate/{email}/{password}")
	String validate(@PathVariable String email, @PathVariable String password) {
		List<User> users = userRepo.findAll();
		for(User user:users) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return "["
						+ "{"
						+ "\"message\":\""+user.getType()
						+"\","
						+ "\"skills\":\""+user.getSkills()+"\",\"id\":"+user.getId()+"}]";
				
				//return user.getType();
			}
		}
		return null;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/user/update/{id}/{email}/{skills}")
	void updateUser(@PathVariable int id,@PathVariable String email,@PathVariable String skills) {
		User u = userRepo.getById(id);
		u.setEmail(email);
		u.setSkills(skills);
		userRepo.save(u);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/user/delete/{id}")
	void deleteUser(@PathVariable int id) {
		userRepo.deleteById(id);
		log.info("user deleted");
	}
	
//	@CrossOrigin(origin="http://localhost:4200")
//	@GetMapping("/employees/")
}
