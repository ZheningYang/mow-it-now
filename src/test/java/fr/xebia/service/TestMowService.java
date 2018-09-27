package fr.xebia.service;

import fr.xebia.domain.Direction;
import fr.xebia.domain.Mower;
import fr.xebia.service.impl.MowServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestMowService {

    private MowService mowService;

    @Before
    public void setup() {
        mowService = new MowServiceImpl();
    }

    @Test
    public void shouldReadInstructionAndInitiateMowers() {

        String INSTRUCTION = "/fr/xebia/test.mow";

        List<Mower> mowers = mowService.initMowers(INSTRUCTION);

        Assert.assertEquals(mowers.size(), 2);
        Assert.assertEquals(mowers.get(0).getDirection(), Direction.N);
        Assert.assertEquals(mowers.get(1).getDirection(), Direction.E);

    }

    @Test
    public void shouldFollowInstruction() {

        String INSTRUCTION = "/fr/xebia/test.mow";

        List<Mower> mowers = mowService.initMowers(INSTRUCTION);

        Assert.assertEquals(mowers.get(0).toString(), "1 2 N");
        Assert.assertEquals(mowers.get(1).toString(), "3 3 E");

        mowers.forEach(mower -> mowService.followInstruction(mower));

        Assert.assertEquals(mowers.get(0).toString(), "1 3 N");
        Assert.assertEquals(mowers.get(1).toString(), "5 1 E");

    }
}
