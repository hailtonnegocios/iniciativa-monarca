package br.com.iniciativamonarca.ordemservico.model.entity;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

@Embeddable
@XmlRootElement(name = "webservicecep")
public class Endereco {

	private String resultado;
	private String resultado_txt;
	private String uf;
	private String cidade;
	private String bairro;
	private String tipo_logradouro;
	private String logradouro;
	private String numero;
	private String cep;
	private String complemento;

	public Endereco() {

	}

	public Endereco(String numero, String complemento, String uf,
			String cidade, String bairro, String tipo_logradouro,
			String logradouro) {
		this.numero = numero;
		this.complemento = complemento;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.tipo_logradouro = tipo_logradouro;
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getResultado_txt() {
		return resultado_txt;
	}

	public void setResultado_txt(String resultado_txt) {
		this.resultado_txt = resultado_txt;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTipo_logradouro() {
		return tipo_logradouro;
	}

	public void setTipo_logradouro(String tipo_logradouro) {
		this.tipo_logradouro = tipo_logradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

}
