package fr.xebia.service;

import fr.xebia.domain.Mower;
import fr.xebia.domain.Order;

import java.util.List;

/**
 * The interface Mow service.
 */
public interface MowService {

    /**
     * Init mowers list.
     *
     * @param instructionPath the instruction path
     * @return the list
     */
    List<Mower> initMowers(String instructionPath);

    /**
     * Follow instruction.
     *
     * @param mower the mower
     */
    void followInstruction(Mower mower);

}
