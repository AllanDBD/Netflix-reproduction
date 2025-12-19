package com.example.javafx.controller;

import javafx.fxml.FXML;
import java.sql.*;
import java.util.Objects;

public class DataBaseController {
    private static Connection connection;
    private static Statement statement;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setStatement(Statement statement) throws SQLException {
        this.statement = statement;
    }

    @FXML
    public static void newUser(String mail, String password, String rib, String birthdate, String subscription) throws SQLException {

        String insertUserQuery = "INSERT INTO Users (mail, password, RIB, birthdate, subscription) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery);
        preparedStatement.setString(1, mail);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, rib);
        preparedStatement.setString(4, birthdate);
        preparedStatement.setString(5, subscription);

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        Integer lastId=generatedKeys.getInt(1);
        preparedStatement.executeUpdate();
    }

    @FXML
    public static void newProfil(Integer idUser, String pseudo, String type) throws SQLException {
        String insertUserQuery = "INSERT INTO Profils (idUser, pseudo, type) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery);
        preparedStatement.setInt(1, idUser);
        preparedStatement.setString(2, pseudo);
        preparedStatement.setString(3, type);
        preparedStatement.executeUpdate();
    }

    public static Integer getLastInsertedUserId() throws SQLException {
        String query = "SELECT MAX(id) AS last_id FROM Users";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.getInt("last_id");
    }

    @FXML
    static void setUserSubscription(Integer userId, String subscriptionText) throws SQLException {
        statement.executeUpdate("UPDATE Users SET subscription = '"+subscriptionText+"' WHERE id = '"+userId+"'");
    }

    public static ResultSet getInfoLastInsertUser(Integer userId) throws SQLException {
        return statement.executeQuery("SELECT * FROM Users WHERE id = '"+userId+"'");
    }

    public static boolean MailAlreadyUse(String mail) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT mail FROM Users");
        while(resultSet.next()){
            String mailUser=resultSet.getString("mail");
            if(mail.equals(mailUser)){
                return true;
            }
        }
        return false;
    }

    public static ResultSet getMailPasswordUser() throws SQLException {
        return statement.executeQuery("SELECT id, mail, password FROM Users");
    }

    public static ResultSet getPasswordUser() throws SQLException {
        return statement.executeQuery("SELECT password FROM Users WHERE id = '"+ConnectedUserController.getConnectedUserId()+"'");
    }

    public static Integer UserNbProfil(Integer userId) throws SQLException {
        int nbProfil = 0;
        ResultSet resultSet = statement.executeQuery("SELECT idUser FROM Profils");
        while (resultSet.next()) {
            Integer idUser = resultSet.getInt("idUser");
            if (Objects.equals(userId, idUser) && nbProfil<4) {
                nbProfil += 1;
            }
        }
        return nbProfil;
    }

    public static ResultSet getPseudosProfil(Integer userId) throws SQLException {
        return statement.executeQuery("SELECT pseudo FROM Profils WHERE idUser = '"+userId+"'");
    }

    public static ResultSet getInfoFilm(String filmId) throws SQLException {
        return statement.executeQuery("SELECT * FROM Films WHERE idFilm = '"+filmId+"'");
    }

    public static ResultSet getInfoSerie(String serieId) throws SQLException {
        return statement.executeQuery("SELECT * FROM Series WHERE idSerie = '"+serieId+"'");
    }

    public static ResultSet getVideoFilm(String id) throws SQLException {
        return statement.executeQuery("SELECT trailer FROM Films WHERE idFilm = '"+id+"'");
    }

    public static ResultSet getVideoSerie(String id) throws SQLException {
        return statement.executeQuery("SELECT trailer FROM Series WHERE idSerie = '"+id+"'");
    }

    public static void changeMDP(Integer userId, String mdp) throws SQLException {
        statement.executeUpdate("UPDATE Users SET password = '"+mdp+"' WHERE id = '"+userId+"'");
    }
}
