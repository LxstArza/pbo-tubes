package com.gotpb.tubespbokelompok7.controllers;

import com.gotpb.tubespbokelompok7.Database;
import com.gotpb.tubespbokelompok7.model.User;
import com.gotpb.tubespbokelompok7.router.Router;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.io.IOException;


public class LoginController extends Controller {
    @FXML
    private TextField fieldUsername;
    @FXML
    private TextField fieldPassword;
    @FXML
    private Label LoginMessage;
    @FXML
    private Button loginbutton;

    @FXML
    private void toRegister() throws IOException {
        this.router.open("register");
    }

    public void masukAkun() {
        Database db = Database.getInstance();
        Router router = Router.getInstance();

        if (!fieldUsername.getText().isBlank() && !fieldPassword.getText().isBlank()) {
            User user = db.login(fieldUsername.getText(), fieldPassword.getText());

            if (user != null) {
                router.open("dashboard");
                DashboardController controller = router.getController("dashboard");
                controller.setUser(user);
            } else {
//                LoginMessage.setText("Identitas tidak terdaftar.");
            }
        } else {
//            LoginMessage.setText("Tolong ae diisi dlu.");
        }
    }
}