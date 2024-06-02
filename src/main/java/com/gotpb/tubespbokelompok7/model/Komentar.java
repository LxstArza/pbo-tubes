package com.gotpb.tubespbokelompok7.model;

import com.gotpb.tubespbokelompok7.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Komentar {
    public String id;
    public String idUser;
    public String text;
    public String idVideo;

    public Komentar(String idUser, String text, String idVideo) {
        this.idUser = idUser;
        this.text = text;
        this.idVideo = idVideo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }


    public static ArrayList<Komentar> getAll() {
        ArrayList<Komentar> listKomentar = new ArrayList<>();

        String query = "SELECT * FROM table_komentar";
        DatabaseConnection db = DatabaseConnection.getInstance();

        try {
            PreparedStatement statement = db.connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Komentar komentar = new Komentar(
                        resultSet.getString("id_user"),
                        resultSet.getString("text"),
                        resultSet.getString("id_video")
                );

                listKomentar.add(komentar);
            }

            return listKomentar;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getByUserId() {
        String query = "SELECT * FROM table_user WHERE id =?";
        DatabaseConnection db = DatabaseConnection.getInstance();

        try {
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setString(1, this.idUser);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = new User(
                        resultSet.getString("email"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );

                return user;
            } else {
                return null; // or throw an exception if not found
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

