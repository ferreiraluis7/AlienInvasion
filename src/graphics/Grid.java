package graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    private Picture representation;

    public void generate(GridTypes grid){

        switch (grid){
            case INITIAL:
                this.representation = new Picture(0,0,GridTypes.INITIAL.getPath());
                break;

            case INTRO:
                this.representation = new Picture(0,0,GridTypes.INTRO.getPath());
                break;

            case GAMESCREEN:
                this.representation = new Picture(0,0,GridTypes.GAMESCREEN.getPath());
                break;

            case CREDITS:
                this.representation = new Picture(0,0,GridTypes.CREDITS.getPath());
                break;

            default:
                System.out.println("Something went wrong");
        }
    }

    public Picture getRepresentation() {
        return representation;
    }
}
