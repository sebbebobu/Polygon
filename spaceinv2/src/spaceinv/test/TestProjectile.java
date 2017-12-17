package spaceinv.test;

import spaceinv.model.IDrawable;
import spaceinv.model.IMovable;

public class TestProjectile implements IMovable, IDrawable {
    double x;
    double y;
    double dX;
    double dY;
    double height;
    double width;

    public TestProjectile(){

    }
    @Override
    public void move() {
        y++;
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
}
