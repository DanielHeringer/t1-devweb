<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${medico != null}">
                            Atualizar
			</c:when>
			<c:otherwise>
				<fmt:message key="cadastrar"/>
			</c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${medico != null}">
		<input type="hidden" name="id" value="${medico.getId()}" />
	</c:if>
	<tr>
		<td><label for="crm"> CRM:
		</label></td>
		<td><input type="text" id="crm" name="crm" required
			value="${medico.getCRM()}"/></td>
	</tr>
	<tr>
		<td><label for="email"> <fmt:message key="medico.email"/>:
		</label></td>
		<td><input type="text" id="email" name="email" required
			value="${medico.getEmail()}"/></td>
	</tr>
	<tr>
		<td><label for="nome"><fmt:message key="medico.Nome"/>:
		</label></td>
		<td><input type="text" id="nome" name="nome"
			required value="${medico.getNome()}" /></td>
	</tr>
	<tr>
		<td><label for="senha"><fmt:message key="medico.senha"/>:
		</label></td>
		<td><input type="password" id="senha" name="senha" required
			/></td>
	</tr>
	<tr>
		<td><label for="telefone"> <fmt:message key="medico.tel"/>:
		</label></td>
		<td><input type="text" id="telefone" name="telefone" required 
                           value="${medico.getTelefone()}"
			/></td>
	</tr>
	<tr>
		<td><label for="especialidade"> <fmt:message key="medico.esp"/>:
		</label></td>
		<td><input type="text" id="especialidade" name="especialidade" required 
                           value="${medico.getEspecialidade()}"
			/></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="<fmt:message key="save.link"/>" /></td>
	</tr>
</table>