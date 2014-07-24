package br.com.iniciativamonarca.ordemservico.model.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "FROM_CLASS", discriminatorType = DiscriminatorType.STRING)
// commit teste no google code -> Alteracao no projeto local
// commit teste no google code -> Alteracao no Google code
// Teste Hailton 15/07/2014
public abstract class Usuario {

	@Id
	@GeneratedValue
	Long id_usuario;


	@NotBlank(message="{usuario.email.vazio}")
	String email;

	@NotBlank(message="{usuario.senha.vazio}")
	String senha;

	@NotBlank(message="{usuario.permissao.vazio}")
	String permissao;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

}
