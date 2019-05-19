package com.example.PlayersTransfer.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="Player")
public class Player {

	@Id
	private int P_ID;

    private String name;

    private int age;
    
    public int getId() {
		return P_ID;
	}

	public void setId(int id) {
		this.P_ID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
