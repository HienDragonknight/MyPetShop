/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhltb.util;

import java.io.Serializable;
import static java.lang.Character.UnicodeBlock.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static jdk.nashorn.internal.codegen.CompilerConstants.className;

/**
 *
 * @author Minh
 */
public class DBHelper implements Serializable{ 
    public static Connection makeConnection() throws ClassNotFoundException, SQLException{
        //1. Load Drive
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2. Create connection String
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Registration";
        //3.Open connection
        Connection con = DriverManager.getConnection(url,"sa","123456");
        
        return con;
    }
}
