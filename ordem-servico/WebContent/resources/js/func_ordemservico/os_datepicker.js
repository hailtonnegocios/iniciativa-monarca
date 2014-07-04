//  ---------------------------  FUNÇÕES RELACIONADAS AO COMPONENTE DATEPICKER DO JQUERY --------------------------------


		  //  INICIAR A DATA DO DATE PICKER SETADO COM O ANO EM 1990          

          // var d = new Date(90,0,1);

          // DEIXAR O DATEPICKER EM PORTUGUES
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


          // MASCARA NO CAMPO DE DATA
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
