package main;

import javafx.scene.Group;
import javafx.scene.control.ChoiceBox;

public  class GetAllPriceForTickets {

    static int numberOfTickets;

    public final  ChoiceBox<Integer> numberTickets = new ChoiceBox<>();


    public void createButtons(Group group) {
        createGetAllPriceForTickets( numberTickets.getValue(), numberTickets);
    }

    public static String createGetAllPriceForTickets( int value, ChoiceBox<Integer> numberTickets) {

        numberOfTickets = 0;
        if (numberTickets.getValue() != null) {
            numberOfTickets = numberTickets.getValue();
        }

        return "CENA ZA BILETY WYNOSI : " + value * numberOfTickets + " PLN";

    }
}
    /*public String getAllPriceForTickets(int value, ChoiceBox<Integer> numberTickets) {

        numberOfTickets = 0;
        if (numberTickets.getValue() != null) {
            numberOfTickets = numberTickets.getValue();
        }

        return "CENA ZA BILETY WYNOSI : " + value * numberOfTickets + " PLN";
    }*/