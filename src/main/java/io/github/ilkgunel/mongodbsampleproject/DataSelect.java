/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.ilkgunel.mongodbsampleproject;

import io.github.ilkgunel.mongodbsampleproject.pojo.Address;
import io.github.ilkgunel.mongodbsampleproject.pojo.Record;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import io.github.ilkgunel.mongodbsampleproject.database.AccessMongoDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "select", urlPatterns = {"/select"})
public class DataSelect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Record> list = new ArrayList<>();
        //FindIterable<Document> result = getMongoDatabase().getCollection("Records").find(new Document("name","Can"));
        AccessMongoDB accessMongoDB = new AccessMongoDB();
        FindIterable<Document> result = accessMongoDB.getMongoDatabase().getCollection("Records").find();

        
        MongoCursor<Document> cursor = result.iterator();

        while (cursor.hasNext()) {
            Document document = cursor.next();
            System.out.println(document.get("_id"));
            System.out.println(document.get("name"));
            System.out.println(document.get("surname"));
            Document address = (Document) document.get("adress");
            System.out.println(address.get("street"));
            System.out.println(address.get("borough"));
            System.out.println(address.get("city"));

            Address address1 = new Address();
            address1.setStreet((String) address.get("street"));
            address1.setBorough((String) address.getString("borough"));
            address1.setCity((String) address.getString("city"));

            Record record = new Record();
            record.setId(document.get("_id").toString());
            record.setName((String) document.get("name"));
            record.setSurname((String) document.get("surname"));
            record.setAddress(address1);

            list.add(record);
        }

        request.setAttribute("records", list);

        RequestDispatcher view = request.getRequestDispatcher("/listRecors.jsp");
        view.forward(request, response);
    }

}
