import graphics.Grid;
import graphics.GridTypes;

public class Test {

    public static void main(String[] args) {

        Grid grid = new Grid();
        grid.generate(GridTypes.INITIAL);// initial --> initial screen
        grid.getRepresentation().draw();
        Game g1 = new Game();
        g1.start();
        Sound.playMusic();

        //intro
        //gamescreen
        //credits              <-- use this four keywords when creating the screens like the example above ;)


        Player cenas = new Player();


    }
}

