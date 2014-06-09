<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="collapse navbar-collapse navbar-ex1-collapse">

    <!--  Menu Lateral -->
	<ul class="nav navbar-nav side-nav">
	<li class="active"><a href="eflog"><i class="fa fa-tasks"></i> Menu</a></li>
	
    <c:forEach items="${listamenu}" var="listamenu">
      <li ><a href="${listamenu.referencia}"><i class="fa fa-edit"></i>${listamenu.nome}</a></li> 
    </c:forEach>	

	</ul>

    <!-- Menu Topo -->
	<ul class="nav navbar-nav navbar-right navbar-user">
		<li class="dropdown user-dropdown"><a href="#"
			class="dropdown-toggle" data-toggle="dropdown"><i
				class="fa fa-user"></i> ${usuarioLog} <b class="caret"></b></a>
			<ul class="dropdown-menu">
				<li><a href="#"><i class="fa fa-gear"></i> Settings</a></li>
				<li class="divider"></li>
				<li><a href="logout"><i class="fa fa-power-off"></i> Log Out</a></li>
			</ul></li>
	</ul>
</div>

</nav><!-- fim SideBar -->