<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7]><html class="no-js lt-ie10 lt-ie9 lt-ie8 lt-ie7" lang="pt-BR"> <![endif]-->
<!--[if IE 7]><html class="no-js lt-ie10 lt-ie9 lt-ie8" lang="pt-BR"> <![endif]-->
<!--[if IE 8]><html class="no-js lt-ie10 lt-ie9" lang="pt-BR"> <![endif]-->
<!--[if IE 9]><html class="no-js lt-ie10" lang="pt-BR"> <![endif]-->
<!--[if gt IE 8]><!--><html class="no-js" lang="pt-BR"><!--<![endif]-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title><fmt:message key="sistema.titulo" /></title>
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/font-awesome/css/font-awesome.css" rel="stylesheet">
	<link href="resources/css/sb-admin.css" rel="stylesheet">
	<link href="resources/css/jquery-ui-1.10.4.css" rel="stylesheet">
	<link rel="shortcut icon" href="resources/img/favicon.ico">
	<!-- <script src="resources/js/plugin_modal.js"></script>-->

	
</head>
<body>

<!-- Parte do trecho alterada no bootstrap.min.css -->
<!-- <style type="text/css">

.col-lg-3 {
  width: 27%;
}

</style>
-->
    <div id="wrapper">
      <!-- Inicio SideBar : 
           O sidebar esta vinculado ao menu na lateral e o menu superior, 
           deixei a parte do logo no cabecalho para separar um pouco dos menus 
      -->
      
      <!-- Inicio SideBar -->
      <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
       
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="efetuaLogin">ORDEM DE SERVIÇO</a>
        </div>