import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.test.Tester;

import static org.academiadecodigo.simplegraphics.graphics.Color.CYAN;

public class Test {

    public static void main(String[] args) throws InterruptedException {


        Picture img = new Picture(0,0,"resources/images/game/FullBackground.png");

        img.draw();
        Player cenas = new Player();
    }
}

