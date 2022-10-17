package main;

import javafx.scene.Group;
import javafx.scene.control.Label;

public class FromToFlightCreator {

    private static final String BUTTON_FROM_FLIGHT_TEXT = "Z";
    private static final String BUTTON_TO_FLIGHT_TEXT = "DO";

    private final Label fromFlight = new Label(BUTTON_FROM_FLIGHT_TEXT);
    private final Label toFlight = new Label(BUTTON_TO_FLIGHT_TEXT);

    public void createButtons(Group group) {
        createFromToFlight(group);
    }

    private void createFromToFlight(Group group) {

        fromFlight.setLayoutX(160);
        fromFlight.setLayoutY(120);


        toFlight.setLayoutX(340);
        toFlight.setLayoutY(120);

        group.getChildren().add(fromFlight);
        group.getChildren().add(toFlight);
    }
}
