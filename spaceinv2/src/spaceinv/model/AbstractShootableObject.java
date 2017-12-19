package spaceinv.model;

public abstract class AbstractShootableObject extends AbstractMovableObject implements IShootable {
    @Override
    public Object fire() {
        TestProjectile t = new TestProjectile();
        t.x = (this.getMinX()+(this.getWidth()/2)) - t.getWidth()/2; // Correct way for x-value - but x should be inaccessible.
        t.y = this.getMinY(); // Temporary - y should be inaccessible.
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
