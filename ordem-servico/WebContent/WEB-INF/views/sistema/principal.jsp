<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>


<c:url value="template/cabecalho.jsp" var="cabecalho" />
<c:url value="template/sidebar_modelos.jsp" var="sidebar" />
<c:url value="template/footer.jsp" var="footer" />

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
-->
	<br />
	
	<c:if test="${usuarioPer == 'ADMIN' }" >
	  <div class="row">
          <div class="col-lg-3">
            <div class="panel panel-info">
              <div class="panel-heading">
                <div class="row">
                  <div class="col-xs-6">
                    <img src="resources/img/cadastros_os.png"/>
                  </div>
                  <div >
                    <p>Módulo de Cadastros</p>
                  </div>
                </div>
              </div>
              <a href="cadastros">
                <div class="panel-footer announcement-bottom">
                  <div class="row">
                    <div class="col-xs-6">
                      Entrar
                    </div>
                    <div class="col-xs-6 text-right">
                      <i class="fa fa-arrow-circle-right"></i>
                    </div>
                  </div>
                </div>
              </a>
              
            </div>
            
          </div>
</c:if>

	<c:if test="${usuarioPer == 'FUNC' }" >
	  <div class="row">
          <div class="col-lg-3">
            <div class="panel panel-danger">
              <div class="panel-heading">
                <div class="row">
                  <div class="col-xs-6">
                    <img src="resources/img/cadastros_os_bloq.png"/>
                  </div>
                  <div >
                    <p>Módulo de Cadastros</p>
                  </div>
                </div>
              </div>
              <!-- <a href="cadastros">-->
                <div class="panel-footer announcement-bottom">
                  <div class="row">
                    <div class="col-xs-6">
                      Bloqueado 
                    </div>
                    <div class="col-xs-6 text-right">
                      <i class="fa fa-arrow-circle-right"></i>
                    </div>
                  </div>
                </div>
              <!-- </a>-->
            </div>
          </div>
</c:if>





          <div class="col-lg-3">
            <div class="panel panel-info">
              <div class="panel-heading">
                <div class="row">
                  <div class="col-xs-6">
                   <img src="resources/img/os.png"/>
                  </div>
                  <div >
                    <p>Módulo de Ordem de Serviço</p>
                  </div>
                </div>
              </div>
              <a href="os">
                <div class="panel-footer announcement-bottom">
                  <div class="row">
                    <div class="col-xs-6">
                      Entrar
                    </div>
                    <div class="col-xs-6 text-right">
                      <i class="fa fa-arrow-circle-right"></i>
                    </div>
                  </div>
                </div>
              </a>
            </div>
          </div>

          <div class="col-lg-3">
            <div class="panel panel-info">
              <div class="panel-heading">
                <div class="row">
                  <div class="col-xs-6">
                    <img src="resources/img/chamados.png"/>
                  </div>
                  <div>
                    <p>Módulo de Chamados</p>
                  </div>
                </div>
              </div>
              <a href="chamados">
                <div class="panel-footer announcement-bottom">
                  <div class="row">
                    <div class="col-xs-6">
                      Entrar
                    </div>
                    <div class="col-xs-6 text-right">
                      <i class="fa fa-arrow-circle-right"></i>
                    </div>
                  </div>
                </div>
              </a>
            </div>
          </div>
	          

	          <div class="col-lg-3">
            <div class="panel panel-warning">
              <div class="panel-heading">
                <div class="row">
                  <div class="col-xs-6">
                    <img src="resources/img/teste.png"/>
                  </div>
                  <div >
                    <p>Modulo de Exemplos</p>
                  </div>
                </div>
              </div>
              <a href="modelos">
                <div class="panel-footer announcement-bottom">
                  <div class="row">
                    <div class="col-xs-6">
                      Entrar
                    </div>
                    <div class="col-xs-6 text-right">
                      <i class="fa fa-arrow-circle-right"></i>
                    </div>
                  </div>
                </div>
              </a>
            </div>
          </div>





	<!-- Button trigger modal -->
	<!-- 
	<button class="btn btn-primary btn-lg" data-toggle="modal"
		data-target="#myModal">Launch demo modal</button>

-->
	<!-- Modal -->
	<!-- 
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				</div>
				<div class="modal-body">
				  Corpo dos Cadastros !
				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
	<br />


-->	
		
</div>
<!--  Inicio :  Conteudo das paginas --> 


<c:import url="${footer}"/>