<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="../template/cabecalho.jsp" />
<c:import url="../template/sidebar_modelos.jsp" />

<!--  Inicio :  Conteudo das paginas -->
<div id="page-wrapper">

	<div class="alert alert-success alert-dismissable">
		<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">&times;</button>
		Exemplo 1 - Alteração do Produto
	</div>

	<form role="form" action="alteraexemplo" method="post">

		<label><fmt:message key="sistema.modelo.campo.ativado" /></label> 
		<c:if test="${list.status}">
		<input type="checkbox" class="myClass" checked="checked" value="true" id="status" name="status" data-color="green" /> 
		</c:if>
		<c:if test="${!list.status}">
		<input type="checkbox" class="myClass"	value="true" id="status" name="status" data-color="green" /> 
		</c:if>
		<br>
		<br>
		
		<label><fmt:message key="sistema.modelo.campo.tipo" /></label>
		<c:if test="${list.tipo == 'Revenda' }" >
        <label class="radio-inline">
          <input name="tipo" id="radio1" value="Revenda" checked="checked" type="radio"> Revenda
        </label>
        <label class="radio-inline">
          <input name="tipo" id="radio2" value="Compra"  type="radio"> Compra
        </label>
        </c:if>
        <c:if test="${list.tipo == 'Compra' }" >
        <label class="radio-inline">
          <input name="tipo" id="radio1" value="Revenda"  type="radio"> Revenda
        </label>
        <label class="radio-inline">
          <input name="tipo" id="radio2" value="Compra"  checked="checked" type="radio"> Compra
        </label>
        </c:if>
        <br>
        <br>
		
        <label>Código do Produto</label>
        <div style="width:80px;">
        <input class="form-control"	type="text" name="id_exemplo" id="id_exemplo" value="${list.id_exemplo}" />
        </div>
		<br>
			
 	    <label><fmt:message key="sistema.modelo.campo.nome" /></label> 
 	    <input class="form-control"	type="text" name="nome" id="nome" value="${list.nome}" /> 
 	    <br>
 	     
		<label><fmt:message key="sistema.modelo.campo.descricao" /></label> 
		<textarea class="form-control"  name="descricao"	id="descricao"  >${list.descricao}</textarea> 
		<br>
			
		<label><fmt:message key="sistema.modelo.campo.tamanho" /></label>
	    <select class="form-control" name="tamanhos" style="width: 200px;">
		<c:forEach var="tamanhos" items="${myEnum}">
		    <c:if test="${list.tamanhos == tamanhos }">
		      <option value="${tamanhos}" selected="true">${tamanhos}</option>
		    </c:if>
		    <c:if test="${list.tamanhos != tamanhos }">
			  <option value="${tamanhos}" >${tamanhos}</option>
			</c:if>
		</c:forEach>
		</select> <br> 
		
		 <label><fmt:message key="sistema.modelo.campo.datacad" /></label>
  	     <div style="width: 200px;">
		   <input name="dat_cad" id="dat_cad"  class="form-control" 
		          value="<fmt:formatDate value="${list.dat_cad.time}"
 				  pattern="dd/MM/yyyy" />"/> 
 	     </div>
 	     <br>

		 <button class="btn btn-primary">Salvar</button>
	</form>
</div>
<!--  Inicio :  Conteudo das paginas -->


<c:import url="../template/footer.jsp" />