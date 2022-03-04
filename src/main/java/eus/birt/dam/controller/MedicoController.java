package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Medico;
import eus.birt.dam.repository.MedicoRepository;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	MedicoRepository medicoRepository;
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		medicoRepository.deleteById(id);
		return "redirect:/medicos";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Medico medico = new Medico();
		model.addAttribute("medico", medico);
		return "medicoForm";
	}
	
	@PostMapping("/new/submit")
	public String processCreationForm(@ModelAttribute Medico medico) {
		medicoRepository.save(medico);
		return "redirect:/medicos/";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("medico", medicoRepository.findById(id));
		return "medicoForm";
	}
	
}
