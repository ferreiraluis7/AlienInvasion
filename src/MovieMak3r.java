import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.TimeUnit;

public class MovieMak3r {

    public void play(String resourcesPath, String pastePrefix, int picQuantity, int mileseconds) throws InterruptedException{
        Picture picture = new Picture(0,0,resourcesPath + pastePrefix +"0.png");


        for (int i = 0; i < picQuantity ; i++) {

            if (i == 0 ){
                picture.draw();
                TimeUnit.MILLISECONDS.sleep(mileseconds);

            }
            else {
                picture = new Picture(0,0,"resources/images/Intro/Intro"+i+".png");
                picture.draw();
                TimeUnit.MILLISECONDS.sleep(mileseconds);

            }
        }

        picture.delete();
    }

}
