package spaceinv.service;


import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/*
     Service to handle events **from model** to GUI
     GUI must know if there has been a collision in the model etc.

     NOTE: Events from GUI to model handled by JavaFX event keyboard listeners etc.

     *** Nothing to do here ****

 */
public class EventService {

    public enum Type {
        NONE,               // All events so far
        BOMB_HIT_GUN,
        BOMB_HIT_GROUND,
        ROCKET_HIT_SHIP,
        SHIP_HIT_GROUND,
        ROCKET_LAUNCHED
    }

    // Used to send event objects from model to GUI
    // This is an inner class because it belong very close to EventService
    // Don't need to fully understand
    public static class SIEvent {

        public final Type type;
        public final Object data;

        public SIEvent(Type type, Object data) {
            this.type = type;
            this.data = data;
        }

        @Override
        public String toString() {
            return type.toString();
        }
    }

    // Reuse same event (if no other event return this)
    private static final SIEvent none = new EventService.SIEvent(Type.NONE, null);
    // Store all incoming events
    private static final List<SIEvent> events = new ArrayList<>();
    private static boolean debug = false;

    public static void add(SIEvent evt) {
        events.add(evt);
        if (debug) {             // Useful for tracing
            out.println(events);
        }
    }

    // Remove and return event
    public static SIEvent remove() {
        if (events.size() > 0) {
            return events.remove(0);
        } else {
            return none;
        }
    }

}
