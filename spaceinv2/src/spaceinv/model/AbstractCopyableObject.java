package spaceinv.model;

public abstract class AbstractCopyableObject extends AbstractMovableObject implements ICopyable{
    @Override
    public Object copyOf() {
        return this; // Should return exact copy of itself.
    }
}
