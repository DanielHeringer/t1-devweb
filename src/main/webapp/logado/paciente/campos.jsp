<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1">
	<caption>
            Agendamento
	</caption>
	<tr>
		<td><label for="cpf"> Médico:
		</label></td>
		<td>
                    <select name="medico" id="cars">
                        <c:forEach items="${requestScope.listaMedico}" var="medico">
                            <option value="${medico.getId()}">${medico.getNome()}</option>
                        </c:forEach>
                    </select>
                </td>
	</tr>
	<tr>
		<td><label for="data">Data:
		</label></td>
		<td><input type="datetime-local" id="data" name="data" required 
			/></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="<fmt:message key="save.link"/>" /></td>
	</tr>
</table>