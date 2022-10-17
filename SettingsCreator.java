package main;

import javafx.scene.Group;
//import javafx.scene.control.Label;
//import javafx.scene.paint.Color;

import java.util.Random;
import static main.MainWindow.logger;
import static main.MainWindow.luck;
import static main.MainWindow.value;

public class SettingsCreator {

    public void createButtons(Group group) {
        createSettings(group);
    }

    private void createSettings(Group group) {

        Random rand = new Random();

        value = rand.nextInt(150) + 50; // losuje cene biletu
        logger.info("Cena za 1 bilet: " + value);

        luck = rand.nextInt(10) + 1;  // losuje czy bilety dostepne - 1-7, nie dostepne 8-10
        logger.info("Wynik losu dla dat: " + luck);
}

}
