package graphics;

public enum Positions {

    //Front
    SPAWN1(56, 270),
    SPAWN2(226, 270),
    SPAWN3(424, 272),
    SPAWN4(651, 272),

    //Middle
    SPAWN5(63, 218),
    SPAWN6(184, 219),
    SPAWN7(310, 220),
    SPAWN8(440, 220),
    SPAWN9(568, 220),
    SPAWN10(685, 218);


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

}
