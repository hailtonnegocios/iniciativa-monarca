package br.com.iniciativamonarca.ordemservico.model.enums;

public enum FuncionarioSetoresEnum {
	Analise(1, "Analise"),
	Reparo(2, "Reparo"),
	Compra(3, "Compra de Peças");
	
	
	private int codigo;
	private String descricao;
	
	private FuncionarioSetoresEnum(int codigo, String descricao) {
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
