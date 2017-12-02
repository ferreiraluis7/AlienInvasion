package gameobjects;

import graphics.Positions;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObjects {

    private boolean isDead = false;
    private Picture shape;
    private GameObjectTypes type;
    private int speedfactor;
    private int counter = 0;
    private Positions currentPosition;
    private int currentAnim = 0;
    private boolean isAlien;
    private boolean isSummoned;

    public GameObjects(GameObjectTypes type, boolean isAlien) {
        this.type = type;
        this.speedfactor = type.getSpeedFactor();
        this.isAlien = isAlien;
        this.currentPosition = Positions.ORIGIN;
        this.shape = new Picture(Positions.ORIGIN.getxPoint(), Positions.ORIGIN.getyPoint(),type.getPath() + "Anim10.png");
    }

    public void hit() {
        isDead = true;
        hide();
    }

    public void summon(){
        shape.draw();
    }

    public void move(Positions nextPos){
        shape.translate(nextPos.getxPoint() - currentPosition.getxPoint(),nextPos.getyPoint() - currentPosition.getyPoint());
    }


    public void hide(){
        this.shape.delete();
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

    public Positions getCurrentPosition() {
        return currentPosition;
    }

    public boolean isAlien() {
        return isAlien;
    }

    public void setCurrentPosition(Positions position) {
        this.currentPosition = position;
    }

    public void setDead() {
        isDead = true;
    }
}
