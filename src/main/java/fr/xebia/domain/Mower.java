package fr.xebia.domain;

import java.util.List;

public class Mower {

    private int id;

    private Position position;

    private Direction direction;

    private Lawn lawn;

    private List<Order> orders;

    public Mower(int id, Position position, Direction direction, Lawn lawn, List<Order> orders) {
        this.id = id;
        this.position = position;
        this.direction = direction;
        this.lawn = lawn;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Lawn getLawn() {
        return lawn;
    }

    public void setLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
