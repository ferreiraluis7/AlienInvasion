import graphics.Grid;
import graphics.GridTypes;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Test {

    public static void main(String[] args) {

        Grid grid = new Grid();
        grid.generate(GridTypes.INITIAL);// initial --> initial screen
        grid.getRepresentation().draw();
        Game game = new Game();
        game.generateMouse();
        System.out.println(grid.getRepresentation().getWidth());

        //intro
        //gamescreen
        //credits              <-- use this four keywords when creating the screens like the example above ;)


        Player cenas = new Player();
    }
}

