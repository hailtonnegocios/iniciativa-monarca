
		  //  Iniciar nos anos de 1990          
 		  // var d = new Date(90,0,1);

          // Deixar o datepicker em portugues
          $(".data").datepicker({
           // defaultDate:d,
		      changeMonth: true,
		      changeYear: true,
		      todayHighlight: true,
              yearRange: '1930:2050',
              dateFormat: 'dd/mm/yy',
  		      dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
		      dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
		      dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
		      monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
		      monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
	      });


          // Mascara no campo
          $(".data").mask("99/99/9999");


         /*
		  *  Lista de efeitos com o datepicker 1 -show 2 -slideDown 3 -fadeIn
		  *  4 -blind 5 -bounce 6 -clip 7 -drop 8 -fold 9 -slide
		  */

          // exemplo de efeito show no datepicker, caso queira outro é só
		  // substituir o ultimo parametro
          // com o nome do efeito
          $(".data").datepicker("option", "showAnim", 'show');

          // Delay ao abrir a div
		  // $("#carregando").delay(200).show(0);
		  // Delay ao fechar a div
		  // $("#carregando").delay(200).hide(0);
          
          
		    // Ao clicar no botão será mandado uma requisição via ajax ao controller requisitando o método funcajax1
			$("#ajax1").hide();
			$("#btnTeste1").click(function() {
				$.post("funcAjax1", {}, function(resposta) {
						$("#ajax1").html('Retorno: '+resposta);
				});
				$("#ajax1").toggle("up");
			});
		
	  	    // Ao clicar no botão será mandado uma requisição via ajax ao controller requisitando o método funcajax2
			$("#ajax2").hide();
			$("#carregando").hide();
			$("#btnTeste2").click(function() {
				$("#carregando").show();
				$.post("funcAjax2", {}, function(data) {
				  var obj = JSON.parse(data);
				  $("#ajax2").html('Retorno: <br><br>'+
							'ID: '+obj.id_exemplo+'<br>'+
							'NOME: '+obj.nome+'<br>'+
							'DESCRIÇÃO: '+obj.descricao+'<br>'+
							'STATUS: '+obj.status+'<br>'+
							'TIPO: '+obj.tipo);
				  $("#carregando").hide();
			    });
			    $("#ajax2").toggle("up");
			});
		
	
			
	  	    // Ao clicar no botão será mandado uma requisição via ajax ao controller requisitando o método funcajax3
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
			
			
		// Ao clicar no botão será mandado uma requisição via ajax ao controller requisitando o método funcajax4
		$("#ajax4").hide();
		$("#tabela_pesquisar").hide();
		$("#carregando3").hide();
	    
		$("#btnTeste4").click(function() {
		      $("#tabela_pesquisar").toggle("up");
		      $("#ajax4").hide();
        });
			
		$("#btn_pesq").click(function() {
			$("#carregando3").show();
			   $.post("funcAjax4", {}, function(data) {
			       var html_text = "";
			       obj = JSON.parse(data);
			       $("#ajax4").html("");
			       $("#ajax4").html(Tabela_Exemplos(html_text));
			       $("#carregando3").hide();
		       });
	        $("#ajax4").toggle("slide");
		});
				
		
		// Ao clicar no botao do modal ,executará essa rotina para excluir o exemplo
		function excluirComModal() {
		   $("#ajax2").val("");
		   var html_text = "";
		   $.post("deletaExemplosAjax", {id : $('#ASerExcluido').val()}, function(data) {
		      obj = JSON.parse(data);
		      $("#ajax4").html("");
		      $("#ajax4").html(Tabela_Exemplos(html_text));
		      $("#carregando3").hide();
			  // tirar a tela de opacidade de fundo do modal
		      $(".modal-backdrop").css('position','inherit'); 
		      $("#btncancelar").click();
		   });
		}
				
		function Tabela_Exemplos(html_text){
		   html_text = html_text+ "<table class=\"table table-hover\">" +
		                          " <tr>"+
						          " <td class=\"info\">Status</td>"+
						          " <td class=\"info\">ID</td>"+
						          " <td class=\"info\">DATA</td>"+
						          " <td class=\"info\">NOME</td>"+
						          " <td class=\"info\">DESCRIÇÃO</td>"+
						          " <td class=\"info\">TAMANHO</td>"+
						          " <td class=\"info\">TIPO</td>"+
					              " <td class=\"info\">ACAO</td></tr>";
					  
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
			   ' <td>'+
						
			   ' <a href=\"mostraExemplos?id='+obj[i].id_exemplo+
			   ' \" title=\"Alterar\" class=\"btn btn-small btn-primary\" role=\"button\" class=\"btn\">'+
			   ' <i class=\"fa fa-edit\"></i></a> '+
						
			   ' <a href=\"#myModal\"	id=\"'+obj[i].id_exemplo+'\" name=\"'+
			   obj[i].id_exemplo+'\" onclick=\"atualizarHiddenASerExcluido('+obj[i].id_exemplo+');\"'+
			   ' class=\"btn btn-small btn-danger\" role=\"button\" class=\"btn\"'+
			   ' data-toggle=\"modal\" title=\"Excluir\">'+ 
			   ' <i class=\"fa fa-share-square-o\"></i></a>';
			}
						
			html_text+'</td></tr></table>';
			return html_text;
		}
				
		function atualizarHiddenASerExcluido(valor) {
		  $('#ASerExcluido').val(valor);
		}
		
