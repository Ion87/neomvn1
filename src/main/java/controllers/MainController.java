package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainController {

@FXML    public TextField startDateInput;
@FXML    public TextField endDateInput;

    @FXML public void getData() {
        System.out.println(startDateInput.getText());
        System.out.println(endDateInput.getText());
       System.out.println("Test OK");
    }
}
