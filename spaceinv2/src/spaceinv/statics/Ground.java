package spaceinv.statics;

import spaceinv.model.AbstractGameObject;

public class Ground extends AbstractGameObject {

    public Ground(double x, double y, double width, double height) {
        super(x,y,width,height);
    }
    public boolean intersects(AbstractGameObject object) {
        if (object == null) {
            return false;
        }
        return ((object.getMinY()+object.getHeight()) > this.getMinY());
    }

}
