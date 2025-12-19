package com.example.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProfilChoiceController {

    @FXML
    private Label pseudo1;
    @FXML
    private Label pseudo2;
    @FXML
    private Label pseudo3;
    @FXML
    private Label pseudo4;

    @FXML
    void initialize() throws SQLException {

        Integer userId = ConnectedUserController.getConnectedUserId();
        Integer nbProfil = DataBaseController.UserNbProfil(userId);

        if (nbProfil != 0) {
            ResultSet resultSet = DataBaseController.getPseudosProfil(userId);

            List<String> pseudos = new ArrayList<>();

            while (resultSet.next()) {
                pseudos.add(resultSet.getString("pseudo"));
            }
            if (nbProfil >= 1 && !pseudos.isEmpty()) {
                pseudo1.setText(pseudos.getFirst());
            }
            if (nbProfil >= 2 && pseudos.size() >= 2) {
                pseudo2.setText(pseudos.get(1));
            }
            if (nbProfil >= 3 && pseudos.size() >= 3) {
                pseudo3.setText(pseudos.get(2));
            }
            if (nbProfil >= 4 && pseudos.size() >= 4) {
                pseudo4.setText(pseudos.get(3));
            }
        }
    }

    public void goToNewProfilButtonClick() throws IOException {
        StageController.CreateProfilScene();
    }


    public void profilButtonClick() throws IOException, SQLException {
        StageController.MenuScene();
    }
}
