package spaceinv.projectiles;

import spaceinv.model.AbstractMovableObject;
import spaceinv.model.ICopyable;

public class Bomb extends AbstractMovableObject implements ICopyable<Bomb> {
    public Bomb(double x, double y, double width, double height,double dy) {
        super(x, y, width, height, 0, dy);
    }

    @Override
    public Bomb copyOf() {
        return new Bomb(getMinX(),getMinY(),getWidth(),getHeight(),getDy());
    }
}
