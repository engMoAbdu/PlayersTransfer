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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="Player")
public class Player {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="player_id")
    private Integer id;

    private String name;

    private int age;

    @ManyToOne
	@JoinColumn (name="club_id")
	@JsonBackReference
	private Club club;
    
    @ManyToMany
	@JoinTable(name = "players_users", 
		joinColumns = @JoinColumn(name = "player_id", referencedColumnName = "player_id"), 
		inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
	private Set<User> PlayersTransfer = new HashSet<User>();
    
    @ManyToMany
	@JoinTable(name = "clubs_players", 
		joinColumns = @JoinColumn(name = "player_id", referencedColumnName = "player_id"), 
		inverseJoinColumns = @JoinColumn(name = "club_id", referencedColumnName = "club_id"))
	private Set<Club> joiningClub = new HashSet<Club>();
    
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Set<User> getPlayersTransfer() {
		return PlayersTransfer;
	}

	public void setPlayersTransfer(Set<User> playersTransfer) {
		PlayersTransfer = playersTransfer;
	}

	public Set<Club> getJoiningClub() {
		return joiningClub;
	}

	public void setJoiningClub(Set<Club> joiningClub) {
		this.joiningClub = joiningClub;
	}
}
