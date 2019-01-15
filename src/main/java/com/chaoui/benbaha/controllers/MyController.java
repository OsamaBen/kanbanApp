package com.chaoui.benbaha.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	private long IDlogin = 0;
	
	@RequestMapping(value="/")
	public String goIndex(Model model) {
		 return "index";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "v_login";
	}
	
	@PostMapping("/login")
	public String login(Model model, @RequestParam String username,@RequestParam String password
									,HttpSession session){
		ChefProjet chefProjet = chefProjetDao.findByUsernameAndPassword(username,password);
		Colaborateur colaborateur = colaborateurDao.findByUsernameAndPassword(username,password);
		
		if(chefProjet!=null) {
			session.setAttribute("IDlogin", chefProjet.getId());
			IDlogin = chefProjet.getId();
			return "v_listeProjets";
		}
		if(colaborateur!=null) {
			session.setAttribute("IDlogin", colaborateur.getId());
			IDlogin = colaborateur.getId();
			return "colaborateur";
		}
		
		return "v_login";
	}
	
	@GetMapping("/projets/c")
	public String creerProjet()
	{
		return "v_creeProjet";
	}
	
	@PostMapping("/projets/c")
	public String creerProjet(@Valid Projet projet)
	{
		projet.setChefProjet(chefProjetDao.findById(IDlogin));
		projetDao.save(projet);
		return "v_listeProjets";
	}
	
	@GetMapping("/projets")
	public ModelAndView getProjets()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("v_listeProjets");
		mv.addObject("listeProjets", projetDao.findAll());		
		return mv;
	}
	
	@PostMapping("/sprints/c")
	public String creerSprint(@Valid Sprint sprint){
	   sprintDao.save(sprint);
	   return "index";
	}
	
	@PostMapping("/taches/c")
	public String creerTache(@Valid Tache tache){
		tacheDao.save(tache);
		return "index";
	}
}
