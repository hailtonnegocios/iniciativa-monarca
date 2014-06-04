package br.com.iniciativamonarca.ordemservico.model.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Exemplo_1 {
	
	
	@Id
	@GeneratedValue
	private Long id_exemplo;
	private String nome;
	private String descricao;
	private boolean status;
	private String tipo;
	

	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar dat_cad;
	
	
	public Calendar getDat_cad() {
		return dat_cad;
	}

	public void setDat_cad(Calendar dat_cad) {
		this.dat_cad = dat_cad;
	}

	@Enumerated(EnumType.STRING)
	private Exemplo_1Enum tamanhos;

	public Long getId_exemplo() {
		return id_exemplo;
	}

	public void setId_exemplo(Long id_exemplo) {
		this.id_exemplo = id_exemplo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Exemplo_1Enum getTamanhos() {
		return tamanhos;
	}

	public void setTamanhos(Exemplo_1Enum tamanhos) {
		this.tamanhos = tamanhos;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
