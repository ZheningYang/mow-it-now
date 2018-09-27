package fr.xebia.domain;

public enum Order {

    D(1, "Right"),
    G(-1, "Left"),
    A(0, "Forward");

    private final int index;

    private final String order;

    Order(int index, String order) {
        this.index = index;
        this.order = order;
    }

    public int getIndex() {
        return index;
    }

    public String getOrder() {
        return order;
    }
}
