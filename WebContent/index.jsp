<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/index.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tela de Login</title>
</head>
<body>

	<header class="menu">
	<h2>Sistema de Cadastro</h2>
	</header>

	<div class="box-login">
		<form action="loginServlet" method="post">
			<fieldset>
				<legend>Bem vindo</legend>
				<input type="text" name="login" placeholder="login" />
				<input type="password" name="pass" placeholder="senha" />
			</fieldset>
			<button type="submit">Acessar</button>
		</form>
	</div>

</body>
</html>