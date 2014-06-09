package br.com.iniciativamonarca.ordemservico.model.enums;

public enum ExemploSidebarEnum {
	 item1("Cadastro Modelo","cadastroExe"),
     item2("Exemplos de Ajax","cadastroAjax"),
     item3("Informações do Módulo", "exemplos");
	 
	 private String referencia;
     private String nome;
     
     ExemploSidebarEnum(String nome, String referencia){
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
