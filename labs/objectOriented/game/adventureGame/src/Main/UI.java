package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class UI {

    public int i = 1;
    public boolean isGearEquipped = false;
    public boolean isGojoDefeated = false;
    public boolean hasWeapon = false;
    // public boolean isGearEquipped = false;

    int windowWidth = 1300;
    int windowHeight = 950;
    int bgWidth = windowWidth - 100;
    int bgHeight = 600;

    int houseObjX = bgWidth - 400;
    int houseObjY = bgHeight - 300;

    Hashtable<String, String> imagePaths;

    // Game manager
    GameManager gm;

    // window
    JFrame window;

    public JTextArea messageText;

    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];

    // Player UI
    JPanel lifePanel;
   public JLabel lifeLabel[] = new JLabel[6];
    JPanel inventoryPanel;
    public JLabel weaponLabel, gearLabel;

    public UI(GameManager gm) {
        this.gm = gm;
        createImagePaths();
        createMainField();
        // createBackground(1,imagePaths.get("bgImg"));
        generateScreen();
        createPlayerField();
        // createObject(); f

        window.setVisible(true);
    }

    public void createPlayerField() {

        lifePanel = new JPanel();
        lifePanel.setBounds(50, 0, 250, 50);
        lifePanel.setBackground(Color.black);
        lifePanel.setLayout(new GridLayout(1, 5));
        window.add(lifePanel);

        ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource(imagePaths.get("lifeIcon")));

        while (i < 6) {

            lifeLabel[i] = new JLabel();
            lifeLabel[i].setIcon(lifeIcon);
            if (i != 1) {
                lifeLabel[i].setVisible(false);
            }
            lifePanel.add(lifeLabel[i]);
            i++;
        }
        i = 2;

        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(850, 0, 100, 50);
        inventoryPanel.setBackground(Color.black);
        inventoryPanel.setLayout(new GridLayout(1, 3));
        window.add(inventoryPanel);

        // create items
        weaponLabel = new JLabel();

        ImageIcon swordIcon = new ImageIcon(getClass().getClassLoader().getResource(imagePaths.get("swordIcon")));

        gearLabel = new JLabel();
        ImageIcon gearIcon = new ImageIcon(getClass().getClassLoader().getResource(imagePaths.get("gearIcon")));

        weaponLabel.setIcon(swordIcon);
        gearLabel.setIcon(gearIcon);

        weaponLabel.setVisible(false);
        gearLabel.setVisible(false);

        inventoryPanel.add(weaponLabel);
        inventoryPanel.add(gearLabel);

    }

    public void createImagePaths() {

        imagePaths = new Hashtable<String, String>();

        imagePaths.put("bg1", "res/bg.png");
        imagePaths.put("bg2", "res/bg2.png");
        imagePaths.put("bg3", "res/bg3.png");
        imagePaths.put("house", "res/houseLogo.png");
        imagePaths.put("chest", "res/chest.png");
        imagePaths.put("gojo", "res/gojo.png");
        imagePaths.put("lifeIcon", "res/lifeIcon.png");
        imagePaths.put("arrowIcon", "res/arrow.png");
        imagePaths.put("swordIcon", "res/swordIcon.png");
        imagePaths.put("gearIcon", "res/gearIcon.png");
        imagePaths.put("arrowIconRight", "res/arrowRight.png");
        imagePaths.put("flyingGear", "res/flyingGear.png");

    }

    public void createMainField() {

        window = new JFrame();
        window.setSize(windowWidth, windowHeight);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        // text area for message
        messageText = new JTextArea("Welcome To Protag Slayer");
        messageText.setBounds(50, 700, bgWidth, 150);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.white);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("DejaVu Sans", Font.PLAIN, 29));
        window.add(messageText);

    }

    public void createBackground(int bgNum, String bgFileName) {

        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(50, 50, bgWidth, bgHeight);
        bgPanel[bgNum].setBackground(Color.black);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, bgWidth, bgHeight);
        try {

            // System.out.println(System.getProperty("user.dir"));

            // BufferedImage image =
            // ImageIO.read(UI.class.getClassLoader().getResourceAsStream("res/bg.png"));
            // ImageIcon bgIcon = new ImageIcon(image);

            ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));

            bgLabel[bgNum].setIcon(bgIcon);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public void wallClimber() {

        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem menuItem = new JMenuItem("climb");

        menuItem.addActionListener(gm.aHandler);
        menuItem.setActionCommand("climb");
        popupMenu.add(menuItem);

        JLabel testoLabel = new JLabel();

        // testoLabel.setBackground(Color.red);
        // ImageIcon objectIcon = new ImageIcon(
        // getClass().getClassLoader().getResource("res/bg.png") );

        // testoLabel.setIcon(objectIcon);

        testoLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenu.show(testoLabel, e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

        });

        testoLabel.setBounds(0, 0, bgWidth, 250);
        testoLabel.setVisible(true);
        bgPanel[2].add(testoLabel);

    }

    public void createObject(int bgNum, int objX, int objY, int objW, int objH, String objFileName, String choice1,
            String choice2, String choice3, String choice1Command, String choice2Command, String choice3Command) {

        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem menuItem[] = new JMenuItem[4];

        menuItem[1] = new JMenuItem(choice1);
        menuItem[1].addActionListener(gm.aHandler);
        menuItem[1].setActionCommand(choice1Command);
        popupMenu.add(menuItem[1]);

        menuItem[2] = new JMenuItem(choice2);
        menuItem[2].addActionListener(gm.aHandler);
        menuItem[2].setActionCommand(choice2Command);
        popupMenu.add(menuItem[2]);

        menuItem[3] = new JMenuItem(choice3);
        menuItem[3].addActionListener(gm.aHandler);
        menuItem[3].setActionCommand(choice3Command);
        popupMenu.add(menuItem[3]);

        JLabel objectLabel = new JLabel();
        // objectLabel.setBounds(houseObjX-100,houseObjY - 145,400,400);
        objectLabel.setBounds(objX, objY, objW, objH);

        // objectLabel.setBackground(Color.red);
        ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
        objectLabel.setIcon(objectIcon);

        objectLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {

                    popupMenu.show(objectLabel, e.getX(), e.getY());

                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

        });

        bgPanel[bgNum].add(objectLabel);

    }

    public void createArrowButton(int bgNum, int x, int y, int width, int height, String arrowFileName,
            String command) {
        ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));

        JButton arrowButton = new JButton();
        arrowButton.setBounds(x, y, width, height);
        arrowButton.setBackground(null);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(arrowIcon);
        arrowButton.addActionListener(gm.aHandler);
        arrowButton.setActionCommand(command);
        arrowButton.setBorderPainted(false);

        bgPanel[bgNum].add(arrowButton);

    }

    public void generateScreen() {

        createBackground(1, imagePaths.get("bg1"));
        createObject(1, houseObjX, houseObjY, 400, 400, imagePaths.get("house"), "Look", "Talk", "Rest", "lookHouse",
                "talkHouse", "restHouse");
        createObject(1, houseObjX - 325, houseObjY + 80, 200, 200, imagePaths.get("chest"), "Look", "Talk",
                "Get Weapon", "lookChest", "talkChest", "openChest");
        createObject(1, 100, houseObjY - 100, 300, 400, imagePaths.get("gojo"), "Look", "Talk", "Attack", "lookGojo",
                "talkGojo", "attackGojo");

        createArrowButton(1, 0, 250, 100, 100, imagePaths.get("arrowIcon"), "goScene2");

        bgPanel[1].add(bgLabel[1]);

        // Screen 2
        createBackground(2, imagePaths.get("bg2"));
        wallClimber();
        createObject(2, houseObjX + 80, houseObjY + 80, 200, 200, imagePaths.get("flyingGear"), "Look", "Talk",
                "Equip Gear", "lookGear", "talkGear", "equipGear");

        createArrowButton(2, bgWidth, 300, 100, 100, imagePaths.get("arrowIconRight"), "goScene2");

        bgPanel[2].add(bgLabel[2]);

        // Screen 3

        createBackground(3, imagePaths.get("bg3"));
        bgPanel[3].add(bgLabel[3]);

    }

}