public class Player extends SoundPlayer{

    private int score = 0;
    private int shotsFired = 0;
    private int shotsOnTarget = 0;

    public void shoot() {
        fire.play();
        shotsFired++;
    }

    public void resetShootsFired() {
        shotsFired = 0;
    }

    public void resetShotsOnTarget() {
        shotsOnTarget = 0;
    }

    public void shotOnTarget() {
        shotsOnTarget++;
    }

    public int getShotsOnTarget() {
        return shotsOnTarget;
    }

    public int getShotsFired() {
        return shotsFired;
    }
}


