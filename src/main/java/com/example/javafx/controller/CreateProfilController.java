package com.example.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class CreateProfilController {

    @FXML
    private TextField pseudoField;
    @FXML
    private ChoiceBox TypeProfilField;

    @FXML
    public void ValiderButtonClick() throws IOException, SQLException {
        Integer userId=ConnectedUserController.getConnectedUserId();
        String pseudoText= pseudoField.getText();
        String typeText = (String) TypeProfilField.getValue();
        DataBaseController.newProfil(userId,pseudoText, typeText);
        StageController.ProfilChoiceScene();
    }

    @FXML
    public void RetourButtonClick() throws IOException, SQLException {
        StageController.ProfilChoiceScene();
    }
}
