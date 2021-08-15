package com.luv2code.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "hbstudent";
        String pwd = "hbstudent";

        System.out.println("Connecting to Database: "+jdbcUrl);
        try {
            DriverManager.getConnection(jdbcUrl,user,pwd);
            System.out.println("Connection successful!!!!!!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
