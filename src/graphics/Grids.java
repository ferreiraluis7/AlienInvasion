package graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum Grids {
    INITIAL("/home/c0d3x/workspace/AlienInvasion/resources/images/game/FullBackground.png"),
    INTRO("path"),
    GAMESCREEN("path"),
    CREDITS("path");
        private String path;


    Grids(String pathname) {
        this.path = pathname;


    }

    public static Picture generateGrid(String gridname){

        switch (gridname){
            case "initial":
                System.out.println(INITIAL.path);
                return new Picture(0,0,INITIAL.path);

            case "intro":
                return new Picture(0,0,INTRO.path);

            case "gamescreen":
                return new Picture(0,0,GAMESCREEN.path);

            case "credits":
                return new Picture(0,0,CREDITS.path);

            default:
                System.out.println("Something went wrong with the enum");
        }

        return null;
    }


}




