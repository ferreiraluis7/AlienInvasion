import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.TimeUnit;

public class MovieMak3r {

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
        }

        picture.delete();
        picture.draw();
    }

}
