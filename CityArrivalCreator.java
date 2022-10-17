package main;

import javafx.scene.Group;
import javafx.scene.control.ChoiceBox;

import java.util.List;

import static main.MainWindow.logger;



public class CityArrivalCreator {

    private final ChoiceBox<String> cityofArrival = new ChoiceBox<>();

    public void createButtons(Group group) {
        createCityArrival(group);
    }

    private void createCityArrival(Group group) {

        List<String> listOfCities2 = List.of("Kopenhaga", "Paryz", "Londyn", "Porto", "Berlin", "Barcelona", "Poznan", "Ateny");
       // ChoiceBox<String> cityofArrival = new ChoiceBox<>();
        cityofArrival.setLayoutX(300);
        cityofArrival.setLayoutY(150);
        cityofArrival.getItems().addAll(listOfCities2);
        cityofArrival.setOnAction(event -> logger.info("Przylot z " + cityofArrival.getValue()));

        group.getChildren().add(cityofArrival);

    }
}
