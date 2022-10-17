package main;

import javafx.scene.Group;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;

import java.util.List;
import static main.MainWindow.logger;

public class NumberTicketsCreator {

    public static final ChoiceBox<Integer> numberTickets = new ChoiceBox<>();

    public void createButtons(Group group) {
        createNumberTickets(group);
    }

    private void createNumberTickets(Group group) {

        List<Integer> listNumberTickets = List.of(1, 2, 3, 4, 5, 6);
        numberTickets.setLayoutX(330);
        numberTickets.setLayoutY(270);
        numberTickets.getItems().addAll(listNumberTickets);
        numberTickets.setOnAction(event -> {
            GetAllPriceForTickets.createGetAllPriceForTickets(numberTickets.getValue(), numberTickets);
            logger.info("Liczba Biletow to " + numberTickets.getValue());
            SearchCreator.search.setDisable(false);
            SearchCreator.search.setVisible(true);
        });

        group.getChildren().add(numberTickets);
    }
}
