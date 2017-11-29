package gameobjects;

import graphics.Shape;

public class GameObjects {

    private boolean isDead = false;
    private int x;
    private int y;
    private Shape shape;
    private GameObjectTypes type;

    public GameObjects(GameObjectTypes type) {
        this.type = type;
        this.shape = new Shape(type.getPath());
        this.shape.setSpeedFactor(this.type.getSpeedFactor());
    }

    public void hit() {
        isDead = true;
    }

    public boolean isDead() {
        return isDead;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Shape getShape() {
        return shape;
    }

    public GameObjectTypes getType() {
        return type;
    }
}
