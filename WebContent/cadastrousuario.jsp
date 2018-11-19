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
		ID: <input type="text" name="id" value="${user.id}" readonly="readonly"/>
		Nome: <input type="text" name="nome" value="${user.name}" />
		Login : <input type="text" name="login" value="${user.login}" />
		Senha: <input type="password" name="senha" value="" />

		<button type="submit">Enviar</button>
		<a href="cadastrarUsuario?acao=cancelar">cancelar</a>
		<a href="cadastrarUsuario?acao=listar">Listar Usuários</a>
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
