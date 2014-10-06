<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<c:url value="../template/cabecalho.jsp" var="cabecalho" />
<c:url value="../template/sidebar.jsp" var="sidebar" />
<c:url value="../template/footer.jsp" var="footer" />

<c:import url="${cabecalho}"/>
<c:import url="${sidebar}"/>

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
	 
	<!-- <button class="btn btn-primary btn-lg" data-toggle="modal"
		data-target="#myModal">Cadastros</button> -->
		
		
		<h1 class="page-header">Esta é a página principal</h1>
		<br>
		<h4 class="alert alert-info text-center">Para acessar qualquer item utilize o menu ao lado.</h4>


	<!-- Modal -->
	 
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Cadastros</h4>
				</div>
				<div class="modal-body">
				  Corpo dos Cadastros !
				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">OK</button>
				</div>
			</div>
		</div>
	</div>
	<br />
		
</div>
<!--  Inicio :  Conteudo das paginas --> 


<c:import url="${footer}"/>