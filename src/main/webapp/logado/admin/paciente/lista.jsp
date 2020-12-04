<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">

	<head>
            <title>Lista Pacientes</title>
	</head>

	<body>

		<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
		<div align="center">
			<h1>
				Pacientes
			</h1>
			<h2>
				<a href="/<%=contextPath%>/admin/">Voltar</a>
				&nbsp;&nbsp;&nbsp; <a href="/<%=contextPath%>/admin/paciente/cadastro">
					Novo Paciente
				</a>
			</h2>
		</div>
		<div align="center">
			<table border="1">
				<caption>
					Lista de Pacientes
				</caption>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Email</th>
					<th>CPF</th>
					<th>Telefone</th>
					<th>Sexo</th>
					<th>Data Nascimento</th>
					<th>Alterar</th>
					</tr>
				<c:forEach var="paciente" items="${requestScope.listaPaciente}">
					<tr>
						<td>${paciente.getId()}</td>
						<td>${paciente.getNome()}</td>
						<td>${paciente.getEmail()}</td>
						<td>${paciente.getCPF()}</td>
						<td>${paciente.getTelefone()}</td>
						<td>${paciente.getSexo()}</td>
						<td>${paciente.getDataNascimento()}</td>
						<td><a href="/<%= contextPath%>/admin/paciente/edicao?id=${paciente.getId()}">
								Editar
						</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/<%= contextPath%>/admin/paciente/remocao?id=${paciente.getId()}"
							onclick="return confirm('<fmt:message key="confirm.link" />');">
								Remover
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</body>
</fmt:bundle>

</html>
