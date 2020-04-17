package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import space.Asteroid;
import space.NasaDataProvider;

import java.util.List;
import java.util.stream.Collectors;

public class MainController {

@FXML    public TextField startDateInput;
@FXML    public TextField endDateInput;
@FXML    public TextArea textArea;

    @FXML public void getData() throws Exception {
        List<Asteroid> asteroids =new NasaDataProvider().getNeoAsteroids(startDateInput.getText(),endDateInput.getText());
        asteroids.forEach(var->textArea.appendText(var.toString()));
    }
}
