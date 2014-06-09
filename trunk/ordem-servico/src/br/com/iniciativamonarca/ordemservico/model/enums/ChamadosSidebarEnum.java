package br.com.iniciativamonarca.ordemservico.model.enums;

public enum ChamadosSidebarEnum {

	 item1("Chamados","");
	 
	 private String referencia;
     private String nome;
     
     ChamadosSidebarEnum(String nome, String referencia){
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
