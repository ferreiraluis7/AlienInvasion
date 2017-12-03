package gameobjects;

public enum GameObjectTypes {
    BASICALIEN("resources/images/aliens/basicalien/"),
    WARRIORALIEN("resources/images/aliens/warrioralien/"),
    CHIEFALIEN("resources/images/aliens/chiefalien/"),
    HOSTAGE1("resources/images/aliens/basicalien/"),
    HOSTAGE2("resources/images/aliens/basicalien/"),
    HOSTAGE3("resources/images/aliens/basicalien/");

    private String path;

    GameObjectTypes(String path) {
        this.path = path;

    }

    protected String getPath() {
        return this.path;
    }

}
