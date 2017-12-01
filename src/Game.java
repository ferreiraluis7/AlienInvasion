import gameobjects.GameObjects;
import gameobjects.hostages.Hostage1;
import gameobjects.hostages.Hostage2;
import gameobjects.hostages.Hostage3;
import graphics.Grid;
import graphics.GridTypes;
import graphics.Positions;
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
    private boolean gameEnded = false;

    public void init() {
        this.player = new Player();
        this.grid = new Grid();
        this.objects = new GameObjects[numberOfAliens + numberOfHostages];
        generateGameObjects();
        generateKeyboard();
    }

    public void start() throws InterruptedException {

        generateIntroStage();

        generateMenuStage();

        generateGameStage();

    }

    private void generateIntroStage() throws InterruptedException {
        grid.generate(GridTypes.INTRO);
        grid.getRepresentation().draw();
        TimeUnit.SECONDS.sleep(3);
    }

    private void generateMenuStage() throws  InterruptedException {
        grid.getRepresentation().delete();
        grid.generate(GridTypes.MENU);
        grid.getRepresentation().draw();

        while (isInMenu){
            TimeUnit.MILLISECONDS.sleep(15);
        }
    }

    private void generateGameStage(){
        grid.getRepresentation().delete();
        grid.generate(GridTypes.MENU);
        grid.getRepresentation().draw();

        generateMouse();
    }

    private void generateGameObjects(){

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

    private void gameStage(){
        int random;
        while(!gameEnded){
            for (int i = 0; i < Positions.values().length; i++) {
                random = (int) (Math.random()*Positions.values().length);
                if(objects[random].getCurrentPosition().isOccupied()){
                    continue;
                }
                objects[random].summon();
                objects[random].getCurrentPosition().setOccupied(true);
            }
            if(checkDeadAliens()) {
                gameEnded = true;
            }

        }
    }

    private boolean checkDeadAliens() {
        for (int i = 0; i < numberOfAliens ; i++) {
            if (!objects[i].isDead()){
                return true;
            }

            if (!objects[i].isDead() && i == numberOfAliens - 1){
                return true;
            }
        }

        return false;
    }

    private void generateMouse() {
        this.sight = new Mouse(this);
        this.sightCross = new Picture(0,0, "resources/images/game/cursor.png");
        sightCross.draw();
        sight.addEventListener(MouseEventType.MOUSE_CLICKED);
        sight.addEventListener(MouseEventType.MOUSE_MOVED);
    }

    private void generateKeyboard() {
        this.keyboard = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_SPACE);
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(event);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        //shoot(target);
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
        if(grid.getType()==GridTypes.MENU){
            grid.getRepresentation().delete();
            grid.generate(GridTypes.MENU);
            isInMenu = false;
        }

    }

    public GameObjects[] getObjects() {
        return objects;
    }

    public Mouse getSight() {
        return sight;
    }
}
