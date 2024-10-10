package Main;

public class SceneChanger {
    GameManager gm;

    public SceneChanger(GameManager gm) {

        this.gm = gm;

    }

    public void showScene1() {

        gm.ui.bgPanel[1].setVisible(true);
        gm.ui.bgPanel[2].setVisible(false);

    }

    public void showScene2() {

        if (gm.ui.isGojoDefeated) {

            gm.ui.messageText.setText("Gotta climb Em all");

            gm.ui.bgPanel[1].setVisible(false);
            gm.ui.bgPanel[3].setVisible(false);
            gm.ui.bgPanel[2].setVisible(true);
        }
        else{
            gm.ui.messageText.setText("You need to defeat Kitkat kun before proceeding");
        }

    }

    public void showScene3() {

        gm.ui.messageText.setText("Congratulation on finishing the quest");


        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);

        gm.ui.bgPanel[3].setVisible(true);
        gm.playAudio(gm.rick);

    }

}
