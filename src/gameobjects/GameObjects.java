package gameobjects;

import graphics.Positions;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObjects {

    private boolean isDead = false;
    private Picture shape;
    private GameObjectTypes type;
    private Positions currentPosition;
    private int currentAnim = 0;
    private boolean isAlien;
    private boolean isVisible = false;

    public GameObjects(GameObjectTypes type, boolean isAlien) {
        this.type = type;
        this.isAlien = isAlien;
        this.currentPosition = Positions.values()[(int) (Math.random() * ((Positions.values().length)))];
        this.shape = new Picture(currentPosition.getxPoint(), currentPosition.getyPoint(),type.getPath() + "Anim10.png");
    }

    public void hit() {
        isDead = true;
        hide();
    }

    public void summon(){
        Positions nextPos;
        shape.grow(-10,-10);
        shape.draw();
        this.isVisible = true;

        nextPos = Positions.values()[(int) (Math.random() * ((Positions.values().length)))];
        move(nextPos);
        currentPosition = nextPos;
    }

    public void move(Positions nextPos){
            shape.translate(nextPos.getxPoint() - currentPosition.getxPoint(),nextPos.getyPoint() - currentPosition.getyPoint());
        }

    public void hide(){
            this.shape.delete();
            shape.grow(10,10);
            this.isVisible = false;


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

    public boolean isVisible(){
        return isVisible;
    }

}
