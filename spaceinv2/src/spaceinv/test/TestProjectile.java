package spaceinv.test;

import spaceinv.model.ICopyable;
import spaceinv.model.IDrawable;
import spaceinv.model.IMovable;

public class TestProjectile implements IMovable, IDrawable, ICopyable {
    double x;                   // Should be private, but is used in TestShip.
    double y;                   //                  - '' -
    private double dX = 0;
    private double dY = 0;
    private double height = 5;
    double width = 5;           //                  - '' -

    public TestProjectile(){

    }
    @Override
    public void move() {
        y--;
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
    public Object copyOf() {
        return this; // Should return exact copy of itself.
    }
}
