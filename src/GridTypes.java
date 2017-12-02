public enum GridTypes {
    INTRO("images/game/IntroBackground.png"),
    MENU("images/game/MenuBackground.png"),
    GAME("images/game/GameBackground.png"),
    CREDITS("path");
        private String path;


    GridTypes(String pathname) {
        this.path = pathname;
    }
    public String getPath() {
        return path;
    }
}




