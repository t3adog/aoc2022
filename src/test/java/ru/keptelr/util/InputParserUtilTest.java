package ru.keptelr.util;

import org.junit.Test;
import ru.keptelr.utils.InputParserUtil;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InputParserUtilTest {

    @Test
    public void testReadInputFile() {
        List<String> inputLines = InputParserUtil.readFile("demo");
        assertEquals(3, inputLines.size());
        assertEquals("one", inputLines.get(0));
        assertEquals("two", inputLines.get(1));
        assertEquals("three", inputLines.get(2));
    }
}
