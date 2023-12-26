package com.green.projectg3.common.Exception;

public enum Cody {
    YES(1), NO(0), NODATA(-1), DUPLICATE(-2), NULL_VALUE(-3), ALIEN_CODE(-99);

    private final int value;

    Cody(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
