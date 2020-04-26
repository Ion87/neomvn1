package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;


public class GUIApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader0 = new FXMLLoader();
        URL url0 = getClass().getResource("/log.fxml");
        loader0.setLocation(url0);
        Parent root0 = loader0.load();
        stage.setScene(new Scene(root0));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
