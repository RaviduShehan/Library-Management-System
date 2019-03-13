package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

    // initialize the connection method

    public Connection connection;
    public Connection getConnection(){

        // set the database name , user name and password
        String dbName="westminsterlibrary";
        String userName="root";
        String password="";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            // set connection with the data base
            connection=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);



        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }
}
