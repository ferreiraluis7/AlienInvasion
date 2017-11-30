package graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum Grids {
    INTRO("resources/images/game/FullBackground.png"),
    MENU("path"),
    GAMESCREEN("path"),
    CREDITS("path");
        private String path;


    Grids(String pathname) {
        this.path = pathname;


    }

    public static Picture generateGrid(Grids grid){

        switch (grid){
            case INTRO:
                System.out.println(INTRO.path);
                return new Picture(0,0, INTRO.path);

            case MENU:
                return new Picture(0,0,MENU.path);

            case GAMESCREEN:
                return new Picture(0,0,GAMESCREEN.path);

            case CREDITS:
                return new Picture(0,0,CREDITS.path);

            default:
                System.out.println("Something went wrong with the enum");
        }

        return null;
    }


}




