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
-->


   <div class="alert alert-success alert-dismissable">
              <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
              Este m�dulo tem o objetivo de ajudar os desenvolvedores, com alguns modelos de Cadastros , Componentes e Pr�ticas para o aprendizado.
            </div>
            
            
            
           <center><img src="resources/img/ilustracao.png" width="350px"/></center>



		
</div>
<!--  Inicio :  Conteudo das paginas --> 


<c:import url="${footer}"/>