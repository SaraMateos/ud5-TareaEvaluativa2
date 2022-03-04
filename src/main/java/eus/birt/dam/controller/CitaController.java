package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Cita;
import eus.birt.dam.repository.CitaRepository;
import eus.birt.dam.repository.MedicoRepository;

@Controller
@RequestMapping("/citas")
public class CitaController {

	@Autowired
	CitaRepository citaRepository;
	
	@Autowired
	MedicoRepository medicoRepository;
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		citaRepository.deleteById(id);
	return "redirect:/citas";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Cita cita = new Cita();
		model.addAttribute("cita", cita);
		model.addAttribute("medicos", medicoRepository.findAll());
		return "citaForm";
	}
	
	@PostMapping("/new/submit")
	public String processCreationForm(@ModelAttribute Cita cita) {
		citaRepository.save(cita);
		return "redirect:/citas/";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("cita", citaRepository.findById(id));
		model.addAttribute("medicos", medicoRepository.findAll());
		return "citaForm";
	}
	
}
