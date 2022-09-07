import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Random;

public class OkienkoStartowe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Random rand = new Random();

        Integer Cena = rand.nextInt(150)+50; // losuje cene biletu
        System.out.println("Cena za 1 bilet: "+Cena);


        int los = rand.nextInt(10)+1;  // losuje czy bilety dostepne - 1-7, nie dostepne 8-10
        System.out.println("Wynik losu dla dat: "+los);


        Label label = new Label("Rezerwacja Biletow Lotniczych");
        Font font = Font.font("Times New Roman", FontWeight.EXTRA_BOLD,28);
        label.setLayoutX(220);
        label.setLayoutY(30);
        label.setFont(font);
        label.setTextFill(Color.GREEN);

        LocalDate Data =  LocalDate.now();
        System.out.println(Data);  // == Data.toString()

        Label labeltime = new Label("Dzis jest: "+Data);
        labeltime.setLayoutX(80);
        labeltime.setLayoutY(200);
        labeltime.setTextFill(Color.GREEN);


        Label biletTak = new Label("Bilety Dostepne");
        biletTak.setLayoutX(60);
        biletTak.setLayoutY(400);
        biletTak.setTextFill(Color.GREEN);
        biletTak.setVisible(false);

        RadioButton wObieStrony = new RadioButton("w obie strony");
        wObieStrony.setLayoutX(50);
        wObieStrony.setLayoutY(80);


        RadioButton wJednaStrone = new RadioButton("w jedna strone");
        wJednaStrone.setLayoutX(150);
        wJednaStrone.setLayoutY(80);


        ToggleGroup togglegroup = new ToggleGroup();
        wObieStrony.setToggleGroup(togglegroup);
        wJednaStrone.setToggleGroup(togglegroup);


        Label biletNie = new Label("Bilety Nie dostepne, podaj inne daty");
        biletNie.setLayoutX(60);
        biletNie.setLayoutY(450);
        biletNie.setTextFill(Color.RED);
        biletNie.setVisible(false);

        TextField dataWylotu = new TextField();
        dataWylotu.setPromptText("DATA WYLOTU [Rok-Msc-Dzien]");
        dataWylotu.setPrefColumnCount(17);
        dataWylotu.setLayoutX(40);
        dataWylotu.setLayoutY(270);
        dataWylotu.setVisible(true);
        dataWylotu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                System.out.println("Wylot w dniu: "+ dataWylotu.getText());

               if (los >= 8 & wJednaStrone.isSelected() == true)
               {
                   biletNie.setVisible(true);

               }

               if (los<=7 & wJednaStrone.isSelected() == true)
               {
                   biletTak.setVisible(true);

               }
            }
        });

        TextField dataPrzylotu = new TextField();
        dataPrzylotu.setPromptText("DATA PRZYLOTU [Rok-Msc-Dzien]");
        dataPrzylotu.setPrefColumnCount(17);
        dataPrzylotu.setLayoutX(40);
        dataPrzylotu.setLayoutY(320);
        dataPrzylotu.setVisible(true);
        dataPrzylotu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                System.out.println("Przylot w dniu: "+dataPrzylotu.getText());

                if (los>=8 & dataWylotu.isVisible())
                {
                    biletNie.setVisible(true);
                    dataPrzylotu.clear();
                    dataWylotu.clear();

                }
                else
                {
                    biletNie.setVisible(false);
                    biletTak.setVisible(true);

                }
            }
        });

        wJednaStrone.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dataPrzylotu.setDisable(true);
                System.out.println("W jedna strone");
            }
        });

        wObieStrony.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dataPrzylotu.setDisable(false);
                dataWylotu.setDisable(false);
                System.out.println("W obie strony");

            }
        });


        String [] lista = {"Krakow", "Warszawa", "Sztokholm", "Wieden", "Praga", "Amsterdam", "Glasgow", "Istanbul"};
        ChoiceBox<String> miastoWylot = new ChoiceBox<>();
        miastoWylot.setLayoutX(120);
        miastoWylot.setLayoutY(150);
        miastoWylot.getItems().addAll(lista);
        miastoWylot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                System.out.println("Wylot do " + miastoWylot.getValue() );
            }
        });

        String [] lista2 = {"Kopenhaga", "Paryz", "Londyn", "Porto", "Berlin", "Barcelona", "Poznan", "Ateny"};
        ChoiceBox<String> miastoPrzylot = new ChoiceBox<>();
        miastoPrzylot.setLayoutX(300);
        miastoPrzylot.setLayoutY(150);
        miastoPrzylot.getItems().addAll(lista2);
        miastoPrzylot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                System.out.println("Przylot z " + miastoPrzylot.getValue() );
            }
        });

        Label lotZ = new Label("Z");
        lotZ.setLayoutX(160);
        lotZ.setLayoutY(120);

        Label lotDO = new Label("DO");
        lotDO.setLayoutX(340);
        lotDO.setLayoutY(120);

        Label data = new Label("DATA  ");
        data.setLayoutX(120);
        data.setLayoutY(230);
        data.setTextFill(Color.GREEN);

        Label pasazer = new Label("LICZBA BILETOW  ");
        pasazer.setLayoutX(300);
        pasazer.setLayoutY(230);
        pasazer.setTextFill(Color.GREEN);


        Button zaplac = new Button("Zaplac teraz");
        zaplac.setLayoutX(600);
        zaplac.setLayoutY(500);
        zaplac.setTextFill(Color.ORANGE);
        zaplac.setVisible(false);
        zaplac.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Płacimy");
            }
        });

        // Cena podawana z Random, nie mam pomysłu jak zrobic wynik   (Cena * liczbaBiletow )....

        Label cena = new Label("CENA ZA BILETY WYNOSI :  " + Cena + " PLN");
        cena.setLayoutX(320);
        cena.setLayoutY(430);
        cena.setTextFill(Color.RED);
        cena.setVisible(false);


        Button szukaj = new Button("Szukaj");
        szukaj.setLayoutX(600);
        szukaj.setLayoutY(260);
        szukaj.setTextFill(Color.GREEN);
        szukaj.setDisable(true);
        szukaj.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Szukamy");
                zaplac.setVisible(true);
                cena.setVisible(true);

            }
        });

        Integer [] lista3 = {1,2,3,4,5,6};
        ChoiceBox<Integer> liczbaBiletow = new ChoiceBox<>();
        liczbaBiletow.setLayoutX(330);
        liczbaBiletow.setLayoutY(270);
        liczbaBiletow.getItems().addAll(lista3);
        liczbaBiletow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                System.out.println("Liczba Biletow to " + liczbaBiletow.getValue() );
                szukaj.setDisable(false);
            }
        });


        ImageView samolotobraz = new ImageView("samolot.jpg");
        samolotobraz.setFitHeight(160);
        samolotobraz.setFitWidth(320);
        samolotobraz.setLayoutY(80);
        samolotobraz.setLayoutX(450);

        Group group = new Group();
        group.getChildren().add(label);
        group.getChildren().add(wObieStrony);
        group.getChildren().add(wJednaStrone);
        group.getChildren().add(miastoWylot);
        group.getChildren().add(miastoPrzylot);
        group.getChildren().add(lotZ);
        group.getChildren().add(lotDO);
        group.getChildren().add(data);
        group.getChildren().add(pasazer);
        group.getChildren().add(szukaj);
        group.getChildren().add(dataWylotu);
        group.getChildren().add(dataPrzylotu);
        group.getChildren().add(samolotobraz);
        group.getChildren().add(liczbaBiletow);
        group.getChildren().add(cena);
        group.getChildren().add(zaplac);
        group.getChildren().add(biletTak);
        group.getChildren().add(biletNie);
        group.getChildren().add(labeltime);

        Scene scene = new Scene(group , 800 , 600, Color.LIGHTBLUE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("System Rezerwacji Biletow Lotniczych");
        primaryStage.show();

    }
}
