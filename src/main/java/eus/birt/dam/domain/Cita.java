package eus.birt.dam.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="cita")
public class Cita {

	@Id
	@SequenceGenerator(name="col_gen", sequenceName="col_sqe", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="col_gen")
	private Long id;
	
	@Column(name="paciente")
	private String paciente;
	
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	@Column(name="informe")
	private String informe;
		
	@ManyToOne
	@JoinColumn(name="medico_id")
	private Medico medico;

	public Cita(String paciente, LocalDate fecha, String informe) {
		super();
		this.paciente = paciente;
		this.fecha = fecha;
		this.informe = informe;
	}

}
