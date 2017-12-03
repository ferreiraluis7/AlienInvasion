import gameobjects.GameObjects;
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

import java.util.concurrent.TimeUnit;

public class Game extends SoundPlayer implements MouseHandler, KeyboardHandler {

    public static final int numberOfAliens = 27;
    public static final int numberOfHostages = 3;

    private Grid grid;
    private Player player;
    private GameObjects[] objects;
    private Mouse sight;
    private Keyboard keyboard;
    private int sightX;
    private int sightY;
    private boolean isInMenu = true;
    private boolean gameEnded = false;
    private MovieMak3r movieMak3r;
    private Text alienShotsInfo;
    private Text hostageShotsInfo;

    public void init() {
        TinySound.init();
        this.player = new Player();
        this.grid = new Grid();
        this.objects = new GameObjects[numberOfAliens + numberOfHostages];
        generateGameObjects();
        generateKeyboard();
        movieMak3r = new MovieMak3r();
    }

    public void start() throws InterruptedException {
            generateIntroStage();

        while (true) {
            generateMenuStage();
            generateGameStage();
            gameStage();
            generateCredits();
        }
    }


    private void generateIntroStage() throws InterruptedException {
        playMusic(chooseSound.INTRO);
        grid.generate(GridTypes.INTRO);
       // grid.getRepresentation().draw();

        movieMak3r.play("resources/images/Intro/", "Intro",92,0,200);

    }

    private void generateMenuStage() throws  InterruptedException {
        resetStats();
        grid.getRepresentation().delete();
        grid.generate(GridTypes.MENU);
        grid.getRepresentation().draw();

        while (isInMenu){
            TimeUnit.MILLISECONDS.sleep(15);
        }
    }

    private void generateGameStage(){
        intro.stop();
        playMusic(chooseSound.GAMEMUSIC);
        grid.getRepresentation().delete();
        grid.generate(GridTypes.GAME);
        grid.getRepresentation().draw();
        generateInGameInfo();
        generateMouse();
    }

    private void generateCredits() throws InterruptedException{
        grid.getRepresentation().delete();
        grid.generate(GridTypes.CREDITS);
        grid.getRepresentation().draw();

        showScore();
    }

    private void showScore() throws InterruptedException{
        Text score = new Text(400,200,"--------- Score ------- \n"
                +" Killed Aliens: " + this.player.getShotsOnTarget()+"\n"
                + "Shots fired: " + this.player.getShotsFired());

        score.setColor(Color.RED);
        score.draw();

        TimeUnit.SECONDS.sleep(5);

        score.delete();
    }

    private void generateGameObjects(){
        objects = new GameObjects[numberOfHostages+numberOfAliens];

        for (int i = 0; i < objects.length ; i++) {
            objects[i] = ObjectFactory.generateObject();
        }
    }

    private void gameStage() throws InterruptedException{
        int counter = 1;
        while(!gameEnded){

            for (int i = 0; i < objects.length; i++) {
                System.out.println(i);
                System.out.println(objects[i]);
                if (objects[i].isDead()) {
                    continue;
                }
                if(counter <= 500){
                    counter += 75;
                }

                objects[i].summon();
                appear.play();
                TimeUnit.MILLISECONDS.sleep(1000 - counter);
                //TimeUnit.SECONDS.sleep(1);
                objects[i].hide();
                TimeUnit.MILLISECONDS.sleep(1000 - counter);
                //TimeUnit.SECONDS.sleep(1);


                if (checkDeadHostages() || checkDeadAliens()) {
                    gameEnded = true;
                }
            }
        }
        cleanGameStage();
        System.out.println(player.getShotsOnTarget());
        System.out.println(player.getShotsFired());
    }

    private void generateInGameInfo(){
        this.alienShotsInfo = new Text(40,176,"Aliens Killed: " + this.player.getShotsOnTarget());
        this.hostageShotsInfo = new Text(40,200,"Hostages killed: " + this.player.getShotOnHostages());
        alienShotsInfo.grow(25,15);
        alienShotsInfo.setColor(Color.RED);
        alienShotsInfo.draw();
        hostageShotsInfo.grow(25,15);
        hostageShotsInfo.setColor(Color.RED);
        hostageShotsInfo.draw();
    }

    private void updateGameInfo(){
        alienShotsInfo.setText("Aliens Killed: " + this.player.getShotsOnTarget());
        hostageShotsInfo.setText("Hostages killed: " + this.player.getShotOnHostages());
    }

    private void resetStats(){
        this.player.resetShotsOnTarget();
        this.player.resetShootsFired();
        this.player.resetShotsOnHostages();
    }

    private void cleanGameStage() {
        gameEnded = false;
        generateGameObjects();
        isInMenu = true;
        alienShotsInfo.delete();
    }

    private boolean checkDeadAliens() {

        for (int i = 0; i < objects.length ; i++) {
            if(objects[i].isAlien()){
                if (!objects[i].isDead()){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkDeadHostages(){
        boolean hostageAlive = false;
        for (int i = 0; i < objects.length; i++) {
            if(!objects[i].isAlien()){
                if(objects[i].isDead()){
                    hostageAlive = true;
                } else {
                    return false;
                }
            }
        }
            return hostageAlive;
    }

    private void shotOnTarget(){
        int objectOriginX;
        int objectOriginY;

        for (int i = 0; i < objects.length ; i++) {
            if(objects[i].isDead() || !objects[i].isVisible()){
                continue;
            }
            objectOriginX = objects[i].getCurrentPosition().getxPoint();
            objectOriginY = objects[i].getCurrentPosition().getyPoint();

            if(sightX >= objectOriginX && sightX <= objects[i].getShape().getMaxX()){
                if(sightY >= objectOriginY && sightY <= objects[i].getShape().getMaxY()){
                    dead.play();
                    objects[i].hit();
                    if(objects[i].isAlien()){
                        player.shotOnTarget();
                    } else {
                        player.shotOnHostages();
                    }
                    updateGameInfo();
                }
            }
        }
    }

    private void generateMouse() {
        this.sight = new Mouse(this);
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
    public void mouseClicked(MouseEvent mouseEvent){


    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        this.sightX = (int) mouseEvent.getX();
        this.sightY = (int) mouseEvent.getY();
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
        } else if(grid.getType()==GridTypes.GAME) {
            player.shoot();
            shotOnTarget();
        }
    }
}
