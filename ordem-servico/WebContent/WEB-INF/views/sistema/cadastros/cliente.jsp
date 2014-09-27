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

	<h3>Cadastro de Clientes</h3>

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
			<li class="active"><a href="#cadastrarCliente" data-toggle="tab">Incluir</a></li>
			<li ><a href="#pesquisaClientes" data-toggle="tab">Pesquisar</a></li>
		</ul>

		<!--  ABA DE INCLUIR -->
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade active in" id="cadastrarCliente">
				<div class="panel panel-default">
					<div class="panel-body">
						<form action="adicionaCliente" method="post">
							<fieldset>
								<legend>Dados Cadastrais</legend>
								<table>
									<tr>
										<td style="color: red; padding-right: 5px;">*</td>
										<td>
											<div style="padding: 0 10px 10px 0; width: 400px;">
												<input class="form-control" type="text" name="nome"
													id="Nome" value="${param.nome}" placeholder="Nome Completo"
													maxlength="80">
											</div>
										</td>
										<td>
											<div style="padding: 0 10px 10px 0; width: 200px;">
												<input class="form-control rg" type="text" name="rg" id="rg"
													value="${param.rg}" placeholder="RG" maxlength="20">
											</div>
										</td>
										<td>
											<div style="padding: 0 10px 10px 0; width: 200px;">
												<input class="form-control cpf" type="text" name="cpf"
													id="cpf" value="${param.cpf}" placeholder="CPF"
													maxlength="20">
											</div>
										</td>
										<td>
											<div style="padding: 0 10px 10px 0; width: 200px;">
												<input class="form-control " type="date"
													name="data_nasc" id="data_nasc" value="${param.data_nasc}" 
													placeholder="Nascimento" maxlength="20">
											</div>
										</td>
									</tr>
								</table>
								<table>
									<tr>
										<td>
											<div style="padding: 0 0 0 10px">
												<input class="form-control cep" maxlength="20" type="text"
													name="cep" id="cep" value="${param.cep}" placeholder="Cep"
													onblur="javascript:consultaEndereco();" />
											</div>
										</td>
										<td>
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
										</td>
									</tr>
								</table>
								<table>
									<tr>
										<td>
											<div style="padding: 10px 10px 10px 10px; width: 90px">
												<input class="form-control" maxlength="80" type="text"
													name="tipo_logradouro" id="tipo_logradouro"
													value="${param.tipo_logradouro}" placeholder="Logra." />
											</div>
										</td>
										<td>
											<div style="padding: 10px 10px 10px 0; width: 450px">
												<input class="form-control" maxlength="80" type="text"
													name="logradouro" id="logradouro"
													value="${param.logradouro}" placeholder="Endereço" />
											</div>
										</td>
										<td>
											<div style="padding: 10px 10px 10px 0; width: 80px">
												<input class="form-control" maxlength="80" type="text"
													name="numero" id="numero" value="${param.numero}"
													placeholder="Nº" />
											</div>
										</td>
										<td>
											<div style="padding: 10px 10px 10px 0; width: 80px">
												<input class="form-control" maxlength="80" type="text"
													name="complemento" id="complemento"
													value="${param.complemento}" placeholder="Compl" />
											</div>
										</td>
									</tr>
								</table>
								<table>
									<tr>
										<td >
											<div style="padding: 0 10px 0 10px; width: 70px">
												<input class="form-control" maxlength="80" type="text"
													name="uf" id="uf" value="${param.uf}" placeholder="UF" />
											</div>
										</td>
										<td>
											<div style="padding: 0 10px 0 0; width: 300px">
												<input class="form-control" maxlength="80" type="text"
													name="cidade" id="cidade" value="${param.cidade}"
													placeholder="Cidade" />
											</div>
										</td>
										<td>
											<div style="padding: 0 10px 0 0; width: 300px">
												<input class="form-control" maxlength="80" type="text"
													name="bairro" id="bairro" value="${param.bairro}"
													placeholder="Bairro" />
											</div>
										</td>
									</tr>

									<tr>
										<td>
											<div style="padding: 10px 10px 0 10px; width: 400px">
												<input class="form-control email" maxlength="200" type="text"
													name="email" id="email" value="${param.email}"
													placeholder="Email" />
											</div>
										</td>
									</tr>

								</table>
								<table>
									<tr>
										<td>
											<div style="padding: 10px 10px 0 10px">
												<input class="form-control telefone" maxlength="80"
													type="text" name="telefones" id="telefone_1"
													value="${telefone_1}" placeholder="Telefone" />
											</div>
										</td>
										<td>
											<div style="padding: 10px 10px 0 0">
												<input class="form-control telefone" maxlength="80"
													type="text" name="telefones" id="telefone_2"
													value="${telefone_2}" placeholder="Telefone Aux." />
											</div>
										</td>
										<td>
											<div style="padding: 10px 10px 0 0">
												<input class="form-control celular" maxlength="80"
													type="text" name="celulares" id="celular_1"
													value="${celular_1}" placeholder="Celular" />
											</div>
										</td>
										<td>
											<div style="padding: 10px 10px 0 0">
												<input class="form-control celular" maxlength="80"
													type="text" name="celulares" id="celular_2"
													value="${celular_2}" placeholder="Celular Aux." />
											</div>
										</td>
									</tr>
								</table>
							</fieldset>
							<input type="submit" value="Gravar">
						</form>
					</div>
				</div>
			</div>

 <!-- ABA DE PESQUISAR -->
			<div class="tab-pane fade" id="pesquisaClientes">
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
								<td><input class="form-control" type="text"	id="name_pesquisar_clientes" /></td>
								<td><button class="btn btn-danger" id="btn_pesquisar_clientes">Pesquisar</button></td>
						    </tr>
						</table>
						<div id="carregando_lista_clientes" align="center">
							<img src="resources/img/carregando.gif">
						</div>
						<div id="lista_de_clientes" class="table-responsive"></div>
						<br>
					</div>
				</div>
			</div>
  		</div>			
			
			
		</div>





</div>



<c:import url="${footer}"></c:import>