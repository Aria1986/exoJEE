<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: Aria
  Date: 31/07/2024
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../../index.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${not empty msg}" >
    <p>${msg}</p>
</c:if>
    <h1>See all categories</h1>
<ul>
<%--    <li><h2>${category1.nom}</h2>--%>
<%--        <p>${category1.description}</p>--%>
<%--    </li>--%>
<%--    <li><h2>${category2.nom}</h2>--%>
<%--        <p>${category2.description}</p>--%>
<%--    </li>--%>
    <c:forEach items="${listCategories}" var="category">
        <li><a href='Category?id=${category.id}'><h2>${category.nom}</h2></a>
            <p>${category.description}</p>
<%--            <form action="Categories/Delete/${category_id}" method="POST">--%>
<%--                <input type="hidden" name="_method" value="DELETE">--%>
<%--                <button type="submit">Supprimer</button>--%>
<%--            </form>--%>

            <a href="Categories/Delete?id=${category_id}"  onclick="return confirm('Êtes-vous sûr de vouloir supprimer ?')">delete category</a>
        </li>
    </c:forEach>
</ul>
