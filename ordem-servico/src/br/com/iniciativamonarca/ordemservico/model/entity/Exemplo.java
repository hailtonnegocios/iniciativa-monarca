package br.com.iniciativamonarca.ordemservico.model.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.iniciativamonarca.ordemservico.model.enums.TamanhosEnum;
import br.com.iniciativamonarca.ordemservico.model.enums.TipoProdutoEnum;

@Entity
public class Exemplo {
	
	
	@Id
	@GeneratedValue
	private Long id_exemplo;
	
	@NotBlank(message="{exemplo.nome.vazio}")
	private String nome;
	@NotBlank(message="{exemplo.descricao.vazio}")
	private String descricao;
	private boolean status;
	@Enumerated(EnumType.STRING)
	private TamanhosEnum tamanhos;
	@Enumerated(EnumType.STRING)
	private TipoProdutoEnum tipo;

	

	@NotNull(message="{exemplo.dat_cad.vazio}")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Past
	private Calendar dat_cad;
	
	
	public Calendar getDat_cad() {
		return dat_cad;
	}

	public void setDat_cad(Calendar dat_cad) {
		this.dat_cad = dat_cad;
	}


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

	public TamanhosEnum getTamanhos() {
		return tamanhos;
	}

	public void setTamanhos(TamanhosEnum tamanhos) {
		this.tamanhos = tamanhos;
	}

	public TipoProdutoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoProdutoEnum tipo) {
		this.tipo = tipo;
	}

	


	
}
