package br.com.iniciativamonarca.ordemservico.model.enums;

public enum ClientesSidebarEnum {

	 item1("Funcionário","cadastroFuncionario"),
     item2("Clientes","moduloClientes");
	 
	 private String referencia;
	 private String nome;
    
    ClientesSidebarEnum(String nome, String referencia){
        this.nome = nome;
        this.referencia = referencia;
    }
    
    public String getReferencia(){
        return this.referencia;
    }
    
    public String getNome(){
        return this.nome;
    }
	

}