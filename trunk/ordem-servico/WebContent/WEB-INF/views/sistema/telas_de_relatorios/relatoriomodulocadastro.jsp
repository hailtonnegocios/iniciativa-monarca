<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="../template/cabecalho.jsp" var="cabecalho" />
<c:url value="../template/sidebar.jsp" var="sidebar" />
<c:url value="../template/footer.jsp" var="footer" />

<c:import url="${cabecalho}" />
<c:import url="${sidebar}" />

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

	<!-- Button trigger modal -->
		<form action="relatorioFuncionario" target="_blank" method="POST">
		<table align="right">
			<tr>
				<td style="padding: 10px 0 0 0;">
				<input class="btn btn-primary btn-lg" type="submit" value="Gerar Relatório" />
				<!-- <a href="relatorioTeste" class="btn btn-primary btn-lg" onclick="geraRelatorio();"  target="_blank">Gerar Relatório</a>-->
			</tr>
		</table>
		<table>
		    <tr>
		      <td><b>Cadastros</b></td>
			  <td><b>Tipo de Relatório</b></td>
			  </tr>
			<tr>
				<td style="padding: 0 20px 0 0; width:200px">
				<select class="form-control" id="menuModuloCadastro" name="menuModuloCadastro">
				<c:forEach items="${listaMenuCadastro}" var="menuCadastro">
						<option value="${menuCadastro.nome }">${menuCadastro.descricao}</option>
				</c:forEach>
				</select>
				</td>
				<td style="width:200px">
				<select class="form-control" id="tipoRelatorioCadastro" name="tipoRelatorioCadastro">
				<c:forEach items="${listaTipoRelatorio}" var="tipoRelatorio">
						<option value="${tipoRelatorio.nome }">${tipoRelatorio.descricao}</option>
				</c:forEach>						
				</select>
				</td>
			</tr>
		</table>
		</form>
</div>
<!--  Inicio :  Conteudo das paginas -->


<c:import url="${footer}" />

