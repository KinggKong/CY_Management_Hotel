package org.example.cy_vn_managementhotel.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHepler {
    public static Connection openConnectionToDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/CY_Management_Hotel?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
        String username = "root";
        String password = "root";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return connection;
    }

    public static void closeConnectionToDB(Connection connection) throws SQLException {
        connection.close();
    }
}
