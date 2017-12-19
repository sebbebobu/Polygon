package spaceinv.model;

public class Ground extends AbstractGameObject {

    public Ground(int x, int y, int width, int height) {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }
    public boolean intersects(AbstractGameObject object) {
        if (object == null) {
            return false;
        }
        return ((object.y+object.height) > this.getMinY());
    }

}
