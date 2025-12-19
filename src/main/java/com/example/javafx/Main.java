package com.example.javafx;

import com.example.javafx.controller.DataBaseController;
import com.example.javafx.controller.StageController;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException, SQLException {

        ConnectDB db = new ConnectDB();
        Connection connection = db.getConnection();
        Statement statement = connection.createStatement();
        String createTableUser = "CREATE TABLE IF NOT EXISTS Users (id INTEGER PRIMARY KEY, mail TEXT, password TEXT, RIB INTEGER, birthdate DATE, subscription TEXT)";
        String createTableProfil = "CREATE TABLE IF NOT EXISTS Profils (id INTEGER PRIMARY KEY, idUser INTEGER, pseudo TEXT, type TEXT, FOREIGN KEY (idUser) REFERENCES Users(id))";
        String createTableFilm = "CREATE TABLE IF NOT EXISTS Films (id INTEGER PRIMARY KEY, idFilm TEXT, nom TEXT, categorie TEXT, description TEXT, age_mini INTEGER, duree TEXT, annee_sortie INTEGER, trailer TEXT, affiche TEXT)";
        //String createTableCastingFilm = "CREATE TABLE IF NOT EXISTS CastingsFilms(id INTEGER_PRIMARY_KEY, nom_film TEXT, nom_acteur TEXT, FOREIGN KEY (nom_film) REFERENCES Films(nom))";
        String createTableSerie = "CREATE TABLE IF NOT EXISTS Series (id TEXT INTEGER KEY, idSerie TEXT, nom TEXT, categorie TEXT, description TEXT, age_mini INTEGER, nb_saisons INTEGER, annee_sortie INTEGER,trailer TEXT, affiche TEXT)";
        //String createTableCastingSerie = "CREATE TABLE IF NOT EXISTS CastingsSeries(id INTEGER_PRIMARY_KEY, nom_serie TEXT, nom_acteur TEXT, FOREIGN KEY (nom_serie) REFERENCES Series(nom))";
        String createTableDocumentaire = "CREATE TABLE IF NOT EXISTS Documentaires (id TEXT INTEGER KEY, idDoc TEXT, nom TEXT, categorie TEXT, description TEXT, age_mini INTEGER, duree TEXT, annee_sortie INTEGER, trailer TEXT, affiche TEXT)";

        statement.executeUpdate(createTableUser);
        statement.executeUpdate(createTableProfil);
        statement.executeUpdate(createTableFilm);
       //statement.executeUpdate(createTableCastingFilm);
        statement.executeUpdate(createTableSerie);
        //statement.executeUpdate(createTableCastingSerie);
        statement.executeUpdate(createTableDocumentaire);

        StageController controller = new StageController();
        controller.setStage(stage);

        DataBaseController dataController = new DataBaseController();
        dataController.setConnection(connection);
        dataController.setStatement(statement);

        StageController.LoginScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

