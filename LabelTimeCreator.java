package main;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.time.LocalDate;

 public class LabelTimeCreator {

    LocalDate Data = LocalDate.now();

    private final String TIME_TEXT = ("Dzis jest: " + Data);
    private final Label labeltime = new Label(TIME_TEXT);

    public void createButtons(Group group) {
        createLabelTime(group);
    }

    private void createLabelTime(Group group) {

       /*
          LocalDate Data = LocalDate.now();
          System.out.println(Data);  // == Data.toString()
          Label labeltime = new Label("Dzis jest: " + Data);
       */

        System.out.println(labeltime);

        labeltime.setLayoutX(80);
        labeltime.setLayoutY(200);
        labeltime.setTextFill(Color.GREEN);

        group.getChildren().add(labeltime);
    }
}
