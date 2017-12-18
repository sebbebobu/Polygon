package spaceinv.test;

import spaceinv.model.IDrawable;
import spaceinv.model.IMovable;
import spaceinv.model.IShootable;

public class TestShip implements IDrawable,IMovable,IShootable {
    private double x;
    private double y;
    private double width;
    private double height;
    private double dx;
    private double dy;

    public TestShip(){
        x = 0;
        y = 150;
        width = 40;
        height = 108;
    }
    @Override
    public double getMinX() {
        return x;
    }
    @Override
    public double getMinY() {
        return y;
    }
    @Override
    public double getWidth() {
        return width;
    }
    @Override
    public double getHeight() {
        return height;
    }
    @Override
    public void move() {
        x++; // Move ship left to right.

        // Correct way to move ship WITH WORKING INPUTS ... I think.
        /*
        x += dX;
        y += dY;
        if(dX != 0)dX--;
        if(dY != 0)dY--;
        */
    }
    @Override
    public void setDx(double dx) {
        this.dx = dx;
    }
    @Override
    public void setDy(double dy) {
        this.dy = dy;
    }
    @Override
    public double getDx() {
        return dx;
    }
    @Override
    public double getDy() {
        return dy;
    }
    @Override
    public Object fire() {
        TestProjectile t = new TestProjectile();
        t.x = (this.getMinX()+(this.getWidth()/2)) - t.getWidth()/2; // Correct way for x-value - but x should be inaccessible.
        t.y = this.getMinY(); // Temporary - y should be inaccessible.
        return t;
    }
    @Override
    public void setProjectile(Object projectile) {
        if (projectile.getClass().equals(TestProjectile.class)){
            ((TestProjectile) projectile).setDx((this.getMinX() + (this.getWidth() / 2)) - (((TestProjectile) projectile).getWidth() / 2));
            ((TestProjectile) projectile).setDy(this.getMinY());
        }
    }
}