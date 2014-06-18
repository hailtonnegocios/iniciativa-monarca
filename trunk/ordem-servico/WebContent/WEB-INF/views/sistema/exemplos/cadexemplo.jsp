<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="../template/cabecalho.jsp" />
<c:import url="../template/sidebar.jsp" />

<!--  Inicio :  Conteudo das paginas -->
<div id="page-wrapper">

	<div class="alert alert-success alert-dismissable">
		<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">&times;</button>
		Exemplo 1 - Cadastro de Produtos
	</div>


    <a href="adicionaExemplos" class="btn btn-primary" role="button">Cadastrar Produto</a>
   <!--  <a href="listaExemplos" class="btn btn-danger" role="button">Listar Produto</a>-->

<br /><br />  <br/>

     <fieldset>
     <div id="listar_exemplo" >
     
     <legend><b>Pesquisar Produtos</b></legend>
    
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
       <input class="form-control" type="text" id="name_pesquisar"  />
     </td>  
     <td>
       <button class="btn btn-danger" id="btn_pesquisar">Pesquisar</button>
     </td>
     </tr>
     </table>
     
     <div id="carregando3" align="center"><img  src="resources/img/carregando.gif"></div>
     <div id="lista_de_exemplos" class="table-responsive"></div>
     
    <br>
    </div>
    </div>
    </fieldset>

    <input type="hidden" id="ASerExcluido">
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog"	aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
		  <div class="modal-content">
		  <div class="modal-header">
		   	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		   	<h3>Atenção!</h3>
		    </div>
		  <div class="modal-body">
		    <p>Tem certeza que deseja excluir este Exemplo?</p>
		  </div>
		  <div class="modal-footer">
		  	<a id="linkExclusao" class="btn btn-danger" onclick="excluirComModal();">Sim</a>
		  	<button class="btn" id="btncancelar" data-dismiss="modal" aria-hidden="true">Não</button>
		  </div>
     	  </div>
       </div>
    </div>



</div>



<c:import url="../template/footer.jsp" />