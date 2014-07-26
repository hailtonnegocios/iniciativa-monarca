package br.com.iniciativamonarca.ordemservico.model.enums;

public enum FuncionarioPermissaoEnum {
	ADMIN(1, "ADMIN"),
	FUNC(2, "FUNC");
	
	private int codigo;
	private String descricao;
	
	private FuncionarioPermissaoEnum(int codigo, String descricao) {
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
