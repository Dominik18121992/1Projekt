package main;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LabelCreator {
    private static final String BUTTON_LABEL_TEXT = "Rezerwacja Biletow Lotniczych";
    private final Label label = new Label(BUTTON_LABEL_TEXT);


    public void createButtons(Group group) {
        createlabel(group);
    }

    private void createlabel(Group group) {

        Font font = Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 28);
        label.setLayoutX(220);
        label.setLayoutY(30);
        label.setFont(font);
        label.setTextFill(Color.GREEN);

        group.getChildren().add(label);
    }
}
