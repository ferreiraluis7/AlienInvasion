package gameobjects;

public enum GameObjectTypes {
    BASICALIEN("resources/images/aliens/basicalien/", 1),
    WARRIORALIEN("resources/images/aliens/basicAlien.png", 2),
    AlIEN3("resources/images/aliens/basicAlien.png", 3),
    HOSTAGE1("resources/images/aliens/basicAlien.png", 1),
    HOSTAGE2("resources/images/aliens/basicAlien.png", 1),
    HOSTAGE3("resources/images/aliens/basicAlien.png", 1);

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
