package br.com.iniciativamonarca.ordemservico.model.enums;

public enum CadastrosSidebarEnum {
	 item1("Funcion�rio","cadastroFuncionario"),
     item2("Clientes",""),
	 item3("Central de Relat�rios","relatorioModuloCadastros");
	 
	 private String referencia;
     private String nome;
     
     CadastrosSidebarEnum(String nome, String referencia){
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
