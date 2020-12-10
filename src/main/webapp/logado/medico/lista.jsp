<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>

	<head>
<title><fmt:message key="page.title" /></title>
	</head>

	<body>
		<fmt:bundle basename="message">
		<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
		
		<div align="center">
			<h1>
				<fmt:message key="consultas.list"/>
			</h1>
			<h2>
				&nbsp;&nbsp;&nbsp; 
				<a href="${pageContext.request.contextPath}/logout.jsp"> 
					Logout
				</a>
			</h2>
			<br />
			<br />
		</div>

		<div align="center">
			<table border="1">
				<caption></caption>
				<tr>
					<th> ID </th>
					<th> <fmt:message key="paciente.welcome"/> </th>
					<th> <fmt:message key="consulta.data"/> </th>
				</tr>
				<c:forEach var="consulta" items="${listaConsultas}">
					<tr>
						<td>${consulta.getId()}</td>
						<td>${consulta.getPaciente()}</td>
						<td>${consulta.getDate()}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		</fmt:bundle>
	</body>

</html>