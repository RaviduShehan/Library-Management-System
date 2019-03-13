package controllers;

import Connection.ConnectionClass;

import Library.Items;
import Library.Report;
import com.fasterxml.jackson.databind.JsonNode;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import play.libs.Json;
import play.mvc.*;

import java.sql.*;
import java.util.ArrayList;

public class LibraryController extends Controller {


    ConnectionClass connectionClass = new ConnectionClass();
    Connection connection = connectionClass.getConnection();
    Statement statement = connection.createStatement();

    public LibraryController() throws SQLException {
    }


    // getting the count for the items
    public Result Count() throws SQLException {

        ResultSet rst = null;
        try {
            rst = statement.executeQuery("SELECT count(*) FROM Items ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (rst.next()) {
            int reminder = 150;
            int values = rst.getInt(1);
            if (values == reminder) {

                return ok(Json.toJson("Library is Full, Please Delete an Item")).as("application/json");
            }
        }

        return ok(Json.toJson("")).as("application/json");
    }


    // Adding Book Data to the Data Base
    public Result Book() throws SQLException {


        JsonNode bookvalue = Json.parse(request().body().asText());
        try {

            // The inputs will be displayed in the console
            System.out.println(bookvalue.get("isbn").textValue());
            System.out.println(bookvalue.get("title").textValue());
            System.out.println(bookvalue.get("section").textValue());
            System.out.println(bookvalue.get("publishedDate").textValue());
            System.out.println(bookvalue.get("author").textValue());
            System.out.println(bookvalue.get("publisher").textValue());
            System.out.println(bookvalue.get("totalPages").textValue());


            //Adding data to the musql database
            try {
                String sql = "INSERT INTO Items(isbn,title,section,publishedDate,author,publisher,totalPages) VALUES('" + bookvalue.get("isbn") + "','" + bookvalue.get("title") + "','" + bookvalue.get("section") + "','" + bookvalue.get("publishedDate") + "','" + bookvalue.get("author") + "','" + bookvalue.get("publisher") + "','" + bookvalue.get("totalPages") + "')";
                int i = statement.executeUpdate(sql);

            } catch (MySQLIntegrityConstraintViolationException e) {
                System.out.println("Invalid Entry for Primary Key");
                JsonNode jsonNode = Json.toJson("The ISBN number you entered is already availble. Please add different Book");
                return ok(jsonNode).as("application/json");
            }
        } catch (NullPointerException e1) {
            return ok(Json.toJson("Please Fill the all fields ")).as("application/json");
        }

        return ok(Json.toJson("Book Added Succesfully!!! ")).as("application/json");
    }


    // Adding the details Of the DVD
    public Result Dvd() throws SQLException {


        JsonNode dvdvalue = Json.parse(request().body().asText());
        try {
            System.out.println(dvdvalue.get("isbn").textValue());
            System.out.println(dvdvalue.get("title").textValue());
            System.out.println(dvdvalue.get("section").textValue());
            System.out.println(dvdvalue.get("languages").textValue());
            System.out.println(dvdvalue.get("subtitles").textValue());
            System.out.println(dvdvalue.get("producer").textValue());
            System.out.println(dvdvalue.get("actors").textValue());


            try {
                String sql = "INSERT INTO Items(isbn,title,section,languages,substitles,producer,actors) VALUES('" + dvdvalue.get("isbn") + "','" + dvdvalue.get("title") + "','" + dvdvalue.get("section") + "','" + dvdvalue.get("languages") + "','" + dvdvalue.get("subtitles") + "','" + dvdvalue.get("producer") + "','" + dvdvalue.get("actors") + "')";
                int i = statement.executeUpdate(sql);

            } catch (MySQLIntegrityConstraintViolationException e) {
                System.out.println("Invalid Entry for Primary Key");
                JsonNode jsonNode = Json.toJson("The ISBN number you entered is already availble. Please add different DVD");
                return ok(jsonNode).as("application/json");
            }

        } catch (NullPointerException e1) {
            return ok(Json.toJson("Please Fill the All the Fields!!! ")).as("application/json");
        }
        return ok(Json.toJson("DVD Added Succesfully!!! ")).as("application/json");
    }


    // method for delete an item
    public Result Del() throws SQLException {
        JsonNode value = Json.parse(request().body().asText());
        try {
            System.out.println(value.get("isbn").textValue());

        ResultSet rst = null;
        try {
            rst = statement.executeQuery("SELECT section FROM Items where isbn='" + value.get("isbn") + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (rst.next()) {

            String values = rst.getString(1);
            try {
                String sql = "DELETE FROM `items` WHERE `items`.`isbn` = '" + value.get("isbn") + "'";
                statement.executeUpdate(sql);
            } catch (MySQLIntegrityConstraintViolationException e) {


                return ok(Json.toJson("Item already Borrowed ")).as("application/json");
            }
            return ok(Json.toJson(values + " Was Deleted!!!")).as("application/json");

        }

            //mysql querry will delete the item in the database
//            try {
//                String sql = "DELETE FROM `items` WHERE `items`.`isbn` = '" + value.get("isbn") + "'";
//                statement.executeUpdate(sql);
//            } catch (MySQLIntegrityConstraintViolationException e) {
//
//
//                return ok(Json.toJson("Item already Borrowed ")).as("application/json");
//            }
        } catch (NullPointerException e1) {
            return ok(Json.toJson("Please Enter Valid ISBN")).as("application/json");
        }
        JsonNode jsonNode = Json.toJson("Item Deleted!!!");
        return ok(jsonNode).as("application/json");
    }


    // This coun1 method will show the count of available slots in the Library
    public Result Count1() throws SQLException {
        ResultSet rst = null;
        try {
            rst = statement.executeQuery("SELECT count(*) FROM Items ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (rst.next()) {
            int total = 150;
            int values = total - rst.getInt(1);

            return ok(Json.toJson(values + " Slots are Available ")).as("application/json");

        }

        return ok(Json.toJson(" Count is ")).as("application/json");
    }


    // Borrowing books
    public Result BorrowItem() throws SQLException {
        JsonNode borrow = Json.parse(request().body().asText());

        try {
            System.out.println(borrow.get("isbn").textValue());
            System.out.println(borrow.get("id").textValue());
            System.out.println(borrow.get("name").textValue());
            System.out.println(borrow.get("email").textValue());
            System.out.println(borrow.get("mobile").textValue());
            System.out.println(borrow.get("date").textValue());


            try {
                String sql = "INSERT INTO borrow (id,name,email,mobile,borrowDate,isbn) VALUES('" + borrow.get("id") + "','" + borrow.get("name") + "','" + borrow.get("email") + "','" + borrow.get("mobile") + "','" + borrow.get("date") + "','" + borrow.get("isbn") + "')";
                int i = statement.executeUpdate(sql);

            } catch (MySQLIntegrityConstraintViolationException e) {
                System.out.println("Invalid Entry for Primary Key");

// check the availability of the item
                ResultSet rst = null;
                try {
                    rst = statement.executeQuery("SELECT DATE_ADD(" + borrow.get("date") + ", INTERVAL 7 DAY); ");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                while (rst.next()) {


                    return ok(Json.toJson("Item is not in the Library, It Will available on " + rst.getDate(1))).as("application/json");


                }

                return ok(Json.toJson("Item is not available")).as("application/json");


            }
        } catch (NullPointerException e1) {
            return ok(Json.toJson("Please Fill the Form Before you borrow an Item ")).as("application/json");
        }

        return ok(Json.toJson("You Borrowed an Item")).as("application/json");
    }


    public Result Rest() throws SQLException {
        JsonNode returnItem = Json.parse(request().body().asText());
        try {
            System.out.println(returnItem.get("isbn").textValue());
            System.out.println(returnItem.get("id").textValue());
            System.out.println(returnItem.get("date").textValue());

            String sql = " UPDATE borrow  set returnDate='" + returnItem.get("date") + "'where isbn='"+returnItem.get("isbn")+"' " ;
            statement.executeUpdate(sql);


                    String query = "DELETE FROM borrow WHERE `isbn` = '" + returnItem.get("isbn") + "'";
                    statement.executeUpdate(query);


        } catch (NullPointerException e) {

            return ok(Json.toJson("Please Fill the Form")).as("application/json");
        }


        return ok(Json.toJson("Item Returned!!!")).as("application/json");


    }


//Display the items in the library

    public Result View() throws SQLException {


        ArrayList<Items> itemList = new ArrayList<>();
        statement.executeBatch();
        ResultSet rst = statement.executeQuery("SELECT isbn,title,section FROM items ");


        while (rst.next()) {


            Items blist = new Items(rst.getString("isbn"), rst.getString("title"), rst.getString("section"));
            itemList.add(blist);
        }


        JsonNode jsonObject = Json.toJson(itemList);
        return ok(jsonObject).as("application/json");

    }

    public Result Search() throws SQLException {
        JsonNode search = Json.parse(request().body().asText());
        try {
            System.out.println(search.get("title").textValue());

            ResultSet rst = null;
            try {
                rst = statement.executeQuery("SELECT title FROM items where title='" + search.get("title") + "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }

         while(rst.next()) {

             String values = rst.getString(1);

             return ok(Json.toJson(values + " is available in the Library")).as("application/json");
         }

        } catch (NullPointerException e) {

            return ok(Json.toJson("Please Fill the Form")).as("application/json");

        }
        return ok(Json.toJson("Item is not available ")).as("application/json");
    }

    public Result Report() throws SQLException {

        ArrayList<Report> reportList = new ArrayList<>();
        statement.executeBatch();
        ResultSet rst = statement.executeQuery("SELECT isbn,id,borrowDate FROM borrow ");


        while (rst.next()) {


            Report rlist = new Report(rst.getString("isbn"), rst.getString("id"), rst.getString("borrowDate"));
            reportList.add(rlist);
        }


        JsonNode jsonObject = Json.toJson(reportList);
        return ok(jsonObject).as("application/json");

    }
}