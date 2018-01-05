package spaceinv.statics;

import spaceinv.model.AbstractGameObject;

public class OuterSpace extends AbstractGameObject {

    public OuterSpace(double x, double y, double width, double height) {
        super(x,y,width,height);
    }
    public boolean intersect(AbstractGameObject object) {
        if (object == null) {
            return false;
        }
        return ((object.getMinY()+object.getHeight()) < this.getMinY());
    }

}
