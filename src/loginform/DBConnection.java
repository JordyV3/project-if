/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jordyvega
 */
public class DBConnection {

    static final String DB_URL = "jdbc:mysql://localhost:3306/ManagerApp";
    static final String USER = "root";
    static final String PASSWORD = "vega2023";
    public static Connection connectDB(){
        Connection conn = null;
        
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            return conn;
        }catch(Exception ex){
            System.out.println("Hubo errores al conectarse a db.");
            return null;
        }
    }
    
}
