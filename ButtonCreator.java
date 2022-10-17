package main;


import javafx.scene.Group;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class ButtonCreator {

    private static final String BUTTON_IN_BOTH_DIRECTION_TITLE_TEXT = "w obie strony";
    private static final String BUTTON_IN_ONE_DIRECTION_TITLE_TEXT = "w jedna strone";
    public static final RadioButton inBothDirection = new RadioButton(BUTTON_IN_BOTH_DIRECTION_TITLE_TEXT);
    public static final RadioButton inOneDirection = new RadioButton(BUTTON_IN_ONE_DIRECTION_TITLE_TEXT);

    public void createButtons(Group group) {
        createInBothAndOneDirectionButtons(group);
    }

    private void createInBothAndOneDirectionButtons(Group group) {

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
}

