package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    GameManager gm;

    public ActionHandler(GameManager gm){

        this.gm = gm;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String choice = e.getActionCommand();

        // System.out.println(choice);

        switch (choice) {

            case "lookHouse":
                gm.ev.lookHouse();
                
                
                break;
 
            case "talkHouse":
                gm.ev.talkHouse();

                
                break;
 
            case "restHouse":

                gm.ev.restHouse();
                
                break;
 
            case "lookChest":
                gm.ev.lookChest();
                
                break;
 
            case "talkChest":
                
                gm.ev.talkChest();
                break;
 
            case "openChest":
                gm.ev.openChest();
            // you have successfully acquired "Playful Cloud"
                
                break;
  
            case "lookGojo":
                gm.ev.lookGojo();
                
                break;
 
            case "talkGojo":
                gm.ev.talkGojo();
                
                break;

            case "attackGojo":
                gm.ev.attackGojo();

                break;

            // change scenes

            case "goScene1":
                gm.sChanger.showScene1();
                break;

            case "goScene2":
                gm.sChanger.showScene2();
                break;

            case "goScene3":
                gm.sChanger.showScene3();
                break;


            case "climb":
                gm.ev.climb();

            break;


            case "lookGear":
                gm.ev.lookGear();

            break;

            case "talkGear":
                gm.ev.talkGear();

            break;

            case "equipGear":
                gm.ev.equipGear();

            break;

           


       
            default:
                break;
        }

    }
    
}
