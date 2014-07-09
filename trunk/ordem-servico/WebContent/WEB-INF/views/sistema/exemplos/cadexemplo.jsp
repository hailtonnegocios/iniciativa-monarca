<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:import url="../template/cabecalho.jsp" />
<c:import url="../template/sidebar.jsp" />

<!--  Inicio :  Conteudo das paginas -->
<div id="page-wrapper">
    
    <!-- COMPONENTE DE ABA -->
	<div class="bs-example">
		
		<!-- ABA DE INCLUIR E PESQUISAR -->
		<ul class="nav nav-tabs" style="margin-bottom: 15px;">
			<li class="active"><a href="#cadastrarexemplo" data-toggle="tab">Incluir</a></li>
			<li><a href="#pesquisarexemplo" data-toggle="tab">Pesquisar</a></li>
		</ul>
		
		<c:if test="${mensagem =='S'}">
		
		    <!-- MENSAGEM DE RETORNO DO CADASTRO -->
			<div id="seconds">
				<div class="alert alert-info alert-dismissable">Registro salvo com sucesso !</div>
			</div>
		</c:if>
		
		<!-- ABA DE INCLUIR -->
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade active in" id="cadastrarexemplo">
				<div class="panel panel-default">
					<div class="panel-body">
						<form action="adicionaExemplos" method="post">
  						   <fieldset>
  						   <legend><b>Status do Produto</b></legend>
						      <div>
							     <fmt:message key="sistema.modelo.campo.ativado" />
							     <input type="checkbox" class="myClass" value="true" id="status"	name="status" data-color="green" />
							  </div> 
							<br>
						    </fieldset>
							<fieldset>
							<legend><b>Dados Cadastrais</b></legend>
							<table>
								<tr>
							    	<td><span style="color: red;padding:10px;">*</span></td>
								  	<td>
										<div style="width: 200px;">
									    	<input name="dat_cad" id="dat_cad" class="form-control data" value="${param.dat_cad}" placeholder="Data de cadastro"/>
									      	<form:errors path="exemplo.dat_cad" cssStyle="color:red;" />
									    </div>	
									    <br>
								  	</td>
							    </tr>
								<tr>
									<td><span style="color: red;padding:10px;">*</span></td>
									<td>
										<div style="width: 380px;">
							            	<input class="form-control" maxlength="80" type="text" name="nome" id="nome" value="${param.nome}" placeholder="Nome do produto" />
							              	<form:errors path="exemplo.nome" cssStyle="color:red;" />
							            </div>
							            <br>
							        </td>
							    </tr>
								<tr>
									<td><span style="color: red;padding:10px;">*</span></td>
 						    		<td>
						    			<div style="width: 400px;">
											<textarea class="form-control" style="height:250px;" maxlength="80" name="descricao" id="descricao" placeholder="Descrição do produto">${param.descricao}</textarea>
											<form:errors path="exemplo.descricao" cssStyle="color:red;" />
										</div>
									</td>
								</tr>
							</table>
							</fieldset>
							<br>
							<fieldset>
							<legend><b>Tipo do Produto</b></legend>
							<!-- <label><fmt:message key="sistema.modelo.campo.tipo" /></label>--> 
							<label class="radio-inline"> 
								<c:forEach items="${tiposProdutos}" var="tipoProduto" varStatus="indice">
									<input name="tipo" id="radio${indice.index}" value="${tipoProduto}" ${indice.index == 0? 'checked':''} type="radio" />
								   		${tipoProduto.descricao}
								    <br>
								</c:forEach>
							</label>
							</fieldset>
							<br>
							<!-- <label><fmt:message key="sistema.modelo.campo.tamanho" /></label>-->
							<fieldset>
							<legend><b>Tamanho</b></legend>
							<select class="form-control" name="tamanhos" style="width: 200px;">
								<c:forEach var="tamanhos" items="${myEnum}">
									<option value="${tamanhos}">${tamanhos.descricao}</option>
								</c:forEach>
							</select> 
							</fieldset>
							<br> 
							<button class="btn btn-primary">Salvar</button>
						</form>
				    </div>
			    </div>
		    </div>
		    
            <!-- ABA DE PESQUISAR -->
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
								<td>
	 							  <select class="form-control" id="select_val">
	 							  <c:forEach var="filtro" items="${filtro}">
	 							      <option value="${filtro.descricao}">${filtro.nome}</option>
	 							  </c:forEach>
								   </select>
								</td>
								<td><input class="form-control" type="text"	id="name_pesquisar" /></td>
								<td><button class="btn btn-danger" id="btn_pesquisar">Pesquisar</button></td>
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

        <!-- MODAL DO BOTÃO DE EXCLUIR DA LISTA -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h3>Atenção!</h3>
					</div>
					<div class="modal-body">
						<p>Tem certeza que deseja excluir este Exemplo?</p>
					</div>
					<div class="modal-footer">
						<a id="linkExclusao" class="btn btn-danger"	onclick="excluirComModal();">Sim</a>
						<button class="btn" id="btncancelar" data-dismiss="modal" aria-hidden="true">Não</button>
					</div>
				</div>
			</div>
		</div>

        <!-- MODAL DO LINK DE EXCLUIR OS ITENS MARCADOS -->
		<div class="modal fade" id="myModal_exclusaoLista" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h3>Atenção !</h3>
					</div>
					<div class="modal-body">
						<p>Tem certeza que deseja excluir os itens marcados?</p>
					</div>
					<div class="modal-footer">
						<a id="linkExclusaoLista" class="btn btn-danger" onclick="excluirComModal_list();">Sim</a>
						<button class="btn" id="btncancelarmodal2" data-dismiss="modal"	aria-hidden="true">Não</button>
					</div>
				</div>
			</div>
		</div>


        <!-- MODAL DO LINK DE VERIFICAÇÃO DE ITENS MARCADOS -->
		<div class="modal fade" id="myModalVerificaSelecionado" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h3>Atenção !</h3>
					</div>
					<div class="modal-body">
						<p>A lista não possui itens selecionados !</p>
					</div>
					<div class="modal-footer">
						<button class="btn" id="btncancelarmodal2" data-dismiss="modal"	aria-hidden="true">OK</button>
					</div>
				</div>
			</div>
		</div>




		<!-- INPUT PARA COLOCAR O ID DO ITEM A SER EXCLUIDO DA LISTA -->
		<input type="hidden" id="ASerExcluido">
		<a href="#myModal_exclusaoLista" data-toggle="modal"  type="hidden" id="chamaModalExcluirLista"></a>
		<a href="#myModalVerificaSelecionado" data-toggle="modal"  type="hidden" id="chamaModalVerificaSelecionados"></a>
		
    </div>
</div>
<c:import url="../template/footer.jsp" />