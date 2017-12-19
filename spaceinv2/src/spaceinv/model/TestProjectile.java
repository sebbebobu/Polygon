package spaceinv.model;

public class TestProjectile extends AbstractCopyableObject{

    public TestProjectile(){
        height = 5;
        width = 5;
    }

    @Override
    public void move() { // Only to look like Update #1.01
        y--;
    }
}
