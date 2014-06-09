package br.com.iniciativamonarca.ordemservico.model.enums;

public enum TipoProdutoEnum {
	
	REVENDA(1, "Revenda"),
	COMPRA(2, "Compra"),
	TROCA(3, "Troca");

	
	private int codigo;
	private String descricao;
	
	private TipoProdutoEnum(int codigo, String descricao) {
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
