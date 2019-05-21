package com.PlayersTransfer.presistance.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity // This tells Hibernate to make a table out of this class
@Table(name="User")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Integer id;

	private String name;
	private String email;

	private int age;
	
	@ManyToMany(mappedBy="ubdateClub")
	private Set<Club> ubdate = new HashSet<Club>();
	
	@ManyToMany(mappedBy="PlayersTransfer")
	private Set<Player> Transfer = new HashSet<Player>();
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Set<Club> getUbdate() {
		return ubdate;
	}

	public void setUbdate(Set<Club> ubdate) {
		this.ubdate = ubdate;
	}

	public Set<Player> getTransfer() {
		return Transfer;
	}

	public void setTransfer(Set<Player> transfer) {
		Transfer = transfer;
	}
}
