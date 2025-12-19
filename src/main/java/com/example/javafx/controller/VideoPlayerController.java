package com.example.javafx.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoPlayerController {

    @FXML
    private MediaView mediaView;

    @FXML
    private ProgressBar progressBar;

    private MediaPlayer mediaPlayer;

    public void initialize() throws SQLException, FileNotFoundException {
        String id = ConnectedUserController.getSelectedOeuvreId();
        ResultSet resultSet = DataBaseController.getVideoFilm(id);
        java.net.URL resource = null;
        if (resultSet.getString("trailer") != null) {
            String pathVideo = resultSet.getString("trailer");
            resource = getClass().getResource(pathVideo);
        }
        resultSet = DataBaseController.getVideoSerie(id);
        if(resultSet.getString("trailer") != null){
            String pathVideo = resultSet.getString("trailer");
            resource = getClass().getResource(pathVideo);
        }
        String videoURI = resource.toExternalForm();
        Media media = new Media(videoURI);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            updateProgressBar();
        });

        mediaPlayer.setOnReady(() -> {
            progressBar.setProgress(0);
        });

        mediaPlayer.play();
    }

    @FXML
    private void PauseButtonClick() {
        MediaPlayer.Status status = mediaPlayer.getStatus();
        if (status == MediaPlayer.Status.PLAYING) {
            mediaPlayer.pause();
        }
    }

    @FXML
    private void RunButtonClick() {
        MediaPlayer.Status status = mediaPlayer.getStatus();
        if (status == MediaPlayer.Status.PAUSED) {
            mediaPlayer.play();
        }
    }

    public void StopButtonClick() throws IOException, SQLException {
        mediaPlayer.stop();
        StageController.MenuScene();
    }

    private void updateProgressBar() {
        Platform.runLater(() -> {
            Duration currentTime = mediaPlayer.getCurrentTime();
            Duration totalTime = mediaPlayer.getTotalDuration();
            progressBar.setProgress((currentTime.toSeconds() / totalTime.toSeconds()));
        });
    }


}

