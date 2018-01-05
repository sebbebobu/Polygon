package spaceinv.ships;

import spaceinv.model.AbstractMovableObject;
import spaceinv.model.IShootable;
import spaceinv.projectiles.Bomb;

public class EnemyShip extends AbstractMovableObject implements IShootable<Bomb> {

    public EnemyShip(double x, double y, double width, double height, double dx, double dy) {
        super(x, y, width, height, dx, dy);
    }

    private Bomb bomb;

    @Override
    public void move() {
        setY(getMinY() + getDy());
        setX(getMinX() + getDx());
    }

    @Override
    public Bomb fire() {
        Bomb b = bomb.copyOf();
        b.setX((this.getMinX()+(this.getWidth()/2)) - b.getWidth()/2);
        b.setY(this.getMinY()+this.getHeight());
        return b;
    }

    @Override
    public void setProjectile(Bomb projectile) {
        this.bomb = projectile;
    }
}
