package br.com.iniciativamonarca.ordemservico.model.enums;

public enum ListaMenuCadastrosEnum {
	item1("funcionario", "Funcionário"),
	item2("cliente", "Cliente");
	
	private String descricao;
    private String nome;
    
    ListaMenuCadastrosEnum(String nome,String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public String getNome(){
        return this.nome;
    }

	
}
