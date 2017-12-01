import kuusisto.tinysound.*;
public class SoundPlayer {




    public static void playMusic(int musicNum){


        switch (musicNum){

            case 1:

                Music song = TinySound.loadMusic("MusicAndSound/intro.wav");
                song.play(true);
                break;
            case 2:
                Music song2 = TinySound.loadMusic("MusicAndSound/throughspace.wav");
                song2.play(true);
                break;




        }





    }
    public static void playSound(){

        Sound fire = TinySound.loadSound("MusicAndSound/pistol.wav");
        fire.play();



    }

    public static void stopMusic(){

    }



    }
