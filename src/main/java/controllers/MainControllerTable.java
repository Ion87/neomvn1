package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import space.Asteroid;
import space.NasaDataProvider;

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
}
