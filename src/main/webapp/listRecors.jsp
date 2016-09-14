<%-- 
    Document   : listRecors
    Created on : Sep 11, 2016, 12:50:23 PM
    Author     : ilkaygunel
--%>

<%@page import="io.github.ilkgunel.mongodbsampleproject.pojo.Record"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

        <table style="width: 300px">
            <c:forEach items="${records}" var="record">
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
                        <a href="<c:url value="dataUpdate">
                           <c:param name="id" value="${record.id}"/>
                           </c:url>">
                        Kaydı Güncelle
                        </a>
                    </center>
                    </td>
                </tr>
            </c:forEach>
        </table>

</body>
</html>
