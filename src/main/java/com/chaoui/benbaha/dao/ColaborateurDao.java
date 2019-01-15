package com.chaoui.benbaha.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaoui.benbaha.entities.Colaborateur;

public interface ColaborateurDao extends JpaRepository<Colaborateur, Long>{

	Colaborateur findByUsernameAndPassword(String username, String password);

}
