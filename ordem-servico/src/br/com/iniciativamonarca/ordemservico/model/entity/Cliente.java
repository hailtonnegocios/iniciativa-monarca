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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cliente {

// Atributos privados;
	
		@Id
		@GeneratedValue
		private Integer id_cliente;  
		
		@ElementCollection
		private List <String> celular; 
		
		@ElementCollection
		private  List <String> telefone;
		
		@Embedded
		Endereco endereco;
		
		@Temporal(TemporalType.DATE)
		@DateTimeFormat (pattern="dd/MM/yyyy")
		private Calendar data_nasc;
		
		private String email;
		private String nome;

		private String cpf;
		private String rg;
		
		
// Getters e Setters		
		public Integer getId_cliente() {
			return id_cliente;
		}
		public void setId_cliente(Integer id_cliente) {
			this.id_cliente = id_cliente;
		}		
		
		public Calendar getData_nasc() {
			return data_nasc;
		}
		public void setData_nasc(Calendar data_nasc) {
			this.data_nasc = data_nasc;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
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
		public Endereco getEndereco() {
			return endereco;
		}
		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}
		
		
		
	
}
