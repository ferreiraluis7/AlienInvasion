import kuusisto.tinysound.*;
public class SoundPlayer {




    public static void playMusic(int musicNum){


        switch (musicNum){

            case 1:

                Music song = TinySound.loadMusic("resources/MusicAndSound/intro.wav");
                song.play(true);
                break;
            case 2:
                Music song2 = TinySound.loadMusic("resources/MusicAndSound/throughspace.wav");
                song2.play(true);
                break;




        }





    }
    public static void playSound(){

        Sound fire = TinySound.loadSound("resources/MusicAndSound/pistol.wav");
        fire.play();



    }

    public static void stopMusic(){

    }



    }
