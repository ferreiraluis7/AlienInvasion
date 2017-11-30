import graphics.Grids;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Test {

    public static void main(String[] args) throws InterruptedException {


        Picture img = Grids.generateGrid(Grids.INITIAL);  // initial --> initial screen

        //intro
        //gamescreen
        //credits              <-- use this four keywords when creating the screens like the example above ;)

        img.draw();
        Player cenas = new Player();
    }
}

