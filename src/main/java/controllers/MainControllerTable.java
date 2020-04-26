package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.GUIApplication;
import space.Asteroid;
import space.NasaDataProvider;

import java.io.IOException;
import java.util.List;

public class MainControllerTable {
    public TextField startDateInput;
    public TextField endDateInput;
    public TableColumn id;
    public TableColumn diameter;
    public TableColumn distance;
    public TableColumn danger;
    public TableView tableView;


    public void getData() throws Exception {
        List<Asteroid> asteroids = new NasaDataProvider().getNeoAsteroids(startDateInput.getText(),endDateInput.getText());
        final ObservableList<Asteroid> data = FXCollections.observableArrayList(asteroids);

        id.setCellValueFactory(
                new PropertyValueFactory<Asteroid,String>("nameId"));
        diameter.setCellValueFactory(
                new PropertyValueFactory<Asteroid,Float>("diameter"));
        distance.setCellValueFactory(
                new PropertyValueFactory<Asteroid,Float>("distanceKm"));
        danger.setCellValueFactory(
                new PropertyValueFactory<Asteroid,Boolean>("danger"));
        tableView.setItems(data);
    }

    public void singOf(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        new GUIApplication().start(stage);
    }
}
