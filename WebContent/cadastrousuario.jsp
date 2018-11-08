<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuários</title>
</head>
<body>
	<form action="cadastrarUsuario" method="post">
		Nome: <input type="text" name="nome" />
		Login : <input type="text" name="login" />
		Senha: <input type="password" name="senha" />

		<button type="submit">Enviar</button>
		<a href="cadastrarUsuario?acao=listar">Listar Usuários</a>
		
		<input type="text" name="buscarNome">
			<button type="submit">buscar</button>
		</input>
	</form>
	
		
	

	<hr>
	<table>
		<tr>
			<td>Id</td>
			<td>Nome</td>
			<td>Login</td>
		</tr>
		<c:forEach items="${usuarios }" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.login}</td>
				<td>
					<a href="cadastrarUsuario?acao=delete&user=${user.login}">Excluir</a>
				<td>
				<td>
					<a href="cadastrarUsuario?acao=editar&id=${user.id}">Editar
				</a>
				<td>
			</tr>
		</c:forEach>
	</table>
	
</body>
