import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.TimeUnit;

public class MovieMak3r extends SoundPlayer{
    private int i,picQuantity;
    private Picture picture;

    void play(String resourcesPath, String imagePrefix, int picQuantity, int imageNumberSuffix, int mileseconds) throws InterruptedException{
        this.picture = new Picture(0,0,resourcesPath + imagePrefix + imageNumberSuffix +".png");
        this.picQuantity = picQuantity;

        for (i = imageNumberSuffix; i < picQuantity ; i++) {

            if (i == 0 ){
                picture.draw();
                TimeUnit.MILLISECONDS.sleep(mileseconds);
            }
            else {

                if(i >= 164){
                    picture = new Picture(0,0,resourcesPath + imagePrefix +i+".png");
                    picture.draw();
                    TimeUnit.MILLISECONDS.sleep(1);

                }else {
                    picture = new Picture(0,0,resourcesPath + imagePrefix +i+".png");
                    picture.draw();
                    TimeUnit.MILLISECONDS.sleep(mileseconds);
                }


            }
            if(i == 11){
                spaceship.play();
            }
            if(i==30){
                spaceship.stop();
            }
            if(i == 31){
                beamdown.play();
            }
            if(i == 59){
                beamdown.stop();
            }

            if(i == 71){
                noise.play();
            }
            if (i == 97){
                noise.stop();
            }
            if(i == 98){
                catarina.play(true);
            }
            if(i == 158){
                catarina.stop();
            }
            if(i ==164){
                footsteps.play(true,2);
            }
            if(i == 451){
                footsteps.stop();
            }
        }
        picture.delete();
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
