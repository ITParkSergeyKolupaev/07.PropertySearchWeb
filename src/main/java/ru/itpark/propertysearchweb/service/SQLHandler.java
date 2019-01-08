package ru.itpark.propertysearchweb.service;

import java.sql.*;

public class SQLHandler {
    private static Connection cn;
    private static PreparedStatement pr;
    public static void connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:db.sqlite3");
            System.out.println("База подключена!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void disconnect(){
        try {
            if (cn!=null && !cn.isClosed())
                cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addProperty(int id, String  area, int price){
        try {
            pr = cn.prepareStatement("INSERT INTO house(id, area,price) VALUES (?,?,?);");
            pr.setInt(1, id);
            pr.setString(2, area);
            pr.setInt(3,price);
            pr.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
