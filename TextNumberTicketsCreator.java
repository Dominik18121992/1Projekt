package main;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class TextNumberTicketsCreator {

    private static final String NUMBER_TICKETS_TEXT = "LICZBA BILETOW  ";
    private final  Label textNumberTickets = new Label(NUMBER_TICKETS_TEXT);

    public void createButtons(Group group) {
        createTextNumberTickets(group);
    }

    private void createTextNumberTickets(Group group) {

        textNumberTickets.setLayoutX(300);
        textNumberTickets.setLayoutY(230);
        textNumberTickets.setTextFill(Color.GREEN);

        group.getChildren().add(textNumberTickets);
    }
}
