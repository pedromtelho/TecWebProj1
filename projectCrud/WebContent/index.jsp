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
<body>
	<div class="container login-container">
		<div class="row">
			<div class="col-md-6 login-form-1">
				<h3>Faça seu login</h3>
				<form action="Login" method="POST">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Your Email *"
							name="User" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control"
							placeholder="Your Password *" name="Senha" />
					</div>
					<h3>${name}</h3>
					<div class="form-group">
						<input type="submit" class="btnSubmit" value="Login" name="login" />
					</div>
				</form>
			</div>
			<div class="col-md-6 login-form-2">
				<form action="TelaInicial" method="POST">
					<h3>Faça seu cadastro</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Your Email *"
							name="User" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control"
							placeholder="Your Password *" name="Senha" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control"
							placeholder="Confirm Your Password *" name="ConfSenha" />
					</div>
					<h3>${senhaIncor}</h3>
					<h3>${senhaNull}</h3>
					<h3>${newUser}</h3>
					<div class="form-group">
						<input type="submit" class="btnSubmit" value="Cadastre-se"
							name="login" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>