import kuusisto.tinysound.*;
public class SoundPlayer {


    Music intro = TinySound.loadMusic("MusicAndSound/intro.wav");
    Music gameMusic = TinySound.loadMusic("MusicAndSound/gameStageMusic.wav");
    Sound fire = TinySound.loadSound("MusicAndSound/pistol.wav");
    Sound alienAppear = TinySound.loadSound("MusicAndSound/alienAppear.wav");
    Sound alienDead = TinySound.loadSound("MusicAndSound/alienDead.wav");
    Sound hostageApear = TinySound.loadSound("MusicAndSound/hostageAppear.wav");
    Sound hostageDead = TinySound.loadSound("MusicAndSound/hostageDead.wav");








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
    public  void playSound(chooseSound sound){

        switch (sound){
            case PISTOL:

                fire.play();
                break;
            case ALIENAPPEAR:

                alienAppear.play();
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
