<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:url value="../template/cabecalho.jsp" var="cabecalho" />
<c:url value="../template/sidebar.jsp" var="sidebar" />
<c:url value="../template/footer.jsp" var="footer" />

<c:import url="${cabecalho}" />
<c:import url="${sidebar}" />

<!--  Inicio :  Conteudo das paginas -->
<div id="page-wrapper">

	<!-- BREADCRUMB -->
	<ol class="breadcrumb">
        <li>
            <a href="efetuaLogin"><i class="entypo-home"></i>Módulos</a>
        </li>
         <li class="active">
           <a href="moduloCadastros"><i class="entypo-home"></i>Página Inicial</a>
        </li>
        <li class="active">
            <strong>Cadastro de Clientes</strong>
        </li>
    </ol>  
    
    <!-- BOTOES NAVEGAÇAO -->
    <ul class="nav nav-pills">
    	<li class="btn btn-default "><a href="moduloCadastros">Menu Principal</a></li>
    	<li class="btn btn-default "><a href="Cliente">Pessoa Física</a></li>
    	<li class="btn btn-default "><a href="ClientePJ">Pessoa Jurídica</a></li>    	
    </ul>
    
    <!-- HEADER DA PAGINA  -->
    <h3 class=page-header>Cadastro de Clientes - Pessoa Jurídica</h3>  

	<!-- COMPONENTE DE ABA - Hailton -->
	<div class="bs-example">

		<c:if test="${mensagem != null}">

			<!-- MENSAGEM DE RETORNO DO CADASTRO -->
			<div id="seconds">
				<div
					class="${error_email != null ? 'alert alert-danger alert-dismissable' : 'alert alert-info alert-dismissable'}">${mensagem}</div>
			</div>
		</c:if>

		<!-- ABA DE INCLUIR E PESQUISAR -->
		<ul class="nav nav-tabs" style="margin-bottom: 15px;">
			<li class="active"><a href="#cadastrarClientePJ" data-toggle="tab">Incluir</a></li>
			<li ><a href="#pesquisaClientesPJ" data-toggle="tab">Pesquisar</a></li>
		</ul>

		<!--  ABA DE INCLUIR -->
		
		<div id="myTabContent" class="tab-content">				
			<div class="tab-pane fade active in" id="cadastrarClientePJ">
				<div class="panel panel-default">
					<div class="panel-body" style="background-color: #E0E0E0">
					
						<form action="adicionaClientePJ" method="post" class="">
									<h3>Dados Cadastrais</h3>	
									<hr>	
									<div class="row dados_empresa">							
										<div  class="form-group">
											<div class=" col-sm-5" >
												<input class="form-control" type="text" name="razaoSocial" class="form-control"
														id="razaoSocial" value="${param.razaoSocial}" placeholder="Razão Social"
														maxlength="180"/>
											</div>
											<div class=" col-sm-2">
												<input class="form-control cnpj" type="text" name="cnpj" id="cnpj" class="form-control"
														value="${param.cnpj}" placeholder="CNPJ" maxlength="18"/>
											</div>
											<div class=" col-sm-2">
												<input class="form-control inscEstadual" type="text" name="inscEstadual" class="form-control"
													id="inscEstadual" value="${param.inscEstadual}" placeholder="Inscrição Estadual"
													maxlength="16"/>
											</div>
											<div class=" col-sm-2" hidden >
												<input class="form-control " type="date"
														name="data_cadastro" id="data_cadastro" value="${param.data_cadastro}" 
														placeholder="Data Cadastro" maxlength="10"/>
											</div>
										</div>	
									</div>	
									<br>
									<div class="row">
										<div class="col-sm-3 text-right"><p> Digite o CEP para achar o endereço automaticamente:</p></div>
										<div class="col-sm-2">
												<input class="form-control cep col-lg-2" maxlength="9" type="text" 
												name="cep" id="cep" value="${param.cep}" placeholder="Cep"
												onblur="javascript:consultaEndereco();" 
												/>					
										</div>									
										<div class="col-sm-4">
											<div id="carrega_endereco" style="padding: 0 0 0 10px">
												<img src="resources/img/carregando.gif">
											</div>
											<div id="retorno_endereco_success"
												style="padding: 0 0 10px 10px; color: green;">
												<img src="resources/img/success_endereco.png">
												Endereço encontrado com sucesso !
											</div>
											<div id="retorno_endereco_error"
												style="padding: 0 0 10px 10px; color: red;">
												<img src="resources/img/error_endereco.png"> Endereço
												não encontrado ou CEP inválido
											</div>		
										</div>	
									</div>
									<br>
									<!--  ENDEREÇO -->
									<div class="row endereco" hidden>
										<div class="form-group">
											<div class=" col-sm-2">
												<input class="form-control" maxlength="10" type="text"
													name="tipo_logradouro" id="tipo_logradouro"
													value="${param.tipo_logradouro}" placeholder="Logra." />
											</div>
											<div class=" col-sm-6">	
												<input class="form-control" maxlength="100" type="text"
													name="logradouro" id="logradouro"
													value="${param.logradouro}" placeholder="Endereço" />
											</div>
											<div class=" col-sm-1">
												<input class="form-control" maxlength="6" type="text"
														name="numero" id="numero" value="${param.numero}"
														placeholder="Nº" />
											</div>
											<div class=" col-sm-2">
												<input class="form-control" maxlength="80" type="text"
														name="complemento" id="complemento"
														value="${param.complemento}" placeholder="Compl" />
											</div>
										</div>
										<br>										
										<br>
										<div class="form-group">
											<div class=" col-sm-4">
												<input class="form-control" maxlength="80" type="text"
														name="bairro" id="bairro" value="${param.bairro}"
														placeholder="Bairro" />
											</div>		
											<div class=" col-sm-4">
												<input class="form-control" maxlength="80" type="text"
														name="cidade" id="cidade" value="${param.cidade}"
														placeholder="Cidade" />
											</div>
											<div class=" col-sm-1">
												<input class="form-control" maxlength="2" type="text"
														name="uf" id="uf" value="${param.uf}" placeholder="UF" />
											</div>
																				
										</div>
									</div>
									<br>
									<div class="row email_empresa" hidden>
										<div class="form-group">
											<div class=" col-sm-5">
												<div class="input-group">
												      <div class="input-group-addon">@</div>
												      
														<input class="form-control email" maxlength="200" type="text"
														name="email" id="email" value="${param.email}"
														placeholder="Email de contato na empresa" />
													</div>
											</div>
										</div>
									</div>
									<br>
									<div class="row tel_empresa" hidden>
										<div class="form-group">
											<div class=" col-sm-3">
												<input class="form-control telefone" maxlength="10"
														type="text" name="telefones" id="telefone_1"
														value="${telefone_1}" placeholder="Telefone" />
											</div>
											<div class=" col-sm-3">
												<input class="form-control telefone" maxlength="10"
														type="text" name="telefones" id="telefone_2"
														value="${telefone_2}" placeholder="Telefone Aux." />
											</div>
											<div class=" col-sm-3">
												<input class="form-control telefone" maxlength="10"
														type="text" name="celulares" id="celular_1"
														value="${celular_1}" placeholder="Celular" />
											</div>
											<div class=" col-sm-3">
												<input class="form-control telefone" maxlength="10"
														type="text" name="celulares" id="celular_2"
														value="${celular_2}" placeholder="Celular Aux." />
											</div>
										</div>
									</div>				
								<br>
								<input class="btn btn-info btn_gravar disabled" type="submit" value="Gravar" >
							
						</form>
					
					</div>
				</div>
			</div>

		

 <!-- ABA DE PESQUISAR -->
			<div class="tab-pane fade" id="pesquisaClientesPJ">
	  	    	<div class="panel panel-default">
		   		    <div class="panel-body">
						<table class="table">
							<tr>
								<th>Filtro</th>
								<th>Campo de Pesquisa</th>
								<th></th>
							</tr>
							<tr>
								<td>
	 							  <select class="form-control" id="select_val_func">
	 							  <c:forEach var="filtro_clientes" items="${filtro_clientes}">
	 							      <option value="${filtro_clientes.descricao}">${filtro_clientes.nome}</option>
	 							  </c:forEach>
								   </select>
								</td>
								<td><input class="form-control" type="text"	id="name_pesquisar_clientes_PJ" /></td>
								<td><button class="btn btn-danger" id="btn_pesquisar_clientes_PJ">Pesquisar</button></td>
						    </tr>
						</table>
						<div id="carregando_lista_clientes_PJ" align="center">
							<img src="resources/img/carregando.gif">
						</div>
						<div id="lista_de_clientes_PJ" class="table-responsive"></div>
						<br>
					</div>
				</div>
			</div>
  		</div>			
			
			
		</div>





</div>

<script src="resources/js/clientePJ.js" type="text/javascript"> </script>

<c:import url="${footer}"></c:import>