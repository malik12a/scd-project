
package DAO;

import java.sql.*;
public class Database {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.food");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management","root","");
            return con;
        } catch (Exception e) {
            System.err.println("Connection error");
            return null;
        }
    }
}

