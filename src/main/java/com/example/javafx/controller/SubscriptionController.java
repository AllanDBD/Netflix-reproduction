package com.example.javafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;
import java.sql.SQLException;

public class SubscriptionController {

    @FXML
    public void AboButtonClick(ActionEvent event) throws IOException, SQLException {
        if (event.getSource() instanceof Button) {
            Button clickedButton = (Button) event.getSource();
            String buttonId = clickedButton.getId();
            if(buttonId.equals("abo1")) {
                DataBaseController.setUserSubscription(DataBaseController.getLastInsertedUserId(),"7.99€");
            }
            else if(buttonId.equals("abo2")) {
                DataBaseController.setUserSubscription(DataBaseController.getLastInsertedUserId(),"10.99€");
            }
            else{
                DataBaseController.setUserSubscription(DataBaseController.getLastInsertedUserId(),"12.99€");
            }
        }
        StageController.RecapAccountScene();
    }
}
