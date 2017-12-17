package spaceinv.model;

/*
   Contract for anything that can move
 */
public interface IMovable {

    void move();            // The movement

    void setDx(double dx);    // Set horizontal speed

    void setDy(double dy);   // Set vertical speed

    double getDx();     // Get horizontal speed

    double getDy();    // Get vertical speed

}
