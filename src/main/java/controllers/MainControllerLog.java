package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.GUIApplication;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Lidia on 26.04.2020.
 */
public class MainControllerLog {
    public TextField logText;
    public PasswordField passText;
    public Label loginLab;
    public Label passLab;
    public Label wrongLab;
    private String log = "user";
    private String pass = "password";

    public void verify(ActionEvent actionEvent) throws IOException {
        if (logText.getText().equals(log)&&passText.getText().equals(pass)){
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            URL url = getClass().getResource("/Table.fxml");
            loader.setLocation(url);
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("Asteroid's data from Nasa");
        }else {
        wrongLab.setText("wrong login or password");
        }
    }
}
