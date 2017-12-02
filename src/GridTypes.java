public enum GridTypes {
    INTRO("resources/images/game/IntroBackground.png"),
    MENU("resources/images/game/MenuBackground.png"),
    GAME("resources/images/game/GameBackground.png"),
    CREDITS("path");
        private String path;


    GridTypes(String pathname) {
        this.path = pathname;
    }
    public String getPath() {
        return path;
    }
}




