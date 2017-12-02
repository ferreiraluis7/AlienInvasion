public class Player {

    private int score = 0;
    private int shootsFired = 0;
    private int shotsOnTarget = 0;

    public void shoot() {
        shootsFired++;
    }

    public void shotOnTarget() {
        shotsOnTarget++;
    }

    public int getShotsOnTarget() {
        return shotsOnTarget;
    }

    public int getShootsFired() {
        return shootsFired;
    }
}


