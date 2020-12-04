<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${paciente != null}">
                            Atualizar
			</c:when>
			<c:otherwise>
                            Cadastrar
			</c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${paciente != null}">
		<input type="hidden" name="id" value="${paciente.getId()}" />
	</c:if>
	<tr>
		<td><label for="cpf"> CPF:
		</label></td>
		<td><input type="text" id="cpf" name="cpf" required
			value="${paciente.getCPF()}"/></td>
	</tr>
	<tr>
		<td><label for="email"> Email:
		</label></td>
		<td><input type="text" id="email" name="email" required
			value="${paciente.getEmail()}"/></td>
	</tr>
	<tr>
		<td><label for="nome">Nome:
		</label></td>
		<td><input type="text" id="nome" name="nome"
			required value="${paciente.getNome()}" /></td>
	</tr>
	<tr>
		<td><label for="senha"> Senha:
		</label></td>
		<td><input type="password" id="senha" name="senha" required
			/></td>
	</tr>
	<tr>
		<td><label for="telefone"> Telefone:
		</label></td>
		<td><input type="text" id="telefone" name="telefone" required 
                           value="${paciente.getTelefone()}"
			/></td>
	</tr>
	<tr>
		<td><label for="sexo"> Sexo:
		</label></td>
		<td><input type="text" id="sexo" name="sexo" required 
                           value="${paciente.getSexo()}"
			/></td>
	</tr>
	<tr>
		<td><label for="data"> Data Nascimento:
		</label></td>
		<td><input type="date" id="data" name="data" required 
			/></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="Salvar" /></td>
	</tr>
</table>