//  ---------------------------  FUNÇÕES RELACIONADAS A TELA DE EXEMPLOS COM AJAX --------------------------------  

         
	      // AO CLICAR NO PRIMEIRO EXEMPLO SERÁ MANDADA UMA REQUISIÇÃO AO MÉTODO  funcAjax1 NO CONTROLLER
		  $("#ajax1").hide();
		  $("#btnTeste1").click(function() {
			 $.post("funcAjax1", {}, function(resposta) {
					$("#ajax1").html('Retorno: '+resposta);
			 });
			   $("#ajax1").toggle("up");
		  });
		
		  // AO CLICAR NO SEGUNDO EXEMPLO SERÁ MANDADA UMA REQUISIÇÃO AO MÉTODO  funcAjax2 NO CONTROLLER
		  $("#ajax2").hide();
		  $("#carregando1").hide();
		  $("#btnTeste2").click(function() {
			  $("#carregando1").show();
				$.post("funcAjax2", {}, function(data) {
				 var obj = JSON.parse(data);
				 $("#ajax2").html('Retorno: <br><br>'+
						'ID: '+obj.id_exemplo+'<br>'+
						'NOME: '+obj.nome+'<br>'+
						'DESCRIÇÃO: '+obj.descricao+'<br>'+
						'STATUS: '+obj.status+'<br>'+
						'TIPO: '+obj.tipo);
				    $("#carregando1").hide();
			    });
			     $("#ajax2").toggle("up");
			});

		    // AO CLICAR NO TERCEIRO EXEMPLO SERÁ MANDADA UMA REQUISIÇÃO AO MÉTODO  funcAjax3 NO CONTROLLER
			$("#ajax3").hide();
			$("#carregando2").hide();
			$("#btnTeste3").click(function() {
				$("#carregando2").show();
				$.post("funcAjax3", {}, function(data) {
				  var t = "";
				  obj = JSON.parse(data);
				  $("#ajax3").html("");
				  for(var i=0;i < obj.length;i++){
					  t = t +'<br><br>'+
					        'ID: '+obj[i].id_exemplo+'<br>'+
							'NOME: '+obj[i].nome+'<br>'+
							'DESCRIÇÃO: '+obj[i].descricao+'<br>'+
							'STATUS: '+obj[i].status+'<br>'+
							'TIPO: '+obj[i].tipo;+'<br><br>';
				  }
				  $("#ajax3").html('Retorno:'+t);
				  $("#carregando2").hide();
			    });
			    $("#ajax3").toggle("up");
			});
			
  		    // AO CLICAR NO QUARTO EXEMPLO SERÁ MANDADA UMA REQUISIÇÃO AO MÉTODO  funcAjax4 NO CONTROLLER
			$("#ajax4").hide();
			$("#tabela_pesquisar").hide();
			$("#carregando3").hide();
		    
			$("#btnTeste4").click(function() {
				  $("#name_pesq").val("");
				  $("#select_val").val("Todos")
			      $("#tabela_pesquisar").toggle("up");
			      $("#ajax4").hide();
	        });
				
			$("#btn_pesq").click(function() {
				if ($("#name_pesq").val() != "" || $("#select_val").val() == "Todos"){
				$("#carregando3").show();
				   $.post("listaLike", {tipo_pesq:$("#select_val").val() , name_pesq:$("#name_pesq").val() }, function(data) {
				       var html_text = "";
				       obj = JSON.parse(data);
				       $("#ajax4").html("");

				       //inserindo a tabela na div #ajax4
				       $("#ajax4").html(Tabela_Exemplos_Ajax(html_text));

				       $("#carregando3").hide();
			       });
		        $("#ajax4").show();
				}else{
					$("#ajax4").html("<center><div style=\"color:red;\">Sem Resultados !!</div></center>");
					$("#ajax4").show();
				}
			});
			
			
//  ---------------------------  FUNÇÕES RELACIONADAS A TELA DE cadastroExemplo -------------------------------------------------------------	
			
			
  		    // AO CLICAR NO BOTÃO DE PESQUISAR DA TELA DE cadastroExemplo , SERÁ LISTADO TODOS OS EXEMPLOS COM RELAÇÃO AO FILTRO ESCOLHIDO  
			$("#lista_de_exemplos").hide();
			$("#carregando3").hide();
			$("#btn_pesquisar").click(function() {
				if ($("#name_pesquisar").val() != "" || $("#select_val").val() == "Todos"){
				$("#carregando3").show();
				   $.post("listaLike", {tipo_pesq:$("#select_val").val() , name_pesq:$("#name_pesquisar").val() }, function(data) {
				       var html_text = "";
				       
				       obj = JSON.parse(data);
				       $("#lista_de_exemplos").html("");

				       //inserindo a tabela na div #lista_de_exemplos
				       $("#lista_de_exemplos").html(Tabela_Exemplos(html_text));

				       $("#carregando3").hide();
			       });
		        $("#lista_de_exemplos").show();
				}else{
					$("#lista_de_exemplos").html("<center><div style=\"color:red;\">Sem Resultados !!</div></center>");
					$("#lista_de_exemplos").show();
				}
			});
			
			
			// AO CLICAR NO BOTÃO DO MODAL A ROTINA ABAIXO SERÁ EXECUTADA  
			function excluirComModal() {
			   $("#ajax2").val("");
			   var html_text = "";
			   $.post("deletaExemplosAjax", {tipo_pesq:$("#select_val").val(),name_pesq:$("#name_pesquisar").val(),id : $('#ASerExcluido').val()}, function(data) {
			      
				  obj = JSON.parse(data);
			      $("#lista_de_exemplos").html("");

 		          //inserindo a tabela na div #ajax4			      
			      $("#lista_de_exemplos").html(Tabela_Exemplos(html_text));
			      $("#carregando3").hide();

			      // tirar a tela de opacidade de fundo do modal
			      $(".modal-backdrop").css('position','inherit'); 
			      $("#btncancelar").click();
			      
			   });
			}
		

			
			// AO CLICAR NO BOTÃO DO MODAL A ROTINA ABAIXO SERÁ EXECUTADA  
			function excluirComModal_list() {
			   $("#ajax2").val("");
			   var html_text = "";
			   $.post("deletaExemplosAjaxListaJson", {tipo_pesq:$("#select_val").val(),name_pesq:$("#name_pesquisar").val(),ListaJson : retornaListadeId_exemplo_no_FormatoJson()}, function(data) {
			      
				  obj = JSON.parse(data);
			      $("#lista_de_exemplos").html("");

 		          //inserindo a tabela na div #ajax4			      
			      $("#lista_de_exemplos").html(Tabela_Exemplos(html_text));
			      $("#carregando3").hide();

			      // tirar a tela de opacidade de fundo do modal
			      $(".modal-backdrop").css('position','inherit'); 
			      $("#btncancelarmodal2").click();
			      
			   });
			}
			
			
			
			// CRIAÇÃO DA TABELA DE EXEMPLOS COM O RETORNO DO AJAX SEM OS BOTÕES DE ALTERAR E EXCLUIR
			function Tabela_Exemplos_Ajax(html_text,mostra_btnalt_btnexc){
			   html_text = html_text+ "<table class=\"table table-hover\">" +
			                          " <tr>"+
							          " <th class=\"info\">Status</th>"+
							          " <th class=\"info\">Código</th>"+
							          " <th class=\"info\">Data</th>"+
							          " <th class=\"info\">Nome</th>"+
							          " <th class=\"info\">Descrição</th>"+
							          " <th class=\"info\">Tamanho</th>"+
							          " <th class=\"info\">Tipo</th>";
						  
			   for(var i=0;i < obj.length;i++){
				   html_text = html_text +
				   ' <tr>'+
				   ' <td'+ (obj[i].status? ' class=\"success\" ': '  class=\"danger\" ')+'>'+(obj[i].status? 'Ativo': 'Inativo')+'</td>'+      
				   ' <td>'+obj[i].id_exemplo+'</td>'+
				   ' <td>'+(obj[i].dat_cad != undefined?obj[i].dat_cad.dayOfMonth:'__')+'/'+
					       (obj[i].dat_cad != undefined?obj[i].dat_cad.month:'__')+'/'+
					       (obj[i].dat_cad != undefined?obj[i].dat_cad.year:'__')+'</td>'+
				   ' <td>'+obj[i].nome+'</td>'+
				   ' <td>'+obj[i].descricao+'</td>'+
				   ' <td>'+obj[i].tamanhos+'</td>'+
				   ' <td>'+obj[i].tipo+'</td>'+
				   ' <td>';
				}
							
				html_text+'</td></tr></table>';
				return html_text;
			}


			// CRIAÇÃO DA TABELA DE EXEMPLOS COM O RETORNO DO AJAX COM OS BOTÕES DE ALTERAR E EXCLUIR			
			function Tabela_Exemplos(html_text,mostra_btnalt_btnexc){
				   html_text = html_text +

				       // Link para Marcar os checkbox
	                   "<span style=\"padding-right:15px;\">" +
	                      "<img src=\"resources/img/check_icon.png\" style=\"padding-right:10px;\">" +
	                      "<a id=\"label_check\" href=\"#\" onclick=\"javascript:marcar_e_desmarcarTodosOsCheckbox();\" role=\"button\">Marcar todos</a>" +
	                   "</span>"+
	                   
	                   // Link para Excluir todos os checkbox marcados pelo usuario
	                   "<span>" +
	                   "  <img src=\"resources/img/del_icon.png\" style=\"padding-right:10px;\">" +
	                   "  <a href=\"#myModal_exclusaoLista\" data-toggle=\"modal\" role=\"button\">Excluir itens selecionados</a>" +
	                   "</span>"+
	                   
	                   " <br><br>" +
	                   " <table class=\"table table-hover\">" +
	                   " <tr>"+
	                   " <th class=\"info\"></th>"+
			           " <th class=\"info\">Status</th>"+
			           " <th class=\"info\">Código</th>"+
			           " <th class=\"info\">Data</th>"+
			           " <th class=\"info\">Nome</th>"+
			           " <th class=\"info\">Descrição</th>"+
			           " <th class=\"info\">Tamanho</th>"+
			           " <th class=\"info\">Tipo</th>"+
 		               " <th class=\"info\">Ação</th></tr>";
							  
				  for(var i=0;i < obj.length;i++){
					   html_text = html_text +
					   ' <tr>'+
					   ' <td><input type="checkbox" value="'+obj[i].id_exemplo+'" id="check'+obj[i].id_exemplo+'/"><br /></td>'+ 
					   ' <td' + (obj[i].status? ' class=\"success\" ': '  class=\"danger\" ')+'>'+(obj[i].status? 'Ativo': 'Inativo')+'</td>'+      
					   ' <td>'+obj[i].id_exemplo+'</td>'+
					   ' <td>'+(obj[i].dat_cad != undefined?obj[i].dat_cad.dayOfMonth:'__')+'/'+
						       (obj[i].dat_cad != undefined?obj[i].dat_cad.month:'__')+'/'+
						       (obj[i].dat_cad != undefined?obj[i].dat_cad.year:'__')+'</td>'+
					   ' <td>'+obj[i].nome+'</td>'+
					   ' <td>'+obj[i].descricao+'</td>'+
					   ' <td>'+obj[i].tamanhos+'</td>'+
					   ' <td>'+obj[i].tipo+'</td>'+
					   ' <td>'+
						
					   // Botão de alterar
					   ' <a href=\"mostraExemplos?id='+obj[i].id_exemplo+
					   ' \" title=\"Alterar\" class=\"btn btn-small btn-primary\" role=\"button\" class=\"btn\">'+
					   ' <i class=\"fa fa-edit\"></i></a> '+
								
					   // Botão de excluir
					   ' <a href=\"#myModal\"	id=\"'+obj[i].id_exemplo+'\" name=\"'+
					     obj[i].id_exemplo+'\" onclick=\"atualizarHiddenASerExcluido('+obj[i].id_exemplo+');\"'+
					   ' class=\"btn btn-small btn-danger\" role=\"button\" class=\"btn\"'+
					   ' data-toggle=\"modal\" title=\"Excluir\">'+ 
					   ' <i class=\"fa fa-share-square-o\"></i></a>';
				  }
					html_text+'</td></tr></table>';
					return html_text;
			}

			
			// MARCAR TODOS OS CHECKBOX
			var flag = true;
			function marcar_e_desmarcarTodosOsCheckbox(){
				  var inputs, i;
				  
				  // pegar todas as tagName input para varrer todos que tiverem o tipo checkbox
				  inputs = document.getElementsByTagName('input');
				  
				  if(flag){
					  for(i=0;i<inputs.length;i++){
						// vão ser marcados somente os check que iniciam com id = check, ou seja, se caso outro check estiver com outro id não será marcado  
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
			function retornaListadeId_exemplo_no_FormatoJson(){
				  var inputs, i, valor="";

				  // pegar todas as tagName input para varrer todos que tiverem o tipo checkbox
				  inputs = document.getElementsByTagName('input');
				  
				  valor = "{\"exemplo\":[";
				  for(i=0;i<inputs.length;i++){
				    // vão ser marcados somente os check que iniciam com id = check, ou seja, se caso outro check estiver com outro id não será marcado
				    if((inputs[i].type=='checkbox') && ((inputs[i].id).substring(0, 5) == 'check')){
				      if(inputs[i].checked==true){
				        valor+="{\id_exemplo\:"+inputs[i].value+"},";
				      }
				    }
				  }
				  
				  // Retirar o ultimo caracter da string , ou seja , a virgula
				  valor = valor.substring(0,(valor.length - 1));

				  valor+="]}";
				  return valor;
			}
			
			
			// ATUALIZA O VALOR DO INPUT COM HIDDEN NA TELA
			function atualizarHiddenASerExcluido(valor) {
			  $('#ASerExcluido').val(valor);
			}

	        // Tempo de espera da mensagem na tela
            $(function() {
	            var tempo = 5;
	            var rotina_de_tempo = setInterval(function() {
	              tempo--;
                  if (tempo == 0) {
	                $('#seconds').text("");
	                clearInterval(rotina_de_tempo);
	              }
	            }, 500);
	        });  

