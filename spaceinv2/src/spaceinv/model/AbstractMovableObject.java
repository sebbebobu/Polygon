package spaceinv.model;

public abstract class AbstractMovableObject extends AbstractGameObject implements IMovable {
    private double dx, dy;

    @Override
    public void move() {
        x++; // Move ship left to right.

        // Correct way to move ship WITH WORKING INPUTS ... I think.
        //this.x += this.getDx;
        //this.y += this.getDy;

        //if(this.getDx > 0)this.setDx(this.getDx()--); // Fixed, now handles negative numbers.
        //if(this.getDy > 0)this.setDy(this.getDy()--);
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
