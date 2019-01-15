package com.chaoui.benbaha.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tache {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",insertable = false, updatable = false)
	private long id; 
	private String etat  ;
	private String description  ;
	private int duree;
	
	@ManyToOne
	@JoinColumn(name = "sprint_id")
	private Sprint sprint;
	@ManyToOne
	@JoinColumn(name = "colaborateur_id")
	private Colaborateur colaborateur;
	
	public Tache() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Tache(String description, int duree) {
		super();
		this.etat = "a_faire";
		this.description = description;
		this.duree = duree;
	}


	public long getIdTache() {
		return id;
	}
	public void setIdTache(long idTache) {
		this.id = idTache;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	
	
}
