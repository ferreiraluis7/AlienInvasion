import graphics.Grid;
import graphics.GridTypes;
import graphics.Grids;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Test {

    public static void main(String[] args) {

        Grid grid = new Grid();
        grid.generate(GridTypes.INITIAL);// initial --> initial screen
        grid.getRepresentation().draw();
        Game g1 = new Game();
        g1.start();


        //intro
        //gamescreen
        //credits              <-- use this four keywords when creating the screens like the example above ;)


        Player cenas = new Player();


    }
}

