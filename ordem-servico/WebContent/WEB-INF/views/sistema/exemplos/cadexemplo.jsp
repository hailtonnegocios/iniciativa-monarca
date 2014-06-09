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


    <a href="adicionaExe" class="btn btn-primary" role="button">Cadastrar Produto</a>
    <a href="listaExe" class="btn btn-danger" role="button">Listar Produto</a>

</div>



<c:import url="../template/footer.jsp" />