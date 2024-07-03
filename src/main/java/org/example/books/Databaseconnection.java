package org.example.books;

public class Databaseconnection {
    package com.example.books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DatabaseConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/booksDB";
        private static final String USER = "tu_usuario";
        private static final String PASSWORD = "tu_contraseña";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }

}
