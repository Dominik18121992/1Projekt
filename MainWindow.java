import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.security.cert.PolicyNode;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.lang.String;
import java.lang.System;

public class MainWindow extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(group, 800, 600, Color.LIGHTBLUE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("System Rezerwacji Biletow Lotniczych");
        primaryStage.show();

        createlabel();
        createLabelTime();
        createAvailableTickets();
        createInBothAndOneDirection();
        createNotAvailableTickets();
        createDateDeparture();
        createDateOfArrival();
        createCityDeparture();
        createCityArrival();
        createFromToFlight();
        createDate();
        createTextNumberTickets();
        createSettings();
        createPay();
        createPrice();
        createSearch();
        createNumberTickets();
        createPhotoPlane();
        getAllPriceForTickets(value, numberTickets);

    }

    Group group = new Group();
    Random rand = new Random();

    final Logger logger = Logger.getAnonymousLogger();
    int luck, value;
    int numberOfTickets;


    public void createSettings() {

        value = rand.nextInt(150) + 50; // losuje cene biletu
        logger.info("Cena za 1 bilet: " + value);
        //System.out.println("Cena za 1 bilet: " + value);

        luck = rand.nextInt(10) + 1;  // losuje czy bilety dostepne - 1-7, nie dostepne 8-10
        logger.info("Wynik losu dla dat: " + luck);

    }

    TextField dateDeparture = new TextField();
    Label notAvailableTickets = new Label("Bilety Nie dostepne, podaj inne daty");
    RadioButton inBothDirection = new RadioButton("w obie strony");
    RadioButton inOneDirection = new RadioButton("w jedna strone");
    Label availableTickets = new Label("Bilety Dostepne");
    TextField dateOfArrival = new TextField();
    Button pay = new Button("Zaplac teraz");
    Label price = new Label();
    Button search = new Button("Szukaj");
    ChoiceBox<Integer> numberTickets = new ChoiceBox<>();


    public void createlabel() {

        Label label = new Label("Rezerwacja Biletow Lotniczych");
        Font font = Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 28);
        label.setLayoutX(220);
        label.setLayoutY(30);
        label.setFont(font);
        label.setTextFill(Color.GREEN);

        group.getChildren().add(label);
    }

    public void createLabelTime() {

        LocalDate Data = LocalDate.now();
        System.out.println(Data);  // == Data.toString()
        Label labeltime = new Label("Dzis jest: " + Data);
        labeltime.setLayoutX(80);
        labeltime.setLayoutY(200);
        labeltime.setTextFill(Color.GREEN);

        group.getChildren().add(labeltime);
    }

    public void createAvailableTickets() {

        availableTickets.setLayoutX(60);
        availableTickets.setLayoutY(400);
        availableTickets.setTextFill(Color.GREEN);
        availableTickets.setVisible(false);

        group.getChildren().add(availableTickets);
    }

    public void createInBothAndOneDirection() {

        inBothDirection.setLayoutX(50);
        inBothDirection.setLayoutY(80);

        inOneDirection.setLayoutX(150);
        inOneDirection.setLayoutY(80);

        ToggleGroup togglegroup = new ToggleGroup();
        inBothDirection.setToggleGroup(togglegroup);
        inOneDirection.setToggleGroup(togglegroup);

        group.getChildren().add(inBothDirection);
        group.getChildren().add(inOneDirection);
    }

    public void createNotAvailableTickets() {

        notAvailableTickets.setLayoutX(60);
        notAvailableTickets.setLayoutY(450);
        notAvailableTickets.setTextFill(Color.RED);
        notAvailableTickets.setVisible(false);
        group.getChildren().add(notAvailableTickets);
    }

    public void createDateDeparture() {

        dateDeparture.setPromptText("DATA WYLOTU [Rok-Msc-Dzien]");
        dateDeparture.setPrefColumnCount(17);
        dateDeparture.setLayoutX(40);
        dateDeparture.setLayoutY(270);
        dateDeparture.setVisible(true);
        dateDeparture.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                logger.info("Wylot w dniu: " + dateDeparture.getText());


                if (luck >= 8 & inOneDirection.isSelected() == true) {
                    notAvailableTickets.setVisible(true);

                }

                if (luck <= 7 & inOneDirection.isSelected() == true) {
                    availableTickets.setVisible(true);

                }
            }

        });

        group.getChildren().add(dateDeparture);

    }

    public void createDateOfArrival() {

        dateOfArrival.setPromptText("DATA PRZYLOTU [Rok-Msc-Dzien]");
        dateOfArrival.setPrefColumnCount(17);
        dateOfArrival.setLayoutX(40);
        dateOfArrival.setLayoutY(320);
        dateOfArrival.setVisible(true);
        dateOfArrival.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                logger.info("Przylot w dniu: " + dateOfArrival.getText());

                if (luck >= 8 & dateDeparture.isVisible()) {
                    notAvailableTickets.setVisible(true);
                    dateOfArrival.clear();
                    dateDeparture.clear();

                } else {
                    notAvailableTickets.setVisible(false);
                    availableTickets.setVisible(true);

                }
            }

        });
        group.getChildren().add(dateOfArrival);

        inOneDirection.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dateOfArrival.setDisable(true);
                logger.info("W jedna strone");
            }
        });

        inBothDirection.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dateOfArrival.setDisable(false);
                dateDeparture.setDisable(false);
                logger.info("W obie strony");

            }
        });
    }

    public void createCityDeparture() {

        List<String> listOfCities = List.of("Krakow", "Warszawa", "Sztokholm", "Wieden", "Praga", "Amsterdam", "Glasgow", "Istanbul");
        // String [] lista = {"Krakow", "Warszawa", "Sztokholm", "Wieden", "Praga", "Amsterdam", "Glasgow", "Istanbul"};
        ChoiceBox<String> cityDeparture = new ChoiceBox<>();
        cityDeparture.setLayoutX(120);
        cityDeparture.setLayoutY(150);
        cityDeparture.getItems().addAll(listOfCities);
        cityDeparture.setOnAction(event -> logger.info("Wylot do " + cityDeparture.getValue()));

        group.getChildren().add(cityDeparture);

    }

    public void createCityArrival() {

        List<String> listOfCities2 = List.of("Kopenhaga", "Paryz", "Londyn", "Porto", "Berlin", "Barcelona", "Poznan", "Ateny");
        ChoiceBox<String> cityofArrival = new ChoiceBox<>();
        cityofArrival.setLayoutX(300);
        cityofArrival.setLayoutY(150);
        cityofArrival.getItems().addAll(listOfCities2);
        cityofArrival.setOnAction(event -> logger.info("Przylot z " + cityofArrival.getValue()));

        group.getChildren().add(cityofArrival);
    }

    public void createFromToFlight() {

        Label fromFlight = new Label("Z");
        fromFlight.setLayoutX(160);
        fromFlight.setLayoutY(120);

        Label toFlight = new Label("DO");
        toFlight.setLayoutX(340);
        toFlight.setLayoutY(120);

        group.getChildren().add(fromFlight);
        group.getChildren().add(toFlight);
    }

    public void createDate() {

        Label date = new Label("DATA  ");
        date.setLayoutX(120);
        date.setLayoutY(230);
        date.setTextFill(Color.GREEN);

        group.getChildren().add(date);
    }

    public void createTextNumberTickets() {

        Label textNumberTickets = new Label("LICZBA BILETOW  ");
        textNumberTickets.setLayoutX(300);
        textNumberTickets.setLayoutY(230);
        textNumberTickets.setTextFill(Color.GREEN);

        group.getChildren().add(textNumberTickets);
    }

    public void createPay() {

        pay.setLayoutX(600);
        pay.setLayoutY(500);
        pay.setTextFill(Color.ORANGE);
        pay.setVisible(false);
        pay.setOnAction(event -> logger.info("Płacimy"));

        group.getChildren().add(pay);
    }


    public void createNumberTickets() {

        List<Integer> listNumberTickets = List.of(1, 2, 3, 4, 5, 6);
        numberTickets.setLayoutX(330);
        numberTickets.setLayoutY(270);
        numberTickets.getItems().addAll(listNumberTickets);
        numberTickets.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                logger.info("Liczba Biletow to " + numberTickets.getValue());
                //search.setDisable(false);
                search.setVisible(true);

            }
        });

        group.getChildren().add(numberTickets);

    }

    public String getAllPriceForTickets(int value, ChoiceBox<Integer> numberTickets) {

        numberOfTickets = 1;
        if (numberTickets.getValue() != null) {
            numberOfTickets = numberTickets.getValue();
        }

        return "CENA ZA BILETY WYNOSI : " + value * numberOfTickets + " PLN";
    }

    public void createPrice() {

        price = new Label(getAllPriceForTickets(value, numberTickets));
        price.setLayoutX(320);
        price.setLayoutY(430);
        price.setTextFill(Color.RED);
        price.setVisible(false);
        search.setOnAction(event -> {
            System.out.println("Szukamy");
            price.setText(getAllPriceForTickets(value, numberTickets));
            pay.setVisible(true);
            price.setVisible(true);
        });

        group.getChildren().add(price);
    }

    public void createSearch() {

        search.setLayoutX(600);
        search.setLayoutY(260);
        search.setTextFill(Color.GREEN);
        //search.setDisable(false);
        search.setVisible(false);
        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                logger.info("Szukamy");
                pay.setVisible(true);
                price.setVisible(true);

            }
        });

        group.getChildren().add(search);
    }

    public void createPhotoPlane() {

        ImageView photoPlane = new ImageView("samolot.jpg");
        photoPlane.setFitHeight(160);
        photoPlane.setFitWidth(320);
        photoPlane.setLayoutY(80);
        photoPlane.setLayoutX(450);

        group.getChildren().add(photoPlane);
    }

}
