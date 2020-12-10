<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:bundle basename="message">
<html>

	<head>
<title><fmt:message key="page.title" /></title>
	</head>

	<body>
		<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
		
		<div align="center">
			<h1>
				<fmt:message key="consultas.list"/>
			</h1>
			<h2>
				<a href="/<%=contextPath%>/paciente/agendar">
					Agendar Consulta
				</a>
			</h2>
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
					<th> <fmt:message key="medico"/> </th>
					<th> <fmt:message key="consulta.data"/> </th>
				</tr>
				<c:forEach var="consulta" items="${listaConsulta}">
					<tr>
						<td>${consulta.getId()}</td>
						<td>${consulta.getMedicoNome()}</td>
						<td>${consulta.getDate()}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		</fmt:bundle>
	</body>

</html>