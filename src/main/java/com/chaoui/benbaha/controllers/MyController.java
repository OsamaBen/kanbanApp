package com.chaoui.benbaha.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chaoui.benbaha.dao.ChefProjetDao;
import com.chaoui.benbaha.dao.ColaborateurDao;
import com.chaoui.benbaha.dao.ProjetDao;
import com.chaoui.benbaha.dao.SprintDao;
import com.chaoui.benbaha.dao.TacheDao;
import com.chaoui.benbaha.entities.ChefProjet;
import com.chaoui.benbaha.entities.Colaborateur;
import com.chaoui.benbaha.entities.Projet;
import com.chaoui.benbaha.entities.Sprint;
import com.chaoui.benbaha.entities.Tache;

@Controller
@RequestMapping(value="/kanban")
public class MyController {

	@Autowired
	ChefProjetDao chefProjetDao;
	@Autowired
	ColaborateurDao colaborateurDao;
	@Autowired
	TacheDao tacheDao;
	@Autowired
	ProjetDao projetDao;
	@Autowired
	SprintDao sprintDao;
	
	
	@RequestMapping(value="/")
	public String goIndex(Model model) {
		 return "index";
	}
	
	
	@PostMapping("/login")
	public String login(Model model, @RequestParam String username,@RequestParam String password
									,HttpSession session){
		ChefProjet chefProjet = chefProjetDao.findByUsernameAndPassword(username,password);
		Colaborateur colaborateur = colaborateurDao.findByUsernameAndPassword(username,password);
		if(chefProjet!=null) {
			return "chefProjet";
		}
		if(colaborateur!=null) {
			return "colaborateur";
		}
		return "index";
	}
	
	@PostMapping("/ChefProjet/CreeProjet")
	public String creeProjet(@Valid Projet projet){
		   projetDao.save(projet);
				return "index";
						}
	
	@PostMapping("/ChefProjet/CreeSprint")
	public String creeProjet(@Valid Sprint sprint){
		   sprintDao.save(sprint);
				return "index";
						}
	
	@PostMapping("/ChefProjet/CreeTache")
	public String creeProjet(@Valid Tache tache){
		   tacheDao.save(tache);
				return "index";
						}
}
