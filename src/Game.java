import gameobjects.GameObjects;
import gameobjects.hostages.Audrey;
import gameobjects.hostages.Faustino;
import gameobjects.hostages.Sergio;
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

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

public class Game extends SoundPlayer implements MouseHandler, KeyboardHandler {

    public static final int numberOfAliens = 30;
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
    private boolean inCredits;
    private DecimalFormat round;
    private boolean keyboardSilent = true;

    // initiate sound, grid, game objects and keyboard

    public void init() {
        TinySound.init();
        this.player = new Player();
        this.grid = new Grid();
        this.objects = new GameObjects[numberOfAliens + numberOfHostages];
        generateGameObjects();
        generateKeyboard();
        movieMak3r = new MovieMak3r();
        this.round = new DecimalFormat("#.##");
    }

    // start the different stages of the game

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
        intro.play(true,0.3);
        grid.generate(GridTypes.INTRO);
        movieMak3r.play("images/Intro/", "Intro",390,0,200);
    }

    private void generateMenuStage() throws  InterruptedException {
        grid.generate(GridTypes.MENU);
        grid.getRepresentation().draw();

        while (isInMenu){
            TimeUnit.MILLISECONDS.sleep(15);
        }
        resetStats(); //reset player stats
    }

    private void generateGameStage(){
        intro.stop();
        gameMusic.play(true);
        grid.getRepresentation().delete();
        grid.generate(GridTypes.GAME);
        grid.getRepresentation().draw();
        generateInGameInfo();
        generateMouse();
    }

    // max time interval between summon/hide has the minimum of 600 milliseconds
    private void gameStage() throws InterruptedException{
        int counter = 1;
        while(!gameEnded){

            for (int i = 0; i < objects.length; i++) {

                if (objects[i].isDead()) {
                    continue;
                }
                if(counter <= 400){
                    counter += 75;
                }

                objects[i].summon();
                appear.play();
                TimeUnit.MILLISECONDS.sleep(1000 - counter);

                objects[i].hide();
                TimeUnit.MILLISECONDS.sleep(1000 - counter);

                if (checkDeadHostages() || checkDeadAliens()) {
                    gameEnded = true;
                    break;
                }
            }
        }
        cleanGameStage();
    }

    private void generateCredits() throws InterruptedException{
        inCredits = true;
        credits.play(true, 1.5);
        grid.generate(GridTypes.CREDITS);
        grid.getRepresentation().draw();
        generateFinalScoreInfo();

        TimeUnit.SECONDS.sleep(3);
        keyboardSilent = false;

        while(inCredits) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
        cleanCredits(); // clean information from credits background
    }

    private void generateGameObjects(){
        objects = new GameObjects[numberOfHostages+numberOfAliens];

        for (int i = 0; i < objects.length ; i++) {
            if(i == 9){
                objects[i] = new Sergio();
                continue;
            }

            if(i == 19){
                objects[i] = new Audrey();
                continue;
            }

            if(i == 29) {
                objects[i] = new Faustino();
                continue;
            }
            objects[i] = AlienFactory.generateAlien();
        }
    }

    // reset player stats
    private void resetStats(){
        this.player.resetShotsOnTarget();
        this.player.resetShootsFired();
        this.player.resetShotsOnHostages();
    }

    private void cleanCredits() {
        credits.stop();
        intro.play(true,0.5);
    }

    private void generateFinalScoreInfo() throws InterruptedException{
         Text accText = new Text(400,120, "Accuracy: " +   round.format(player.getAccuracy()) + " %");
         Text alienKills = new Text(400, 170,  "Aliens Killed: " + Math.round(player.getShotsOnTarget()));
         Text hostageKills = new Text(400,220, "Hostages Killed: " + Math.round(player.getShotOnHostages()));
         accText.grow(40,20);
         alienKills.grow(40,20);
         hostageKills.grow(40,20);
         accText.setColor(Color.WHITE);
         alienKills.setColor(Color.WHITE);

        if(player.getShotsOnTarget() == numberOfAliens) {
            alienKills.setColor(Color.GREEN);
            hostageKills.setColor(Color.GREEN);
        }else{
            alienKills.setColor(Color.RED);
            hostageKills.setColor(Color.RED);
        }
         accText.draw();
         alienKills.draw();
         hostageKills.draw();
    }

    private void generateInGameInfo(){
        this.alienShotsInfo = new Text(40,176,"Aliens Killed: " + Math.round(this.player.getShotsOnTarget()));
        this.hostageShotsInfo = new Text(40,200,"Hostages killed: " + Math.round(this.player.getShotOnHostages()));
        alienShotsInfo.grow(25,15);
        alienShotsInfo.setColor(Color.RED);
        alienShotsInfo.draw();
        hostageShotsInfo.grow(25,15);
        hostageShotsInfo.setColor(Color.RED);
        hostageShotsInfo.draw();
    }

    private void updateGameInfo(){
        alienShotsInfo.setText("Aliens Killed: " + Math.round(this.player.getShotsOnTarget()));
        hostageShotsInfo.setText("Hostages killed: " + Math.round(this.player.getShotOnHostages()));
    }

    private void cleanGameStage() {
        gameMusic.stop();
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
    public void mouseClicked(MouseEvent mouseEvent) {
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
        if(grid.getType() == GridTypes.INTRO){
            movieMak3r.stop();
        }

        if(grid.getType()==GridTypes.MENU){
            grid.generate(GridTypes.MENU);
            isInMenu = false;
        } else if(grid.getType()==GridTypes.GAME) {
            player.shoot();
            shotOnTarget();
        } else if (!keyboardSilent && grid.getType() == GridTypes.CREDITS){
            inCredits = false;
            keyboardSilent = true;
        }
    }
}
