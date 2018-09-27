package fr.xebia.service.impl;

import fr.xebia.domain.*;
import fr.xebia.service.MowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static fr.xebia.util.FileReaderUtil.readStringFromFile;

public class MowServiceImpl implements MowService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MowServiceImpl.class);

    @Override
    public List<Mower> initMowers(String instructionPath) {
        LOGGER.info("Start reading instructions for mowers");
        String instruction = readStringFromFile(instructionPath);
        String[] instructions = instruction.split("\n");
        LOGGER.info("Retrieving lawn information...");
        String[] lawnInfo = instructions[0].split(" ");

        LOGGER.info("Creating lawn...");
        Lawn lawn = new Lawn(Integer.valueOf(lawnInfo[0]), Integer.valueOf(lawnInfo[1]));

        List<Mower> mowers = new ArrayList<>();

        int nbMowers = (instructions.length - 1) / 2;

        for (int i = 1; i <= nbMowers * 2; i += 2) {
            LOGGER.info("Retrieving mower n° {} information...", i/2);
            String[] MowerInfo = instructions[i].split(" ");
            LOGGER.info("Creating mower init position...");
            Position position = new Position(Integer.valueOf(MowerInfo[0]), Integer.valueOf(MowerInfo[1]));

            LOGGER.info("Creating mower orders...");
            List<Character> orderInfo = instructions[i + 1].chars().mapToObj(e -> (char) e).collect(Collectors.toList());
            List<Order> orders = new ArrayList<>();
            for (Character c : orderInfo) {
                orders.add(Order.valueOf(c.toString()));
            }
            mowers.add(new Mower(i / 2, position, Direction.valueOf(MowerInfo[2]), lawn, orders));
        }

        return mowers;
    }

    public void followInstruction(Mower mower) {

        for (Order order : mower.getOrders()) {
            if (order.equals(Order.A)) {
                forward(mower);
            } else {
                turn(mower, order);
            }
        }

    }

    private void forward(Mower mower) {
        Position position = mower.getPosition();
        switch (mower.getDirection()) {
            case N:
                position.headNorth();
                break;
            case E:
                position.headEast();
                break;
            case S:
                position.headSouth();
                break;
            case W:
                position.headWest();
                break;
            default:
                break;
        }

        if (position.isValidPosition(mower.getLawn())) {
            mower.setPosition(position);
        }
    }

    private void turn(Mower mower, Order order) {
        int index = (mower.getDirection().getIndex() + order.getIndex()) % 4;
        index = index < 0 ? index + 4 : index;
        Direction direction = Direction.values()[index];
        mower.setDirection(direction);
    }
}
