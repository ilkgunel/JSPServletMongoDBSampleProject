<%-- 
    Document   : listRecors
    Created on : Sep 11, 2016, 12:50:23 PM
    Author     : ilkaygunel
--%>

<%@page import="io.github.ilkgunel.mongodbsampleproject.pojo.Record"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<Record> pList = (List<Record>) request.getAttribute("records");
        %>

        <table style="width: 300px">
            <%
                for (Record record : pList) {
            %>
            <tr>
                <td><%=record.getId()%></td>
                <td><%=record.getName()%></td>
                <td><%=record.getSurname()%></td>
                <td><a href="http://www.google.com"><input type="submit" value="Güncelle"></a></td>
            </tr>
            <%
                }
            %>
        </table>

    </body>
</html>
