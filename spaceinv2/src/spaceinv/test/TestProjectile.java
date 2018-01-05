package spaceinv.test;

import spaceinv.model.AbstractCopyableObject;

public class TestProjectile extends AbstractCopyableObject {

    public TestProjectile(){
        super(0,0,5,5,0,0);
    }

    @Override
    public void move() { // Only to look like Update #1.01
        //setY(getMinY() = getMinY() - 1);
    }
}
