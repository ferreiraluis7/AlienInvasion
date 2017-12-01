import kuusisto.tinysound.*;
public class Sound {

    public static void playMusic(){

        Music song = TinySound.loadMusic("MusicAndSound/throughspace.wav");
        song.play(true);

    }
    public static  void playSound(){

        kuusisto.tinysound.Sound fire = TinySound.loadSound("MusicAndSound/pistol.wav");
        fire.play();


    }

    }
