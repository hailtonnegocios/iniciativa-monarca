package br.com.iniciativamonarca.ordemservico.model.enums;

public enum TamanhosEnum {
	
	PEQUENO(1, "Pequena"),
	MEDIO(2, "Média"),
	GRANDE(3, "Grande");

	
	private int codigo;
	private String descricao;
	
	private TamanhosEnum(int codigo, String descricao) {
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
