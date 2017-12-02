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
    }

    public void hit() {
        isDead = true;
        shape.delete();
    }

    public void summon(){

        this.shape = new Picture(currentPosition.getxPoint(),currentPosition.getyPoint(), this.type.getPath() + "Anim10.png");
        shape.draw();

        /*
        if (!isSummoned && this.type == GameObjectTypes.BASICALIEN ){
            isSummoned = true;

            currentPosition = Positions.values()[ (int) (Math.random()*Positions.values().length)];
            this.shape = new Picture(currentPosition.getxPoint(),currentPosition.getyPoint(), this.type.getPath() + "Anim0.png");
            shape.draw();
        }
        else if(isSummoned && this.type == GameObjectTypes.BASICALIEN ){

            if(currentAnim != 10){
                currentAnim++;
                this.shape.load(this.type.getPath() + "Anim" + currentAnim + ".png");

            }else {
                counter++;
            }

        }

        if (!isSummoned && this.type == GameObjectTypes.WARRIORALIEN ){
            currentPosition = Positions.values()[ (int) (Math.random()*Positions.values().length)];
            this.shape = new Picture(currentPosition.getxPoint(),currentPosition.getyPoint(), this.type.getPath() + "Anim0.png");
            shape.draw();
        }
        else if(isSummoned && this.type == GameObjectTypes.WARRIORALIEN ){
            //anim
        }

        if (!isSummoned && this.type == GameObjectTypes.CHIEFALIEN){
            currentPosition = Positions.values()[ (int) (Math.random()*Positions.values().length)];
            this.shape = new Picture(currentPosition.getxPoint(),currentPosition.getyPoint(), this.type.getPath() + "Anim0.png");
            shape.draw();
        }
        else if(isSummoned && this.type == GameObjectTypes.CHIEFALIEN){
            //anim
        }

        if (!isSummoned && this.type == GameObjectTypes.HOSTAGE1){
            currentPosition = Positions.values()[ (int) (Math.random()*Positions.values().length)];
            this.shape = new Picture(currentPosition.getxPoint(),currentPosition.getyPoint(), this.type.getPath() + "Anim0.png");
            shape.draw();
        }
        else if(isSummoned && this.type == GameObjectTypes.HOSTAGE1 ){
            //anim
        }

        if (!isSummoned && this.type == GameObjectTypes.HOSTAGE2){
            currentPosition = Positions.values()[ (int) (Math.random()*Positions.values().length)];
            this.shape = new Picture(currentPosition.getxPoint(),currentPosition.getyPoint(), this.type.getPath() + "Anim0.png");
            shape.draw();
        }
        else if(isSummoned && this.type == GameObjectTypes.HOSTAGE2 ){
            //anim
        }

        if (!isSummoned && this.type == GameObjectTypes.HOSTAGE3){
            currentPosition = Positions.values()[ (int) (Math.random()*Positions.values().length)];
            this.shape = new Picture(currentPosition.getxPoint(),currentPosition.getyPoint(), this.type.getPath() + "Anim0.png");
            shape.draw();
        }
        else if(isSummoned && this.type == GameObjectTypes.HOSTAGE3 ){
            //anim
        }

        */

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
}
