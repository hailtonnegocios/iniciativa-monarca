package br.com.iniciativamonarca.ordemservico.model.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {

// Atributos privados;
	
		@Id
		@GeneratedValue
		private Integer id_cliente;  
		
		private String bairro;
		private String CEP;
		@ElementCollection
		private List <String> celular; 
		private String cidade;
		private String complemento;
		private Calendar data_nasc;
		private String email;
		private String endereco;
		private String estado;
		private String nome;
		private String numero;
		@ElementCollection
		private  List <String> telefone;
		private String cpf;
		private String rg;
		
		
// Getters e Setters		
		public Integer getId_cliente() {
			return id_cliente;
		}
		public void setId_cliente(Integer id_cliente) {
			this.id_cliente = id_cliente;
		}		
		public String getBairro() {
			return bairro;
		}
		public void setBairro(String bairro) {
			this.bairro = bairro;
		}
		public String getCEP() {
			return CEP;
		}
		public void setCEP(String cEP) {
			CEP = cEP;
		}

		public String getCidade() {
			return cidade;
		}
		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
		public String getComplemento() {
			return complemento;
		}
		public void setComplemento(String complemento) {
			this.complemento = complemento;
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
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String numero) {
			this.numero = numero;
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
		
		
		
	
}
