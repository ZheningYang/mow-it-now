package fr.xebia.service;

import fr.xebia.domain.Mower;
import fr.xebia.domain.Order;

import java.util.List;

public interface MowService {

    List<Mower> initMowers(String instructionPath);

    void followInstruction(Mower mower);

}
