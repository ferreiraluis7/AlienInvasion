package graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Shape implements Representables{

    private int speedFactor;
    private int x;
    private int y;
    private Picture picture;


    public Shape(String path) {
        this.picture = new Picture(x,y,path);
    }

    @Override
    public void hide() {
                            // Implement
    }

    @Override
    public void show() {
                            // Implement
    }

    public int getSpeedFactor() {
        return speedFactor;
    }

    public void setSpeedFactor(int speedFactor) {
        this.speedFactor = speedFactor;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
