import gameobjects.GameObjects;
import gameobjects.hostages.Hostage1;
import gameobjects.hostages.Hostage2;
import gameobjects.hostages.Hostage3;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements MouseHandler {
    public static final int numberOfAliens = 27;
    public static final int numberOfHostages = 3;
    public static final int gameWidth = 800;
    public static final int gameHeight = 600;
    private Picture background;
    private Player player;
    private GameObjects[] objects;
    private Mouse sight;
    private Picture sightCross;
    private int sightX;
    private int sightY;



    public void init() {
        this.player = new Player();
        this.objects = new GameObjects[numberOfAliens + numberOfHostages];


    }

    public void start() {

    }

    public void generateGameObjects(){
        for(int i = 0 ; i < objects.length; i++) {
            if(i == numberOfAliens) {
                objects[i] = new Hostage1();
                continue;
            }
            if(i > numberOfAliens && i != objects.length -1 ){
                objects[i] = new Hostage2();
                continue;
            }
            if (i == objects.length - 1){
                objects[i] = new Hostage3();
                continue;
            }
            objects[i] = AlienFactory.generateAlien();
        }




    }

    public void generateMouse() {
        this.sight = new Mouse(this);
        this.sightCross = new Picture(0,0, "resources/images/game/cursor.png");
        sightCross.draw();
        sight.addEventListener(MouseEventType.MOUSE_CLICKED);
        sight.addEventListener(MouseEventType.MOUSE_MOVED);
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
        } else if (mouseEvent.getY() < sightCross.getHeight() + 23  || mouseEvent.getY() > gameHeight) {
            sightCross.translate(mouseEvent.getX() - sightCross.getWidth()/2  - sightCross.getX(), 0);
        } else {
            sightCross.translate(mouseEvent.getX() - sightCross.getWidth()/2  - sightCross.getX(), mouseEvent.getY() - sightCross.getHeight() - sightCross.getY());
        }
    }



}
