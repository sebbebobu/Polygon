package spaceinv.model;

public abstract class AbstractCopyableObject extends AbstractMovableObject implements ICopyable{
    public AbstractCopyableObject(double x, double y, double width, double height, double dx, double dy) {
        super(x, y, width, height, dx, dy);
    }

    @Override
    public Object copyOf() {
        return this; // Should return exact copy of itself.
    }
}
