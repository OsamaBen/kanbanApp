package com.chaoui.benbaha.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaoui.benbaha.entities.ChefProjet;

public interface ChefProjetDao extends JpaRepository<ChefProjet, Long>{

	ChefProjet findByUsernameAndPassword(String username, String password);
	ChefProjet findById(long id);
}
