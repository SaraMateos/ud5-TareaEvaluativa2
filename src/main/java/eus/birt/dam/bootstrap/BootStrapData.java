/*package eus.birt.dam.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.domain.Medico;
import eus.birt.dam.repository.MedicoRepository;


@Component
public class BootStrapData implements CommandLineRunner {
	
	@Autowired
	MedicoRepository medicoRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		Medico medico1 = new Medico("Geraint", "Thomas",LocalDate.parse("1989-04-04"),"Cardiologo");
		medicoRepository.save(medico1);
		System.out.println("Started in Bootstrap");
        System.out.println("Number of medics: " + medicoRepository.count());
			
	}
	
}*/