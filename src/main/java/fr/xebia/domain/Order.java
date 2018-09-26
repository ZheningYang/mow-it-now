package fr.xebia.domain;

public enum Order {

    D(90, "Right"),
    G(-90, "Left"),
    A(0, "Forward");

    private final int degrees;

    private final String order;

    Order(int degrees, String order) {
        this.degrees = degrees;
        this.order = order;
    }

    public int getDegrees() {
        return degrees;
    }

    public String getOrder() {
        return order;
    }
}
