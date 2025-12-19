package com.example.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoSerieController {

    @FXML
    private ImageView affiche;
    @FXML
    private Label nom;
    @FXML
    private Label categorie;
    @FXML
    private Label age;
    @FXML
    private Label duree;
    @FXML
    private Label annee;
    @FXML
    private TextArea description;

    @FXML
    void initialize() throws SQLException, FileNotFoundException {
        String serieId = ConnectedUserController.getSelectedOeuvreId();
        ResultSet resultSet = DataBaseController.getInfoSerie(serieId);

        FileInputStream stream = new FileInputStream(resultSet.getString("affiche"));
        Image image = new Image(stream);

        affiche.setImage(image);
        nom.setText(resultSet.getString("nom"));
        categorie.setText(resultSet.getString("categorie"));
        age.setText(resultSet.getString("age_mini"));
        duree.setText(resultSet.getString("nb_saisons"));
        annee.setText(resultSet.getString("annee_sortie"));
        description.setEditable(false);
        description.setText(resultSet.getString("description"));
    }

    public void accueilButtonClick() throws IOException, SQLException {
        StageController.MenuScene();
    }

    public void profilButtonClick() throws SQLException, IOException {
        StageController.ProfilChoiceScene();
    }

    public void compteButtonClick() throws IOException {
        StageController.AccountMenuScene();
    }

    public void lectureButtonClick() throws IOException {
        StageController.VideoPlayerScene();
    }
}
