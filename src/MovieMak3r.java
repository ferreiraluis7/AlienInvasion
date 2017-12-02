import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.TimeUnit;

public class MovieMak3r extends SoundPlayer{

    public void play(String resourcesPath, String imagePrefix, int picQuantity, int imageNumberSuffix, int mileseconds) throws InterruptedException{
        Picture picture = new Picture(0,0,resourcesPath + imagePrefix + imageNumberSuffix +".png");


        for (int i = 0; i < picQuantity ; i++) {

            if (i == 0 ){
                picture.draw();
                TimeUnit.MILLISECONDS.sleep(mileseconds);

            }
            else {
                picture = new Picture(0,0,resourcesPath + imagePrefix +i+".png");
                picture.draw();
                TimeUnit.MILLISECONDS.sleep(mileseconds);

            }


            if(i == 17){
                noise.play();
            }
            if (i == 25){
                noise.stop();
            }
            if(i == 26){
                catarina.play();
            }
            if(i == 88){
                catarina.stop();
            }
        }

        picture.delete();
        picture.draw();
    }

}
