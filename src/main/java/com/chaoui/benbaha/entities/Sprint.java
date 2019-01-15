package com.chaoui.benbaha.entities;

import java.util.HashSet;
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
public class Sprint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",insertable = false, updatable = false)
	private long id;
	private int nbrTaches;
	@OneToMany(mappedBy="sprint",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Tache> taches=new HashSet<>();
	@ManyToOne
	@JoinColumn(name = "projet_id")
	private Projet projet;
	
	public Sprint() {
		super();
		this.nbrTaches=0;
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNbrTaches() {
		return nbrTaches;
	}
	public void setNbrTaches(int nbrTaches) {
		this.nbrTaches = nbrTaches;
	}
	
}
