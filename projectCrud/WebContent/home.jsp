<%@page import="br.edu.insper.Model.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Treller</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
	<div>
		<form action="Trello" method="POST">
			<div class="form-group">
				<input type="text" class="form-control"
					placeholder="Digite o nome da sua tarefa" name="nomeTarefa" />
			</div>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Descrição"
					name="descTarefa" />
			</div>
			<div class="form-group">
				<input type="submit" class="btnSubmit" value="Gravar" name="login" />
			</div>
		</form>
	</div>

	<div class="table-responsive">
		<table class="table table-striped table-dark">
			<thead>

				<tr>
					<th scope="col">Task</th>
					<th scope="col">Descrição</th>
					<th scope="col">Data de criação</th>
				</tr>
			</thead>
			<%
				try {
					List<ShowTarefas> tarefas = (List<ShowTarefas>) request.getAttribute("dados");
					for (ShowTarefas tarefa : tarefas) {
			%>
			<tbody>
				<tr>
					<td><%=tarefa.getNome()%></td>
					<td><%=tarefa.getTarefa()%></td>
					<td><%=tarefa.getData()%></td>
					<td>
						<form method="POST" action="Delete">
							<input type="hidden" name="user" value="<%=user%>"> <input
								type="hidden" name="id" value="<%=tarefa.getId()%>"> <input
								type="submit" class="btnSubmit" value="Deletar" />
						</form>
					</td>
					<td>
						<form method="GET" action="Update">
							<input type="hidden" name="user" value="<%=user%>"> <input
								type="hidden" name="id" value="<%=tarefa.getId()%>"> <input
								type="submit" class="btnSubmit" value="Editar" />
						</form>
					</td>
				</tr>
			</tbody>
			<%
				}
				} catch (NullPointerException e) {
					;
				}
			%>
		</table>
	</div>
</body>
</html>
