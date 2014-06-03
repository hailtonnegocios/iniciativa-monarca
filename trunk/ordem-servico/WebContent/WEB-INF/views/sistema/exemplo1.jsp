<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="../template/cabecalho.jsp" />
<c:import url="../template/sidebar_modelos.jsp" />

<!--  Inicio :  Conteudo das paginas -->
<div id="page-wrapper">

	<!-- <div class="row">
	 
		<div class="col-lg-12">
			<div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
                   <p><b>Bem Vindo !!!, ${usuarioLogado.email}</b></p> 
			</div>
		</div>
	</div>

	<br />
-->

	<div class="alert alert-success alert-dismissable">
		<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">&times;</button>
		Exemplo 1 - Cadastro de Produtos
	</div>

<form role="form" action="addexe1" method="post">
	
 
	<label>Produto Ativado</label>
    <input type="checkbox" class="myClass" value="true" id="status" name="status" data-color="green" />

	<br>  <br>
	
	<label>Nome do Produto</label>  
          <input class="form-control" type="text" name="nome" id="nome" />
    <br>
	
	<label>Descrição do Produto</label>
	<input class="form-control" type="text" name="descricao" id="descricao" />
	 <br> 

	<label>Tamanho do Produto</label> 
	<select class="form-control" name="tamanhos">
		<c:forEach var="tamanhos" items="${myEnum}">
			<option value="${tamanhos}">${tamanhos}</option>
		</c:forEach>
	</select>
<br>
	<label>Data do Cadastro</label> 
	<input class="form-control" type="text" name="dat_cad" id="dat_cad" />
	<br>

        <button class="btn btn-primary" >Enviar</button>

</form>



</div>
<!--  Inicio :  Conteudo das paginas -->


<c:import url="../template/footer.jsp" />