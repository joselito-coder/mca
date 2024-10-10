package Event;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Main.GameManager;

public class Event01 {
    GameManager gm;

    public Event01(GameManager gm) {
        this.gm = gm;
    }

    public void climb() {
        if (gm.ui.isGearEquipped) {

            gm.sChanger.showScene3();

        } else {
            gm.ui.messageText.setText("cannot climb wall\nhint: to climb this high wall you need maneuvering gear");
        }

    }

    public void setPrompt(String text) {

        gm.ui.messageText.setText(text);

    }

    public void lookHouse() {

        setPrompt("This is your comfy house.");
    }

    public void talkHouse() {

        setPrompt("You can't talk to a house now can ya?");
    }

    public void restHouse() {

        setPrompt("You have rested\n\n( You have gained life )");
        if (gm.ui.i < 6) {
            gm.ui.lifeLabel[gm.ui.i].setVisible(true);
            gm.ui.i++;
        }

    }

    public void lookChest() {

        setPrompt("You LOOk inside a chest...\nthere is a weapon in there");

    }

    public void talkChest() {
        setPrompt("The chest whispers to you...\n( take this weapon and defeat kitkat kun)");

    }

    public void openChest() {
        setPrompt("You have acquired the weapon Playful Cloud");
        gm.ui.hasWeapon = true;
        gm.ui.weaponLabel.setVisible(true);

    }

    public void lookGojo() {
        gm.playAudio(gm.yowaiMo);
        setPrompt("Gojo Looks back at you with his 'Six Eyes'");

    }

    public void talkGojo() {
        gm.playAudio(gm.yowaiMo);
        setPrompt("Gojo: YOWAII MOUUU\n( hint: you should attack gojo with playful cloud )");

    }

    public void attackGojo() {
        if (gm.ui.hasWeapon) {
            setPrompt("Kitkat kun has been defeated you can now proceed to next area");
            gm.ui.isGojoDefeated = true;

        } else {

            gm.playAudio(gm.yowaiMo);
            setPrompt("Yowai MOU\nhint: you need to have a weapon to atk satoru");
        }

    }

    public void lookGear() {
        setPrompt("You have found your wings of freedom");
    }

    public void talkGear() {
        setPrompt("what are you doing??\npeople will think you are delulu");
    }

    public void equipGear() {
        gm.playAudio(gm.sasagayo);
        gm.ui.isGearEquipped = true;
        gm.ui.gearLabel.setVisible(true);
    }

}
