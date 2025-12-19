package com.example.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class SigninController {

    public TextField mailField;
    public TextField password1Field;
    public TextField password2Field;
    public TextField ribField;
    public TextField birthDateField;
    public Label wrongRibField;
    public Label emptyField;
    public Label wrongPassword2Field;
    public Label wrongMailField;
    public Label wrongDateField;


    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$"
    );

    private static final Pattern DATE_PATTERN = Pattern.compile(
            "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d{2}$"
    );

    @FXML
    public void ValiderButtonClick() throws IOException, SQLException {
        String mailText= mailField.getText();
        String password1Text= password1Field.getText();
        String password2Text= password2Field.getText();
        String ribText= ribField.getText();
        String birthdateText= birthDateField.getText();


        if(mailText.isEmpty() || password1Text.isEmpty() || password2Text.isEmpty() || ribText.isEmpty() || birthdateText.isEmpty()){
            emptyField.setText("Veuillez remplir tous les champs");
        }

        else if(!EMAIL_PATTERN.matcher(mailText).matches()){
            wrongMailField.setText("Mail invalide");
            emptyField.setText("");
        }


        else if (EMAIL_PATTERN.matcher(mailText).matches() && DataBaseController.MailAlreadyUse(mailText)) {
            wrongMailField.setText("Mail déjà existant");
            emptyField.setText("");
        }

        else if(!password1Text.equals(password2Text) && EMAIL_PATTERN.matcher(mailText).matches() && !DataBaseController.MailAlreadyUse(mailText)){
            wrongPassword2Field.setText("Entrer les mêmes mot de passe");
            wrongMailField.setText("");
            emptyField.setText("");
        }

        else if (ribText.length()!=8 && password1Text.equals(password2Text) && EMAIL_PATTERN.matcher(mailText).matches() && !DataBaseController.MailAlreadyUse(mailText)){
            wrongRibField.setText("RIB invalide");
            wrongPassword2Field.setText("");
            emptyField.setText("");
            wrongMailField.setText("");
        }

        else if(!DATE_PATTERN.matcher(birthdateText).matches() && ribText.length()==4 && password1Text.equals(password2Text) && EMAIL_PATTERN.matcher(mailText).matches() && !DataBaseController.MailAlreadyUse(mailText)){
            wrongRibField.setText("");
            wrongDateField.setText("Date invalide");
            emptyField.setText("");
            wrongMailField.setText("");
            wrongPassword2Field.setText("");
        }

        else {
            wrongDateField.setText("");
            mailField.setText("");
            password1Field.setText("");
            password2Field.setText("");
            ribField.setText("");
            birthDateField.setText("");
            DataBaseController.newUser(mailText, password1Text, ribText, birthdateText, "");
            StageController.SubscriptionScene();
        }
    }

    @FXML
    public void SeConnecterButtonClick() throws IOException {
        StageController.LoginScene();
    }
}
