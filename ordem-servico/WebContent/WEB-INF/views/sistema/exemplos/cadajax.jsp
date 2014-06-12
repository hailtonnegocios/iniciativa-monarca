<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ini" %>

<c:import url="../template/cabecalho.jsp" />
<c:import url="../template/sidebar.jsp" />

<!--  Inicio :  Conteudo das paginas -->
<div id="page-wrapper">

	<div class="alert alert-success alert-dismissable">
		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		Exemplos com Ajax
	</div>
    
    <button id="btnTeste1" class="btn btn-primary">Requisição feita com ajax ao RequestMapping("funcAjax1") - Retorno de uma String</button>
    <br><br>
    <div id="ajax1" class="alert alert-danger alert-dismissable" style="width:300px;hidth:100px;"></div>
    
    <button id="btnTeste2" class="btn btn-primary">Requisição feita com ajax ao RequestMapping("funcAjax2") - Retorno de uma Objeto</button>
    <br><br>
    <div id="carregando"><img  src="resources/img/carregando_2.gif"></div>
    <div id="ajax2" class="alert alert-danger alert-dismissable" style="height:190px;"></div>
    
    <div>
    <button id="btnTeste3" class="btn btn-primary">Requisição feita com ajax ao RequestMapping("funcAjax3") - Retorno de uma Lista</button>
    <br><br>
      <div id="carregando2"><img  src="resources/img/carregando_2.gif"></div>
      <div id="ajax3" class="alert alert-danger alert-dismissable"></div>
    </div>
    
    
    <div>
    <button id="btnTeste4" class="btn btn-primary">Requisição feita com ajax ao RequestMapping("funcAjax4") - Retorno de uma Lista com pesquisa</button>
    <br><br>
      <div id="carregando3"><img  src="resources/img/carregando_2.gif"></div>
      <div id="ajax4"></div>
    <br>
    </div>

</div>

</div>

<c:import url="../template/footer.jsp" />