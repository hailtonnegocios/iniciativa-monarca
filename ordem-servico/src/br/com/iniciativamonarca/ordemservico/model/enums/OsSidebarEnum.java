package br.com.iniciativamonarca.ordemservico.model.enums;

public enum OsSidebarEnum {
	 item1("Ordem de Serviço","");
	 
	 private String referencia;
     private String nome;
     
     OsSidebarEnum(String nome, String referencia){
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
