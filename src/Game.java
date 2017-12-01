import gameobjects.GameObjects;
import graphics.GridTypes;
import kuusisto.tinysound.TinySound;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    public static final int numberOfcharacters = 20;
    private Picture background;

    public void start(){
        TinySound.init();
        Player player1 = new Player();
        GameObjects[] characterList = new GameObjects[numberOfcharacters];

        for(int i = 0 ; i < numberOfcharacters; i++){
            //characterList[i] = GameObjectsFactory.generate();
        }
        //generateBackground(GridTypes.INITIAL);







    }
   /* private void generateBackground(GridTypes teste){
        background.delete();
        background = GridTypes.generateGrid(GridTypes.INITIAL);
        background.draw();
    }*/


}
