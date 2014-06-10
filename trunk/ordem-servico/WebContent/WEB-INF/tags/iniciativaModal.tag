<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="idAserExcluido" required="true"%>
<%@ attribute name="metodoNaController" required="true"%>
<%@ attribute name="nomeDoObjetoASerExcluido" required="true"%>


<a href="#myModal${idAserExcluido}"	id="${idAserExcluido}" name="${idAserExcluido}" onclick="atualizarHiddenExemploASerExcluido${idAserExcluido}(${idAserExcluido});"
	class="btn btn-small btn-danger" role="button" class="btn"	data-toggle="modal" title="Excluir"> 
	<i class="fa fa-share-square-o"></i>
</a>

<input type="hidden" id="exemploASerExcluido${idAserExcluido}">

<div class="modal fade" id="myModal${idAserExcluido}" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h3>Atenção!</h3>
			</div>
			<div class="modal-body">
				<p>Tem certeza que deseja excluir este ${nomeDoObjetoASerExcluido}?</p>
			</div>
			<div class="modal-footer">
				<a id="linkExclusao${idAserExcluido}" class="btn btn-danger" onclick="excluirExemplo${idAserExcluido}();">Excluir</a>
				<button class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
     function atualizarHiddenExemploASerExcluido${idAserExcluido}(valor1) {
	   $('#exemploASerExcluido${idAserExcluido}').val(valor1);
     }

     function excluirExemplo${idAserExcluido}() {
        $("#linkExclusao${idAserExcluido}").attr('href','${metodoNaController}?id='+$('#exemploASerExcluido${idAserExcluido}').val());
        $("#linkExclusao${idAserExcluido}").click();
     }
</script>
