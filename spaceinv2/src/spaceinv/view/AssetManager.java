package spaceinv.view;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import spaceinv.model.IDrawable;
import spaceinv.service.ImageService;
import spaceinv.service.SoundService;

import java.util.HashMap;
import java.util.Map;

import static spaceinv.model.SpaceInv.HEIGHT;
import static spaceinv.model.SpaceInv.WIDTH;

/*
   Class loading and holding assets

   *** Nothing to do here ***
*/


public class AssetManager {

    private static final Map<String, Image> images = new HashMap<>();
    private static final Map<String, AudioClip> sounds = new HashMap<>();

    // This is run at class loading time (before any statics created)
    static {
        images.put("flame", ImageService.getImage("flame.png", 18, 37));
        images.put("explosion", ImageService.getImage("explosion.png", 40, 40));
        images.put("explosion2", ImageService.getImage("explosion2.png", 40, 40));
        images.put("background", ImageService.getImage("background.png", WIDTH, HEIGHT, false));
        sounds.put("rocket", SoundService.getSound("rocket.wav"));
        sounds.put("explosion1", SoundService.getSound("explosion1.wav"));
        sounds.put("explosion2", SoundService.getSound("explosion2.wav"));
        sounds.put("music", SoundService.getSound("spacemusic.wav"));
    }

    public static AudioClip getSound(String key) {
        return sounds.get(key);
    }

    // Get any image
    public static Image getImage(String key) {
        return images.get(key);
    }

    // Get image matching some object type (class)
    // NOTE: Names of image files must match class names (in lowercase)
    // Image file name = o.getClass().getSimpleName().toLowerCase() + ".png"

    public static Image getImageForObject(IDrawable o) {
        String name = o.getClass().getSimpleName().toLowerCase();
        if (!images.containsKey(name)) {
            Image i = ImageService.getImage(name + ".png", o.getWidth(), o.getHeight(), true);
            images.put(name, i);
        }
        // TODO Throw
        return images.get(name);
    }
}
