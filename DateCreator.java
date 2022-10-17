package main;

import javafx.scene.Group;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;

import java.util.List;

public class DateCreator {

    private static final String BUTTON_DATE_TEXT = "DATA  ";
    private final Label date = new Label(BUTTON_DATE_TEXT);

    public void createButtons(Group group) {
        createDate(group);
    }

    private void createDate(Group group) {

        date.setLayoutX(120);
        date.setLayoutY(230);
        date.setTextFill(Color.GREEN);

        group.getChildren().add(date);
    }
}

