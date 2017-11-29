package gameobjects;

public enum GameObjectTypes {
    ALIEN1("path"),
    ALIEN2("path"),
    AlIEN3("path"),
    HOSTAGE1("path"),
    HOSTAGE2("path"),
    HOSTAGE3("path");

    private String path;

    GameObjectTypes(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
