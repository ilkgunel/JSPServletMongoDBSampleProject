<%-- 
    Document   : listRecors
    Created on : Sep 11, 2016, 12:50:23 PM
    Author     : ilkaygunel
--%>

<%@page import="io.github.ilkgunel.pojo.Record"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<body>
	<c:if test="${fn:length(records) gt 0}">
		<c:forEach items="${records}" var="record">
			<table style="width: 300px">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Surname</th>
					<th>İşlem</th>
				</tr>

				<tr>
					<td><center>${record.id}</center></td>
					<td><center>${record.name}</center></td>
					<td><center>${record.surname}</center></td>
					<td>
						<center>
							<a href="<c:url value="dataUpdate"><c:param name="id" value="${record.id}"/></c:url>">
								<input type="submit"
								onclick="return  confirm('Kaydı Güncellemek İstediğinize Emin misiniz?')"
								value="Kaydı Güncelle" style="background-color: aqua">
							</a>
						</center>
						<center>
							<a href="<c:url value="dataDelete"><c:param name="id" value="${record.id}"/></c:url>">
								<input type="submit"
								onclick="return confirm('Kaydı Silmek İstediğinize Emin misiniz?')"
								value="Kaydı Sil" style="background-color: red">
							</a>
						</center>
					</td>
				</tr>
			</table>
		</c:forEach>
	</c:if>
	<c:if test="${fn:length(records) == 0}">
		<%
			out.println("Veritabanında kayıt bulunmuyor!");
		%>
	</c:if>
    <br>
	${operationMessage}
        <br>
        <a href="<c:url value="dataInsert"></c:url>">Kayıt Eklemek İçin Tıklayın</a>
</body>
</html>
