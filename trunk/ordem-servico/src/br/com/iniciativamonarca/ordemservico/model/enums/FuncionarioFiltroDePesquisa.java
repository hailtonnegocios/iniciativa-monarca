package br.com.iniciativamonarca.ordemservico.model.enums;

public enum FuncionarioFiltroDePesquisa {
	item1("Pesquisar Todos","Todos"),
    item2("Código","id_usuario"),
    item3("Nome", "nome");
	
	private String descricao;
    private String nome;
    
    FuncionarioFiltroDePesquisa(String nome,String descricao){
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
