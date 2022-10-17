package main;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class PhotoPlaneCreator {

    //private static final String PLANE_PHOTO = "samolot.jpg";
    //private final ImageView photoPlane = new ImageView(PLANE_PHOTO);

    public void createButtons(Group group) {
        createPhotoPlane(group);
    }

    private void createPhotoPlane(Group group) {

        ImageView photoPlane = new ImageView("samolot.jpg");
        photoPlane.setFitHeight(160);
        photoPlane.setFitWidth(320);
        photoPlane.setLayoutY(80);
        photoPlane.setLayoutX(450);

        group.getChildren().add(photoPlane);
    }
}
