package spaceinv.model;

public abstract class AbstractGameObject implements IDrawable{ // Only Drawable object... Sub-classes has to implement Shoot-able or Move-able individually...
    private double height, width, x, y;

    public AbstractGameObject(double x, double y, double width, double height) {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }
    public boolean intersect(AbstractGameObject enemyShip){
        return ((enemyShip.getMinX() <= (this.getMinX() + this.getHeight())) && ((enemyShip.getMinX() + enemyShip.getWidth()) >= this.getMinX())) && ((enemyShip.getMinY() < (this.getMinY() + this.getHeight())) && ((enemyShip.getMinY() + enemyShip.getHeight()) > this.getMinY()));
    }
    @Override
    public double getMinX() {
        return x;
    }

    @Override
    public double getMinY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
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
