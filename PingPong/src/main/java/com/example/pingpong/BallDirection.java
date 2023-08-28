package com.example.pingpong;

public enum BallDirection {
    TOP_LEFT(1),
    TOP_RIGHT(2),
    BOTTOM_LEFT(3),
    BOTTOM_RIGHT(4);

    private final int ordinalNumber;

    BallDirection(int ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    public int getOrdinalNumber() {
        return ordinalNumber;
    }

    public static BallDirection getByNumber(int ordinalNumber){
        for (BallDirection dir:BallDirection.values()){
            if (dir.getOrdinalNumber()==ordinalNumber) return dir;
        }
        throw new IllegalArgumentException("Invalid ordinal number" + ordinalNumber);
    }
}
