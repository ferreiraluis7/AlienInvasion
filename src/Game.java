import gameobjects.GameObjects;
import graphics.Grids;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    public static final int numberOfcharacters = 20;
    private Picture background;


    public void start(){
        Player player1 = new Player();
        GameObjects[] characterList = new GameObjects[numberOfcharacters];

        for(int i = 0 ; i < numberOfcharacters; i++){
            //characterList[i] = GameObjectsFactory.generate();
        }
        generateBackground(Grids.INITIAL);







    }
    private void generateBackground(Grids teste){
        background.delete();
        background = Grids.generateGrid(Grids.INITIAL);
        background.draw();
    }


}
