package spaceinv.model;

import spaceinv.projectiles.Bomb;
import spaceinv.projectiles.Rocket;
import spaceinv.service.EventService;
import spaceinv.ships.EnemyShip;
import spaceinv.statics.Ground;
import spaceinv.statics.OuterSpace;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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


    public static double timer = 0;
    // Application global constants
    public static final double WIDTH = 800;    // Size of window
    public static final double HEIGHT = 400;

    // The model
    private static OuterSpace outerSpace;
    private static Ground ground;
    private static Gun gun;
    private static List<EnemyShip> ships;
    private static List<AbstractMovableObject> movables = new ArrayList<>();

    // Administrative things

    private boolean rocketFlying;  // Just one rocket at the time
    private int points;            // Player points
    private Random rand = new Random();

    public SpaceInv(OuterSpace outerSpace, Ground ground, Gun gun, List<EnemyShip> ships) {
        SpaceInv.outerSpace = outerSpace;
        SpaceInv.ground = ground;
        SpaceInv.gun = gun;
        SpaceInv.ships = ships;
        movables.add(gun);
        movables.addAll(ships);

    }

    // ------ Game loop (call by timer) -----------------

    public void update() {
        // TODO this is the game loop, i.e move things and check collisions, called by timer (see GUI)
        timer++;
        List<AbstractMovableObject> amoRemoval = new ArrayList<>();
        List<AbstractMovableObject> amoAdding = new ArrayList<>();
        for (AbstractMovableObject m : movables){
            if(m instanceof EnemyShip)
            {
                if(rand.nextInt(100) == 50){
                    Bomb b = ((EnemyShip) m).fire();
                    b.setDy(2);
                    amoAdding.add(b);
                }
                if(ground.intersects(m)) {
                    EventService.add(new EventService.SIEvent(Type.SHIP_HIT_GROUND,m));
                }
                else{
                    if(timer < 60){
                        m.setDx(2.5);
                        m.setDy(0);
                    }
                    else if(180 <= timer && timer < 240){
                        m.setDx(0);
                        m.setDy(1.5);
                    }
                    else if(240 <= timer && timer < 420)
                    {
                        m.setDx(-2.5);
                        m.setDy(0);
                    }
                    else if(420 <= timer && timer < 480)
                    {
                        m.setDx(0);
                        m.setDy(1.5);
                    }
                    else if(480 == timer)
                    {
                        m.setDx(2.5);
                        m.setDy(0);
                        timer = 0;
                    }
                    m.move();
                }
            }
            else if(m instanceof Gun) {
                if (m.getMinX() >= 0 && (m.getMinX() + m.getWidth() < WIDTH))
                    m.move();
            }
            else if(m instanceof Bomb)
            {
                if(ground.intersects(m)) {
                    EventService.add(new EventService.SIEvent(Type.BOMB_HIT_GROUND,m));
                    amoRemoval.add(m);
                }
                else if(gun.intersect(m)){
                    EventService.add(new EventService.SIEvent(Type.BOMB_HIT_GUN,m));
                    amoRemoval.add(m);
                }
                else
                    m.move();
            }
            else if(m instanceof Rocket)
            {
                for (AbstractMovableObject ab: movables) {
                    if(ab instanceof EnemyShip){
                        if(m.intersect(ab))
                        {
                            EventService.add(new EventService.SIEvent(Type.ROCKET_HIT_SHIP,m));
                            points += 100;
                            amoRemoval.add(ab);
                            amoRemoval.add(m);
                            rocketFlying = false;
                        }
                    }
                    if(outerSpace.intersect(m))
                    {
                        amoRemoval.add(m);
                        rocketFlying = false;
                    }

                }
                m.move();
            }
            //if (!ground.intersects(m) && !outerSpace.intersects(m) && m.getMinX()>=0 && (m.getMinX() + m.getWidth() < WIDTH) && (m.getMinY()+m.getHeight() < HEIGHT) && m.getMinY() >= 0)
            //    m.move();
        }
        movables.addAll(amoAdding);
        movables.removeAll(amoRemoval);
    }


    public void fireGun() {
        if (!rocketFlying) {    // Just one projectile at the time
            Rocket r = gun.fire();
            movables.add(r);
            rocketFlying = !rocketFlying;
            EventService.add(new EventService.SIEvent(Type.ROCKET_LAUNCHED, r));
        }
    }

    // ---------- Getters for GUI -------------------------

    // This is for keyboard input. Must get gun to be able to set direction and fire
    // See SpaceInvGUI, keyPresses an keyReleased
    public Gun getGun() {
        return gun;   
    }

    // This is for GUI, get all objects to move
    public List<IDrawable> getMovables() {
        List<IDrawable> tmp = new ArrayList<>();
        tmp.addAll(movables);
        return tmp;
    }

    // Get ground
    public IDrawable getGround() {
        return ground;
    }

    public int getPoints() {
        return points;
    }
}
