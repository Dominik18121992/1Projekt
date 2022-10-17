package main;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import static main.MainWindow.logger;

public class PayCreator {
    private static final String BUTTON_PAY_TEXT = "Zaplac teraz";
    public static final Button pay = new Button(BUTTON_PAY_TEXT);


    public void createButtons(Group group) {
        createPay(group);
    }

    private void createPay(Group group) {
        pay.setLayoutX(600);
        pay.setLayoutY(500);
        pay.setTextFill(Color.ORANGE);
        pay.setVisible(false);
        pay.setOnAction(event -> logger.info("Płacimy"));

        group.getChildren().add(pay);
    }
}
