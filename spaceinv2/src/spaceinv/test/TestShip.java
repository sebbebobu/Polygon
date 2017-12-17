package spaceinv.test;

import spaceinv.model.IDrawable;
import spaceinv.model.IMovable;
import spaceinv.model.IShootable;

public class TestShip implements IDrawable,IMovable,IShootable {
    private double x = 0;
    private double y = 150;
    private double width = 40;
    private double height = 108;
    private double dX;
    private double dY;

    public TestShip(){

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
        dX = dx;
    }
    @Override
    public void setDy(double dy) {
        dY = dy;
    }
    @Override
    public double getDx() {
        return dX;
    }
    @Override
    public double getDy() {
        return dY;
    }
    @Override
    public Object fire() {
        TestProjectile t = new TestProjectile();
        t.x = (this.getMinX()+(this.getWidth()/2)) - t.width/2; // Correct way for x-value - but x should be inaccessible.
        t.y = this.getMinY();
        return t;
    }
    @Override
    public void setProjectile(Object projectile) {
        if (projectile.getClass().equals(TestProjectile.class)){
            ((TestProjectile) projectile).setDx((this.getMinX() + (this.getWidth() / 2)) - (((TestProjectile) projectile).width / 2));
            ((TestProjectile) projectile).setDy(this.getMinY());
        }
    }
}