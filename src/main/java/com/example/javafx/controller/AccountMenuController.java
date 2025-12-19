package com.example.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMenuController {

    @FXML
    private TextField mdp1;
    @FXML
    private TextField mdp2;
    @FXML
    private Label wrongMDP;
    @FXML
    private Label mdpModified;

    public void accueilButtonClick() throws IOException, SQLException {
        mdpModified.setText("");
        wrongMDP.setText("");
        StageController.MenuScene();
    }

    public void profilButtonClick() throws SQLException, IOException {
        mdpModified.setText("");
        wrongMDP.setText("");
        StageController.ProfilChoiceScene();
    }

    public void deconnectionButtonClick() throws IOException {
        mdpModified.setText("");
        wrongMDP.setText("");
        StageController.LoginScene();
    }

    public void ValiderButtonClick() throws SQLException {
        String mdp1Text = mdp1.getText();
        String mdp2Text = mdp2.getText();
        ResultSet resultSet=DataBaseController.getPasswordUser();
        String userPassword=resultSet.getString("password");
        if(mdp1Text.equals(userPassword)){
            wrongMDP.setText("");
            mdpModified.setText("Mot de passe modifié avec succès");
            mdp1.setText("");
            mdp2.setText("");
            Integer userId= ConnectedUserController.getConnectedUserId();
            DataBaseController.changeMDP(userId, mdp2Text);
        }
        else{
            wrongMDP.setText("Mot de passe incorrect");
        }
    }

}
