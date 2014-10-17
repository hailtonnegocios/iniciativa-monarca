         
            $("#retorno_endereco_success").hide();
            $("#retorno_endereco_error").hide();
            $("#carrega_endereco").hide();
            function consultaEndereco(){
            	$("#carrega_endereco").show();
                $("#retorno_endereco_success").hide();
                $("#retorno_endereco_error").hide();
			    
                $.post("consultaEndereco", {cep:$('#cep').val()}, function(data) {
				   obj = JSON.parse(data);
				   
				   $('#numero').val("");
				   $('#complemento').val("");
				   
				   $('#cep').css('border-width','1.8px');
				   obj.logradouro != "" ? $("#retorno_endereco_success").show() :$("#retorno_endereco_success").hide();
				   obj.logradouro != "" ? $("#retorno_endereco_error").hide() :$("#retorno_endereco_error").show();
				   obj.logradouro != "" ? $('#cep').css('border-color','#5cb85c'):$('#cep').css('border-color','#FF0000');;
				  
				   $('#uf').val(obj.uf);
				   $('#uf').css('border-width','1.8px');
				   obj.uf != "" ? $('#uf').css('border-color','#5cb85c'):$('#uf').css('border-color','#FF0000');;
				  
				   $('#cidade').val(obj.cidade);
				   $('#cidade').css('border-width','1.8px');
				   obj.cidade != "" ? $('#cidade').css('border-color','#5cb85c'):$('#cidade').css('border-color','#FF0000');;
				  
				   $('#bairro').val(obj.bairro);
				   $('#bairro').css('border-width','1.8px');
				   obj.bairro != "" ? $('#bairro').css('border-color','#5cb85c'):$('#bairro').css('border-color','#FF0000');;
				  
				   $('#tipo_logradouro').val(obj.tipo_logradouro);
				   $('#tipo_logradouro').css('border-width','1.8px');
				   obj.logradouro != "" ? $('#tipo_logradouro').css('border-color','#5cb85c'):$('#tipo_logradouro').css('border-color','#FF0000');;

				   
				   $('#logradouro').val(obj.logradouro);
				   $('#logradouro').css('border-width','1.8px');
				   obj.logradouro != "" ? $('#logradouro').css('border-color','#5cb85c'):$('#logradouro').css('border-color','#FF0000');;

				   $("#carrega_endereco").hide();
				   $('#numero').focus();
				   
				   
				   // ESTA PARTE DO CODIGO É PARA FUNCIONAR APENAS NA PAGINA CLIENTE PJ POIS SEU DESENHO FOI ALTERADO
				   // EM RELAÇAO A PAGINA CLIENTE (QUE SERIA APENAS PARA CLIENTES PF)
				   if(obj.resultado == 1){
						  $('.endereco').show();
						  $('.email_empresa').show();
						  $('.tel_empresa').show();
						  $('#numero').focus();
						  $('.btn_gravar').removeClass("disabled");
						 
					   }else{
						  $('.endereco').hide();
						  $('.email_empresa').hide();
						  $('.tel_empresa').hide();
						  $('.btn_gravar').addClass("disabled");
						  $('#cep').focus();
					   }

			    });
          }
            
            // CONSULTAR FUNCIONARIO ------------------------------------------------------------------------------
			$("#lista_de_funcionarios").hide();
			$("#carregando_lista_func").hide();
			$("#btn_pesquisar_func").click(function() {
				if ($("#name_pesquisar_func").val() != "" || $("#select_val_func").val() == "Todos"){
				$("#carregando_lista_func").show();
				   $.post("listaLikeFunc", {campo:$("#select_val_func").val() , name_pesq:$("#name_pesquisar_func").val() }, function(data) {
				       var html_text = "";
				       obj = JSON.parse(data);

				       if(obj.length > 0){
					       $("#lista_de_funcionarios").html("");
					       //inserindo a tabela na div #lista_de_funcionarios
					       $("#lista_de_funcionarios").html(Tabela_Funcionarios(html_text));
					       $("#carregando_lista_func").hide();
					    }else{
					       $("#lista_de_funcionarios").html("<center><div style=\"color:red;\">Sem Resultados na consulta !!</div></center>");
					       $("#carregando_lista_func").hide();
 					    }
			       });
		        $("#lista_de_funcionarios").show();
				}else{
					$("#lista_de_funcionarios").html("<center><div style=\"color:red;\">Sem Resultados !!</div></center>");
					$("#lista_de_funcionarios").show();
				}
			});
			
			// TABELA DE FUNCIONARIO -----------------------------------------------------------------------------------------------------
			function Tabela_Funcionarios(html_text){
				   html_text = html_text +

				       // Link para Marcar os checkbox
	                   "<span style=\"padding-right:15px;\">" +
	                      "<img src=\"resources/img/check_icon.png\" style=\"padding-right:10px;\">" +
	                      "<a id=\"label_check\" href=\"#\" onclick=\"javascript:marcar_e_desmarcarTodosOsCheckbox_func();\" role=\"button\">Marcar todos</a>" +
	                   "</span>"+
	                   
	                   // Link para Excluir todos os checkbox marcados pelo usuario
	                   "<span>" +
	                   "  <img src=\"resources/img/del_icon.png\" style=\"padding-right:10px;\">" +
	                   "  <a href=\"#\" onclick=\"javascript:verificaComboboxMarcada_func(); \" role=\"button\">Excluir itens selecionados</a>" +
	                   "</span>"+
	                   
	                   " <br><br>" +
	                   " <table class=\"table table-hover\">" +
	                   " <tr>"+
	                   " <th class=\"info\"></th>"+
			           " <th class=\"info\">Codigo</th>"+
			           " <th class=\"info\">Nome</th>"+
			           " <th class=\"info\">Rg</th>"+
			           " <th class=\"info\">CPF</th>"+
			           " <th class=\"info\">email</th>"+
			           " <th class=\"info\">Setor</th>"+
			           " <th class=\"info\">Editar</th>"+
 		               " <th class=\"info\">Excluir</th></tr>";
							  
				  for(var i=0;i < obj.length;i++){
					   html_text = html_text +
					   ' <tr>'+
					   ' <td><input type="checkbox" value="'+obj[i].id_usuario+'" id="check'+obj[i].id_usuario+'/"><br /></td>'+ 
					   ' <td>'+obj[i].id_usuario+'</td>'+
					   /*' <td>'+(obj[i].dat_cad != undefined?obj[i].dat_cad.dayOfMonth:'__')+'/'+
						       (obj[i].dat_cad != undefined?obj[i].dat_cad.month:'__')+'/'+
						       (obj[i].dat_cad != undefined?obj[i].dat_cad.year:'__')+'</td>'+ */
					   ' <td>'+obj[i].nome+'</td>'+
					   ' <td>'+obj[i].rg+'</td>'+
					   ' <td>'+obj[i].cpf+'</td>'+
					   ' <td>'+obj[i].email+'</td>'+
					   ' <td class=\"success\">'+obj[i].setor+'</td>'+
					   ' <td>'+
						
					   // Botao de alterar
					   ' <a href=\"mostraFuncionario?id='+obj[i].id_usuario+
					   ' \" title=\"Alterar\" class=\"btn btn-small btn-primary\" role=\"button\" class=\"btn\">'+
					   ' <i class=\"fa fa-edit\"></i></a> '+
					   '<td>'+		
					   // Botao de excluir
					   ' <a href=\"#myModal_func\"	id=\"'+obj[i].id_usuario+'\" name=\"'+
					     obj[i].id_usuario+'\" onclick=\"atualizarHiddenASerExcluido('+obj[i].id_usuario+');\"'+
					   ' class=\"btn btn-small btn-danger\" role=\"button\" class=\"btn\"'+
					   ' data-toggle=\"modal\" title=\"Excluir\">'+ 
					   ' <i class=\"fa fa-share-square-o\"></i></a>';
				  }
					html_text+'</td></tr></table>';
					return html_text;
			}


			
			// BOTAO DE EXCLUIR DA LISTA ----------------------------------------------------------------------------------------------
			function excluirComModal() {
				   var html_text = "";
				   $.post("deletaFuncionarioAjax", {tipo_pesq:$("#select_val_func").val(),name_pesq:$("#name_pesquisar_func").val(),id : $('#ASerExcluido_func').val()}, function(data) {
				      
					  obj = JSON.parse(data);
				      $("#lista_de_funcionarios").html("");

	 		          //inserindo a tabela na div #ajax4			      
				      $("#lista_de_funcionarios").html(Tabela_Funcionarios(html_text));
				      $("#carregando_lista_func").hide();

				      // tirar a tela de opacidade de fundo do modal
				      $(".modal-backdrop").css('position','inherit'); 
				      $("#btncancelar_func").click();
				      
				   });
				}
			
			// ATUALIZA O VALOR DO INPUT COM HIDDEN NA TELA
			function atualizarHiddenASerExcluido(valor) {
			  $('#ASerExcluido_func').val(valor);
			}

			
			// AO CLICAR NO BOTAO DO MODAL A ROTINA ABAIXO SERA EXECUTADA  
			function excluirComModal_list_func() {
			   var html_text = "";
			   
			   $.post("deletaFuncionarioAjaxListaJson", {tipo_pesq:$("#select_val_func").val(),name_pesq:$("#name_pesquisar_func").val(),ListaJson : retornaListadeId_funcionario_no_FormatoJson()}, function(data) {
			      
				  obj = JSON.parse(data);
			      $("#lista_de_funcionarios").html("");

 		          //inserindo a tabela na div #ajax4			      
			      $("#lista_de_funcionarios").html(Tabela_Funcionarios(html_text));
			      $("#carregando_lista_func").hide();

			      // tirar a tela de opacidade de fundo do modal
			      $(".modal-backdrop").css('position','inherit'); 
			      $("#btncancelarmodal2_func").click();
			      
			   });
			}
			
			//VAI VERIFICAR SE A LISTA POSSUI ITENS SELECIONADOS
			function verificaComboboxMarcada_func(){
				if(retornaSelecionados_func() == 0){
					$('#chamaModalVerificaSelecionados_func').click();
					
				}else{
					$('#chamaModalExcluirLista_func').click();
				}
			}
			
			
			// RETORNA A QUANTIDADE DE ITENS MARCADOS NA LISTA
			function retornaSelecionados_func(){
				  var inputs, i, selecionado=0;

				  // pegar todas as tagName input para varrer todos que tiverem o tipo checkbox
				  inputs = document.getElementsByTagName('input');
				  
				  for(i=0;i<inputs.length;i++){
				    // vao ser marcados somente os check que iniciam com id = check, ou seja, se caso outro check estiver com outro id n�o ser� marcado
				    if((inputs[i].type=='checkbox') && ((inputs[i].id).substring(0, 5) == 'check')){
				      if(inputs[i].checked==true){
                         selecionado++;
				      }
				    }
				  }
				  return selecionado;
			}

			// MARCAR TODOS OS CHECKBOX
			var flag = true;
			function marcar_e_desmarcarTodosOsCheckbox_func(){
				  var inputs, i;
				  
				  // pegar todas as tagName input para varrer todos que tiverem o tipo checkbox
				  inputs = document.getElementsByTagName('input');
				  
				  if(flag){
					  for(i=0;i<inputs.length;i++){
						// vao ser marcados somente os check que iniciam com id= check, ou seja, se caso outro check estiver com outro id n�o ser� marcado  
					    if((inputs[i].type=='checkbox')  && ((inputs[i].id).substring(0, 5) == 'check')){
					    	inputs[i].checked=true;
					    	$('#label_check').text("Desmarcar Todos");
					    }
					  }
				      flag=false;
				  }
				  else{
					  for(i=0;i<inputs.length;i++){
						if(inputs[i].type=='checkbox'){
					    	inputs[i].checked=false;
					    	$('#label_check').text("Marcar Todos");
					    }
					  }
				  flag=true;
				 }
			}
			
			
			// RETORNA OS IDS CHECKADOS NO FORMATO JSON
			function retornaListadeId_funcionario_no_FormatoJson(){
				  var inputs, i, valor="";

				  // pegar todas as tagName input para varrer todos que tiverem o tipo checkbox
				  inputs = document.getElementsByTagName('input');
				  
				  valor = "{\"funcionario\":[";
				  for(i=0;i<inputs.length;i++){
					  
				    // vao ser marcados somente os check que iniciam com id = check, ou seja, se caso outro check estiver com outro id n�o sera marcado
				    if((inputs[i].type=='checkbox') && ((inputs[i].id).substring(0, 5) == 'check')){
				      if(inputs[i].checked==true){
				        valor+="{\id_usuario\:"+inputs[i].value+"},";
				      }
				    }
				  }
				  
				  // Retirar o ultimo caracter da string , ou seja , a virgula
				  valor = valor.substring(0,(valor.length - 1));

				  valor+="]}";
				  
				  return valor;
			}
			