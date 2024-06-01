package com.gotpb.tubespbokelompok7.model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gotpb.tubespbokelompok7.DatabaseConnection;



public class Testimoni {
    public int id;
    public User user;
    public String text;

    public Testimoni(String text) {

        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public static ArrayList<Testimoni> getAll() {
        ArrayList<Testimoni> listTestimoni = new ArrayList<>();
        String query = "SELECT * FROM table_testimoni";
        DatabaseConnection db = DatabaseConnection.getInstance();

        try {
            PreparedStatement statement = db.connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Testimoni testimoni = new Testimoni(

                        resultSet.getString("text")
                );

                listTestimoni.add(testimoni);
            }
            return listTestimoni;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addTestimoni(String idUser, String text) {
        String query = "INSERT INTO table_testimoni (id_user, text) VALUES (?,?)";
        DatabaseConnection db = DatabaseConnection.getInstance();

        try {
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setString(1, idUser);
            statement.setString(2, text);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}