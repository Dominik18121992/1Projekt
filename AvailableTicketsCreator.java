package main;

import javafx.scene.Group;
import javafx.scene.control.Label;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class AvailableTicketsCreator {

    private static final String BUTTON_AVAILABLE_TICKETS_TEXT = "Bilety Dostepne";
    public static final Label availableTickets = new Label(BUTTON_AVAILABLE_TICKETS_TEXT);


    public void createButtons(Group group) {
        createAvailableTickets(group);
    }

    private void createAvailableTickets(Group group) {

        availableTickets.setLayoutX(60);
        availableTickets.setLayoutY(400);
        availableTickets.setTextFill(Color.GREEN);
        availableTickets.setVisible(false);

        group.getChildren().add(availableTickets);
    }
}



