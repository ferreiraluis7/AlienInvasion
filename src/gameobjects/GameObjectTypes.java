package gameobjects;

public enum GameObjectTypes {
    BASICALIEN("resources/images/aliens/basicalien/"),
    WARRIORALIEN("resources/images/aliens/warrioralien/"),
    CHIEFALIEN("resources/images/aliens/chiefalien/"),
    HOSTAGE1("resources/images/hostages/sérgio/"),
    HOSTAGE2("resources/images/hostages/audrey/"),
    HOSTAGE3("resources/images/hostages/faustino/");

    private String path;

    GameObjectTypes(String path) {
        this.path = path;

    }

    protected String getPath() {
        return this.path;
    }

}
