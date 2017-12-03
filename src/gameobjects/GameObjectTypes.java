package gameobjects;

public enum GameObjectTypes {
    BASICALIEN("images/aliens/basicalien/"),
    WARRIORALIEN("images/aliens/warrioralien/"),
    CHIEFALIEN("images/aliens/chiefalien/"),
    HOSTAGE1("images/hostages/sergio/"),
    HOSTAGE2("images/hostages/audrey/"),
    HOSTAGE3("images/hostages/faustino/");

    private String path;

    GameObjectTypes(String path) {
        this.path = path;

    }

    protected String getPath() {
        return this.path;
    }

}
