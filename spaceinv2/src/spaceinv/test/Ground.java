package spaceinv.test;

import spaceinv.model.IDrawable;

public class Ground implements IDrawable {
    private double height;
    private double width;
    private double x;
    private double y;
    public Ground(int x, int y, int width, int height) {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }
    public void intersects(){

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
