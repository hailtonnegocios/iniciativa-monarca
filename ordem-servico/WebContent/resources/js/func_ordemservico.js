		// Mascara no campo
		$("#dat_cad").mask("99/99/9999");
		
		// Deixar o datepicker em portugues
		$("#dat_cad").datepicker(
				{
					dateFormat : 'dd/mm/yy',
					dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta',
							'Sexta', 'Sábado' ],
					dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
					dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb',
							'Dom' ],
					monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio',
							'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro',
							'Novembro', 'Dezembro' ],
					monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun',
							'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
					nextText : 'Próximo',
					prevText : 'Anterior'
				});
		
		/*
		 * Lista de efeitos com o datepicker 
		 * 1 -show 
		 * 2 -slideDown 
		 * 3 -fadeIn 
		 * 4 -blind 
		 * 5 -bounce 
		 * 6 -clip 
		 * 7 -drop 
		 * 8 -fold 
		 * 9 -slide
		 * 
		 */
		
		
		// exemplo de efeito show no datepicker, caso queira outro é só substituir o
		// ultimo parametro com o nome do efeito
		
		$("#dat_cad").datepicker("option", "showAnim", 'show');
		
		// Delay ao abrir a div
		// $("#carregando").delay(200).show(0);
		// Delay ao fechar a div
		// $("#carregando").delay(200).hide(0);




	    // Ao clicar no botão será mandado uma requisição via ajax ao controller requisitando o método funcajax1
		$("#ajax1").hide();
		$("#btnTeste1").click(function() {
			$.post("funcajax1", {}, function(resposta) {
					$("#ajax1").html('Retorno: '+resposta);
			});
			$("#ajax1").toggle("up");
		});
	
  	    // Ao clicar no botão será mandado uma requisição via ajax ao controller requisitando o método funcajax2
		$("#ajax2").hide();
		$("#carregando").hide();
		$("#btnTeste2").click(function() {
			$("#carregando").show();
			$.post("funcajax2", {}, function(data) {
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
			$.post("funcajax3", {}, function(data) {
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
	
