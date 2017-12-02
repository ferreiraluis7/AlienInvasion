import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    private Picture representation;
    private GridTypes type;

    public void generate(GridTypes grid){

        switch (grid){
            case MENU:
                this.representation = new Picture(0,0, GridTypes.MENU.getPath());
                this.type = grid;
                break;

            case INTRO:
                this.representation = new Picture(0,0, GridTypes.INTRO.getPath());
                this.type = grid;
                break;

            case GAME:
                this.representation = new Picture(0,0 , GridTypes.GAME.getPath());
                this.type = grid;
                break;

            case CREDITS:
                this.representation = new Picture(0,0, GridTypes.CREDITS.getPath());
                this.type = grid;
                break;

            default:
                System.out.println("Something went wrong");
        }
    }

    public Picture getRepresentation() {
        return representation;
    }

    public GridTypes getType() {
        return type;
    }
}
