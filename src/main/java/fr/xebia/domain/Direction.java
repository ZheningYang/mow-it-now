package fr.xebia.domain;

/**
 * The enum Direction.
 */
public enum Direction {
    /**
     * directions: north, east, south, west.
     */
    N(0, "North"),
    E(1, "East"),
    S(2, "South"),
    W(3, "West");

    private final int index;
    private final String label;

    Direction(int index, String label) {
        this.index = index;
        this.label = label;
    }

    public int getIndex() {
        return index;
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
