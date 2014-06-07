<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
          <a class="navbar-brand" href="eflog">INICIATIVA MONARCA</a>
        </div>