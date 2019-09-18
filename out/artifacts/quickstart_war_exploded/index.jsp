<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
    
  <h2>首页</h2>
<%--  <h2>欢迎你: <%=request.getAttribute("username")%></h2>--%>
  <h2>欢迎你:<%=session.getAttribute("username")%></h2>
  <a href="person.jsp">哈哈哈</a>
  </body>
</html>
