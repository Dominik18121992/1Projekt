package main;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class NotAvailableTicketsCreator {
    private static final String BUTTON_NOT_AVAILABLE_TICKETS_TEXT = "Bilety Nie dostepne, podaj inne daty";
    public static final Label notAvailableTickets = new Label(BUTTON_NOT_AVAILABLE_TICKETS_TEXT);

    public void createButtons(Group group) {
        createNotAvailableTickets(group);
    }

    private void createNotAvailableTickets(Group group) {

        notAvailableTickets.setLayoutX(60);
        notAvailableTickets.setLayoutY(450);
        notAvailableTickets.setTextFill(Color.RED);
        notAvailableTickets.setVisible(false);

        group.getChildren().add(notAvailableTickets);
    }
}
