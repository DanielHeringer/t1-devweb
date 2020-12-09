<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Medicos</title>
<script src="js/ajaxMedico.js"></script>
</head>
<body>
	<br />
	<jsp:useBean id='bean' class='bean.ListaMedicosBean' />

	<form name='form'>
		<div align="center">
			<p>Lista de Medicos</p>
			<label for="medico">Especialidade</label> <input id="medico" name="medico"
				onkeyUp="getMedicos()">
			<div id="medicos">

				<p>Quantidade: ${fn:length(bean.medicos)}</p>
				<table border="1" style="width: 400px; border: 1px solid black">

					<tr>
						<th style="width: 70%;">Nome</th>
						<th style="width: 20%; text-align: center">Especialidade</th>
					</tr>
					<c:forEach var="medico" items="${bean.medicos}">
						<tr>
							<td>${medico.getNome()}</td>
							<td style="text-align: center">${medico.getEspecialidade()}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</form>
	<br />
	<a href="index.jsp">Voltar</a>
</body>
</html>