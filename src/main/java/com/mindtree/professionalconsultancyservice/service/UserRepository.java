package com.mindtree.professionalconsultancyservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.professionalconsultancyservice.entity.User;

//interface GetExceptPassword{
//	String getName();
//	String getEmail();
//	String getSkills();
//}

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
