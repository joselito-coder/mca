package Main;

import Event.Event01;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameManager{

    ActionHandler aHandler = new ActionHandler(this);

    public UI ui = new UI(this);
    public SceneChanger sChanger = new SceneChanger(this);

    public Event01 ev = new Event01(this);
    

    public URL yowaiMo = getClass().getClassLoader().getResource("res/audio/yowaimo.wav");
    public URL sasagayo = getClass().getClassLoader().getResource("res/audio/sasagayo.wav");
    public URL rick = getClass().getClassLoader().getResource("res/audio/rick.wav");

    
    Clip clip;

    public void playAudio(URL file) {

        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);

            clip.setFramePosition(0);
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }

    }



    public static void main(String args[]){

        new GameManager();

    }

    public GameManager(){

    }


}