import gameobjects.GameObjects;
import graphics.Grids;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    public int score = 300;
    public static final int numberOfcharacters = 20;
    private Picture background;


    public void start(){
        Player player1 = new Player();
        GameObjects[] characterList = new GameObjects[numberOfcharacters];

        for(int i = 0 ; i < numberOfcharacters; i++){
            //characterList[i] = GameObjectsFactory.generate();
        }
        generateBackground(Grids.INTRO);


        Text score = new Text(100,30,"Score: " + Integer.toString(this.score));

        score.setColor(Color.WHITE);
        score.grow(60,20);
        score.draw();




    }
    private void generateBackground(Grids teste){

        background = Grids.generateGrid(teste);
        background.draw();

    }


}
