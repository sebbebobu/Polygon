package spaceinv.model;

public abstract class AbstractMovableObject extends AbstractGameObject implements IMovable {
    public double dx, dy;
    public AbstractMovableObject(double x, double y, double width, double height, double dx, double dy) {
        super(x,y, width, height);
        this.dx = dx;
        this.dy = dy;
    }
    @Override
    public  void move()
    {
        //x++; // Move ship left to right.

        // Correct way to move ship WITH WORKING INPUTS ... I think.
        setY(getMinY() + getDy());
        //this.setY(this.getMinY() + this.getDy());

    }

    @Override
    public void setDx(double dx) { this.dx = dx; }

    @Override
    public void setDy(double dy) { this.dy = dy; }

    @Override
    public double getDx() { return dx; }

    @Override
    public double getDy() { return dy; }
}
