package spaceinv.view;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spaceinv.service.ImageService;

import static java.lang.System.out;

/*
     Draw animation on canvas

     ***  Nothing to do here ****

 */
public class Explosion extends AnimationTimer {

    private final static Image i = ImageService.getImage("explosion.png", 640, 480);
    private final GraphicsContext gc;
    private final double x;
    private final double y;
    private double sx = 0;
    private double sy = 0;
    private int frameCounter = 0;


    public Explosion(GraphicsContext gc, double x, double y) {
        this.x = x;
        this.y = y;
        this.gc = gc;
    }

    @Override
    public void handle(long now) {
        gc.drawImage(i, sx, sy, 80, 80, x - 20, y - 40, 80, 80);
        sx = (sx + 80) % 640;
        if (sx == 0) {
            sy = (sy + 80) % 480;
        }
        if (frameCounter > 48) {
            stop();
            return;
        }
        frameCounter++;
    }
}
