<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<c:import url="../template/cabecalho.jsp" />
<c:import url="../template/sidebar.jsp" />

<!--  Inicio :  Conteudo das paginas -->
<div id="page-wrapper">

	<div class="alert alert-success alert-dismissable">
		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		Exemplo 1 - Alteração do Produto
	</div>

	<form action="alteraExemplos" method="post">

		<label>
			<fmt:message key="sistema.modelo.campo.ativado" />
		</label>
		
		<input type="checkbox" class="myClass" ${exemplo1Selecionado.status? 'checked':''}  id="status" name="status" data-color="green" />
		
		<br> <br>

		<label>
			<fmt:message key="sistema.modelo.campo.tipo" />
		</label>
		<label class="radio-inline">
		<c:forEach items="${tiposProdutos}" var="tipoProduto" varStatus="indice">
			<input name="tipo" id="radio${indice.index}" value="${tipoProduto}" ${tipoProduto.descricao == exemplo1Selecionado.tipo.descricao? 'checked':''} type="radio"/>${tipoProduto.descricao}<br>
		</c:forEach>
		</label>
		<br> <br>

		<label>Código do Produto</label>
		<div style="width: 80px;">
			<input class="form-control" type="text" name="id_exemplo" id="id_exemplo" value="${exemplo1Selecionado.id_exemplo}" />
		</div>
		<br>

		<label>
			<fmt:message key="sistema.modelo.campo.nome" />
		</label>
		<input class="form-control" type="text" name="nome" id="nome" value="${exemplo1Selecionado.nome}" />
		<form:errors path="exemplo.nome" cssStyle="color:red;"/>
		<br>

		<label>
			<fmt:message key="sistema.modelo.campo.descricao" />
		</label>
		<textarea class="form-control" name="descricao" id="descricao">${exemplo1Selecionado.descricao}</textarea>
		<form:errors path="exemplo.descricao" cssStyle="color:red;"/>
		<br>

		<label>
			<fmt:message key="sistema.modelo.campo.tamanho" />
		</label>
		<select class="form-control" name="tamanhos" style="width: 200px;">
			<c:forEach var="tamanhos" items="${myEnum}">
				<option value="${tamanhos}" ${exemplo1Selecionado.tamanhos == tamanhos? 'selected':''}>${tamanhos.descricao}</option>
			</c:forEach>
		</select>
		<br>

		<label>
			<fmt:message key="sistema.modelo.campo.datacad" />
		</label>
		<div style="width: 200px;">
			<input name="dat_cad" id="dat_cad" class="form-control data" value="<fmt:formatDate value="${exemplo1Selecionado.dat_cad.time}"
 				  pattern="dd/MM/yyyy" />" />
            <form:errors path="exemplo.dat_cad" cssStyle="color:red;"/>
		</div>
		<br>

		<button class="btn btn-primary">Salvar</button>
	</form>
</div>
<!--  Inicio :  Conteudo das paginas -->


<c:import url="../template/footer.jsp" />