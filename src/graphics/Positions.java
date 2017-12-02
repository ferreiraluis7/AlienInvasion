package graphics;

public enum Positions {

    //Front
    SPAWN1(56,260),
    SPAWN2(226,260),
    SPAWN3(424, 262),
    SPAWN4(651, 262),

    //Middle
    SPAWN5(696,-696);



    private int xPoint;
    private int yPoint;
    private boolean isOccupied = false;

    Positions(int x, int y) {
        this.xPoint = x;
        this.yPoint = y;
    }

    public int getxPoint() {
        return xPoint;
    }

    public int getyPoint() {
        return yPoint;
    }

    public void setxPoint(int xPoint) {
        this.xPoint = xPoint;
    }

    public void setyPoint(int yPoint) {
        this.yPoint = yPoint;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
