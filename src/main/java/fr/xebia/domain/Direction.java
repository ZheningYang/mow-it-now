package fr.xebia.domain;

/**
 * The enum Direction.
 */
public enum Direction {
    /**
     * directions: north, east, south, west.
     */
    N(0, "North"),
    E(90, "East"),
    S(180, "South"),
    W(270, "West");

    private final int degrees;
    private final String label;

    Direction(int degrees, String label) {
        this.degrees = degrees;
        this.label = label;
    }

    /**
     * Gets degrees.
     *
     * @return the degrees
     */
    public int getDegrees() {
        return degrees;
    }

    /**
     * Gets label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }
}
