<%@page import="br.edu.insper.Model.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="./style.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<meta charset="UTF-8">
<title>Treller</title>
</head>
<body>
	<%!Cadastros user;%>
	<%
		user = (Cadastros) request.getAttribute("user");
	%>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="#">Treller</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
	</nav>
	<%
		try {
			List<ShowTarefas> tarefas = (List<ShowTarefas>) request.getAttribute("tarefas");
			for (ShowTarefas tarefa : tarefas) {
	%>

	<form method="POST" action="Update">
		<div class="form-row">
			<div class="col">
				<input name="nome" type="text" class="form-control"
					placeholder="nome" value="<%=tarefa.getNome()%>">
			</div>
			<div class="col">
				<input type="text" class="form-control" placeholder="descrição"
					name="desc" value="<%=tarefa.getTarefa()%>">
			</div>
			<div class="col">
				<input type="hidden" value="<%=tarefa.getId()%>" name="id"/>
				<input type="submit" class="btnSubmit" value="Editar" />
			</div>
		</div>
	</form>
	<%
			}
		} catch (NullPointerException e) {
			;
		}
	%>

</body>
</html>