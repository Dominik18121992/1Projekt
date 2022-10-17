package main;

import javafx.scene.Group;
import javafx.scene.control.ChoiceBox;
import static main.MainWindow.logger;

import java.util.List;

public class CityDepartureCreator {
    private final ChoiceBox<String> cityDeparture = new ChoiceBox<>();

    public void createButtons(Group group) {
        createCityDeparture(group);
    }

    private void createCityDeparture(Group group) {
        List<String> listOfCities = List.of("Krakow", "Warszawa", "Sztokholm", "Wieden", "Praga", "Amsterdam", "Glasgow", "Istanbul");
        // String [] lista = {"Krakow", "Warszawa", "Sztokholm", "Wieden", "Praga", "Amsterdam", "Glasgow", "Istanbul"};
        //ChoiceBox<String> cityDeparture = new ChoiceBox<>();
        cityDeparture.setLayoutX(120);
        cityDeparture.setLayoutY(150);
        cityDeparture.getItems().addAll(listOfCities);
        cityDeparture.setOnAction(event -> logger.info("Wylot do " + cityDeparture.getValue()));

        group.getChildren().add(cityDeparture);
    }
}
