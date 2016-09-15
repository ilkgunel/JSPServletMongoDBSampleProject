<%-- 
    Document   : recordUpdate
    Created on : Sep 14, 2016, 12:25:24 PM
    Author     : ilkaygunel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="dataUpdate">
            <table>
                <tr>
                    <td></td>
                    <td><input name="id" type="hidden" value="${updateRecord.id}"></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input name="name" type="text" value="${updateRecord.name}"></td>
                </tr>
                <tr>
                    <td>Surname</td>
                    <td><input name="surname" type="text" value="${updateRecord.surname}"></td>
                </tr>
                <tr>
                    <td>Cadde</td>
                    <td><input name="street" type="text" value="${updateRecord.address.street}"></td>
                </tr>
                <tr>
                    <td>İlçe</td>
                    <td><input name="borough" type="text" value="${updateRecord.address.borough}"></td>
                </tr>
                <tr>
                    <td>İl</td>
                    <td><input name="city" type="text" value="${updateRecord.address.city}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Kaydı Güncelle"></td>
                </tr>
                <tr>   
                    <td>${updateMessage}</td>
                    <td></td>
                </tr>
            </table>
        </form>
    </body>
</html>
