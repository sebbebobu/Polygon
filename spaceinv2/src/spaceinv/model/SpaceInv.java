package spaceinv.model;

import spaceinv.service.EventService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static spaceinv.service.EventService.Type;


/*
 * Logic for the SpaceInv Game
 * Model class representing the "overall" game logic
 *
 * Nothing visual here
 *
 * See:
 * - week6/samples/catchtherain
 */
public class SpaceInv {

    // Application global constants
    public static final double WIDTH = 800;    // Size of window
    public static final double HEIGHT = 400;

    // The model
    // TODO

    // Administrative things

    private boolean rocketFlying;  // Just one rocket at the time
    private int points;            // Player points

    public SpaceInv(/* All objects needed for model sent in here */) {
       // TODO
    }

    // ------ Game loop (call by timer) -----------------

    public void update() {
        // TODO this is the game loop, i.e move things and check collisions, called by timer (see GUI)
    }


    public void fireGun() {
        if (!rocketFlying) {    // Just one projectile at the time
            // TODO
            rocketFlying = !rocketFlying;
            EventService.add(new EventService.SIEvent(Type.ROCKET_LAUNCHED, null));
        }
    }

    // ---------- Getters for GUI -------------------------

    // This is for keyboard input. Must get gun to be able to set direction and fire
    // See SpaceInvGUI, keyPresses an keyReleased
    /*public XXX getGun() {
        return null;   // TODO
    }*/

    // This is for GUI, get all objects to move
    public List<IDrawable> getMovables() {
        return null; // TODO Collections.unmodifiableList("all things that move");  MUST use this
    }

    // Get ground
    public IDrawable getGround() {
        return null;   // TODO
    }

    public int getPoints() {
        return points;
    }
}
