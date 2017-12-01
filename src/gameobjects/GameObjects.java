package gameobjects;

import graphics.Positions;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObjects {

    private boolean isDead = false;
    private Picture shape;
    private GameObjectTypes type;
    private int speedfactor;
    private Positions currentPosition;
    private int currentAnim = 0;

    public GameObjects(GameObjectTypes type) {
        this.type = type;
        this.speedfactor = type.getSpeedFactor();
    }

    public void hit() {
        isDead = true;
        shape.delete();
    }

    public void summon(){

        currentPosition = Positions.values()[ (int) (Math.random()*Positions.values().length)];
        this.shape = new Picture(currentPosition.getxPoint(),currentPosition.getyPoint(), this.type.getPath() + "Alien3_anim10.png");
        shape.draw();
    }

    public boolean isDead() {
        return isDead;
    }

    public Picture getShape() {
        return shape;
    }

    public GameObjectTypes getType() {
        return type;
    }


}
