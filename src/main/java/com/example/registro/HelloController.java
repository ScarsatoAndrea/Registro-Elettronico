package com.example.registro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class HelloController  {
    @FXML
    private Label welcomeText;

    private Stage stage;
    private Scene scene;
    private FXMLLoader root;
    private Socket socket = new Socket("127.0.0.1", 50007);

    public HelloController() throws IOException {
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void onBtnHomeClick(ActionEvent event) throws IOException {

        System.out.println("ok");

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out.println("assenze");
        System.out.println((in.readLine()));

        root = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        stage.setScene(scene);
        stage.show();

        out.close();
        in.close();
        socket.close();
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