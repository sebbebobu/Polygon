package spaceinv.test;

import spaceinv.model.ICopyable;
import spaceinv.model.IDrawable;
import spaceinv.model.IMovable;

public class TestProjectile implements IMovable, IDrawable, ICopyable {
    double x;                   // Should be private, but is used in TestShip.
    double y;                   //                  - '' -
    private double dx = 0;
    private double dy = 0;
    private double height = 5;
    private double width = 5;   // Now fixed.

    public TestProjectile(){

    }
    @Override
    public void move() {
        y--;
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
