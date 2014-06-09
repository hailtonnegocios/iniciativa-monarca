package br.com.iniciativamonarca.ordemservico.model.enums;

public enum ExemploSidebarEnum {
	 item1("Cadastro Modelo","cadexemplo"),
     item2("Exemplos de Ajax","cadajax"),
     item3("Informações do Módulo", "modelos");
	 
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
