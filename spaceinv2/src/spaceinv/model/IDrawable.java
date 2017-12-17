package spaceinv.model;

/*
   Contract for anything that can be drawn on screen
   This must be fulfilled by any object the GUI shall render
 */
public interface IDrawable {
    double getMinX();      // MinX and Y is upper left corner (y-axis pointing donw)

    double getMinY();

    double getWidth();

    double getHeight();

}
