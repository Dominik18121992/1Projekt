package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import javax.swing.*;

import static main.MainWindow.logger;
import static main.MainWindow.luck;


public class DateDepartureCreator {

    private final TextField dateDeparture = new TextField();

    public void createButtons(Group group) {
        createDateDeparture(group);
    }

    private void createDateDeparture(Group group) {

        dateDeparture.setPromptText("DATA WYLOTU [Rok-Msc-Dzien]");
        dateDeparture.setPrefColumnCount(17);
        dateDeparture.setLayoutX(40);
        dateDeparture.setLayoutY(270);
        dateDeparture.setVisible(true);
        dateDeparture.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                logger.info("Wylot w dniu: " + dateDeparture.getText());



                if (luck >= 8 & ButtonCreator.inOneDirection.isSelected() == true) {
                    NotAvailableTicketsCreator.notAvailableTickets.setVisible(true);

                }

                if (luck <= 7 & ButtonCreator.inOneDirection.isSelected() == true) {
                    AvailableTicketsCreator.availableTickets.setVisible(true);

                }
            }

        });

        group.getChildren().add(dateDeparture);

}
 }
