package com.chaoui.benbaha.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Projet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",insertable = false, updatable = false)
	private long id;
	private String description ;
	@OneToMany(mappedBy="projet",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Sprint> sprints;
	@ManyToOne
	@JoinColumn(name = "chef_Projet_id")
	private ChefProjet chefProjet;
	
	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Projet(String description) {
		super();
		this.description = description;
	}

	public long getIdProjet() {
		return id;
	}
	public void setIdProjet(long idProjet) {
		this.id = idProjet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
