package br.com.iniciativamonarca.ordemservico.model.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Funcionario extends Usuario {

	@NotBlank(message="{funcionario.nome.vazio}")
	String nome;
	String cpf;
	String rg;
	String setor;

	@ElementCollection
	List<String> telefones;

	@ElementCollection
	List<String> celulares;

	@Embedded
	Endereco endereco;

	public List<String> getCelulares() {
		return celulares;
	}

	public void setCelulares(List<String> celulares) {
		this.celulares = celulares;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
