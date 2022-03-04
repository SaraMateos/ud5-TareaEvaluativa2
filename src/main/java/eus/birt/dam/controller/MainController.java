package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eus.birt.dam.repository.CitaRepository;
import eus.birt.dam.repository.MedicoRepository;

@Controller
public class MainController {

	@Autowired
	MedicoRepository medicoRepository;
	
	@Autowired
	CitaRepository citaRepository;
	
	@GetMapping({"/", "/welcome"})
	public String welcome() {
		return "index";
	}
	
	@GetMapping({"/medicos"})
	public String getMedicos(Model model) {
		model.addAttribute("medicos", medicoRepository.findAll());
		return "medicos";
	}
	
	@GetMapping({"/citas"})
	public String getCitas(Model model) {
		model.addAttribute("citas", citaRepository.findAll());
		return "citas";
	}
}
