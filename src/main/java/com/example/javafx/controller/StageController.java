package com.example.javafx.controller;

import com.example.javafx.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class StageController {

    private static Connection connection;

    private static Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @FXML
    public static void LoginScene() throws IOException {
        FXMLLoader loginLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene loginScene = new Scene(loginLoader.load(), 1240, 850);
        stage.setScene(loginScene);
        stage.setTitle("Page de connexion");
        stage.show();
    }

    @FXML
    public static void SigninScene() throws IOException {
        FXMLLoader signinLoader = new FXMLLoader(Main.class.getResource("signin.fxml"));
        Scene signinScene = new Scene(signinLoader.load(), 1240, 850);
        stage.setScene(signinScene);
        stage.setTitle("Page de création de compte");
        stage.show();
    }

    @FXML
    public static void SubscriptionScene() throws IOException {
        FXMLLoader subscriptionLoader = new FXMLLoader(Main.class.getResource("subscription.fxml"));
        Scene subscriptionScene = new Scene(subscriptionLoader.load(), 1240, 850);
        stage.setScene(subscriptionScene);
        stage.setTitle("Page de choix d'abonnement");
        stage.show();
    }

    @FXML
    public static void RecapAccountScene() throws IOException {
        FXMLLoader recapAccountLoader = new FXMLLoader(Main.class.getResource("recapAccount.fxml"));
        Scene recapAccountScene = new Scene(recapAccountLoader.load(), 1240, 850);
        stage.setScene(recapAccountScene);
        stage.setTitle("Récapitulatif du compte");
        stage.show();
    }

    @FXML
    public static void ProfilChoiceScene() throws IOException, SQLException {
        Integer userId= ConnectedUserController.getConnectedUserId();
        Integer nbProfil=DataBaseController.UserNbProfil(userId);
        if (nbProfil == 0) {
            FXMLLoader profil0ChoiceLoader = new FXMLLoader(Main.class.getResource("profil0.fxml"));
            Scene profil0ChoiceScene = new Scene(profil0ChoiceLoader.load(), 1240, 850);
            stage.setScene(profil0ChoiceScene);
            stage.setTitle("Page de choix de profil");
        }
        if (nbProfil== 1) {
            FXMLLoader profil1ChoiceLoader = new FXMLLoader(Main.class.getResource("profil1.fxml"));
            Scene profil1ChoiceScene = new Scene(profil1ChoiceLoader.load(), 1240, 850);
            stage.setScene(profil1ChoiceScene);
            stage.setTitle("Page de choix de profil");
        }
        if (nbProfil == 2) {
            FXMLLoader profil2ChoiceLoader = new FXMLLoader(Main.class.getResource("profil2.fxml"));
            Scene profil2ChoiceScene = new Scene(profil2ChoiceLoader.load(), 1240, 850);
            stage.setScene(profil2ChoiceScene);
            stage.setTitle("Page de choix de profil");
        }
        if (nbProfil == 3) {
            FXMLLoader profil3ChoiceLoader = new FXMLLoader(Main.class.getResource("profil3.fxml"));
            Scene profil3ChoiceScene = new Scene(profil3ChoiceLoader.load(), 1240, 850);
            stage.setScene(profil3ChoiceScene);
            stage.setTitle("Page de choix de profil");
        }
        if (nbProfil == 4) {
            FXMLLoader profil4ChoiceLoader = new FXMLLoader(Main.class.getResource("profil4.fxml"));
            Scene profil4ChoiceScene = new Scene(profil4ChoiceLoader.load(), 1240, 850);
            stage.setScene(profil4ChoiceScene);
            stage.setTitle("Page de choix de profil");
        }
        stage.show();
    }

    @FXML
    public static void CreateProfilScene() throws IOException {
        FXMLLoader createProfilLoader = new FXMLLoader(Main.class.getResource("createProfil.fxml"));
        Scene createProfilScene = new Scene(createProfilLoader.load(), 1240, 850);
        stage.setScene(createProfilScene);
        stage.setTitle("Page de création de profil");
    }

    @FXML
    public static void MenuScene() throws IOException, SQLException {
        FXMLLoader menuLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
        Scene menuScene = new Scene(menuLoader.load(), 1380, 850);
        stage.setScene(menuScene);
        stage.setTitle("Menu");
    }

    @FXML
    public static void AccountMenuScene() throws IOException {
        FXMLLoader accountMenuLoader = new FXMLLoader(Main.class.getResource("accountMenu.fxml"));
        Scene accountMenuScene = new Scene(accountMenuLoader.load(), 1380, 850);
        stage.setScene(accountMenuScene);
        stage.setTitle("Menu de compte");
    }

    @FXML
    public static void InfoFilmScene() throws IOException {
        FXMLLoader infoFilLoader = new FXMLLoader(Main.class.getResource("infoFilm.fxml"));
        Scene infoFilmScene = new Scene(infoFilLoader.load(), 1380, 800);
        stage.setScene(infoFilmScene);
        stage.setTitle("Info du film");
    }

    @FXML
    public static void InfoSerieScene() throws IOException {
        FXMLLoader infoSerieLoader = new FXMLLoader(Main.class.getResource("infoSerie.fxml"));
        Scene infoSerieScene = new Scene(infoSerieLoader.load(), 1380, 800);
        stage.setScene(infoSerieScene);
        stage.setTitle("Info de la série");
    }

    @FXML
    public static void VideoPlayerScene() throws IOException {
        FXMLLoader videoPlayerLoader = new FXMLLoader(Main.class.getResource("videoPlayer.fxml"));
        Scene videoPlayerScene = new Scene(videoPlayerLoader.load(), 1380, 820);
        stage.setScene(videoPlayerScene);
        stage.setTitle("");
    }
}










