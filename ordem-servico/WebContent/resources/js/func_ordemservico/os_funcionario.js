
         
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

			    });
			    
			    
          }

      	
