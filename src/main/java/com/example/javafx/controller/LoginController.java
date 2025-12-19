package com.example.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class LoginController {

    public javafx.scene.control.TextField mailField;
    public javafx.scene.control.TextField passwordField;
    public Label wrongIDorPassword;

    @FXML
    public void ConnectionButtonClick() throws IOException, SQLException {
        ResultSet resultSet= DataBaseController.getMailPasswordUser();
        while (resultSet.next()) {
            String mailText=mailField.getText();
            String passwordText= passwordField.getText();
            Integer id = resultSet.getInt("id");
            String mailUser= resultSet.getString("mail");
            String passwordUser= resultSet.getString("password");

            if(Objects.equals(mailText, mailUser) && Objects.equals(passwordText, passwordUser)){
                ConnectedUserController connectedUserController= new ConnectedUserController();
                connectedUserController.setConnectedUserId(id);
                StageController.ProfilChoiceScene();
            }
        }
        wrongIDorPassword.setText("Mail ou Mot de passe incorrect!");
    }

    @FXML
    public void SigninButtonClick() throws IOException {
        StageController.SigninScene();
    }
}
