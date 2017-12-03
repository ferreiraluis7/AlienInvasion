public class Player extends SoundPlayer{

    private double shotsFired = 0;
    private double shotsOnTarget = 0;
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

    double getAccuracy(){
        return ((shotsOnTarget/shotsFired) * 100);
    }

    void shotOnTarget() {
        shotsOnTarget++;
    }

    void shotOnHostages(){
        shotOnHostages++;
    }

    double getShotsOnTarget() {
        return shotsOnTarget;
    }

    double getShotsFired() {
        return shotsFired;
    }

    public int getShotOnHostages() {
        return shotOnHostages;
    }
}


