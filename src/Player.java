public class Player extends SoundPlayer{

    private int score = 0;
    private int shotsFired = 0;
    private int shotsOnTarget = 0;
    private int shotOnHostages = 0;

    void shoot() {
        fire.play();
        shotsFired++;
    }

    void resetShootsFired() {
        shotsFired = 0;
    }

    void resetShotsOnTarget() {
        shotsOnTarget = 0;
    }

    void resetShotsOnHostages() {
        shotOnHostages = 0;
    }

    void shotOnTarget() {
        shotsOnTarget++;
    }

    void shotOnHostages(){
        shotOnHostages++;
    }

    int getShotsOnTarget() {
        return shotsOnTarget;
    }

    int getShotsFired() {
        return shotsFired;
    }

    public int getShotOnHostages() {
        return shotOnHostages;
    }
}


