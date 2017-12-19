package spaceinv.model;

public abstract class AbstractGameObject implements IDrawable{ // Only Drawable object... Sub-classes has to implement Shoot-able or Move-able individually...
    double height, width, x, y;
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
