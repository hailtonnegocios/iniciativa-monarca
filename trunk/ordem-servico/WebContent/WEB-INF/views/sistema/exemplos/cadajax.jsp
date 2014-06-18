<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ini" %>

<c:import url="../template/cabecalho.jsp" />
<c:import url="../template/sidebar.jsp" />


<!--  Inicio :  Conteudo das paginas -->
<div id="page-wrapper">



	<div class="alert alert-success alert-dismissable">
		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		Exemplos com Ajax
	</div>
    
    <button id="btnTeste1"  class="btn btn-primary form-control data">Requisição feita com ajax ao RequestMapping("funcAjax1") - Retorno de uma String</button>
    <br><br>
    <div id="ajax1" class="alert alert-danger alert-dismissable" style="width:300px;hidth:100px;"></div>
    
    <button id="btnTeste2" class="btn btn-primary form-control data">Requisição feita com ajax ao RequestMapping("funcAjax2") - Retorno de uma Objeto</button>
    <br><br>
    <div id="carregando1"><img  src="resources/img/carregando.gif"></div>
    <div id="ajax2" class="alert alert-danger alert-dismissable" style="height:190px;"></div>
    
    <div>
    <button id="btnTeste3" class="btn btn-primary form-control data">Requisição feita com ajax ao RequestMapping("funcAjax3") - Retorno de uma Lista</button>
    <br><br>
      <div id="carregando2"><img  src="resources/img/carregando.gif"></div>
      <div id="ajax3" class="alert alert-danger alert-dismissable"></div>
    </div>
    
    <div>
    <button id="btnTeste4" class="btn btn-primary form-control data">Requisição feita com ajax ao RequestMapping("funcAjax4") - Retorno de uma tabela com pesquisa</button>
<br><br>
     
     <fieldset>
     <div id="tabela_pesquisar" >
     
     <legend><b>Pesquisar Exemplos</b></legend>
    
     <table class="table">
     <tr class="active">
     <th>Filtro</th><th>Campo de Pesquisa</th><th></th>
     </tr>
     <tr>
     <td>
     <select class="form-control" id="select_val">
       <option value="Todos">Pesquisar Todos</option>
       <option value="id_exemplo">Código</option>
       <option value="nome">Nome</option>
       <option value="descricao">Descrição</option>
     </select>
     </td>
     <td>
       <input class="form-control" type="text" id="name_pesq"  />
     </td>  
     <td>
       <button class="btn btn-danger" id="btn_pesq">Pesquisar</button>
     </td>
     </tr>
     </table>
     
     <div id="carregando3" align="center"><img  src="resources/img/carregando.gif"></div>
     <div id="ajax4" class="table-responsive"></div>
     
    <br>
    </div>
    </div>
    </fieldset>

</div>
</div>

<c:import url="../template/footer.jsp" />
