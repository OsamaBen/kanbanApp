package com.chaoui.benbaha.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Colaborateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",insertable = false, updatable = false)
	private long id;
	private String firstName;
	private String lastName;
	private String sexe;
	private String phone;
	private String adresse;
	private String email;
	private String username;
	private String password;
	@OneToOne
	@JoinColumn(name = "tache_id")
	private Tache tache;
	@ManyToOne
	@JoinColumn(name = "Chef_Projet_id")
	private ChefProjet chefProjet;
	
	public Colaborateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Colaborateur(String firstName, String lastName, String sexe, String phone, String adresse, String email,
			String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sexe = sexe;
		this.phone = phone;
		this.adresse = adresse;
		this.email = email;
		this.username = username;
		this.password = password;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
