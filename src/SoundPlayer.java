import kuusisto.tinysound.*;
public class SoundPlayer {


    Music intro = TinySound.loadMusic("MusicAndSound/intro.wav");
    Music gameMusic = TinySound.loadMusic("MusicAndSound/gameStageMusic.wav");
    Music credits = TinySound.loadMusic("MusicAndSound/credits.wav");
    Sound fire = TinySound.loadSound("MusicAndSound/pistol.wav");
    Sound appear = TinySound.loadSound("MusicAndSound/appear.wav");
    Sound dead = TinySound.loadSound("MusicAndSound/hostageDead.wav");
    Music catarina = TinySound.loadMusic("MusicAndSound/catarina.wav");
    Sound noise = TinySound.loadSound("MusicAndSound/noise.wav");







    public  void playMusic(chooseSound sound){


        switch (sound){

            case INTRO:
                intro.play(true,0.9);
                break;
            case GAMEMUSIC:

                gameMusic.play(true,0.9);
                break;





        }





    }







    public static void stopMusic(){


    }


    protected enum chooseSound{
        INTRO,
        GAMEMUSIC,
        PISTOL,
        ALIENAPPEAR,
        ALIENDEAD,
        HOSTAGEAPPEAR,
        HOSTAGEDEAD,

    }


}
