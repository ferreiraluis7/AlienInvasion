package graphics;

public enum Positions {

    SPAWN1(56,263),
    SPAWN2(226,263),
    SPAWN3(424, 267),
    SPAWN4(651, 272);




    private int xPoint;
    private int yPoint;

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
}
