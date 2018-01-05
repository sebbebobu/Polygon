package spaceinv.model;

import spaceinv.projectiles.Bomb;
import spaceinv.projectiles.Rocket;
import spaceinv.ships.BattleCruiser;
import spaceinv.ships.Bomber;
import spaceinv.ships.EnemyShip;
import spaceinv.ships.Frigate;
import spaceinv.statics.Ground;
import spaceinv.statics.OuterSpace;

import java.util.ArrayList;
import java.util.List;

import static spaceinv.model.SpaceInv.HEIGHT;
import static spaceinv.model.SpaceInv.WIDTH;


/*
    Utility to build formations
 */
public class Factory {

    private static final double X_MARGIN = 120;   // Min x for ships
    private static final double SHIP_WIDTH = 40;  // Logical size of ships
    private static final double SHIP_HEIGHT = 30;
    private static final double X_OFFSET = 5;    // Between ships
    private static final double Y_OFFSET = 5;
    private static final double GROUND_HEIGHT = 20;

    private static final double DEFAULT_DX = 3;  // Default speed
    private static final double DEFAULT_DY = 7;



    public static SpaceInv buildModel(){


        double gunWidth = 40;
        double gunHeight = 40;

        OuterSpace os = new OuterSpace(0,0,800,5);
        Ground gr = new Ground(0,HEIGHT-GROUND_HEIGHT,WIDTH,GROUND_HEIGHT);
        Gun gun = new Gun(WIDTH/2,HEIGHT-GROUND_HEIGHT-gunHeight,gunWidth,gunHeight,0,0);


        String[] shipNames = {BattleCruiser.class.getSimpleName(), BattleCruiser.class.getSimpleName(),
                Bomber.class.getSimpleName(), Bomber.class.getSimpleName(), Frigate.class.getSimpleName()};
        List<Bomb> bombs = new ArrayList<>();

        //System.out.println(shipNames[0]); // - Actually prints out Name of object's Class!

        bombs.add(new Bomb(0, 0, 10, 10, 0)); // WTF is dis!
        gun.setProjectile(new Rocket(0,0,5,5,-10));
        List<EnemyShip> ships = Factory.buildFormation(shipNames, bombs, 2);
        return new SpaceInv(os,gr,gun,ships);

        //return null;
    }


    private static List<EnemyShip> buildFormation(String[] shipNames, List<Bomb> bombs,
                                                  int nCols){
        List<EnemyShip> ships = new ArrayList<>();
        double x = X_MARGIN;
        double y = 0;
        for (String name : shipNames) {
            for (int i = 0; i < nCols; i++) {
                EnemyShip s = getShipForName(name, x, y, SHIP_WIDTH, SHIP_HEIGHT, DEFAULT_DX, DEFAULT_DY);
                s.setProjectile(bombs.get(0));
                ships.add(s);
                x = x + SHIP_WIDTH + X_OFFSET;
            }
            x = X_MARGIN;
            y = y + SHIP_HEIGHT + Y_OFFSET;
        }
        return ships;
    }


    // Convert ship names to objects
    private static EnemyShip getShipForName(String name, double x, double y,
                                             double shipWidth, double shipHeight,
                                             double dx, double dy) {
        switch (name) {
            case "BattleCruiser":
                return new BattleCruiser(x,y,shipWidth,shipHeight,dx,dy);
            case "Frigate":
                return new Frigate(x,y,shipWidth,shipHeight,dx,dy);
            case "Bomber":
                return new Bomber(x,y,shipWidth,shipHeight,dx,dy);
            default:
                throw new IllegalArgumentException("No such ship");
        }
    }

}
