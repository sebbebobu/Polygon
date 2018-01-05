package spaceinv.model;

import spaceinv.test.TestProjectile;

public abstract class AbstractShootableObject extends AbstractMovableObject implements IShootable {

    public AbstractShootableObject(double x , double y, double width, double height, double dx, double dy)
    {
        super(x,y,width,height,dx,dy);
    }
    @Override
    public Object fire() {
        AbstractShootableObject t = new AbstractShootableObject(0,0,5,5,0,0) {};
        t.setX((this.getMinX()+(this.getWidth()/2)) - t.getWidth()/2);
        t.setY(this.getMinY());
        return t;
    }

    @Override
    public void setProjectile(Object projectile) {
        if (projectile.getClass().equals(TestProjectile.class)){
            ((TestProjectile) projectile).setDx((this.getMinX() + (this.getWidth() / 2)) - (((TestProjectile) projectile).getWidth() / 2));
            ((TestProjectile) projectile).setDy(this.getMinY());
        }
    }
}
