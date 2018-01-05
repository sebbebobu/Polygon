package spaceinv.service;


import javafx.scene.image.Image;

import java.net.URL;

/*
 *  A service, a class that can support the application with images
 *  (but not is part of model)
 *
 *    *** Nothing to do here ***
 */
public class ImageService {

    private static final String imageDir = "../assets/img/";

    public static Image getImage(String fileName, double requestedWidth, double requestedHeight, boolean preserveRatio) {
        URL url = ImageService.class.getResource(imageDir + fileName);
        return new Image(url.toString(), requestedWidth, requestedHeight, preserveRatio, true);
    }

    // Overloaded
    public static Image getImage(String fileName, double requestedWidth, double requestedHeight) {
        URL url = ImageService.class.getResource(imageDir + fileName);
        return new Image(url.toString(), requestedWidth, requestedHeight, true, true);
    }

    /*
    public static Image getXplosion() { //(String fileName, double requestedWidth, double requestedHeight) {
        URL url = ImageService.class.getResource(imageDir + "explosion.gif");
        return new Image(url.toString(), 30, 30, true, true);
    }
    */

}
