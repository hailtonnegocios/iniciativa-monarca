<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:import url="../template/cabecalho.jsp" />
<c:import url="../template/sidebar.jsp" />

<!--  Inicio :  Conteudo das paginas -->
<div id="page-wrapper">
    <!-- COMPONENTE DE ABA -->
	<div class="bs-example">
		<ul class="nav nav-tabs" style="margin-bottom: 15px;">
			<li class="active"><a href="#cadastrarexemplo" data-toggle="tab">Alterar Exemplo </a></li>
		</ul>
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade active in" id="cadastrarexemplo">
				<br>
				<div class="panel panel-default">
					<div class="panel-body">
						<form action="alteraExemplos" method="post">
							<fieldset>
								<legend><b>Status do Produto</b></legend>
								<div>
									<fmt:message key="sistema.modelo.campo.ativado" />
									<input type="checkbox" class="myClass" ${exemplo1Selecionado.status? 'checked':''} id="status"
								    name="status" data-color="green" />
								</div>
								<br>
							</fieldset>
							<br>
							<fieldset>
								<legend><b>Dados Cadastrais</b></legend>
								<table>
									<tr>
										<td><span style="color: red; padding: 10px;"></span></td>
										<td><label>Código do Produto</label>
											<div style="width: 80px;">
												<input class="form-control" type="text" readonly="readonly"
												name="id_exemplo" id="id_exemplo"
												value="${exemplo1Selecionado.id_exemplo}" />
											</div> 
											<br>
										</td>
									</tr>
									<tr>
										<td><span style="color: red; padding: 10px;">*</span></td>
										<td><label><fmt:message
													key="sistema.modelo.campo.datacad" /></label>
											<div style="width: 200px;">
												<input name="dat_cad" id="dat_cad" class="form-control data"
													value="<fmt:formatDate value="${exemplo1Selecionado.dat_cad.time}"
					                              pattern="dd/MM/yyyy" />" />
												<form:errors path="exemplo.dat_cad" cssStyle="color:red;" />
											</div> <br>
										</td>
									</tr>
									<tr>
										<td><span style="color: red; padding: 10px;">*</span></td>
										<td><label><fmt:message	key="sistema.modelo.campo.nome" /></label>
											<div style="width: 380px;">
												<input class="form-control" maxlength="80" type="text"
													name="nome" id="nome" value="${exemplo1Selecionado.nome}" />
												<form:errors path="exemplo.nome" cssStyle="color:red;" />
											</div> <br>
										</td>
									</tr>
									<tr>
										<td><span style="color: red; padding: 10px;">*</span></td>
										<td><label><fmt:message	key="sistema.modelo.campo.descricao" /></label>
											<div style="width: 400px;">
												<textarea class="form-control" maxlength="350"
												style="height: 200px;" name="descricao" id="descricao">${exemplo1Selecionado.descricao}</textarea>
												<form:errors path="exemplo.descricao" cssStyle="color:red;" />
											</div>
										</td>
									</tr>
								</table>
							</fieldset>
							<br>
							<fieldset>
								<legend><b>Tipo do Produto</b></legend>
								<label class="radio-inline"> 
									<c:forEach	items="${tiposProdutos}" var="tipoProduto" varStatus="indice">
										<input name="tipo" id="radio${indice.index}"
											value="${tipoProduto}"
											${tipoProduto.descricao == exemplo1Selecionado.tipo.descricao? 'checked':''}
											type="radio" />${tipoProduto.descricao}
											<br>
									</c:forEach>
								    <br>
								</label>
							</fieldset>
							<br>
							<fieldset>
								<legend><b>Tamanho</b></legend>
								<select class="form-control" name="tamanhos" style="width: 200px;">
									<c:forEach var="tamanhos" items="${myEnum}">
										<option value="${tamanhos}"	${exemplo1Selecionado.tamanhos == tamanhos? 'selected':''}>${tamanhos.descricao}</option>
									</c:forEach>
								</select>
							</fieldset>
							<br>
							<button class="btn btn-primary">Salvar</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<c:import url="../template/footer.jsp" />