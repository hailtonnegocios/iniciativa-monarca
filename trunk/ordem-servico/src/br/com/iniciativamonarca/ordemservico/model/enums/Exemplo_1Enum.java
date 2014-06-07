package br.com.iniciativamonarca.ordemservico.model.enums;

public enum Exemplo_1Enum {
	
	PEQUENO(1, "Pequena de Mais"),
	MEDIO(2, "M�dia"),
	GRANDE(3, "Grande");

	
	private int codigo;
	private String descricao;
	
	private Exemplo_1Enum(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}