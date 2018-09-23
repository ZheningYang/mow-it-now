package fr.xebia.domain;

public enum Orientation {
    N("N"),
    E("E"),
    W("W"),
    S("S");

    private final String orientation;

    Orientation(String str) {
        orientation = str;
    }

    public boolean equalsOrientation(String otherOrientation) {
        return orientation.equals(otherOrientation);
    }

    @Override
    public String toString() {
        return this.orientation;
    }
}
