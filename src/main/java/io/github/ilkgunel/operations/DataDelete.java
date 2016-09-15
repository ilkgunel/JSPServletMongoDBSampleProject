/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.ilkgunel.operations;

import io.github.ilkgunel.database.AccessMongoDB;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author ilkaygunel
 */
@WebServlet(name = "dataDelete", urlPatterns = {"/dataDelete"})
public class DataDelete extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String operationMessage = "";
        
        String id = request.getParameter("id");
        ObjectId objectId = new ObjectId(id);
        
        AccessMongoDB accessMongoDB = new AccessMongoDB();
        try {
            accessMongoDB.getCollection().deleteOne(new Document("_id",objectId));
            operationMessage = "Kayıt Silme İşlemi Başarılı!";
            accessMongoDB.closeMongoClient();
        } catch (Exception e) {
            operationMessage = "An Error Occured! Error is:"+e;
        }
        
        /*request.setAttribute("operationMessage", operationMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/select");
        dispatcher.forward(request, response);*/
        HttpSession session = request.getSession();
        session.setAttribute("operationMessage", operationMessage);
        response.sendRedirect(request.getContextPath()+"/select");
    }
}
