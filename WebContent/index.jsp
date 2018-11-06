<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link  rel="stylesheet" href="resources/css/grid.css">
<link  rel="stylesheet" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tela de Login</title>
</head>
<body>

	<header class="menu">
		<h2> Sistema de Cadastro</h2>
	</header>
	
	<div class="container login">
		
		 <div class="login-form">
		 	<h1>Login</h1>
			<form action="loginServlet" method="post">
				
				Login: <input type="text" name="login" />
				Senha: <input type="password" name="pass"/>
				<button type="submit">Logar</button>		
			</form>
		</div>
	</div>
	<footer>
		<p>Esse é um projeto crud
        &copy Paulo Cavalcante
	</footer>
</body>
</html>