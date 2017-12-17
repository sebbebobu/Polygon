package spaceinv.service;

import javafx.scene.media.AudioClip;

import java.net.URL;

/*
 *  A service, a class that can support the application with sounds
 *  (but not is part of model)
 *
 *    *** Nothing to do here ***
 */
public class SoundService {

    private static final String soundDir = "../assets/sound/";

    public static AudioClip getMusic(String fileName) {
        return getSound(fileName);
    }

    public static AudioClip getSound(String fileName){
         URL resource = SoundService.class.getResource(soundDir + fileName);
         return new AudioClip(resource.toString());
    }
}
