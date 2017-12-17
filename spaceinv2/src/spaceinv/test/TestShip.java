package spaceinv.test;

import spaceinv.model.IDrawable;
import spaceinv.model.IMovable;

public class TestShip implements IDrawable,IMovable {
    @Override
    public double getMinX() {
        return -1;
    }

    @Override
    public double getMinY() {
        return -1;
    }

    @Override
    public double getWidth() {
        return -1;
    }

    @Override
    public double getHeight() {
        return -1;
    }

    @Override
    public void move() {

    }

    @Override
    public void setDx(double dx) {

    }

    @Override
    public void setDy(double dy) {

    }

    @Override
    public double getDx() {
        return -1;
    }

    @Override
    public double getDy() {
        return -1;
    }
}