import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.TimeUnit;

public class MovieMak3r extends SoundPlayer {
    private int i, picQuantity;
    private Picture picture, picture2;
    private boolean change;

    void play(String resourcesPath, String imagePrefix, int picQuantity, int imageNumberSuffix, int mileseconds) throws InterruptedException {
        this.picture = new Picture(0, 0, resourcesPath + imagePrefix + imageNumberSuffix + ".png");
        this. picture2 = new Picture(0, 0, resourcesPath + imagePrefix + (imageNumberSuffix + 1) + ".png");
        this.picQuantity = picQuantity;

        for (i = imageNumberSuffix; i < picQuantity; i++) {

            if (i == 0) {

                picture.draw();
                TimeUnit.MILLISECONDS.sleep(1);
                picture.delete();
            } else if (i == 1) {
                picture2.draw();
                picture.delete();
                TimeUnit.MILLISECONDS.sleep(mileseconds);
            } else {
                if (!change) {
                    picture.load(resourcesPath + imagePrefix + i + ".png");
                    picture.draw();
                    picture2.delete();
                    TimeUnit.MILLISECONDS.sleep(mileseconds);
                    change = true;
                } else {
                    picture2.load(resourcesPath + imagePrefix + i + ".png");
                    picture2.draw();
                    picture.delete();
                    TimeUnit.MILLISECONDS.sleep(mileseconds);
                }
            }
            
            if (i == 11) {
                spaceship.play();
            }
            if (i == 26) {
                spaceship.stop();
            }
            if (i == 27) {
                beamdown.play();
            }
            if (i == 54) {
                beamdown.stop();
            }

            if (i == 71) {
                noise.play();
            }
            if (i == 96) {
                noise.stop();
            }
            if (i == 97) {
                catarina.play(true);
            }
            if (i == 157) {
                catarina.stop();
            }
            if (i == 164) {
                footsteps.play(true, 2);
            }
            if (i == 203) {
                footsteps.stop();
            }
        }
    }

    public void stop() {

        i = picQuantity;
        spaceship.stop();
        beamdown.stop();
        noise.stop();
        catarina.stop();
        footsteps.stop();

    }


}
