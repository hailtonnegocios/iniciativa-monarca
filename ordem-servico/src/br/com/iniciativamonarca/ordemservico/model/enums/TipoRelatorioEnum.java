package br.com.iniciativamonarca.ordemservico.model.enums;

public enum TipoRelatorioEnum {
	
	item1("simplificado", "Simplificado"),
	item2("completo", "Completo");
	
	private String descricao;
    private String nome;
    
    TipoRelatorioEnum(String nome,String descricao){
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
