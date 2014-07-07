<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="../template/cabecalho.jsp" />
<c:import url="../template/sidebar.jsp" />

<!--  Inicio :  Conteudo das paginas -->
<div id="page-wrapper">

<!-- 	<div class="alert alert-info alert-dismissable">
		<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">&times;</button>
		Exemplo 1 - Cadastro de Produtos
	</div>-->

	<div class="bs-example">
		<ul class="nav nav-tabs" style="margin-bottom: 15px;">
			<li class="active"><a href="#cadastrarexemplo" data-toggle="tab">Incluir </a></li>
			<li><a href="#pesquisarexemplo" data-toggle="tab">Pesquisar
			</a></li>
			
		</ul>

		<c:if test="${mensagem =='S'}">
		  <div id="seconds"><div class="alert alert-info alert-dismissable">Registro salvo com Sucesso !!!</div></div>
		</c:if>
				
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade active in" id="cadastrarexemplo">
				
				<div class="panel panel-default">
					<div class="panel-body">
						
				
						
											<!-- 				<a href="adicionaExemplos" class="btn btn-primary" role="button">Cadastrar
					Produto</a>-->

						<!--  <a href="listaExemplos" class="btn btn-danger" role="button">Listar Produto</a>-->


						<form action="salvaExemplos" method="post">
							<label> <fmt:message key="sistema.modelo.campo.ativado" />
							</label> <input type="checkbox" class="myClass" value="true" id="status"
								name="status" data-color="green" /> <br> <br> <label>
								<fmt:message key="sistema.modelo.campo.tipo" />
							</label> <label class="radio-inline"> <c:forEach
									items="${tiposProdutos}" var="tipoProduto" varStatus="indice">
									<input name="tipo" id="radio${indice.index}"
										value="${tipoProduto}" ${indice.index == 0? 'checked':''}
										type="radio" /> ${tipoProduto.descricao}<br>
								</c:forEach>
							</label> <br> <br> <label> <fmt:message
									key="sistema.modelo.campo.nome" />
							</label> <input class="form-control" type="text" name="nome" id="nome"
								value="${param.nome}" />
							<form:errors path="exemplo.nome" cssStyle="color:red;" />
							<br> <label> <fmt:message
									key="sistema.modelo.campo.descricao" />
							</label>
							<textarea class="form-control" name="descricao" id="descricao">${param.descricao}</textarea>
							<form:errors path="exemplo.descricao" cssStyle="color:red;" />
							<br> <label> <fmt:message
									key="sistema.modelo.campo.tamanho" />
							</label> <select class="form-control" name="tamanhos"
								style="width: 200px;">
								<c:forEach var="tamanhos" items="${myEnum}">
									<option value="${tamanhos}">${tamanhos.descricao}</option>
								</c:forEach>
							</select> <br> <label> <fmt:message
									key="sistema.modelo.campo.datacad" />
							</label>
							<div style="width: 200px;">
								<input name="dat_cad" id="dat_cad" class="form-control data"
									value="${param.dat_cad}" />
								<form:errors path="exemplo.dat_cad" cssStyle="color:red;" />
								<br>
							</div>


							<button class="btn btn-primary">Salvar</button>
						</form>
						
						
						

					</div>
				</div>



			</div>

			<div class="tab-pane fade" id="pesquisarexemplo">
				<div class="panel panel-default">


					<div class="panel-body">

						<table class="table">
							<tr>
								<th>Filtro</th>
								<th>Campo de Pesquisa</th>
								<th></th>
							</tr>
							<tr>
								<td><select class="form-control" id="select_val">
										<option value="Todos">Pesquisar Todos</option>
										<option value="id_exemplo">Código</option>
										<option value="nome">Nome</option>
										<option value="descricao">Descrição</option>
								</select></td>
								<td><input class="form-control" type="text"
									id="name_pesquisar" /></td>
								<td>
									<button class="btn btn-danger" id="btn_pesquisar">Pesquisar</button>

								</td>
							</tr>
						</table>

						<div id="carregando3" align="center">
							<img src="resources/img/carregando.gif">
						</div>
						<div id="lista_de_exemplos" class="table-responsive"></div>

						<br>


					</div>

				</div>
			</div>
		</div>




		<input type="hidden" id="ASerExcluido">
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h3>Atenção!</h3>
					</div>
					<div class="modal-body">
						<p>Tem certeza que deseja excluir este Exemplo?</p>
					</div>
					<div class="modal-footer">
						<a id="linkExclusao" class="btn btn-danger"
							onclick="excluirComModal();">Sim</a>
						<button class="btn" id="btncancelar" data-dismiss="modal"
							aria-hidden="true">Não</button>
					</div>
				</div>
			</div>
		</div>



		<div class="modal fade" id="myModal_exclusaoLista" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h3>Atenção !</h3>
					</div>
					<div class="modal-body">
						<p>Tem certeza que deseja excluir os itens marcados?</p>
					</div>
					<div class="modal-footer">
						<a id="linkExclusaoLista" class="btn btn-danger"
							onclick="excluirComModal_list();">Sim</a>
						<button class="btn" id="btncancelarmodal2" data-dismiss="modal"
							aria-hidden="true">Não</button>
					</div>
				</div>
			</div>
		</div>

	</div>



	<c:import url="../template/footer.jsp" />