<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="../template/cabecalho.jsp" />
<c:import url="../template/sidebar.jsp" />
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
		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		Exemplo 1 - Cadastro de Produtos
	</div>
	
	<form action="salvaExemplos" method="post">
		<label>
			<fmt:message key="sistema.modelo.campo.ativado" />
		</label>
		<input type="checkbox" class="myClass" value="true" id="status" name="status" data-color="green" />
		<br> <br>
		<label>
			<fmt:message key="sistema.modelo.campo.tipo" />
		</label>
		<label class="radio-inline">
			<c:forEach items="${tiposProdutos}" var="tipoProduto" varStatus="indice">
				<input name="tipo" id="radio${indice.index}" value="${tipoProduto}" ${indice.index == 0? 'checked':''} type="radio"/> ${tipoProduto.descricao}<br>
			</c:forEach>
		</label>
		
		<br> <br>
		
		<label>
			<fmt:message key="sistema.modelo.campo.nome" />
		</label>
		<input class="form-control" type="text" name="nome" id="nome" value="${param.nome}" />
		<form:errors path="exemplo.nome" cssStyle="color:red;"/>
		<br>
		<label>
			<fmt:message key="sistema.modelo.campo.descricao" />
		</label>
		<textarea class="form-control" name="descricao" id="descricao" >${param.descricao}</textarea>
		<form:errors path="exemplo.descricao" cssStyle="color:red;"/>
		<br>
		<label>
			<fmt:message key="sistema.modelo.campo.tamanho" />
		</label>
		<select class="form-control" name="tamanhos" style="width: 200px;">
			<c:forEach var="tamanhos" items="${myEnum}">
				<option value="${tamanhos}">${tamanhos.descricao}</option>
			</c:forEach>
		</select>
		<br>
		<label>
			<fmt:message key="sistema.modelo.campo.datacad" />
		</label>
		<div style="width: 200px;">
			<input name="dat_cad" id="dat_cad" class="form-control data" value="${param.dat_cad}" />
			<form:errors path="exemplo.dat_cad" cssStyle="color:red;"/>
			<br>
		</div>
			<br>
		
		<button class="btn btn-primary">Salvar</button>
	</form>
</div>
<!--  Inicio :  Conteudo das paginas -->
<c:import url="../template/footer.jsp" />