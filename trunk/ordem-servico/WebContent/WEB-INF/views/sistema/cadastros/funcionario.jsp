<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:import url="../template/cabecalho.jsp" />
<c:import url="../template/sidebar.jsp" />

<!--  Inicio :  Conteudo das paginas -->
<div id="page-wrapper">
    
    <!-- COMPONENTE DE ABA - Hailton -->
	<div class="bs-example">
		
		<!-- ABA DE INCLUIR E PESQUISAR -->
		<ul class="nav nav-tabs" style="margin-bottom: 15px;">
			<li class="active"><a href="#cadastrarexemplo" data-toggle="tab">Incluir</a></li>
			<li><a href="#pesquisarexemplo" data-toggle="tab">Pesquisar</a></li>
		</ul>
		
		<c:if test="${mensagem != null}">
		
		    <!-- MENSAGEM DE RETORNO DO CADASTRO -->
			<div id="seconds">
				<div class="alert alert-info alert-dismissable">${mensagem}</div>
			</div>
		</c:if>
		
		<!-- ABA DE INCLUIR -->
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade active in" id="cadastrarexemplo">
				<div class="panel panel-default">
					<div class="panel-body">
						<form action="adicionaFuncionario" method="post">
							<fieldset>
							<legend><b><fmt:message key="sistema.funcionario.legend.dadoscadastrais" /></b></legend>
							<table>
 							       <tr>
 							       <td style="color:red;padding-right:5px;">*</td>
				                    <td colspan="2">
					                    <div style="padding:0 10px 10px 0;width:400px">
							                 <input class="form-control" maxlength="80" type="text" name="nome" id="nome" value="${param.nome}" placeholder="Nome Completo" />
							            </div>
							          </td>
							          <td>
							              <div style="padding:0 10px 10px 0">
							            	<input class="form-control rg" maxlength="80" type="text" name="rg" id="rg" value="${param.rg}" placeholder="Rg" />
							              	
							              </div>
							          </td>
							          <td>
							             <div style="padding:0 10px 10px 0">
							            	<input class="form-control cpf" maxlength="80" type="text" name="cpf" id="cpf" value="${param.cpf}" placeholder="Cpf" />
							              	
							             </div>
							          </td>
							          </tr>
							          <tr><td></td><td><form:errors path="funcionario.nome" cssStyle="color:red;" /><td><td><td><td><td></tr>
							   </table>
                               <table>
                                     <tr>
                                     <td>													         
							             <div style="padding: 0 0 0 10px">
                                             <input class="form-control cep" maxlength="80" type="text" name="cep" id="cep" value="${param.cep}" placeholder="Cep" onblur="javascript:consultaEndereco();" />
							             </div>
							         </td>
							         <td>
							            <div id="carrega_endereco" style="padding: 0 0 0 10px"><img  src="resources/img/carregando.gif"></div>
							            <div id="retorno_endereco_success" style="padding: 0 0 10px 10px;color:green;"><img src="resources/img/success_endereco.png"> Endereço encontrado com sucesso !</div>
							            <div id="retorno_endereco_error" style="padding: 0 0 10px 10px;color:red;"><img src="resources/img/error_endereco.png"> Endereço não encontrado ou CEP inválido</div>
							         </td>
							         </tr>
							    </table>
							    <table>
							         <tr>
                                     <td>													         
							            <div style="padding:10px 10px 10px 10px;width:90px">
                                           <input class="form-control" maxlength="80" type="text" name="tipo_logradouro" id="tipo_logradouro" value="${param.tipo_logradouro}" placeholder="Logra." />
							            </div>
							         </td>
							         <td>
							            <div style="padding:10px 10px 10px 0;width:450px">
                                            <input class="form-control" maxlength="80" type="text" name="logradouro" id="logradouro" value="${param.logradouro}" placeholder="Endereço" />
							            </div>
							         </td>
							         <td>
							            <div style="padding:10px 10px 10px 0;width:80px">
                                           <input class="form-control" maxlength="80" type="text" name="numero" id="numero" value="${param.numero}" placeholder="Nº" />
							            </div>
							         </td>
							         <td>
							            <div style="padding:10px 10px 10px 0;width:80px">
                                           <input class="form-control" maxlength="80" type="text" name="complemento" id="complemento" value="${param.complemento}" placeholder="Compl" />
							            </div>
							         </td>
							         </tr>
							     </table>
							     <table>
							          <tr>
							          <td>
							             <div style="padding:0 10px 0 10px;width:70px">
                                            <input class="form-control" maxlength="80" type="text" name="uf" id="uf" value="${param.uf}" placeholder="UF" />
							             </div>
							          </td>
							          <td>
							             <div style="padding:0 10px 0 0;width:300px">
                                            <input class="form-control" maxlength="80" type="text" name="cidade" id="cidade" value="${param.cidade}" placeholder="Cidade" />
							             </div>
							          </td>
							          <td>
							             <div style="padding:0 10px 0 0;width:300px">
                                            <input class="form-control" maxlength="80" type="text" name="bairro" id="bairro" value="${param.bairro}" placeholder="Bairro" />
							             </div>
							          </td>
							          </tr>
							     </table>
							     <table>
							     	 <tr>
							            <td>
							              <div style="padding: 10px 10px 0 10px">
							            	<input class="form-control telefone" maxlength="80" type="text" name="telefones" id="telefone_1" value="${telefone_1}" placeholder="Telefone" />
							              </div>
							            </td>
							            <td>
							              <div style="padding: 10px 10px 0 0">
							            	<input class="form-control telefone" maxlength="80" type="text" name="telefones" id="telefone_2" value="${telefone_2}" placeholder="Telefone Aux." />
							              </div>
							            </td>
							            <td>
							              <div style="padding: 10px 10px 0 0">
							            	<input class="form-control celular" maxlength="80" type="text" name="celulares" id="celular_1" value="${celular_1}" placeholder="Celular" />
							              </div>
							            </td>
							            <td>
							              <div style="padding: 10px 10px 0 0">
							            	<input class="form-control celular" maxlength="80" type="text" name="celulares" id="celular_2" value="${celular_2}" placeholder="Celular Aux." />
							              </div>
							            </td>
							            </tr>
							     </table>
							     
                             </fieldset>
                             <br>
                             
                            <fieldset>
                            <legend><b><fmt:message key="sistema.funcionario.legend.setor" /></b></legend>
                            
                            <table>                            
							    <tr>
							      <td>
							        <div style="padding:0 10px 10px 10px;width:200px">
						          <select class="form-control" name="setor" id="setor">
							             <option value="Compra">Compra</option>
							             <option value="Tecninca">Técnica</option>
							             <option value="Vendas">Vendas</option>
							          </select>
							        </div>
							      </td>
							     </tr>
                            </table>                      
                            </fieldset>
                            <fieldset>
                              <legend><b><fmt:message key="sistema.funcionario.legend.autenticacao" /></b></legend>
                                    <table>
    							        <tr>
    							        <td style="color:red">*</td>
							            <td>
							               <div style="padding: 15px 10px 0 5px;width:350px;">
							            	  <input class="form-control" maxlength="80" type="text" name="email" id="email" value="${param.email}" placeholder="Email" />
							               </div>
							            </td>
							            <td style="color:red">*</td>
							            <td>
							               <div style="padding: 15px 10px 0 5px">
							            	  <input class="form-control" maxlength="80" type="password" name="senha" id="senha" value="${param.senha}" placeholder="Senha" />
							              	  
							               </div>
							            </td>
							          <td>
							          <div style="padding:0 10px 10px 0;width:200px">
							          <label><fmt:message key="sistema.funcionario.label.permissao" /></label>
							          <select class="form-control" name="permissao" id="permissao">
							             <option value="ADMIN">ADMIN</option>
							             <option value="FUNC">FUNC</option>
							          </select>
							        </div>
							        </td>
							        </tr>
							          <tr>
							              <td></td>
							              <td><form:errors path="funcionario.email" cssStyle="color:red;" /></td>
							              <td></td>
							              <td><form:errors path="funcionario.senha" cssStyle="color:red;" /></td>
							              <td><form:errors path="funcionario.permissao" cssStyle="color:red;" /></td>
							          </tr>
                                     </table>  
                            </fieldset>
                            <br>
                            <div style="padding:0 0 0 10px;">
							<button class="btn btn-danger" ><fmt:message key="sistema.funcionario.btn.salvar" /></button>
							</div>
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
	 							  <select class="form-control" id="">
	 							  <c:forEach var="filtro" items="">
	 							      <option value=""></option>
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
						<a id="linkExclusao" class="btn btn-danger"	onclick="">Sim</a>
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
						<a id="linkExclusaoLista" class="btn btn-danger" onclick="">Sim</a>
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