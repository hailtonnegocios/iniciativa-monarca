package br.com.iniciativamonarca.ordemservico.model.enums;

public enum CadastrosSidebarEnum {
	 item1("Funcionário","cadastroFuncionario"),
     item2("Clientes",""),
	 item3("Central de Relatórios","relatorioModuloCadastros");
	 
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
