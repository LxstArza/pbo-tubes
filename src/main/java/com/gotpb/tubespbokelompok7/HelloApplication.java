package com.gotpb.tubespbokelompok7;

import com.gotpb.tubespbokelompok7.controllers.Controller;
import com.gotpb.tubespbokelompok7.controllers.LoginController;
import com.gotpb.tubespbokelompok7.router.Router;
import com.gotpb.tubespbokelompok7.views.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        View[] views = {
                new LoginView(),
                new RegisterView(),
                new DashboardView(),
                new VideoView(),
        };

        Router router = Router.getInstance(stage);
        router.setup(views);
        router.open("login");
    }

    public static void main(String[] args) {
        launch();
    }
}