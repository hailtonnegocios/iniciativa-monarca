/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function ReturnContato() {
    alert("Mensagem enviada com sucesso!");
    document.getElementById('nome').value = 'Nome';
    document.getElementById('email').value = 'Email';
    document.getElementById('telefone').value = 'Telefone';
    document.getElementById('cidade').value = 'Cidade e Estado';
    document.getElementById('mensagem').value = 'Mensagem';
}
   
    
   
jQuery(document).ready(function(){
    jQuery('#ajax_form').submit(function(){
        var dados = jQuery( this ).serialize();

        jQuery.ajax({
                type: "POST",
                url: "contato.php",
                data: dados,
                success: function( data ){
                        //alert( data );
                        ReturnContato();
                }
        });
        return false;
    });
});
	

