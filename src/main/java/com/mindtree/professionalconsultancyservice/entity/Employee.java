package com.mindtree.professionalconsultancyservice.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee extends User{
	@Id
	@GeneratedValue
	int id;
	String name;
	String email;
	String password;
	String skills;
	public Employee() {
		
	}
	public Employee(String name, String email, String password, String skills) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.skills = skills;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	public String getType() {
		return "Employee";
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", skills="
				+ skills + "]";
	}
	
	
	
	
}
