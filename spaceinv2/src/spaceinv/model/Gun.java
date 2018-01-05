package spaceinv.model;

import spaceinv.projectiles.Rocket;

public class Gun extends AbstractMovableObject implements IShootable<Rocket> {
    public Gun(double x, double y, double width, double height, double dx, double dy) {
        super(x, y, width, height, dx, dy);
    }

    private Rocket rocket;

    @Override
    public void move() { // Necessary override b/c Gun should only move in x-direction.
        //x++; // Move ship left to right.
        // Correct way to move ship WITH WORKING INPUTS ... I think.
        this.setX(this.getMinX()+this.getDx());
    }

    @Override
    public void setProjectile(Rocket projectile) {
        this.rocket = projectile;
    }

    @Override
    public Rocket fire() {
        Rocket r = rocket.copyOf();
        r.setX((this.getMinX()+(this.getWidth()/2)) - r.getWidth()/2);
        r.setY(this.getMinY());
        return r;
    }
}
