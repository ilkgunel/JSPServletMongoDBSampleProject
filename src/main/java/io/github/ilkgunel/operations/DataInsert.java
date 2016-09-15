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
import org.bson.Document;

/**
 *
 * @author ilkaygunel
 */
@WebServlet(name = "dataInsert", urlPatterns = {"/dataInsert"})
public class DataInsert extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String insertMessage = "";
        
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String street = request.getParameter("street");
        String borough = request.getParameter("borough");
        String city = request.getParameter("city");

        AccessMongoDB accessMongoDB = new AccessMongoDB();

        try {
            accessMongoDB.getCollection().insertOne(
                    new Document().append("id", id)
                    .append("name", name)
                    .append("surname", surname)
                    .append("adress",
                            new Document()
                            .append("street", street)
                            .append("borough", borough)
                            .append("city", city))
            );
            insertMessage = "Record successfully inserted!";
        } catch (Exception e) {
            insertMessage = "An error occured while inserting data! Error is:"+e;
        }
        request.setAttribute("insertMessage", insertMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/dataInsert.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String insertMessage = "";
        request.setAttribute("insertMessage", insertMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/dataInsert.jsp");
        dispatcher.forward(request, response);
    }
}
