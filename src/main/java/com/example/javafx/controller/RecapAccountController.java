package com.example.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecapAccountController {

    @FXML
    private Label  mailRecap;
    @FXML
    private Label ribRecap;
    @FXML
    private Label dateRecap;
    @FXML
    private Label subscriptionRecap;

    @FXML
    void initialize() throws SQLException {
        Integer id=DataBaseController.getLastInsertedUserId();
        ResultSet resultSet=DataBaseController.getInfoLastInsertUser(id);
        String mail=resultSet.getString("mail");
        String rib=resultSet.getString("rib");
        String birthdate=resultSet.getString("birthdate");
        String subscription=resultSet.getString("subscription");
        mailRecap.setText(mail);
        ribRecap.setText(rib);
        dateRecap.setText(birthdate);
        subscriptionRecap.setText(subscription);
    }

    public void RetourButtonClick() throws IOException {
        StageController.SubscriptionScene();
    }

    public void CreerCompteButtonClick() throws IOException {
        StageController.LoginScene();
    }
}
