package com.example.registro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    private Stage stage;
    private Scene scene;
    private FXMLLoader root;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void onBtnHomeClick(ActionEvent event) throws IOException {
        root = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onBtnVotiClick(ActionEvent event) throws IOException {
        root = new FXMLLoader(HelloApplication.class.getResource("voti.fxml"));
        stage = new Stage();//(Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onBtnPresenzeClick(ActionEvent event) throws IOException {
        root = new FXMLLoader(HelloApplication.class.getResource("presenze.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();
    }
}