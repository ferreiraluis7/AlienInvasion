import kuusisto.tinysound.*;
public class SoundPlayer {




    public static void playMusic(ChooseSound sound){


        switch (sound){

            case INTROMUSIC:

                Music song = TinySound.loadMusic("MusicAndSound/intro.wav");
                song.play(true);
                break;
            case GAMEMUSIC:
                Music song2 = TinySound.loadMusic("MusicAndSound/throughspace.wav");
                song2.play(true);
                break;




        }





    }
    public static void playSound(ChooseSound sound){
        Sound fire = TinySound.loadSound("MusicAndSound/pistol.wav");
        Sound alienappear = TinySound.loadSound("MusicAndSound/")
        switch (sound){
            case FIRE:

                fire.play();



                break;


        }





    }

    public static void stopMusic(){

    }


    public enum ChooseSound {
        FIRE,
        ALIENAPPEAR,
        ALIENDEAD,
        HOSTAGEAPPEAR,
        HOSTAGEDEAD,
        INTROMUSIC,
        GAMEMUSIC,

    }



    }
