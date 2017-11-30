import gameobjects.GameObjects;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements MouseHandler {

    private int score = 0;
    private int shootsFired = 0;
    private int sightX;
    private int sightY;
    private Mouse sight;
    private Picture sightCross;
    private GameObjects target;


    public Player(){
        this.sight = new Mouse(this);
        this.sightCross = new Picture(0,0, "resources/images/game/cursor.png");
        sightCross.draw();
        sight.addEventListener(MouseEventType.MOUSE_CLICKED);
        sight.addEventListener(MouseEventType.MOUSE_MOVED);

    }


    public void shoot(GameObjects target) {
        if(target.getX() == sightX && target.getY() == sightY) {
            target.hit();
            score +=5;
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        //shoot(target);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        sightX = (int) mouseEvent.getX();
        sightY = (int) mouseEvent.getY();

        if((mouseEvent.getX() < sightCross.getWidth()/2 || mouseEvent.getX() > 775) && (mouseEvent.getY() < (sightCross.getHeight()/2) + 23 || mouseEvent.getY() > 600)){ //canvas bar has 23 pixels
            sightCross.translate(0,0);
        } else if (mouseEvent.getX() < sightCross.getWidth()/2 || mouseEvent.getX() > 775) {
            sightCross.translate(0,mouseEvent.getY() - sightCross.getHeight() - sightCross.getY());
        } else if (mouseEvent.getY() < 48 || mouseEvent.getY() > 600) {
            sightCross.translate(mouseEvent.getX() - sightCross.getWidth()/2  - sightCross.getX(), 0);
        } else{
            sightCross.translate(mouseEvent.getX() - sightCross.getWidth()/2  - sightCross.getX(), mouseEvent.getY() - sightCross.getHeight() - sightCross.getY());
        }
    }
}

