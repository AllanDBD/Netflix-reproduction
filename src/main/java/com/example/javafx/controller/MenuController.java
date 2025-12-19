package com.example.javafx.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.SQLException;

public class MenuController {

    public void profilButtonClick() throws SQLException, IOException {
        StageController.ProfilChoiceScene();
    }

    public void compteButtonClick() throws IOException {
        StageController.AccountMenuScene();
    }

    public void FilmButtonClick(ActionEvent event) throws IOException {
        String buttonId = null;
        if (event.getSource() instanceof Button) {
            Button clickedButton = (Button) event.getSource();
            buttonId = clickedButton.getId();
        }
        ConnectedUserController connectedUserController= new ConnectedUserController();
        connectedUserController.setIdOeuvre(buttonId);
        StageController.InfoFilmScene();
    }

    public void SerieButtonClick(ActionEvent event) throws IOException {
        String buttonId = null;
        if (event.getSource() instanceof Button) {
            Button clickedButton = (Button) event.getSource();
            buttonId = clickedButton.getId();
        }
        ConnectedUserController connectedUserController= new ConnectedUserController();
        connectedUserController.setIdOeuvre(buttonId);
        StageController.InfoSerieScene();
    }
}
