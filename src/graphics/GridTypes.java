package graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum GridTypes {
    MENU("resources/images/game/FullBackground.png"),
    INTRO("path"),
    GAMESTAGE("resources/images/game/GameBackground.png"),
    CREDITS("path");

    private String path;


    GridTypes(String pathname) {
        this.path = pathname;
    }

    public String getPath() {
        return path;
    }


}




