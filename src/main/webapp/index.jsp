<%@ page contentType="text/html" pageEncoding="UTF-8"%> <%@ page
isELIgnored="false"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Login</title>
    <link
      href="${pageContext.request.contextPath}/layout.css"
      rel="stylesheet"
      type="text/css"
    />
  </head>
  <body>
    <fmt:bundle basename="message">
      <h1><fmt:message key="saudacoes"/></h1>
    <c:if test="${mensagens.existeErros}">
      <div id="erro">
        <ul>
          <c:forEach var="erro" items="${mensagens.erros}">
            <li>${erro}</li>
          </c:forEach>
        </ul>
      </div>
    </c:if>
      <form method="post" action="dologin.jsp">
        <table>
          <tr>
            <th><fmt:message key="login"/></th>
            <td><input type="text" name="login" value="${param.login}" /></td>
          </tr>
          <tr>
            <th><fmt:message key="senha"/></th>
            <td><input type="password" name="senha" /></td>
          </tr>
          <tr>
            <td>
              <input type="submit" name="bOK" value="<fmt:message key="entrar"/>" />
            </td>
          </tr>
        </table>
      </form>
      </br>
      </br>
      <fmt:message key="listar.medico"/> <a href="listaMedicos.jsp"><fmt:message key="click"/></a> 
    </fmt:bundle>
  </body>
</html>

