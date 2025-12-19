package com.example.javafx.controller;

public class ConnectedUserController {
    private static Integer idUser;
    private static String idOeuvre;

    public void setConnectedUserId(Integer idUser){
        this.idUser= idUser;
    }

    public static Integer getConnectedUserId(){
        return idUser;
    }

    public void setIdOeuvre(String idOeuvre){
        this.idOeuvre= idOeuvre;
    }

    public static String getSelectedOeuvreId(){
        return idOeuvre;
    }

}
