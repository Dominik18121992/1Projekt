package main;
//import main.java.NotAvailableTicketsCreator ;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import javax.swing.*;

import static main.MainWindow.logger;
import static main.MainWindow.luck;

public class DateOfArrivalCreator  {

    private static final String BUTTON_AVAILABLE_TICKETS_TEXT = "Bilety Dostepne";
    private final TextField dateOfArrival = new TextField();
    private final TextField dateDeparture = new TextField();

   // private final TextField dateDeparture = new TextField();

    public void createButtons(Group group) {

        //createDateOfArrival(group);
    }

    private void createDateOfArrival(Group group) {

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
                    NotAvailableTicketsCreator.notAvailableTickets.setVisible(true);
                    dateOfArrival.clear();
                    dateDeparture.clear();

                } else {
                    NotAvailableTicketsCreator. notAvailableTickets.setVisible(false);
                    AvailableTicketsCreator.availableTickets.setVisible(true);

                }
            }

        });
        group.getChildren().add(dateOfArrival);

        ButtonCreator.inOneDirection.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dateOfArrival.setDisable(true);
                logger.info("W jedna strone");
            }
        });

        ButtonCreator.inBothDirection.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dateOfArrival.setDisable(false);
                dateDeparture.setDisable(false);
                logger.info("W obie strony");

            }
        });
    }
}
