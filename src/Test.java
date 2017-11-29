import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Test implements MouseHandler {


    public static void main(String[] args) {


        Rectangle rec = new Rectangle(0,0,800,800);
        rec.fill();

        Test t = new Test();
    }

    public void test() {
        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        if(mouseEvent.getX() == 25 || mouseEvent.getY() == 48 || mouseEvent.getX() == 775 || mouseEvent.getY() == 775) {
            Picture sight = new Picture(mouseEvent.getX(),mouseEvent.getY(),"resources/images/game/cursor.png");
            sight.draw();
            return;
        }

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }
}


