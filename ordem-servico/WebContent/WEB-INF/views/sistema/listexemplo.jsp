<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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

	<table class="table table-hover">
		<tr>
			<td class="info">STATUS</td>
			<td class="info">ID</td>
			<td class="info">DATA</td>
			<td class="info">NOME</td>
			<td class="info">DESCRICAO</td>
			<td class="info">TAMANHO</td>
			<td class="info">TIPO</td>
			<td class="info">AC�O</td>
		</tr>


		<c:forEach items="${lista}" var="list">
			<tr>
				<c:if test="${list.status == true}">
					<td class="success">Ativo</td>
				</c:if>
				<c:if test="${list.status == false}">
					<td class="danger">Inativo</td>
				</c:if>
				<td>${list.id_exemplo}</td>
				<td><fmt:formatDate value="${list.dat_cad.time}"
						pattern="dd/MM/yyyy" /></td>
				<td>${list.nome}</td>
				<td>${list.descricao}</td>
				<td>${list.tamanhos}</td>
				<td>${list.tipo}</td>
				<td><a href="">Alterar</a> <a href="delexemplo?id_exemplo=${list.id_exemplo}">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<!--  Inicio :  Conteudo das paginas -->


<c:import url="../template/footer.jsp" />