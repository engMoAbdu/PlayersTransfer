package com.example.PlayersTransfer.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="User")
public class User {

	@Id
	private int U_ID;
	private String name;
	private String email;
	private int age;
	
	public int getId() {
		return U_ID;
	}
	public void setId(int id) {
		this.U_ID = id;
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
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
