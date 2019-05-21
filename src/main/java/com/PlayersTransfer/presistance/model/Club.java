package com.PlayersTransfer.presistance.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity // This tells Hibernate to make a table out of this class
@Table(name="Club")
public class Club {
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="club_id")
	    private Integer id;

	    private String name;

	    private String Country;

	    @OneToMany(mappedBy = "club")
		private Set<Player> players = new HashSet<Player>();
	    
	    @ManyToMany
		@JoinTable(name = "clubs_users", 
			joinColumns = @JoinColumn(name = "club_id", referencedColumnName = "club_id"), 
			inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
		private Set<User> ubdateClub = new HashSet<User>();
	    
	    @ManyToMany(mappedBy="joiningClub")
		private Set<Player> registration = new HashSet<Player>();
	    
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

		public String getCountry() {
			return Country;
		}

		public void setCountry(String country) {
			this.Country = country;
		}

		public Set<Player> getPlayers() {
			return players;
		}

		public void setPlayers(Set<Player> players) {
			this.players = players;
		}

		public Set<User> getUbdateClub() {
			return ubdateClub;
		}

		public void setUbdateClub(Set<User> ubdateClub) {
			this.ubdateClub = ubdateClub;
		}

		public Set<Player> getRegistration() {
			return registration;
		}

		public void setRegistration(Set<Player> registration) {
			this.registration = registration;
		}
}
