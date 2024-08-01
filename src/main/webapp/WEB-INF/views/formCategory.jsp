<%--
  Created by IntelliJ IDEA.
  User: Aria
  Date: 30/07/2024
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../../index.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="postCategory" method="post">
    <div class="form-group">
        <label for="nomCategory">Nom de la catégorie</label>
        <input type="text" class="form-control" id="nomCategory"  name="nomCategory" placeholder="Category">
    </div>
    <div class="form-group">
        <label for="description">Description</label>
        <textarea  class="form-control" name="description" id="description" placeholder="description"></textarea>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>