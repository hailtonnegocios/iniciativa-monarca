package br.com.iniciativamonarca.ordemservico.model.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ClientePJ {
	
	// Atributos privados;
	
			@Id
			@GeneratedValue
			private Integer id_cliente_pj;  
			
			@ElementCollection
			private List <String> celular; 
			
			@ElementCollection
			private  List <String> telefone;
			
			@Embedded
			Endereco endereco;
			
			@Temporal(TemporalType.DATE)
			@DateTimeFormat (pattern="dd/MM/yyyy")
			private Calendar data_fundacao;
			
			private String email;
			
			@NotNull
			private String razaoSocial;

			@NotNull
			private String cnpj;
			
			private String inscEstadual;
			
			
			// Getters e Setters	
			
			public Integer getId_cliente_pj() {
				return id_cliente_pj;
			}
			public void setId_cliente_pj(Integer id_cliente_pj) {
				this.id_cliente_pj = id_cliente_pj;
			}
			public List<String> getCelular() {
				return celular;
			}
			public void setCelular(List<String> celular) {
				this.celular = celular;
			}
			public List<String> getTelefone() {
				return telefone;
			}
			public void setTelefone(List<String> telefone) {
				this.telefone = telefone;
			}
			public Endereco getEndereco() {
				return endereco;
			}
			public void setEndereco(Endereco endereco) {
				this.endereco = endereco;
			}
			public Calendar getData_fundacao() {
				return data_fundacao;
			}
			public void setData_fundacao(Calendar data_fundacao) {
				this.data_fundacao = data_fundacao;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getRazaoSocial() {
				return razaoSocial;
			}
			public void setRazaoSocial(String razaoSocial) {
				this.razaoSocial = razaoSocial;
			}
			public String getCnpj() {
				return cnpj;
			}
			public void setCnpj(String cnpj) {
				this.cnpj = cnpj;
			}
			public String getInscEstadual() {
				return inscEstadual;
			}
			public void setInscEstadual(String inscEstadual) {
				this.inscEstadual = inscEstadual;
			}
			
	
	
	
	
}
