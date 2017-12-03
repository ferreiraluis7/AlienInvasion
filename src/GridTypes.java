public enum GridTypes {
    INTRO("images/game/IntroBackground.png"),
    MENU("images/game/MenuBackground.png"),
    GAME("images/game/GameBackground.png"),
    CREDITS("images/game/CreditsBackground.png");

    private String path;


    GridTypes(String pathname) {
        this.path = pathname;
    }
    String getPath() {
        return path;
    }
}




