<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">

	<head>
            <title>CRUD</title>
	</head>

        <body>
            <a href="medico"> <fmt:message key="listar.medico"/></a>
            <a href="paciente"> <fmt:message key="listar.paciente"/></a>
        </body>
</fmt:bundle>
</html>