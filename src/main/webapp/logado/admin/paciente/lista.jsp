<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">

	<head>
            <title> <fmt:message key="page.title"/></title>
	</head>

	<body>

		<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
		<div align="center">
			<h1>
				<fmt:message key="paciente.welcome"/>
			</h1>
			<h2>
				<a href="/<%=contextPath%>/admin/">Voltar</a>
				&nbsp;&nbsp;&nbsp; <a href="/<%=contextPath%>/admin/paciente/cadastro">
					<fmt:message key="paciente.create"/>
				</a>
			</h2>
		</div>
		<div align="center">
			<table border="1">
				<caption>
					<fmt:message key="listar.paciente"/>
				</caption>
				<tr>
					<th>ID</th>
					<th><fmt:message key="paciente.Nome"/></th>
					<th>E-mail</th>
					<th>CPF</th>
					<th><fmt:message key="paciente.tel"/></th>
					<th><fmt:message key="paciente.sexo"/></th>
					<th><fmt:message key="paciente.nascimento"/></th>
					<th><fmt:message key="table.change"/></th>
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
