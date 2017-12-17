package spaceinv.test;

import spaceinv.model.IDrawable;

public class Ground implements IDrawable {
    public double height;
    public double width;
    public double x;
    public double y;
    public Ground(int ground_x, int ground_y, int ground_width, int ground_Height) {
        height = ground_Height;
        width = ground_width;
        x = ground_x;
        y = ground_y;
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
