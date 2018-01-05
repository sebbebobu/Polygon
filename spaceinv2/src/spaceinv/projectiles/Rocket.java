package spaceinv.projectiles;

import spaceinv.model.AbstractMovableObject;
import spaceinv.model.ICopyable;

public class Rocket extends AbstractMovableObject implements ICopyable<Rocket> {
    public Rocket(double x, double y, double width, double height, double dy) {
        super(x, y, width, height, 0, dy);
    }

    @Override
    public Rocket copyOf() {
        return this;
    }
}
