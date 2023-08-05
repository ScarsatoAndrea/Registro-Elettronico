package com.example.registro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.converter.ByteStringConverter;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;

public class SceneController {
    private Stage stage;
    private Scene scene;
    @FXML
    private Parent root;

    private Socket socket;
    private Studente studente;
    @FXML
    private TextField usernameTxt;
    @FXML
    private PasswordField passwordTxt;


    public void login (ActionEvent event) throws IOException{
        studente = new Studente(usernameTxt.getText(), passwordTxt.getText());

        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToHome(ActionEvent event) throws IOException {
//        String length = String.valueOf(socket.getInputStream().read());
//        System.out.println("Dimensione ricevuta: " + length);
//        int length2 = socket.getInputStream().read();
//        System.out.println("Dimensione ricevuta: " + length2);

        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToVoti(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("voti.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToPresenze(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("presenze.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLogin(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
