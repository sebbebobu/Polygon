package spaceinv.test;

import spaceinv.model.IDrawable;
import spaceinv.model.IMovable;
import spaceinv.model.IShootable;

public class TestShip implements IDrawable,IMovable,IShootable {
    public double x;
    public double y;
    public double width;
    public double height;
    public double dX;
    public double dY;

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
        return new TestProjectile();
    }
    @Override
    public void setProjectile(Object projectile) {

    }
}