package eus.birt.dam.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="medico")
public class Medico {

	@Id
	@SequenceGenerator(name="col_gen2", sequenceName="col_sqe2", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="col_gen2")
	
	private Long id;
	
	//@Column(name="nombre")
	private String nombre;
	
	//@Column(name="apellidos")
	private String apellidos;
	
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate nacimiento;

	//@Column(name="especialidad")
	private String especialidad;
	
	@OneToMany
	@JoinColumn(name="cita_id")
	List <Cita> citas = new ArrayList<>();

	public Medico(String nombre, String apellidos, LocalDate nacimiento, String especialidad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nacimiento = nacimiento;
		this.especialidad = especialidad;
	}
	
	
}
