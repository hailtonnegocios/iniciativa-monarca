package br.com.iniciativamonarca.ordemservico.model.enums;

public enum ExemploFiltroDePesquisa {
	item1("Pesquisar Todos","Todos"),
    item2("Código","id_exemplo"),
    item3("Nome", "nome"),
	item4("Descrição", "descricao");
	
	
	private String descricao;
    private String nome;
    
    ExemploFiltroDePesquisa(String nome,String descricao){
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
