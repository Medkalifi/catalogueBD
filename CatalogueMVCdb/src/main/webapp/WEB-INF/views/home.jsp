<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form action="saveProduit" modelAttribute="produit">
<table>
<tr>
<td>ID Produit:<f:hidden path="idProduit"/></td>
<td>${produit.idProduit}</td>
</tr>
<tr>
<td>Nom Produit:</td>
<td><f:input path="nomProduit"/></td>
<td><f:errors path="nomProduit" cssClass="error"/></td>
</tr>
<tr>
<td>Prix:</td>
<td><f:input path="prix"/></td>
<td><f:errors path="prix" cssClass="error"/></td>
</tr>
<tr>
<td><input type="submit" value="Save"></td>
</tr>
</table>
</f:form>
<table border="1" width="80%">
<tr>
<th>ID</th><th>Nom</th><th>Prix</th>
</tr>
<c:forEach items="${produits}" var="p">
<tr>
<td>${p.idProduit }</td>
<td>${p.nomProduit }</td>
<td>${p.prix }</td>
<td><a href="deleteProduit?id=${p.idProduit }">Supprimer</a></td>
<td><a href="editProduit/${p.idProduit }">Edit</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>
