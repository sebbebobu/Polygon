package spaceinv.model;

public class Gun extends AbstractShootableObject {
    @Override
    public void move() { // Necessary override b/c Gun should only move in x-direction.
        x++; // Move ship left to right.
        // Correct way to move ship WITH WORKING INPUTS ... I think.
        //this.x += this.dX;
    }
}
