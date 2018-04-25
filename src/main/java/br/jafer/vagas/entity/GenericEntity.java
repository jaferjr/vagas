package br.jafer.vagas.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;


@SuppressWarnings("serial")
@MappedSuperclass
public class GenericEntity implements Serializable{

	
	@Id
	@SequenceGenerator(name="codigo", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


}
