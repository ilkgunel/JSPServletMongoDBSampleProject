/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.ilkgunel.mongodbsampleproject;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import io.github.ilkgunel.mongodbsampleproject.database.AccessMongoDB;
import io.github.ilkgunel.mongodbsampleproject.pojo.Address;
import io.github.ilkgunel.mongodbsampleproject.pojo.Record;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author ilkaygunel
 */
@WebServlet(name = "dataUpdate", urlPatterns = {"/dataUpdate"})
public class DataUpdate extends HttpServlet {
    String updateMessage = "";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recordId = request.getParameter("id");
        ObjectId objectId = new ObjectId(recordId);

        AccessMongoDB accessMongoDB = new AccessMongoDB();
        MongoDatabase database = accessMongoDB.getMongoDatabase();

        FindIterable<Document> searchResult = database.getCollection("Records").find(new Document("_id", objectId));

        MongoCursor<Document> cursor = searchResult.iterator();

        Record updateRecord = new Record();

        Document record = cursor.next();

        System.out.println("\n\nDocument:" + record);

        updateRecord.setId(record.get("_id").toString());
        updateRecord.setName((String) record.get("name"));
        updateRecord.setSurname((String) record.get("surname"));

        Document addressDocument = (Document) record.get("adress");
        Address address = new Address();
        address.setStreet((String) addressDocument.get("street"));
        address.setBorough((String) addressDocument.getString("borough"));
        address.setCity((String) addressDocument.getString("city"));
        updateRecord.setAddress(address);

        request.setAttribute("updateRecord", updateRecord);
        request.setAttribute("updateMessage", updateMessage);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/recordUpdate.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        

        String recordId = request.getParameter("id");
        ObjectId objectId = new ObjectId(recordId);

        AccessMongoDB accessMongoDB = new AccessMongoDB();
        MongoDatabase database = accessMongoDB.getMongoDatabase();
        try {
            UpdateResult updateResult = database.getCollection("Records").updateOne(new Document("_id", objectId), 
                    new Document("$set",new Document()
                    .append("name", request.getParameter("name"))
                    .append("surname", request.getParameter("surname"))
                    .append("adress",
                            new Document()
                            .append("street", request.getParameter("street"))
                            .append("borough", request.getParameter("borough"))
                            .append("city", request.getParameter("city")))));
            updateMessage = "Update Is Successful";
        } catch (Exception e) {
            updateMessage = "An error occured while updating record. Error is:"+e;
        }
        
        request.setAttribute("updateMessage", updateMessage);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/recordUpdate.jsp");
        dispatcher.forward(request, response);
    }
}
