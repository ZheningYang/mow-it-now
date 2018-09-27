package fr.xebia.util;

import org.junit.Assert;
import org.junit.Test;

public class TestFileReaderUtil {

    @Test(expected = NullPointerException.class)
    public void shouldThrowNPE() throws RuntimeException {
        FileReaderUtil.readStringFromFile("unknown-path");
    }

    @Test
    public void shouldReadTextFromFile () {
        String result = FileReaderUtil.readStringFromFile("/fr/xebia/test");
        Assert.assertEquals(result, "THis iS A tEst\n");
    }
}
