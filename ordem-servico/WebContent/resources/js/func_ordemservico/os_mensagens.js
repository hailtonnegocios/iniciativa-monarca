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
