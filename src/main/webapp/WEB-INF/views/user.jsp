<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aria
  Date: 02/08/2024
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../../index.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>User</title>
<h1>User details</h1>
<ul>
 <li><h2>${user.name}</h2></li>
    <c:if test="user.email !=null">
        <li>${user.email}</li>
    </c:if>
</ul>
