package main;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class SearchCreator {

    private static final String BUTTON_SEARCH_TEXT = "Szukaj";
    public static final Button search = new Button(BUTTON_SEARCH_TEXT);


    public void createButtons(Group group) {

      createSearch(group);

      // return  ;
    }

    private void createSearch(Group group) {

        search.setLayoutX(600);
        search.setLayoutY(260);
        search.setTextFill(Color.GREEN);
        search.setDisable(false);
        search.setVisible(false);
        search.setOnMouseClicked(
                mouseEvent -> {
                    PriceCreator.price.setText("");
                    PriceCreator.createPrice(group);
                    PayCreator.pay.setVisible(true);
                    PriceCreator.price.setVisible(true);
                });

        group.getChildren().add(search);
    }

}
