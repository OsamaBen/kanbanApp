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
	private String titre ;
	
	@OneToMany(mappedBy="projet",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Sprint> sprints;
	@ManyToOne @JoinColumn(name = "chef_Projet_id")
	private ChefProjet chefProjet;
	
	public Projet() {}
	
	public Projet(String description) {
		this.titre = description;
	}

	public long getIdProjet() {
		return id;
	}
	public void setIdProjet(long idProjet) {
		this.id = idProjet;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String description) {
		this.titre = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(Set<Sprint> sprints) {
		this.sprints = sprints;
	}

	public ChefProjet getChefProjet() {
		return chefProjet;
	}

	public void setChefProjet(ChefProjet chefProjet) {
		this.chefProjet = chefProjet;
	}
	
	
}
