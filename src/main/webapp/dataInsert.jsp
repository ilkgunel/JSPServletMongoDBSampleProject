<%-- 
    Document   : index
    Created on : Sep 11, 2016, 11:36:28 AM
    Author     : ilkaygunel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kayıt Eklemek</title>
    </head>
    <body>
        <form action="dataInsert" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id"</td>
                </tr>
                <tr>
                    <td>Adınız</td>
                    <td><input type="text" name="name"</td>
                </tr>
                <tr>
                    <td>Soyadınız</td>
                    <td><input type="text" name="surname"</td>
                </tr>
                <tr>
                    <td>Cadde/Sokak</td>
                    <td><input type="text" name="street"</td>
                </tr>
                <tr>
                    <td>İlçe</td>
                    <td><input type="text" name="borough"</td>
                </tr>
                <tr>
                    <td>İl</td>
                    <td><input type="text" name="city"</td>
                </tr>
                <tr>
                    <td><input type="submit" value="GÖNDER"</td>
                </tr>
            </table>
        </form>
        <br>
        ${insertMessage}
    </body>
</html>
