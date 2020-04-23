package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class GUIApplication extends Application{
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        URL url = getClass().getResource("/Table.fxml");
        loader.setLocation(url);
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle("Asteroid's data from Nasa");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
