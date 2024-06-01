package com.gotpb.tubespbokelompok7.controllers;

import com.gotpb.tubespbokelompok7.HelloApplication;
import com.gotpb.tubespbokelompok7.model.Video;
import com.gotpb.tubespbokelompok7.router.Router;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.media.MediaView;
import javafx.util.Duration;

import javax.xml.stream.events.Comment;


public class VideoController {
    @FXML private TextField fieldKomentar;
    @FXML private MediaView mediaView;
    @FXML private Label likes;

    private Media media;
    private MediaPlayer mediaPlayer;
    private Video video;
    

    public void initVideo(Video video) {
        this.video = video;

        this.media = new Media(video.getFile().toString());
        this.mediaPlayer = new MediaPlayer(this.media);
        this.mediaView.setMediaPlayer(this.mediaPlayer);
        this.mediaPlayer.play();
    }

    public void play() {
        mediaPlayer.play();
    }

    public void pause() {
        mediaPlayer.pause();
    }

    public void reset() {
        mediaPlayer.seek(Duration.seconds(0.0));
    }

    public void stop(){ mediaPlayer.stop();}

    @FXML
    private void kirimKomentar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("tampilan video.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void toRating(ActionEvent event) throws IOException {
        int l = Integer.parseInt(likes.getText());
        l++;
        likes.setText(Integer.toString(l));

    }

    @FXML
    private void takeQuiz(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("tampilan video.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void kembali(ActionEvent actionEvent) {
        stop();
        Router router = Router.getInstance();
        router.open("dashboard");
    }
}
