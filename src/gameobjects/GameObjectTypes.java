package gameobjects;

public enum GameObjectTypes {
    ALIEN1("path", 1),
    ALIEN2("path", 2),
    AlIEN3("path", 3),
    HOSTAGE1("path", 1),
    HOSTAGE2("path", 1),
    HOSTAGE3("path", 1);

    private String path;
    private int speedFactor;

    GameObjectTypes(String path, int speedFactor) {
        this.path = path;
        this.speedFactor = speedFactor;

    }

    public String getPath() {
        return this.path;
    }

    public int getSpeedFactor() {
        return speedFactor;
    }
}
