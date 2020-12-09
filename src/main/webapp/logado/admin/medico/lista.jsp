<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">

	<head>
            <title> <fmt:message key="table.titlem"/></title>
	</head>

	<body>

		<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
		<div align="center">
			<h1>
				<fmt:message key="CRUD.medico"/>
			</h1>
			<h2>
				<a href="/<%=contextPath%>/admin/">Voltar</a>
				&nbsp;&nbsp;&nbsp; <a href="/<%=contextPath%>/admin/medico/cadastro">
					<fmt:message key="medico.novo"/>
				</a>
			</h2>
		</div>
		<div align="center">
			<table border="1">
				<caption>
					<fmt:message key="table.titlem"/>
				</caption>
				<tr>
					<th>ID</th>
					<th> <fmt:message key="medico.Nome"/></th>
					<th> <fmt:message key="medico.email"/></th>
					<th>CRM</th>
					<th> <fmt:message key="medico.tel"/></th>
					<th> <fmt:message key="medico.esp"/></th>
					<th> <fmt:message key="table.change"/></th>
					</tr>
				<c:forEach var="medico" items="${requestScope.listaMedicos}">
					<tr>
						<td>${medico.getId()}</td>
						<td>${medico.getNome()}</td>
						<td>${medico.getEmail()}</td>
						<td>${medico.getCRM()}</td>
						<td>${medico.getTelefone()}</td>
						<td>${medico.getEspecialidade()}</td>
						<td><a href="/<%= contextPath%>/admin/medico/edicao?id=${medico.getId()}">
								Editar
						</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/<%= contextPath%>/admin/medico/remocao?id=${medico.getId()}"
							onclick="return confirm('<fmt:message key="confirm.link"/>');">
								Remover
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</body>
</fmt:bundle>

</html>
