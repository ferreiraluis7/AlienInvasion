package graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum GridTypes {
    INITIAL("resources/images/game/FullBackground.png"),
    INTRO("path"),
    GAMESCREEN("path"),
    CREDITS("path");
        private String path;


    GridTypes(String pathname) {
        this.path = pathname;
    }

    public String getPath() {
        return path;
    }
}




