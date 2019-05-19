package com.example.PlayersTransfer.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="Club")
public class Club {

	@Id
	private int C_ID;

    private String name;

    private String Country;

	public int getId() {
		return C_ID;
	}

	public void setId(int id) {
		this.C_ID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

}
