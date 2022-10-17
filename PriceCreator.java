package main;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import static main.MainWindow.logger;
import static main.NumberTicketsCreator.numberTickets;
import static main.MainWindow.value;

public class PriceCreator {

    public static final Label price = new Label(GetAllPriceForTickets.createGetAllPriceForTickets(MainWindow.value, NumberTicketsCreator.numberTickets));

    public void createButtons(Group group) {
        createPrice(group);
    }

    public static void createPrice(Group group) {
        price.setLayoutX(320);
        price.setLayoutY(430);
        price.setTextFill(Color.RED);
        price.setVisible(false);
        SearchCreator.search.setOnAction(event ->
    {
        logger.info("Szukamy");
        //price.setText(getAllPriceForTickets(value, numberTickets));
        PayCreator.pay.setVisible(true);
        price.setVisible(true);
    });

        group.getChildren().add(price);

}

}
