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
							<legend><b>Dados Cadastrais</b></legend>
							<table>
 							       <tr>
				                    <td colspan="2">
					                    <div style="padding-bottom:10px;">
							                 <input class="form-control" maxlength="80" type="text" name="nome" id="nome" value="" placeholder="Nome do Funcionário" />
							                <!--  <form:errors path="" cssStyle="color:red;" />-->
							            </div>
							          </td>
							       </tr>
							       <tr>
							          <td>
							              <div style="padding:0 10px 0 0">
							            	<input class="form-control rg" maxlength="80" type="text" name="rg" id="rg" value="" placeholder="Rg" />
							              	<!--<form:errors path="" cssStyle="color:red;" />-->
							              </div>
							          </td>
							          <td>
							             <div>
							            	<input class="form-control cpf" maxlength="80" type="text" name="cpf" id="cpf" value="" placeholder="Cpf" />
							              	<!--<form:errors path="" cssStyle="color:red;" />-->
							             </div>
							          </td>
							          </tr>
							          <tr>
							            <td>
							              <div style="padding: 10px 10px 0 0">
							            	<input class="form-control" maxlength="80" type="text" name="telefones" id="telefone_1" value="" placeholder="Telefone 1" />
							              	<!--<form:errors path="" cssStyle="color:red;" />-->
							              </div>
							            </td>
							            <td>
							              <div style="padding: 10px 10px 0 0">
							            	<input class="form-control" maxlength="80" type="text" name="telefones" id="telefone_2" value="" placeholder="Telefone 2" />
							              	<!--<form:errors path="" cssStyle="color:red;" />-->
							              </div>
							            </td>
							             <td>
							              <div style="padding: 10px 10px 0 0">
							            	<input class="form-control" maxlength="80" type="text" name="telefones" id="telefone_3" value="" placeholder="Telefone 2" />
							              	<!--<form:errors path="" cssStyle="color:red;" />-->
							              </div>
							            </td>
							            </tr>
							            <tr>
							            <td>
							              <div style="padding: 10px 10px 0 0">
							            	<input class="form-control" maxlength="80" type="text" name="celulares" id="celular_1" value="" placeholder="Celular 1" />
							              	<!--<form:errors path="" cssStyle="color:red;" />-->
							              </div>
							            </td>
							            <td>
							              <div style="padding: 10px 10px 0 0">
							            	<input class="form-control" maxlength="80" type="text" name="celulares" id="celular_2" value="" placeholder="Celular 2" />
							              	<!--<form:errors path="" cssStyle="color:red;" />-->
							              </div>
							            </td>
							             <td>
							              <div style="padding: 10px 10px 0 0">
							            	<input class="form-control" maxlength="80" type="text" name="celulares" id="celular_3" value="" placeholder="Celular 3" />
							              	<!--<form:errors path="" cssStyle="color:red;" />-->
							              </div>
							            </td>
							            </tr>
							</table>
							</fieldset>
							<br>
                            <fieldset>
                              <legend><b>Login</b></legend>
                                    <table>
    							        <tr>
							            <td>
							               <div style="padding: 15px 10px 0 0">
							            	  <input class="form-control" maxlength="80" type="text" name="email" id="email" value="" placeholder="Usuário" />
							              	  <!--<form:errors path="" cssStyle="color:red;" />-->
							               </div>
							            </td>
							            <td>
							               <div style="padding: 15px 10px 0 0">
							            	  <input class="form-control" maxlength="80" type="password" name="senha" id="senha" value="" placeholder="Senha" />
							              	  <!--<form:errors path="" cssStyle="color:red;" />-->
							               </div>
							            </td>
							          <td>
							          <div style="padding:0 10px 10px 0;width:200px">
							          <label>Permissão</label>
							          <select class="form-control" name="permissao" id="permissao">
							             <option value="ADMIN">ADMIN</option>
							             <option value="FUNC">FUNC</option>
							          </select>
							        </div>
							        </td>
							            
							            </tr>
                                     </table>  
                            </fieldset>
                            <br>
                            <fieldset>	
                                <legend><b>Endereço</b></legend>
                                <table>
                                     <tr>
                                     <td>													         
							             <div>
                                             <input class="form-control cep" maxlength="80" type="text" name="endereco.cep" id="cep" value="" placeholder="Cep" onblur="javascript:consultaEndereco();" />
							                 <!--<form:errors path="" cssStyle="color:red;" />-->
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
							            <div style="padding:10px 10px 10px 0;width:90px">
                                           <input class="form-control" maxlength="80" type="text" name="endereco.tipo_logradouro" id="tipo_logradouro" value="" placeholder="Logra." />
							               <!--<form:errors path="" cssStyle="color:red;" />-->
							            </div>
							         </td>
							         <td>
							            <div style="padding:10px 10px 10px 0;width:450px">
                                            <input class="form-control" maxlength="80" type="text" name="endereco.logradouro" id="logradouro" value="" placeholder="Endereço" />
							               <!-- <form:errors path="" cssStyle="color:red;" />-->
							            </div>
							         </td>
							         <td>
							            <div style="padding:10px 10px 10px 0;width:80px">
                                           <input class="form-control" maxlength="80" type="text" name="endereco.numero" id="numero" value="" placeholder="Nº" />
							               <!--<form:errors path="" cssStyle="color:red;" />-->
							            </div>
							         </td>
							         <td>
							            <div style="padding:10px 10px 10px 0;width:80px">
                                           <input class="form-control" maxlength="80" type="text" name="endereco.complemento" id="complemento" value="" placeholder="Compl" />
							               <!--<form:errors path="" cssStyle="color:red;" />-->
							            </div>
							         </td>
							         </tr>
							     </table>
							     <table>
							          <tr>
							          <td>
							             <div style="padding:0 10px 0 0;width:70px">
                                            <input class="form-control" maxlength="80" type="text" name="endereco.uf" id="uf" value="" placeholder="UF" />
							                <!--<form:errors path="" cssStyle="color:red;" />-->
							             </div>
							          </td>
							          <td>
							             <div style="padding:0 10px 0 0;width:300px">
                                            <input class="form-control" maxlength="80" type="text" name="endereco.cidade" id="cidade" value="" placeholder="Cidade" />
							                <!--<form:errors path="" cssStyle="color:red;" />-->
							             </div>
							          </td>
							          <td>
							             <div style="padding:0 10px 0 0;width:300px">
                                            <input class="form-control" maxlength="80" type="text" name="endereco.bairro" id="bairro" value="" placeholder="Bairro" />
							                <!--<form:errors path="" cssStyle="color:red;" />-->
							             </div>
							          </td>
							          </tr>
							     </table>
                            </fieldset>
                            <br>
                            <fieldset>
                            <legend><b>Setor</b></legend>
                            
                            <table>                            
							    <tr>
							      <td>
							        <div style="padding:0 10px 10px 0;width:200px">
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
							<br>
							<button class="btn btn-success">Salvar</button>
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