
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
			 * Lista de efeitos com o datepicker 1 -show 2 -slideDown 3 -fadeIn
			 * 4 -blind 5 -bounce 6 -clip 7 -drop 8 -fold 9 -slide
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
		
		
		
  	    // Ao clicar no botão será mandado uma requisição via ajax ao controller requisitando o método funcajax3
		$("#ajax4").hide();
		$("#carregando3").hide();
		$("#btnTeste4").click(function() {
			$("#carregando3").show();
			$.post("funcAjax4", {}, function(data) {
				//alert(data);
			  var html_text = "";
			  obj = JSON.parse(data);
			  $("#ajax4").html("");
			  html_text = "<input class=\"form-control\" type=\"text\"  /><br>" +
			  		      "<button class=\"btn btn-danger\">Pesquisar</button><br><br>";
			  
			  html_text = html_text+ "<table class=\"table table-hover\"><tr>"+
			                     "<td class=\"info\">Status</td>"+
			                     "<td class=\"info\">ID</td>"+
			                     "<td class=\"info\">DATA</td>"+
			                     "<td class=\"info\">NOME</td>"+
			                     "<td class=\"info\">DESCRIÇÃO</td>"+
			                     "<td class=\"info\">TAMANHO</td>"+
			                     "<td class=\"info\">TIPO</td>"+
			                     "<td class=\"info\">ACAO</td></tr>";
			  
			     
			  for(var i=0;i < obj.length;i++){
			     html_text = html_text +
			     
  		         '<tr>'+
				     '<td'+ (obj[i].status? ' class=\"success\" ': '  class=\"danger\" ')+'>'+(obj[i].status? 'Ativo': 'Inativo')+'</td>'+      
					 '<td>'+obj[i].id_exemplo+'</td>'+
					 '<td>'+obj[i].dat_cad.dayOfMonth+'/'+obj[i].dat_cad.month+'/'+obj[i].dat_cad.year+'</td>'+
					 '<td>'+obj[i].nome+'</td>'+
					 '<td>'+obj[i].descricao+'</td>'+
					 '<td>'+obj[i].tamanhos+'</td>'+
					 '<td>'+obj[i].tipo+'</td>'+
					 '<td>'+
					     '<a href=\"mostraExemplos?id='+obj[i].id_exemplo+
					     '\" title=\"Alterar\" class=\"btn btn-small btn-primary\" role=\"button\" class=\"btn\">'+
					     ' <i class=\"fa fa-edit\"></i></a> '+

 
		                 '<a href=\"#myModal'+obj[i].id_exemplo+'\"	id=\"'+obj[i].id_exemplo+'\" name=\"'+
		                 obj[i].id_exemplo+'\" onclick=\"atualizarHiddenExemploASerExcluido'+
		                 obj[i].id_exemplo+'('+obj[i].id_exemplo+');\"'+
	             		 'class=\"btn btn-small btn-danger\" role=\"button\" class=\"btn\"'+
	             		 '	data-toggle=\"modal\" title=\"Excluir\">'+ 
	             		 '<i class=\"fa fa-share-square-o\"></i></a>'+
             		
             		     '<input type=\"hidden\" id=\"exemploASerExcluido'+obj[i].id_exemplo+'\">'+
   
             		
	             		    '<div class=\"modal fade\" id=\"myModal'+obj[i].id_exemplo+'\" tabindex=\"-1\" role=\"dialog\"'+
	             			'aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">'+
	             			'<div class=\"modal-dialog\">'+
	             				'<div class=\"modal-content\">'+
	             					'<div class=\"modal-header\">'+
	             						'<button type=\"button\" class=\"close\" data-dismiss=\"modal\"'+
	             							'aria-hidden=\"true\">&times;</button>'+
	             						'<h3>Atenção!</h3>'+
	             					'</div>'+
	             					'<div class=\"modal-body\">'+
	             						'<p>Tem certeza que deseja excluir este Exemplo?</p>'+
	             					'</div>'+
	             					'<div class=\"modal-footer\">'+
	             						'<a id=\"linkExclusao'+obj[i].id_exemplo+'\" class=\"btn btn-danger\" onclick=\"excluirExemplo'+obj[i].id_exemplo+'();\">Excluir</a>'+
	             						'<button class=\"btn\" data-dismiss=\"modal\" aria-hidden=\"true\">Cancelar</button>'+
	             					'</div>'+
	             				'</div>'+
	             			'</div>'+
	             		'</div>'+
	                 
	             
	             		
	   			     '<script type="text/javascript">'+
				     
	          	    ' function atualizarHiddenExemploASerExcluido'+obj[i].id_exemplo+'(valor1) {'+
	          		  ' $(\"#exemploASerExcluido'+obj[i].id_exemplo+'\").val(valor1);'+
	          	     '}'+

	          	     'function excluirExemplo'+obj[i].id_exemplo+'() {'+
	          	        '$(\"#linkExclusao'+obj[i].id_exemplo+'\").attr(\"href\",\"deletaExemplosAjax?id=\"+$(\"#exemploASerExcluido'+obj[i].id_exemplo+'\").val());'+
	          	        '$(\"#linkExclusao'+obj[i].id_exemplo+'\").click();'+
	          	        
	          	     '}'+
	              		
	 			     '</script>'+

	             		
	             		
					     '</td></tr>';
			     
			     
			     
			     
				 
			  }
			  $("#ajax4").html(html_text+"</table>");
			  $("#carregando3").hide();
		    });
		    $("#ajax4").toggle("up");
		});

		
		
		



		
	/*
	 * 
	 * $("#minhaDiv").hide(); $("#btnTeste").click(function(){ //Sem parâmetros: o
	 * efeito é executado em 400ms $("#minhaDiv").fadeIn(); //Parâmetro com a
	 * duração em ms do efeito $("#minhaDiv").fadeIn(1000); //Parâmetro slow: o
	 * efeito é executado em 600ms $("#minhaDiv").fadeIn("slow"); //Parâmetro fast:
	 * o efeito é executado em 200ms $("#minhaDiv").fadeIn("fast"); //Informada
	 * duração e função de callback $("#minhaDiv").fadeIn("fast", function(){
	 * alert("fade concluido"); } ); });
	 * 
	 * 
	 * 
	 * $("#btnTeste").click(function(){ //Sem parâmetros: o efeito é executado em
	 * 400ms $("#minhaDiv").fadeOut(); //Parâmetro com a duração em ms do efeito
	 * $("#minhaDiv").fadeOut(1000); //Parâmetro slow: o efeito é executado em 600ms
	 * $("#minhaDiv").fadeOut("slow"); //Parâmetro fast: o efeito é executado em
	 * 200ms $("#minhaDiv").fadeOut("fast"); //Informada duração e função de
	 * callback $("#minhaDiv").fadeOut("fast", function(){ alert("fade concluido"); } );
	 * });
	 * 
	 * 
	 * 
	 * $("#btnTeste").click(function(){ //Informada a duração do efeito e o valor da
	 * opacidade $("#minhaDiv").fadeTo("slow", 0.5); //Informada adicionalmente a
	 * função callback $("#minhaDiv").fadeTo("slow", 0.5, function(){ alert("Fade
	 * concluido"); } ); });
	 * 
	 * 
	 * 
	 * 
	 * $("#btnTeste").click(function(){ //Sem parâmetros: o efeito é executado em
	 * 400ms $("#minhaDiv").fadeToggle("slow"); //Informada a função callback
	 * $("#minhaDiv").fadeToggle("slow", function(){ alert("Fade concluido"); } );
	 * });
	 * 
	 * 
	 * 
	 * 
	 * $("#btnTeste").click(function(){ //Sem parâmetros: o efeito é executado em
	 * 400ms $("#minhaDiv").slideUp(); //Parâmetro com a duração em ms do efeito
	 * $("#minhaDiv").slideUp(1000); //Parâmetro slow: o efeito é executado em 600ms
	 * $("#minhaDiv").slideUp("slow"); //Parâmetro fast: o efeito é executado em
	 * 200ms $("#minhaDiv").slideUp("fast"); //Informada duração e função de
	 * callback $("#minhaDiv").slideUp("fast", function(){ alert("Slide concluido"); } );
	 * });
	 * 
	 * 
	 * 
	 * $("#minhaDiv").hide(); $("#btnTeste").click(function(){ //Sem parâmetros: o
	 * efeito é executado em 400ms $("#minhaDiv").slideDown(); //Parâmetro com a
	 * duração em ms do efeito $("#minhaDiv").slideDown(1000); //Parâmetro slow: o
	 * efeito é executado em 600ms $("#minhaDiv").slideDown("slow"); //Parâmetro
	 * fast: o efeito é executado em 200ms $("#minhaDiv").slideDown("fast");
	 * //Informada duração e função de callback $("#minhaDiv").slideDown("fast",
	 * function(){ alert("Slide concluido"); } ); });
	 * 
	 * 
	 * 
	 * $("#btnTeste").click(function(){ //Sem parâmetros: o efeito é executado em
	 * 400ms $("#minhaDiv").slideToggle(); //Parâmetro com a duração em ms do efeito
	 * $("#minhaDiv").slideToggle(1000); //Parâmetro slow: o efeito é executado em
	 * 600ms $("#minhaDiv").slideToggle("slow"); //Parâmetro fast: o efeito é
	 * executado em 200ms $("#minhaDiv").slideToggle("fast"); //Informada duração e
	 * função de callback $("#minhaDiv").slideToggle("fast", function(){
	 * alert("Slide concluido"); } ); });
	 * 
	 * 
	 */