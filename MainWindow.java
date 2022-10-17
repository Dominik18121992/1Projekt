package main;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Random;
import java.util.logging.Logger;

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
import main.*;
import javax.swing.*;
import java.security.cert.PolicyNode;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.lang.String;
import java.lang.System;

public class MainWindow extends Application {
    Group group = new Group();
    static final Logger logger = Logger.getAnonymousLogger();
    static int luck, value;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(group, 800, 600, Color.LIGHTBLUE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("System Rezerwacji Biletow Lotniczych");
        primaryStage.show();

        //Random rand = new Random();

        ButtonCreator buttonCreator = new ButtonCreator();
        buttonCreator.createButtons(group);

        DateOfArrivalCreator dateOfArrivalCreator = new DateOfArrivalCreator();
        dateOfArrivalCreator.createButtons(group);

        FromToFlightCreator fromToFlightCreator = new FromToFlightCreator();
        fromToFlightCreator.createButtons(group);

        SearchCreator searchCreator = new SearchCreator();
        searchCreator.createButtons(group);

        PayCreator payCreator = new PayCreator();
        payCreator.createButtons(group);

        PriceCreator priceCreator = new PriceCreator();
        priceCreator.createButtons(group);

        TextNumberTicketsCreator textNumberTicketsCreator = new TextNumberTicketsCreator();
        textNumberTicketsCreator.createButtons(group);

        LabelCreator labelCreator = new LabelCreator();
        labelCreator.createButtons(group);

        LabelTimeCreator labelTimeCreator = new LabelTimeCreator();
        labelTimeCreator.createButtons(group);

        DateCreator dateCreator = new DateCreator();
        dateCreator.createButtons(group);

        PhotoPlaneCreator photoPlaneCreator = new PhotoPlaneCreator();
        photoPlaneCreator.createButtons(group);

        SettingsCreator settingsCreator = new SettingsCreator();
        settingsCreator.createButtons(group);

        DateDepartureCreator dateDepartureCreator = new DateDepartureCreator();
        dateDepartureCreator.createButtons(group);

        CityDepartureCreator cityDepartureCreator = new CityDepartureCreator();
        cityDepartureCreator.createButtons(group);

        CityArrivalCreator cityArrivalCreator = new CityArrivalCreator();
        cityArrivalCreator.createButtons(group);

        AvailableTicketsCreator availableTicketsCreator = new AvailableTicketsCreator();
        availableTicketsCreator.createButtons(group);

        NotAvailableTicketsCreator notAvailableTicketsCreator = new NotAvailableTicketsCreator();
        notAvailableTicketsCreator.createButtons(group);

        NumberTicketsCreator numberTicketsCreator = new NumberTicketsCreator();
        numberTicketsCreator.createButtons(group);

        //getAllPriceForTickets(value, numberTickets);
        //int numberOfTickets;

    }

}


