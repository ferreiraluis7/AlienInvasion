import gameobjects.GameObjects;
import gameobjects.hostages.Hostage1;
import gameobjects.hostages.Hostage2;
import gameobjects.hostages.Hostage3;
import graphics.Grid;
import graphics.GridTypes;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.TimeUnit;

public class Game implements MouseHandler, KeyboardHandler {
    public static final int numberOfAliens = 27;
    public static final int numberOfHostages = 3;
    public static final int gameWidth = 800;
    public static final int gameHeight = 600;
    private Grid grid;
    private Player player;
    private GameObjects[] objects;
    private Mouse sight;
    private Keyboard keyboard;
    private Picture sightCross;
    private int sightX;
    private int sightY;
    private boolean isInMenu = true;
    private int timeCounter = 0;




    public void init() {
        this.player = new Player();
        this.grid = new Grid();
        this.objects = new GameObjects[numberOfAliens + numberOfHostages];
        generateGameObjects();
        generateKeyboard();
    }

    public void start() throws InterruptedException {
        TinySound.init();
        SoundPlayer.playMusic(2);



        int asd = 1;
        grid.generate(GridTypes.INITIAL);
        grid.getRepresentation().draw();
        Text text = new Text(300 ,300,"Intro");
        text.setColor(Color.BLUE);
        text.draw();
        TimeUnit.SECONDS.sleep(3);


        grid.getRepresentation().delete();
        grid.generate(GridTypes.INITIAL);
        grid.getRepresentation().draw();

        while (isInMenu){
            TimeUnit.MILLISECONDS.sleep(15);
        }

        grid.getRepresentation().draw();
        Text text2 = new Text(300 ,300,"MENU");
        text2.setColor(Color.RED);
        text2.draw();
        generateMouse();

    }



    public void generateGameObjects(){

        for(int i = 0 ; i < objects.length; i++) {
            if(i == numberOfAliens) {
                objects[i] = new Hostage1();

            } else if(i == numberOfAliens + 1) {
                objects[i] = new Hostage2();

            } else if (i == numberOfAliens +2){
                objects[i] = new Hostage3();

            } else {
                objects[i] = AlienFactory.generateAlien();
            }
        }
    }

    public void setTimer(int time) {
        while(timeCounter!= time) {
            timeCounter++;
        }
    }

    public void generateMouse() {
        this.sight = new Mouse(this);
        this.sightCross = new Picture(0,0, "resources/images/game/cursor.png");
        sightCross.draw();
        sight.addEventListener(MouseEventType.MOUSE_CLICKED);
        sight.addEventListener(MouseEventType.MOUSE_MOVED);
    }

    public void generateKeyboard() {
        this.keyboard = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_SPACE);
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(event);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        SoundPlayer.playSound();

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        this.sightX = (int) mouseEvent.getX();
        this.sightY = (int) mouseEvent.getY();

        if((mouseEvent.getX() < sightCross.getWidth()/2 || mouseEvent.getX() > gameWidth - sightCross.getWidth()/2 ) && (mouseEvent.getY() < (sightCross.getHeight()/2) + 23 || mouseEvent.getY() > gameHeight)){ //canvas bar has 23 pixels
            sightCross.translate(0,0);
        } else if (mouseEvent.getX() < sightCross.getWidth()/2 || mouseEvent.getX() > gameWidth - sightCross.getWidth()/2 ) {
            sightCross.translate(0,mouseEvent.getY() - sightCross.getHeight() - sightCross.getY());
        } else if (mouseEvent.getY() < sightCross.getHeight() || mouseEvent.getY() > gameHeight) {
            sightCross.translate(mouseEvent.getX() - sightCross.getWidth()/2  - sightCross.getX(), 0);
        } else {
            sightCross.translate(mouseEvent.getX() - sightCross.getWidth()/2  - sightCross.getX(), mouseEvent.getY() - sightCross.getHeight() - sightCross.getY());
        }

    }

    @Override
    public void keyPressed(KeyboardEvent e) {


    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        if(grid.getType()==GridTypes.INITIAL){
            grid.getRepresentation().delete();
            grid.generate(GridTypes.INITIAL);
            isInMenu = false;
            keyboard = null;
        }

    }

    public GameObjects[] getObjects() {
        return objects;
    }

    public Mouse getSight() {
        return sight;
    }
}
