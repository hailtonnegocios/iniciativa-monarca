
</div><!-- fim wrapper -->


		<!-- JavaScript -->
		<script src="resources/js/jquery-1.10.2.js"></script>
		<script src="resources/js/jquery-ui-1.10.4.js"></script>
		<script src="resources/js/bootstrap.js"></script>
		
		<!-- Page Specific Plugins -->
		<script
			src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
		<script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
		<script src="resources/js/morris/chart-data-morris.js"></script>
		<script src="resources/js/tablesorter/jquery.tablesorter.js"></script>
		<script src="resources/js/tablesorter/tables.js"></script>
		<script src="resources/js/maskjquery.js" type="text/javascript"></script>

		<script>
		
          // Mascara no campo
          $("#dat_cad").mask("99/99/9999");

          // Deixar o datepicker em portugues
          $("#dat_cad").datepicker({
		    dateFormat: 'dd/mm/yy',
		    dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
		    dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
		    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
		    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
		    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
		    nextText: 'Próximo',
		    prevText: 'Anterior'
		});

          /*
	          Lista de efeitos com o datepicker
	          1 -show
	          2 -slideDown
	          3 -fadeIn
	          4 -blind
	          5 -bounce
	          6 -clip
	          7 -drop
	          8 -fold
	          9 -slide
	      */

          // exemplo de efeito show no datepicker, caso queira outro é só substituir o ultimo parametro
          // com o nome do efeito
          $("#dat_cad").datepicker("option", "showAnim", 'show');

          
        </script>
		
</body>
</html>